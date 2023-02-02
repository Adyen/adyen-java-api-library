package com.adyen.service.resource;

import com.adyen.Client;
import com.adyen.Service;

public class ManagementResource extends Resource {
    public ManagementResource(Service service, String endpoint) {
        super(service, service.getClient().getConfig().getManagementEndpoint() + Client.MANAGEMENT_VERSION + endpoint, null);
    }
}
