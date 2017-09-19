/**
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.AccountHolderBalanceRequest;
import com.adyen.model.AccountHolderBalanceResponse;
import com.adyen.model.TransferFundsRequest;
import com.adyen.model.TransferFundsResponse;
import com.adyen.service.resource.fund.AccountHolderBalance;
import com.adyen.service.resource.fund.TransferFunds;
import com.google.gson.reflect.TypeToken;

/**
 * Created by rikt on 9/7/17.
 */
public class Fund extends Service {

    private AccountHolderBalance accountHolderBalance;
    private TransferFunds transferFunds;

    public Fund(Client client) {
        super(client);
        this.accountHolderBalance = new AccountHolderBalance(this);
        transferFunds = new TransferFunds(this);
    }

    public AccountHolderBalanceResponse AccountHolderBalance(AccountHolderBalanceRequest accountHolderBalanceRequest) throws Exception {
        String jsonRequest = GSON.toJson(accountHolderBalanceRequest);

        String jsonResult = accountHolderBalance.request(jsonRequest);

        AccountHolderBalanceResponse accountHolderBalanceResponse = GSON.fromJson(jsonResult, new TypeToken<AccountHolderBalanceResponse>() {
        }.getType());


        return accountHolderBalanceResponse;
    }

    public TransferFundsResponse transferFunds(TransferFundsRequest transferFundsRequest) throws Exception {

        String jsonRequest = GSON.toJson(transferFundsRequest);

        String jsonResult = transferFunds.request(jsonRequest);

        TransferFundsResponse transferFundsResponse = GSON.fromJson(jsonResult, new TypeToken<TransferFundsResponse>() {
        }.getType());


        return transferFundsResponse;
    }
}