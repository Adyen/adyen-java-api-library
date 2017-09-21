package com.adyen.service.resource.account;

import java.util.Arrays;
import com.adyen.Service;
import com.adyen.service.Resource;

public class SuspendAccountHolder extends Resource {

    public SuspendAccountHolder(Service service) {
        super(service,
                service.getClient().getConfig().getMarketPayEndpoint() + "/Account/" + service.getClient().getMarketPayApiVersion() + "/suspendAccountHolder",
                Arrays.asList(
                        "accountHolderCode"
                )
        );
    }
}