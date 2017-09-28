package com.adyen.service.resource.account;

import java.util.Arrays;
import com.adyen.Service;
import com.adyen.service.Resource;

public class GetUploadedDocuments extends Resource {

    public GetUploadedDocuments(Service service) {
        super(service,
                service.getClient().getConfig().getMarketPayEndpoint() + "/Account/" + service.getClient().getMarketPayApiVersion() + "/getUploadedDocuments",
                Arrays.asList(
                        "accountHolderCode"
                )
        );
    }
}