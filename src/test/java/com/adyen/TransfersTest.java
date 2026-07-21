package com.adyen;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import com.adyen.constants.ApiConstants;
import com.adyen.enums.Environment;
import com.adyen.model.transfers.*;
import com.adyen.service.transfers.*;
import java.lang.reflect.Field;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class TransfersTest extends BaseTest {

  @Test
  public void baseUrlOnTest() throws NoSuchFieldException, IllegalAccessException {
    Client client = new Client(new Config().apiKey("test").environment(Environment.TEST));

    TransfersApi transfersApi = new TransfersApi(client);
    // get field by reflection (it is protected)
    Field baseURLField = TransfersApi.class.getDeclaredField("baseURL");
    baseURLField.setAccessible(true);
    String baseURL = (String) baseURLField.get(transfersApi);
    assertEquals(
        String.format(
            "https://balanceplatform-api-test.adyen.com/btl/v%s", TransfersApi.API_VERSION),
        baseURL);
  }

  @Test
  public void baseUrlOnLive() throws NoSuchFieldException, IllegalAccessException {
    Client client = new Client(new Config().apiKey("test").environment(Environment.LIVE));

    TransfersApi transfersApi = new TransfersApi(client);
    // get field by reflection (it is protected)
    Field baseURLField = TransfersApi.class.getDeclaredField("baseURL");
    baseURLField.setAccessible(true);
    String baseURL = (String) baseURLField.get(transfersApi);
    assertEquals(
        String.format(
            "https://balanceplatform-api-live.adyen.com/btl/v%s", TransfersApi.API_VERSION),
        baseURL);
  }

  @Test
  public void approveInitiatedTransfersTest() throws Exception {
    Client client = createMockClientFromResponse("");
    TransfersApi transfers = new TransfersApi(client);
    ApproveTransfersRequest approveTransfersRequest = new ApproveTransfersRequest();
    approveTransfersRequest.setTransferIds(Arrays.asList("APUFHASUDF4AS", "407ASFPUAHSFA"));
    transfers.approveInitiatedTransfers(approveTransfersRequest);
  }

  @Test
  public void getAllTransfersTest() throws Exception {
    Client client = createMockClientFromFile("mocks/transfers/get-all-transfers-success.json");
    TransfersApi transfers = new TransfersApi(client);
    FindTransfersResponse response =
        transfers.getAllTransfers(OffsetDateTime.now(), OffsetDateTime.now());
    assertEquals(2, response.getData().size());
    TransferData transfer1 = response.getData().get(0);
    assertEquals("1W1UG35QQEBJLHZ8", transfer1.getId());
    assertEquals("YOUR_BALANCE_PLATFORM", transfer1.getBalancePlatform());
    assertEquals(5400L, transfer1.getAmount().getValue());
    assertEquals("EUR", transfer1.getAmount().getCurrency());

    TransferData transfer2 = response.getData().get(1);
    assertEquals("312M2060T5Z3YWYQ", transfer2.getId());
    assertEquals(15000L, transfer2.getAmount().getValue());
  }

  @Test
  public void getTransferTest() throws Exception {
    Client client = createMockClientFromFile("mocks/transfers/get-transfer-success.json");

    TransfersApi transfers = new TransfersApi(client);
    TransferData response = transfers.getTransfer("1W1UG35QQEBJLHZ8");

    assertEquals("1W1UG35QQEBJLHZ8", response.getId());
    assertEquals("YOUR_BALANCE_PLATFORM", response.getBalancePlatform());
    assertEquals(5400L, response.getAmount().getValue());
    assertEquals("EUR", response.getAmount().getCurrency());
    assertEquals("AH32272223222B5CZW6QZ2V34", response.getAccountHolder().getId());
    assertEquals("BA3227C223222B5B9SCR82TMV", response.getBalanceAccount().getId());

    // check events and eventsData
    assertNotNull(response.getEvents());
    assertNotNull(response.getEvents().get(0));
    assertNotNull(response.getEvents().get(0).getEventsData());
    assertEquals(1, response.getEvents().get(0).getEventsData().size());
    assertNotNull(response.getEvents().get(0).getEventsData().get(0));
    assertInstanceOf(
        InterchangeData.class,
        response.getEvents().get(0).getEventsData().get(0).getActualInstance());

    // check networkReason and tracing (new TransferData fields)
    assertEquals(
        new NetworkReason()
            .code("R01")
            .description("Insufficient funds")
            .namespace(NetworkReason.NamespaceEnum.USACHRETURNREASONCODE),
        response.getNetworkReason());
    assertNotNull(response.getTracing());
    assertInstanceOf(USAchTracingData.class, response.getTracing().getActualInstance());
    USAchTracingData tracing = response.getTracing().getUSAchTracingData();
    assertEquals("091000010000001", tracing.getTraceNumber());
    assertEquals(USAchTracingData.TypeEnum.USACH, tracing.getType());

    // check tracingData (new TransferEvent field)
    TransferEventTracingData eventTracingData = response.getEvents().get(0).getTracingData();
    assertNotNull(eventTracingData);
    assertInstanceOf(UKFpsTracingData.class, eventTracingData.getActualInstance());
    UKFpsTracingData eventTracing = eventTracingData.getUKFpsTracingData();
    assertEquals("FP123456789", eventTracing.getFpid());
    assertEquals(UKFpsTracingData.TypeEnum.UKFPS, eventTracing.getType());
  }

  @Test
  public void transferTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/transfers/post-transfers-payout-cross-border-200.json");

    TransfersApi transfers = new TransfersApi(client);
    Transfer response = transfers.transferFunds(new TransferInfo());

    Amount amount = new Amount();
    amount.setCurrency("EUR");
    amount.setValue(110000L);
    assertEquals(amount, response.getAmount());
    assertEquals("BAB8B2C3D4E5F6G7H8D9J6GD4", response.getBalanceAccount().getId());
    assertEquals("1W1UG35U8A9J5ZLG", response.getId());
  }

  @Test
  public void initiateCashoutTest() throws Exception {
    Client client = createMockClientFromFile("mocks/transfers/post-cashouts-200.json");
    CashOutApi cashOut = new CashOutApi(client);

    CashOutInfo cashOutInfo =
        new CashOutInfo()
            .instructingBalanceAccountId("BA00000000000000000000001")
            .amount(new Amount().currency("EUR").value(50000L));

    CashOut response = cashOut.initiateCashout(cashOutInfo);

    assertEquals("CO00000000000000000000001", response.getId());
    assertEquals("BA00000000000000000000001", response.getInstructingBalanceAccountId());
    assertEquals(new Amount().currency("EUR").value(50000L), response.getAmount());
    assertEquals(
        new CashOutInfoCounterparty().transferInstrumentId("SE00000000000000000000001"),
        response.getCounterparty());
    assertEquals("Cashout to bank account", response.getDescription());
    assertEquals("CASHOUT-REF-001", response.getReferenceForBeneficiary());
    assertEquals(new Fee().amount(new Amount().currency("EUR").value(500L)), response.getFee());

    assertEquals(2, response.getTransfers().size());
    assertEquals(
        new CashOutTransfer()
            .id("400F6060JMB1I0AB")
            .type(CashOutTransfer.TypeEnum.CASHOUTREPAYMENT)
            .amount(new Amount().currency("EUR").value(50500L)),
        response.getTransfers().get(0));
    assertEquals(
        new CashOutTransfer()
            .id("400F6060JMB1I0AA")
            .type(CashOutTransfer.TypeEnum.CASHOUTFEE)
            .amount(new Amount().currency("EUR").value(500L)),
        response.getTransfers().get(1));

    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/btl/v4/cashouts",
            cashOutInfo.toJson(),
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void defaultErrorResponseEntityTest() throws Exception {
    String json =
        "{\"type\":\"https://docs.adyen.com/errors/forbidden\",\"title\":\"Forbidden\","
            + "\"status\":403,\"detail\":\"Insufficient permissions\",\"errorCode\":\"00_401\","
            + "\"instance\":\"/cashouts\",\"requestId\":\"REQ123\"}";
    DefaultErrorResponseEntity error = DefaultErrorResponseEntity.fromJson(json);

    assertEquals("https://docs.adyen.com/errors/forbidden", error.getType());
    assertEquals("Forbidden", error.getTitle());
    assertEquals(Integer.valueOf(403), error.getStatus());
    assertEquals("Insufficient permissions", error.getDetail());
    assertEquals("00_401", error.getErrorCode());
    assertEquals("/cashouts", error.getInstance());
    assertEquals("REQ123", error.getRequestId());
  }

  @Test
  public void getAllTransactionsTest() throws Exception {
    Client client = createMockClientFromFile("mocks/transfers/get-transactions-success-200.json");
    TransactionsApi transactions = new TransactionsApi(client);
    TransactionSearchResponse response = transactions.getAllTransactions(null, null);
    Transaction transactionsResponse = response.getData().get(1);
    assertEquals("AH00000000000000000000001", transactionsResponse.getAccountHolder().getId());
    assertEquals("BA00000000000000000000001", transactionsResponse.getBalanceAccount().getId());
    assertEquals(Transaction.StatusEnum.BOOKED, transactionsResponse.getStatus());
  }

  @Test
  public void getTransactionTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/transfers/get-transactions-id-success-200.json");
    TransactionsApi transactions = new TransactionsApi(client);
    Transaction response = transactions.getTransaction("1");
    assertEquals("EVJN4227C224222B5JBDHPTD672M52EUR", response.getId());
    assertEquals("AH00000000000000000000001", response.getAccountHolder().getId());
    assertEquals("48TYZO5ZVURJ2FCW", response.getTransfer().getId());
  }
}
