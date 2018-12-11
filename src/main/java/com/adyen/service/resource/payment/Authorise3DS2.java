package com.adyen.service.resource.payment;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.Resource;

public class Authorise3DS2 extends Resource {

    public Authorise3DS2(Service service) {
        super(service,
                service.getClient().getConfig().getEndpoint() + "/pal/servlet/Payment/" + Client.API_VERSION + "/authorise3ds2", null);
    }
    {
    }
}