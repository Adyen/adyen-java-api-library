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

import com.adyen.constants.BrandCodes;
import com.adyen.deserializer.PaymentMethodDetailsDeserializerJackson;
import com.adyen.model.Amount;
import com.adyen.model.Split;
import com.adyen.model.SplitAmount;
import com.adyen.model.checkout.CheckoutCancelOrderRequest;
import com.adyen.model.checkout.CheckoutCancelOrderResponse;
import com.adyen.model.checkout.CheckoutCreateOrderRequest;
import com.adyen.model.checkout.CheckoutCreateOrderResponse;
import com.adyen.model.checkout.CheckoutOrder;
import com.adyen.model.checkout.PaymentMethodsRequest;
import com.adyen.model.checkout.PaymentMethodsResponse;
import com.adyen.model.checkout.PaymentRequest;
import com.adyen.model.checkout.PaymentResponse;
import com.adyen.model.checkout.CreateCheckoutSessionRequest;
import com.adyen.model.checkout.CreateCheckoutSessionResponse;
import com.adyen.model.checkout.RiskData;
import com.adyen.model.checkout.CreatePaymentCaptureRequest;
import com.adyen.model.checkout.PaymentCaptureResource;
import com.adyen.model.checkout.CreatePaymentCancelRequest;
import com.adyen.model.checkout.PaymentCancelResource;
import com.adyen.model.checkout.PaymentReversalResource;
import com.adyen.model.checkout.CreatePaymentReversalRequest;
import com.adyen.model.checkout.PaymentRefundResource;
import com.adyen.model.checkout.CreatePaymentRefundRequest;
import com.adyen.model.checkout.CreateStandalonePaymentCancelRequest;
import com.adyen.model.checkout.StandalonePaymentCancelResource;
import com.adyen.model.checkout.PaymentAmountUpdateResource;
import com.adyen.model.checkout.CreatePaymentAmountUpdateRequest;
import com.adyen.service.Checkout;
import com.adyen.service.exception.ApiException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;
import static com.adyen.enums.Environment.LIVE;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests for
 * /paymentSession
 * /payments/result
 * /paymentMethods
 * /payments
 * /payments/details
 * /payments/storedPaymentMethods
 */
