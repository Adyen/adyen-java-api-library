package com.adyen.service.resource.notification;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.resource.Resource;

import java.util.Arrays;


public class TestNotificationConfiguration extends Resource {

    public TestNotificationConfiguration(Service service) {
        super(service,
              service.getClient().getConfig().getMarketPayEndpoint() + "/Notification/" + Client.MARKETPAY_NOTIFICATION_API_VERSION + "/testNotificationConfiguration",
              Arrays.asList(
                      "eventTypes",
                      "notificationId"
              )
        );
    }
}
