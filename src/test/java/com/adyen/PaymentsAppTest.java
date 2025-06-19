package com.adyen;

import com.adyen.model.RequestOptions;
import com.adyen.model.paymentsapp.BoardingTokenRequest;
import com.adyen.model.paymentsapp.BoardingTokenResponse;
import com.adyen.model.paymentsapp.PaymentsAppResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.paymentsapp.PaymentsAppApi;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PaymentsAppTest extends BaseTest {

    @Test
    public void testGeneratePaymentsAppBoardingTokenForMerchantSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/paymentsapp/boardingToken-success.json");
        PaymentsAppApi paymentsAppApi = new PaymentsAppApi(client);

        BoardingTokenResponse response = paymentsAppApi.
                generatePaymentsAppBoardingTokenForMerchant("MerchantAccount123", new BoardingTokenRequest()
                        .boardingRequestToken("mockedRequestToken"));

        assertNotNull(response);
        assertEquals("eyJhYmMxMjMiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c", response.getBoardingToken());
        assertEquals("mockedInstallationId", response.getInstallationId());
    }

    @Test
    public void testGeneratePaymentsAppBoardingTokenForMerchantError() throws Exception {
        Client client = createMockClientForErrors(403, "mocks/paymentsapp/boardingToken-error-403.json");
        PaymentsAppApi paymentsAppApi = new PaymentsAppApi(client);

        try {
            paymentsAppApi.
                    generatePaymentsAppBoardingTokenForMerchant("MerchantAccount123", new BoardingTokenRequest()
                            .boardingRequestToken("mockedRequestToken"));
            fail("ApiException expected");
        } catch (ApiException e) {
            assertEquals(403, e.getStatusCode());
            assertNotNull(e.getResponseBody());
            assertTrue(e.getResponseBody().contains("PA001"));
        }
    }

    @Test
    public void testGeneratePaymentsAppBoardingTokenForStoreSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/paymentsapp/boardingToken-success.json");
        PaymentsAppApi paymentsAppApi = new PaymentsAppApi(client);

        BoardingTokenResponse response = paymentsAppApi.
                generatePaymentsAppBoardingTokenForStore("MerchantAccount123", "StoreEU",  new BoardingTokenRequest()
                        .boardingRequestToken("mockedRequestToken"));

        assertNotNull(response);
        assertEquals("eyJhYmMxMjMiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c", response.getBoardingToken());
        assertEquals("mockedInstallationId", response.getInstallationId());

    }

    @Test
    public void testGeneratePaymentsAppBoardingTokenForStoreError() throws Exception {
        Client client = createMockClientForErrors(403, "mocks/paymentsapp/boardingToken-error-403.json");
        PaymentsAppApi paymentsAppApi = new PaymentsAppApi(client);

        try {
            paymentsAppApi.
                    generatePaymentsAppBoardingTokenForStore("MerchantAccount123", "StoreEU",  new BoardingTokenRequest()
                            .boardingRequestToken("mockedRequestToken"));
            fail("ApiException expected");
        } catch (ApiException e) {
            assertEquals(403, e.getStatusCode());
            assertNotNull(e.getResponseBody());
            assertTrue(e.getResponseBody().contains("PA001"));
        }
    }

    @Test
    public void testListPaymentsAppForMerchantSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/paymentsapp/paymentsAppList-success.json");
        PaymentsAppApi paymentsAppApi = new PaymentsAppApi(client);

        PaymentsAppResponse response = paymentsAppApi.listPaymentsAppForMerchant("MerchantAccount123");

        assertNotNull(response);
        assertNotNull(response.getPaymentsApps());
        assertEquals(2, response.getPaymentsApps().size());
    }

    @Test
    public void testListPaymentsAppForMerchantWithParamsSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/paymentsapp/paymentsAppList-success.json");
        PaymentsAppApi paymentsAppApi = new PaymentsAppApi(client);
        RequestOptions requestOptions = new RequestOptions();

        PaymentsAppResponse response = paymentsAppApi.listPaymentsAppForMerchant("MerchantAccount123", "BOARDED",
                10, 0L, requestOptions);

        assertNotNull(response);
        assertNotNull(response.getPaymentsApps());
        assertEquals(2, response.getPaymentsApps().size());
    }

    @Test
    public void testListPaymentsAppForMerchantError() throws Exception {
        Client client = createMockClientForErrors(500, "mocks/paymentsapp/paymentsAppList-error-500.json");
        PaymentsAppApi paymentsAppApi = new PaymentsAppApi(client);

        try {
            paymentsAppApi.listPaymentsAppForMerchant("MerchantAccount123");
            fail("ApiException expected");
        } catch (ApiException e) {
            assertEquals(500, e.getStatusCode());
            assertNotNull(e.getResponseBody());
            assertTrue(e.getResponseBody().contains("PA002"));
        }
    }

    @Test
    public void testListPaymentsAppForStoreSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/paymentsapp/paymentsAppList-success.json");
        PaymentsAppApi paymentsAppApi = new PaymentsAppApi(client);

        PaymentsAppResponse response = paymentsAppApi.listPaymentsAppForStore("MerchantAccount123", "StoreEU");

        assertNotNull(response);
        assertNotNull(response.getPaymentsApps());
        assertEquals(2, response.getPaymentsApps().size());
    }

    @Test
    public void testRevokePaymentsAppSuccess() throws Exception {
        Client client = createMockClientFromResponse("");
        PaymentsAppApi paymentsAppApi = new PaymentsAppApi(client);

        // This is a void method, so we just check that no exception is thrown.
        paymentsAppApi.revokePaymentsApp("MerchantAccount123", "StoreEU");
    }

}