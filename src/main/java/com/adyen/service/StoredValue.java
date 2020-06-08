/*
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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.service;

import com.adyen.ApiKeyAuthenticatedService;
import com.adyen.Client;
import com.adyen.model.storedvalue.StoredValueBalanceCheckRequest;
import com.adyen.model.storedvalue.StoredValueBalanceCheckResponse;
import com.adyen.model.storedvalue.StoredValueBalanceMergeRequest;
import com.adyen.model.storedvalue.StoredValueBalanceMergeResponse;
import com.adyen.model.storedvalue.StoredValueIssueRequest;
import com.adyen.model.storedvalue.StoredValueIssueResponse;
import com.adyen.model.storedvalue.StoredValueLoadRequest;
import com.adyen.model.storedvalue.StoredValueLoadResponse;
import com.adyen.model.storedvalue.StoredValueStatusChangeRequest;
import com.adyen.model.storedvalue.StoredValueStatusChangeResponse;
import com.adyen.model.storedvalue.StoredValueVoidRequest;
import com.adyen.model.storedvalue.StoredValueVoidResponse;
import com.adyen.service.resource.storedvalue.ChangeStatus;
import com.adyen.service.resource.storedvalue.CheckBalance;
import com.adyen.service.resource.storedvalue.Issue;
import com.adyen.service.resource.storedvalue.Load;
import com.adyen.service.resource.storedvalue.MergeBalance;
import com.adyen.service.resource.storedvalue.VoidTransaction;
import com.google.gson.reflect.TypeToken;

public class StoredValue extends ApiKeyAuthenticatedService {

    private ChangeStatus changeStatus;
    private CheckBalance checkBalance;
    private Issue issue;
    private Load load;
    private MergeBalance mergeBalance;
    private VoidTransaction voidTransaction;

    public StoredValue(Client client) {
        super(client);
        changeStatus = new ChangeStatus(this);
        checkBalance = new CheckBalance(this);
        issue = new Issue(this);
        load = new Load(this);
        mergeBalance = new MergeBalance(this);
        voidTransaction = new VoidTransaction(this);
    }


    public StoredValueStatusChangeResponse changeStatus(StoredValueStatusChangeRequest storedValueStatusChangeRequest) throws Exception {
        String jsonRequest = GSON.toJson(storedValueStatusChangeRequest);

        String jsonResult = changeStatus.request(jsonRequest);

        StoredValueStatusChangeResponse storedValueStatusChangeResponse = GSON.fromJson(jsonResult, new TypeToken<StoredValueStatusChangeResponse>() {
        }.getType());

        return storedValueStatusChangeResponse;
    }

    public StoredValueBalanceCheckResponse checkBalance(StoredValueBalanceCheckRequest storedValueBalanceCheckRequest) throws Exception {
        String jsonRequest = GSON.toJson(storedValueBalanceCheckRequest);

        String jsonResult = checkBalance.request(jsonRequest);

        StoredValueBalanceCheckResponse storedValueBalanceCheckResponse = GSON.fromJson(jsonResult, new TypeToken<StoredValueBalanceCheckResponse>() {
        }.getType());

        return storedValueBalanceCheckResponse;
    }

    public StoredValueIssueResponse issue(StoredValueIssueRequest storedValueIssueRequest) throws Exception {
        String jsonRequest = GSON.toJson(storedValueIssueRequest);

        String jsonResult = issue.request(jsonRequest);

        StoredValueIssueResponse storedValueIssueResponse = GSON.fromJson(jsonResult, new TypeToken<StoredValueIssueResponse>() {
        }.getType());

        return storedValueIssueResponse;
    }

    public StoredValueLoadResponse load(StoredValueLoadRequest storedValueLoadRequest) throws Exception {
        String jsonRequest = GSON.toJson(storedValueLoadRequest);

        String jsonResult = load.request(jsonRequest);

        StoredValueLoadResponse storedValueLoadResponse = GSON.fromJson(jsonResult, new TypeToken<StoredValueLoadResponse>() {
        }.getType());

        return storedValueLoadResponse;
    }

    public StoredValueBalanceMergeResponse mergeBalance(StoredValueBalanceMergeRequest storedValueBalanceMergeRequest) throws Exception {
        String jsonRequest = GSON.toJson(storedValueBalanceMergeRequest);

        String jsonResult = mergeBalance.request(jsonRequest);

        StoredValueBalanceMergeResponse storedValueBalanceMergeResponse = GSON.fromJson(jsonResult, new TypeToken<StoredValueBalanceMergeResponse>() {
        }.getType());

        return storedValueBalanceMergeResponse;
    }

    public StoredValueVoidResponse voidTransaction(StoredValueVoidRequest storedValueVoidRequest) throws Exception {
        String jsonRequest = GSON.toJson(storedValueVoidRequest);

        String jsonResult = voidTransaction.request(jsonRequest);

        StoredValueVoidResponse storedValueVoidResponse = GSON.fromJson(jsonResult, new TypeToken<StoredValueVoidResponse>() {
        }.getType());

        return storedValueVoidResponse;
    }

}
