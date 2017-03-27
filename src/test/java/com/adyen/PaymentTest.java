package com.adyen;

import com.adyen.constants.ApiConstants.AdditionalData;
import com.adyen.constants.ApiConstants.RefusalReason;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.httpclient.HttpURLConnectionClient;
import com.adyen.model.FraudCheckResult;
import com.adyen.model.PaymentRequest;
import com.adyen.model.PaymentRequest3d;
import com.adyen.model.PaymentResult;
import com.adyen.service.Payment;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests for /authorise and /authorise3d
 */
public class PaymentTest extends BaseTest {
    /**
     * Test success flow for
     * POST /authorise
     */
    @Test
    public void TestAuthoriseSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/authorise-success.json");
        Payment payment = new Payment(client);

        PaymentRequest paymentRequest = createFullCardPaymentRequest();

        PaymentResult paymentResult = payment.authorise(paymentRequest);

        assertTrue(paymentResult.isAuthorised());

        SimpleDateFormat format = new SimpleDateFormat("M/yyyy");
        assertEquals("8/2018", format.format(paymentResult.getExpiryDate()));

        assertEquals("411111", paymentResult.getCardBin());
        assertEquals("1111", paymentResult.getCardSummary());
        assertEquals("Holder", paymentResult.getCardHolderName());
        assertTrue(paymentResult.get3DOffered());
        assertFalse(paymentResult.get3DAuthenticated());
        assertEquals("69746", paymentResult.getAuthCode());

        assertEquals(11, paymentResult.getFraudResult().getFraudCheckResults().size());

        FraudCheckResult fraudCheckResult = paymentResult.getFraudResult().getFraudCheckResults().get(0);
        assertEquals("CardChunkUsage", fraudCheckResult.getName());
        assertEquals(8, fraudCheckResult.getAccountScore().intValue());
        assertEquals(2, fraudCheckResult.getCheckId().intValue());
    }

    /**
     * Test error flow 010 for
     * POST /authorise
     */
    @Test
    public void TestAuthoriseError010Mocked() throws Exception {
        Client client = createMockClientForErrors(403, "mocks/authorise-error-010.json");
        Payment payment = new Payment(client);

        PaymentRequest paymentRequest = createFullCardPaymentRequest();

        try {
            PaymentResult paymentResult = payment.authorise(paymentRequest);
            assertTrue("Exception expected", false);
        } catch (ApiException e) {
            String errorCode = e.getError().getErrorCode();
            assertEquals("010", errorCode);

            int status = e.getError().getStatus();
            assertEquals(403, status);
        }
    }

    /**
     * Test error flow with wrong CVC for
     * POST /authorise
     */
    @Test
    public void TestAuthoriseErrorCVCDeclinedMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/authorise-error-cvc-declined.json");
        Payment payment = new Payment(client);

        PaymentRequest paymentRequest = createFullCardPaymentRequest();

        PaymentResult paymentResult = payment.authorise(paymentRequest);

        assertTrue(paymentResult.isRefused());
    }

    /**
     * Test success flow with 3D secured CC for
     * POST /authorise
     */
    @Test
    public void TestAuthoriseSuccess3DMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/authorise-success-3d.json");
        Payment payment = new Payment(client);

        PaymentRequest paymentRequest = createFullCardPaymentRequest();

        PaymentResult paymentResult = payment.authorise(paymentRequest);

        assertTrue(paymentResult.isRedirectShopper());
        assertNotNull(paymentResult.getMd());
        assertNotNull(paymentResult.getIssuerUrl());
        assertNotNull(paymentResult.getPaRequest());
    }

    /**
     * Test success flow for
     * POST /authorise3d
     */
    @Test
    public void TestAuthorise3DSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/authorise3d-success.json");
        Payment payment = new Payment(client);

        PaymentRequest3d paymentRequest3d = create3DPaymentRequest();

        PaymentResult paymentResult = payment.authorise3D(paymentRequest3d);

        assertTrue(paymentResult.isAuthorised());
        assertNotNull(paymentResult.getPspReference());
    }

    /**
     * Test success flow (CSE) for
     * POST /authorise
     */
    @Test
    public void TestAuthoriseCSESuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/authorise-success-cse.json");
        Payment payment = new Payment(client);

        PaymentRequest paymentRequest = createCSEPaymentRequest();

        PaymentResult paymentResult = payment.authorise(paymentRequest);

        assertTrue(paymentResult.isAuthorised());
    }

    /**
     * Test flow (CSE) expired card for
     * POST /authorise
     */
    @Test
    public void TestAuthoriseCSEErrorExpiredMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/authorise-error-expired.json");
        Payment payment = new Payment(client);

        PaymentRequest paymentRequest = createCSEPaymentRequest();

        PaymentResult paymentResult = payment.authorise(paymentRequest);

        assertTrue(paymentResult.isRefused());
        assertEquals(RefusalReason.REFUSED, paymentResult.getRefusalReason());
        assertEquals("DECLINED Expiry Incorrect", paymentResult.getAdditionalData().get(AdditionalData.REFUSAL_REASON_RAW));
    }

    /**
     * Test error 401 (Not authorized)
     */
    @Test
    public void TestError401Mocked() throws Exception {
        HttpURLConnectionClient httpURLConnectionClient = mock(HttpURLConnectionClient.class);
        HTTPClientException httpClientException = new HTTPClientException(
                401,
                "An error occured",
                new HashMap<String, List<String>>(),
                null);

        when(httpURLConnectionClient.
                request(any(String.class), any(String.class), any(Config.class))).
                thenThrow(httpClientException);

        Client client = new Client();
        client.setHttpClient(httpURLConnectionClient);

        Payment payment = new Payment(client);

        PaymentRequest paymentRequest = createFullCardPaymentRequest();

        try {
            PaymentResult paymentResult = payment.authorise(paymentRequest);
            assertTrue("Exception expected", false);
        } catch (ApiException e) {
            assertEquals(401, e.getStatusCode());
            assertNull(e.getError());
        }
    }

    /**
     * Test OpenInvoice API flow for klarna
     *
     * @throws Exception
     */
    @Test
    public void TestOpenInvoice() throws Exception {

        Client client = createMockClientFromFile("mocks/authorise-success-klarna.json");
        Payment payment = new Payment(client);

        PaymentRequest paymentRequest = this.createOpenInvoicePaymentRequest();
        PaymentResult paymentResult = payment.authorise(paymentRequest);
        assertEquals("2374421290", paymentResult.getAdditionalData().get("additionalData.acquirerReference"));
        assertEquals("klarna", paymentResult.getAdditionalData().get("paymentMethodVariant"));
        assertTrue(paymentResult.isAuthorised());
    }
}
