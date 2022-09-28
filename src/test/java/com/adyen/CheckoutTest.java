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
import com.adyen.model.Split;
import com.adyen.model.SplitAmount;
import com.adyen.model.checkout.*;
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
        assertNotNull(paymentMethodsResponse.getPaymentMethods());
        assertEquals(2, paymentMethodsResponse.getStoredPaymentMethods().size());
        assertEquals("8314960677671745", paymentMethodsResponse.getStoredPaymentMethods().get(0).getId());
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
        PaymentDetailsResponse PaymentResponse = checkout.paymentsDetails(createPaymentsDetailsRequest());
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
        PaymentDetailsResponse PaymentResponse = checkout.paymentsDetails(createPaymentsDetailsRequest());
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
        PaymentSetupRequest paymentSessionRequest = createPaymentSessionRequest();
        PaymentSetupResponse paymentSessionResponse = checkout.paymentSession(paymentSessionRequest);
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
        PaymentSetupRequest paymentSessionRequest = createPaymentSessionRequest();
        PaymentSetupResponse paymentSessionResponse = checkout.paymentSession(paymentSessionRequest);
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
        PaymentVerificationRequest paymentResultRequest = new PaymentVerificationRequest();
        paymentResultRequest.setPayload("This is a test payload");
        PaymentVerificationResponse paymentResultResponse = checkout.paymentResult(paymentResultRequest);
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
        PaymentVerificationRequest paymentResultRequest = new PaymentVerificationRequest();
        paymentResultRequest.setPayload("This is a test payload");
        PaymentVerificationResponse paymentResultResponse = checkout.paymentResult(paymentResultRequest);
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
        assertEquals(0, new BigDecimal("1000.0").compareTo(BigDecimal.valueOf(PaymentResponse.getAction().getCheckoutVoucherAction().getInitialAmount().getValue())));
        assertEquals("2020-01-12T09:37:49", PaymentResponse.getAction().getCheckoutVoucherAction().getExpiresAt());
        assertEquals("12101", PaymentResponse.getAction().getCheckoutVoucherAction().getEntity());
        assertEquals("501 422 944", PaymentResponse.getAction().getCheckoutVoucherAction().getReference());

    }

    @Test
    public void TestSepaPaymentMethodDetails() {
        SepaDirectDebitDetails sepaDirectDebitDetailsDetails = new SepaDirectDebitDetails();
        sepaDirectDebitDetailsDetails.type(SepaDirectDebitDetails.TypeEnum.SEPADIRECTDEBIT);
        sepaDirectDebitDetailsDetails.setOwnerName("A. Schneider");
        sepaDirectDebitDetailsDetails.setIban("DE87123456781234567890");

        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(sepaDirectDebitDetailsDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(sepaDirectDebitDetails));

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
        expectedRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(sepaDirectDebitDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(achDetails));

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
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(achDetails));

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
        econtextVoucherDetails.setType(EcontextVoucherDetails.TypeEnum.SEVENELEVEN);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(econtextVoucherDetails));

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
        econtextVoucherDetails.setType(EcontextVoucherDetails.TypeEnum.SEVENELEVEN);
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(econtextVoucherDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(idealDetails));

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
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(idealDetails));

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
        googlePayDetails.setFundingSource(GooglePayDetails.FundingSourceEnum.DEBIT);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(googlePayDetails));

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
        googlePayDetails.setFundingSource(GooglePayDetails.FundingSourceEnum.DEBIT);
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(googlePayDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(payWithGoogleDetails));

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
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(payWithGoogleDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(payPalDetails));

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
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(payPalDetails));

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
        dokuDetails.setLastName("Smith");
        dokuDetails.setShopperEmail("test@email.com");
        dokuDetails.setType(DokuDetails.TypeEnum.INDOMARET);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(dokuDetails));

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
        dokuDetails.setLastName("Smith");
        dokuDetails.setShopperEmail("test@email.com");
        dokuDetails.setType(DokuDetails.TypeEnum.INDOMARET);
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(dokuDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(amazonPayDetails));

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
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(amazonPayDetails));

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
        applePayDetails.setFundingSource(ApplePayDetails.FundingSourceEnum.DEBIT);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(applePayDetails));

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
        applePayDetails.setFundingSource(ApplePayDetails.FundingSourceEnum.DEBIT);
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(applePayDetails));

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestBillDeskOnlineDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"billdesk_online\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        BillDeskDetails billdeskOnlineDetails = new BillDeskDetails();
        billdeskOnlineDetails.setIssuer("111");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod (billdeskOnlineDetails));

        String gsonRequest = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gsonRequest);

        String jacksonRequest = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jacksonRequest);
    }

    @Test
    public void TestBillDeskOnlineDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"billdesk_online\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        BillDeskDetails billdeskOnlineDetails = new BillDeskDetails();
        billdeskOnlineDetails.setIssuer("111");
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(billdeskOnlineDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(bacsDirectDebitDetails));

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
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(bacsDirectDebitDetails));

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestBilldeskWalletDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"billdesk_wallet\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        BillDeskDetails billdeskWalletDetails = new BillDeskDetails();
        billdeskWalletDetails.setIssuer("111");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(billdeskWalletDetails));

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestBillDeskWalletDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"111\",\"type\":\"billdesk_wallet\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
        BillDeskDetails billdeskWalletDetails = new BillDeskDetails();
        billdeskWalletDetails.setIssuer("111");
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(billdeskWalletDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(dotpayDetails));

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
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(dotpayDetails));

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestGenericIssuerPaymentMethodDetails() {
        GenericIssuerPaymentMethodDetails genericIssuerPaymentMethodDetails = new GenericIssuerPaymentMethodDetails();
        genericIssuerPaymentMethodDetails.setIssuer("111");
        genericIssuerPaymentMethodDetails.setType(GenericIssuerPaymentMethodDetails.TypeEnum.EPS);

        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(genericIssuerPaymentMethodDetails));

        String jsonRequest = PRETTY_PRINT_GSON.toJson(PaymentRequest);
        assertJsonStringEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"issuer\": \"111\",\n"
                + "    \"type\": \"eps\"\n"
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
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(giropayDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(giropayDetails));

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestSamsungPayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"debit\",\"samsungPayToken\":\"samsungpaytoken\",\"type\":\"samsungpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        SamsungPayDetails samsungPayDetails = new SamsungPayDetails();
        samsungPayDetails.setFundingSource(SamsungPayDetails.FundingSourceEnum.DEBIT);
        samsungPayDetails.setSamsungPayToken("samsungpaytoken");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(samsungPayDetails));

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
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(samsungPayDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(vippsDetails));

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
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(vippsDetails));

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jacksonObject);
    }

    @Test
    public void TestVisaCheckoutDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"type\":\"visacheckout\",\"visaCheckoutCallId\":\"visacheckoutcallid\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        VisaCheckoutDetails visaCheckoutDetails = new VisaCheckoutDetails();
        visaCheckoutDetails.setFundingSource(VisaCheckoutDetails.FundingSourceEnum.DEBIT);
        visaCheckoutDetails.setVisaCheckoutCallId("visacheckoutcallid");
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(visaCheckoutDetails));

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestVisaCheckoutDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"type\":\"visacheckout\",\"visaCheckoutCallId\":\"visacheckoutcallid\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        VisaCheckoutDetails visaCheckoutDetails = new VisaCheckoutDetails();
        visaCheckoutDetails.setFundingSource(VisaCheckoutDetails.FundingSourceEnum.DEBIT);
        visaCheckoutDetails.setVisaCheckoutCallId("visacheckoutcallid");
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(visaCheckoutDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(storedPaymentMethodDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(cardDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(androidPayDetails));

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
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(androidPayDetails));

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
        klarnaDetails.setType(KlarnaDetails.TypeEnum.KLARNA);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(klarnaDetails));

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
        klarnaDetails.setType(KlarnaDetails.TypeEnum.KLARNA);
        PaymentRequest expectedPaymentRequest = createPaymentsCheckoutRequest();
        expectedPaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(klarnaDetails));

        PaymentRequest gson = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, gson);

        PaymentRequest jackson = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedPaymentRequest, jackson);
    }

    @Test
    public void TestMasterPassDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"masterpassTransactionId\":\"transactionId\",\"type\":\"masterpass\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MasterpassDetails masterpassDetails = new MasterpassDetails();
        masterpassDetails.setFundingSource(MasterpassDetails.FundingSourceEnum.DEBIT);
        masterpassDetails.setMasterpassTransactionId("transactionId");

        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(masterpassDetails));

        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestMasterPassDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"masterpassTransactionId\":\"transactionId\",\"type\":\"masterpass\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        MasterpassDetails masterpassDetails = new MasterpassDetails();
        masterpassDetails.setFundingSource(MasterpassDetails.FundingSourceEnum.DEBIT);
        masterpassDetails.setMasterpassTransactionId("transactionId");
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(masterpassDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(mobilePayDetails));

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
        expectedRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(mobilePayDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(payUUpiDetails));

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
        expectedRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(payUUpiDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(upiIntentDetails));

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
        expectedRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(upiIntentDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(upiCollectDetails));

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
        expectedRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(upiCollectDetails));

        PaymentRequest gsonObject = GSON.fromJson(json, PaymentRequest.class);
        assertEquals(expectedRequest, gsonObject);

        PaymentRequest jacksonObject = OBJECT_MAPPER.readValue(json, PaymentRequest.class);
        assertEquals(expectedRequest, jacksonObject);
    }

    @Test
    public void TestWeChatPayDetailsSerialization() throws JsonProcessingException {
        String expectedJson = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"appId\":\"appId\",\"openid\":\"openId\",\"type\":\"wechatpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        WeChatPayDetails weChatPayDetails = new WeChatPayDetails();
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(weChatPayDetails));
        String gson = GSON.toJson(PaymentRequest);
        assertJsonStringEquals(expectedJson, gson);

        String jackson = OBJECT_MAPPER.writeValueAsString(PaymentRequest);
        assertJsonStringEquals(expectedJson, jackson);
    }

    @Test
    public void TestWeChatPayDetailsDeserialization() throws JsonProcessingException {
        String json = "{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"appId\":\"appId\",\"openid\":\"openId\",\"type\":\"wechatpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";

        WeChatPayDetails weChatPayDetails = new WeChatPayDetails();
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(weChatPayDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(weChatPayMiniProgramDetails));

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
        expectedRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(weChatPayMiniProgramDetails));

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
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(blikDetails));

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
        expectedRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(blikDetails));

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
        dragonPayDetails.setType(DragonpayDetails.TypeEnum.EBANKING);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(dragonPayDetails));

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
        dragonPayDetails.setType(DragonpayDetails.TypeEnum.EBANKING);
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(dragonPayDetails));

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
        mbwayDetails.setType(MbwayDetails.TypeEnum.MBWAY);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(mbwayDetails));

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
        mbwayDetails.setType(MbwayDetails.TypeEnum.MBWAY);
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(mbwayDetails));

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
        molPayDetails.setType(MolPayDetails.TypeEnum.FPX_MY);
        PaymentRequest PaymentRequest = createPaymentsCheckoutRequest();
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(molPayDetails));

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
        molPayDetails.setType(MolPayDetails.TypeEnum.FPX_MY);
        PaymentRequest expectedRequest = createPaymentsCheckoutRequest();
        expectedRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(molPayDetails));
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
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setRecurringProcessingModel(PaymentRequest.RecurringProcessingModelEnum.CARDONFILE);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentRequest);
        assertTrue(jsonRequest.contains("recurringProcessingModel\": \"CardOnFile\"\n") || jsonRequest.contains("recurringProcessingModel\": \"CardOnFile\",\n"));

        paymentRequest.setRecurringProcessingModel(PaymentRequest.RecurringProcessingModelEnum.SUBSCRIPTION);
        jsonRequest = PRETTY_PRINT_GSON.toJson(paymentRequest);
        assertTrue(jsonRequest.contains("recurringProcessingModel\": \"Subscription\"\n") || jsonRequest.contains("recurringProcessingModel\": \"Subscription\",\n"));

        paymentRequest.setRecurringProcessingModel(PaymentRequest.RecurringProcessingModelEnum.UNSCHEDULEDCARDONFILE);
        jsonRequest = PRETTY_PRINT_GSON.toJson(paymentRequest);
        assertTrue(jsonRequest.contains("recurringProcessingModel\": \"UnscheduledCardOnFile\"\n") || jsonRequest.contains("recurringProcessingModel\": \"UnscheduledCardOnFile\",\n"));
    }

    @Test
    public void TestPaymentResponseChallengeShopper() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-3ds2-challenge-shopper.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest paymentRequest = createPaymentsCheckoutRequest();
        PaymentResponse paymentResponse = checkout.payments(paymentRequest);
        assertEquals(PaymentResponse.ResultCodeEnum.CHALLENGESHOPPER, paymentResponse.getResultCode());
        assertNotNull(paymentResponse.getAction());
        assertNotNull(paymentResponse.getAction().getCheckoutRedirectAction().getData());
        assertEquals(3, paymentResponse.getAction().getCheckoutRedirectAction().getData().size());
        assertEquals("POST", paymentResponse.getAction().getCheckoutRedirectAction().getMethod());
        assertEquals("Ab02b4c0!BQABAgA4e3wGkhVah4CJL19qdegdmm9E...", paymentResponse.getAction().getCheckoutRedirectAction().getData());
        assertEquals("scheme", paymentResponse.getAction().getCheckoutRedirectAction().getPaymentMethodType());
        assertEquals("https://test.adyen.com/hpp/3d/validate.shtml", paymentResponse.getAction().getCheckoutRedirectAction().getUrl());
        assertEquals(CheckoutRedirectAction.TypeEnum.REDIRECT, paymentResponse.getAction().getCheckoutRedirectAction().getType());
    }

    @Test
    public void TestPaymentResponseAuthenticationFinished() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-3ds2-authentication-finished.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest paymentRequest = createPaymentsCheckoutRequest();
        PaymentResponse paymentResponse = checkout.payments(paymentRequest);
        assertEquals(PaymentResponse.ResultCodeEnum.AUTHENTICATIONFINISHED, paymentResponse.getResultCode());
        assertNotNull(paymentResponse.getThreeDS2Result());
        assertNotNull(paymentResponse.getThreeDS2Result().getAuthenticationValue());
        assertNotNull(paymentResponse.getThreeDS2Result().getDsTransID());
        assertNotNull(paymentResponse.getThreeDS2Result().getEci());
        assertNotNull(paymentResponse.getThreeDS2Result().getMessageVersion());
        assertNotNull(paymentResponse.getThreeDS2Result().getThreeDSServerTransID());
        assertNotNull(paymentResponse.getThreeDS2Result().getTransStatus());
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
        PaymentRequest paymentRequest = createPaymentRequestWithOrder();
        PaymentResponse paymentResponse = checkout.payments(paymentRequest);
        assertEquals("payment reference", paymentResponse.getMerchantReference());
        assertEquals("881593078164515C", paymentResponse.getPspReference());
        assertEquals(PaymentResponse.ResultCodeEnum.AUTHORISED, paymentResponse.getResultCode());
        assertEquals("EUR", paymentResponse.getAmount().getCurrency());
        assertEquals((Long) 1000L, paymentResponse.getAmount().getValue());
        assertEquals("Ab02b4c0!BQABAgBqxSuFhuXUF7IvIRvSw5bDPHN...", paymentResponse.getOrder().getOrderData());
        assertEquals("order reference", paymentResponse.getOrder().getReference());
        assertEquals("8515930288670953", paymentResponse.getOrder().getPspReference());
        assertEquals("2020-06-25T20:01:07Z", paymentResponse.getOrder().getExpiresAt());
        assertEquals("EUR", paymentResponse.getOrder().getRemainingAmount().getCurrency());
        assertEquals((Long) 1500L, paymentResponse.getOrder().getRemainingAmount().getValue());
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
        PaymentRequest paymentRequest = createPaymentsCheckoutRequest();
        PaymentResponse paymentResponse = checkout.payments(paymentRequest);
        assertEquals(PaymentResponse.ResultCodeEnum.IDENTIFYSHOPPER, paymentResponse.getResultCode());
        assertEquals(CheckoutThreeDS2Action.TypeEnum.THREEDS2, paymentResponse.getAction().getCheckoutThreeDS2Action().getType());
        assertEquals("fingerprint", paymentResponse.getAction().getCheckoutThreeDS2Action().getSubtype());
        assertEquals("scheme", paymentResponse.getAction().getCheckoutThreeDS2Action().getPaymentMethodType());
    }

    /**
     * Start modifications endpoints tests
     */
    @Test public void TestPaymentsCaptures() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/checkout/captures-success.json");
        Checkout checkout = new Checkout(client);
        CreatePaymentCaptureRequest createPaymentCaptureRequest = new CreatePaymentCaptureRequest();
        createPaymentCaptureRequest.setAmount(new Amount().currency("EUR").value(1000L));
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
            createPaymentCaptureRequest.setAmount(new Amount().currency("EUR").value(1000L));
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
        createPaymentRefundRequest.setAmount(new Amount().currency("EUR").value(1000L));
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
            createPaymentRefundRequest.setAmount(new Amount().currency("EUR").value(1000L));
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
        createPaymentAmountUpdateRequest.setAmount(new Amount().currency("EUR").value(1000L));
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
            createPaymentAmountUpdateRequest.setAmount(new Amount().currency("EUR").value(1000L));
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

    protected PaymentSetupRequest createPaymentSessionRequest() {
        PaymentSetupRequest paymentSessionRequest = new PaymentSetupRequest();
        paymentSessionRequest.setAmount(new Amount().currency("USD").value(1000L));
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

        details.setType(CardDetails.TypeEnum.SCHEME);
        details.setEncryptedCardNumber("test_4111111111111111");
        details.setEncryptedExpiryMonth("test_10");
        details.setEncryptedExpiryYear("test_2030");
        details.setCvc("737");
        details.setHolderName("John Smith");

        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(details));

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

        details.setType(CardDetails.TypeEnum.SCHEME);
        details.setEncryptedCardNumber("test_4111111111111111");
        details.setEncryptedExpiryMonth("test_03");
        details.setEncryptedExpiryYear("test_2030");
        details.setCvc("737");
        details.setHolderName("John Smith");

        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(details));
        PaymentRequest.setReturnUrl("https://your-company.com/...");
        PaymentRequest.setMerchantAccount("MagentoMerchantTest");

        return PaymentRequest;
    }

    protected PaymentRequest createEncryptedPaymentsCheckoutRequestWithoutHoldername() {
        PaymentRequest PaymentRequest = new PaymentRequest();
        CardDetails details = new CardDetails();

        PaymentRequest.setReference("Your order number");
        PaymentRequest.setAmount(createAmountObject("USD", 1000L));

        details.setType(CardDetails.TypeEnum.SCHEME);
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
        PaymentRequest paymentRequest = new PaymentRequest();

        paymentRequest.setReference("Your order number");
        paymentRequest.setAmount(createAmountObject("USD", 1000L));
        CardDetails defaultPaymentMethodDetails = new CardDetails();
        defaultPaymentMethodDetails.setType(CardDetails.TypeEnum.NETWORKTOKEN);
        defaultPaymentMethodDetails.setBrand(BrandCodes.MASTERCARD);
        defaultPaymentMethodDetails.setExpiryMonth("08");
        defaultPaymentMethodDetails.setExpiryYear("2020");
        defaultPaymentMethodDetails.setHolderName("CARDHOLDER_NAME");
        defaultPaymentMethodDetails.setNumber("5555444433331111");
        defaultPaymentMethodDetails.setNetworkPaymentReference("MCC123456789012");

        paymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(defaultPaymentMethodDetails));

        paymentRequest.setReturnUrl("https://your-company.com/...");
        paymentRequest.setMerchantAccount("MagentoMerchantTest");
        paymentRequest.setShopperReference("YOUR_SHOPPER_REFERENCE");
        paymentRequest.setRecurringProcessingModel(PaymentRequest.RecurringProcessingModelEnum.CARDONFILE);

        return paymentRequest;
    }


    /**
     * Returns a sample PaymentsDetailsRequest opbject with test data
     */

    protected DetailsRequest createPaymentsDetailsRequest() {
        DetailsRequest paymentsDetailsRequest = new DetailsRequest();
        PaymentCompletionDetails completionDetails  = new PaymentCompletionDetails();
        completionDetails.setMD("mdValue");
        completionDetails.setPaRes("paResValue");
        completionDetails.setPayload("paymentDataValue");
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
        PaymentRequest.setAmount(new Amount().currency("EUR").value(1000L));

        details.setType(CardDetails.TypeEnum.SCHEME);
        details.setEncryptedCardNumber("test_4111111111111111");
        details.setEncryptedExpiryMonth("test_10");
        details.setEncryptedExpiryYear("test_2030");
        details.setCvc("737");
        details.setHolderName("John Smith");
        PaymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(details));

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