public class CheckoutTest extends BaseTest {
    /**
     * Test success flow for
     * POST /payments
     */
    @Test
    public void TestPaymentsSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-success.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentResponse PaymentResponse = checkout.payments(PaymentRequest);
        assertEquals("8535296650153317", PaymentResponse.getPspReference());
        assertNotNull(PaymentResponse.getDonationToken());
    }

    /**
     * Test success flow for PayPal SDK type
     * POST /payments
     */
    @Test
    public void TestPaypalPaymentSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-success-paypal.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentResponse PaymentResponse = checkout.payments(PaymentRequest);
        assertEquals("EC-42N19135GM6949000", PaymentResponse.getAction().getCheckoutSDKAction().getSdkData().get("orderID"));
    }

    /**
     * Test success flow for OneTimePass type
     * POST /payments
     */
    @Test
    public void TestOneTimePassPaymentSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-success-onetimepass.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentResponse PaymentResponse = checkout.payments(PaymentRequest);
        assertEquals(1, PaymentResponse.getAction().getCheckoutSDKAction().getResendInterval());
        assertEquals(3, PaymentResponse.getAction().getResendMaxAttempts());
        assertEquals("https://localhost:8080", PaymentResponse.getAction().getResendUrl());
        assertNotNull(PaymentResponse.getAction());
        assertEquals(Redirect.MethodEnum.GET, PaymentResponse.getAction().getRedirect().getMethod());
        assertEquals("https://localhost:8080", PaymentResponse.getAction().getRedirect().getUrl());
        assertNull(PaymentResponse.getAction().getRedirect().getData());

    }

    /**
     * Test success flow for
     * POST /payments
     */
    @Test
    public void TestEncryptedPaymentsSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-encrypted-success.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest PaymentRequest = createEncryptedPaymentsCheckoutRequest();
        PaymentResponse PaymentResponse = checkout.payments(PaymentRequest);
        assertEquals("883586864229293H", PaymentResponse.getPspReference());
    }

    /**
     * Test success flow for
     * POST /payments
     */
    @Test
    public void TestEncryptedPaymentsWithoutHoldernameSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-encrypted-without-holdername-success.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest PaymentRequest = createEncryptedPaymentsCheckoutRequestWithoutHoldername();
        PaymentResponse PaymentResponse = checkout.payments(PaymentRequest);
        assertEquals("853613724697009G", PaymentResponse.getPspReference());
    }
    
    /**
     * Test error flow for
     * POST /payments
     */
    @Test
    public void TestPaymentsErrorMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-error-invalid-data-422.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentResponse PaymentResponse = checkout.payments(PaymentRequest);
        assertNull(PaymentResponse.getPspReference());
    }

    /**
     * Test success flow for
     * POST /paymentMethods
     */
    @Test
    public void TestPaymentMethodsSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentmethods-success.json");
        Checkout checkout = new Checkout(client);
        PaymentMethodsRequest paymentMethodsRequest = new PaymentMethodsRequest();
        paymentMethodsRequest.setMerchantAccount("MagentoMerchantTest");
        PaymentMethodsResponse paymentMethodsResponse = checkout.paymentMethods(paymentMethodsRequest);
        assertEquals(32, paymentMethodsResponse.getPaymentMethods().size());
        assertEquals("Credit Card", paymentMethodsResponse.getPaymentMethods().get(2).getName());
        assertEquals(9, paymentMethodsResponse.getPaymentMethods().get(2).getBrands().size());
        assertEquals("svs", paymentMethodsResponse.getPaymentMethods().get(25).getBrand());
        assertEquals("Local Polish Payment Methods", paymentMethodsResponse.getPaymentMethods().get(12).getName());
        assertEquals("Bank transfer / postal", paymentMethodsResponse.getPaymentMethods().get(12).getIssuers().get(2).getName());


    }

    /**
     * Test success flow for
     * POST /paymentMethods
     * including one-click methods
     */
    @Test
    public void TestPaymentMethodsOneClickSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentmethods-oneclick-success.json");
        Checkout checkout = new Checkout(client);
        PaymentMethodsRequest paymentMethodsRequest = new PaymentMethodsRequest();
        paymentMethodsRequest.setMerchantAccount("MagentoMerchantTest");
        PaymentMethodsResponse paymentMethodsResponse = checkout.paymentMethods(paymentMethodsRequest);
        assertNotNull(paymentMethodsResponse.getPaymentMethods().getOneClickPaymentMethods());
        assertEquals(2, paymentMethodsResponse.getOneClickPaymentMethods().size());
        assertEquals("8314960677671745", paymentMethodsResponse.getOneClickPaymentMethods().get(0).getRecurringDetailReference());
    }

    /**
     * Test success flow for
     * POST /paymentMethods
     * including storing methods
     */
    @Test
    public void TestPaymentMethodsStoringMethodsMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentmethods-storingmethods-success.json");
        Checkout checkout = new Checkout(client);
        PaymentMethodsRequest paymentMethodsRequest = new PaymentMethodsRequest();
        paymentMethodsRequest.setMerchantAccount("TestMerchant");
        PaymentMethodsResponse paymentMethodsResponse = checkout.paymentMethods(paymentMethodsRequest);
        assertNotNull(paymentMethodsResponse.getStoringMethods());
        assertEquals(1, paymentMethodsResponse.getStoringMethods().size());
        assertEquals(1, paymentMethodsResponse.getStoringMethods().get(0).getIssuers().size());
        assertEquals("rabobank", paymentMethodsResponse.getStoringMethods().get(0).getIssuers().get(0).getId());
        assertEquals("Rabobank", paymentMethodsResponse.getStoringMethods().get(0).getIssuers().get(0).getName());
        assertNotNull(paymentMethodsResponse.getStoringMethods().get(0).getIssuers().get(0).getRedirectUrls());
    }

    /**
     * Test error flow for
     * POST /paymentMethods
     */
    @Test
    public void TestPaymentMethodsErrorMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentmethods-error-forbidden-403.json");
        Checkout checkout = new Checkout(client);
        PaymentMethodsRequest paymentMethodsRequest = new PaymentMethodsRequest();
        paymentMethodsRequest.setMerchantAccount("MagentoMerchantTest");
        PaymentMethodsResponse paymentMethodsResponse = checkout.paymentMethods(paymentMethodsRequest);
        assertNull(paymentMethodsResponse.getPaymentMethods());
    }

    /**
     * Test success flow for
     * POST /payments/details
     */
    @Test
    public void TestPaymentsDetailsSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentsdetails-sucess.json");
        Checkout checkout = new Checkout(client);
        PaymentsDetailsResponse PaymentResponse = checkout.paymentsDetails(createPaymentsDetailsRequest());
        assertEquals("Authorised", PaymentResponse.getResultCode().toString());
    }

    /**
     * Test error flow for
     * POST /payments/details
     */

    @Test
    public void TestPaymentsDetailsErrorMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentsdetails-error-invalid-data-422.json");
        Checkout checkout = new Checkout(client);
        PaymentsDetailsResponse PaymentResponse = checkout.paymentsDetails(createPaymentsDetailsRequest());
        assertNull(PaymentResponse.getResultCode());

    }

    /**
     * Test success flow for
     * POST  /paymentSession
     */

    @Test
    public void TestPaymentSessionSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentsession-sucess.json");
        Checkout checkout = new Checkout(client);
        PaymentSessionRequest paymentSessionRequest = createPaymentSessionRequest();
        PaymentSessionResponse paymentSessionResponse = checkout.paymentSession(paymentSessionRequest);
        assertNotNull(paymentSessionResponse.getPaymentSession());
    }

    /**
     * Test error flow for
     * POST  /paymentSession
     */

    @Test
    public void TestPaymentSessionErrorMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentsession-error-invalid-data-422.json");
        Checkout checkout = new Checkout(client);
        PaymentSessionRequest paymentSessionRequest = createPaymentSessionRequest();
        PaymentSessionResponse paymentSessionResponse = checkout.paymentSession(paymentSessionRequest);
        assertNull(paymentSessionResponse.getPaymentSession());
    }

    /**
     * Test success flow for
     * POST  /payments/result
     */

    @Test
    public void TestPaymentsResultSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentsresult-sucess.json");
        Checkout checkout = new Checkout(client);
        PaymentResultRequest paymentResultRequest = new PaymentResultRequest();
        paymentResultRequest.setPayload("This is a test payload");
        PaymentResultResponse paymentResultResponse = checkout.paymentResult(paymentResultRequest);
        assertEquals("Authorised", paymentResultResponse.getResultCode().toString());
    }

    /**
     * Test error flow for
     * POST  /payments/result
     */

    @Test
    public void TestPaymentsResultErrorMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentsresult-error-invalid-data-payload-422.json");
        Checkout checkout = new Checkout(client);
        PaymentResultRequest paymentResultRequest = new PaymentResultRequest();
        paymentResultRequest.setPayload("This is a test payload");
        PaymentResultResponse paymentResultResponse = checkout.paymentResult(paymentResultRequest);
        assertNull(paymentResultResponse.getResultCode());
    }

    /**
     * Test error flow on Checkout creation
     */
    @Test
    public void TestPaymentMethodsFailureMissingIdentifierOnLive() {
        Client client = createMockClientFromFile("mocks/checkout/paymentsresult-error-invalid-data-payload-422.json");
        client.setEnvironment(LIVE, null);
        try {
            new Checkout(client);
        } catch (IllegalArgumentException e) {
            assertEquals("Please provide your unique live url prefix on the setEnvironment() call on the Client or provide checkoutEndpoint in your config object.", e.getMessage());
        }

    }

    @Test
    public void TestPaymentMethodDetails() {
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        String jsonRequest = PRETTY_PRINT_GSON.toJson(PaymentRequest);

        assertJsonStringEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"type\": \"scheme\",\n"
                + "    \"holderName\": \"John Smith\",\n"
                + "    \"cvc\": \"737\",\n"
                + "    \"encryptedCardNumber\": \"test_4111111111111111\",\n"
                + "    \"encryptedExpiryMonth\": \"test_10\",\n"
                + "    \"encryptedExpiryYear\": \"test_2030\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}", jsonRequest);

        TestPaymentMethodDetails testPaymentMethodDetails = new TestPaymentMethodDetails();
        testPaymentMethodDetails.setType("testType");
        testPaymentMethodDetails.setTestValue("testValue");
        PaymentRequest.setPaymentMethod(testPaymentMethodDetails);

        jsonRequest = PRETTY_PRINT_GSON.toJson(PaymentRequest);
        assertJsonStringEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"testKey\": \"testValue\",\n"
                + "    \"type\": \"testType\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}", jsonRequest);
    }

    @Test
    public void TestEncryptedPaymentMethodDetails() {
        PaymentRequest PaymentRequest = createEncryptedPaymentsCheckoutRequest();
        String jsonRequest = PRETTY_PRINT_GSON.toJson(PaymentRequest);

        assertJsonStringEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"type\": \"scheme\",\n"
                + "    \"holderName\": \"John Smith\",\n"
                + "    \"cvc\": \"737\",\n"
                + "    \"encryptedCardNumber\": \"test_4111111111111111\",\n"
                + "    \"encryptedExpiryMonth\": \"test_03\",\n"
                + "    \"encryptedExpiryYear\": \"test_2030\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}", jsonRequest);

        TestPaymentMethodDetails testPaymentMethodDetails = new TestPaymentMethodDetails();
        testPaymentMethodDetails.setType("testType");
        testPaymentMethodDetails.setTestValue("testValue");
        PaymentRequest.setPaymentMethod(testPaymentMethodDetails);

        jsonRequest = PRETTY_PRINT_GSON.toJson(PaymentRequest);
        assertJsonStringEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"testKey\": \"testValue\",\n"
                + "    \"type\": \"testType\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}", jsonRequest);
    }

    /**
     * Test success flow for
     * POST /payments
     */
    @Test
    public void TestMultibancoPaymentsSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentsresult-multibanco-succes.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentResponse PaymentResponse = checkout.payments(PaymentRequest);
        assertEquals(0, new BigDecimal("1000.0").compareTo(BigDecimal.valueOf(PaymentResponse.getAction().getInitialAmount().getValue())));
        assertEquals("2020-01-12T09:37:49", PaymentResponse.getAction().getExpiresAt());
        assertEquals("12101", PaymentResponse.getAction().getEntity());
        assertEquals("501 422 944", PaymentResponse.getAction().getReference());

    }

    @Test
    public void TestSepaPaymentMethodDetails() {
        SepaDirectDebitDetails sepaDirectDebitDetailsDetails = new SepaDirectDebitDetails();
        sepaDirectDebitDetailsDetails.type("sepadirectdebit");
        sepaDirectDebitDetailsDetails.setOwnerName("A. Schneider");
        sepaDirectDebitDetailsDetails.setIban("DE87123456781234567890");

        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(sepaDirectDebitDetailsDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(PaymentRequest);

        assertJsonStringEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"type\": \"sepadirectdebit\",\n"
                + "    \"ownerName\": \"A. Schneider\",\n"
                + "    \"iban\": \"DE87123456781234567890\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}", jsonRequest);
    }

    @Test
    public void TestSepaDirectDebitDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"iban\":\"DE87123456781234567890\",\"ownerName\":\"A. Schneider\",\"type\":\"sepadirectdebit\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        SepaDirectDebitDetails sepaDirectDebitDetails = new SepaDirectDebitDetails();
        sepaDirectDebitDetails.setOwnerName("A. Schneider");
        sepaDirectDebitDetails.setIban("DE87123456781234567890");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(sepaDirectDebitDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestSepaDirectDebitDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"iban\":\"DE87123456781234567890\",\"ownerName\":\"A. Schneider\",\"type\":\"sepadirectdebit\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        SepaDirectDebitDetails sepaDirectDebitDetails = new SepaDirectDebitDetails();
        sepaDirectDebitDetails.setOwnerName("A. Schneider");
        sepaDirectDebitDetails.setIban("DE87123456781234567890");
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(sepaDirectDebitDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestAchDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"bankAccountNumber\":\"1234567\",\"bankLocationId\":\"1234567\",\"encryptedBankAccountNumber\":\"1234asdfg\",\"ownerName\":\"John Smith\",\"type\":\"ach\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        AchDetails achDetails = new AchDetails();
        achDetails.setBankAccountNumber("1234567");
        achDetails.setBankLocationId("1234567");
        achDetails.setEncryptedBankAccountNumber("1234asdfg");
        achDetails.setOwnerName("John Smith");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(achDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestAchDetailsDeserializer() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"bankAccountNumber\":\"1234567\",\"bankLocationId\":\"1234567\",\"encryptedBankAccountNumber\":\"1234asdfg\",\"ownerName\":\"John Smith\",\"type\":\"ach\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        AchDetails achDetails = new AchDetails();
        achDetails.setBankAccountNumber("1234567");
        achDetails.setBankLocationId("1234567");
        achDetails.setEncryptedBankAccountNumber("1234asdfg");
        achDetails.setOwnerName("John Smith");
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(achDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestEcontextVoucherDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"firstName\":\"John\",\"lastName\":\"Smith\",\"shopperEmail\":\"test@email.com\",\"telephoneNumber\":\"0123456789\",\"type\":\"econtext_seveneleven\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        EcontextVoucherDetails econtextVoucherDetails = new EcontextVoucherDetails();
        econtextVoucherDetails.setFirstName("John");
        econtextVoucherDetails.setLastName("Smith");
        econtextVoucherDetails.setShopperEmail("test@email.com");
        econtextVoucherDetails.setTelephoneNumber("0123456789");
        econtextVoucherDetails.setType(EcontextVoucherDetails.SEVENELEVEN);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(econtextVoucherDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestEcontextVoucherDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"firstName\":\"John\",\"lastName\":\"Smith\",\"shopperEmail\":\"test@email.com\",\"telephoneNumber\":\"0123456789\",\"type\":\"econtext_seveneleven\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        EcontextVoucherDetails econtextVoucherDetails = new EcontextVoucherDetails();
        econtextVoucherDetails.setFirstName("John");
        econtextVoucherDetails.setLastName("Smith");
        econtextVoucherDetails.setShopperEmail("test@email.com");
        econtextVoucherDetails.setTelephoneNumber("0123456789");
        econtextVoucherDetails.setType(EcontextVoucherDetails.SEVENELEVEN);
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(econtextVoucherDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestIdealDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"1121\",\"type\":\"ideal\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        IdealDetails idealDetails = new IdealDetails();
        idealDetails.setIssuer("1121");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(idealDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestIdealDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"1121\",\"type\":\"ideal\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
        IdealDetails idealDetails = new IdealDetails();
        idealDetails.setIssuer("1121");
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(idealDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestGooglePayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"googlePayToken\":\"Payload as retrieved from Google Pay response\",\"type\":\"googlepay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        GooglePayDetails googlePayDetails = new GooglePayDetails();
        googlePayDetails.setGooglePayToken("Payload as retrieved from Google Pay response");
        googlePayDetails.setFundingSource(GooglePayDetails.FundingSourceEnum.CREDIT);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(googlePayDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestGooglePayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"googlePayToken\":\"Payload as retrieved from Google Pay response\",\"type\":\"googlepay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
        GooglePayDetails googlePayDetails = new GooglePayDetails();
        googlePayDetails.setGooglePayToken("Payload as retrieved from Google Pay response");
        googlePayDetails.setFundingSource(GooglePayDetails.FundingSourceEnum.CREDIT);
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(googlePayDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestPayWithGoogleDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"debit\",\"googlePayToken\":\"Payload as retrieved from Google Pay response\",\"recurringDetailReference\":\"serialize-reference\",\"storedPaymentMethodId\":\"shop\",\"type\":\"paywithgoogle\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        PayWithGoogleDetails payWithGoogleDetails = new PayWithGoogleDetails();
        payWithGoogleDetails.setGooglePayToken("Payload as retrieved from Google Pay response");
        payWithGoogleDetails.setFundingSource(PayWithGoogleDetails.FundingSourceEnum.DEBIT);
        payWithGoogleDetails.setRecurringDetailReference("serialize-reference");
        payWithGoogleDetails.setStoredPaymentMethodId("shop");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(payWithGoogleDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestPayWithGoogleDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"debit\",\"googlePayToken\":\"Payload as retrieved from Google Pay response\",\"recurringDetailReference\":\"some-reference\",\"storedPaymentMethodId\":\"my-shop\",\"type\":\"paywithgoogle\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        PayWithGoogleDetails payWithGoogleDetails = new PayWithGoogleDetails();
        payWithGoogleDetails.setGooglePayToken("Payload as retrieved from Google Pay response");
        payWithGoogleDetails.setFundingSource(PayWithGoogleDetails.FundingSourceEnum.DEBIT);
        payWithGoogleDetails.setRecurringDetailReference("some-reference");
        payWithGoogleDetails.setStoredPaymentMethodId("my-shop");
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(payWithGoogleDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestPayPalDetails() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"orderID\":\"orderId\",\"payerID\":\"payerId\",\"type\":\"paypal\",\"storedPaymentMethodId\":\"12345678\",\"subtype\":\"sdk\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        PayPalDetails payPalDetails = new PayPalDetails();
        payPalDetails.setOrderID("orderId");
        payPalDetails.setPayerID("payerId");
        payPalDetails.setSubtype(PayPalDetails.SubtypeEnum.SDK);
        payPalDetails.setStoredPaymentMethodId("12345678");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(payPalDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestPayPalDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"orderID\":\"orderId\",\"payerID\":\"payerId\",\"type\":\"paypal\",\"subtype\":\"sdk\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        PayPalDetails payPalDetails = new PayPalDetails();
        payPalDetails.setOrderID("orderId");
        payPalDetails.setPayerID("payerId");
        payPalDetails.setSubtype(PayPalDetails.SubtypeEnum.SDK);
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(payPalDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestDokuDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"firstName\":\"John\",\"infix\":\"infix\",\"lastName\":\"Smith\",\"ovoId\":\"ovoid\",\"shopperEmail\":\"test@email.com\",\"type\":\"doku_indomaret\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        DokuDetails dokuDetails = new DokuDetails();
        dokuDetails.setFirstName("John");
        dokuDetails.setInfix("infix");
        dokuDetails.setLastName("Smith");
        dokuDetails.setOvoId("ovoid");
        dokuDetails.setShopperEmail("test@email.com");
        dokuDetails.setType(DokuDetails.INDOMARET);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(dokuDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestDokuDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"firstName\":\"John\",\"infix\":\"infix\",\"lastName\":\"Smith\",\"ovoId\":\"ovoid\",\"shopperEmail\":\"test@email.com\",\"type\":\"doku_indomaret\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        DokuDetails dokuDetails = new DokuDetails();
        dokuDetails.setFirstName("John");
        dokuDetails.setInfix("infix");
        dokuDetails.setLastName("Smith");
        dokuDetails.setOvoId("ovoid");
        dokuDetails.setShopperEmail("test@email.com");
        dokuDetails.setType(DokuDetails.INDOMARET);
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(dokuDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestAmazonPayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"amazonPayToken\":\"amazonpaytoken\",\"type\":\"amazonpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        AmazonPayDetails amazonPayDetails = new AmazonPayDetails();
        amazonPayDetails.setAmazonPayToken("amazonpaytoken");

        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(amazonPayDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestAmazonPayDetailsDeserializer() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"amazonPayToken\":\"amazonpaytoken\",\"type\":\"amazonpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        AmazonPayDetails amazonPayDetails = new AmazonPayDetails();
        amazonPayDetails.setAmazonPayToken("amazonpaytoken");
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(amazonPayDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);

    }

    @Test
    public void TestApplePayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"applePayToken\":\"applepaytoken\",\"fundingSource\":\"credit\",\"type\":\"applepay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        ApplePayDetails applePayDetails = new ApplePayDetails();
        applePayDetails.setApplePayToken("applepaytoken");
        applePayDetails.setFundingSource(ApplePayDetails.FundingSourceEnum.CREDIT);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(applePayDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestApplePayDetailsDeserializer() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"applePayToken\":\"applepaytoken\",\"fundingSource\":\"credit\",\"type\":\"applepay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        ApplePayDetails applePayDetails = new ApplePayDetails();
        applePayDetails.setApplePayToken("applepaytoken");
        applePayDetails.setFundingSource(ApplePayDetails.FundingSourceEnum.CREDIT);
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(applePayDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestBillDeskOnlineDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"billdesk_online\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        BillDeskOnlineDetails billdeskOnlineDetails = new BillDeskOnlineDetails();
        billdeskOnlineDetails.setIssuer("111");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(billdeskOnlineDetails);

        String gsonRequest = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gsonRequest);

        String jacksonRequest = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jacksonRequest);
    }

    @Test
    public void TestBillDeskOnlineDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"billdesk_online\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        BillDeskOnlineDetails billdeskOnlineDetails = new BillDeskOnlineDetails();
        billdeskOnlineDetails.setIssuer("111");
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(billdeskOnlineDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestBacsDirectDebitDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"GBP\"},\"merchantAccount\":\"TestMerchant\",\"paymentMethod\":{\"type\":\"directdebit_GB\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        BacsDirectDebitDetails bacsDirectDebitDetails = new BacsDirectDebitDetails();
        PaymentRequest PaymentRequest = createBacsDirectDebitDetails();
        PaymentRequest.setPaymentMethod(bacsDirectDebitDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestBacsDirectDebitDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"GBP\"},\"merchantAccount\":\"TestMerchant\",\"paymentMethod\":{\"type\":\"directdebit_GB\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        BacsDirectDebitDetails bacsDirectDebitDetails = new BacsDirectDebitDetails();
        PaymentRequest expectedPaymentRequest = createBacsDirectDebitDetails();
        expectedPaymentRequest.setPaymentMethod(bacsDirectDebitDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestBilldeskWalletDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"billdesk_wallet\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        BillDeskWalletDetails billdeskWalletDetails = new BillDeskWalletDetails();
        billdeskWalletDetails.setIssuer("111");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(billdeskWalletDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestBillDeskWalletDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"billdesk_wallet\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
        BillDeskWalletDetails billdeskWalletDetails = new BillDeskWalletDetails();
        billdeskWalletDetails.setIssuer("111");
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(billdeskWalletDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestDotpayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"dotpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        DotpayDetails dotpayDetails = new DotpayDetails();
        dotpayDetails.setIssuer("111");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(dotpayDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestDotpayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"dotpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
        DotpayDetails dotpayDetails = new DotpayDetails();
        dotpayDetails.setIssuer("111");
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(dotpayDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestEntercashDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"entercash\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        EntercashDetails entercashDetails = new EntercashDetails();
        entercashDetails.setIssuer("111");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(entercashDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestEntercashDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"entercash\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        EntercashDetails entercashDetails = new EntercashDetails();
        entercashDetails.setIssuer("111");
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(entercashDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestGenericIssuerPaymentMethodDetails() {
        GenericIssuerPaymentMethodDetails genericIssuerPaymentMethodDetails = new GenericIssuerPaymentMethodDetails();
        genericIssuerPaymentMethodDetails.setIssuer("111");
        genericIssuerPaymentMethodDetails.setType("ideal");

        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(genericIssuerPaymentMethodDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(PaymentRequest);
        assertJsonStringEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"issuer\": \"111\",\n"
                + "    \"type\": \"ideal\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}", jsonRequest);
    }

    @Test
    public void TestGiropayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"giropay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        GiropayDetails giropayDetails = new GiropayDetails();
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(giropayDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestGiropayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"giropay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        GiropayDetails giropayDetails = new GiropayDetails();
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(giropayDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestQiwiWalletDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"telephoneNumber\":\"123456789\",\"type\":\"qiwiwallet\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        QiwiWalletDetails qiwiWalletDetails = new QiwiWalletDetails();
        qiwiWalletDetails.setTelephoneNumber("123456789");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(qiwiWalletDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestQiwiWalletDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"telephoneNumber\":\"123456789\",\"type\":\"qiwiwallet\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        QiwiWalletDetails qiwiWalletDetails = new QiwiWalletDetails();
        qiwiWalletDetails.setTelephoneNumber("123456789");
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(qiwiWalletDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestSamsungPayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"debit\",\"samsungPayToken\":\"samsungpaytoken\",\"type\":\"samsungpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        SamsungPayDetails samsungPayDetails = new SamsungPayDetails();
        samsungPayDetails.setFundingSource(SamsungPayDetails.FundingSourceEnum.DEBIT);
        samsungPayDetails.setSamsungPayToken("samsungpaytoken");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(samsungPayDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestSamsungPayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"debit\",\"samsungPayToken\":\"samsungpaytoken\",\"type\":\"samsungpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        SamsungPayDetails samsungPayDetails = new SamsungPayDetails();
        samsungPayDetails.setFundingSource(SamsungPayDetails.FundingSourceEnum.DEBIT);
        samsungPayDetails.setSamsungPayToken("samsungpaytoken");
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(samsungPayDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestVippsDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"telephoneNumber\":\"123456789\",\"type\":\"vipps\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        VippsDetails vippsDetails = new VippsDetails();
        vippsDetails.setTelephoneNumber("123456789");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(vippsDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestVippsDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"telephoneNumber\":\"123456789\",\"type\":\"vipps\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        VippsDetails vippsDetails = new VippsDetails();
        vippsDetails.setTelephoneNumber("123456789");
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(vippsDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestVisaCheckoutDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"type\":\"visacheckout\",\"visaCheckoutCallId\":\"visacheckoutcallid\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        VisaCheckoutDetails visaCheckoutDetails = new VisaCheckoutDetails();
        visaCheckoutDetails.setFundingSource(VisaCheckoutDetails.FundingSourceEnum.CREDIT);
        visaCheckoutDetails.setVisaCheckoutCallId("visacheckoutcallid");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(visaCheckoutDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestVisaCheckoutDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"type\":\"visacheckout\",\"visaCheckoutCallId\":\"visacheckoutcallid\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        VisaCheckoutDetails visaCheckoutDetails = new VisaCheckoutDetails();
        visaCheckoutDetails.setFundingSource(VisaCheckoutDetails.FundingSourceEnum.CREDIT);
        visaCheckoutDetails.setVisaCheckoutCallId("visacheckoutcallid");
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(visaCheckoutDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestRecurringPaymentMethodDetails() {
        StoredPaymentMethodDetails storedPaymentMethodDetails = new StoredPaymentMethodDetails();
        storedPaymentMethodDetails.setStoredPaymentMethodId("testStoredPaymentMethodId");

        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(storedPaymentMethodDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(PaymentRequest);

        assertJsonStringEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"storedPaymentMethodId\": \"testStoredPaymentMethodId\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}", jsonRequest);
    }

    @Test
    public void TestShopperNotificationReferencePaymentMethodDetails() {
        CardDetails cardDetails = new CardDetails();
        cardDetails.setShopperNotificationReference("IA0F7500002462");

        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(cardDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(PaymentRequest);

        assertJsonStringEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"shopperNotificationReference\": \"IA0F7500002462\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}", jsonRequest);
    }

    @Test
    public void TestAndroidPayDetails() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"androidpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        AndroidPayDetails androidPayDetails = new AndroidPayDetails();
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(androidPayDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestAndroidPayDetailsDeserializer() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"androidpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        AndroidPayDetails androidPayDetails = new AndroidPayDetails();
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(androidPayDetails);

        PaymentRequest gson = PRETTY_PRINT_GSON.fromJson(json, PaymentRequest.class);
        PaymentRequest jackson = OBJECT_MAPPER.readValue(json, PaymentRequest.class);

        assertEquals(expectedPaymentRequest, gson);
        assertEquals(expectedPaymentRequest, jackson);
    }

    @Test
    public void TestKlarnaDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"billingAddress\":\"billingaddress\",\"deliveryAddress\":\"deliveryaddress\",\"personalDetails\":\"personaldetails\",\"recurringDetailReference\":\"reference\",\"storedPaymentMethodId\":\"storedpaymentmethodid\",\"type\":\"klarna\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        KlarnaDetails klarnaDetails = new KlarnaDetails();
        klarnaDetails.setBillingAddress("billingaddress");
        klarnaDetails.setDeliveryAddress("deliveryaddress");
        klarnaDetails.setPersonalDetails("personaldetails");
        klarnaDetails.setStoredPaymentMethodId("storedpaymentmethodid");
        klarnaDetails.setRecurringDetailReference("reference");
        klarnaDetails.setType(KlarnaDetails.KLARNA);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(klarnaDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestKlarnaDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"billingAddress\":\"billingaddress\",\"deliveryAddress\":\"deliveryaddress\",\"personalDetails\":\"personaldetails\",\"recurringDetailReference\":\"reference\",\"storedPaymentMethodId\":\"storedpaymentmethodid\",\"type\":\"klarna\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        KlarnaDetails klarnaDetails = new KlarnaDetails();
        klarnaDetails.setRecurringDetailReference("reference");
        klarnaDetails.setBillingAddress("billingaddress");
        klarnaDetails.setDeliveryAddress("deliveryaddress");
        klarnaDetails.setPersonalDetails("personaldetails");
        klarnaDetails.setStoredPaymentMethodId("storedpaymentmethodid");
        klarnaDetails.setType(KlarnaDetails.KLARNA);
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(klarnaDetails);

        PaymentRequest gson = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gson);

        PaymentRequest jackson = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jackson);
    }

    @Test
    public void TestMasterPassDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"masterpassTransactionId\":\"transactionId\",\"type\":\"masterpass\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MasterpassDetails masterpassDetails = new MasterpassDetails();
        masterpassDetails.setFundingSource(MasterpassDetails.FundingSourceEnum.CREDIT);
        masterpassDetails.setMasterpassTransactionId("transactionId");

        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(masterpassDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestMasterPassDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"masterpassTransactionId\":\"transactionId\",\"type\":\"masterpass\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MasterpassDetails masterpassDetails = new MasterpassDetails();
        masterpassDetails.setFundingSource(MasterpassDetails.FundingSourceEnum.CREDIT);
        masterpassDetails.setMasterpassTransactionId("transactionId");
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(masterpassDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestMobilePayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"mobilepay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MobilePayDetails mobilePayDetails = new MobilePayDetails();
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(mobilePayDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestMobilePayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"mobilepay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MobilePayDetails mobilePayDetails = new MobilePayDetails();
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(mobilePayDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestPayUUpiDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"payu_IN_upi\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        PayUUpiDetails payUUpiDetails = new PayUUpiDetails();
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(payUUpiDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestPayUUpiDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"payu_IN_upi\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        PayUUpiDetails payUUpiDetails = new PayUUpiDetails();
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(payUUpiDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestPayUpiIntentDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"upi_intent\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        UpiIntentDetails upiIntentDetails = new UpiIntentDetails();
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(upiIntentDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestPayUpiIntentDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"upi_intent\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        UpiIntentDetails upiIntentDetails = new UpiIntentDetails();
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(upiIntentDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestPayUpiCollectDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"upi_collect\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        UpiCollectDetails upiCollectDetails = new UpiCollectDetails();
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(upiCollectDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestPayUpiCollectDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"upi_collect\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        UpiCollectDetails upiCollectDetails = new UpiCollectDetails();
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(upiCollectDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestWeChatPayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"appId\":\"appId\",\"openid\":\"openId\",\"type\":\"wechatpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        WeChatPayDetails weChatPayDetails = new WeChatPayDetails();
        weChatPayDetails.setAppId("appId");
        weChatPayDetails.setOpenid("openId");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(weChatPayDetails);
        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestWeChatPayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"appId\":\"appId\",\"openid\":\"openId\",\"type\":\"wechatpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        WeChatPayDetails weChatPayDetails = new WeChatPayDetails();
        weChatPayDetails.setAppId("appId");
        weChatPayDetails.setOpenid("openId");
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(weChatPayDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestWeChatPayMiniProgramDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"appId\":\"appId\",\"openid\":\"openId\",\"type\":\"wechatpayMiniProgram\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        WeChatPayMiniProgramDetails weChatPayMiniProgramDetails = new WeChatPayMiniProgramDetails();
        weChatPayMiniProgramDetails.setAppId("appId");
        weChatPayMiniProgramDetails.setOpenid("openId");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(weChatPayMiniProgramDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestWeChatPayMiniProgramDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"appId\":\"appId\",\"openid\":\"openId\",\"type\":\"wechatpayMiniProgram\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        WeChatPayMiniProgramDetails weChatPayMiniProgramDetails = new WeChatPayMiniProgramDetails();
        weChatPayMiniProgramDetails.setAppId("appId");
        weChatPayMiniProgramDetails.setOpenid("openId");
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(weChatPayMiniProgramDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestBlikDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"blikCode\":\"blikCode\",\"type\":\"blik\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        BlikDetails blikDetails = new BlikDetails();
        blikDetails.setBlikCode("blikCode");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(blikDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestBlikDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"blikCode\":\"blikCode\",\"type\":\"blik\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        BlikDetails blikDetails = new BlikDetails();
        blikDetails.setBlikCode("blikCode");
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(blikDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestDragonpayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"issuer\",\"shopperEmail\":\"test@test.com\",\"type\":\"dragonpay_ebanking\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        DragonpayDetails dragonPayDetails = new DragonpayDetails();
        dragonPayDetails.setIssuer("issuer");
        dragonPayDetails.setShopperEmail("test@test.com");
        dragonPayDetails.setType(DragonpayDetails.EBANKING);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(dragonPayDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestDragonpayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"issuer\",\"shopperEmail\":\"test@test.com\",\"type\":\"dragonpay_ebanking\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        DragonpayDetails dragonPayDetails = new DragonpayDetails();
        dragonPayDetails.setIssuer("issuer");
        dragonPayDetails.setShopperEmail("test@test.com");
        dragonPayDetails.setType(DragonpayDetails.EBANKING);
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(dragonPayDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestLianLianPayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"telephoneNumber\":\"telephone\",\"type\":\"lianlianpay_ebanking_credit\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        LianLianPayDetails lianLianPayDetails = new LianLianPayDetails();
        lianLianPayDetails.setTelephoneNumber("telephone");
        lianLianPayDetails.setType(LianLianPayDetails.EBANKING_CREDIT);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(lianLianPayDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestLianLianPayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"telephoneNumber\":\"telephone\",\"type\":\"lianlianpay_ebanking_credit\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        LianLianPayDetails lianLianPayDetails = new LianLianPayDetails();
        lianLianPayDetails.setTelephoneNumber("telephone");
        lianLianPayDetails.setType(LianLianPayDetails.EBANKING_CREDIT);
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(lianLianPayDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestMbwayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"shopperEmail\":\"test@test.com\",\"telephoneNumber\":\"telephone\",\"type\":\"mbway\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MbwayDetails mbwayDetails = new MbwayDetails();
        mbwayDetails.setTelephoneNumber("telephone");
        mbwayDetails.setShopperEmail("test@test.com");
        mbwayDetails.setType(MbwayDetails.MBWAY);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(mbwayDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestMbwayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"shopperEmail\":\"test@test.com\",\"telephoneNumber\":\"telephone\",\"type\":\"mbway\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MbwayDetails mbwayDetails = new MbwayDetails();
        mbwayDetails.setTelephoneNumber("telephone");
        mbwayDetails.setShopperEmail("test@test.com");
        mbwayDetails.setType(MbwayDetails.MBWAY);
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(mbwayDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestMolPayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"issuer\",\"type\":\"molpay_ebanking_direct_MY\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MolPayDetails molPayDetails = new MolPayDetails();
        molPayDetails.setIssuer("issuer");
        molPayDetails.setType(MolPayDetails.EBANKING_DIRECT_MY);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(molPayDetails);

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestMolPayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"issuer\",\"type\":\"molpay_ebanking_direct_MY\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MolPayDetails molPayDetails = new MolPayDetails();
        molPayDetails.setIssuer("issuer");
        molPayDetails.setType(MolPayDetails.EBANKING_DIRECT_MY);
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(molPayDetails);

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestDateSerializers() throws ParseException {
        PaymentRequest PaymentRequest = new PaymentRequest();

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        fmt.setTimeZone(TimeZone.getTimeZone("GMT"));

        Date d = fmt.parse("2018-10-31");
        PaymentRequest.setDateOfBirth(d);
        PaymentRequest.setDeliveryDate(d);
        String jsonRequest = PRETTY_PRINT_GSON.toJson(PaymentRequest);
        assertJsonStringEquals("{\n"
                + "  \"dateOfBirth\": \"2018-10-31\",\n"
                + "  \"deliveryDate\": \"2018-10-31T00:00:00.000Z\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}", jsonRequest);
    }

    @Test
    public void TestRecurringProcessingModels() {
        PaymentRequest PaymentRequest = new PaymentRequest();
        PaymentRequest.setRecurringProcessingModel(PaymentRequest.RecurringProcessingModelEnum.CARDONFILE);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(PaymentRequest);
        assertTrue(jsonRequest.contains("recurringProcessingModel\": \"CardOnFile\"\n") || jsonRequest.contains("recurringProcessingModel\": \"CardOnFile\",\n"));

        PaymentRequest.setRecurringProcessingModel(PaymentRequest.RecurringProcessingModelEnum.SUBSCRIPTION);
        jsonRequest = PRETTY_PRINT_GSON.toJson(PaymentRequest);
        assertTrue(jsonRequest.contains("recurringProcessingModel\": \"Subscription\"\n") || jsonRequest.contains("recurringProcessingModel\": \"Subscription\",\n"));

        PaymentRequest.setRecurringProcessingModel(PaymentRequest.RecurringProcessingModelEnum.UNSCHEDULEDCARDONFILE);
        jsonRequest = PRETTY_PRINT_GSON.toJson(PaymentRequest);
        assertTrue(jsonRequest.contains("recurringProcessingModel\": \"UnscheduledCardOnFile\"\n") || jsonRequest.contains("recurringProcessingModel\": \"UnscheduledCardOnFile\",\n"));
    }

    @Test
    public void TestPaymentResponseDate() {
        PaymentResponse PaymentResponse = new PaymentResponse();
        try {
            Date expiryDate = PaymentResponse.getExpiryDate();
            Assert.assertNull(expiryDate);
        } catch (Exception ex) {

            Assert.fail("multibanco date throw Exception");
        }
    }

    @Test
    public void TestPaymentResponseChallengeShopper() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-3ds2-challenge-shopper.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentResponse PaymentResponse = checkout.payments(PaymentRequest);
        assertEquals(PaymentResponse.ResultCodeEnum.CHALLENGESHOPPER, PaymentResponse.getResultCode());
        assertNotNull(PaymentResponse.getAction());
        assertNotNull(PaymentResponse.getAction().getData());
        assertEquals(3, PaymentResponse.getAction().getData().size());
        assertEquals("POST", PaymentResponse.getAction().getMethod());
        assertEquals("Ab02b4c0!BQABAgA4e3wGkhVah4CJL19qdegdmm9E...", PaymentResponse.getAction().getPaymentData());
        assertEquals("scheme", PaymentResponse.getAction().getPaymentMethodType());
        assertEquals("https://test.adyen.com/hpp/3d/validate.shtml", PaymentResponse.getAction().getUrl());
        assertEquals(CheckoutPaymentsAction.CheckoutActionType.REDIRECT, PaymentResponse.getAction().getType());
    }

    @Test
    public void TestPaymentResponseAuthenticationFinished() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-3ds2-authentication-finished.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentResponse PaymentResponse = checkout.payments(PaymentRequest);
        assertEquals(PaymentResponse.ResultCodeEnum.AUTHENTICATIONFINISHED, PaymentResponse.getResultCode());
        assertNotNull(PaymentResponse.getThreeDS2Result());
        assertNotNull(PaymentResponse.getThreeDS2Result().getAuthenticationValue());
        assertNotNull(PaymentResponse.getThreeDS2Result().getDsTransID());
        assertNotNull(PaymentResponse.getThreeDS2Result().getEci());
        assertNotNull(PaymentResponse.getThreeDS2Result().getMessageVersion());
        assertNotNull(PaymentResponse.getThreeDS2Result().getThreeDSServerTransID());
        assertNotNull(PaymentResponse.getThreeDS2Result().getTransStatus());
    }

    /**
     * Test ApiException flow for POST
     */
    @Test
    public void TestApiExceptionErrorMocked() throws Exception {
        Client client = createMockClientForErrors(422, "mocks/checkout/payments-error-invalid-data-422.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        try {
            checkout.payments(PaymentRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals("130", e.getError().getErrorCode());
            assertEquals(422, e.getError().getStatus());
            assertEquals(e.getResponseHeaders().size(), 0);
            assertNotNull(e.getResponseHeaders());
        }
    }

    /**
     * Test Payments flow for with Network tokenization
     */
    @Test
    public void TestPaymentsNetworkSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-network-success.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest PaymentRequest = createPaymentsNetworkCheckoutRequest();
        PaymentResponse PaymentResponse = checkout.payments(PaymentRequest);
        assertEquals("MCC123456789012", PaymentResponse.getAdditionalData().get("networkTxReference"));
        assertEquals("8535296650153317", PaymentResponse.getPspReference());
    }

    /**
     * Test RiskData inside /payments
     */
    @Test
    public void TestRiskDataInRequest() {
        RiskData riskData = new RiskData();
        riskData.setClientData("IOfW3k9G2PvXFu2j");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setRiskData(riskData);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(PaymentRequest);
        assertTrue(jsonRequest.contains("riskData"));
        assertTrue(jsonRequest.contains("clientData\": \"IOfW3k9G2PvXFu2j\"\n"));
    }

    @Test
    public void TestOrdersSuccess() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/checkout/orders-success.json");
        Checkout checkout = new Checkout(client);
        CheckoutCreateOrderRequest checkoutCreateOrderRequest = createCheckoutCreateOrderRequest();
        CheckoutCreateOrderResponse checkoutCreateOrderResponse = checkout.orders(checkoutCreateOrderRequest);
        assertEquals("2020-06-25T20:01:07Z", checkoutCreateOrderResponse.getExpiresAt());
        assertEquals("8515930288670953", checkoutCreateOrderResponse.getPspReference());
        assertEquals(CheckoutCreateOrderResponse.ResultCodeEnum.SUCCESS, checkoutCreateOrderResponse.getResultCode());
        assertEquals("Ab02b4c0!BQABAgBqxSuFhuXUF7IvIRvSw5bDPHN...", checkoutCreateOrderResponse.getOrderData());
        assertEquals("order reference", checkoutCreateOrderResponse.getReference());
        assertEquals("EUR", checkoutCreateOrderResponse.getRemainingAmount().getCurrency());
        assertEquals((Long) 2500L, checkoutCreateOrderResponse.getRemainingAmount().getValue());
    }

    @Test
    public void TestPaymentsWithOrderSuccess() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/checkout/payments-success-order.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest PaymentRequest = createPaymentRequestWithOrder();
        PaymentResponse PaymentResponse = checkout.payments(PaymentRequest);
        assertEquals("payment reference", PaymentResponse.getMerchantReference());
        assertEquals("881593078164515C", PaymentResponse.getPspReference());
        assertEquals(PaymentResponse.ResultCodeEnum.AUTHORISED, PaymentResponse.getResultCode());
        assertEquals("EUR", PaymentResponse.getAmount().getCurrency());
        assertEquals((Long) 1000L, PaymentResponse.getAmount().getValue());
        assertEquals("Ab02b4c0!BQABAgBqxSuFhuXUF7IvIRvSw5bDPHN...", PaymentResponse.getOrder().getOrderData());
        assertEquals("order reference", PaymentResponse.getOrder().getReference());
        assertEquals("8515930288670953", PaymentResponse.getOrder().getPspReference());
        assertEquals("2020-06-25T20:01:07Z", PaymentResponse.getOrder().getExpiresAt());
        assertEquals("EUR", PaymentResponse.getOrder().getRemainingAmount().getCurrency());
        assertEquals((Long) 1500L, PaymentResponse.getOrder().getRemainingAmount().getValue());
    }

    @Test
    public void TestOrdersCancelSuccess() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/checkout/orders-cancel-success.json");
        Checkout checkout = new Checkout(client);
        CheckoutCancelOrderRequest checkoutCancelOrderRequest = createCheckoutCancelOrderRequest();
        CheckoutCancelOrderResponse checkoutCancelOrderResponse = checkout.ordersCancel(checkoutCancelOrderRequest);
        assertEquals("8515931182066678", checkoutCancelOrderResponse.getPspReference());
        assertEquals("Received", checkoutCancelOrderResponse.getResultCode());
    }

    @Test
    public void TestStoredPaymentMethods() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/checkout/paymentmethods-storedpaymentmethods.json");
        Checkout checkout = new Checkout(client);
        PaymentMethodsRequest paymentMethodsRequest = new PaymentMethodsRequest();
        paymentMethodsRequest.setMerchantAccount("MagentoMerchantTest");
        PaymentMethodsResponse paymentMethodsResponse = checkout.paymentMethods(paymentMethodsRequest);

        assertEquals(4, paymentMethodsResponse.getStoredPaymentMethods().size());
        assertEquals("NL32ABNA0515071439", paymentMethodsResponse.getStoredPaymentMethods().get(0).getIban());
        assertEquals("Adyen", paymentMethodsResponse.getStoredPaymentMethods().get(0).getOwnerName());
        assertEquals("sepadirectdebit", paymentMethodsResponse.getStoredPaymentMethods().get(0).getType());
    }

    @Test
    public void TestPaymentResponseIdentifyShopper() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/checkout/payments-3ds2-identify-shopper.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentResponse PaymentResponse = checkout.payments(PaymentRequest);
        assertEquals(PaymentResponse.ResultCodeEnum.IDENTIFYSHOPPER, PaymentResponse.getResultCode());
        assertEquals(CheckoutPaymentsAction.CheckoutActionType.THREEDS2, PaymentResponse.getAction().getType());
        assertEquals("fingerprint", PaymentResponse.getAction().getSubtype());
        assertEquals("scheme", PaymentResponse.getAction().getPaymentMethodType());
    }

    /**
     * Start modifications endpoints tests
     */
    @Test public void TestPaymentsCaptures() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/checkout/captures-success.json");
        Checkout checkout = new Checkout(client);
        CreatePaymentCaptureRequest createPaymentCaptureRequest = new CreatePaymentCaptureRequest();
        createPaymentCaptureRequest.setAmount(createAmountObject("EUR", 1000L));
        createPaymentCaptureRequest.setMerchantAccount("test_merchant_account");
        PaymentCaptureResource paymentCaptureResource = checkout.paymentsCaptures("12321A", createPaymentCaptureRequest);
        assertEquals("received", paymentCaptureResource.getStatus().toString());
        assertEquals("my_reference", paymentCaptureResource.getReference());
    }

    @Test public void TestPaymentsCapturesFailed() throws IOException, ApiException {
        Client client = createMockClientForErrors(422, "mocks/checkout/modifications-error-422.json");
        try {
            Checkout checkout = new Checkout(client);
            CreatePaymentCaptureRequest createPaymentCaptureRequest = new CreatePaymentCaptureRequest();
            createPaymentCaptureRequest.setAmount(createAmountObject("EUR", 1000L));
            createPaymentCaptureRequest.setMerchantAccount("test_merchant_account");
            PaymentCaptureResource paymentCaptureResource = checkout.paymentsCaptures("12321A", createPaymentCaptureRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals("167", e.getError().getErrorCode());
            assertEquals(422, e.getError().getStatus());
            assertEquals(e.getResponseHeaders().size(), 0);
            assertNotNull(e.getResponseHeaders());
        }
    }

    @Test public void TestPaymentsCancels() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/checkout/cancels-success.json");
        Checkout checkout = new Checkout(client);
        CreatePaymentCancelRequest createPaymentCancelRequest = new CreatePaymentCancelRequest();
        createPaymentCancelRequest.setMerchantAccount("test_merchant_account");
        PaymentCancelResource paymentCancelResource = checkout.paymentsCancels("12321A", createPaymentCancelRequest);
        assertEquals("received", paymentCancelResource.getStatus().toString());
        assertEquals("my_reference", paymentCancelResource.getReference());
    }

    @Test public void TestPaymentsCancelsFailed() throws IOException, ApiException {
        try {
            Client client = createMockClientForErrors(422, "mocks/checkout/modifications-error-422.json");
            Checkout checkout = new Checkout(client);
            CreatePaymentCancelRequest createPaymentCancelRequest = new CreatePaymentCancelRequest();
            createPaymentCancelRequest.setMerchantAccount("test_merchant_account");
            checkout.paymentsCancels("12321A", createPaymentCancelRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals("167", e.getError().getErrorCode());
            assertEquals(422, e.getError().getStatus());
            assertEquals(e.getResponseHeaders().size(), 0);
            assertNotNull(e.getResponseHeaders());
        }
    }

    @Test public void TestCancels() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/checkout/standalone-cancels-success.json");
        Checkout checkout = new Checkout(client);
        CreateStandalonePaymentCancelRequest createStandalonePaymentCancelRequest = new CreateStandalonePaymentCancelRequest();
        createStandalonePaymentCancelRequest.setMerchantAccount("test_merchant_account");
        StandalonePaymentCancelResource standalonePaymentCancelResource = checkout.cancels(createStandalonePaymentCancelRequest);
        assertEquals("received", standalonePaymentCancelResource.getStatus().toString());
        assertEquals("861633338418518C", standalonePaymentCancelResource.getPspReference());
    }
    @Test public void TestCancelsFailed() throws IOException, ApiException {
        try {
            Client client = createMockClientForErrors(422, "mocks/checkout/modifications-error-422.json");
            Checkout checkout = new Checkout(client);
            CreateStandalonePaymentCancelRequest createStandalonePaymentCancelRequest = new CreateStandalonePaymentCancelRequest();
            createStandalonePaymentCancelRequest.setMerchantAccount("test_merchant_account");
            checkout.cancels(createStandalonePaymentCancelRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals("167", e.getError().getErrorCode());
            assertEquals(422, e.getError().getStatus());
            assertEquals(e.getResponseHeaders().size(), 0);
            assertNotNull(e.getResponseHeaders());
        }
    }

    @Test public void TestPaymentsRefunds() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/checkout/refunds-success.json");
        Checkout checkout = new Checkout(client);
        CreatePaymentRefundRequest createPaymentRefundRequest = new CreatePaymentRefundRequest();
        createPaymentRefundRequest.setAmount(createAmountObject("EUR", 1000L));
        createPaymentRefundRequest.setMerchantAccount("test_merchant_account");
        PaymentRefundResource paymentRefundResource = checkout.paymentsRefunds("12321A", createPaymentRefundRequest);
        assertEquals("received", paymentRefundResource.getStatus().toString());
        assertEquals("my_reference", paymentRefundResource.getReference());
    }

    @Test public void TestPaymentsRefundsFailed() throws IOException, ApiException {
        try {
            Client client = createMockClientForErrors(422, "mocks/checkout/modifications-error-422.json");
            Checkout checkout = new Checkout(client);
            CreatePaymentRefundRequest createPaymentRefundRequest = new CreatePaymentRefundRequest();
            createPaymentRefundRequest.setAmount(createAmountObject("EUR", 1000L));
            createPaymentRefundRequest.setMerchantAccount("test_merchant_account");
            checkout.paymentsRefunds("12321A", createPaymentRefundRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals("167", e.getError().getErrorCode());
            assertEquals(422, e.getError().getStatus());
            assertEquals(e.getResponseHeaders().size(), 0);
            assertNotNull(e.getResponseHeaders());
        }
    }

    @Test public void TestPaymentsReversals() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/checkout/reversals-success.json");
        Checkout checkout = new Checkout(client);
        CreatePaymentReversalRequest createPaymentReversalRequest = new CreatePaymentReversalRequest();
        createPaymentReversalRequest.setMerchantAccount("test_merchant_account");
        PaymentReversalResource paymentReversalResource = checkout.paymentsReversals("12321A", createPaymentReversalRequest);
        assertEquals("received", paymentReversalResource.getStatus().toString());
        assertEquals("my_reference", paymentReversalResource.getReference());
    }

    @Test public void TestPaymentsReversalsFailed() throws IOException, ApiException {
        try {
            Client client = createMockClientForErrors(422, "mocks/checkout/modifications-error-422.json");
            Checkout checkout = new Checkout(client);
            CreatePaymentReversalRequest createPaymentReversalRequest = new CreatePaymentReversalRequest();
            createPaymentReversalRequest.setMerchantAccount("test_merchant_account");
            checkout.paymentsReversals("12321A", createPaymentReversalRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals("167", e.getError().getErrorCode());
            assertEquals(422, e.getError().getStatus());
            assertEquals(e.getResponseHeaders().size(), 0);
            assertNotNull(e.getResponseHeaders());
        }
    }

    @Test public void TestPaymentsAmountUpdates() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/checkout/amount-updates-success.json");
        Checkout checkout = new Checkout(client);
        CreatePaymentAmountUpdateRequest createPaymentAmountUpdateRequest = new CreatePaymentAmountUpdateRequest();
        createPaymentAmountUpdateRequest.setAmount(createAmountObject("EUR", 1000L));
        createPaymentAmountUpdateRequest.setMerchantAccount("test_merchant_account");
        PaymentAmountUpdateResource paymentAmountUpdateResource = checkout.paymentsAmountUpdates("12321A", createPaymentAmountUpdateRequest);
        assertEquals("received", paymentAmountUpdateResource.getStatus().toString());
        assertEquals("my_reference", paymentAmountUpdateResource.getReference());
    }

    @Test public void TestPaymentsAmountUpdatesFailed() throws IOException, ApiException {
        try {
            Client client = createMockClientForErrors(422, "mocks/checkout/modifications-error-422.json");
            Checkout checkout = new Checkout(client);
            CreatePaymentAmountUpdateRequest createPaymentAmountUpdateRequest = new CreatePaymentAmountUpdateRequest();
            createPaymentAmountUpdateRequest.setAmount(createAmountObject("EUR", 1000L));
            createPaymentAmountUpdateRequest.setMerchantAccount("test_merchant_account");
            checkout.paymentsAmountUpdates("12321A", createPaymentAmountUpdateRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals("167", e.getError().getErrorCode());
            assertEquals(422, e.getError().getStatus());
            assertEquals(e.getResponseHeaders().size(), 0);
            assertNotNull(e.getResponseHeaders());
        }
    }

    /**
     * end modification endpoints tests
     */

    /**
     * Returns a sample PaymentSessionRequest object with test data
     */

    protected PaymentSessionRequest createPaymentSessionRequest() {
        PaymentSessionRequest paymentSessionRequest = new PaymentSessionRequest();
        paymentSessionRequest.setAmount(createAmountObject("USD", 1000L));
        paymentSessionRequest.setReference("Your order number");
        paymentSessionRequest.setCountryCode("NL");
        paymentSessionRequest.setReturnUrl("https://your-company.com/...");
        paymentSessionRequest.setMerchantAccount("MagentoMerchantTest");
        return paymentSessionRequest;

    }

    /**
     * Returns a sample PaymentRequest object with test data
     */
    protected PaymentRequest createPaymentsCheckoutRequest() {
        PaymentRequest PaymentRequest = new PaymentRequest();
        CardDetails details = new CardDetails();

        PaymentRequest.setReference("Your order number");
        PaymentRequest.setAmount(createAmountObject("USD", 1000L));

        details.setType("scheme");
        details.setEncryptedCardNumber("test_4111111111111111");
        details.setEncryptedExpiryMonth("test_10");
        details.setEncryptedExpiryYear("test_2030");
        details.setCvc("737");
        details.setHolderName("John Smith");

        PaymentRequest.setPaymentMethod(details);

        PaymentRequest.setReturnUrl("https://your-company.com/...");
        PaymentRequest.setMerchantAccount("MagentoMerchantTest");

        return PaymentRequest;
    }

    /**
     * Returns a sample PaymentRequest object with test data
     */
    protected PaymentRequest createBacsDirectDebitDetails() {
        PaymentRequest PaymentRequest = new PaymentRequest();

        PaymentRequest.setReference("Your order number");
        PaymentRequest.setAmount(createAmountObject("GBP", 1000L));

        PaymentRequest.setReturnUrl("https://your-company.com/...");
        PaymentRequest.setMerchantAccount("TestMerchant");

        return PaymentRequest;
    }

    protected PaymentRequest createEncryptedPaymentsCheckoutRequest() {
        PaymentRequest PaymentRequest = new PaymentRequest();
        CardDetails details = new CardDetails();

        PaymentRequest.setReference("Your order number");
        PaymentRequest.setAmount(createAmountObject("USD", 1000L));

        details.setType("scheme");
        details.setEncryptedCardNumber("test_4111111111111111");
        details.setEncryptedExpiryMonth("test_03");
        details.setEncryptedExpiryYear("test_2030");
        details.setCvc("737");
        details.setHolderName("John Smith");

        PaymentRequest.setPaymentMethod(details);
        PaymentRequest.setReturnUrl("https://your-company.com/...");
        PaymentRequest.setMerchantAccount("MagentoMerchantTest");

        return PaymentRequest;
    }

    protected PaymentRequest createEncryptedPaymentsCheckoutRequestWithoutHoldername() {
        PaymentRequest PaymentRequest = new PaymentRequest();
        CardDetails details = new CardDetails();

        PaymentRequest.setReference("Your order number");
        PaymentRequest.setAmount(createAmountObject("USD", 1000L));

        details.setType("scheme");
        details.setEncryptedCardNumber("test_4111111111111111");
        details.setEncryptedExpiryMonth("test_10");
        details.setEncryptedExpiryYear("test_2030");
        details.setCvc("737");
        details.setHolderName("John Smith");

        PaymentRequest.setReturnUrl("https://your-company.com/...");
        PaymentRequest.setMerchantAccount("MagentoMerchantTest");

        return PaymentRequest;
    }

    /**
     * Returns a sample PaymentRequest object with type networkToken and brand visa
     */
    protected PaymentRequest createPaymentsNetworkCheckoutRequest() {
        PaymentRequest PaymentRequest = new PaymentRequest();

        PaymentRequest.setReference("Your order number");
        PaymentRequest.setAmount(createAmountObject("USD", 1000L));
        CardDetails defaultPaymentMethodDetails = new CardDetails();
        defaultPaymentMethodDetails.setType("networkToken");
        defaultPaymentMethodDetails.setBrand(BrandCodes.MASTERCARD);
        defaultPaymentMethodDetails.setExpiryMonth("08");
        defaultPaymentMethodDetails.setExpiryYear("2020");
        defaultPaymentMethodDetails.setHolderName("CARDHOLDER_NAME");
        defaultPaymentMethodDetails.setNumber("5555444433331111");
        defaultPaymentMethodDetails.setNetworkPaymentReference("MCC123456789012");

        PaymentRequest.setPaymentMethod(defaultPaymentMethodDetails);

        PaymentRequest.setReturnUrl("https://your-company.com/...");
        PaymentRequest.setMerchantAccount("MagentoMerchantTest");
        PaymentRequest.setShopperReference("YOUR_SHOPPER_REFERENCE");
        PaymentRequest.setRecurringProcessingModel(PaymentRequest.RecurringProcessingModelEnum.CARDONFILE);

        return PaymentRequest;
    }


    /**
     * Returns a sample PaymentsDetailsRequest opbject with test data
     */

    protected PaymentsDetailsRequest createPaymentsDetailsRequest() {
        PaymentsDetailsRequest paymentsDetailsRequest = new PaymentsDetailsRequest();
        paymentsDetailsRequest.setPaymentData("Ab02b4c0!BQABAgCJN1wRZuGJmq8dMncmypvknj9s7l5Tj...");
        paymentsDetailsRequest.set3DRequestData("mdValue", "paResValue", "paymentDataValue");
        return paymentsDetailsRequest;
    }

    /**
     * Returns a sample Amount object with given currency and value
     */
    protected Amount createAmountObject(String currency, Long value) {
        Amount amount = new Amount();
        amount.setCurrency(currency);
        amount.setValue(value);
        return amount;
    }

    protected CreateStoredPaymentMethodRequest createStoredPaymentMethodsRequest() {
        StoringMethod storingMethod = new StoringMethod();
        storingMethod.setType("tokenconnect");
        storingMethod.setPushAccountReceipt("abc12391401941");
        storingMethod.setShopperIP("123");

        CreateStoredPaymentMethodRequest createStoredPaymentMethodRequest = new CreateStoredPaymentMethodRequest();
        createStoredPaymentMethodRequest.setMerchantAccount("TestMerchant");
        createStoredPaymentMethodRequest.setShopperReference("sh123412341234");
        createStoredPaymentMethodRequest.setStoringMethod(storingMethod);

        return createStoredPaymentMethodRequest;
    }

    protected CheckoutCreateOrderRequest createCheckoutCreateOrderRequest() {
        CheckoutCreateOrderRequest checkoutCreateOrderRequest = new CheckoutCreateOrderRequest();
        checkoutCreateOrderRequest.setAmount(createAmountObject("EUR", 2500L));
        checkoutCreateOrderRequest.setMerchantAccount("TestMerchant");
        checkoutCreateOrderRequest.setReference("order reference");
        return checkoutCreateOrderRequest;
    }

    protected PaymentRequest createPaymentRequestWithOrder() {
        PaymentRequest PaymentRequest = new PaymentRequest();
        CardDetails details = new CardDetails();
        PaymentRequest.setReference("payment reference");
        PaymentRequest.setAmount(createAmountObject("EUR", 1000L));

        details.setType("scheme");
        details.setEncryptedCardNumber("test_4111111111111111");
        details.setEncryptedExpiryMonth("test_10");
        details.setEncryptedExpiryYear("test_2030");
        details.setCvc("737");
        details.setHolderName("John Smith");
        PaymentRequest.setPaymentMethod(details);

        CheckoutOrder checkoutOrder = new CheckoutOrder();
        checkoutOrder.setOrderData("Ab02b4c0!BQABAgBqxSuFhuXUF7IvIRvSw5bDPHN...");
        checkoutOrder.setPspReference("8515930288670953");
        PaymentRequest.setOrder(checkoutOrder);

        PaymentRequest.setMerchantAccount("TestMerchant");
        return PaymentRequest;
    }

    protected CheckoutCancelOrderRequest createCheckoutCancelOrderRequest() {
        CheckoutCancelOrderRequest checkoutCancelOrderRequest = new CheckoutCancelOrderRequest();
        checkoutCancelOrderRequest.setMerchantAccount("TestMerchant");
        CheckoutOrder checkoutOrder = new CheckoutOrder();
        checkoutOrder.setPspReference("8515930288670953");
        checkoutOrder.setOrderData("Ab02b4c0!BQABAgBqxSuFhuXUF7IvIRvSw5bDPHN...");
        checkoutCancelOrderRequest.setOrder(checkoutOrder);
        return checkoutCancelOrderRequest;
    }

    protected PaymentRequest createBankTransferPaymentRequest() {
        PaymentRequest PaymentRequest = new PaymentRequest();
        PaymentRequest.setReference("payment reference");

        CardDetails defaultPaymentMethodDetails = new CardDetails();
        defaultPaymentMethodDetails.setType("sepadirectdebit");
        PaymentRequest.setPaymentMethod(defaultPaymentMethodDetails);

        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(10000L);
        PaymentRequest.setAmount(amount);

        List<Split> splits = new ArrayList<>();
        Split split = new Split();
        split.setType(Split.TypeEnum.MARKETPLACE);
        split.setAccount("1234567891234567");
        split.setReference("Wallet deposit");
        SplitAmount splitAmount = new SplitAmount();
        splitAmount.setCurrency("EUR");
        splitAmount.setValue(10000L);
        split.setAmount(splitAmount);
        splits.add(split);
        PaymentRequest.setSplits(splits);

        PaymentRequest.setCountryCode("NL");
        PaymentRequest.setReference("auth-banktransfer-split-12345");
        PaymentRequest.setMerchantAccount("merchantAccount");

        return PaymentRequest;
    }

    @Test
    public void TestPaymentMethodDetailsDirectDeserialization() throws JsonProcessingException {
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(new PaymentMethodDetailsTypeAdapter()).create();

        String json = "{\"type\": \"applepay\",\"applePayToken\": \"VNRWtuNlNEWkRCSm1xWndjMDFFbktkQU...\"}";

        PaymentMethodDetails gsonObject = gson.fromJson(json, PaymentMethodDetails.class);
        assertNotNull(gsonObject);
        assertTrue(gsonObject instanceof ApplePayDetails);
        assertEquals("VNRWtuNlNEWkRCSm1xWndjMDFFbktkQU...", ((ApplePayDetails) gsonObject).getApplePayToken());

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new SimpleModule().addDeserializer(PaymentMethodDetails.class, new PaymentMethodDetailsDeserializerJackson()));
        PaymentMethodDetails jacksonObject = objectMapper.readValue(json, PaymentMethodDetails.class);
        assertNotNull(jacksonObject);
        assertTrue(jacksonObject instanceof ApplePayDetails);
        assertEquals("VNRWtuNlNEWkRCSm1xWndjMDFFbktkQU...", ((ApplePayDetails) jacksonObject).getApplePayToken());
    }

    @Test
    public void TestPaymentMethodDetailsDirectDeserializationIndianBanking() throws JsonProcessingException {
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(new PaymentMethodDetailsTypeAdapter()).create();

        String json = "{\"type\": \"wallet_IN\",\"issuer\": \"CBI\"}";

        PaymentMethodDetails gsonObject = gson.fromJson(json, PaymentMethodDetails.class);
        assertNotNull(gsonObject);
        assertTrue(gsonObject instanceof GenericIssuerPaymentMethodDetails);
        assertEquals("CBI", ((GenericIssuerPaymentMethodDetails) gsonObject).getIssuer());

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new SimpleModule().addDeserializer(PaymentMethodDetails.class, new PaymentMethodDetailsDeserializerJackson()));
        PaymentMethodDetails jacksonObject = objectMapper.readValue(json, PaymentMethodDetails.class);
        assertNotNull(jacksonObject);
        assertTrue(jacksonObject instanceof GenericIssuerPaymentMethodDetails);
        assertEquals("CBI", ((GenericIssuerPaymentMethodDetails) jacksonObject).getIssuer());
    }

    @Test
    public void TestBankTransferPaymentsSuccess() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/checkout/payments-banktransfer-success.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest PaymentRequest = createBankTransferPaymentRequest();
        PaymentResponse PaymentResponse = checkout.payments(PaymentRequest);
        assertEquals(PaymentResponse.ResultCodeEnum.RECEIVED, PaymentResponse.getResultCode());
        assertEquals(CheckoutPaymentsAction.CheckoutActionType.BANKTRANSFER, PaymentResponse.getAction().getType());
        assertEquals("Adyen", PaymentResponse.getAction().getBeneficiary());
        assertEquals("NL13TEST0123456789", PaymentResponse.getAction().getIban());
        assertEquals("TESTNL02", PaymentResponse.getAction().getBic());
        assertEquals("851-6178-9473-6924A", PaymentResponse.getAction().getReference());
        assertEquals("bankTransfer_IBAN", PaymentResponse.getAction().getPaymentMethodType());
    }

    /**
     * Test Checkout Sessions
     */
    protected CreateCheckoutSessionRequest createCreateCheckoutSessionRequest() {
        CreateCheckoutSessionRequest createCheckoutSessionRequest = new CreateCheckoutSessionRequest();
        createCheckoutSessionRequest.setMerchantAccount("TestMerchant");
        createCheckoutSessionRequest.setReference("TestReference");
        createCheckoutSessionRequest.setReturnUrl("http://test-url.com");

        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(10000L);

        createCheckoutSessionRequest.setAmount(amount);
        return createCheckoutSessionRequest;
    }

    @Test
    public void TestCheckoutSessionSuccess() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/checkout/sessions-success.json");
        Checkout checkout = new Checkout(client);
        CreateCheckoutSessionRequest sessionsRequest = createCreateCheckoutSessionRequest();
        CreateCheckoutSessionResponse sessionsResponse = checkout.sessions(sessionsRequest);
        assertEquals("TestMerchant", sessionsResponse.getMerchantAccount());
        assertEquals("TestReference", sessionsResponse.getReference());
        assertEquals("http://test-url.com", sessionsResponse.getReturnUrl());
        assertEquals("2021-09-30T06:45:06Z", sessionsResponse.getExpiresAt());
        assertEquals("EUR", sessionsResponse.getAmount().getCurrency());
        assertEquals("1000", sessionsResponse.getAmount().getValue().toString());
    }

    @Test
    public void TestCheckoutSessionErrorMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/sessions-error-invalid-data-422.json");
        Checkout checkout = new Checkout(client);
        CreateCheckoutSessionRequest sessionsRequest = createCreateCheckoutSessionRequest();
        CreateCheckoutSessionResponse sessionsResponse = checkout.sessions(sessionsRequest);
        assertNull(sessionsResponse.getSessionData());
    }

    private void assertJsonStringEquals(String firstInput, String secondInput) {
        JsonParser parser = new JsonParser();
        assertEquals(parser.parse(firstInput), parser.parse(secondInput));
    }
}

class TestPaymentMethodDetails implements PaymentMethodDetails {
    @SerializedName("testKey")
    private String testValue;

    @SerializedName("type")
    private String type;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }
}
