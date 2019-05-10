package com.adyen.service.resource.binlookup;

import java.util.Arrays;
import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.Resource;

public class GetCostEstimate extends Resource {

    public GetCostEstimate(Service service) {
        super(service, service.getClient().getConfig().getCheckoutEndpoint() + "/" + Client.BIN_LOOKUP_API_VERSION + "/getCostEstimate",
              Arrays.asList("merchantAccount", "amount"));
    }
}
