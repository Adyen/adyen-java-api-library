package com.adyen.service.resource.fund;

import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;

public class SetupBeneficiary extends Resource {

    public SetupBeneficiary(Service service) {
        super(service,
                service.getClient().getConfig().getMarketPayEndpoint() + "/Fund/" + service.getClient().getMarketPayApiVersion() + "/setupBeneficiary",
                Arrays.asList(
                        "destinationAccountCode",
                        "merchantReference",
                        "sourceAccountCode"
                )
        );
    }

}
