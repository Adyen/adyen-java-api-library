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
import com.adyen.model.marketpay.CheckAccountHolderResponse;
import com.adyen.model.marketpay.CloseAccountHolderRequest;
import com.adyen.model.marketpay.CloseAccountHolderResponse;
import com.adyen.model.marketpay.CloseAccountRequest;
import com.adyen.model.marketpay.CloseAccountResponse;
import com.adyen.model.marketpay.CreateAccountHolderRequest;
import com.adyen.model.marketpay.CreateAccountHolderResponse;
import com.adyen.model.marketpay.CreateAccountRequest;
import com.adyen.model.marketpay.CreateAccountResponse;
import com.adyen.model.marketpay.DeleteBankAccountRequest;
import com.adyen.model.marketpay.DeleteBankAccountResponse;
import com.adyen.model.marketpay.DeletePayoutMethodRequest;
import com.adyen.model.marketpay.DeletePayoutMethodResponse;
import com.adyen.model.marketpay.DeleteShareholderRequest;
import com.adyen.model.marketpay.DeleteShareholderResponse;
import com.adyen.model.marketpay.GetAccountHolderRequest;
import com.adyen.model.marketpay.GetAccountHolderResponse;
import com.adyen.model.marketpay.GetUploadedDocumentsRequest;
import com.adyen.model.marketpay.GetUploadedDocumentsResponse;
import com.adyen.model.marketpay.PerformVerificationRequest;
import com.adyen.model.marketpay.SuspendAccountHolderRequest;
import com.adyen.model.marketpay.SuspendAccountHolderResponse;
import com.adyen.model.marketpay.UnSuspendAccountHolderRequest;
import com.adyen.model.marketpay.UnSuspendAccountHolderResponse;
import com.adyen.model.marketpay.UpdateAccountHolderRequest;
import com.adyen.model.marketpay.UpdateAccountHolderResponse;
import com.adyen.model.marketpay.UpdateAccountHolderStateRequest;
import com.adyen.model.marketpay.UpdateAccountHolderStateResponse;
import com.adyen.model.marketpay.UpdateAccountRequest;
import com.adyen.model.marketpay.UpdateAccountResponse;
import com.adyen.model.marketpay.UploadDocumentRequest;
import com.adyen.model.marketpay.UploadDocumentResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.account.CheckAccountHolder;
import com.adyen.service.resource.account.CloseAccount;
import com.adyen.service.resource.account.CloseAccountHolder;
import com.adyen.service.resource.account.CreateAccount;
import com.adyen.service.resource.account.CreateAccountHolder;
import com.adyen.service.resource.account.DeleteBankAccount;
import com.adyen.service.resource.account.DeletePayoutMethod;
import com.adyen.service.resource.account.DeleteShareholder;
import com.adyen.service.resource.account.GetAccountHolder;
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
    private GetUploadedDocuments getUploadedDocuments;
    private CheckAccountHolder checkAccountHolder;
    private DeletePayoutMethod deletePayoutMethod;

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
        getUploadedDocuments = new GetUploadedDocuments(this);
        checkAccountHolder = new CheckAccountHolder(this);
        deletePayoutMethod = new DeletePayoutMethod(this);
    }

    public CreateAccountHolderResponse createAccountHolder(CreateAccountHolderRequest accountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(accountHolderRequest);

        String jsonResult = createAccountHolder.request(jsonRequest);

        CreateAccountHolderResponse createAccountHolderResponse = GSON.fromJson(jsonResult, new TypeToken<CreateAccountHolderResponse>() {
        }.getType());

        return createAccountHolderResponse;

    }

    public UpdateAccountHolderResponse updateAccountHolder(UpdateAccountHolderRequest updateAccountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(updateAccountHolderRequest);

        String jsonResult = updateAccountHolder.request(jsonRequest);
        UpdateAccountHolderResponse updateAccountHolderResponse = GSON.fromJson(jsonResult, new TypeToken<UpdateAccountHolderResponse>() {
        }.getType());

        return updateAccountHolderResponse;
    }

    public GetAccountHolderResponse getAccountHolder(GetAccountHolderRequest getAccountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(getAccountHolderRequest);

        String jsonResult = getAccountHolder.request(jsonRequest);
        GetAccountHolderResponse getAccountHolderResponse = GSON.fromJson(jsonResult, new TypeToken<GetAccountHolderResponse>() {
        }.getType());

        return getAccountHolderResponse;
    }

    public UploadDocumentResponse uploadDocument(UploadDocumentRequest uploadDocumentRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(uploadDocumentRequest);

        String jsonResult = uploadDocument.request(jsonRequest);
        UploadDocumentResponse uploadDocumentResponse = GSON.fromJson(jsonResult, new TypeToken<UploadDocumentResponse>() {
        }.getType());
        return uploadDocumentResponse;
    }

    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(createAccountRequest);

        String jsonResult = createAccount.request(jsonRequest);
        CreateAccountResponse createAccountResponse = GSON.fromJson(jsonResult, new TypeToken<CreateAccountResponse>() {
        }.getType());

        return createAccountResponse;
    }

    public DeleteBankAccountResponse deleteBankAccount(DeleteBankAccountRequest deleteBankAccountRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(deleteBankAccountRequest);

        String jsonResult = deleteBankAccount.request(jsonRequest);
        DeleteBankAccountResponse deleteBankAccountResponse = GSON.fromJson(jsonResult, new TypeToken<DeleteBankAccountResponse>() {
        }.getType());

        return deleteBankAccountResponse;
    }

    public DeleteShareholderResponse deleteShareholder(DeleteShareholderRequest deleteShareholderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(deleteShareholderRequest);

        String jsonResult = deleteShareholder.request(jsonRequest);
        DeleteShareholderResponse deleteShareholderResponse = GSON.fromJson(jsonResult, new TypeToken<DeleteShareholderResponse>() {
        }.getType());

        return deleteShareholderResponse;
    }

    public SuspendAccountHolderResponse suspendAccountHolder(SuspendAccountHolderRequest suspendAccountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(suspendAccountHolderRequest);

        String jsonResult = suspendAccountHolder.request(jsonRequest);
        SuspendAccountHolderResponse suspendAccountHolderResponse = GSON.fromJson(jsonResult, new TypeToken<SuspendAccountHolderResponse>() {
        }.getType());

        return suspendAccountHolderResponse;
    }

    public UnSuspendAccountHolderResponse unSuspendAccountHolder(UnSuspendAccountHolderRequest unSuspendAccountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(unSuspendAccountHolderRequest);

        String jsonResult = unSuspendAccountHolder.request(jsonRequest);
        UnSuspendAccountHolderResponse unSuspendAccountHolderResponse = GSON.fromJson(jsonResult, new TypeToken<UnSuspendAccountHolderResponse>() {
        }.getType());

        return unSuspendAccountHolderResponse;
    }

    public UpdateAccountHolderStateResponse updateAccountHolderState(UpdateAccountHolderStateRequest updateAccountHolderStateRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(updateAccountHolderStateRequest);

        String jsonResult = updateAccountHolderState.request(jsonRequest);
        UpdateAccountHolderStateResponse updateAccountHolderStateResponse = GSON.fromJson(jsonResult, new TypeToken<UpdateAccountHolderStateResponse>() {
        }.getType());

        return updateAccountHolderStateResponse;
    }

    public CloseAccountResponse closeAccount(CloseAccountRequest closeAccountRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(closeAccountRequest);

        String jsonResult = closeAccount.request(jsonRequest);
        CloseAccountResponse closeAccountResponse = GSON.fromJson(jsonResult, new TypeToken<CloseAccountResponse>() {
        }.getType());

        return closeAccountResponse;
    }

    public CloseAccountHolderResponse closeAccountHolder(CloseAccountHolderRequest closeAccountHolderRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(closeAccountHolderRequest);

        String jsonResult = closeAccountHolder.request(jsonRequest);
        CloseAccountHolderResponse closeAccountHolderResponse = GSON.fromJson(jsonResult, new TypeToken<CloseAccountHolderResponse>() {
        }.getType());

        return closeAccountHolderResponse;
    }

    public UpdateAccountResponse updateAccount(UpdateAccountRequest updateAccountRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(updateAccountRequest);

        String jsonResult = updateAccount.request(jsonRequest);
        UpdateAccountResponse updateAccountResponse = GSON.fromJson(jsonResult, new TypeToken<UpdateAccountResponse>() {
        }.getType());

        return updateAccountResponse;
    }

    public GetUploadedDocumentsResponse getUploadedDocuments(GetUploadedDocumentsRequest getUploadedDocumentsRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(getUploadedDocumentsRequest);

        String jsonResult = getUploadedDocuments.request(jsonRequest);
        GetUploadedDocumentsResponse getUploadedDocumentsResponse = GSON.fromJson(jsonResult, new TypeToken<GetUploadedDocumentsResponse>() {
        }.getType());

        return getUploadedDocumentsResponse;
    }

    public CheckAccountHolderResponse checkAccountHolder(PerformVerificationRequest performVerificationRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(performVerificationRequest);

        String jsonResult = checkAccountHolder.request(jsonRequest);
        CheckAccountHolderResponse checkAccountHolderResponse = GSON.fromJson(jsonResult, new TypeToken<CheckAccountHolderResponse>() {
        }.getType());

        return checkAccountHolderResponse;
    }

    public DeletePayoutMethodResponse deletePayoutMethod(DeletePayoutMethodRequest deletePayoutMethodRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(deletePayoutMethodRequest);

        String jsonResult = deletePayoutMethod.request(jsonRequest);
        DeletePayoutMethodResponse deletePayoutMethodResponse = GSON.fromJson(jsonResult, new TypeToken<DeletePayoutMethodResponse>() {
        }.getType());

        return deletePayoutMethodResponse;
    }
}