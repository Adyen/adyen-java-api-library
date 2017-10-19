package com.adyen.service.resource.notification;

import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;


public class DeleteNotificationConfiguration extends Resource {

    public DeleteNotificationConfiguration(Service service) {
        super(service,
              service.getClient().getConfig().getMarketPayEndpoint() + "/Notification/" + service.getClient().getMarketPayApiVersion() + "/deleteNotificationConfiguration",
              Arrays.asList(
                      "configurationDetails"
              )
        );
    }
}
