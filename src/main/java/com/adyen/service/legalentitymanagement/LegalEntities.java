package com.adyen.service.legalentitymanagement;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.legalentitymanagement.BusinessLines;
import com.adyen.model.legalentitymanagement.LegalEntity;
import com.adyen.model.legalentitymanagement.LegalEntityInfo;
import com.adyen.model.legalentitymanagement.JSON;
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

    public LegalEntity retrieve(String legalEntityId) throws IOException, ApiException {
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, String.format("/legalEntities/%s", legalEntityId));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return LegalEntity.fromJson(jsonResult);
    }

    public LegalEntity update(String legalEntityId, LegalEntityInfo request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, String.format("/legalEntities/%s", legalEntityId));
        String jsonResult = resource.request(jsonRequest, ApiConstants.HttpMethod.PATCH);
        return LegalEntity.fromJson(jsonResult);
    }

    public BusinessLines listBusinessLines(String legalEntityId) throws IOException, ApiException {
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, String.format("/legalEntities/%s/businessLines", legalEntityId));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return BusinessLines.fromJson(jsonResult);
    }
}
