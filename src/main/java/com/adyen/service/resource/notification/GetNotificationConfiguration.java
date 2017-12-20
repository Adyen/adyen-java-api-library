package com.adyen.service.resource.notification;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;

public class GetNotificationConfiguration extends Resource {

    public GetNotificationConfiguration(Service service) {
        super(service,
              service.getClient().getConfig().getMarketPayEndpoint() + "/Notification/" + Client.MARKETPAY_API_VERSION + "/getNotificationConfiguration",
              Arrays.asList(
                      "notificationId"
              )
        );
    }
}
