package com.adyen.service.resource.account;

import java.util.Arrays;
import com.adyen.Service;
import com.adyen.service.Resource;

/**
 * Created by rikt on 9/11/17.
 */
public class CreateAccountHolder extends Resource {

    public CreateAccountHolder(Service service) {
        super(service,
              service.getClient().getConfig().getMarketPayEndpoint() + "/Account/" + service.getClient().getMarketPayApiVersion() + "/createAccountHolder",
              Arrays.asList(
                      "accountHolderCode",
                      "accountHolderDetails",
                      "legalEntity"
              )
        );
    }
}
