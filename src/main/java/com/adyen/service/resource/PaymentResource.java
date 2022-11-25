package com.adyen.service.resource;

import com.adyen.Client;
import com.adyen.Service;

public class PaymentResource extends Resource {
    public PaymentResource(Service service, String endpoint) {
        super(service, service.getClient().getConfig().getEndpoint() + "/pal/servlet/Payment/" + Client.API_VERSION  +
                endpoint, null);
    }
}