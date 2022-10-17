package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.LegalEntityManagement.BusinessLineService;
import com.adyen.service.LegalEntityManagement.Documents;
import com.adyen.service.LegalEntityManagement.HostedOnboardingPage;
import com.adyen.service.LegalEntityManagement.LegalEntities;
import com.adyen.service.LegalEntityManagement.TransferInstruments;

public class LegalEntityManagementService extends Service {
    public LegalEntityManagementService(Client client) {
        super(client);
    }

    public LegalEntities legalEntities = new LegalEntities(this.getClient());

    public TransferInstruments transferInstruments = new TransferInstruments(this.getClient());

    public BusinessLineService businessLineService = new BusinessLineService(this.getClient());

    public Documents documents = new Documents(this.getClient());

    public HostedOnboardingPage hostedOnboardingPage = new HostedOnboardingPage(this.getClient());
}
