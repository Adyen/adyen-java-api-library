package com.adyen.service.resource.notification;

import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;

/**
 * Created by rikt on 9/13/17.
 */
public class UpdateNotificationConfiguration extends Resource {

    public UpdateNotificationConfiguration(Service service) {
        super(service,
              service.getClient().getConfig().getMarketPayEndpoint() + "/Notification/" + service.getClient().getMarketPayApiVersion() + "/updateNotificationConfiguration",
              Arrays.asList(
                      "configurationDetails"
              )
        );
    }
}
