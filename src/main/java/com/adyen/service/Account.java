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
import com.adyen.model.CreateAccountHolderRequest;
import com.adyen.model.CreateAccountHolderResponse;
import com.adyen.service.resource.account.CreateAccountHolder;
import com.google.gson.reflect.TypeToken;

/**
 * Created by rikt on 9/7/17.
 */
public class Account extends Service {

    private CreateAccountHolder createAccountHolder;

    public Account(Client client) {
        super(client);

        createAccountHolder = new CreateAccountHolder(this);
    }

    public CreateAccountHolderResponse createAccountHolder(CreateAccountHolderRequest accountHolderRequest) throws Exception {
        String jsonRequest = GSON.toJson(accountHolderRequest);

        String jsonResult = createAccountHolder.request(jsonRequest);

        CreateAccountHolderResponse createAccountHolderResponse = GSON.fromJson(jsonResult, new TypeToken<CreateAccountHolderResponse>() {
        }.getType());

        return createAccountHolderResponse;

    }
}