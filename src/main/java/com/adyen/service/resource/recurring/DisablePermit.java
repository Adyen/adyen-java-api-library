package com.adyen.service.resource.recurring;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.resource.Resource;

public class DisablePermit extends Resource {
    public DisablePermit(Service service) {
        super(service,
                service.getClient().getConfig().getEndpoint() + "/pal/servlet/Recurring/" + Client.RECURRING_API_VERSION + "/disablePermit", null);
    }
}
