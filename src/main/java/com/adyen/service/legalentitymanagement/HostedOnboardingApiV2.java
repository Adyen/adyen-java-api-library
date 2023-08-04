package com.adyen.service.legalentitymanagement;

import com.adyen.Client;

public class HostedOnboardingApiV2 extends HostedOnboardingApi{
    public HostedOnboardingApiV2(Client client) {
        super(client);
        this.baseURL = createBaseURL("https://kyc-test.adyen.com/lem/v2");
    }
}
