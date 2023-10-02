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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.constants.ApiConstants.AdditionalData;
import com.adyen.constants.ApiConstants.RefusalReason;
import com.adyen.httpclient.AdyenHttpClient;
import com.adyen.httpclient.ClientInterface;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.model.RequestOptions;
import com.adyen.model.payment.*;
import com.adyen.service.PaymentApi;
import com.adyen.service.exception.ApiException;
import com.adyen.util.DateUtil;
import com.fasterxml.jackson.databind.JavaType;
import com.google.gson.reflect.TypeToken;
import okio.ByteString;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.Base64;

import static com.adyen.constants.ApiConstants.AdditionalData.*;
import static com.adyen.constants.ApiConstants.SelectedBrand.BOLETO_SANTANDER;
import static com.adyen.model.payment.PaymentResult.ResultCodeEnum.RECEIVED;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Tests for /authorise and /authorise3d
 */
public class PaymentTest extends BaseTest {
    /**
     * Test success flow for POST /authorise
     */
    @Test
    public void TestAuthoriseSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/authorise-success.json");
        PaymentApi payment = new PaymentApi(client);

        PaymentRequest paymentRequest = createFullCardPaymentRequest();

        MerchantDevice device = new MerchantDevice();
        device.setOs("LINUX");

        ApplicationInfo applicationInfo = new ApplicationInfo();
        applicationInfo.setMerchantDevice(device);
        paymentRequest.setApplicationInfo(applicationInfo);

        PaymentResult paymentResult = payment.authorise(paymentRequest);

        assertAuthorised(paymentResult);

        SimpleDateFormat format = new SimpleDateFormat("M/yyyy", Locale.ENGLISH);
        format.setTimeZone(TimeZone.getTimeZone("GMT"));

        Map<String, String> additionalData =  paymentResult.getAdditionalData();
        assertNotNull(additionalData);
        String expiryDate = additionalData.get(EXPIRY_DATE);
        assertEquals("8/2018", format.format(DateUtil.parseMYDate(expiryDate)));

        assertEquals("411111", additionalData.get(CARD_BIN));
        assertEquals("1111", additionalData.get(CARD_SUMMARY));
        assertEquals("Holder", additionalData.get(CARD_HOLDER_NAME));
        assertEquals("true", additionalData.get(THREE_D_OFFERERED));
        assertEquals("false", additionalData.get(THREE_D_AUTHENTICATED));
        assertEquals("69746", paymentResult.getAuthCode());

        assertEquals(11, paymentResult.getFraudResult().getResults().size());

