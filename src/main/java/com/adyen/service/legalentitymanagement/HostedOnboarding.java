package com.adyen.service.legalentitymanagement;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.legalentitymanagement.OnboardingLink;
import com.adyen.model.legalentitymanagement.OnboardingLinkInfo;
import com.adyen.model.legalentitymanagement.OnboardingTheme;
import com.adyen.model.legalentitymanagement.OnboardingThemes;
import com.adyen.model.legalentitymanagement.JSON;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.LegalEntityManagementResource;

import java.io.IOException;

public class HostedOnboarding extends Service {
    public HostedOnboarding(Client client) {
        super(client);
        new JSON();
    }

    public OnboardingLink create(String legalEntityId, OnboardingLinkInfo request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, String.format("/legalEntities/%s/onboardingLinks", legalEntityId));
        String jsonResult = resource.request(jsonRequest);
        return OnboardingLink.fromJson(jsonResult);
    }

    public OnboardingThemes listThemes() throws IOException, ApiException {
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, "/themes");
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return OnboardingThemes.fromJson(jsonResult);
    }

    public OnboardingTheme retrieveTheme(String themeId) throws IOException, ApiException {
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, String.format("/themes/%s", themeId));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return OnboardingTheme.fromJson(jsonResult);
    }
}
