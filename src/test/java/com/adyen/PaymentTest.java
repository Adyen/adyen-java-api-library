package com.adyen;

import com.adyen.constants.ApiConstants.AdditionalData;
import com.adyen.constants.ApiConstants.RefusalReason;
import com.adyen.model.PaymentRequest;
import com.adyen.model.PaymentRequest3d;
import com.adyen.model.PaymentResult;
import com.adyen.service.Payment;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import static org.junit.Assert.*;

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
}
