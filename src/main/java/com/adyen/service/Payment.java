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
package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.RequestOptions;
import com.adyen.model.payments.AdjustAuthorisationRequest;
import com.adyen.model.payments.ApplicationInfo;
import com.adyen.model.payments.AuthenticationResultRequest;
import com.adyen.model.payments.AuthenticationResultResponse;
import com.adyen.model.payments.CancelOrRefundRequest;
import com.adyen.model.payments.CancelRequest;
import com.adyen.model.payments.CaptureRequest;
import com.adyen.model.payments.CommonField;
import com.adyen.model.payments.DonationRequest;
import com.adyen.model.payments.JSON;
import com.adyen.model.payments.ModificationResult;
import com.adyen.model.payments.PaymentRequest;
import com.adyen.model.payments.PaymentRequest3d;
import com.adyen.model.payments.PaymentRequest3ds2;
import com.adyen.model.payments.PaymentResult;
import com.adyen.model.payments.RefundRequest;
import com.adyen.model.payments.TechnicalCancelRequest;
import com.adyen.model.payments.ThreeDS2ResultRequest;
import com.adyen.model.payments.ThreeDS2ResultResponse;
import com.adyen.model.payments.VoidPendingRefundRequest;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.PaymentResource;

import java.io.IOException;
import java.util.Optional;

import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;

public class Payment extends Service {

    private final PaymentResource authorise;
    private final PaymentResource authorise3D;
    private final PaymentResource authorise3DS2;
    private final PaymentResource retrieve3DS2Result;
    private final PaymentResource getAuthenticationResult;
    private final PaymentResource capture;
    private final PaymentResource cancel;
    private final PaymentResource refund;
    private final PaymentResource cancelOrRefund;
    private final PaymentResource technicalCancel;
    private final PaymentResource adjustAuthorisation;
    private final PaymentResource donate;
    private final PaymentResource voidPendingRefund;

    public Payment(Client client) {
        super(client);

        authorise = new PaymentResource(this, "/authorise");
        authorise3D = new PaymentResource(this, "/authorise3d");
        authorise3DS2 = new PaymentResource(this, "/authorise3ds2");
        retrieve3DS2Result = new PaymentResource(this, "/retrieve3ds2Result");
        getAuthenticationResult = new PaymentResource(this, "/getAuthenticationResult");
        capture = new PaymentResource(this, "/capture");
        cancel  = new PaymentResource(this, "/cancel");
        refund = new PaymentResource(this, "/refund");
        cancelOrRefund = new PaymentResource(this, "/cancelOrRefund");
        technicalCancel = new PaymentResource(this, "/technicalCancel");
        adjustAuthorisation = new PaymentResource(this, "/adjustAuthorisation");
        donate = new PaymentResource(this, "/donate");
        voidPendingRefund = new PaymentResource(this, "/voidPendingRefund");
        new JSON();
    }

    /**
     * POST /authorise API call
     *
     * @param paymentRequest paymentRequest
     * @return PaymentResult
     * @throws ApiException ApiException
     * @throws IOException  IOException
     */
    public PaymentResult authorise(PaymentRequest paymentRequest) throws ApiException, IOException {
        return authorise(paymentRequest, null);
    }

    public PaymentResult authorise(PaymentRequest paymentRequest, RequestOptions requestOptions) throws ApiException, IOException {
        paymentRequest.setApplicationInfo(addLibrary(paymentRequest.getApplicationInfo()));
        String jsonRequest = paymentRequest.toJson();
        String jsonResult = authorise.request(jsonRequest, requestOptions);
        return PaymentResult.fromJson(jsonResult);
    }

    /**
     * POST /authorise3d API call
     *
     * @param paymentRequest3d authorise3D
     * @return PaymentResult
     * @throws Exception Exception
     */
    public PaymentResult authorise3D(PaymentRequest3d paymentRequest3d) throws Exception {
        paymentRequest3d.setApplicationInfo(addLibrary(paymentRequest3d.getApplicationInfo()));
        String jsonRequest = paymentRequest3d.toJson();

        String jsonResult = authorise3D.request(jsonRequest);

        return PaymentResult.fromJson(jsonResult);
    }

    /**
     * POST /authorise3ds2 API call
     *
     * @param paymentRequest3ds2 PaymentRequest3ds2
     * @return PaymentResult
     * @throws Exception Exception
     */
    public PaymentResult authorise3DS2(PaymentRequest3ds2 paymentRequest3ds2) throws Exception {
        paymentRequest3ds2.setApplicationInfo(addLibrary(paymentRequest3ds2.getApplicationInfo()));
        String jsonRequest = paymentRequest3ds2.toJson();

        String jsonResult = authorise3DS2.request(jsonRequest);

        return PaymentResult.fromJson(jsonResult);
    }

    /**
     * POST /retrieve3ds2Result API call
     *
     * @deprecated Use /getAuthenticationResult instead
     * @param threeDS2ResultRequest PaymentRequest3ds2
     * @return PaymentResult
     * @throws Exception Exception
     */
    @Deprecated
    public ThreeDS2ResultResponse retrieve3ds2Result(ThreeDS2ResultRequest threeDS2ResultRequest) throws Exception {
        String jsonRequest = threeDS2ResultRequest.toJson();

        String jsonResult = retrieve3DS2Result.request(jsonRequest);

        return ThreeDS2ResultResponse.fromJson(jsonResult);
    }

