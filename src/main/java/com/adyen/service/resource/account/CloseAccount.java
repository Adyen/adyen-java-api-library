package com.adyen.service.resource.account;

import java.util.Arrays;
import com.adyen.Service;
import com.adyen.service.Resource;

public class CloseAccount extends Resource {

    public CloseAccount(Service service) {
        super(service,
                service.getClient().getConfig().getMarketPayEndpoint() + "/Account/" + service.getClient().getMarketPayApiVersion() + "/closeAccount",
                Arrays.asList(
                        "accountCode"
                )
        );
    }
}
