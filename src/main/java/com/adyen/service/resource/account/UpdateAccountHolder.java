package com.adyen.service.resource.account;

import java.util.Arrays;
import com.adyen.Service;
import com.adyen.service.Resource;

public class UpdateAccountHolder extends Resource {

    public UpdateAccountHolder(Service service) {
        super(service,
                service.getClient().getConfig().getMarketPayEndpoint() + "/Account/" + service.getClient().getMarketPayApiVersion() + "/updateAccountHolder",
                Arrays.asList(
                        "accountHolderCode",
                        "accountHolderDetails"
                )
        );
    }
}