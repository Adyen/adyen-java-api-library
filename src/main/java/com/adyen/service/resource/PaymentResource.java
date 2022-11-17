package com.adyen.service.resource;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.Resource;

public class PaymentResource extends Resource {
    public PaymentResource(Service service, String endpoint) {
        super(service, service.getClient().getConfig().getEndpoint() + "/pal/servlet/Payment/" + Client.API_VERSION  +
                endpoint, null);
    }
}
