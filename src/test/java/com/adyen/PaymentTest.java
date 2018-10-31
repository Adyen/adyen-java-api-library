/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.Test;
import com.adyen.constants.ApiConstants.AdditionalData;
import com.adyen.constants.ApiConstants.RefusalReason;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.httpclient.HttpURLConnectionClient;
import com.adyen.model.Address;
import com.adyen.model.FraudCheckResult;
import com.adyen.model.Name;
import com.adyen.model.PaymentRequest;
import com.adyen.model.PaymentRequest3d;
import com.adyen.model.PaymentResult;
import com.adyen.model.RequestOptions;
import com.adyen.service.Payment;
import com.adyen.service.exception.ApiException;
import static com.adyen.constants.ApiConstants.SelectedBrand.BOLETO_SANTANDER;
import static com.adyen.model.PaymentResult.ResultCodeEnum.RECEIVED;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.isNull;
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

        SimpleDateFormat format = new SimpleDateFormat("M/yyyy", Locale.ENGLISH);
        format.setTimeZone(TimeZone.getTimeZone("GMT"));

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
            payment.authorise(paymentRequest);
            fail("Exception expected");
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
        HTTPClientException httpClientException = new HTTPClientException(401, "An error occured", new HashMap<String, List<String>>(), null);

        when(httpURLConnectionClient.request(any(String.class), any(String.class), any(Config.class), anyBoolean(), any(RequestOptions.class))).thenThrow(httpClientException);
        when(httpURLConnectionClient.request(any(String.class), any(String.class), any(Config.class), anyBoolean(), (RequestOptions) isNull())).thenThrow(httpClientException);

        Client client = new Client();
        client.setHttpClient(httpURLConnectionClient);

        Payment payment = new Payment(client);

        PaymentRequest paymentRequest = createFullCardPaymentRequest();

        try {
            payment.authorise(paymentRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertTrue(e.toString().contains("401"));
            assertEquals(401, e.getStatusCode());
            assertNull(e.getError());
        }
    }

    /**
     * Test OpenInvoice API flow for klarna
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

    @Test
    public void TestBoletoSuccess() throws Exception {

        Client client = createMockClientFromFile("mocks/authorise-success-boleto.json");
        Payment payment = new Payment(client);

        Address billingAddress = new Address();
        billingAddress.setCity("São Paulo");
        billingAddress.setCountry("BR");
        billingAddress.setHouseNumberOrName("999");
        billingAddress.setPostalCode("04787910");
        billingAddress.setStateOrProvince("SP");
        billingAddress.setStreet("Roque Petroni Jr");

        Name shopperName = new Name();
        shopperName.setFirstName("Jose");
        shopperName.setLastName("Silva");

        PaymentRequest paymentRequest = createBasePaymentRequest(new PaymentRequest()).reference("123456")
                                                                                      .setAmountData("200", "BRL")
                                                                                      .billingAddress(billingAddress)
                                                                                      .selectedBrand(BOLETO_SANTANDER)
                                                                                      .shopperName(shopperName);

        PaymentResult paymentResult = payment.authorise(paymentRequest);
        assertEquals(BOLETO_SANTANDER, paymentResult.getPaymentMethod());
        assertEquals("34191.75801 12021.372227 21111.100000 8 71670000001000", paymentResult.getBoletoBarCodeReference());
        assertEquals(
                "BQABAQB8k7t5uD2wSpo185nNeQ9CU50Zf6z/z9EdC5yFH3+1o/DQH3v3dtTxqXD2DrEdVH0Ro3r/+G9bdUzrCUjfMFh7YB32VL2oPqye9Ly/MWzj7bOaRrpGH5PaB8gE9LkIgo8WKqHix1cwsFm3aHiLBECjItOpUR/CBuiJBGPvseN7yrSdG5vQAUM9AQixpPkyCNokbnDZoa1y3+qihZa7vvzV/XylTXdgirxboVKpk07Wfvpad8Owg/K/ofDqUfrZ3SUovkJzpZ5wP2NtOz84zBV8dJ+9vZs+aor/E//s+EjKgNJt2s2uX0OfdE3h1n41RW2MlfQBtXLbgbxKVVSH5qfPELsZhr10A9y9VpCd9DOP6lEAAFchf10tGLvIKj2j4ktIErp0uLCbLqa1/AvmfQ9a6e0TClmsbtwKoZ9LvAPpzHqRcmidgyUM1Igk5YsHBD7L8pzoJS5hL+DKXMeUav6oP20v9huLS3Ps6EiK4fyg5kgptZPhSQ5UN3GrGSoefja1Ylw32EBovEiaK9rdKkT/eVf+wncwLTLUiMD26R7qRxbvwAg4G8VIv6dxvOsKf2RutfOoCBNH6VhgwXfIoe0bHqmpx4dGwrjkVThspdsZYhHFrZK58grIb4OyKORibOYxvsmYmRdWMDX9Y1X8uva8OYs=",
                paymentResult.getBoletoData());

        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        fmt.setTimeZone(TimeZone.getTimeZone("GMT"));

        assertEquals("2017-05-22", fmt.format(paymentResult.getBoletoDueDate()));
        assertEquals(
                "https://test.adyen.com/hpp/generationBoleto.shtml?data=BQABAQB8k7t5uD2wSpo185nNeQ9CU50Zf6z%2Fz9EdC5yFH3%2B1o%2FDQH3v3dtTxqXD2DrEdVH0Ro3r%2F%2BG9bdUzrCUjfMFh7YB32VL2oPqye9Ly%2FMWzj7bOaRrpGH5PaB8gE9LkIgo8WKqHix1cwsFm3aHiLBECjItOpUR%2FCBuiJBGPvseN7yrSdG5vQAUM9AQixpPkyCNokbnDZoa1y3%2BqihZa7vvzV%2FXylTXdgirxboVKpk07Wfvpad8Owg%2FK%2FofDqUfrZ3SUovkJzpZ5wP2NtOz84zBV8dJ%2B9vZs%2Baor%2FE%2F%2Fs%2BEjKgNJt2s2uX0OfdE3h1n41RW2MlfQBtXLbgbxKVVSH5qfPELsZhr10A9y9VpCd9DOP6lEAAFchf10tGLvIKj2j4ktIErp0uLCbLqa1%2FAvmfQ9a6e0TClmsbtwKoZ9LvAPpzHqRcmidgyUM1Igk5YsHBD7L8pzoJS5hL%2BDKXMeUav6oP20v9huLS3Ps6EiK4fyg5kgptZPhSQ5UN3GrGSoefja1Ylw32EBovEiaK9rdKkT%2FeVf%2BwncwLTLUiMD26R7qRxbvwAg4G8VIv6dxvOsKf2RutfOoCBNH6VhgwXfIoe0bHqmpx4dGwrjkVThspdsZYhHFrZK58grIb4OyKORibOYxvsmYmRdWMDX9Y1X8uva8OYs%3D",
                paymentResult.getBoletoUrl());
        assertEquals("2017-06-06", fmt.format(paymentResult.getBoletoExpirationDate()));
        assertEquals(RECEIVED, paymentResult.getResultCode());
        assertEquals("8814950120218231", paymentResult.getPspReference());
    }
}
