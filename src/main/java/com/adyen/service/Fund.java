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
import com.adyen.service.resource.fund.AccountHolderBalance;
import com.google.gson.reflect.TypeToken;

/**
 * Created by rikt on 9/7/17.
 */
public class Fund extends Service {

    private AccountHolderBalance accountHolderBalance;

    public Fund(Client client) {
        super(client);
        this.accountHolderBalance = new AccountHolderBalance(this);
    }

    public AccountHolderBalanceResponse AccountHolderBalance(AccountHolderBalanceRequest accountHolderBalanceRequest) throws Exception {
        String jsonRequest = GSON.toJson(accountHolderBalanceRequest);

        String jsonResult = accountHolderBalance.request(jsonRequest);

        AccountHolderBalanceResponse accountHolderBalanceResponse = GSON.fromJson(jsonResult, new TypeToken<AccountHolderBalanceResponse>() {
        }.getType());


        return accountHolderBalanceResponse;
    }
}