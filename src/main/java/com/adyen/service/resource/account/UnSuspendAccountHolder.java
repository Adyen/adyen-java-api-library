package com.adyen.service.resource.account;

import java.util.Arrays;
import com.adyen.Service;
import com.adyen.service.Resource;

public class UnSuspendAccountHolder extends Resource {

    public UnSuspendAccountHolder(Service service) {
        super(service,
                service.getClient().getConfig().getMarketPayEndpoint() + "/Account/" + service.getClient().getMarketPayApiVersion() + "/unSuspendAccountHolder",
                Arrays.asList(
                        "accountHolderCode"
                )
        );
    }
}