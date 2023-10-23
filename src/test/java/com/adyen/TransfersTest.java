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
        amount.setValue(110000L);
        assertEquals(response.getAmount(), amount);
        assertEquals(response.getBalanceAccount().getId(), "BAB8B2C3D4E5F6G7H8D9J6GD4");
        assertEquals(response.getId(), "1W1UG35U8A9J5ZLG");
    }

    @Test
    public void TransactionsListTest() throws Exception {
        Client client = createMockClientFromFile("mocks/transfers/get-transactions-success-200.json");
        TransactionsApi transactions = new TransactionsApi(client);
        TransactionSearchResponse response = transactions.getAllTransactions(null, null);
        Transaction transactionsResponse = response.getData().get(1);
        assertEquals(transactionsResponse.getAccountHolder().getId(), "AH00000000000000000000001");
        assertEquals(transactionsResponse.getBalanceAccount().getId(), "BA00000000000000000000001");
        assertEquals(transactionsResponse.getStatus(), Transaction.StatusEnum.BOOKED);
    }

    @Test
    public void TransactionsRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/transfers/get-transactions-id-success-200.json");
        TransactionsApi transactions = new TransactionsApi(client);
        Transaction response = transactions.getTransaction("1");
        assertEquals(response.getId(), "EVJN4227C224222B5JBDHPTD672M52EUR");
        assertEquals(response.getAccountHolder().getId(), "AH00000000000000000000001");
        assertEquals(response.getTransfer().getId(), "48TYZO5ZVURJ2FCW");
    }

     @Test
    public void TestGetCapitalAccounts() throws Exception {
        Client client = createMockClientFromFile("mocks/capital/get-capital-account.json");
        CapitalApi capital = new CapitalApi(client);
        CapitalGrants response = capital.getCapitalAccount();
        assertEquals(response.getGrants().get(0).getGrantOfferId(), "string");
        verify(client.getHttpClient()).request(
                "https://balanceplatform-api-test.adyen.com/btl/v4/grants",
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
                "https://balanceplatform-api-test.adyen.com/btl/v4/grants",
                "{}",
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.POST,
                null
        );
    }
}
