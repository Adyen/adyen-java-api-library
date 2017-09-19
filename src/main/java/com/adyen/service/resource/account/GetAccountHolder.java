package com.adyen.service.resource.account;

import java.util.Arrays;
import com.adyen.Service;
import com.adyen.service.Resource;

public class GetAccountHolder extends Resource {

    public GetAccountHolder(Service service) {
        super(service,
                service.getClient().getConfig().getMarketPayEndpoint() + "/Account/" + service.getClient().getMarketPayApiVersion() + "/getAccountHolder",
                null
        );
    }
}