package com.adyen.service.resource.modification;

import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;
import java.util.List;

public class Refund extends Resource {

    public Refund(Service service) {
        super(service,
                service.getClient().getConfig().getEndpoint() + "/pal/servlet/Payment/" + service.getClient().getApiVersion() + "/refund",
                Arrays.asList(
                        "merchantAccount",
                        "modificationAmount",
                        "modificationAmount.value",
                        "modificationAmount.currency",
                        "originalReference"
                )
        );
    }
}
