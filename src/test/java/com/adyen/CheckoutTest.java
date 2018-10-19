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
 * Copyright (c) 2018 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.model.Amount;
import com.adyen.model.checkout.*;
import com.adyen.service.Checkout;
import org.junit.Test;

import java.util.HashMap;

import static com.adyen.enums.Environment.LIVE;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests for
 * /paymentSession
 * /payments/result
 * /paymentMethods
 * /payments
 * /payments/details
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
        assertEquals(65, paymentMethodsResponse.getPaymentMethods().size());
        assertEquals("AliPay", paymentMethodsResponse.getPaymentMethods().get(0).getName());
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
    public void TestPaymentMethodsFailureMissingIdentifierOnLive() throws Exception {
        Client client = createMockClientFromFile("mocks/checkout/paymentsresult-error-invalid-data-payload-422.json");
        client.setEnvironment(LIVE);
        try {
            new Checkout(client);
        } catch (IllegalArgumentException e) {
            assertEquals("Please provide your unique live url prefix on the setEnvironment() call on the Client or provide checkoutEndpoint in your config object.", e.getMessage());
        }

    }

    /**
     * Returns a sample PaymentSessionRequest opbject with test data
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
     * Returns a sample PaymentsRequest opbject with test data
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
}
