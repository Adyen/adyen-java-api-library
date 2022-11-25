package com.adyen.service.resource;

import com.adyen.Client;
import com.adyen.Service;

public class CheckoutResource extends Resource {
    public CheckoutResource(Service service, String endpoint) {
        super(service, service.getClient().getConfig().getCheckoutEndpoint() + "/" + Client.CHECKOUT_API_VERSION +
               endpoint, null);
    }
}