        FraudCheckResult fraudCheckResult = paymentResult.getFraudResult().getResults().get(0).getFraudCheckResult();
        assertEquals("CardChunkUsage", fraudCheckResult.getName());
        assertEquals(8, fraudCheckResult.getAccountScore().intValue());
        assertEquals(2, fraudCheckResult.getCheckId().intValue());
    }

    /**
     * Test error flow 010 for POST /authorise
     */
    @Test
    public void TestAuthoriseError010Mocked() throws Exception {
        Client client = createMockClientForErrors(403, "mocks/authorise-error-010.json");
        PaymentApi payment = new PaymentApi(client);

        PaymentRequest paymentRequest = createFullCardPaymentRequest();

        try {
            payment.authorise(paymentRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertTrue(e.getResponseBody().contains("010"));
            assertEquals(403, e.getStatusCode());
        }
    }

    /**
     * Test error flow with wrong CVC for POST /authorise
     */
    @Test
    public void TestAuthoriseErrorCVCDeclinedMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/authorise-error-cvc-declined.json");
        PaymentApi payment = new PaymentApi(client);

        PaymentRequest paymentRequest = createFullCardPaymentRequest();

        PaymentResult paymentResult = payment.authorise(paymentRequest);

        assertRefused(paymentResult);
    }

    /**
     * Test success flow with 3D secured CC for POST /authorise
     */
    @Test
    public void TestAuthoriseSuccess3DMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/authorise-success-3d.json");
        PaymentApi payment = new PaymentApi(client);

        PaymentRequest paymentRequest = createFullCardPaymentRequest();

        PaymentResult paymentResult = payment.authorise(paymentRequest);

        assertEquals(PaymentResult.ResultCodeEnum.REDIRECTSHOPPER, paymentResult.getResultCode());
        assertNotNull(paymentResult.getMd());
        assertNotNull(paymentResult.getIssuerUrl());
        assertNotNull(paymentResult.getPaRequest());
    }

    /**
     * Test success flow for POST /authorise3d
     */
    @Test
    public void TestAuthorise3DSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/authorise3d-success.json");
        PaymentApi payment = new PaymentApi(client);

        PaymentRequest3d paymentRequest3d = create3DPaymentRequest();

        PaymentResult paymentResult = payment.authorise3d(paymentRequest3d);

        assertAuthorised(paymentResult);
        assertNotNull(paymentResult.getPspReference());
    }

    /**
     * Test success flow for POST /authorise3ds2
     */
    @Test
    public void TestAuthorise3DS2SuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/authorise-success-3ds2.json");
        PaymentApi payment = new PaymentApi(client);

        PaymentRequest3ds2 paymentRequest3ds2 = create3DS2PaymentRequest();

        PaymentResult paymentResult = payment.authorise3ds2(paymentRequest3ds2);

        assertAuthorised(paymentResult);
        assertNotNull(paymentResult.getAdditionalData());
        assertEquals(paymentResult.getPspReference(), "9935272408535455");
        assertEquals(paymentResult.getAuthCode(), "46125");
    }

    /**
     * Test success flow for POST /retrieve3ds2Result
     */
    @Test
    public void TestRetrieve3ds2ResultSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/retrieve-result-success-3ds2.json");
        PaymentApi payment = new PaymentApi(client);
        ThreeDS2ResultRequest threeDS2ResultRequest = new ThreeDS2ResultRequest();
        threeDS2ResultRequest.setMerchantAccount("AMerchantAccount");
        threeDS2ResultRequest.setPspReference("9935272408535455");

        ThreeDS2ResultResponse threeDS2ResultResponse = payment.retrieve3ds2Result(threeDS2ResultRequest);

        assertEquals(threeDS2ResultResponse.getThreeDS2Result().getTransStatus(), "Y");
        assertEquals(threeDS2ResultResponse.getThreeDS2Result().getAuthenticationValue(), "3q2+78r+ur7erb7vyv66vv8deha8=");
        assertEquals(threeDS2ResultResponse.getThreeDS2Result().getEci(), "07");
        assertEquals(threeDS2ResultResponse.getThreeDS2Result().getThreeDSServerTransID(), "73aab3ce-eb39-49e8-8e9b-46fb77a472f1");
    }

    /**
     * Test success flow (CSE) for POST /authorise
     */
    @Test
    public void TestAuthoriseCSESuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/authorise-success-cse.json");
        PaymentApi payment = new PaymentApi(client);

        PaymentRequest paymentRequest = createCSEPaymentRequest();

        PaymentResult paymentResult = payment.authorise(paymentRequest);

        assertAuthorised(paymentResult);
    }

    /**
     * Test flow (CSE) expired card for POST /authorise
     */
    @Test
    public void TestAuthoriseCSEErrorExpiredMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/authorise-error-expired.json");
        PaymentApi payment = new PaymentApi(client);

        PaymentRequest paymentRequest = createCSEPaymentRequest();

        PaymentResult paymentResult = payment.authorise(paymentRequest);

        assertRefused(paymentResult);
        assertEquals(RefusalReason.REFUSED, paymentResult.getRefusalReason());
        assertEquals("DECLINED Expiry Incorrect", paymentResult.getAdditionalData().get(AdditionalData.REFUSAL_REASON_RAW));
    }

    /**
     * Test error 401 (Not authorized)
     */
    @Test
    public void TestError401Mocked() throws Exception {
        AdyenHttpClient adyenHttpClient = mock(AdyenHttpClient.class);
        HTTPClientException httpClientException = new HTTPClientException(401, "An error occured", new HashMap<>(), null);

        when(adyenHttpClient.request(anyString(), anyString(), any(Config.class), anyBoolean(), any(RequestOptions.class), isNull())).thenThrow(httpClientException);
        when(adyenHttpClient.request(anyString(), anyString(), any(Config.class), anyBoolean(), isNull(), any(), isNull())).thenThrow(httpClientException);

        Client client = new Client();
        client.setHttpClient(adyenHttpClient);

        PaymentApi payment = new PaymentApi(client);

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
        PaymentApi payment = new PaymentApi(client);

        PaymentRequest paymentRequest = this.createOpenInvoicePaymentRequest();
        PaymentResult paymentResult = payment.authorise(paymentRequest);
        assertEquals("2374421290", paymentResult.getAdditionalData().get("additionalData.acquirerReference"));
        assertEquals("klarna", paymentResult.getAdditionalData().get("paymentMethodVariant"));
        assertAuthorised(paymentResult);
    }

    @Test
    public void TestBoletoSuccess() throws Exception {

        Client client = createMockClientFromFile("mocks/authorise-success-boleto.json");
        PaymentApi payment = new PaymentApi(client);

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
                                                                                      .amount(new Amount().value(200L).currency( "BRL"))
                                                                                      .billingAddress(billingAddress)
                                                                                      .selectedBrand(BOLETO_SANTANDER)
                                                                                      .shopperName(shopperName);

        PaymentResult paymentResult = payment.authorise(paymentRequest);

        Map<String, String> additionalData =  paymentResult.getAdditionalData();
        assertNotNull(additionalData);
        assertEquals(BOLETO_SANTANDER, additionalData.get(PAYMENT_METHOD));
        assertEquals("34191.75801 12021.372227 21111.100000 8 71670000001000", additionalData.get(BOLETO_BARCODE_REFERENCE));
        assertEquals(
                "BQABAQB8k7t5uD2wSpo185nNeQ9CU50Zf6z/z9EdC5yFH3+1o/DQH3v3dtTxqXD2DrEdVH0Ro3r/+G9bdUzrCUjfMFh7YB32VL2oPqye9Ly/MWzj7bOaRrpGH5PaB8gE9LkIgo8WKqHix1cwsFm3aHiLBECjItOpUR/CBuiJBGPvseN7yrSdG5vQAUM9AQixpPkyCNokbnDZoa1y3+qihZa7vvzV/XylTXdgirxboVKpk07Wfvpad8Owg/K/ofDqUfrZ3SUovkJzpZ5wP2NtOz84zBV8dJ+9vZs+aor/E//s+EjKgNJt2s2uX0OfdE3h1n41RW2MlfQBtXLbgbxKVVSH5qfPELsZhr10A9y9VpCd9DOP6lEAAFchf10tGLvIKj2j4ktIErp0uLCbLqa1/AvmfQ9a6e0TClmsbtwKoZ9LvAPpzHqRcmidgyUM1Igk5YsHBD7L8pzoJS5hL+DKXMeUav6oP20v9huLS3Ps6EiK4fyg5kgptZPhSQ5UN3GrGSoefja1Ylw32EBovEiaK9rdKkT/eVf+wncwLTLUiMD26R7qRxbvwAg4G8VIv6dxvOsKf2RutfOoCBNH6VhgwXfIoe0bHqmpx4dGwrjkVThspdsZYhHFrZK58grIb4OyKORibOYxvsmYmRdWMDX9Y1X8uva8OYs=",
                additionalData.get(BOLETO_DATA));

        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        fmt.setTimeZone(TimeZone.getTimeZone("GMT"));

        assertEquals("2017-05-22", fmt.format(DateUtil.parseYmdDate(additionalData.get(BOLETO_DUE_DATE))));
        assertEquals(
                "https://test.adyen.com/hpp/generationBoleto.shtml?data=BQABAQB8k7t5uD2wSpo185nNeQ9CU50Zf6z%2Fz9EdC5yFH3%2B1o%2FDQH3v3dtTxqXD2DrEdVH0Ro3r%2F%2BG9bdUzrCUjfMFh7YB32VL2oPqye9Ly%2FMWzj7bOaRrpGH5PaB8gE9LkIgo8WKqHix1cwsFm3aHiLBECjItOpUR%2FCBuiJBGPvseN7yrSdG5vQAUM9AQixpPkyCNokbnDZoa1y3%2BqihZa7vvzV%2FXylTXdgirxboVKpk07Wfvpad8Owg%2FK%2FofDqUfrZ3SUovkJzpZ5wP2NtOz84zBV8dJ%2B9vZs%2Baor%2FE%2F%2Fs%2BEjKgNJt2s2uX0OfdE3h1n41RW2MlfQBtXLbgbxKVVSH5qfPELsZhr10A9y9VpCd9DOP6lEAAFchf10tGLvIKj2j4ktIErp0uLCbLqa1%2FAvmfQ9a6e0TClmsbtwKoZ9LvAPpzHqRcmidgyUM1Igk5YsHBD7L8pzoJS5hL%2BDKXMeUav6oP20v9huLS3Ps6EiK4fyg5kgptZPhSQ5UN3GrGSoefja1Ylw32EBovEiaK9rdKkT%2FeVf%2BwncwLTLUiMD26R7qRxbvwAg4G8VIv6dxvOsKf2RutfOoCBNH6VhgwXfIoe0bHqmpx4dGwrjkVThspdsZYhHFrZK58grIb4OyKORibOYxvsmYmRdWMDX9Y1X8uva8OYs%3D",
                additionalData.get(BOLETO_URL));
        assertEquals("2017-06-06", fmt.format(DateUtil.parseYmdDate(additionalData.get(BOLETO_EXPIRATION_DATE))));
        assertEquals(RECEIVED, paymentResult.getResultCode());
        assertEquals("8814950120218231", paymentResult.getPspReference());
    }

    @Test
    public void TestGetAuthenticationResult3ds1Success() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/authentication-result-success-3ds1.json");

        PaymentApi payment = new PaymentApi(client);
        AuthenticationResultRequest authenticationResultRequest = createAuthenticationResultRequest();
        AuthenticationResultResponse authenticationResultResponse = payment.getAuthenticationResult(authenticationResultRequest);
        assertNotNull(authenticationResultResponse);
        assertNotNull(authenticationResultResponse.getThreeDS1Result());
        assertNull(authenticationResultResponse.getThreeDS2Result());
    }

    @Test
    public void TestGetAuthenticationResult3ds2Success() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/authentication-result-success-3ds2.json");

        PaymentApi payment = new PaymentApi(client);
        AuthenticationResultRequest authenticationResultRequest = createAuthenticationResultRequest();
        AuthenticationResultResponse authenticationResultResponse = payment.getAuthenticationResult(authenticationResultRequest);
        assertNotNull(authenticationResultResponse);
        assertNull(authenticationResultResponse.getThreeDS1Result());
        assertNotNull(authenticationResultResponse.getThreeDS2Result());
    }

    @Test
    public void TestGetAuthenticationResultErrorOldAuthentication() throws IOException {
        Client client = createMockClientForErrors(422, "mocks/authentication-result-error-old-psp.json");

        PaymentApi payment = new PaymentApi(client);
        AuthenticationResultRequest authenticationResultRequest = createAuthenticationResultRequest();
        try {
            payment.getAuthenticationResult(authenticationResultRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getResponseBody());
            assertTrue(e.getResponseBody().contains("15_024"));
            assertEquals(422, e.getStatusCode());
        }
    }

    @Test
    public void TestGetAuthenticationResultErrorNotFound() throws IOException {
        Client client = createMockClientForErrors(422, "mocks/authentication-result-error-not-found.json");

        PaymentApi payment = new PaymentApi(client);
        AuthenticationResultRequest authenticationResultRequest = createAuthenticationResultRequest();
        try {
            payment.getAuthenticationResult(authenticationResultRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getResponseBody());
            assertTrue(e.getResponseBody().contains("15_012"));
            assertEquals(422, e.getStatusCode());
        }
    }

    @Test
    public void TestGetAuthenticationResultErrorInvalidPsp() throws IOException {
        Client client = createMockClientForErrors(422, "mocks/authentication-result-error-invalid-psp.json");

        PaymentApi payment = new PaymentApi(client);
        AuthenticationResultRequest authenticationResultRequest = createAuthenticationResultRequest();
        authenticationResultRequest.setPspReference(null);
        try {
            payment.getAuthenticationResult(authenticationResultRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getResponseBody());
            assertTrue(e.getResponseBody().contains("15_011"));
            assertEquals(422, e.getStatusCode());
        }
    }

    @Test
    public void TestGetAuthenticationResultErrorNotAllowed() throws IOException {

        Client client = createMockClientForErrors(403, "mocks/authentication-result-error-not-allowed.json");

        PaymentApi payment = new PaymentApi(client);
        AuthenticationResultRequest authenticationResultRequest = createAuthenticationResultRequest();
        try {
            payment.getAuthenticationResult(authenticationResultRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getResponseBody());
            assertTrue(e.getResponseBody().contains("010"));
            assertEquals(403, e.getStatusCode());
        }
    }

    @Test
    public void TestAuthoriseCustomApplicationInfo() throws Exception {
        Client client = createMockClientFromFile("mocks/authorise-success-cse.json");
        PaymentApi payment = new PaymentApi(client);

        PaymentRequest paymentRequest = createCSEPaymentRequest();
        ApplicationInfo applicationInfo = new ApplicationInfo();
        applicationInfo.setMerchantDevice(new MerchantDevice().os("Android"));
        paymentRequest.setApplicationInfo(applicationInfo);

        PaymentResult paymentResult = payment.authorise(paymentRequest);

        assertAuthorised(paymentResult);
        assertEquals(applicationInfo, paymentRequest.getApplicationInfo());
        assertEquals("Android", paymentRequest.getApplicationInfo().getMerchantDevice().getOs());
    }

    protected void assertAuthorised(PaymentResult paymentResult) {
        assertEquals(PaymentResult.ResultCodeEnum.AUTHORISED, paymentResult.getResultCode());
    }
    
    protected void assertRefused(PaymentResult paymentResult) {
        assertEquals(PaymentResult.ResultCodeEnum.REFUSED, paymentResult.getResultCode());
    }
    @Test
    public void TestByteArrayDeserialization() throws Exception {

        final String expectedBytesAsString = "Let's pretend/ this a jpg or something=";
        final byte[] expectedBytes = expectedBytesAsString.getBytes(StandardCharsets.UTF_8);
        final ByteString expectedByteString = ByteString.of(expectedBytes);
        final String serializedBytes = expectedByteString.base64();
        final String serializedBytesWithQuotes = "\"" + serializedBytes + "\"";

        // Act
        byte[] actualDeserializedBytes = JSON.getMapper().readValue(serializedBytesWithQuotes, byte[].class);

        // Assert
        assertEquals(expectedBytesAsString, new String(Base64.getDecoder().decode(actualDeserializedBytes)));
    }

    @Test
    public void TestByteArrayToJSONString() throws Exception {
        Client client = createMockClientFromFile("mocks/authorise-success.json");
        PaymentApi payment = new PaymentApi(client);
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.mpiData(new ThreeDSecureData().cavv("AQIDBAUGBwgJCgsMDQ4PEBESExQ=".getBytes()));
        
        payment.authorise(paymentRequest);
        // Unicode representation of the string
        String expected = "\"mpiData\":{\"cavv\":\"AQIDBAUGBwgJCgsMDQ4PEBESExQ=\"}";
        ClientInterface http = client.getHttpClient();
        verify(http).request(anyString(), contains(expected), any(), eq(false), isNull(), any(), isNull());
    }

    @Test
    public void testRefund() throws Exception {
        Client client = createMockClientFromFile("mocks/modification-success.json");
        PaymentApi payment = new PaymentApi(client);
        RefundRequest request = new RefundRequest();
        ModificationResult result = payment.refund(request);
        assertEquals(result.getResponse(), ModificationResult.ResponseEnum.REFUND_RECEIVED_);
    }

    @Test
    public void testCapture() throws Exception {
        Client client = createMockClientFromFile("mocks/modification-success.json");
        PaymentApi payment = new PaymentApi(client);
        CaptureRequest request = new CaptureRequest();
        ModificationResult result = payment.capture(request);
        assertEquals(result.getResponse(), ModificationResult.ResponseEnum.REFUND_RECEIVED_);
    }

    @Test
    public void testCancel() throws Exception {
        Client client = createMockClientFromFile("mocks/modification-success.json");
        PaymentApi payment = new PaymentApi(client);
        CancelRequest request = new CancelRequest();
        ModificationResult result = payment.cancel(request);
        assertEquals(result.getResponse(), ModificationResult.ResponseEnum.REFUND_RECEIVED_);
    }

    @Test
    public void testCancelOrRefund() throws Exception {
        Client client = createMockClientFromFile("mocks/modification-success.json");
        PaymentApi payment = new PaymentApi(client);
        CancelOrRefundRequest request = new CancelOrRefundRequest();
        ModificationResult result = payment.cancelOrRefund(request);
        assertEquals(result.getResponse(), ModificationResult.ResponseEnum.REFUND_RECEIVED_);
    }

    @Test
    public void testTechnicalCancel() throws Exception {
        Client client = createMockClientFromFile("mocks/modification-success.json");
        PaymentApi payment = new PaymentApi(client);
        TechnicalCancelRequest request = new TechnicalCancelRequest();
        ModificationResult result = payment.technicalCancel(request);
        assertEquals(result.getResponse(), ModificationResult.ResponseEnum.REFUND_RECEIVED_);
    }

    @Test
    public void testAdjustAuthorisation() throws Exception {
        Client client = createMockClientFromFile("mocks/modification-success.json");
        PaymentApi payment = new PaymentApi(client);
        AdjustAuthorisationRequest request = new AdjustAuthorisationRequest();
        ModificationResult result = payment.adjustAuthorisation(request);
        assertEquals(result.getResponse(), ModificationResult.ResponseEnum.REFUND_RECEIVED_);
    }

    @Test
    public void testDonate() throws Exception {
        Client client = createMockClientFromFile("mocks/modification-success.json");
        PaymentApi payment = new PaymentApi(client);
        DonationRequest request = new DonationRequest();
        ModificationResult result = payment.donate(request);
        assertEquals(result.getResponse(), ModificationResult.ResponseEnum.REFUND_RECEIVED_);
    }

    @Test
    public void testVoidPendingRefund() throws Exception {
        Client client = createMockClientFromFile("mocks/modification-success.json");
        PaymentApi payment = new PaymentApi(client);
        VoidPendingRefundRequest request = new VoidPendingRefundRequest();
        ModificationResult result = payment.voidPendingRefund(request);
        assertEquals(result.getResponse(), ModificationResult.ResponseEnum.REFUND_RECEIVED_);
    }
}
