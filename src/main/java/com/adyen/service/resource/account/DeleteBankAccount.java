package com.adyen.service.resource.account;

import java.util.Arrays;
import com.adyen.Service;
import com.adyen.service.Resource;

public class DeleteBankAccount extends Resource {

    public DeleteBankAccount(Service service) {
        super(service,
                service.getClient().getConfig().getMarketPayEndpoint() + "/Account/" + service.getClient().getMarketPayApiVersion() + "/deleteBankAccounts",
                Arrays.asList(
                        "accountHolderCode",
                        "bankAccountUUIDs"
                )
        );
    }
}
