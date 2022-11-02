package com.adyen;

import com.adyen.model.transfer.*;
import com.adyen.service.Transfers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransfersTest extends BaseTest {

    @Test
    public void TransferTest() throws Exception {
        Client client = createMockClientFromFile("mocks/transfers/post-transfers-payout-cross-border-200.json");
        Transfers transfers = new Transfers(client);
        Transfer response = transfers.transfers(new TransferInfo());
        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(80000L);
        assertEquals(response.getAmount(), amount);
        assertEquals(response.getBalanceAccountId(), "BAB8B2C3D4E5F6G7H8D9J6GD4");
        assertEquals(response.getPriority(), Transfer.PriorityEnum.REGULAR);
    }

    @Test
    public void TransactionsListTest() throws Exception {
        Client client = createMockClientFromFile("mocks/transfers/get-transactions-success-200.json");
        Transfers transactions = new Transfers(client);
        TransactionSearchResponse response = transactions.listTransactions();
        Transaction transactionsResponse = response.getData().get(1);
        assertEquals(transactionsResponse.getAccountHolderId(), "AHA1B2C3D4E5F6G7H8I9J0");
        assertEquals(transactionsResponse.getCounterparty().getBalanceAccountId(), "BAB8B2C3D4E5F6G7H8D9J6GD4");
        assertEquals(transactionsResponse.getBalancePlatform(), "YOUR_BALANCE_PLATFORM");
    }

    @Test
    public void TransactionsRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/transfers/get-transactions-id-success-200.json");
        Transfers transactions = new Transfers(client);
        Transaction response = transactions.getTransaction("1");
        assertEquals(response.getAccountHolderId(), "AHA1B2C3D4E5F6G7H8I9J0");
        assertEquals(response.getBalancePlatform(), "YOUR_BALANCE_PLATFORM");
        assertEquals(response.getTransferId(), "2QP32A5U7IWC5WKG");
    }
}
