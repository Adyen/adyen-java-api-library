package com.adyen.service.LegalEntityManagement;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.legalEntityManagement.BusinessLines;
import com.adyen.model.legalEntityManagement.JSON;
import com.adyen.model.legalEntityManagement.LegalEntity;
import com.adyen.model.legalEntityManagement.LegalEntityInfo;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.LegalEntityManagementResource;

import java.io.IOException;

public class LegalEntities extends Service {
    public LegalEntities(Client client) {
        super(client);
        new JSON();
    }

    public LegalEntity create(LegalEntityInfo request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, "/legalEntities");
        String jsonResult = resource.request(jsonRequest);
        return LegalEntity.fromJson(jsonResult);
    }

    public LegalEntity retrieve(String id) throws IOException, ApiException {
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, String.format("/legalEntities/%s", id));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return LegalEntity.fromJson(jsonResult);
    }

    public LegalEntity update(String id, LegalEntityInfo request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, String.format("/legalEntities/%s", id));
        String jsonResult = resource.request(jsonRequest, ApiConstants.HttpMethod.PATCH);
        return LegalEntity.fromJson(jsonResult);
    }

    public BusinessLines listBusinessLines(String id) throws IOException, ApiException {
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, String.format("/legalEntities/%s/businessLines", id));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return BusinessLines.fromJson(jsonResult);
    }
}
