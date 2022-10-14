package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.balancePlatform.AccountHolders;
import com.adyen.service.balancePlatform.BalanceAccounts;
import com.adyen.service.balancePlatform.General;
import com.adyen.service.balancePlatform.PaymentInstrumentGroups;
import com.adyen.service.balancePlatform.PaymentInstruments;
import com.adyen.service.balancePlatform.TransactionRules;

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
