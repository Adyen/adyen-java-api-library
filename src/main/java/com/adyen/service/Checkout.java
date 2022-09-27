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

package com.adyen.service;

import com.adyen.ApiKeyAuthenticatedService;
import com.adyen.Client;
import com.adyen.model.RequestOptions;
import com.adyen.model.checkout.*;
import com.adyen.service.exception.ApiException;
import com.adyen.model.checkout.PaymentRequest;
import com.adyen.model.checkout.PaymentResponse;
import com.adyen.service.resource.CheckoutResource;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Checkout extends ApiKeyAuthenticatedService {

    private final CheckoutResource cancels;
    private final CheckoutResource payments;
    private final CheckoutResource paymentMethods;
    private final CheckoutResource paymentsDetails;
    private final CheckoutResource paymentSession;
    private final CheckoutResource paymentsResult;
    private final CheckoutResource orders;
    private final CheckoutResource ordersCancel;
    private final CheckoutResource sessions;
    private final CheckoutResource paymentMethodsBalance;
    private final CheckoutResource applePaySessions;
    private final CheckoutResource donations;
    private final CheckoutResource cardDetails;

    public Checkout(Client client) {

        super(client);
        cancels = new CheckoutResource(this, "/cancels");
        payments = new CheckoutResource(this, "/payments");
        paymentMethods = new CheckoutResource(this, "/paymentMethods");
        paymentsDetails = new CheckoutResource(this, "/payments/details");
        paymentSession = new CheckoutResource(this, "/paymentSession");
        paymentsResult = new CheckoutResource(this, "/payments/result");
        orders = new CheckoutResource(this, "/orders");
        ordersCancel = new CheckoutResource(this, "/orders/cancel");
        sessions = new CheckoutResource(this, "/sessions");
        paymentMethodsBalance = new CheckoutResource(this, "/paymentMethods/balance");
        applePaySessions = new CheckoutResource(this, "/applePay/sessions");
        donations = new CheckoutResource(this, "/donations");
        cardDetails = new CheckoutResource(this,"/cardDetails");
    }

    /**
     * POST /payments API call
     *
     * @param PaymentRequest PaymentRequest
     * @return PaymentResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public PaymentResponse payments(PaymentRequest PaymentRequest) throws ApiException, IOException {
        return payments(PaymentRequest, null);
    }


    public PaymentResponse payments(PaymentRequest PaymentRequest, RequestOptions requestOptions) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(PaymentRequest);
        String jsonResult = payments.request(jsonRequest, requestOptions);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentResponse>() {
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
     * @return PaymentResponse PaymentResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public PaymentDetailsResponse paymentsDetails(DetailsRequest paymentsDetailsRequest) throws ApiException, IOException {
        return paymentsDetails(paymentsDetailsRequest, null);
    }

    public PaymentDetailsResponse paymentsDetails(DetailsRequest paymentsDetailsRequest, RequestOptions requestOptions) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentsDetailsRequest);
        String jsonResult = paymentsDetails.request(jsonRequest, requestOptions);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentDetailsResponse>() {
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

    public PaymentSetupResponse paymentSession(PaymentSetupRequest paymentSessionRequest) throws ApiException, IOException {
        return paymentSession(paymentSessionRequest, null);
    }

    public PaymentSetupResponse paymentSession(PaymentSetupRequest paymentSessionRequest, RequestOptions requestOptions) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentSessionRequest);
        String jsonResult = paymentSession.request(jsonRequest, requestOptions);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentSetupResponse>() {
        }.getType());
    }

    /**
     * POST payments/result API call
     *
     * @param paymentResultRequest paymentResultRequest
     * @return PaymentVerificationResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public PaymentVerificationResponse paymentResult(PaymentVerificationRequest paymentResultRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentResultRequest);
        String jsonResult = paymentsResult.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentVerificationResponse>() {
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
     * POST /sessions API call
     *
     * @param createCheckoutSessionRequest CreateCheckoutSessionRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public CreateCheckoutSessionResponse sessions(CreateCheckoutSessionRequest createCheckoutSessionRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(createCheckoutSessionRequest);
        String jsonResult = sessions.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<CreateCheckoutSessionResponse>() {
        }.getType());
    }

    /**
     * POST /payments/{paymentPspReference}/captures
     *
     * @param paymentPspReference         String
     * @param createPaymentCaptureRequest CreatePaymentCaptureRequest
     */
    public PaymentCaptureResource paymentsCaptures(String paymentPspReference, CreatePaymentCaptureRequest createPaymentCaptureRequest) throws ApiException, IOException {
        CheckoutResource paymentsCaptures = new CheckoutResource(this, "/payments/" + paymentPspReference + "/captures");
        String jsonRequest = GSON.toJson(createPaymentCaptureRequest);
        String jsonResult = paymentsCaptures.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentCaptureResource>() {
        }.getType());
    }

    /**
     * POST /payments/{paymentPspReference}/cancels
     *
     * @param paymentPspReference        String
     * @param createPaymentCancelRequest CreatePaymentCancelRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public PaymentCancelResource paymentsCancels(String paymentPspReference, CreatePaymentCancelRequest createPaymentCancelRequest) throws ApiException, IOException {
        CheckoutResource paymentsCancels = new CheckoutResource(this, "/payments/" + paymentPspReference + "/cancels");
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
    public StandalonePaymentCancelResource cancels(CreateStandalonePaymentCancelRequest createStandalonePaymentCancelRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(createStandalonePaymentCancelRequest);
        String jsonResult = cancels.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<StandalonePaymentCancelResource>() {
        }.getType());
    }

    /**
     * POST /payments/{paymentPspReference}/reversal
     *
     * @param paymentPspReference          String
     * @param createPaymentReversalRequest CreatePaymentReversalRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public PaymentReversalResource paymentsReversals(String paymentPspReference, CreatePaymentReversalRequest createPaymentReversalRequest) throws ApiException, IOException {
        CheckoutResource paymentReversal = new CheckoutResource(this, "/payments/" + paymentPspReference + "/reversals");
        String jsonRequest = GSON.toJson(createPaymentReversalRequest);
        String jsonResult = paymentReversal.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentReversalResource>() {
        }.getType());
    }

    /**
     * POST /payments/{paymentPspReference}/refunds
     *
     * @param paymentPspReference        String
     * @param createPaymentRefundRequest CreatePaymentRefundRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public PaymentRefundResource paymentsRefunds(String paymentPspReference, CreatePaymentRefundRequest createPaymentRefundRequest) throws ApiException, IOException {
        CheckoutResource paymentsRefunds = new CheckoutResource(this, "/payments/" + paymentPspReference + "/refunds");
        String jsonRequest = GSON.toJson(createPaymentRefundRequest);
        String jsonResult = paymentsRefunds.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentRefundResource>() {
        }.getType());
    }

    /**
     * POST /payments/{paymentPspReference}/amountUpdates
     *
     * @param paymentPspReference              String
     * @param createPaymentAmountUpdateRequest CreatePaymentAmountUpdateRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public PaymentAmountUpdateResource paymentsAmountUpdates(String paymentPspReference, CreatePaymentAmountUpdateRequest createPaymentAmountUpdateRequest) throws ApiException, IOException {
        CheckoutResource paymentsAmountUpdates = new CheckoutResource(this, "/payments/" + paymentPspReference + "/amountUpdates");
        String jsonRequest = GSON.toJson(createPaymentAmountUpdateRequest);
        String jsonResult = paymentsAmountUpdates.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentAmountUpdateResource>() {
        }.getType());
    }

    /**
     * POST /paymentMethods/balance
     *
     * @param checkoutBalanceCheckRequest CheckoutBalanceCheckRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public CheckoutBalanceCheckResponse paymentsMethodsBalance(CheckoutBalanceCheckRequest checkoutBalanceCheckRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(checkoutBalanceCheckRequest);
        String jsonResult = paymentMethodsBalance.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<CheckoutBalanceCheckResponse>() {
        }.getType());
    }

    /**
     * GET /paymentLinks/{linkId}
     *
     * @param linkId String
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public PaymentLinkResponse paymentLinks(String linkId) throws ApiException, IOException {
        CheckoutResource paymentLinks = new CheckoutResource(this, "/paymentLinks/" + linkId);
        String jsonResult = paymentLinks.request("{}");
        return GSON.fromJson(jsonResult, new TypeToken<PaymentLinkResponse>() {
        }.getType());
    }

    /**
     * POST /applePay/sessions
     *
     * @param createApplePaySessionRequest CreateApplePaySessionRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public ApplePaySessionResponse applePaySessions(CreateApplePaySessionRequest createApplePaySessionRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(createApplePaySessionRequest);
        String jsonResult = applePaySessions.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<ApplePaySessionResponse>() {
        }.getType());
    }

    /**
     * POST /donations
     *
     * @param paymentDonationRequest PaymentDonationRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public DonationResponse donations(PaymentDonationRequest paymentDonationRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentDonationRequest);
        String jsonResult = donations.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<DonationResponse>() {
        }.getType());
    }

    /**
     * POST /cardDetails
     *
     * @param cardDetailsRequest CardDetailsRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public CardDetailsResponse cardDetails(CardDetailsRequest cardDetailsRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(cardDetailsRequest);
        String jsonResult = cardDetails.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<CardDetailsResponse>() {
        }.getType());
    }
}