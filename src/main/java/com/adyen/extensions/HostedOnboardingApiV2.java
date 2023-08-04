package com.adyen.extensions;

import com.adyen.Client;
import com.adyen.service.legalentitymanagement.HostedOnboardingApi;

public class HostedOnboardingApiV2 extends HostedOnboardingApi {
    public HostedOnboardingApiV2(Client client) {
        super(client);
        this.baseURL = createBaseURL("https://kyc-test.adyen.com/lem/v2");
    }
}
