package com.adyen.service.resource.transfers;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.Resource;


public class TransactionResource extends Resource {
    public TransactionResource(Service service) {
        super(service,
                service.getClient().getConfig().getEndpoint() + "/btl/" + Client.TRANSFER_VERSION
                        + "/transactions/",
                null);
    }
}
