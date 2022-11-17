package com.adyen.service;

import com.adyen.ApiKeyAuthenticatedService;
import com.adyen.Client;
import com.adyen.model.RequestOptions;
import com.adyen.model.checkout.ApplePaySessionResponse;
import com.adyen.model.checkout.ApplicationInfo;
import com.adyen.model.checkout.CardDetailsRequest;
import com.adyen.model.checkout.CardDetailsResponse;
import com.adyen.model.checkout.CheckoutBalanceCheckRequest;
import com.adyen.model.checkout.CheckoutBalanceCheckResponse;
import com.adyen.model.checkout.CheckoutCancelOrderRequest;
import com.adyen.model.checkout.CheckoutCancelOrderResponse;
import com.adyen.model.checkout.CheckoutCreateOrderRequest;
import com.adyen.model.checkout.CheckoutCreateOrderResponse;
import com.adyen.model.checkout.CommonField;
import com.adyen.model.checkout.CreateApplePaySessionRequest;
import com.adyen.model.checkout.CreateCheckoutSessionRequest;
import com.adyen.model.checkout.CreateCheckoutSessionResponse;
import com.adyen.model.checkout.CreatePaymentAmountUpdateRequest;
import com.adyen.model.checkout.CreatePaymentCancelRequest;
import com.adyen.model.checkout.CreatePaymentCaptureRequest;
import com.adyen.model.checkout.CreatePaymentLinkRequest;
import com.adyen.model.checkout.CreatePaymentRefundRequest;
import com.adyen.model.checkout.CreatePaymentReversalRequest;
import com.adyen.model.checkout.CreateStandalonePaymentCancelRequest;
import com.adyen.model.checkout.DetailsRequest;
import com.adyen.model.checkout.DonationResponse;
import com.adyen.model.checkout.JSON;
import com.adyen.model.checkout.PaymentAmountUpdateResource;
import com.adyen.model.checkout.PaymentCancelResource;
import com.adyen.model.checkout.PaymentCaptureResource;
import com.adyen.model.checkout.PaymentDetailsResponse;
import com.adyen.model.checkout.PaymentDonationRequest;
import com.adyen.model.checkout.PaymentLinkResponse;
import com.adyen.model.checkout.PaymentMethodsRequest;
import com.adyen.model.checkout.PaymentMethodsResponse;
import com.adyen.model.checkout.PaymentRefundResource;
import com.adyen.model.checkout.PaymentRequest;
import com.adyen.model.checkout.PaymentResponse;
import com.adyen.model.checkout.PaymentReversalResource;
import com.adyen.model.checkout.PaymentSetupRequest;
import com.adyen.model.checkout.PaymentSetupResponse;
import com.adyen.model.checkout.PaymentVerificationRequest;
import com.adyen.model.checkout.PaymentVerificationResponse;
import com.adyen.model.checkout.StandalonePaymentCancelResource;
import com.adyen.model.checkout.UpdatePaymentLinkRequest;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.CheckoutResource;


import java.io.IOException;
import java.util.Optional;

