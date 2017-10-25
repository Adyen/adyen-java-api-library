package com.adyen.service.resource.notification;

import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;

public class GetNotificationConfiguration extends Resource {

    public GetNotificationConfiguration(Service service) {
        super(service,
              service.getClient().getConfig().getMarketPayEndpoint() + "/Notification/" + service.getClient().getMarketPayApiVersion() + "/getNotificationConfiguration",
              Arrays.asList(
                      "notificationId"
              )
        );
    }
}
