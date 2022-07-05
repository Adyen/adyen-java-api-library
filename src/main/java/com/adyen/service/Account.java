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

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.marketpay.*;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.account.CheckAccountHolder;
import com.adyen.service.resource.account.CloseAccount;
import com.adyen.service.resource.account.CloseAccountHolder;
import com.adyen.service.resource.account.CloseStores;
import com.adyen.service.resource.account.CreateAccount;
import com.adyen.service.resource.account.CreateAccountHolder;
import com.adyen.service.resource.account.DeleteBankAccount;
import com.adyen.service.resource.account.DeletePayoutMethod;
import com.adyen.service.resource.account.DeleteShareholder;
import com.adyen.service.resource.account.DeleteSignatories;
import com.adyen.service.resource.account.GetAccountHolder;
import com.adyen.service.resource.account.GetTaxForm;
import com.adyen.service.resource.account.GetUploadedDocuments;
import com.adyen.service.resource.account.SuspendAccountHolder;
import com.adyen.service.resource.account.UnSuspendAccountHolder;
import com.adyen.service.resource.account.UpdateAccount;
import com.adyen.service.resource.account.UpdateAccountHolder;
import com.adyen.service.resource.account.UpdateAccountHolderState;
import com.adyen.service.resource.account.UploadDocument;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Account extends Service {

    private final CreateAccountHolder createAccountHolder;
    private final UpdateAccountHolder updateAccountHolder;
    private final GetAccountHolder getAccountHolder;
    private final UploadDocument uploadDocument;
    private final CreateAccount createAccount;
    private final DeleteBankAccount deleteBankAccount;
    private final DeleteShareholder deleteShareholder;
    private final DeleteSignatories deleteSignatories;
    private final SuspendAccountHolder suspendAccountHolder;
    private final UnSuspendAccountHolder unSuspendAccountHolder;
    private final UpdateAccountHolderState updateAccountHolderState;
    private final CloseAccount closeAccount;
    private final CloseAccountHolder closeAccountHolder;
    private final CloseStores closeStores;
    private final UpdateAccount updateAccount;
    private final GetUploadedDocuments getUploadedDocuments;
    private final CheckAccountHolder checkAccountHolder;
    private final DeletePayoutMethod deletePayoutMethod;
    private final GetTaxForm getTaxForm;

    public Account(Client client) {
        super(client);

        createAccountHolder = new CreateAccountHolder(this);
        updateAccountHolder = new UpdateAccountHolder(this);
        getAccountHolder = new GetAccountHolder(this);
        uploadDocument = new UploadDocument(this);
        createAccount = new CreateAccount(this);
        deleteBankAccount = new DeleteBankAccount(this);
        deleteShareholder = new DeleteShareholder(this);
        deleteSignatories = new DeleteSignatories(this);
        suspendAccountHolder = new SuspendAccountHolder(this);
        unSuspendAccountHolder = new UnSuspendAccountHolder(this);
        updateAccountHolderState = new UpdateAccountHolderState(this);
        closeAccount = new CloseAccount(this);
        closeAccountHolder = new CloseAccountHolder(this);
        closeStores = new CloseStores(this);
        updateAccount = new UpdateAccount(this);
        getUploadedDocuments = new GetUploadedDocuments(this);
        checkAccountHolder = new CheckAccountHolder(this);
        deletePayoutMethod = new DeletePayoutMethod(this);
        getTaxForm = new GetTaxForm(this);
    }

    public CreateAccountHolderResponse createAccountHolder(CreateAccountHolderRequest accountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(accountHolderRequest);

        String jsonResult = createAccountHolder.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<CreateAccountHolderResponse>() {
        }.getType());
    }

    public UpdateAccountHolderResponse updateAccountHolder(UpdateAccountHolderRequest updateAccountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(updateAccountHolderRequest);

        String jsonResult = updateAccountHolder.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<UpdateAccountHolderResponse>() {
        }.getType());
    }

    public GetAccountHolderResponse getAccountHolder(GetAccountHolderRequest getAccountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(getAccountHolderRequest);

        String jsonResult = getAccountHolder.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<GetAccountHolderResponse>() {
        }.getType());
    }

    public UploadDocumentResponse uploadDocument(UploadDocumentRequest uploadDocumentRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(uploadDocumentRequest);

        String jsonResult = uploadDocument.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<UploadDocumentResponse>() {
        }.getType());
    }

    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(createAccountRequest);

        String jsonResult = createAccount.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<CreateAccountResponse>() {
        }.getType());
    }

    public DeleteBankAccountResponse deleteBankAccount(DeleteBankAccountRequest deleteBankAccountRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(deleteBankAccountRequest);

        String jsonResult = deleteBankAccount.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<DeleteBankAccountResponse>() {
        }.getType());
    }

    public DeleteShareholderResponse deleteShareholder(DeleteShareholderRequest deleteShareholderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(deleteShareholderRequest);

        String jsonResult = deleteShareholder.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<DeleteShareholderResponse>() {
        }.getType());
    }

    public DeleteSignatoriesResponse deleteSignatories(DeleteSignatoriesRequest deleteSignatoriesRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(deleteSignatoriesRequest);

        String jsonResult = deleteSignatories.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<DeleteSignatoriesResponse>() {
        }.getType());
    }

    public SuspendAccountHolderResponse suspendAccountHolder(SuspendAccountHolderRequest suspendAccountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(suspendAccountHolderRequest);

        String jsonResult = suspendAccountHolder.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<SuspendAccountHolderResponse>() {
        }.getType());
    }

    public UnSuspendAccountHolderResponse unSuspendAccountHolder(UnSuspendAccountHolderRequest unSuspendAccountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(unSuspendAccountHolderRequest);

        String jsonResult = unSuspendAccountHolder.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<UnSuspendAccountHolderResponse>() {
        }.getType());
    }

    public UpdateAccountHolderStateResponse updateAccountHolderState(UpdateAccountHolderStateRequest updateAccountHolderStateRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(updateAccountHolderStateRequest);

        String jsonResult = updateAccountHolderState.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<UpdateAccountHolderStateResponse>() {
        }.getType());
    }

    public CloseAccountResponse closeAccount(CloseAccountRequest closeAccountRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(closeAccountRequest);

        String jsonResult = closeAccount.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<CloseAccountResponse>() {
        }.getType());
    }

    public CloseAccountHolderResponse closeAccountHolder(CloseAccountHolderRequest closeAccountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(closeAccountHolderRequest);

        String jsonResult = closeAccountHolder.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<CloseAccountHolderResponse>() {
        }.getType());
    }
    public GenericResponse closeStores(CloseStoresRequest closeStoresRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(closeStoresRequest);

        String jsonResult = closeStores.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<GenericResponse>() {
        }.getType());
    }

    public UpdateAccountResponse updateAccount(UpdateAccountRequest updateAccountRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(updateAccountRequest);

        String jsonResult = updateAccount.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<UpdateAccountResponse>() {
        }.getType());
    }

    public GetUploadedDocumentsResponse getUploadedDocuments(GetUploadedDocumentsRequest getUploadedDocumentsRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(getUploadedDocumentsRequest);

        String jsonResult = getUploadedDocuments.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<GetUploadedDocumentsResponse>() {
        }.getType());
    }

    public CheckAccountHolderResponse checkAccountHolder(PerformVerificationRequest performVerificationRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(performVerificationRequest);

        String jsonResult = checkAccountHolder.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<CheckAccountHolderResponse>() {
        }.getType());
    }

    public DeletePayoutMethodResponse deletePayoutMethod(DeletePayoutMethodRequest deletePayoutMethodRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(deletePayoutMethodRequest);

        String jsonResult = deletePayoutMethod.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<DeletePayoutMethodResponse>() {
        }.getType());
    }

    public GetTaxFormResponse getTaxForm(GetTaxFormRequest getTaxFormRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(getTaxFormRequest);

        String jsonResult = getTaxForm.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<GetTaxFormResponse>() {
        }.getType());
    }
}
