package com.adyen.service.legalentitymanagement;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.legalEntityManagement.TransferInstrument;
import com.adyen.model.legalEntityManagement.TransferInstrumentInfo;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.LegalEntityManagementResource;

import java.io.IOException;

public class TransferInstruments extends Service {
    public TransferInstruments(Client client) {
        super(client);
    }

    public TransferInstrument create(TransferInstrumentInfo request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, "/transferInstruments");
        String jsonResult = resource.request(jsonRequest);
        return TransferInstrument.fromJson(jsonResult);
    }

    public TransferInstrument retrieve(String transferInstrumentId) throws IOException, ApiException {
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, String.format("/transferInstruments/%s", transferInstrumentId));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return TransferInstrument.fromJson(jsonResult);
    }

    public TransferInstrument update(String transferInstrumentId, TransferInstrumentInfo request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, String.format("/transferInstruments/%s", transferInstrumentId));
        String jsonResult = resource.request(jsonRequest, ApiConstants.HttpMethod.PATCH);
        return TransferInstrument.fromJson(jsonResult);
    }

    public void delete(String transferInstrumentId) throws IOException, ApiException {
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, String.format("/transferInstruments/%s", transferInstrumentId));
        resource.request(null, ApiConstants.HttpMethod.DELETE);
    }
}
