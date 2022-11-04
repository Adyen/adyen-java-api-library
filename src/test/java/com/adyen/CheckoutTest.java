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

import com.adyen.enums.Environment;
import com.adyen.httpclient.AdyenHttpClient;
import com.adyen.httpclient.HTTPClientException;

import com.adyen.model.checkout.Amount;
import com.adyen.model.checkout.ApplePaySessionResponse;
import com.adyen.model.checkout.CardDetails;
import com.adyen.model.checkout.CardDetailsRequest;
import com.adyen.model.checkout.CardDetailsResponse;
import com.adyen.model.checkout.CheckoutBalanceCheckRequest;
import com.adyen.model.checkout.CheckoutCancelOrderRequest;
import com.adyen.model.checkout.CheckoutCancelOrderResponse;
import com.adyen.model.checkout.CheckoutCreateOrderRequest;
import com.adyen.model.checkout.CheckoutCreateOrderResponse;
import com.adyen.model.checkout.CheckoutOrder;
import com.adyen.model.checkout.CheckoutRedirectAction;
import com.adyen.model.checkout.CreateApplePaySessionRequest;
import com.adyen.model.checkout.CreateCheckoutSessionRequest;
import com.adyen.model.checkout.CreateCheckoutSessionResponse;
import com.adyen.model.checkout.CreatePaymentLinkRequest;
import com.adyen.model.checkout.DetailsRequest;
import com.adyen.model.checkout.DonationResponse;
import com.adyen.model.checkout.IdealDetails;
import com.adyen.model.checkout.JSON;
import com.adyen.model.checkout.PaymentDetailsResponse;
import com.adyen.model.checkout.PaymentDonationRequest;
import com.adyen.model.checkout.PaymentDonationRequestPaymentMethod;
import com.adyen.model.checkout.PaymentLinkResponse;
import com.adyen.model.checkout.PaymentMethodsRequest;
import com.adyen.model.checkout.PaymentMethodsResponse;
import com.adyen.model.checkout.PaymentRequest;
import com.adyen.model.checkout.PaymentResponse;
import com.adyen.model.checkout.PaymentVerificationRequest;
import com.adyen.model.checkout.PaymentVerificationResponse;
import com.adyen.model.checkout.UpdatePaymentLinkRequest;
import com.adyen.service.Checkout;

