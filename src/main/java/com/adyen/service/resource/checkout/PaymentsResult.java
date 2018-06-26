package com.adyen.service.resource.checkout;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;

public class PaymentsResult extends Resource {
    public PaymentsResult(Service service) {
        super(service, service.getClient().getConfig().getCheckoutEndpoint() + "/" + Client.CHECKOUT_API_VERSION +
                "/payments/result", Arrays.asList("payload"));

    }
}
