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

package com.adyen.service;

import java.io.IOException;
import com.adyen.ApiKeyAuthenticatedService;
import com.adyen.Client;
import com.adyen.model.RequestOptions;
import com.adyen.model.checkout.PaymentMethodsRequest;
import com.adyen.model.checkout.PaymentMethodsResponse;
import com.adyen.model.checkout.PaymentResultRequest;
import com.adyen.model.checkout.PaymentResultResponse;
import com.adyen.model.checkout.PaymentSessionRequest;
import com.adyen.model.checkout.PaymentSessionResponse;
import com.adyen.model.checkout.PaymentsDetailsRequest;
import com.adyen.model.checkout.PaymentsRequest;
import com.adyen.model.checkout.PaymentsResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.checkout.PaymentMethods;
import com.adyen.service.resource.checkout.PaymentSession;
import com.adyen.service.resource.checkout.Payments;
import com.adyen.service.resource.checkout.PaymentsDetails;
import com.adyen.service.resource.checkout.PaymentsResult;
import com.google.gson.reflect.TypeToken;


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
     * @param paymentsRequest  PaymentsRequest
     * @return paymentsResponse
     * @throws IOException IOException
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
     * @throws IOException IOException
     * @throws  ApiException ApiException
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
     * @throws IOException IOException
     * @throws  ApiException ApiException
     */
    public PaymentsResponse paymentsDetails(PaymentsDetailsRequest paymentsDetailsRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentsDetailsRequest);
        String jsonResult = paymentsDetails.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentsResponse>() {
        }.getType());

    }

    /**
     * POST /paymentSession API call
     *
     * @param paymentSessionRequest paymentSessionRequest
     * @return paymentSessionResponse
     * @throws IOException IOException
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
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public PaymentResultResponse paymentResult(PaymentResultRequest paymentResultRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentResultRequest);
        String jsonResult = paymentsResult.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentResultResponse>() {
        }.getType());
    }

}
