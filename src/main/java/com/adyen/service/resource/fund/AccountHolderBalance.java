package com.adyen.service.resource.fund;

import java.util.Arrays;
import com.adyen.Service;
import com.adyen.service.Resource;

/**
 * Created by rikt on 9/12/17.
 */
public class AccountHolderBalance extends Resource {

    public AccountHolderBalance(Service service) {
        super(service,
              service.getClient().getConfig().getMarketPayEndpoint() + "/Fund/" + service.getClient().getMarketPayApiVersion() + "/accountHolderBalance",
              Arrays.asList(
                      "accountHolderCode"
              )
        );
    }

}
