package com.adyen.service.resource.account;

import java.util.Arrays;
import com.adyen.Service;
import com.adyen.service.Resource;

public class UploadDocument extends Resource {

    public UploadDocument(Service service) {
        super(service,
                service.getClient().getConfig().getMarketPayEndpoint() + "/Account/" + service.getClient().getMarketPayApiVersion() + "/uploadDocument",
                Arrays.asList(
                        "documentContent",
                        "documentDetail"
                )
        );
    }
}