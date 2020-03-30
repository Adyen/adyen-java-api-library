package com.adyen.service.resource.notification;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Collections;


public class DeleteNotificationConfigurations extends Resource {

    public DeleteNotificationConfigurations(Service service) {
        super(service,
              service.getClient().getConfig().getMarketPayEndpoint() + "/Notification/" + Client.MARKETPAY_NOTIFICATION_API_VERSION + "/deleteNotificationConfigurations",
                Collections.singletonList("notificationIds")
        );
    }
}
