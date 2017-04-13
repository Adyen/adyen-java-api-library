package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.modification.*;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.modification.Cancel;
import com.adyen.service.resource.modification.CancelOrRefund;
import com.adyen.service.resource.modification.Capture;
import com.adyen.service.resource.modification.Refund;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

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
     * @param cancelRequest
     * @return
     * @throws IOException
     * @throws ApiException
     */
    public ModificationResult cancelOrRefund(CancelRequest cancelRequest) throws IOException, ApiException {
        String jsonRequest = serializeRequest(cancelRequest);

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
