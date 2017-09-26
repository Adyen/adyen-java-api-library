package com.adyen.service.resource.fund;

import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;

/**
 * Created by rikt on 9/12/17.
 */
public class AccountHolderTransactionList extends Resource {

    public AccountHolderTransactionList(Service service) {
        super(service,
              service.getClient().getConfig().getMarketPayEndpoint() + "/Fund/" + service.getClient().getMarketPayApiVersion() + "/accountHolderTransactionList",
              Arrays.asList(
                      "accountHolderCode",
                      "transactionStatuses.TransactionStatus",
                      "transactionListsPerAccount",
                      "transactionListsPerAccount.TransactionListForAccount",
                      "transactionListsPerAccount.TransactionListForAccount.accountCode",
                      "transactionListsPerAccount.TransactionListForAccount.page"
              )
        );
    }

}
