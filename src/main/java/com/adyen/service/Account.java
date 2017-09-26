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
    private DeleteBankAccount deleteBankAccount;
    private DeleteShareholder deleteShareholder;
    private SuspendAccountHolder suspendAccountHolder;
    private UnSuspendAccountHolder unSuspendAccountHolder;
    private UpdateAccountHolderState updateAccountHolderState;
    private CloseAccount closeAccount;
    private CloseAccountHolder closeAccountHolder;
    private UpdateAccount updateAccount;

    public Account(Client client) {
        super(client);

        createAccountHolder = new CreateAccountHolder(this);
        updateAccountHolder = new UpdateAccountHolder(this);
        getAccountHolder = new GetAccountHolder(this);
        uploadDocument = new UploadDocument(this);
        createAccount = new CreateAccount(this);
        deleteBankAccount = new DeleteBankAccount(this);
        deleteShareholder = new DeleteShareholder(this);
        suspendAccountHolder = new SuspendAccountHolder(this);
        unSuspendAccountHolder = new UnSuspendAccountHolder(this);
        updateAccountHolderState = new UpdateAccountHolderState(this);
        closeAccount = new CloseAccount(this);
        closeAccountHolder = new CloseAccountHolder(this);
        updateAccount = new UpdateAccount(this);

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

    public DeleteBankAccountResponse deleteBankAccount(DeleteBankAccountRequest deleteBankAccountRequest) throws Exception{
        String jsonRequest = GSON.toJson(deleteBankAccountRequest);

        String jsonResult = deleteBankAccount.request(jsonRequest);
        DeleteBankAccountResponse deleteBankAccountResponse = GSON.fromJson(jsonResult, new TypeToken<DeleteBankAccountResponse>() {
        }.getType());

        return deleteBankAccountResponse;
    }

    public DeleteShareholderResponse deleteShareholder(DeleteShareholderRequest deleteShareholderRequest) throws Exception{
        String jsonRequest = GSON.toJson(deleteShareholderRequest);

        String jsonResult = deleteShareholder.request(jsonRequest);
        DeleteShareholderResponse deleteShareholderResponse = GSON.fromJson(jsonResult, new TypeToken<DeleteShareholderResponse>() {
        }.getType());

        return deleteShareholderResponse;
    }

    public SuspendAccountHolderResponse suspendAccountHolder(SuspendAccountHolderRequest suspendAccountHolderRequest) throws  Exception{
        String jsonRequest = GSON.toJson(suspendAccountHolderRequest);

        String jsonResult = suspendAccountHolder.request(jsonRequest);
        SuspendAccountHolderResponse suspendAccountHolderResponse = GSON.fromJson(jsonResult, new TypeToken<SuspendAccountHolderResponse>() {
        }.getType());

        return suspendAccountHolderResponse;
    }

    public UnSuspendAccountHolderResponse unSuspendAccountHolder(UnSuspendAccountHolderRequest unSuspendAccountHolderRequest) throws Exception {
        String jsonRequest = GSON.toJson(unSuspendAccountHolderRequest);

        String jsonResult = unSuspendAccountHolder.request(jsonRequest);
        UnSuspendAccountHolderResponse unSuspendAccountHolderResponse = GSON.fromJson(jsonResult, new TypeToken<UnSuspendAccountHolderResponse>() {
        }.getType());

        return unSuspendAccountHolderResponse;
    }

    public UpdateAccountHolderStateResponse updateAccountHolderState(UpdateAccountHolderStateRequest updateAccountHolderStateRequest) throws Exception{
        String jsonRequest = GSON.toJson(updateAccountHolderStateRequest);

        String jsonResult = updateAccountHolderState.request(jsonRequest);
        UpdateAccountHolderStateResponse updateAccountHolderStateResponse = GSON.fromJson(jsonResult, new TypeToken<UpdateAccountHolderStateResponse>() {
        }.getType());

        return updateAccountHolderStateResponse;
    }

    public CloseAccountResponse closeAccount(CloseAccountRequest closeAccountRequest) throws Exception{
        String jsonRequest = GSON.toJson(closeAccountRequest);

        String jsonResult = closeAccount.request(jsonRequest);
        CloseAccountResponse closeAccountResponse = GSON.fromJson(jsonResult, new TypeToken<CloseAccountResponse>() {
        }.getType());

        return closeAccountResponse;
    }

    public CloseAccountHolderResponse closeAccountHolder(CloseAccountHolderRequest closeAccountHolderRequest) throws Exception{
        String jsonRequest = GSON.toJson(closeAccountHolderRequest);

        String jsonResult = closeAccountHolder.request(jsonRequest);
        CloseAccountHolderResponse closeAccountHolderResponse = GSON.fromJson(jsonResult, new TypeToken<CloseAccountHolderResponse>() {
        }.getType());

        return closeAccountHolderResponse;
    }

    public UpdateAccountResponse updateAccount(UpdateAccountRequest updateAccountRequest) throws Exception{
        String jsonRequest = GSON.toJson(updateAccountRequest);

        String jsonResult = updateAccount.request(jsonRequest);
        UpdateAccountResponse updateAccountResponse = GSON.fromJson(jsonResult, new TypeToken<UpdateAccountResponse>() {
        }.getType());

        return updateAccountResponse;
    }
}