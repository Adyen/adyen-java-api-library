package com.adyen.service.resource.account;

import java.util.Arrays;
import com.adyen.Service;
import com.adyen.service.Resource;

public class CloseAccountHolder extends Resource {

    public CloseAccountHolder(Service service) {
        super(service,
                service.getClient().getConfig().getMarketPayEndpoint() + "/Account/" + service.getClient().getMarketPayApiVersion() + "/closeAccountHolder",
                Arrays.asList(
                        "accountHolderCode"
                )
        );
    }
}