    /**
     * POST /getAuthenticationResult API call
     *
     * @param authenticationResultRequest AuthenticationResultRequest
     * @return AuthenticationResultResponse
     * @throws ApiException ApiException
     * @throws IOException  IOException
     */
    public AuthenticationResultResponse getAuthenticationResult(AuthenticationResultRequest authenticationResultRequest) throws IOException, ApiException {
        String jsonRequest = authenticationResultRequest.toJson();

        String jsonResult = getAuthenticationResult.request(jsonRequest);

        return AuthenticationResultResponse.fromJson(jsonResult);
    }

    /**
     * Overwrite library version
     */
    private ApplicationInfo addLibrary(ApplicationInfo applicationInfo) {
        return Optional.ofNullable(applicationInfo)
                .orElse(new ApplicationInfo())
                .adyenLibrary(new CommonField().name(LIB_NAME).version(LIB_VERSION));
    }

    /**
     * POST /capture API call
     *
     * @param captureRequest CaptureRequest
     * @return ModificationResult
     * @throws ApiException ApiException
     * @throws IOException  IOException
     */
    public ModificationResult capture(CaptureRequest captureRequest) throws IOException, ApiException {
        String jsonRequest = captureRequest.toJson();

        String jsonResult = capture.request(jsonRequest);

        return ModificationResult.fromJson(jsonResult);
    }

    /**
     * POST /cancel API call
     *
     * @param cancelRequest CancelRequest
     * @return ModificationResult
     * @throws ApiException ApiException
     * @throws IOException  IOException
     */
    public ModificationResult cancel(CancelRequest cancelRequest) throws IOException, ApiException {
        String jsonRequest = cancelRequest.toJson();

        String jsonResult = cancel.request(jsonRequest);

        return ModificationResult.fromJson(jsonResult);
    }

    /**
     * POST /refund API call
     *
     * @param refundRequest RefundRequest
     * @return ModificationResult
     * @throws ApiException ApiException
     * @throws IOException  IOException
     */
    public ModificationResult refund(RefundRequest refundRequest) throws IOException, ApiException {
        String jsonRequest = refundRequest.toJson();

        String jsonResult = refund.request(jsonRequest);

        return ModificationResult.fromJson(jsonResult);
    }

    /**
     * POST /cancelOrRefund API call
     *
     * @param cancelOrRefundRequest CancelOrRefundRequest
     * @return ModificationResult
     * @throws ApiException ApiException
     * @throws IOException  IOException
     */
    public ModificationResult cancelOrRefund(CancelOrRefundRequest cancelOrRefundRequest) throws IOException, ApiException {
        String jsonRequest = cancelOrRefundRequest.toJson();

        String jsonResult = cancelOrRefund.request(jsonRequest);

        return ModificationResult.fromJson(jsonResult);
    }

    /**
     * POST /technicalCancel API call
     *
     * @param technicalCancelRequest TechnicalCancelRequest
     * @return ModificationResult
     * @throws ApiException ApiException
     * @throws IOException  IOException
     */
    public ModificationResult technicalCancel(TechnicalCancelRequest technicalCancelRequest) throws IOException, ApiException {
        String jsonRequest = technicalCancelRequest.toJson();

        String jsonResult = technicalCancel.request(jsonRequest);

        return ModificationResult.fromJson(jsonResult);
    }

    /**
     * POST /adjustAuthorisation API call
     *
     * @param adjustAuthorisationRequest AdjustAuthorisationRequest
     * @return ModificationResult
     * @throws ApiException ApiException
     * @throws IOException  IOException
     */
    public ModificationResult adjustAuthorisation(AdjustAuthorisationRequest adjustAuthorisationRequest) throws IOException, ApiException {
        String jsonRequest = adjustAuthorisationRequest.toJson();

        String jsonResult = adjustAuthorisation.request(jsonRequest);

        return ModificationResult.fromJson(jsonResult);
    }

    /**
     * POST /donate API call
     *
     * @param donationRequest DonationRequest
     * @return ModificationResult
     * @throws ApiException ApiException
     * @throws IOException  IOException
     */
    public ModificationResult donate(DonationRequest donationRequest) throws IOException, ApiException {
        String jsonRequest = donationRequest.toJson();

        String jsonResult = donate.request(jsonRequest);

        return ModificationResult.fromJson(jsonResult);
    }

    /**
     * POST /voidPendingRefund API call
     *
     * @param voidPendingRefundRequest VoidPendingRefundRequest
     * @return ModificationResult
     * @throws ApiException ApiException
     * @throws IOException  IOException
     */
    public ModificationResult voidPendingRefund(VoidPendingRefundRequest voidPendingRefundRequest) throws IOException, ApiException {
        String jsonRequest = voidPendingRefundRequest.toJson();

        String jsonResult = voidPendingRefund.request(jsonRequest);

        return ModificationResult.fromJson(jsonResult);
    }
}
