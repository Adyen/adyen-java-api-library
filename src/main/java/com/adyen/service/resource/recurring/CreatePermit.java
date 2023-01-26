package com.adyen.service.resource.recurring;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.resource.Resource;

public class CreatePermit extends Resource {
    public CreatePermit(Service service) {
        super(service,
                service.getClient().getConfig().getEndpoint() + "/pal/servlet/Recurring/" + Client.RECURRING_API_VERSION + "/createPermit", null);
    }
}
