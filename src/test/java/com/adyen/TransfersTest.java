package com.adyen;

import com.adyen.constants.ApiConstants;
import com.adyen.model.transfers.*;
import com.adyen.service.transfers.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.HashMap;

public class TransfersTest extends BaseTest {

    @Test
    public void TransferTest() throws Exception {
        Client client = createMockClientFromFile("mocks/transfers/post-transfers-payout-cross-border-200.json");
        TransfersApi transfers = new TransfersApi(client);
        Transfer response = transfers.transferFunds(new TransferInfo());
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
        TransactionsApi transactions = new TransactionsApi(client);
        TransactionSearchResponse response = transactions.getAllTransactions(null, null);
        TransactionData transactionsResponse = response.getData().get(1);
        assertEquals(transactionsResponse.getAccountHolderId(), "AHA1B2C3D4E5F6G7H8I9J0");
        assertEquals(transactionsResponse.getCounterparty().getBalanceAccountId(), "BAB8B2C3D4E5F6G7H8D9J6GD4");
        assertEquals(transactionsResponse.getBalancePlatform(), "YOUR_BALANCE_PLATFORM");
    }

    @Test
    public void TransactionsRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/transfers/get-transactions-id-success-200.json");
        TransactionsApi transactions = new TransactionsApi(client);
        TransactionData response = transactions.getTransaction("1");
        assertEquals(response.getAccountHolderId(), "AHA1B2C3D4E5F6G7H8I9J0");
        assertEquals(response.getBalancePlatform(), "YOUR_BALANCE_PLATFORM");
        assertEquals(response.getTransferId(), "2QP32A5U7IWC5WKG");
    }

     @Test
    public void TestGetCapitalAccounts() throws Exception {
        Client client = createMockClientFromFile("mocks/capital/get-capital-account.json");
        CapitalApi capital = new CapitalApi(client);
        CapitalGrants response = capital.getCapitalAccount();
        assertEquals(response.getGrants().get(0).getGrantOfferId(), "string");
        verify(client.getHttpClient()).request(
                "https://balanceplatform-api-test.adyen.com/btl/v3/grants",
                null,
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.GET,
                new HashMap<>()
        );
    }

    @Test
    public void TestRequestGrant() throws Exception {
        Client client = createMockClientFromFile("mocks/capital/request-grant.json");
        CapitalApi capital = new CapitalApi(client);
        CapitalGrant response = capital.requestGrantPayout(new CapitalGrantInfo());
        assertEquals(response.getGrantAccountId(), "CG00000000000000000000001");
        verify(client.getHttpClient()).request(
                "https://balanceplatform-api-test.adyen.com/btl/v3/grants",
                "{}",
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.POST,
                null
        );
    }
}
