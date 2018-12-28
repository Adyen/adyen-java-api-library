package com.adyen.service.resource.payment;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.Resource;

public class Retrieve3DS2Result extends Resource {

    public Retrieve3DS2Result(Service service) {
        super(service,
                service.getClient().getConfig().getEndpoint() + "/pal/servlet/Payment/" + Client.API_VERSION + "/retrieve3ds2Result", null);
    }
}
