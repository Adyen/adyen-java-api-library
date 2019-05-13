package com.adyen.service.resource.binlookup;

import java.util.Arrays;
import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.Resource;

public class Get3dsAvailability extends Resource {

    public Get3dsAvailability(Service service) {
        super(service,
                service.getClient().getConfig().getEndpoint() + "/pal/servlet/BinLookup/" + Client.BIN_LOOKUP_API_VERSION + "/get3dsAvailability",
              Arrays.asList("merchantAccount", "cardNumber"));
    }
}
