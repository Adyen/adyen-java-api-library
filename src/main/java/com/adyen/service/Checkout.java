/**
 * ######
 * ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 * ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 * ############   ############  #############   ############  #####  ######
 * ######
 * #############
 * ############
 * <p>
 * Adyen Java API Library
 * <p>
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service;

import com.adyen.ApiKeyAuthenticatedService;
import com.adyen.Client;
import com.adyen.model.checkout.*;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.checkout.*;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Checkout extends ApiKeyAuthenticatedService {

    private Payments payments;
    private PaymentMethods paymentMethods;
    private PaymentsDetails paymentsDetails;
    private PaymentSession paymentSession;
    private PaymentsResult paymentsResult;

    public Checkout(Client client) {

        super(client);
        payments = new Payments(this);
        paymentMethods = new PaymentMethods(this);
        paymentsDetails = new PaymentsDetails(this);
        paymentSession = new PaymentSession(this);
        paymentsResult = new PaymentsResult(this);
    }

    /**
     * POST /payments API call
     *
     * @param paymentRequest
     * @return paymentResponse
     * @throws IOException
     * @throws ApiException
     */
    public PaymentResponse payments(PaymentRequest paymentRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentRequest);
        String jsonResult = payments.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentResponse>() {
        }.getType());

    }

    /**
     * POST /paymentMethods API call
     *
     * @param paymentMethodsRequest
     * @return paymentMethodsResponse
     * @throws IOException
     * @throws ApiException
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
     * @param detailsRequest
     * @return paymentResponse
     * @throws IOException
     * @throws ApiException
     */
    public PaymentResponse paymentsDetails(DetailsRequest detailsRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(detailsRequest);
        String jsonResult = paymentsDetails.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentResponse>() {
        }.getType());

    }

    /**
     * POST /paymentSession API call
     *
     * @param paymentSetupRequest
     * @return paymentSetupResponse
     * @throws IOException
     * @throws ApiException
     */

    public PaymentSetupResponse paymentSession(PaymentSetupRequest paymentSetupRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentSetupRequest);
        String jsonResult = paymentSession.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentSetupResponse>() {
        }.getType());
    }

    /**
     * POST payments/result API call
     *
     * @param paymentVerificationRequest
     * @return paymentVerificationResponse
     * @throws IOException
     * @throws ApiException
     */

    public PaymentVerificationResponse paymentResult(PaymentVerificationRequest paymentVerificationRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentVerificationRequest);
        String jsonResult = paymentsResult.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentVerificationResponse>() {
        }.getType());
    }

}
