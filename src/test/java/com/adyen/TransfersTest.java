package com.adyen;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
  public void ApproveInitiatedTransfersTest() throws Exception {
    Client client = createMockClientFromResponse("");
    TransfersApi transfers = new TransfersApi(client);
    ApproveTransfersRequest approveTransfersRequest = new ApproveTransfersRequest();
    approveTransfersRequest.setTransferIds(Arrays.asList("APUFHASUDF4AS", "407ASFPUAHSFA"));
    transfers.approveInitiatedTransfers(approveTransfersRequest);
  }

  @Test
  public void GetAllTransfersTest() throws Exception {
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
  public void GetTransferTest() throws Exception {
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
  }

  @Test
  public void TransferTest() throws Exception {
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
  public void GetAllTransactionsTest() throws Exception {
    Client client = createMockClientFromFile("mocks/transfers/get-transactions-success-200.json");
    TransactionsApi transactions = new TransactionsApi(client);
    TransactionSearchResponse response = transactions.getAllTransactions(null, null);
    Transaction transactionsResponse = response.getData().get(1);
    assertEquals("AH00000000000000000000001", transactionsResponse.getAccountHolder().getId());
    assertEquals("BA00000000000000000000001", transactionsResponse.getBalanceAccount().getId());
    assertEquals(Transaction.StatusEnum.BOOKED, transactionsResponse.getStatus());
  }

  @Test
  public void GetTransactionTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/transfers/get-transactions-id-success-200.json");
    TransactionsApi transactions = new TransactionsApi(client);
    Transaction response = transactions.getTransaction("1");
    assertEquals("EVJN4227C224222B5JBDHPTD672M52EUR", response.getId());
    assertEquals("AH00000000000000000000001", response.getAccountHolder().getId());
    assertEquals("48TYZO5ZVURJ2FCW", response.getTransfer().getId());
  }
}
