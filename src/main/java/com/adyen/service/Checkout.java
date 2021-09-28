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

package com.adyen.service;

import com.adyen.ApiKeyAuthenticatedService;
import com.adyen.Client;
import com.adyen.model.RequestOptions;
import com.adyen.model.checkout.*;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.checkout.*;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Checkout extends ApiKeyAuthenticatedService {

    private Cancels cancels;
    private Payments payments;
    private PaymentMethods paymentMethods;
    private PaymentsDetails paymentsDetails;
    private PaymentSession paymentSession;
    private PaymentsResult paymentsResult;
    private Orders orders;
    private OrdersCancel ordersCancel;
    private StoredPaymentsMethods storedPaymentsMethods;

    public Checkout(Client client) {

        super(client);
        cancels = new Cancels(this);
        payments = new Payments(this);
        paymentMethods = new PaymentMethods(this);
        paymentsDetails = new PaymentsDetails(this);
        paymentSession = new PaymentSession(this);
        paymentsResult = new PaymentsResult(this);
        orders = new Orders(this);
        ordersCancel = new OrdersCancel(this);
        storedPaymentsMethods = new StoredPaymentsMethods(this);

    }

    /**
     * POST /payments API call
     *
     * @param paymentsRequest PaymentsRequest
     * @return paymentsResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public PaymentsResponse payments(PaymentsRequest paymentsRequest) throws ApiException, IOException {
        return payments(paymentsRequest, null);
    }


    public PaymentsResponse payments(PaymentsRequest paymentsRequest, RequestOptions requestOptions) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentsRequest);
        String jsonResult = payments.request(jsonRequest, requestOptions);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentsResponse>() {
        }.getType());
    }

    /**
     * POST /paymentMethods API call
     *
     * @param paymentMethodsRequest PaymentMethodsRequest
     * @return paymentMethodsResponse PaymentMethodsResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */

    public PaymentMethodsResponse paymentMethods(PaymentMethodsRequest paymentMethodsRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentMethodsRequest);
        String jsonResult = paymentMethods.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentMethodsResponse>() {
        }.getType());

    }

    /**
     * POST payments/details API call
     *
     * @param paymentsDetailsRequest paymentsDetailsRequest
     * @return paymentsResponse paymentsResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public PaymentsDetailsResponse paymentsDetails(PaymentsDetailsRequest paymentsDetailsRequest) throws ApiException, IOException {
        return paymentsDetails(paymentsDetailsRequest, null);
    }

    public PaymentsDetailsResponse paymentsDetails(PaymentsDetailsRequest paymentsDetailsRequest, RequestOptions requestOptions) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentsDetailsRequest);
        String jsonResult = paymentsDetails.request(jsonRequest, requestOptions);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentsDetailsResponse>() {
        }.getType());
    }

    /**
     * POST /paymentSession API call
     *
     * @param paymentSessionRequest paymentSessionRequest
     * @return paymentSessionResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */

    public PaymentSessionResponse paymentSession(PaymentSessionRequest paymentSessionRequest) throws ApiException, IOException {
        return paymentSession(paymentSessionRequest, null);
    }

    public PaymentSessionResponse paymentSession(PaymentSessionRequest paymentSessionRequest, RequestOptions requestOptions) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentSessionRequest);
        String jsonResult = paymentSession.request(jsonRequest, requestOptions);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentSessionResponse>() {
        }.getType());
    }

    /**
     * POST payments/result API call
     *
     * @param paymentResultRequest paymentResultRequest
     * @return paymentResultResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public PaymentResultResponse paymentResult(PaymentResultRequest paymentResultRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentResultRequest);
        String jsonResult = paymentsResult.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentResultResponse>() {
        }.getType());
    }

    /**
     * POST /storedPaymentMethods API call
     *
     * @param createStoredPaymentMethodRequest StoredPaymentMethodsRequest
     * @return storedPaymentMethod
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public StoredPaymentMethodResource storedPaymentMethods(CreateStoredPaymentMethodRequest createStoredPaymentMethodRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(createStoredPaymentMethodRequest);
        String jsonResult = storedPaymentsMethods.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<StoredPaymentMethodResource>() {
        }.getType());
    }

    /**
     * POST /orders API call
     *
     * @param checkoutCreateOrderRequest CheckoutCreateOrderRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public CheckoutCreateOrderResponse orders(CheckoutCreateOrderRequest checkoutCreateOrderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(checkoutCreateOrderRequest);
        String jsonResult = orders.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<CheckoutCreateOrderResponse>() {
        }.getType());
    }

    /**
     * POST /orders/cancel API call
     *
     * @param checkoutCancelOrderRequest CheckoutCancelOrderRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public CheckoutCancelOrderResponse ordersCancel(CheckoutCancelOrderRequest checkoutCancelOrderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(checkoutCancelOrderRequest);
        String jsonResult = ordersCancel.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<CheckoutCancelOrderResponse>() {
        }.getType());
    }

    /**
     * POST /payments/{paymentPspReference}/captures
     *
     * @param paymentPspReference String
     * @param createPaymentCaptureRequest CreatePaymentCaptureRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public PaymentCaptureResource paymentsCaptures(String paymentPspReference, CreatePaymentCaptureRequest createPaymentCaptureRequest) throws ApiException, IOException{
        PaymentsCaptures paymentsCaptures = new PaymentsCaptures(this, paymentPspReference);
        String jsonRequest = GSON.toJson(createPaymentCaptureRequest);
        String jsonResult = paymentsCaptures.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentCaptureResource>() {
        }.getType());
    }

    /**
     * POST /payments/{paymentPspReference}/cancels
     *
     * @param paymentPspReference String
     * @param createPaymentCancelRequest CreatePaymentCancelRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public PaymentCancelResource paymentsCancels(String paymentPspReference, CreatePaymentCancelRequest createPaymentCancelRequest) throws ApiException, IOException{
        PaymentsCancels paymentsCancels = new PaymentsCancels(this, paymentPspReference);
        String jsonRequest = GSON.toJson(createPaymentCancelRequest);
        String jsonResult = paymentsCancels.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentCancelResource>() {
        }.getType());
    }

    /**
     * POST /cancels
     *
     * @param createStandalonePaymentCancelRequest CreateStandalonePaymentCancelRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public StandalonePaymentCancelResource cancels(CreateStandalonePaymentCancelRequest createStandalonePaymentCancelRequest) throws ApiException, IOException{
        String jsonRequest = GSON.toJson(createStandalonePaymentCancelRequest);
        String jsonResult = cancels.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<StandalonePaymentCancelResource>() {
        }.getType());
    }

    /**
     * POST /payments/{paymentPspReference}/refunds
     *
     * @param paymentPspReference String
     * @param createPaymentRefundRequest CreatePaymentRefundRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public PaymentRefundResource paymentsRefunds(String paymentPspReference, CreatePaymentRefundRequest createPaymentRefundRequest) throws ApiException, IOException{
        PaymentsRefunds paymentsRefunds = new PaymentsRefunds(this, paymentPspReference);
        String jsonRequest = GSON.toJson(createPaymentRefundRequest);
        String jsonResult = paymentsRefunds.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentRefundResource>() {
        }.getType());
    }

    /**
     * POST /payments/{paymentPspReference}/amountUpdates
     *
     * @param paymentPspReference String
     * @param createPaymentAmountUpdateRequest CreatePaymentAmountUpdateRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public PaymentAmountUpdateResource paymentsAmountUpdates(String paymentPspReference, CreatePaymentAmountUpdateRequest createPaymentAmountUpdateRequest) throws ApiException, IOException{
        PaymentsAmountUpdates paymentsAmountUpdates = new PaymentsAmountUpdates(this, paymentPspReference);
        String jsonRequest = GSON.toJson(createPaymentAmountUpdateRequest);
        String jsonResult = paymentsAmountUpdates.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentAmountUpdateResource>() {
        }.getType());
    }

}