import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;
import static com.adyen.constants.ApiConstants.HttpMethod.GET;
import static com.adyen.constants.ApiConstants.HttpMethod.PATCH;

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
    private final CheckoutResource paymentLinks;

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
        cardDetails = new CheckoutResource(this, "/cardDetails");
        paymentLinks = new CheckoutResource(this, "/paymentLinks");
        new JSON();

    }

    /**
     * Get ApplicationInfo for checkout request objects.
     * Fills the object with Library info and returns it so it can be set on the request object.
     * @param applicationInfo ApplicationInfo
     * @return ApplicationInfo
     */
    private ApplicationInfo setApplicationInfo(ApplicationInfo applicationInfo) {
        return Optional.ofNullable(applicationInfo)
                .orElse(new ApplicationInfo())
                .adyenLibrary(new CommonField().name(LIB_NAME).version(LIB_VERSION));
    }

    /**
     * POST /payments API call
     *
     * @param paymentRequest PaymentRequest
     * @return PaymentResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public PaymentResponse payments(PaymentRequest paymentRequest) throws ApiException, IOException {
        return payments(paymentRequest, null);
    }


    public PaymentResponse payments(PaymentRequest paymentRequest, RequestOptions requestOptions) throws ApiException, IOException {
        paymentRequest.setApplicationInfo(setApplicationInfo(paymentRequest.getApplicationInfo()));
        String jsonRequest = paymentRequest.toJson();
        String jsonResult = payments.request(jsonRequest, requestOptions);
        return PaymentResponse.fromJson(jsonResult);
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
        String jsonRequest = paymentMethodsRequest.toJson();
        String jsonResult = paymentMethods.request(jsonRequest);
        return PaymentMethodsResponse.fromJson(jsonResult);
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
        String jsonRequest = paymentsDetailsRequest.toJson();
        String jsonResult = paymentsDetails.request(jsonRequest, requestOptions);
        return PaymentDetailsResponse.fromJson(jsonResult);
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
        paymentSessionRequest.setApplicationInfo(setApplicationInfo(paymentSessionRequest.getApplicationInfo()));
        String jsonRequest = paymentSessionRequest.toJson();
        String jsonResult = paymentSession.request(jsonRequest, requestOptions);
        return PaymentSetupResponse.fromJson(jsonResult);
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
        String jsonRequest = paymentResultRequest.toJson();
        String jsonResult = paymentsResult.request(jsonRequest);
        return PaymentVerificationResponse.fromJson(jsonResult);
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
        String jsonRequest = checkoutCreateOrderRequest.toJson();
        String jsonResult = orders.request(jsonRequest);
        return CheckoutCreateOrderResponse.fromJson(jsonResult);
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
        String jsonRequest = checkoutCancelOrderRequest.toJson();
        String jsonResult = ordersCancel.request(jsonRequest);
        return CheckoutCancelOrderResponse.fromJson(jsonResult);
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
        createCheckoutSessionRequest.setApplicationInfo(setApplicationInfo(createCheckoutSessionRequest.getApplicationInfo()));
        String jsonRequest = createCheckoutSessionRequest.toJson();
        String jsonResult = sessions.request(jsonRequest);
        return CreateCheckoutSessionResponse.fromJson(jsonResult);
    }

    /**
     * POST /payments/{paymentPspReference}/captures
     *
     * @param paymentPspReference         String
     * @param createPaymentCaptureRequest CreatePaymentCaptureRequest
     */
    public PaymentCaptureResource paymentsCaptures(String paymentPspReference, CreatePaymentCaptureRequest createPaymentCaptureRequest) throws ApiException, IOException {
        return paymentsCaptures(paymentPspReference, createPaymentCaptureRequest, null);
    }

    public PaymentCaptureResource paymentsCaptures(String paymentPspReference, CreatePaymentCaptureRequest createPaymentCaptureRequest, RequestOptions requestOptions) throws ApiException, IOException {
        CheckoutResource paymentsCaptures = new CheckoutResource(this, "/payments/" + paymentPspReference + "/captures");
        String jsonRequest = createPaymentCaptureRequest.toJson();
        String jsonResult = paymentsCaptures.request(jsonRequest, requestOptions);
        return PaymentCaptureResource.fromJson(jsonResult);
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
        return paymentsCancels(paymentPspReference, createPaymentCancelRequest, null);
    }

    public PaymentCancelResource paymentsCancels(String paymentPspReference, CreatePaymentCancelRequest createPaymentCancelRequest, RequestOptions requestOptions) throws ApiException, IOException {
        CheckoutResource paymentsCancels = new CheckoutResource(this, "/payments/" + paymentPspReference + "/cancels");
        String jsonRequest = createPaymentCancelRequest.toJson();
        String jsonResult = paymentsCancels.request(jsonRequest, requestOptions);
        return PaymentCancelResource.fromJson(jsonResult);
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
        return cancels(createStandalonePaymentCancelRequest, null);
    }

    public StandalonePaymentCancelResource cancels(CreateStandalonePaymentCancelRequest createStandalonePaymentCancelRequest, RequestOptions requestOptions) throws ApiException, IOException {
        String jsonRequest = createStandalonePaymentCancelRequest.toJson();
        String jsonResult = cancels.request(jsonRequest, requestOptions);
        return StandalonePaymentCancelResource.fromJson(jsonResult);
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
        return paymentsReversals(paymentPspReference, createPaymentReversalRequest, null);
    }

    public PaymentReversalResource paymentsReversals(String paymentPspReference, CreatePaymentReversalRequest createPaymentReversalRequest, RequestOptions requestOptions) throws ApiException, IOException {
        CheckoutResource paymentReversal = new CheckoutResource(this, "/payments/" + paymentPspReference + "/reversals");
        String jsonRequest = createPaymentReversalRequest.toJson();
        String jsonResult = paymentReversal.request(jsonRequest, requestOptions);
        return PaymentReversalResource.fromJson(jsonResult);
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
        return paymentsRefunds(paymentPspReference, createPaymentRefundRequest, null);
    }

    public PaymentRefundResource paymentsRefunds(String paymentPspReference, CreatePaymentRefundRequest createPaymentRefundRequest, RequestOptions requestOptions) throws ApiException, IOException {
        CheckoutResource paymentsRefunds = new CheckoutResource(this, "/payments/" + paymentPspReference + "/refunds");
        String jsonRequest = createPaymentRefundRequest.toJson();
        String jsonResult = paymentsRefunds.request(jsonRequest, requestOptions);
        return PaymentRefundResource.fromJson(jsonResult);
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
        return paymentsAmountUpdates(paymentPspReference, createPaymentAmountUpdateRequest, null);
    }

    public PaymentAmountUpdateResource paymentsAmountUpdates(String paymentPspReference, CreatePaymentAmountUpdateRequest createPaymentAmountUpdateRequest, RequestOptions requestOptions) throws ApiException, IOException {
        CheckoutResource paymentsAmountUpdates = new CheckoutResource(this, "/payments/" + paymentPspReference + "/amountUpdates");
        String jsonRequest = createPaymentAmountUpdateRequest.toJson();
        String jsonResult = paymentsAmountUpdates.request(jsonRequest, requestOptions);
        return PaymentAmountUpdateResource.fromJson(jsonResult);
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
        String jsonRequest = checkoutBalanceCheckRequest.toJson();
        String jsonResult = paymentMethodsBalance.request(jsonRequest);
        return CheckoutBalanceCheckResponse.fromJson(jsonResult);
    }

    /**
     * POST /paymentLinks
     *
     * @param createPaymentLinkRequest CreatePaymentLinkRequest
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public PaymentLinkResponse paymentLinks(CreatePaymentLinkRequest createPaymentLinkRequest) throws ApiException, IOException {
        createPaymentLinkRequest.setApplicationInfo(setApplicationInfo(createPaymentLinkRequest.getApplicationInfo()));
        String jsonRequest = createPaymentLinkRequest.toJson();
        String jsonResult = paymentLinks.request(jsonRequest);
        return PaymentLinkResponse.fromJson(jsonResult);
    }

    /**
     * GET /paymentLinks/{linkId}
     *
     * @param linkId String
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public PaymentLinkResponse getPaymentLinks(String linkId) throws ApiException, IOException {
        CheckoutResource paymentLinks = new CheckoutResource(this, "/paymentLinks/" + linkId);
        String jsonResult = paymentLinks.request("{}", GET);
        return PaymentLinkResponse.fromJson(jsonResult);
    }

    /**
     * PATCH /paymentLinks/{linkId}
     *
     * @param updatePaymentLinkRequest UpdatePaymentLinkRequest
     * @param linkId String
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public PaymentLinkResponse patchPaymentLinks(String linkId, UpdatePaymentLinkRequest updatePaymentLinkRequest) throws ApiException, IOException {
        CheckoutResource paymentLinks = new CheckoutResource(this, "/paymentLinks/" + linkId);
        String jsonRequest = updatePaymentLinkRequest.toJson();
        String jsonResult = paymentLinks.request(jsonRequest, PATCH);
        return PaymentLinkResponse.fromJson(jsonResult);
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
        String jsonRequest = createApplePaySessionRequest.toJson();
        String jsonResult = applePaySessions.request(jsonRequest);
        return ApplePaySessionResponse.fromJson(jsonResult);
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
        paymentDonationRequest.setApplicationInfo(setApplicationInfo(paymentDonationRequest.getApplicationInfo()));
        String jsonRequest = paymentDonationRequest.toJson();
        String jsonResult = donations.request(jsonRequest);
        return DonationResponse.fromJson(jsonResult);
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
        String jsonRequest = cardDetailsRequest.toJson();
        String jsonResult = cardDetails.request(jsonRequest);
        return CardDetailsResponse.fromJson(jsonResult);
    }
}
