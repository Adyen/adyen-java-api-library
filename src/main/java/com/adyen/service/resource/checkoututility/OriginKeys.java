package com.adyen.service.resource.checkoututility;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;

public class OriginKeys extends Resource {

    public OriginKeys(Service service) {
        super(service, service.getClient().getConfig().getCheckoutEndpoint() + "/" + Client.CHECKOUT_UTILITY_API_VERSION +
                "/originKeys", Arrays.asList("originDomains" ));
    }
}
