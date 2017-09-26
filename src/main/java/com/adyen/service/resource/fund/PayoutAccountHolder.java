package com.adyen.service.resource.fund;

import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;

public class PayoutAccountHolder extends Resource {

    public PayoutAccountHolder(Service service) {
        super(service,
                service.getClient().getConfig().getMarketPayEndpoint() + "/Fund/" + service.getClient().getMarketPayApiVersion() + "/payoutAccountHolder",
                Arrays.asList(
                        "accountCode",
                        "accountHolderCode",
                        "amount",
                        "description",
                        "bankAccountUUID"
                )
        );
    }

}
