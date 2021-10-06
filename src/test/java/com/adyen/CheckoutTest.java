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
import com.adyen.deserializer.PaymentMethodDetailsTypeAdapter;
import com.adyen.model.Amount;
import com.adyen.model.Split;
import com.adyen.model.SplitAmount;
import com.adyen.model.checkout.CheckoutCancelOrderRequest;
import com.adyen.model.checkout.CheckoutCancelOrderResponse;
import com.adyen.model.checkout.CheckoutCreateOrderRequest;
import com.adyen.model.checkout.CheckoutCreateOrderResponse;
import com.adyen.model.checkout.CheckoutOrder;
import com.adyen.model.checkout.CheckoutPaymentsAction;
import com.adyen.model.checkout.CreateStoredPaymentMethodRequest;
import com.adyen.model.checkout.DefaultPaymentMethodDetails;
import com.adyen.model.checkout.PaymentMethodDetails;
import com.adyen.model.checkout.PaymentMethodsRequest;
import com.adyen.model.checkout.PaymentMethodsResponse;
import com.adyen.model.checkout.PaymentResultRequest;
import com.adyen.model.checkout.PaymentResultResponse;
import com.adyen.model.checkout.PaymentSessionRequest;
import com.adyen.model.checkout.PaymentSessionResponse;
import com.adyen.model.checkout.PaymentsDetailsRequest;
import com.adyen.model.checkout.PaymentsDetailsResponse;
import com.adyen.model.checkout.PaymentsRequest;
import com.adyen.model.checkout.PaymentsResponse;
import com.adyen.model.checkout.CreateCheckoutSessionRequest;
import com.adyen.model.checkout.CreateCheckoutSessionResponse;
import com.adyen.model.checkout.Redirect;
import com.adyen.model.checkout.RiskData;
import com.adyen.model.checkout.StoredPaymentMethodResource;
import com.adyen.model.checkout.StoringMethod;
import com.adyen.model.checkout.details.AchDetails;
import com.adyen.model.checkout.details.AmazonPayDetails;
import com.adyen.model.checkout.details.AndroidPayDetails;
import com.adyen.model.checkout.details.ApplePayDetails;
import com.adyen.model.checkout.details.BacsDirectDebitDetails;
import com.adyen.model.checkout.details.BillDeskOnlineDetails;
import com.adyen.model.checkout.details.BillDeskWalletDetails;
import com.adyen.model.checkout.details.BlikDetails;
import com.adyen.model.checkout.details.DokuDetails;
import com.adyen.model.checkout.details.DotpayDetails;
import com.adyen.model.checkout.details.DragonpayDetails;
import com.adyen.model.checkout.details.EcontextVoucherDetails;
import com.adyen.model.checkout.details.EntercashDetails;
import com.adyen.model.checkout.details.GenericIssuerPaymentMethodDetails;
import com.adyen.model.checkout.details.GiropayDetails;
import com.adyen.model.checkout.details.GooglePayDetails;
import com.adyen.model.checkout.details.IdealDetails;
import com.adyen.model.checkout.details.KlarnaDetails;
import com.adyen.model.checkout.details.LianLianPayDetails;
import com.adyen.model.checkout.details.MasterpassDetails;
import com.adyen.model.checkout.details.MbwayDetails;
import com.adyen.model.checkout.details.MobilePayDetails;
import com.adyen.model.checkout.details.MolPayDetails;
import com.adyen.model.checkout.details.PayPalDetails;
import com.adyen.model.checkout.details.PayUUpiDetails;
import com.adyen.model.checkout.details.QiwiWalletDetails;
import com.adyen.model.checkout.details.SamsungPayDetails;
import com.adyen.model.checkout.details.SepaDirectDebitDetails;
import com.adyen.model.checkout.details.VippsDetails;
import com.adyen.model.checkout.details.VisaCheckoutDetails;
import com.adyen.model.checkout.details.WeChatPayDetails;
import com.adyen.model.checkout.details.WeChatPayMiniProgramDetails;
import com.adyen.service.Checkout;
import com.adyen.service.exception.ApiException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        PaymentsResponse paymentsResponse = checkout.payments(paymentsRequest);
        assertEquals("8535296650153317", paymentsResponse.getPspReference());
        assertNotNull(paymentsResponse.getDonationToken());
    }

    /**
     * Test success flow for PayPal SDK type
     * POST /payments
     */
    @Test
    public void TestPaypalPaymentSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-success-paypal.json");
        Checkout checkout = new Checkout(client);
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        PaymentsResponse paymentsResponse = checkout.payments(paymentsRequest);
        assertEquals("EC-42N19135GM6949000", paymentsResponse.getAction().getSdkData().get("orderID"));
    }

    /**
     * Test success flow for OneTimePass type
     * POST /payments
     */
    @Test
    public void TestOneTimePassPaymentSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-success-onetimepass.json");
        Checkout checkout = new Checkout(client);
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        PaymentsResponse paymentsResponse = checkout.payments(paymentsRequest);
        assertEquals(1, paymentsResponse.getAction().getResendInterval());
        assertEquals(3, paymentsResponse.getAction().getResendMaxAttempts());
        assertEquals("https://localhost:8080", paymentsResponse.getAction().getResendUrl());
        assertNotNull(paymentsResponse.getAction());
        assertEquals(Redirect.MethodEnum.GET, paymentsResponse.getAction().getRedirect().getMethod());
        assertEquals("https://localhost:8080", paymentsResponse.getAction().getRedirect().getUrl());
        assertNull(paymentsResponse.getAction().getRedirect().getData());

    }

    /**
     * Test success flow for
     * POST /payments
     */
    @Test
    public void TestEncryptedPaymentsSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-encrypted-success.json");
        Checkout checkout = new Checkout(client);
        PaymentsRequest paymentsRequest = createEncryptedPaymentsCheckoutRequest();
        PaymentsResponse paymentsResponse = checkout.payments(paymentsRequest);
        assertEquals("883586864229293H", paymentsResponse.getPspReference());
    }

    /**
     * Test success flow for
     * POST /payments
     */
    @Test
    public void TestEncryptedPaymentsWithoutHoldernameSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-encrypted-without-holdername-success.json");
        Checkout checkout = new Checkout(client);
        PaymentsRequest paymentsRequest = createEncryptedPaymentsCheckoutRequestWithoutHoldername();
        PaymentsResponse paymentsResponse = checkout.payments(paymentsRequest);
        assertEquals("853613724697009G", paymentsResponse.getPspReference());
    }

    /**
     * Test error flow for
     * POST /payments
     */
    @Test
    public void TestPaymentsErrorMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-error-invalid-data-422.json");
        Checkout checkout = new Checkout(client);
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        PaymentsResponse paymentsResponse = checkout.payments(paymentsRequest);
        assertNull(paymentsResponse.getPspReference());
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
        assertEquals(27, paymentMethodsResponse.getPaymentMethods().size());
        assertEquals("Credit Card", paymentMethodsResponse.getPaymentMethods().get(0).getName());
        assertEquals(6, paymentMethodsResponse.getPaymentMethods().get(0).getBrands().size());
        assertEquals("vvvgiftcard", paymentMethodsResponse.getPaymentMethods().get(23).getBrand());

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
        assertNotNull(paymentMethodsResponse.getOneClickPaymentMethods());
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
        PaymentsDetailsResponse paymentsResponse = checkout.paymentsDetails(createPaymentsDetailsRequest());
        assertEquals("Authorised", paymentsResponse.getResultCode().toString());
    }

    /**
     * Test error flow for
     * POST /payments/details
     */

    @Test
    public void TestPaymentsDetailsErrorMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentsdetails-error-invalid-data-422.json");
        Checkout checkout = new Checkout(client);
        PaymentsDetailsResponse paymentsResponse = checkout.paymentsDetails(createPaymentsDetailsRequest());
        assertNull(paymentsResponse.getResultCode());

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
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);

        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"type\": \"scheme\",\n"
                + "    \"number\": \"4111111111111111\",\n"
                + "    \"expiryMonth\": \"10\",\n"
                + "    \"expiryYear\": \"2018\",\n"
                + "    \"holderName\": \"John Smith\",\n"
                + "    \"cvc\": \"737\"\n"
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
        paymentsRequest.setPaymentMethod(testPaymentMethodDetails);

        jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
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
        PaymentsRequest paymentsRequest = createEncryptedPaymentsCheckoutRequest();
        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);

        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"type\": \"scheme\",\n"
                + "    \"holderName\": \"John Smith\",\n"
                + "    \"encryptedCardNumber\": \"test_4111111111111111\",\n"
                + "    \"encryptedExpiryMonth\": \"test_03\",\n"
                + "    \"encryptedExpiryYear\": \"test_2030\",\n"
                + "    \"encryptedSecurityCode\": \"test_737\"\n"
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
        paymentsRequest.setPaymentMethod(testPaymentMethodDetails);

        jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
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
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        PaymentsResponse paymentsResponse = checkout.payments(paymentsRequest);
        assertEquals(0, new BigDecimal("1000.0").compareTo(BigDecimal.valueOf(paymentsResponse.getAction().getInitialAmount().getValue())));
        assertEquals("2020-01-12T09:37:49", paymentsResponse.getAction().getExpiresAt());
        assertEquals("12101", paymentsResponse.getAction().getEntity());
        assertEquals("501 422 944", paymentsResponse.getAction().getReference());

    }

    @Test
    public void TestSepaPaymentMethodDetails() {
        DefaultPaymentMethodDetails defaultPaymentMethodDetails = new DefaultPaymentMethodDetails();
        defaultPaymentMethodDetails.type("sepadirectdebit");
        defaultPaymentMethodDetails.setSepaOwnerName("A. Schneider");
        defaultPaymentMethodDetails.setSepaIbanNumber("DE87123456781234567890");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(defaultPaymentMethodDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);

        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"type\": \"sepadirectdebit\",\n"
                + "    \"sepa.ownerName\": \"A. Schneider\",\n"
                + "    \"sepa.ibanNumber\": \"DE87123456781234567890\"\n"
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
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(sepaDirectDebitDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestSepaDirectDebitDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"iban\":\"DE87123456781234567890\",\"ownerName\":\"A. Schneider\",\"type\":\"sepadirectdebit\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        SepaDirectDebitDetails sepaDirectDebitDetails = new SepaDirectDebitDetails();
        sepaDirectDebitDetails.setOwnerName("A. Schneider");
        sepaDirectDebitDetails.setIban("DE87123456781234567890");
        PaymentsRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(sepaDirectDebitDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
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
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(achDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestAchDetailsDeserializer() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"bankAccountNumber\":\"1234567\",\"bankLocationId\":\"1234567\",\"encryptedBankAccountNumber\":\"1234asdfg\",\"ownerName\":\"John Smith\",\"type\":\"ach\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        AchDetails achDetails = new AchDetails();
        achDetails.setBankAccountNumber("1234567");
        achDetails.setBankLocationId("1234567");
        achDetails.setEncryptedBankAccountNumber("1234asdfg");
        achDetails.setOwnerName("John Smith");
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(achDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
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
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(econtextVoucherDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
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
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(econtextVoucherDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestIdealDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"1121\",\"type\":\"ideal\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        IdealDetails idealDetails = new IdealDetails();
        idealDetails.setIssuer("1121");
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(idealDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestIdealDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"1121\",\"type\":\"ideal\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
        IdealDetails idealDetails = new IdealDetails();
        idealDetails.setIssuer("1121");
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(idealDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestGooglePayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"googlePayCardNetwork\":\"googlepaycardnetwork\",\"googlePayToken\":\"Payload as retrieved from Google Pay response\",\"type\":\"paywithgoogle\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        GooglePayDetails googlePayDetails = new GooglePayDetails();
        googlePayDetails.setGooglePayToken("Payload as retrieved from Google Pay response");
        googlePayDetails.setFundingSource(GooglePayDetails.FundingSourceEnum.CREDIT);
        googlePayDetails.setGooglePayCardNetwork("googlepaycardnetwork");
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(googlePayDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestGooglePayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"googlePayCardNetwork\":\"googlepaycardnetwork\",\"googlePayToken\":\"Payload as retrieved from Google Pay response\",\"type\":\"paywithgoogle\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
        GooglePayDetails googlePayDetails = new GooglePayDetails();
        googlePayDetails.setGooglePayToken("Payload as retrieved from Google Pay response");
        googlePayDetails.setFundingSource(GooglePayDetails.FundingSourceEnum.CREDIT);
        googlePayDetails.setGooglePayCardNetwork("googlepaycardnetwork");
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(googlePayDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
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
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(payPalDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestPayPalDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"orderID\":\"orderId\",\"payerID\":\"payerId\",\"type\":\"paypal\",\"subtype\":\"sdk\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        PayPalDetails payPalDetails = new PayPalDetails();
        payPalDetails.setOrderID("orderId");
        payPalDetails.setPayerID("payerId");
        payPalDetails.setSubtype(PayPalDetails.SubtypeEnum.SDK);
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(payPalDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
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
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(dokuDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
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
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(dokuDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestAmazonPayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"amazonPayToken\":\"amazonpaytoken\",\"checkoutSessionId\":\"checkoutsessionid\",\"type\":\"amazonpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        AmazonPayDetails amazonPayDetails = new AmazonPayDetails();
        amazonPayDetails.setAmazonPayToken("amazonpaytoken");
        amazonPayDetails.setCheckoutSessionId("checkoutsessionid");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(amazonPayDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestAmazonPayDetailsDeserializer() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"amazonPayToken\":\"amazonpaytoken\",\"checkoutSessionId\":\"checkoutsessionid\",\"type\":\"amazonpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        AmazonPayDetails amazonPayDetails = new AmazonPayDetails();
        amazonPayDetails.setAmazonPayToken("amazonpaytoken");
        amazonPayDetails.setCheckoutSessionId("checkoutsessionid");
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(amazonPayDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);

    }

    @Test
    public void TestApplePayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"applePayToken\":\"applepaytoken\",\"fundingSource\":\"credit\",\"type\":\"applepay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        ApplePayDetails applePayDetails = new ApplePayDetails();
        applePayDetails.setApplePayToken("applepaytoken");
        applePayDetails.setFundingSource(ApplePayDetails.FundingSourceEnum.CREDIT);
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(applePayDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestApplePayDetailsDeserializer() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"applePayToken\":\"applepaytoken\",\"fundingSource\":\"credit\",\"type\":\"applepay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        ApplePayDetails applePayDetails = new ApplePayDetails();
        applePayDetails.setApplePayToken("applepaytoken");
        applePayDetails.setFundingSource(ApplePayDetails.FundingSourceEnum.CREDIT);
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(applePayDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestBillDeskOnlineDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"billdesk_online\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        BillDeskOnlineDetails billdeskOnlineDetails = new BillDeskOnlineDetails();
        billdeskOnlineDetails.setIssuer("111");
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(billdeskOnlineDetails);

        String gsonRequest = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gsonRequest);

        String jacksonRequest = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jacksonRequest);
    }

    @Test
    public void TestBillDeskOnlineDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"billdesk_online\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        BillDeskOnlineDetails billdeskOnlineDetails = new BillDeskOnlineDetails();
        billdeskOnlineDetails.setIssuer("111");
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(billdeskOnlineDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestBacsDirectDebitDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"GBP\"},\"merchantAccount\":\"TestMerchant\",\"paymentMethod\":{\"type\":\"directdebit_GB\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        BacsDirectDebitDetails bacsDirectDebitDetails = new BacsDirectDebitDetails();
        PaymentsRequest paymentsRequest = createBacsDirectDebitDetails();
        paymentsRequest.setPaymentMethod(bacsDirectDebitDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestBacsDirectDebitDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"GBP\"},\"merchantAccount\":\"TestMerchant\",\"paymentMethod\":{\"type\":\"directdebit_GB\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        BacsDirectDebitDetails bacsDirectDebitDetails = new BacsDirectDebitDetails();
        PaymentsRequest expectedPaymentRequest = createBacsDirectDebitDetails();
        expectedPaymentRequest.setPaymentMethod(bacsDirectDebitDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestBilldeskWalletDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"billdesk_wallet\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        BillDeskWalletDetails billdeskWalletDetails = new BillDeskWalletDetails();
        billdeskWalletDetails.setIssuer("111");
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(billdeskWalletDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestBillDeskWalletDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"billdesk_wallet\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
        BillDeskWalletDetails billdeskWalletDetails = new BillDeskWalletDetails();
        billdeskWalletDetails.setIssuer("111");
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(billdeskWalletDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestDotpayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"dotpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        DotpayDetails dotpayDetails = new DotpayDetails();
        dotpayDetails.setIssuer("111");
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(dotpayDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestDotpayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"dotpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
        DotpayDetails dotpayDetails = new DotpayDetails();
        dotpayDetails.setIssuer("111");
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(dotpayDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestEntercashDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"entercash\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        EntercashDetails entercashDetails = new EntercashDetails();
        entercashDetails.setIssuer("111");
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(entercashDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestEntercashDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"entercash\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        EntercashDetails entercashDetails = new EntercashDetails();
        entercashDetails.setIssuer("111");
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(entercashDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestGenericIssuerPaymentMethodDetails() {
        GenericIssuerPaymentMethodDetails genericIssuerPaymentMethodDetails = new GenericIssuerPaymentMethodDetails();
        genericIssuerPaymentMethodDetails.setIssuer("111");
        genericIssuerPaymentMethodDetails.setType("ideal");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(genericIssuerPaymentMethodDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
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
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(giropayDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestGiropayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"giropay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        GiropayDetails giropayDetails = new GiropayDetails();
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(giropayDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestQiwiWalletDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"telephoneNumber\":\"123456789\",\"type\":\"qiwiwallet\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        QiwiWalletDetails qiwiWalletDetails = new QiwiWalletDetails();
        qiwiWalletDetails.setTelephoneNumber("123456789");
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(qiwiWalletDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestQiwiWalletDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"telephoneNumber\":\"123456789\",\"type\":\"qiwiwallet\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        QiwiWalletDetails qiwiWalletDetails = new QiwiWalletDetails();
        qiwiWalletDetails.setTelephoneNumber("123456789");
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(qiwiWalletDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestSamsungPayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"samsungPayToken\":\"samsungpaytoken\",\"type\":\"samsungpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        SamsungPayDetails samsungPayDetails = new SamsungPayDetails();
        samsungPayDetails.setFundingSource(SamsungPayDetails.FundingSourceEnum.CREDIT);
        samsungPayDetails.setSamsungPayToken("samsungpaytoken");
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(samsungPayDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestSamsungPayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"samsungPayToken\":\"samsungpaytoken\",\"type\":\"samsungpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        SamsungPayDetails samsungPayDetails = new SamsungPayDetails();
        samsungPayDetails.setFundingSource(SamsungPayDetails.FundingSourceEnum.CREDIT);
        samsungPayDetails.setSamsungPayToken("samsungpaytoken");
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(samsungPayDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestVippsDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"telephoneNumber\":\"123456789\",\"type\":\"vipps\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        VippsDetails vippsDetails = new VippsDetails();
        vippsDetails.setTelephoneNumber("123456789");
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(vippsDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestVippsDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"telephoneNumber\":\"123456789\",\"type\":\"vipps\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        VippsDetails vippsDetails = new VippsDetails();
        vippsDetails.setTelephoneNumber("123456789");
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(vippsDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestVisaCheckoutDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"type\":\"visacheckout\",\"visaCheckoutCallId\":\"visacheckoutcallid\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        VisaCheckoutDetails visaCheckoutDetails = new VisaCheckoutDetails();
        visaCheckoutDetails.setFundingSource(VisaCheckoutDetails.FundingSourceEnum.CREDIT);
        visaCheckoutDetails.setVisaCheckoutCallId("visacheckoutcallid");
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(visaCheckoutDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestVisaCheckoutDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"type\":\"visacheckout\",\"visaCheckoutCallId\":\"visacheckoutcallid\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        VisaCheckoutDetails visaCheckoutDetails = new VisaCheckoutDetails();
        visaCheckoutDetails.setFundingSource(VisaCheckoutDetails.FundingSourceEnum.CREDIT);
        visaCheckoutDetails.setVisaCheckoutCallId("visacheckoutcallid");
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(visaCheckoutDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestRecurringPaymentMethodDetails() {
        DefaultPaymentMethodDetails defaultPaymentMethodDetails = new DefaultPaymentMethodDetails();
        defaultPaymentMethodDetails.setStoredPaymentMethodId("testStoredPaymentMethodId");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(defaultPaymentMethodDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);

        assertEquals("{\n"
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
        DefaultPaymentMethodDetails defaultPaymentMethodDetails = new DefaultPaymentMethodDetails();
        defaultPaymentMethodDetails.setShopperNotificationReference("IA0F7500002462");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(defaultPaymentMethodDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);

        assertEquals("{\n"
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
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"androidPayToken\":\"androidpaytoken\",\"type\":\"androidpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        AndroidPayDetails androidPayDetails = new AndroidPayDetails();
        androidPayDetails.setAndroidPayToken("androidpaytoken");
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(androidPayDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestAndroidPayDetailsDeserializer() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"androidPayToken\":\"androidpaytoken\",\"type\":\"androidpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        AndroidPayDetails androidPayDetails = new AndroidPayDetails();
        androidPayDetails.setAndroidPayToken("androidpaytoken");
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(androidPayDetails);

        PaymentsRequest gson = PRETTY_PRINT_GSON.fromJson(json, PaymentsRequest.class);
        PaymentsRequest jackson = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);

        assertEquals(expectedPaymentRequest, gson);
        assertEquals(expectedPaymentRequest, jackson);
    }

    @Test
    public void TestKlarnaDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"bankAccount\":\"bankaccount\",\"billingAddress\":\"billingaddress\",\"deliveryAddress\":\"deliveryaddress\",\"installmentConfigurationKey\":\"installmentconfigurationkey\",\"personalDetails\":\"personaldetails\",\"separateDeliveryAddress\":\"separatedeliveryaddress\",\"storedPaymentMethodId\":\"storedpaymentmethodid\",\"token\":\"token\",\"type\":\"klarna\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        KlarnaDetails klarnaDetails = new KlarnaDetails();
        klarnaDetails.setBankAccount("bankaccount");
        klarnaDetails.setBillingAddress("billingaddress");
        klarnaDetails.setDeliveryAddress("deliveryaddress");
        klarnaDetails.setInstallmentConfigurationKey("installmentconfigurationkey");
        klarnaDetails.setPersonalDetails("personaldetails");
        klarnaDetails.setSeparateDeliveryAddress("separatedeliveryaddress");
        klarnaDetails.setStoredPaymentMethodId("storedpaymentmethodid");
        klarnaDetails.setToken("token");
        klarnaDetails.setType(KlarnaDetails.KLARNA);
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(klarnaDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestKlarnaDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"bankAccount\":\"bankaccount\",\"billingAddress\":\"billingaddress\",\"deliveryAddress\":\"deliveryaddress\",\"installmentConfigurationKey\":\"installmentconfigurationkey\",\"personalDetails\":\"personaldetails\",\"separateDeliveryAddress\":\"separatedeliveryaddress\",\"storedPaymentMethodId\":\"storedpaymentmethodid\",\"token\":\"token\",\"type\":\"klarna\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        KlarnaDetails klarnaDetails = new KlarnaDetails();
        klarnaDetails.setBankAccount("bankaccount");
        klarnaDetails.setBillingAddress("billingaddress");
        klarnaDetails.setDeliveryAddress("deliveryaddress");
        klarnaDetails.setInstallmentConfigurationKey("installmentconfigurationkey");
        klarnaDetails.setPersonalDetails("personaldetails");
        klarnaDetails.setSeparateDeliveryAddress("separatedeliveryaddress");
        klarnaDetails.setStoredPaymentMethodId("storedpaymentmethodid");
        klarnaDetails.setToken("token");
        klarnaDetails.setType(KlarnaDetails.KLARNA);
        PaymentsRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(klarnaDetails);

        PaymentsRequest gson = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, gson);

        PaymentsRequest jackson = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedPaymentRequest, jackson);
    }

    @Test
    public void TestMasterPassDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"masterpassTransactionId\":\"transactionId\",\"type\":\"masterpass\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MasterpassDetails masterpassDetails = new MasterpassDetails();
        masterpassDetails.setFundingSource(MasterpassDetails.FundingSourceEnum.CREDIT);
        masterpassDetails.setMasterpassTransactionId("transactionId");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(masterpassDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestMasterPassDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"masterpassTransactionId\":\"transactionId\",\"type\":\"masterpass\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MasterpassDetails masterpassDetails = new MasterpassDetails();
        masterpassDetails.setFundingSource(MasterpassDetails.FundingSourceEnum.CREDIT);
        masterpassDetails.setMasterpassTransactionId("transactionId");
        PaymentsRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(masterpassDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestMobilePayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"mobilepay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MobilePayDetails mobilePayDetails = new MobilePayDetails();
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(mobilePayDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestMobilePayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"mobilepay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MobilePayDetails mobilePayDetails = new MobilePayDetails();
        PaymentsRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(mobilePayDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestPayUUpiDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"payu_IN_upi\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        PayUUpiDetails payUUpiDetails = new PayUUpiDetails();
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(payUUpiDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestPayUUpiDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"payu_IN_upi\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        PayUUpiDetails payUUpiDetails = new PayUUpiDetails();
        PaymentsRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(payUUpiDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestWeChatPayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"appId\":\"appId\",\"openid\":\"openId\",\"type\":\"wechatpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        WeChatPayDetails weChatPayDetails = new WeChatPayDetails();
        weChatPayDetails.setAppId("appId");
        weChatPayDetails.setOpenid("openId");
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(weChatPayDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestWeChatPayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"appId\":\"appId\",\"openid\":\"openId\",\"type\":\"wechatpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        WeChatPayDetails weChatPayDetails = new WeChatPayDetails();
        weChatPayDetails.setAppId("appId");
        weChatPayDetails.setOpenid("openId");
        PaymentsRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(weChatPayDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestWeChatPayMiniProgramDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"appId\":\"appId\",\"openid\":\"openId\",\"type\":\"wechatpayMiniProgram\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        WeChatPayMiniProgramDetails weChatPayMiniProgramDetails = new WeChatPayMiniProgramDetails();
        weChatPayMiniProgramDetails.setAppId("appId");
        weChatPayMiniProgramDetails.setOpenid("openId");
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(weChatPayMiniProgramDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestWeChatPayMiniProgramDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"appId\":\"appId\",\"openid\":\"openId\",\"type\":\"wechatpayMiniProgram\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        WeChatPayMiniProgramDetails weChatPayMiniProgramDetails = new WeChatPayMiniProgramDetails();
        weChatPayMiniProgramDetails.setAppId("appId");
        weChatPayMiniProgramDetails.setOpenid("openId");
        PaymentsRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(weChatPayMiniProgramDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestBlikDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"blikCode\":\"blikCode\",\"type\":\"blik\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        BlikDetails blikDetails = new BlikDetails();
        blikDetails.setBlikCode("blikCode");
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(blikDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestBlikDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"blikCode\":\"blikCode\",\"type\":\"blik\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        BlikDetails blikDetails = new BlikDetails();
        blikDetails.setBlikCode("blikCode");
        PaymentsRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(blikDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestDragonpayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"issuer\",\"shopperEmail\":\"test@test.com\",\"type\":\"dragonpay_ebanking\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        DragonpayDetails dragonPayDetails = new DragonpayDetails();
        dragonPayDetails.setIssuer("issuer");
        dragonPayDetails.setShopperEmail("test@test.com");
        dragonPayDetails.setType(DragonpayDetails.EBANKING);
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(dragonPayDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestDragonpayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"issuer\",\"shopperEmail\":\"test@test.com\",\"type\":\"dragonpay_ebanking\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        DragonpayDetails dragonPayDetails = new DragonpayDetails();
        dragonPayDetails.setIssuer("issuer");
        dragonPayDetails.setShopperEmail("test@test.com");
        dragonPayDetails.setType(DragonpayDetails.EBANKING);
        PaymentsRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(dragonPayDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestLianLianPayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"telephoneNumber\":\"telephone\",\"type\":\"lianlianpay_ebanking_credit\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        LianLianPayDetails lianLianPayDetails = new LianLianPayDetails();
        lianLianPayDetails.setTelephoneNumber("telephone");
        lianLianPayDetails.setType(LianLianPayDetails.EBANKING_CREDIT);
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(lianLianPayDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestLianLianPayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"telephoneNumber\":\"telephone\",\"type\":\"lianlianpay_ebanking_credit\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        LianLianPayDetails lianLianPayDetails = new LianLianPayDetails();
        lianLianPayDetails.setTelephoneNumber("telephone");
        lianLianPayDetails.setType(LianLianPayDetails.EBANKING_CREDIT);
        PaymentsRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(lianLianPayDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestMbwayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"shopperEmail\":\"test@test.com\",\"telephoneNumber\":\"telephone\",\"type\":\"mbway\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MbwayDetails mbwayDetails = new MbwayDetails();
        mbwayDetails.setTelephoneNumber("telephone");
        mbwayDetails.setShopperEmail("test@test.com");
        mbwayDetails.setType(MbwayDetails.MBWAY);
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(mbwayDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestMbwayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"shopperEmail\":\"test@test.com\",\"telephoneNumber\":\"telephone\",\"type\":\"mbway\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MbwayDetails mbwayDetails = new MbwayDetails();
        mbwayDetails.setTelephoneNumber("telephone");
        mbwayDetails.setShopperEmail("test@test.com");
        mbwayDetails.setType(MbwayDetails.MBWAY);
        PaymentsRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(mbwayDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestMolPayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"issuer\",\"type\":\"molpay_ebanking_direct_MY\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MolPayDetails molPayDetails = new MolPayDetails();
        molPayDetails.setIssuer("issuer");
        molPayDetails.setType(MolPayDetails.EBANKING_DIRECT_MY);
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(molPayDetails);

        String gson = GSON.toJson(paymentsRequest);
        assertEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(paymentsRequest);
        assertEquals(expectedJson, jackson);
    }

    @Test
    public void TestMolPayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"issuer\",\"type\":\"molpay_ebanking_direct_MY\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MolPayDetails molPayDetails = new MolPayDetails();
        molPayDetails.setIssuer("issuer");
        molPayDetails.setType(MolPayDetails.EBANKING_DIRECT_MY);
        PaymentsRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(molPayDetails);

        PaymentsRequest gsonObject = GSON.fromJson(json, PaymentsRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentsRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentsRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestDateSerializers() throws ParseException {
        PaymentsRequest paymentsRequest = new PaymentsRequest();

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        fmt.setTimeZone(TimeZone.getTimeZone("GMT"));

        Date d = fmt.parse("2018-10-31");
        paymentsRequest.setDateOfBirth(d);
        paymentsRequest.setDeliveryDate(d);
        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
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
        PaymentsRequest paymentsRequest = new PaymentsRequest();
        paymentsRequest.setRecurringProcessingModel(PaymentsRequest.RecurringProcessingModelEnum.CARD_ON_FILE);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertTrue(jsonRequest.contains("recurringProcessingModel\": \"CardOnFile\"\n"));

        paymentsRequest.setRecurringProcessingModel(PaymentsRequest.RecurringProcessingModelEnum.SUBSCRIPTION);
        jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertTrue(jsonRequest.contains("recurringProcessingModel\": \"Subscription\"\n"));

        paymentsRequest.setRecurringProcessingModel(PaymentsRequest.RecurringProcessingModelEnum.UNSCHEDULED_CARD_ON_FILE);
        jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertTrue(jsonRequest.contains("recurringProcessingModel\": \"UnscheduledCardOnFile\"\n"));
    }

    @Test
    public void TestPaymentResponseDate() {
        PaymentsResponse paymentsResponse = new PaymentsResponse();
        try {
            Date expiryDate = paymentsResponse.getExpiryDate();
            Assert.assertNull(expiryDate);
        } catch (Exception ex) {

            Assert.fail("multibanco date throw Exception");
        }
    }

    @Test
    public void TestPaymentResponseChallengeShopper() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-3ds2-challenge-shopper.json");
        Checkout checkout = new Checkout(client);
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        PaymentsResponse paymentsResponse = checkout.payments(paymentsRequest);
        assertEquals(PaymentsResponse.ResultCodeEnum.CHALLENGESHOPPER, paymentsResponse.getResultCode());
        assertNotNull(paymentsResponse.getAction());
        assertNotNull(paymentsResponse.getAction().getData());
        assertEquals(3, paymentsResponse.getAction().getData().size());
        assertEquals("POST", paymentsResponse.getAction().getMethod());
        assertEquals("Ab02b4c0!BQABAgA4e3wGkhVah4CJL19qdegdmm9E...", paymentsResponse.getAction().getPaymentData());
        assertEquals("scheme", paymentsResponse.getAction().getPaymentMethodType());
        assertEquals("https://test.adyen.com/hpp/3d/validate.shtml", paymentsResponse.getAction().getUrl());
        assertEquals(CheckoutPaymentsAction.CheckoutActionType.REDIRECT, paymentsResponse.getAction().getType());
    }

    @Test
    public void TestPaymentResponseAuthenticationFinished() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-3ds2-authentication-finished.json");
        Checkout checkout = new Checkout(client);
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        PaymentsResponse paymentsResponse = checkout.payments(paymentsRequest);
        assertEquals(PaymentsResponse.ResultCodeEnum.AUTHENTICATIONFINISHED, paymentsResponse.getResultCode());
        assertNotNull(paymentsResponse.getThreeDS2Result());
        assertNotNull(paymentsResponse.getThreeDS2Result().getAuthenticationValue());
        assertNotNull(paymentsResponse.getThreeDS2Result().getDsTransID());
        assertNotNull(paymentsResponse.getThreeDS2Result().getEci());
        assertNotNull(paymentsResponse.getThreeDS2Result().getMessageVersion());
        assertNotNull(paymentsResponse.getThreeDS2Result().getThreeDSServerTransID());
        assertNotNull(paymentsResponse.getThreeDS2Result().getTransStatus());
    }

    @Test
    public void TestStoredPaymentMethodsSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/storedpaymentmethods-success.json");
        Checkout checkout = new Checkout(client);
        CreateStoredPaymentMethodRequest createStoredPaymentMethodRequest = createStoredPaymentMethodsRequest();
        StoredPaymentMethodResource storedPaymentMethodResource = checkout.storedPaymentMethods(createStoredPaymentMethodRequest);

        assertNotNull(createStoredPaymentMethodRequest);
        assertEquals("128472894248249", storedPaymentMethodResource.getId());
        assertEquals("scheme", storedPaymentMethodResource.getType());
        assertEquals("sh123412341234", storedPaymentMethodResource.getShopperReference());
        assertEquals("mc", storedPaymentMethodResource.getBrand());
        assertEquals("1111", storedPaymentMethodResource.getLastFour());
        assertEquals("04", storedPaymentMethodResource.getExpiryMonth());
        assertEquals("2020", storedPaymentMethodResource.getExpiryYear());
        assertNotNull(storedPaymentMethodResource.getSupportedShopperInteractions());
        List<String> supportedShopperInteraction = storedPaymentMethodResource.getSupportedShopperInteractions();
        assertTrue(supportedShopperInteraction.contains("Ecommerce"));
        assertTrue(supportedShopperInteraction.contains("ContAuth"));
    }

    @Test
    public void TestStoredPaymentMethodsErrorMocked() throws Exception {
        Client client = createMockClientForErrors(422, "mocks/checkout/storedpaymentmethods-error-invalid-data-422.json");
        Checkout checkout = new Checkout(client);
        CreateStoredPaymentMethodRequest createStoredPaymentMethodRequest = createStoredPaymentMethodsRequest();
        try {
            checkout.storedPaymentMethods(createStoredPaymentMethodRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals("121", e.getError().getErrorCode());
            assertEquals(422, e.getError().getStatus());
            assertEquals(e.getResponseHeaders().size(), 0);
            assertNotNull(e.getResponseHeaders());
        }
    }

    /**
     * Test ApiException flow for POST
     */
    @Test
    public void TestApiExceptionErrorMocked() throws Exception {
        Client client = createMockClientForErrors(422, "mocks/checkout/payments-error-invalid-data-422.json");
        Checkout checkout = new Checkout(client);
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        try {
            checkout.payments(paymentsRequest);
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
        PaymentsRequest paymentsRequest = createPaymentsNetworkCheckoutRequest();
        PaymentsResponse paymentsResponse = checkout.payments(paymentsRequest);
        assertEquals("MCC123456789012", paymentsResponse.getAdditionalData().get("networkTxReference"));
        assertEquals("8535296650153317", paymentsResponse.getPspReference());
    }

    /**
     * Test RiskData inside /payments
     */
    @Test
    public void TestRiskDataInRequest() {
        RiskData riskData = new RiskData();
        riskData.setClientData("IOfW3k9G2PvXFu2j");
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setRiskData(riskData);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
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
        PaymentsRequest paymentsRequest = createPaymentsRequestWithOrder();
        PaymentsResponse paymentsResponse = checkout.payments(paymentsRequest);
        assertEquals("payment reference", paymentsResponse.getMerchantReference());
        assertEquals("881593078164515C", paymentsResponse.getPspReference());
        assertEquals(PaymentsResponse.ResultCodeEnum.AUTHORISED, paymentsResponse.getResultCode());
        assertEquals("EUR", paymentsResponse.getAmount().getCurrency());
        assertEquals((Long) 1000L, paymentsResponse.getAmount().getValue());
        assertEquals("Ab02b4c0!BQABAgBqxSuFhuXUF7IvIRvSw5bDPHN...", paymentsResponse.getOrder().getOrderData());
        assertEquals("order reference", paymentsResponse.getOrder().getReference());
        assertEquals("8515930288670953", paymentsResponse.getOrder().getPspReference());
        assertEquals("2020-06-25T20:01:07Z", paymentsResponse.getOrder().getExpiresAt());
        assertEquals("EUR", paymentsResponse.getOrder().getRemainingAmount().getCurrency());
        assertEquals((Long) 1500L, paymentsResponse.getOrder().getRemainingAmount().getValue());
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
    public void TestPaymentsResponseIdentifyShopper() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/checkout/payments-3ds2-identify-shopper.json");
        Checkout checkout = new Checkout(client);
        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        PaymentsResponse paymentsResponse = checkout.payments(paymentsRequest);
        assertEquals(PaymentsResponse.ResultCodeEnum.IDENTIFYSHOPPER, paymentsResponse.getResultCode());
        assertEquals(CheckoutPaymentsAction.CheckoutActionType.THREEDS2, paymentsResponse.getAction().getType());
        assertEquals("fingerprint", paymentsResponse.getAction().getSubtype());
        assertEquals("scheme", paymentsResponse.getAction().getPaymentMethodType());
    }

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
     * Returns a sample PaymentsRequest object with test data
     */
    protected PaymentsRequest createPaymentsCheckoutRequest() {
        PaymentsRequest paymentsRequest = new PaymentsRequest();

        paymentsRequest.setReference("Your order number");
        paymentsRequest.setAmount(createAmountObject("USD", 1000L));
        paymentsRequest.addCardData("4111111111111111", "10", "2018", "737", "John Smith");

        paymentsRequest.setReturnUrl("https://your-company.com/...");
        paymentsRequest.setMerchantAccount("MagentoMerchantTest");

        return paymentsRequest;
    }

    /**
     * Returns a sample PaymentsRequest object with test data
     */
    protected PaymentsRequest createBacsDirectDebitDetails() {
        PaymentsRequest paymentsRequest = new PaymentsRequest();

        paymentsRequest.setReference("Your order number");
        paymentsRequest.setAmount(createAmountObject("GBP", 1000L));

        paymentsRequest.setReturnUrl("https://your-company.com/...");
        paymentsRequest.setMerchantAccount("TestMerchant");

        return paymentsRequest;
    }

    /**
     * Returns a sample Encrypted PaymentsRequest opbject with test data
     */
    protected PaymentsRequest createEncryptedPaymentsCheckoutRequest() {
        PaymentsRequest paymentsRequest = new PaymentsRequest();

        paymentsRequest.setReference("Your order number");
        paymentsRequest.setAmount(createAmountObject("USD", 1000L));
        paymentsRequest.addEncryptedCardData("test_4111111111111111", "test_03", "test_2030", "test_737", "John Smith");

        paymentsRequest.setReturnUrl("https://your-company.com/...");
        paymentsRequest.setMerchantAccount("MagentoMerchantTest");

        return paymentsRequest;
    }

    protected PaymentsRequest createEncryptedPaymentsCheckoutRequestWithoutHoldername() {
        PaymentsRequest paymentsRequest = new PaymentsRequest();

        paymentsRequest.setReference("Your order number");
        paymentsRequest.setAmount(createAmountObject("USD", 1000L));
        paymentsRequest.addEncryptedCardData("test_4111111111111111", "test_03", "test_2030", "test_737");

        paymentsRequest.setReturnUrl("https://your-company.com/...");
        paymentsRequest.setMerchantAccount("MagentoMerchantTest");

        return paymentsRequest;
    }

    /**
     * Returns a sample PaymentsRequest object with type networkToken and brand visa
     */
    protected PaymentsRequest createPaymentsNetworkCheckoutRequest() {
        PaymentsRequest paymentsRequest = new PaymentsRequest();

        paymentsRequest.setReference("Your order number");
        paymentsRequest.setAmount(createAmountObject("USD", 1000L));
        DefaultPaymentMethodDetails defaultPaymentMethodDetails = new DefaultPaymentMethodDetails();
        defaultPaymentMethodDetails.setType("networkToken");
        defaultPaymentMethodDetails.setBrand(BrandCodes.MASTERCARD);
        defaultPaymentMethodDetails.setExpiryMonth("08");
        defaultPaymentMethodDetails.setExpiryYear("2020");
        defaultPaymentMethodDetails.setHolderName("CARDHOLDER_NAME");
        defaultPaymentMethodDetails.setNumber("5555444433331111");
        defaultPaymentMethodDetails.setNetworkPaymentReference("MCC123456789012");

        paymentsRequest.setPaymentMethod(defaultPaymentMethodDetails);

        paymentsRequest.setReturnUrl("https://your-company.com/...");
        paymentsRequest.setMerchantAccount("MagentoMerchantTest");
        paymentsRequest.setShopperReference("YOUR_SHOPPER_REFERENCE");
        paymentsRequest.setRecurringProcessingModel(PaymentsRequest.RecurringProcessingModelEnum.CARD_ON_FILE);

        return paymentsRequest;
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
     * Returns a sample Amount opbject with given currency and value
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

    protected PaymentsRequest createPaymentsRequestWithOrder() {
        PaymentsRequest paymentsRequest = new PaymentsRequest();
        paymentsRequest.setReference("payment reference");
        paymentsRequest.setAmount(createAmountObject("EUR", 1000L));
        paymentsRequest.addEncryptedCardData("test_4111111111111111", "test_03", "test_2030", "test_737", "holderName");

        CheckoutOrder checkoutOrder = new CheckoutOrder();
        checkoutOrder.setOrderData("Ab02b4c0!BQABAgBqxSuFhuXUF7IvIRvSw5bDPHN...");
        checkoutOrder.setPspReference("8515930288670953");
        paymentsRequest.setOrder(checkoutOrder);

        paymentsRequest.setMerchantAccount("TestMerchant");
        return paymentsRequest;
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

    protected PaymentsRequest createBankTransferPaymentRequest() {
        PaymentsRequest paymentsRequest = new PaymentsRequest();
        paymentsRequest.setReference("payment reference");

        DefaultPaymentMethodDetails defaultPaymentMethodDetails = new DefaultPaymentMethodDetails();
        defaultPaymentMethodDetails.setType("bankTransfer_IBAN");
        paymentsRequest.setPaymentMethod(defaultPaymentMethodDetails);

        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(10000L);
        paymentsRequest.setAmount(amount);

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
        paymentsRequest.setSplits(splits);

        paymentsRequest.setCountryCode("NL");
        paymentsRequest.setReference("auth-banktransfer-split-12345");
        paymentsRequest.setMerchantAccount("merchantAccount");

        return paymentsRequest;
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
    public void TestBankTransferPaymentsSuccess() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/checkout/payments-banktransfer-success.json");
        Checkout checkout = new Checkout(client);
        PaymentsRequest paymentsRequest = createBankTransferPaymentRequest();
        PaymentsResponse paymentsResponse = checkout.payments(paymentsRequest);
        assertEquals(PaymentsResponse.ResultCodeEnum.RECEIVED, paymentsResponse.getResultCode());
        assertEquals(CheckoutPaymentsAction.CheckoutActionType.BANKTRANSFER, paymentsResponse.getAction().getType());
        assertEquals("Adyen", paymentsResponse.getAction().getBeneficiary());
        assertEquals("NL13TEST0123456789", paymentsResponse.getAction().getIban());
        assertEquals("TESTNL02", paymentsResponse.getAction().getBic());
        assertEquals("851-6178-9473-6924A", paymentsResponse.getAction().getReference());
        assertEquals("bankTransfer_IBAN", paymentsResponse.getAction().getPaymentMethodType());
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
