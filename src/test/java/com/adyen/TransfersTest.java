package com.adyen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import com.adyen.constants.ApiConstants;
import com.adyen.enums.Environment;
import com.adyen.model.transfers.*;
import com.adyen.service.transfers.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class TransfersTest extends BaseTest {

  @Test
  public void baseUrlOnTest() throws NoSuchFieldException, IllegalAccessException {
    Client client = new Client(new Config()
            .apiKey("test")
            .environment(Environment.TEST));

    TransfersApi transfersApi = new TransfersApi(client);
    // get field by reflection (it is protected)
    Field baseURLField = TransfersApi.class.getDeclaredField("baseURL");
    baseURLField.setAccessible(true);
    String baseURL = (String) baseURLField.get(transfersApi);
    assertEquals("https://balanceplatform-api-test.adyen.com/btl/v4", baseURL);
  }

  @Test
  public void baseUrlOnLive() throws NoSuchFieldException, IllegalAccessException {
    Client client = new Client(new Config()
            .apiKey("test")
            .environment(Environment.LIVE));

    TransfersApi transfersApi = new TransfersApi(client);
    // get field by reflection (it is protected)
    Field baseURLField = TransfersApi.class.getDeclaredField("baseURL");
    baseURLField.setAccessible(true);
    String baseURL = (String) baseURLField.get(transfersApi);
    assertEquals("https://balanceplatform-api-live.adyen.com/btl/v4", baseURL);
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
  public void TransactionsListTest() throws Exception {
    Client client = createMockClientFromFile("mocks/transfers/get-transactions-success-200.json");
    TransactionsApi transactions = new TransactionsApi(client);
    TransactionSearchResponse response = transactions.getAllTransactions(null, null);
    Transaction transactionsResponse = response.getData().get(1);
    assertEquals("AH00000000000000000000001", transactionsResponse.getAccountHolder().getId());
    assertEquals("BA00000000000000000000001", transactionsResponse.getBalanceAccount().getId());
    assertEquals(Transaction.StatusEnum.BOOKED, transactionsResponse.getStatus());
  }

  @Test
  public void TransactionsRetrieveTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/transfers/get-transactions-id-success-200.json");
    TransactionsApi transactions = new TransactionsApi(client);
    Transaction response = transactions.getTransaction("1");
    assertEquals("EVJN4227C224222B5JBDHPTD672M52EUR", response.getId());
    assertEquals("AH00000000000000000000001", response.getAccountHolder().getId());
    assertEquals("48TYZO5ZVURJ2FCW", response.getTransfer().getId());
  }

}
