package com.adyen.service.resource.recurring;

import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;

public class ListRecurringDetails extends Resource {
    public ListRecurringDetails(Service service) {
        super(service,
                service.getClient().getConfig().getEndpoint() + "/pal/servlet/Recurring/" + service.getClient().getApiVersion() + "/listRecurringDetails",
                Arrays.asList(
                        "merchantAccount",
                        "recurring.contract",
                        "shopperReference"
                ));
    }
}
