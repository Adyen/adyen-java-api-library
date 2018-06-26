package com.adyen.service.resource.checkout;

import java.util.Arrays;
import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;

public class Payments extends Resource {

    public Payments(Service service)
    {
        super(service, service.getClient().getConfig().getCheckoutEndpoint() +"/"+ Client.CHECKOUT_API_VERSION + "/payments",
                Arrays.asList("merchantAccount", "reference", "amount", "returnUrl", "paymentMethod"));

    }
}
