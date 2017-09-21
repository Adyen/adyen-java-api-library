package com.adyen.service.resource.account;

import java.util.Arrays;
import com.adyen.Service;
import com.adyen.service.Resource;

public class DeleteShareholder extends Resource {

    public DeleteShareholder(Service service) {
        super(service,
                service.getClient().getConfig().getMarketPayEndpoint() + "/Account/" + service.getClient().getMarketPayApiVersion() + "/deleteShareholders",
                Arrays.asList(
                        "accountHolderCode"
                )
        );
    }
}
