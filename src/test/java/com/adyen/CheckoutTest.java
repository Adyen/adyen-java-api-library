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

import com.adyen.model.Amount;
import com.adyen.model.checkout.*;
import com.adyen.service.Checkout;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests for
 * /paymentSession
 * /payments/result
 * <p>
 * /paymentMethods
 * /payments
 * /payments/details
 * /originKeys
 */
public class CheckoutTest extends BaseTest {
    /**
     * Test success flow for
     * POST /authorise
     */
    @Test
    public void TestPaymentsSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-success.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest paymentRequest = createPaymentsCheckoutRequest();
        PaymentResponse paymentResponse = checkout.payments(paymentRequest);
        assertEquals("8535296650153317", paymentResponse.getPspReference());
    }

    @Test
    public void TestPaymentsErrorMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/payments-error-invalid-data-422.json");
        Checkout checkout = new Checkout(client);
        PaymentRequest paymentRequest = createPaymentsCheckoutRequest();
        PaymentResponse paymentResponse = checkout.payments(paymentRequest);
        assertNull(paymentResponse.getPspReference());
    }

    @Test
    public void TestPaymentMethodsSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentmethods-success.json");
        Checkout checkout = new Checkout(client);
        PaymentMethodsRequest paymentMethodsRequest = new PaymentMethodsRequest();
        paymentMethodsRequest.setMerchantAccount("MagentoMerchantTest");
        PaymentMethodsResponse paymentMethodsResponse = checkout.paymentMethods(paymentMethodsRequest);
        assertEquals(65, paymentMethodsResponse.getPaymentMethods().size());
        assertEquals("AliPay", paymentMethodsResponse.getPaymentMethods().get(0).getName());
    }

    @Test
    public void TestPaymentMethodsErrorMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentmethods-error-forbidden-403.json");
        Checkout checkout = new Checkout(client);
        PaymentMethodsRequest paymentMethodsRequest = new PaymentMethodsRequest();
        paymentMethodsRequest.setMerchantAccount("MagentoMerchantTest");
        PaymentMethodsResponse paymentMethodsResponse = checkout.paymentMethods(paymentMethodsRequest);
        assertNull( paymentMethodsResponse.getPaymentMethods());
    }

    @Test
    public void TestPaymentsDetailsSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentsdetails-sucess.json");
        Checkout checkout = new Checkout(client);

        DetailsRequest detailsRequest = new DetailsRequest();
        detailsRequest.setPaymentData("Ab02b4c0!BQABAgCJN1wRZuGJmq8dMncmypvknj9s7l5Tj...");
        HashMap<String, String> details = new HashMap<>();
        details.put("MD", "sdfsdfsdf...");
        details.put("PaRes","sdfsdfsdf...");
        detailsRequest.setDetails(details);
        PaymentResponse paymentResponse = checkout.paymentsDetails(detailsRequest);
        assertEquals("Authorised", paymentResponse.getResultCode().toString());

    }

    @Test
    public void TestPaymentsDetailsErrorMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentsdetails-error-invalid-data-422.json");
        Checkout checkout = new Checkout(client);
        DetailsRequest detailsRequest = new DetailsRequest();
        detailsRequest.setPaymentData("Ab02b4c0!BQABAgCJN1wRZuGJmq8dMncmypvknj9s7l5Tj...");
        HashMap<String, String> details = new HashMap<>();
        details.put("MD", "sdfsdfsdf...");
        details.put("PaRes","sdfsdfsdf...");
        detailsRequest.setDetails(details);
        PaymentResponse paymentResponse = checkout.paymentsDetails(detailsRequest);
        assertNull(paymentResponse.getResultCode());

    }

    @Test
    public void TestPaymentSessionSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentsession-sucess.json");
        Checkout checkout = new Checkout(client);
        PaymentSetupRequest paymentSetupRequest = createPaymentSessionRequest();
        PaymentSetupResponse paymentSetupResponse = checkout.paymentSession(paymentSetupRequest);
        assertNotNull(paymentSetupResponse.getPaymentSession());
    }

    @Test
    public void TestPaymentSessionErrorMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentsession-error-invalid-data-422.json");
        Checkout checkout = new Checkout(client);
        PaymentSetupRequest paymentSetupRequest = createPaymentSessionRequest();
        PaymentSetupResponse paymentSetupResponse = checkout.paymentSession(paymentSetupRequest);
        assertNull(paymentSetupResponse.getPaymentSession());
    }

    @Test
    public void TestPaymentsResultSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentsresult-sucess.json");
        Checkout checkout = new Checkout(client);
        PaymentVerificationRequest paymentVerificationRequest = new PaymentVerificationRequest();
        paymentVerificationRequest.setPayload("This is a test payload");
        PaymentVerificationResponse paymentVerificationResponse = checkout.paymentResult(paymentVerificationRequest);
        assertEquals("Authorised", paymentVerificationResponse.getResultCode().toString());
    }

    @Test
    public void TestPaymentsResultErrorMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentsresult-error-invalid-data-payload-422.json");
        Checkout checkout = new Checkout(client);
        PaymentVerificationRequest paymentVerificationRequest = new PaymentVerificationRequest();
        paymentVerificationRequest.setPayload("This is a test payload");
        PaymentVerificationResponse paymentVerificationResponse = checkout.paymentResult(paymentVerificationRequest);
        assertNull(paymentVerificationResponse.getResultCode());
    }

    protected PaymentSetupRequest createPaymentSessionRequest() {
        PaymentSetupRequest paymentSetupRequest = new PaymentSetupRequest();
        paymentSetupRequest.setAmount(createAmountObject("USD",1000L));
        paymentSetupRequest.setReference("Your order number");
        paymentSetupRequest.setCountryCode("NL");
        paymentSetupRequest.setReturnUrl("https://your-company.com/...");
        paymentSetupRequest.setMerchantAccount("MagentoMerchantTest");
        return paymentSetupRequest;

    }

    /**
     * Returns a sample PaymentRequest opbject with full card data
     */
    protected PaymentRequest createPaymentsCheckoutRequest() {
        PaymentRequest paymentRequest = new PaymentRequest();

        paymentRequest.setReference("Your order number");
        paymentRequest.setAmount(createAmountObject("USD",1000L));
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setType("scheme");
        paymentRequest.setPaymentMethod(new HashMap<String, String>());

        paymentRequest.putPaymentMethodItem("number", "4111111111111111");
        paymentRequest.putPaymentMethodItem("expiryMonth", "08");
        paymentRequest.putPaymentMethodItem("expiryYear", "2018");
        paymentRequest.putPaymentMethodItem("holderName", "John Smith");
        paymentRequest.putPaymentMethodItem("cvc", "737");

        paymentRequest.setReturnUrl("https://your-company.com/...");
        paymentRequest.setMerchantAccount("MagentoMerchantTest");

        return paymentRequest;
    }

    protected Amount createAmountObject(String currency, Long value) {
        Amount amount = new Amount();
        amount.setCurrency(currency);
        amount.setValue(value);
        return amount;
    }
}
