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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.constants.BrandCodes;
import com.adyen.model.Address;
import com.adyen.model.Amount;
import com.adyen.model.checkout.*;
import com.adyen.model.checkout.details.*;
import com.adyen.service.Checkout;
import com.adyen.service.exception.ApiException;
import com.google.gson.annotations.SerializedName;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        assertEquals(26, paymentMethodsResponse.getPaymentMethods().size());
        assertEquals("Credit Card", paymentMethodsResponse.getPaymentMethods().get(0).getName());
        assertEquals(6, paymentMethodsResponse.getPaymentMethods().get(0).getBrands().size());
        assertTrue(paymentMethodsResponse.getPaymentMethods().get(0).getSupportsRecurring());
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
        PaymentsResponse paymentsResponse = checkout.paymentsDetails(createPaymentsDetailsRequest());
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
        PaymentsResponse paymentsResponse = checkout.paymentsDetails(createPaymentsDetailsRequest());
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
        assertEquals("2020-01-12T09:37:49",paymentsResponse.getAction().getExpiresAt());
        assertEquals("12101",paymentsResponse.getAction().getEntity());
        assertEquals("501 422 944",paymentsResponse.getAction().getReference());

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
                + "}",jsonRequest );
    }

    @Test
    public void TestSepaDirectDebitDetails() {
        SepaDirectDebitDetails sepaDirectDebitDetails = new SepaDirectDebitDetails();
        sepaDirectDebitDetails.setOwnerName("A. Schneider");
        sepaDirectDebitDetails.setIban("DE87123456781234567890");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(sepaDirectDebitDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);

        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"iban\": \"DE87123456781234567890\",\n"
                + "    \"ownerName\": \"A. Schneider\",\n"
                + "    \"type\": \"sepadirectdebit\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestAchDetails(){
        AchDetails achDetails = new AchDetails();
        achDetails.setBankAccountNumber("1234567");
        achDetails.setBankLocationId("1234567");
        achDetails.setEncryptedBankAccountNumber("1234asdfg");
        achDetails.setOwnerName("John Smith");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(achDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"bankAccountNumber\": \"1234567\",\n"
                + "    \"bankLocationId\": \"1234567\",\n"
                + "    \"encryptedBankAccountNumber\": \"1234asdfg\",\n"
                + "    \"ownerName\": \"John Smith\",\n"
                + "    \"type\": \"ach\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestEcontextVoucherDetails(){
        EcontextVoucherDetails econtextVoucherDetails = new EcontextVoucherDetails();
        econtextVoucherDetails.setFirstName("John");
        econtextVoucherDetails.setLastName("Smith");
        econtextVoucherDetails.setShopperEmail("test@email.com");
        econtextVoucherDetails.setTelephoneNumber("0123456789");
        econtextVoucherDetails.setType(EcontextVoucherDetails.SEVENELEVEN);

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(econtextVoucherDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"firstName\": \"John\",\n"
                + "    \"lastName\": \"Smith\",\n"
                + "    \"shopperEmail\": \"test@email.com\",\n"
                + "    \"telephoneNumber\": \"0123456789\",\n"
                + "    \"type\": \"econtext_seveneleven\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestIdealDetails(){
        IdealDetails idealDetails = new IdealDetails();
        idealDetails.setIssuer("1121");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(idealDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"issuer\": \"1121\",\n"
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
                + "}",jsonRequest );
    }

    @Test
    public void TestGooglePayDetails(){
        GooglePayDetails googlePayDetails = new GooglePayDetails();
        googlePayDetails.setGooglePayToken("Payload as retrieved from Google Pay response");
        googlePayDetails.setFundingSource(GooglePayDetails.FundingSourceEnum.CREDIT);
        googlePayDetails.setGooglePayCardNetwork("googlepaycardnetwork");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(googlePayDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"fundingSource\": \"credit\",\n"
                + "    \"googlePayCardNetwork\": \"googlepaycardnetwork\",\n"
                + "    \"googlePayToken\": \"Payload as retrieved from Google Pay response\",\n"
                + "    \"type\": \"paywithgoogle\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestPayPalDetails(){
        PayPalDetails payPalDetails = new PayPalDetails();
        payPalDetails.setOrderID("orderId");
        payPalDetails.setPayerID("payerId");
        payPalDetails.setSubtype(PayPalDetails.SubtypeEnum.SDK);

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(payPalDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"orderID\": \"orderId\",\n"
                + "    \"payerID\": \"payerId\",\n"
                + "    \"type\": \"paypal\",\n"
                + "    \"subtype\": \"sdk\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestDokuDetails(){
        DokuDetails dokuDetails = new DokuDetails();
        dokuDetails.setFirstName("John");
        dokuDetails.setInfix("infix");
        dokuDetails.setLastName("Smith");
        dokuDetails.setOvoId("ovoid");
        dokuDetails.setShopperEmail("test@email.com");
        dokuDetails.setType(DokuDetails.INDOMARET);

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(dokuDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"firstName\": \"John\",\n"
                + "    \"infix\": \"infix\",\n"
                + "    \"lastName\": \"Smith\",\n"
                + "    \"ovoId\": \"ovoid\",\n"
                + "    \"shopperEmail\": \"test@email.com\",\n"
                + "    \"type\": \"doku_indomaret\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestAmazonPayDetails(){
        AmazonPayDetails amazonPayDetails = new AmazonPayDetails();
        amazonPayDetails.setAmazonPayToken("amazonpaytoken");
        amazonPayDetails.setCheckoutSessionId("checkoutsessionid");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(amazonPayDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"amazonPayToken\": \"amazonpaytoken\",\n"
                + "    \"checkoutSessionId\": \"checkoutsessionid\",\n"
                + "    \"type\": \"amazonpay\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestApplePayDetails(){
        ApplePayDetails applePayDetails = new ApplePayDetails();
        applePayDetails.setApplePayToken("applepaytoken");
        applePayDetails.setFundingSource(ApplePayDetails.FundingSourceEnum.CREDIT);

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(applePayDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"applePayToken\": \"applepaytoken\",\n"
                + "    \"fundingSource\": \"credit\",\n"
                + "    \"type\": \"applepay\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestBilldeskOnlineDetails(){
        BillDeskOnlineDetails billdeskOnlineDetails = new BillDeskOnlineDetails();
        billdeskOnlineDetails.setIssuer("111");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(billdeskOnlineDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"issuer\": \"111\",\n"
                + "    \"type\": \"billdesk_online\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestBilldeskWalletDetails(){
        BillDeskWalletDetails billdeskWalletDetails = new BillDeskWalletDetails();
        billdeskWalletDetails.setIssuer("111");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(billdeskWalletDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"issuer\": \"111\",\n"
                + "    \"type\": \"billdesk_wallet\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestDotpayDetails(){
        DotpayDetails dotpayDetails = new DotpayDetails();
        dotpayDetails.setIssuer("111");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(dotpayDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"issuer\": \"111\",\n"
                + "    \"type\": \"dotpay\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestEntercashDetails(){
        EntercashDetails entercashDetails = new EntercashDetails();
        entercashDetails.setIssuer("111");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(entercashDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"issuer\": \"111\",\n"
                + "    \"type\": \"entercash\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestGenericIssuerPaymentMethodDetails(){
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
                + "}",jsonRequest );
    }

    @Test
    public void TestGiropayDetails(){
        GiropayDetails giropayDetails = new GiropayDetails();

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(giropayDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"type\": \"giropay\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestQiwiWalletDetails(){
        QiwiWalletDetails qiwiWalletDetails = new QiwiWalletDetails();
        qiwiWalletDetails.setTelephoneNumber("123456789");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(qiwiWalletDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"telephoneNumber\": \"123456789\",\n"
                + "    \"type\": \"qiwiwallet\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestSamsungPayDetails(){
        SamsungPayDetails samsungPayDetails = new SamsungPayDetails();
        samsungPayDetails.setFundingSource(SamsungPayDetails.FundingSourceEnum.CREDIT);
        samsungPayDetails.setSamsungPayToken("samsungpaytoken");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(samsungPayDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"fundingSource\": \"credit\",\n"
                + "    \"samsungPayToken\": \"samsungpaytoken\",\n"
                + "    \"type\": \"samsungpay\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestVippsDetails(){
        VippsDetails vippsDetails = new VippsDetails();
        vippsDetails.setTelephoneNumber("123456789");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(vippsDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"telephoneNumber\": \"123456789\",\n"
                + "    \"type\": \"vipps\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestVisaCheckoutDetails(){
        VisaCheckoutDetails visaCheckoutDetails = new VisaCheckoutDetails();
        visaCheckoutDetails.setFundingSource(VisaCheckoutDetails.FundingSourceEnum.CREDIT);
        visaCheckoutDetails.setVisaCheckoutCallId("visacheckoutcallid");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(visaCheckoutDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);
        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"fundingSource\": \"credit\",\n"
                + "    \"type\": \"visacheckout\",\n"
                + "    \"visaCheckoutCallId\": \"visacheckoutcallid\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
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
                + "}",jsonRequest );
    }

    @Test
    public void TestAndroidPayDetails() {
        AndroidPayDetails androidPayDetails = new AndroidPayDetails();
        androidPayDetails.setAndroidPayToken("androidpaytoken");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(androidPayDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);

        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"androidPayToken\": \"androidpaytoken\",\n"
                + "    \"type\": \"androidpay\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestKlarnaDetails() {
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

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);

        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"bankAccount\": \"bankaccount\",\n"
                + "    \"billingAddress\": \"billingaddress\",\n"
                + "    \"deliveryAddress\": \"deliveryaddress\",\n"
                + "    \"installmentConfigurationKey\": \"installmentconfigurationkey\",\n"
                + "    \"personalDetails\": \"personaldetails\",\n"
                + "    \"separateDeliveryAddress\": \"separatedeliveryaddress\",\n"
                + "    \"storedPaymentMethodId\": \"storedpaymentmethodid\",\n"
                + "    \"token\": \"token\",\n"
                + "    \"type\": \"klarna\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestMasterPassDetails() {
        MasterpassDetails masterpassDetails = new MasterpassDetails();
        masterpassDetails.setFundingSource(MasterpassDetails.FundingSourceEnum.CREDIT);
        masterpassDetails.setMasterpassTransactionId("transactionId");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(masterpassDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);

        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"fundingSource\": \"credit\",\n"
                + "    \"masterpassTransactionId\": \"transactionId\",\n"
                + "    \"type\": \"masterpass\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestMobilePayDetails() {
        MobilePayDetails mobilePayDetails = new MobilePayDetails();

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(mobilePayDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);

        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"type\": \"mobilepay\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestPayUUpiDetails() {
        PayUUpiDetails payUUpiDetails = new PayUUpiDetails();
        payUUpiDetails.setVpa("vpa");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(payUUpiDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);

        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"type\": \"payu_IN_upi\",\n"
                + "    \"vpa\": \"vpa\"\n" + ""
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestWeChatPayDetails() {
        WeChatPayDetails weChatPayDetails = new WeChatPayDetails();
        weChatPayDetails.setAppId("appId");
        weChatPayDetails.setOpenid("openId");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(weChatPayDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);

        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"appId\": \"appId\",\n" + ""
                + "    \"openid\": \"openId\",\n" + ""
                + "    \"type\": \"wechatpay\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
    }

    @Test
    public void TestWeChatPayMiniProgramDetails() {
        WeChatPayMiniProgramDetails weChatPayMiniProgramDetails = new WeChatPayMiniProgramDetails();
        weChatPayMiniProgramDetails.setAppId("appId");
        weChatPayMiniProgramDetails.setOpenid("openId");

        PaymentsRequest paymentsRequest = createPaymentsCheckoutRequest();
        paymentsRequest.setPaymentMethod(weChatPayMiniProgramDetails);

        String jsonRequest = PRETTY_PRINT_GSON.toJson(paymentsRequest);

        assertEquals("{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 1000,\n"
                + "    \"currency\": \"USD\"\n"
                + "  },\n"
                + "  \"merchantAccount\": \"MagentoMerchantTest\",\n"
                + "  \"paymentMethod\": {\n"
                + "    \"appId\": \"appId\",\n" + ""
                + "    \"openid\": \"openId\",\n" + ""
                + "    \"type\": \"wechatpayMiniProgram\"\n"
                + "  },\n"
                + "  \"reference\": \"Your order number\",\n"
                + "  \"returnUrl\": \"https://your-company.com/...\",\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}",jsonRequest );
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
                + "}",jsonRequest );
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
        assertEquals("Ab02b4c0!BQABAgA4e3wGkhVah4CJL19qdegdmm9E...", paymentsResponse.getPaymentData());
        assertNotNull(paymentsResponse.getDetails());
        assertEquals(1, paymentsResponse.getDetails().size());
        assertEquals("threeds2.challengeResult", paymentsResponse.getDetails().get(0).getKey());
        assertEquals("text", paymentsResponse.getDetails().get(0).getType());
        assertNotNull(paymentsResponse.getAuthentication());
        assertEquals(1, paymentsResponse.getAuthentication().size());
        assertEquals("S0zYWQ0MGEwMjU2MjEifQ==", paymentsResponse.getAuthentication().get("threeds2.challengeToken"));
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
    public void TestPaymentLinksSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payment-links-success.json");
        Checkout checkout = new Checkout(client);
        CreatePaymentLinkRequest createPaymentLinkRequest = createPaymentLinkRequest();
        CreatePaymentLinkResponse createPaymentLinkResponse = checkout.paymentLinks(createPaymentLinkRequest);
        assertNotNull(createPaymentLinkResponse);
        assertNotNull(createPaymentLinkResponse.getUrl());
        assertNotNull(createPaymentLinkResponse.getExpiresAt());
        assertNotNull(createPaymentLinkResponse.getAmount());
        assertNotNull(createPaymentLinkResponse.getReference());
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

    @Test
    public void TestPaymentLinksErrorMerchantMissing() throws IOException {
        Client client = createMockClientForErrors(403,"mocks/checkout/payment-links-error-merchant.json");
        Checkout checkout = new Checkout(client);
        CreatePaymentLinkRequest createPaymentLinkRequest = createPaymentLinkRequest();
        try {
            checkout.paymentLinks(createPaymentLinkRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals("901", e.getError().getErrorCode());
            assertEquals(403, e.getError().getStatus());
        }
    }

    @Test
    public void TestPaymentLinksErrorAmountMissing() throws IOException {
        Client client = createMockClientForErrors(422,"mocks/checkout/payment-links-error-amount.json");
        Checkout checkout = new Checkout(client);
        CreatePaymentLinkRequest createPaymentLinkRequest = createPaymentLinkRequest();
        try {
            checkout.paymentLinks(createPaymentLinkRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals("100", e.getError().getErrorCode());
            assertEquals(422, e.getError().getStatus());
        }
    }

    @Test
    public void TestPaymentLinksErrorReferenceMissing() throws IOException {
        Client client = createMockClientForErrors(422,"mocks/checkout/payment-links-error-reference.json");
        Checkout checkout = new Checkout(client);
        CreatePaymentLinkRequest createPaymentLinkRequest = createPaymentLinkRequest();
        try {
            checkout.paymentLinks(createPaymentLinkRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals("130", e.getError().getErrorCode());
            assertEquals(422, e.getError().getStatus());
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
        assertEquals((Long)2500L, checkoutCreateOrderResponse.getRemainingAmount().getValue());
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
        assertEquals((Long)1000L, paymentsResponse.getAmount().getValue());
        assertEquals("Ab02b4c0!BQABAgBqxSuFhuXUF7IvIRvSw5bDPHN...", paymentsResponse.getOrder().getOrderData());
        assertEquals("order reference", paymentsResponse.getOrder().getReference());
        assertEquals("8515930288670953", paymentsResponse.getOrder().getPspReference());
        assertEquals("2020-06-25T20:01:07Z", paymentsResponse.getOrder().getExpiresAt());
        assertEquals("EUR", paymentsResponse.getOrder().getRemainingAmount().getCurrency());
        assertEquals((Long)1500L, paymentsResponse.getOrder().getRemainingAmount().getValue());
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

    /**
     * Returns a sample PaymentsRequest opbject with test data
     */
    protected CreatePaymentLinkRequest createPaymentLinkRequest() {
        CreatePaymentLinkRequest createPaymentLinkRequest = new CreatePaymentLinkRequest();

        createPaymentLinkRequest.setReference("YOUR_ORDER_NUMBER");
        createPaymentLinkRequest.setAmount(createAmountObject("BRL", 1000L));
        createPaymentLinkRequest.setCountryCode("BR");
        createPaymentLinkRequest.setMerchantAccount("MagentoMerchantTest");
        createPaymentLinkRequest.setShopperReference("YOUR_UNIQUE_SHOPPER_ID");
        createPaymentLinkRequest.setShopperEmail("test@email.com");
        createPaymentLinkRequest.setShopperLocale("pt_BR");
        createPaymentLinkRequest.setExpiresAt("2019-12-17T10:05:29Z");
        Address address = new Address();
        address.setStreet("Street");
        address.setPostalCode("59000060");
        address.setCity("City");
        address.setHouseNumberOrName("999");
        address.setCountry("BR");
        address.setStateOrProvince("SP");
        createPaymentLinkRequest.setBillingAddress(address);
        createPaymentLinkRequest.setDeliveryAddress(address);

        return createPaymentLinkRequest;
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
