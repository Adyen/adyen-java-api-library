package com.adyen.service.resource.fund;

import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;

public class RefundNotPaidOutTransfers extends Resource {

    public RefundNotPaidOutTransfers(Service service) {
        super(service,
                service.getClient().getConfig().getMarketPayEndpoint() + "/Fund/" + service.getClient().getMarketPayApiVersion() + "/refundNotPaidOutTransfers",
                Arrays.asList(
                        "accountHolderCode",
                        "accountCode"
                )
        );
    }

}
