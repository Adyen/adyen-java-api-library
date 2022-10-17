package com.adyen.service.LegalEntityManagement;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.legalEntityManagement.JSON;
import com.adyen.model.legalEntityManagement.OnboardingLink;
import com.adyen.model.legalEntityManagement.OnboardingLinkInfo;
import com.adyen.model.legalEntityManagement.OnboardingTheme;
import com.adyen.model.legalEntityManagement.OnboardingThemes;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.LegalEntityManagementResource;

import java.io.IOException;

public class HostedOnboardingPage extends Service {
    public HostedOnboardingPage(Client client) {
        super(client);
        new JSON();
    }

    public OnboardingLink create(String id, OnboardingLinkInfo request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, String.format("/documents/%s", id));
        String jsonResult = resource.request(jsonRequest);
        return OnboardingLink.fromJson(jsonResult);
    }

    public OnboardingThemes listThemes() throws IOException, ApiException {
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, "/themes");
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return OnboardingThemes.fromJson(jsonResult);
    }

    public OnboardingTheme retrieveTheme(String id) throws IOException, ApiException {
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, String.format("/themes/%s", id));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return OnboardingTheme.fromJson(jsonResult);
    }
}
