package com.adyen.service.resource.fund;

import java.util.Arrays;
import com.adyen.Service;
import com.adyen.service.Resource;

public class TransferFunds extends Resource {

    public TransferFunds(Service service) {
        super(service,
                service.getClient().getConfig().getMarketPayEndpoint() + "/Fund/" + service.getClient().getMarketPayApiVersion() + "/transferFunds",
                Arrays.asList(
                        "sourceAccountCode",
                        "destinationAccountCode",
                        "amount",
                        "transferCode"
                )
        );
    }

}
