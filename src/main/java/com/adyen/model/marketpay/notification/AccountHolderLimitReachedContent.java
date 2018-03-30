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

package com.adyen.model.marketpay.notification;

import java.util.Date;
import com.adyen.model.Amount;
import com.adyen.model.marketpay.AccountState;
import com.google.gson.annotations.SerializedName;

public class AccountHolderLimitReachedContent {
    @SerializedName("accountHolderCode")
    private String accountHolderCode;

    @SerializedName("accountState")
    private AccountState accountState;

    @SerializedName("amount")
    private Amount amount;

    @SerializedName("totalAmountBeforeLimit")
    private Amount totalAmountBeforeLimit;

    @SerializedName("transactionDate")
    private Date transactionDate;

    @SerializedName("transactionFailed")
    private String transactionFailed;

    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public AccountState getAccountState() {
        return accountState;
    }

    public void setAccountState(AccountState accountState) {
        this.accountState = accountState;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Amount getTotalAmountBeforeLimit() {
        return totalAmountBeforeLimit;
    }

    public void setTotalAmountBeforeLimit(Amount totalAmountBeforeLimit) {
        this.totalAmountBeforeLimit = totalAmountBeforeLimit;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionFailed() {
        return transactionFailed;
    }

    public void setTransactionFailed(String transactionFailed) {
        this.transactionFailed = transactionFailed;
    }

    @Override
    public String toString() {
        return "AccountHolderLimitReachedContent{"
                + "accountHolderCode='"
                + accountHolderCode
                + '\''
                + ", accountState="
                + accountState
                + ", amount="
                + amount
                + ", totalAmountBeforeLimit="
                + totalAmountBeforeLimit
                + ", transactionDate="
                + transactionDate
                + ", transactionFailed='"
                + transactionFailed
                + '\''
                + '}';
    }
}