import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckoutTest extends BaseTest {
    protected Client createMockErrorClient(String response) {
        AdyenHttpClient adyenHttpClient = mock(AdyenHttpClient.class);
        try {
            when(adyenHttpClient.request(anyString(), any(), any(Config.class), anyBoolean(), isNull(), any())).thenThrow(new HTTPClientException("HTTP Exception"));
        } catch (IOException | HTTPClientException e) {
            e.printStackTrace();
        }
        Client client = new Client();
        client.setHttpClient(adyenHttpClient);
        client.setEnvironment(Environment.TEST, null);
        return client;
    }

    /**
     * Should make a payment
     */
    @Test
    public void TestPaymentSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentResponse.json");
        Amount amount = new Amount().currency("EUR").value(1000L);
        CardDetails cardDetails = new CardDetails();
        cardDetails.encryptedCardNumber("5136333333333335")
                .holderName("John Doe")
                .cvc("737")
                .encryptedExpiryMonth("08")
                .encryptedExpiryYear("2018");
        cardDetails.setType(CardDetails.TypeEnum.SCHEME);
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setAmount(amount);
        paymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(cardDetails));
        Checkout checkout = new Checkout(client);
        PaymentResponse paymentResponse = checkout.payments(paymentRequest);
        assertEquals("993617895204576J", paymentResponse.getPspReference());
        assertEquals(CheckoutRedirectAction.TypeEnum.REDIRECT, paymentResponse.getAction().getCheckoutRedirectAction().getType());
        assertEquals("https://checkoutshopper-test.adyen.com/checkoutshopper/threeDS/redirect?MD=M2R...", paymentResponse.getAction().getCheckoutRedirectAction().getUrl());
    }

    /**
     * Should be able to stringify and parse paymentMethod in PaymentRequest (test oneOf serialization and deserialization)
     */
    @Test
    public void TestPaymentRequestSerialization() throws Exception {
        new JSON();
        String paymentRequestJson = getFileContents("mocks/checkout/paymentRequest.json");
        IdealDetails idealDetails = new IdealDetails();
        idealDetails.setIssuer("issuerName");
        Amount amount = new Amount().currency("EUR").value(1000L);
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setAmount(amount);
        paymentRequest.setMerchantAccount("myMerchantAccount");
        paymentRequest.setReference("merchantReference");
        paymentRequest.setReturnUrl("http://return.com");
        paymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(idealDetails));

        PaymentRequest parsedPaymentRequest = PaymentRequest.fromJson(paymentRequestJson);
        assertEquals(IdealDetails.TypeEnum.IDEAL, parsedPaymentRequest.getPaymentMethod().getIdealDetails().getType());
        assertEquals("EUR", parsedPaymentRequest.getAmount().getCurrency());
    }

    /**
     * Should make paymentMethods call
     */
    @Test
    public void TestPaymentMethodsSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentMethodsResponse.json");
        PaymentMethodsRequest paymentMethodsRequest = new PaymentMethodsRequest();
        paymentMethodsRequest.setMerchantAccount("myMerchantAccount");
        Checkout checkout = new Checkout(client);
        PaymentMethodsResponse paymentMethodsResponse = checkout.paymentMethods(paymentMethodsRequest);
        assertEquals(1, paymentMethodsResponse.getPaymentMethods().size());
        assertEquals("klarna", paymentMethodsResponse.getPaymentMethods().get(0).getType());

    }
    /**
     * Should make paymentLink call
     */
    @Test
    public void TestPaymentLinkSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentLinkResponse.json");
        CreatePaymentLinkRequest createPaymentLinkRequest = new CreatePaymentLinkRequest();
        Amount amount = new Amount().currency("EUR").value(500L);
        createPaymentLinkRequest.setAmount(amount);
        createPaymentLinkRequest.setMerchantAccount("myMerchantAccount");
        createPaymentLinkRequest.setReference("merchantReference");
        Checkout checkout = new Checkout(client);
        PaymentLinkResponse paymentLinkResponse = checkout.paymentLinks(createPaymentLinkRequest);
        assertEquals("https://test.adyen.link/PL6DB3157D27FFBBCF", paymentLinkResponse.getUrl());
        assertEquals(PaymentLinkResponse.StatusEnum.ACTIVE, paymentLinkResponse.getStatus());
    }

    /**
     * Should make paymentLink get call
     */
    @Test
    public void TestGetPaymentLinkSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/getPaymentLinkResponse.json");

        Checkout checkout = new Checkout(client);
        PaymentLinkResponse paymentLinkResponse = checkout.getPaymentLinks("linkId");
        assertEquals("shopper-reference", paymentLinkResponse.getReference());
        assertEquals(PaymentLinkResponse.StatusEnum.EXPIRED, paymentLinkResponse.getStatus());
    }

    /**
     * Should make paymentLink patch call
     */
    @Test
    public void TestPatchPaymentLinkSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/patchPaymentLinkResponse.json");

        UpdatePaymentLinkRequest updatePaymentLinkRequest = new UpdatePaymentLinkRequest();
        updatePaymentLinkRequest.setStatus(UpdatePaymentLinkRequest.StatusEnum.EXPIRED);
        Checkout checkout = new Checkout(client);
        PaymentLinkResponse paymentLinkResponse = checkout.patchPaymentLinks("linkId", updatePaymentLinkRequest);
        assertEquals("shopper-reference", paymentLinkResponse.getReference());
        assertEquals(PaymentLinkResponse.StatusEnum.EXPIRED, paymentLinkResponse.getStatus());
    }

    /**
     * Should make payments/details call
     */
    @Test
    public void TestPaymentDetailsSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentDetailsResponse.json");
        DetailsRequest detailsRequest = new DetailsRequest();
        detailsRequest.setPaymentData("STATE_DATA");
        Checkout checkout = new Checkout(client);
        PaymentDetailsResponse paymentDetailsResponse = checkout.paymentsDetails(detailsRequest);
        assertEquals(PaymentDetailsResponse.ResultCodeEnum.AUTHORISED, paymentDetailsResponse.getResultCode());
        assertEquals("V4HZ4RBFJGXXGN82", paymentDetailsResponse.getPspReference());
    }

    /**
     * Should make sessions call
     */
    @Test
    public void TestCreateSessionsSuccessCall() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/createSessionsResponse.json");
        CreateCheckoutSessionRequest sessionRequest = new CreateCheckoutSessionRequest();
        sessionRequest.setReturnUrl("https://your-company.com/checkout?shopperOrder=12xy..");
        sessionRequest.setCountryCode("NL");
        sessionRequest.setReference("YOUR_PAYMENT_REFERENCE");
        sessionRequest.setMerchantAccount("YOUR_MERCHANT_ACCOUNT");
        Amount amount = new Amount().currency("EUR").value(100L);
        sessionRequest.setAmount(amount);
        Checkout checkout = new Checkout(client);
        CreateCheckoutSessionResponse createCheckoutSessionResponse = checkout.sessions(sessionRequest);
        assertEquals("Ab02b4c0!BFHSPFBQTEwM0NBNTM3RfCf5", createCheckoutSessionResponse.getSessionData());
        assertEquals("CS1453E3730C313478", createCheckoutSessionResponse.getId());
    }

    /**
     * Should make paymentsResults call
     */
    @Test
    public void TestPaymentsResultsSuccessCall() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentResultsResponse.json");
        PaymentVerificationRequest paymentVerificationRequest = new PaymentVerificationRequest();
        paymentVerificationRequest.setPayload("PAYLOAD");
        Checkout checkout = new Checkout(client);
        PaymentVerificationResponse paymentVerificationResponse = checkout.paymentResult(paymentVerificationRequest);
        assertEquals(PaymentVerificationResponse.ResultCodeEnum.AUTHORISED, paymentVerificationResponse.getResultCode());
        assertEquals("V4HZ4RBFJGXXGN82", paymentVerificationResponse.getPspReference());
    }

    /**
     * Should make orders call
     */
    @Test
    public void TestCreateOrderSuccessCall() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/createOrderResponse.json");
        CheckoutCreateOrderRequest checkoutCreateOrderRequest = new CheckoutCreateOrderRequest();
        Amount amount = new Amount().currency("EUR").value(2500L);
        checkoutCreateOrderRequest.setAmount(amount);
        checkoutCreateOrderRequest.setReference("YOUR_ORDER_REFERENCE");
        checkoutCreateOrderRequest.setMerchantAccount("YOUR_MERCHANT_ACOUNT");
        Checkout checkout = new Checkout(client);
        CheckoutCreateOrderResponse checkoutCreateOrderResponse= checkout.orders(checkoutCreateOrderRequest);
        assertEquals("8616178914061985", checkoutCreateOrderResponse.getPspReference());
        assertEquals("Abzt3JH4wnzErMnOZwSdgA==", checkoutCreateOrderResponse.getOrderData());
    }

    /**
     * Should make ordersCancel call
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
    public void TestCancelOrderSuccessCall() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/cancelOrderResponse.json");
        CheckoutCancelOrderRequest checkoutCancelOrderRequest = new CheckoutCancelOrderRequest();
        checkoutCancelOrderRequest.setMerchantAccount("YOUR_MERCHANT_ACCOUNT");
        CheckoutOrder checkoutOrder = new CheckoutOrder();
        checkoutOrder.setPspReference("8815517812932012");
        checkoutOrder.setOrderData("823fh892f8f18f4...148f13f9f3f");
        checkoutCancelOrderRequest.setOrder(checkoutOrder);
        Checkout checkout = new Checkout(client);
        CheckoutCancelOrderResponse checkoutCancelOrderResponse = checkout.ordersCancel(checkoutCancelOrderRequest);
        assertEquals(CheckoutCancelOrderResponse.ResultCodeEnum.RECEIVED, checkoutCancelOrderResponse.getResultCode());
        assertEquals("8816178914079738", checkoutCancelOrderResponse.getPspReference());
    }

    /**
     * Should make applePaySessions call
     */
    @Test
    public void TestApplePaySessionsSuccessCall() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/applePaySessionsResponse.json");
        CreateApplePaySessionRequest createApplePaySessionRequest = new CreateApplePaySessionRequest();
        createApplePaySessionRequest.setDisplayName("YOUR_MERCHANT_NAME");
        createApplePaySessionRequest.setDomainName("YOUR_DOMAIN_NAME");
        createApplePaySessionRequest.setMerchantIdentifier("YOUR_MERCHANT_ID");
        Checkout checkout = new Checkout(client);
        ApplePaySessionResponse applePaySessionResponse = checkout.applePaySessions(createApplePaySessionRequest);
        assertEquals("eyJ2Z", applePaySessionResponse.getData());
    }

    /**
     * Should make donations call
     */
    @Test
    public void TestDonationsSuccessCall() throws Exception {
        Client client =  createMockClientFromFile("mocks/checkout/donationResponse.json");
        PaymentDonationRequest paymentDonationRequest = new PaymentDonationRequest();
        Amount amount = new Amount().currency("EUR").value(1000L);
        paymentDonationRequest.setAmount(amount);
        paymentDonationRequest.setDonationAccount("YOUR_DONATION_ACCOUNT");
        paymentDonationRequest.setMerchantAccount("YOUR_MERCHANT_ACCOUNT");
        CardDetails cardDetails = new CardDetails().type(CardDetails.TypeEnum.SCHEME);
        paymentDonationRequest.paymentMethod(new PaymentDonationRequestPaymentMethod(cardDetails));
        paymentDonationRequest.setReference("YOUR_MERCHANT_REFERENCE");
        paymentDonationRequest.setReturnUrl("https://your-company.com/...");
        Checkout checkout = new Checkout(client);
        DonationResponse donationResponse = checkout.donations(paymentDonationRequest);
        assertEquals(PaymentResponse.ResultCodeEnum.AUTHORISED ,donationResponse.getPayment().getResultCode());
        assertEquals("UNIQUE_RESOURCE_ID", donationResponse.getId());
        assertEquals(DonationResponse.StatusEnum.COMPLETED, donationResponse.getStatus());
    }

    /**
     * Should make cardDetails call
     */
    @Test
    public void TestCardDetailsRequestSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/cardDetailsResponse.json");
        CardDetailsRequest cardDetailsRequest = new CardDetailsRequest();
        cardDetailsRequest.setCardNumber("123412341234");
        cardDetailsRequest.setMerchantAccount("YOUR_MERCHANT_ACCOUNT");
        Checkout checkout = new Checkout(client);
        CardDetailsResponse cardDetailsResponse = checkout.cardDetails(cardDetailsRequest);
        assertEquals(2, cardDetailsResponse.getBrands().size());
        assertEquals("visa", cardDetailsResponse.getBrands().get(0).getType());
        assertEquals(true, cardDetailsResponse.getBrands().get(0).getSupported());
    }

    /**
     * Should properly (de)serialize Dates
     */
    @Test
    public void TestDateSerialization() throws Exception {
        new JSON();
        CheckoutBalanceCheckRequest checkoutBalanceCheckRequest = new CheckoutBalanceCheckRequest();
        Date date = new Date();
        date.setTime(1665500907000L); // Tuesday, October 11, 2022 5:08:27 PM GMT+02:00 DST
        checkoutBalanceCheckRequest.setDateOfBirth(date);
        Amount amount = new Amount().currency("EUR").value(1000L);
        checkoutBalanceCheckRequest.setAmount(amount);
        checkoutBalanceCheckRequest.setMerchantAccount("YOUR_MERCHANT_ACCOUNT");
        checkoutBalanceCheckRequest.setReference("YOUR_MERCHANT_REFERENCE");
        Map<String, String> paymentMethod = new HashMap<>();
        checkoutBalanceCheckRequest.setPaymentMethod(paymentMethod);
        String checkoutBalanceRequestJson = checkoutBalanceCheckRequest.toJson();
        assert(checkoutBalanceRequestJson.contains("\"dateOfBirth\":\"2022-10-11T15:08:27.000Z\""));
        assertEquals(1665500907000L, CheckoutBalanceCheckRequest.fromJson(checkoutBalanceRequestJson).getDateOfBirth().getTime());

    }
}
