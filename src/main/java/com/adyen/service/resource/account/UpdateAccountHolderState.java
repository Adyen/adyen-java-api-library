package com.adyen.service.resource.account;

import java.util.Arrays;
import com.adyen.Service;
import com.adyen.service.Resource;

public class UpdateAccountHolderState extends Resource {

    public UpdateAccountHolderState(Service service) {
        super(service,
                service.getClient().getConfig().getMarketPayEndpoint() + "/Account/" + service.getClient().getMarketPayApiVersion() + "/updateAccountHolderState",
                Arrays.asList(
                        "accountHolderCode",
                        "stateType",
                        "disable"
                )
        );
    }
}