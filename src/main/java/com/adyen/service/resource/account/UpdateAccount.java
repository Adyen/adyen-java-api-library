package com.adyen.service.resource.account;

import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;

public class UpdateAccount extends Resource {

    public UpdateAccount(Service service) {
        super(service,
                service.getClient().getConfig().getMarketPayEndpoint() + "/Account/" + service.getClient().getMarketPayApiVersion() + "/updateAccount",
                Arrays.asList(
                        "accountCode",
                        "payoutSchedule.schedule",
                        "payoutSchedule.action"
                )
        );
    }
}