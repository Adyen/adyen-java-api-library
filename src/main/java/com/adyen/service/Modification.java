package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.modification.CancelRequest;
import com.adyen.model.modification.CaptureRequest;
import com.adyen.model.modification.ModificationResult;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.modification.CancelOrRefund;
import com.adyen.service.resource.modification.Capture;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Modification extends Service {
    private CancelOrRefund cancelOrRefund;
    private Capture capture;

    public Modification(Client client) {
        super(client);

        capture = new Capture(this);
        cancelOrRefund = new CancelOrRefund(this);
    }

    /**
     * Issue capture request
     *
     * @param captureRequest
     * @return
     * @throws IOException
     * @throws ApiException
     */
    public ModificationResult capture(CaptureRequest captureRequest) throws IOException, ApiException {
        Gson gson = new Gson();
        String jsonRequest = gson.toJson(captureRequest);

        String jsonResult = capture.request(jsonRequest);

        ModificationResult modificationResult = gson.fromJson(jsonResult, new TypeToken<ModificationResult>() {
        }.getType());

        return modificationResult;
    }

    public ModificationResult cancelOrRefund(CancelRequest cancelRequest) throws IOException, ApiException {
        Gson gson = new Gson();
        String jsonRequest = gson.toJson(cancelRequest);

        String jsonResult = cancelOrRefund.request(jsonRequest);

        ModificationResult modificationResult = gson.fromJson(jsonResult, new TypeToken<ModificationResult>() {
        }.getType());

        return modificationResult;
    }
}
