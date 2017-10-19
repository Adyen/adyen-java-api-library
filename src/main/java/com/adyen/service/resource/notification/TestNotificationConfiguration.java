package com.adyen.service.resource.notification;

import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;


public class TestNotificationConfiguration extends Resource {

    public TestNotificationConfiguration(Service service) {
        super(service,
              service.getClient().getConfig().getMarketPayEndpoint() + "/Notification/" + service.getClient().getMarketPayApiVersion() + "/testNotificationConfiguration",
              Arrays.asList(
                      "configurationDetails"
              )
        );
    }
}
