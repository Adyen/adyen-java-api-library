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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.marketpay.AccountHolderBalanceRequest;
import com.adyen.model.marketpay.AccountHolderBalanceResponse;
import com.adyen.model.marketpay.AccountHolderTransactionListRequest;
import com.adyen.model.marketpay.AccountHolderTransactionListResponse;
import com.adyen.model.marketpay.PayoutAccountHolderRequest;
import com.adyen.model.marketpay.PayoutAccountHolderResponse;
import com.adyen.model.marketpay.RefundNotPaidOutTransfersRequest;
import com.adyen.model.marketpay.RefundNotPaidOutTransfersResponse;
import com.adyen.model.marketpay.SetupBeneficiaryRequest;
import com.adyen.model.marketpay.SetupBeneficiaryResponse;
import com.adyen.model.marketpay.TransferFundsRequest;
import com.adyen.model.marketpay.TransferFundsResponse;
import com.adyen.service.resource.fund.AccountHolderBalance;
import com.adyen.service.resource.fund.AccountHolderTransactionList;
import com.adyen.service.resource.fund.PayoutAccountHolder;
import com.adyen.service.resource.fund.RefundNotPaidOutTransfers;
import com.adyen.service.resource.fund.SetupBeneficiary;
import com.adyen.service.resource.fund.TransferFunds;
import com.google.gson.reflect.TypeToken;

public class Fund extends Service {

    private AccountHolderBalance accountHolderBalance;
    private TransferFunds transferFunds;
    private PayoutAccountHolder payoutAccountHolder;
    private AccountHolderTransactionList accountHolderTransactionList;
    private RefundNotPaidOutTransfers refundNotPaidOutTransfers;
    private SetupBeneficiary setupBeneficiary;

    public Fund(Client client) {
        super(client);
        accountHolderBalance = new AccountHolderBalance(this);
        transferFunds = new TransferFunds(this);
        payoutAccountHolder = new PayoutAccountHolder(this);
        accountHolderTransactionList = new AccountHolderTransactionList(this);
        refundNotPaidOutTransfers = new RefundNotPaidOutTransfers(this);
        setupBeneficiary = new SetupBeneficiary(this);

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

    public PayoutAccountHolderResponse payoutAccountHolder(PayoutAccountHolderRequest payoutAccountHolderRequest) throws Exception {
        String jsonRequest = GSON.toJson(payoutAccountHolderRequest);

        String jsonResult = payoutAccountHolder.request(jsonRequest);

        PayoutAccountHolderResponse payoutAccountHolderResponse = GSON.fromJson(jsonResult, new TypeToken<PayoutAccountHolderResponse>() {
        }.getType());


        return payoutAccountHolderResponse;
    }

    public AccountHolderTransactionListResponse accountHolderTransactionList(AccountHolderTransactionListRequest accountHolderTransactionListRequest) throws Exception {
        String jsonRequest = GSON.toJson(accountHolderTransactionListRequest);

        String jsonResult = accountHolderTransactionList.request(jsonRequest);

        AccountHolderTransactionListResponse accountHolderTransactionListResponse = GSON.fromJson(jsonResult, new TypeToken<AccountHolderTransactionListResponse>() {
        }.getType());


        return accountHolderTransactionListResponse;
    }

    public RefundNotPaidOutTransfersResponse refundNotPaidOutTransfers(RefundNotPaidOutTransfersRequest refundNotPaidOutTransfersRequest) throws Exception {
        String jsonRequest = GSON.toJson(refundNotPaidOutTransfersRequest);

        String jsonResult = refundNotPaidOutTransfers.request(jsonRequest);

        RefundNotPaidOutTransfersResponse refundNotPaidOutTransfersResponse = GSON.fromJson(jsonResult, new TypeToken<RefundNotPaidOutTransfersResponse>() {
        }.getType());

        return refundNotPaidOutTransfersResponse;
    }

    public SetupBeneficiaryResponse setupBeneficiary(SetupBeneficiaryRequest setupBeneficiaryRequest) throws Exception {
        String jsonRequest = GSON.toJson(setupBeneficiaryRequest);

        String jsonResult = setupBeneficiary.request(jsonRequest);

        SetupBeneficiaryResponse setupBeneficiaryResponse = GSON.fromJson(jsonResult, new TypeToken<SetupBeneficiaryResponse>() {
        }.getType());

        return setupBeneficiaryResponse;
    }
}