/**
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
import com.adyen.model.modification.AbstractModificationRequest;
import com.adyen.model.modification.CancelOrRefundRequest;
import com.adyen.model.modification.CancelRequest;
import com.adyen.model.modification.CaptureRequest;
import com.adyen.model.modification.ModificationResult;
import com.adyen.model.modification.RefundRequest;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.modification.Cancel;
import com.adyen.service.resource.modification.CancelOrRefund;
import com.adyen.service.resource.modification.Capture;
import com.adyen.service.resource.modification.Refund;
import com.google.gson.reflect.TypeToken;

public class Modification extends Service {
    private CancelOrRefund cancelOrRefund;
    private Cancel cancel;
    private Capture capture;
    private Refund refund;

    public Modification(Client client) {
        super(client);

        capture = new Capture(this);
        cancelOrRefund = new CancelOrRefund(this);
        cancel = new Cancel(this);
        refund = new Refund(this);
    }

    /**
     * Issues /capture request
     *
     * @param captureRequest
     * @return
     * @throws IOException
     * @throws ApiException
     */
    public ModificationResult capture(CaptureRequest captureRequest) throws IOException, ApiException {
        String jsonRequest = serializeRequest(captureRequest);

        String jsonResult = capture.request(jsonRequest);

        return deserializeResponse(jsonResult);
    }

    /**
     * Issues /cancelOrRefund request
     *
     * @param cancelOrRefundRequest
     * @return
     * @throws IOException
     * @throws ApiException
     */
    public ModificationResult cancelOrRefund(CancelOrRefundRequest cancelOrRefundRequest) throws IOException, ApiException {
        String jsonRequest = serializeRequest(cancelOrRefundRequest);

        String jsonResult = cancelOrRefund.request(jsonRequest);

        return deserializeResponse(jsonResult);
    }

    /**
     * Issues /refund request
     *
     * @param refundRequest
     * @return
     * @throws IOException
     * @throws ApiException
     */
    public ModificationResult refund(RefundRequest refundRequest) throws IOException, ApiException {
        String jsonRequest = serializeRequest(refundRequest);

        String jsonResult = refund.request(jsonRequest);

        return deserializeResponse(jsonResult);
    }

    /**
     * Issues /cancel request
     *
     * @param cancelRequest
     * @return
     * @throws IOException
     * @throws ApiException
     */
    public ModificationResult cancel(CancelRequest cancelRequest) throws IOException, ApiException {
        String jsonRequest = serializeRequest(cancelRequest);

        String jsonResult = cancel.request(jsonRequest);

        return deserializeResponse(jsonResult);
    }

    private String serializeRequest(AbstractModificationRequest modificationRequest) {
        String jsonRequest = GSON.toJson(modificationRequest);

        return jsonRequest;
    }

    private ModificationResult deserializeResponse(String jsonResult) {
        ModificationResult modificationResult = GSON.fromJson(jsonResult, new TypeToken<ModificationResult>() {
        }.getType());

        return modificationResult;
    }
}
