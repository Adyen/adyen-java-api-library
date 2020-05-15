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

import java.io.IOException;
import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.RequestOptions;
import com.adyen.model.modification.AbstractModificationRequest;
import com.adyen.model.modification.AdjustAuthorisationRequest;
import com.adyen.model.modification.CancelOrRefundRequest;
import com.adyen.model.modification.CancelRequest;
import com.adyen.model.modification.CaptureRequest;
import com.adyen.model.modification.DonationRequest;
import com.adyen.model.modification.ModificationResult;
import com.adyen.model.modification.RefundRequest;
import com.adyen.model.modification.TechnicalCancelRequest;
import com.adyen.model.modification.VoidPendingRefundRequest;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.modification.AdjustAuthorisation;
import com.adyen.service.resource.modification.Cancel;
import com.adyen.service.resource.modification.CancelOrRefund;
import com.adyen.service.resource.modification.Capture;
import com.adyen.service.resource.modification.Donate;
import com.adyen.service.resource.modification.Refund;
import com.adyen.service.resource.modification.TechnicalCancel;
import com.adyen.service.resource.modification.VoidPendingRefund;
import com.google.gson.reflect.TypeToken;

public class Modification extends Service {
    private CancelOrRefund cancelOrRefund;
    private Cancel cancel;
    private Capture capture;
    private Refund refund;
    private AdjustAuthorisation adjustAuthorisation;
    private TechnicalCancel technicalCancel;
    private VoidPendingRefund voidPendingRefund;
    private Donate donate;

    public Modification(Client client) {
        super(client);

        capture = new Capture(this);
        cancelOrRefund = new CancelOrRefund(this);
        cancel = new Cancel(this);
        refund = new Refund(this);
        adjustAuthorisation = new AdjustAuthorisation(this);
        technicalCancel = new TechnicalCancel(this);
        voidPendingRefund = new VoidPendingRefund(this);
        donate = new Donate(this);
    }

    /**
     * Issues /capture request
     *
     * @param captureRequest CaptureRequest
     * @return ModificationResult
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */

    public ModificationResult capture(CaptureRequest captureRequest) throws IOException, ApiException {
        return capture(captureRequest, null);
    }

    public ModificationResult capture(CaptureRequest captureRequest, RequestOptions requestOptions) throws IOException, ApiException {
        String jsonRequest = serializeRequest(captureRequest);
        String jsonResult = capture.request(jsonRequest, requestOptions);
        return deserializeResponse(jsonResult);
    }

    /**
     * Issues /cancelOrRefund request
     *
     * @param cancelOrRefundRequest CancelOrRefundRequest
     * @return ModificationResult
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public ModificationResult cancelOrRefund(CancelOrRefundRequest cancelOrRefundRequest) throws IOException, ApiException {
        return cancelOrRefund(cancelOrRefundRequest, null);
    }

    public ModificationResult cancelOrRefund(CancelOrRefundRequest cancelOrRefundRequest, RequestOptions requestOptions) throws IOException, ApiException {
        String jsonRequest = serializeRequest(cancelOrRefundRequest);
        String jsonResult = cancelOrRefund.request(jsonRequest, requestOptions);
        return deserializeResponse(jsonResult);
    }

    /**
     * Issues /refund request
     *
     * @param refundRequest RefundRequest
     * @return ModificationResult
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public ModificationResult refund(RefundRequest refundRequest) throws IOException, ApiException {
        return refund(refundRequest, null);
    }

    public ModificationResult refund(RefundRequest refundRequest, RequestOptions requestOptions) throws IOException, ApiException {
        String jsonRequest = serializeRequest(refundRequest);
        String jsonResult = refund.request(jsonRequest, requestOptions);
        return deserializeResponse(jsonResult);
    }

    /**
     * Issues /cancel request
     *
     * @param cancelRequest CancelRequest
     * @return ModificationResult
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public ModificationResult cancel(CancelRequest cancelRequest) throws IOException, ApiException {
        return cancel(cancelRequest, null);
    }

    public ModificationResult cancel(CancelRequest cancelRequest, RequestOptions requestOptions) throws IOException, ApiException {

        String jsonRequest = serializeRequest(cancelRequest);
        String jsonResult = cancel.request(jsonRequest, requestOptions);
        return deserializeResponse(jsonResult);
    }


    /**
     * Issues /technical Cancel
     *
     * @param technicalCancelRequest TechnicalCancelRequest
     * @return ModificationResult
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public ModificationResult technicalCancel(TechnicalCancelRequest technicalCancelRequest) throws IOException, ApiException {
        return technicalCancel(technicalCancelRequest, null);
    }

    public ModificationResult technicalCancel(TechnicalCancelRequest technicalCancelRequest, RequestOptions requestOptions) throws IOException, ApiException {

        String jsonRequest = serializeRequest(technicalCancelRequest);
        String jsonResult = technicalCancel.request(jsonRequest, requestOptions);
        return deserializeResponse(jsonResult);
    }

    /**
     * Issues /adjust Authorisation
     *
     * @param adjustAuthorisationRequest AdjustAuthorisationRequest
     * @return ModificationResult
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public ModificationResult adjustAuthorization(AdjustAuthorisationRequest adjustAuthorisationRequest) throws IOException, ApiException {
        return adjustAuthorization(adjustAuthorisationRequest, null);
    }

    public ModificationResult adjustAuthorization(AdjustAuthorisationRequest adjustAuthorisationRequest, RequestOptions requestOptions) throws IOException, ApiException {

        String jsonRequest = serializeRequest(adjustAuthorisationRequest);
        String jsonResult = adjustAuthorisation.request(jsonRequest, requestOptions);
        return deserializeResponse(jsonResult);
    }

    /**
     * Issues /voidPendingRefund request
     *
     * @param voidPendingRefundRequest VoidPendingRefundRequest
     * @return ModificationResult
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public ModificationResult voidPendingRefund(VoidPendingRefundRequest voidPendingRefundRequest) throws IOException, ApiException {
        return voidPendingRefund(voidPendingRefundRequest, null);
    }

    public ModificationResult voidPendingRefund(VoidPendingRefundRequest voidPendingRefundRequest, RequestOptions requestOptions) throws IOException, ApiException {
        String jsonRequest = serializeRequest(voidPendingRefundRequest);
        String jsonResult = voidPendingRefund.request(jsonRequest, requestOptions);
        return deserializeResponse(jsonResult);
    }

    /**
     * Issues /donate request
     *
     * @param donationRequest DonationRequest
     * @return ModificationResult
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public ModificationResult donate(DonationRequest donationRequest) throws IOException, ApiException {
        return donate(donationRequest, null);
    }

    public ModificationResult donate(DonationRequest donationRequest, RequestOptions requestOptions) throws IOException, ApiException {
        String jsonRequest = serializeDonationRequest(donationRequest);
        String jsonResult = donate.request(jsonRequest, requestOptions);
        return deserializeResponse(jsonResult);
    }

    private String serializeRequest(AbstractModificationRequest modificationRequest) {
        String jsonRequest = GSON.toJson(modificationRequest);

        return jsonRequest;
    }

    private String serializeDonationRequest(DonationRequest donationRequest) {
        String jsonRequest = GSON.toJson(donationRequest);

        return jsonRequest;
    }

    private ModificationResult deserializeResponse(String jsonResult) {
        ModificationResult modificationResult = GSON.fromJson(jsonResult, new TypeToken<ModificationResult>() {
        }.getType());

        return modificationResult;
    }
}
