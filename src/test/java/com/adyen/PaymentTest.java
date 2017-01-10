package com.adyen;

import com.adyen.constants.ApiConstants.AdditionalData;
import com.adyen.constants.ApiConstants.RefusalReason;
import com.adyen.model.PaymentRequest;
import com.adyen.model.PaymentRequest3d;
import com.adyen.model.PaymentResult;
import com.adyen.service.Payment;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Tests for /authorise and /authorise3d
 */
public class PaymentTest extends BaseTest {


    public Map<String, Object> doPaymentCall() {

        Client client = this.createClientFromConfigurations();


        // define parameters
        Map<String, Object> params = new HashMap<String, Object>();

        String merchantAccount = configurations.get("merchantAccount");
        String reference = "TEST-PAYMENT-2";


        Map<String, String> amount = new HashMap<String, String>();
        amount.put("currency", "EUR");
        amount.put("value", "100000"); // minor units!
        params.put("amount", amount);


        // reflection with dot in gson ? problem is then cse encryption

        Map<String, String> card = new HashMap<String, String>();
        card.put("expiryMonth", "08");
        card.put("expiryYear", "2018");
        card.put("holderName", "John Doe");
        card.put("number", "5136333333333335");
        card.put("cvc", "737");

        params.put("card", card);

        params.put("merchantAccount", merchantAccount);
        params.put("reference", reference);

        Payment paymentRequest = new Payment(client);

        try {
            Map<String, Object> result = paymentRequest.authorise(params);
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }


    @Test
    public void TestSuccessFulPaymentAuthorisation() {
        Map<String, Object> result = this.doPaymentCall();
        System.out.println(result);

//		Object pspReference = result.get("pspReference");
        String resultCode = result.get("resultCode").toString();

        assertEquals("Authorised", resultCode);
    }

    @Test
    public void TestSuccessFulPaymentAuthorisationJson() {

        Client client = this.createClientFromConfigurations();
        Payment paymentRequest = new Payment(client);

        String json = "{ " +
                "\"reference\": \"1000000\", " +
                "\"merchantAccount\": \"MagentoMerchantRik\", " +
                "\"amount\": { " +
                "\"currency\": \"EUR\"," +
                " \"value\": \"10000\" " +
                "}, " +
                "\"card\": { " +
                "\"expiryMonth\": \"08\"," +
                "\"expiryYear\": \"2018\"," +
                "\"holderName\": \"John Doe\"," +
                "\"number\": \"5136333333333335\"," +
                "\"cvc\": \"737\"" +
                "} " +
                "}";


        Map<String, Object> result = null;
        try {
            result = paymentRequest.authorise(json);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(result);


//		Object pspReference = result.get("pspReference");
        String resultCode = result.get("resultCode").toString();

        assertEquals("Authorised", resultCode);
    }

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
