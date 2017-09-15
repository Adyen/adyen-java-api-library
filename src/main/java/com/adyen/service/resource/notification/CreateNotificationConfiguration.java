package com.adyen.service.resource.notification;

import java.util.Arrays;
import com.adyen.Service;
import com.adyen.service.Resource;

/**
 * Created by rikt on 9/13/17.
 */
public class CreateNotificationConfiguration extends Resource {

    public CreateNotificationConfiguration(Service service) {
        super(service,
              service.getClient().getConfig().getMarketPayEndpoint() + "/Notification/" + service.getClient().getMarketPayApiVersion() + "/createNotificationConfiguration",
              Arrays.asList(
                      "configurationDetails"
              )
        );
    }
}
