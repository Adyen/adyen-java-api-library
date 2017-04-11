package com.adyen.service.resource.recurring;

import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;

public class Disable extends Resource {
    public Disable(Service service) {
        super(service,
                service.getClient().getConfig().getEndpoint() + "/pal/servlet/Recurring/" + service.getClient().getApiVersion() + "/disable",
                Arrays.asList(
                        "merchantAccount",
                        "shopperReference",
                        "recurringDetailReference"
                ));
    }
}
