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
import com.adyen.model.*;
import com.adyen.service.resource.account.*;
import com.google.gson.reflect.TypeToken;

/**
 * Created by rikt on 9/7/17.
 */
public class Account extends Service {

    private CreateAccountHolder createAccountHolder;
    private UpdateAccountHolder updateAccountHolder;
    private GetAccountHolder getAccountHolder;
    private UploadDocument uploadDocument;
    private CreateAccount createAccount;

    public Account(Client client) {
        super(client);

        createAccountHolder = new CreateAccountHolder(this);
        updateAccountHolder = new UpdateAccountHolder(this);
        getAccountHolder = new GetAccountHolder(this);
        uploadDocument = new UploadDocument(this);
        createAccount = new CreateAccount(this);
    }

    public CreateAccountHolderResponse createAccountHolder(CreateAccountHolderRequest accountHolderRequest) throws Exception {
        String jsonRequest = GSON.toJson(accountHolderRequest);

        String jsonResult = createAccountHolder.request(jsonRequest);

        CreateAccountHolderResponse createAccountHolderResponse = GSON.fromJson(jsonResult, new TypeToken<CreateAccountHolderResponse>() {
        }.getType());

        return createAccountHolderResponse;

    }

    public UpdateAccountHolderResponse updateAccountHolder(UpdateAccountHolderRequest updateAccountHolderRequest) throws Exception {
        String jsonRequest = GSON.toJson(updateAccountHolderRequest);

        String jsonResult = updateAccountHolder.request(jsonRequest);
        UpdateAccountHolderResponse updateAccountHolderResponse = GSON.fromJson(jsonResult, new TypeToken<UpdateAccountHolderResponse>() {
        }.getType());

        return updateAccountHolderResponse;
    }

    public GetAccountHolderResponse getAccountHolder(GetAccountHolderRequest getAccountHolderRequest) throws Exception {
        String jsonRequest = GSON.toJson(getAccountHolderRequest);

        String jsonResult = getAccountHolder.request(jsonRequest);
        GetAccountHolderResponse getAccountHolderResponse = GSON.fromJson(jsonResult, new TypeToken<GetAccountHolderResponse>() {
        }.getType());

        return getAccountHolderResponse;
    }

    public UploadDocumentResponse uploadDocument(UploadDocumentRequest uploadDocumentRequest) throws Exception {
        String jsonRequest = GSON.toJson(uploadDocumentRequest);

        String jsonResult = uploadDocument.request(jsonRequest);
        UploadDocumentResponse uploadDocumentResponse = GSON.fromJson(jsonResult, new TypeToken<UploadDocumentResponse>() {
        }.getType());
        return uploadDocumentResponse;
    }

    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) throws Exception {
        String jsonRequest = GSON.toJson(createAccountRequest);

        String jsonResult = createAccount.request(jsonRequest);
        CreateAccountResponse createAccountResponse = GSON.fromJson(jsonResult, new TypeToken<CreateAccountResponse>() {
        }.getType());

        return createAccountResponse;
    }

}