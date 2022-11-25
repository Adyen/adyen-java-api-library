package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.balanceplatform.AccountHolders;
import com.adyen.service.balanceplatform.BalanceAccounts;
import com.adyen.service.balanceplatform.General;
import com.adyen.service.balanceplatform.PaymentInstrumentGroups;
import com.adyen.service.balanceplatform.PaymentInstruments;
import com.adyen.service.balanceplatform.TransactionRules;

public class BalancePlatformService extends Service {
    public BalancePlatformService(Client client) {
        super(client);
    }

    public General general = new General(this.getClient());

    public AccountHolders accountHolders = new AccountHolders(this.getClient());

    public BalanceAccounts balanceAccounts = new BalanceAccounts(this.getClient());

    public PaymentInstruments paymentInstruments = new PaymentInstruments(this.getClient());

    public PaymentInstrumentGroups paymentsInstrumentGroups = new PaymentInstrumentGroups(this.getClient());

    public TransactionRules transactionRules = new TransactionRules(this.getClient());
}
