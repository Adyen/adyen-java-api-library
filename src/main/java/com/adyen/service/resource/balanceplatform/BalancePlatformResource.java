package com.adyen.service.resource.balanceplatform;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.resource.Resource;

public class BalancePlatformResource extends Resource {
    public BalancePlatformResource(Service service, String endpoint) {
        super(service, service.getClient().getConfig().getBalancePlatformEndpoint() + "/bcl/" + Client.BALANCE_PLATFORM_VERSION + endpoint, null);
    }
}
