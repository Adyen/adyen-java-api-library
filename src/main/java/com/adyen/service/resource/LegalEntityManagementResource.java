package com.adyen.service.resource;

import com.adyen.Client;
import com.adyen.Service;

public class LegalEntityManagementResource extends Resource {
    public LegalEntityManagementResource(Service service, String endpoint) {
        super(service, service.getClient().getConfig().getLegalManagementEndpoint() + Client.LEGAL_ENTITY_MANAGEMENT_VERSION + endpoint, null);
    }
}
