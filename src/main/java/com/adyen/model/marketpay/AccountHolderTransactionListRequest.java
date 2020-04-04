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
package com.adyen.model.marketpay;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * AccountHolderTransactionListRequest
 */
public class AccountHolderTransactionListRequest {
    @SerializedName("transactionListsPerAccount")
    private List<TransactionListForAccount> transactionListsPerAccount = new ArrayList<>();

    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    /**
     * Gets or Sets transactionStatuses
     */
    public enum TransactionStatusesEnum {
        @SerializedName("Chargeback")
        CHARGEBACK("Chargeback"),

        @SerializedName("ChargebackReceived")
        CHARGEBACKRECEIVED("ChargebackReceived"),

        @SerializedName("ChargebackReversed")
        CHARGEBACKREVERSED("ChargebackReversed"),

        @SerializedName("ChargebackReversedReceived")
        CHARGEBACKREVERSEDRECEIVED("ChargebackReversedReceived"),

        @SerializedName("CreditFailed")
        CREDITFAILED("CreditFailed"),

        @SerializedName("Credited")
        CREDITED("Credited"),

        @SerializedName("DebitFailed")
        DEBITFAILED("DebitFailed"),

        @SerializedName("DebitReversedReceived")
        DEBITREVERSEDRECEIVED("DebitReversedReceived"),

        @SerializedName("Debited")
        DEBITED("Debited"),

        @SerializedName("DebitedReversed")
        DEBITEDREVERSED("DebitedReversed"),

        @SerializedName("FundTransfer")
        FUNDTRANSFER("FundTransfer"),

        @SerializedName("Payout")
        PAYOUT("Payout"),

        @SerializedName("PayoutReversed")
        PAYOUTREVERSED("PayoutReversed"),

        @SerializedName("PendingCredit")
        PENDINGCREDIT("PendingCredit"),

        @SerializedName("PendingDebit")
        PENDINGDEBIT("PendingDebit"),

        @SerializedName("PendingFundTransfer")
        PENDINGFUNDTRANSFER("PendingFundTransfer");

        private String value;

        TransactionStatusesEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("transactionStatuses")
    private List<TransactionStatusesEnum> transactionStatuses = new ArrayList<>();

    public AccountHolderTransactionListRequest transactionListsPerAccount(List<TransactionListForAccount> transactionListsPerAccount) {
        this.transactionListsPerAccount = transactionListsPerAccount;
        return this;
    }

    public AccountHolderTransactionListRequest addTransactionListsPerAccountItem(TransactionListForAccount transactionListsPerAccountItem) {
        this.transactionListsPerAccount.add(transactionListsPerAccountItem);
        return this;
    }

    /**
     * Fill this to get the transaction list for specific accounts of a specific page. Leave empty to get the last 50 transactions for all accounts of the account holder.
     *
     * @return transactionListsPerAccount
     **/
    public List<TransactionListForAccount> getTransactionListsPerAccount() {
        return transactionListsPerAccount;
    }

    public void setTransactionListsPerAccount(List<TransactionListForAccount> transactionListsPerAccount) {
        this.transactionListsPerAccount = transactionListsPerAccount;
    }

    public AccountHolderTransactionListRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * The account holder for which you want the transaction list
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public AccountHolderTransactionListRequest transactionStatuses(List<TransactionStatusesEnum> transactionStatuses) {
        this.transactionStatuses = transactionStatuses;
        return this;
    }

    public AccountHolderTransactionListRequest addTransactionStatusesItem(TransactionStatusesEnum transactionStatusesItem) {
        this.transactionStatuses.add(transactionStatusesItem);
        return this;
    }

    /**
     * The filter for transaction status
     *
     * @return transactionStatuses
     **/
    public List<TransactionStatusesEnum> getTransactionStatuses() {
        return transactionStatuses;
    }

    public void setTransactionStatuses(List<TransactionStatusesEnum> transactionStatuses) {
        this.transactionStatuses = transactionStatuses;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountHolderTransactionListRequest accountHolderTransactionListRequest = (AccountHolderTransactionListRequest) o;
        return Objects.equals(this.transactionListsPerAccount, accountHolderTransactionListRequest.transactionListsPerAccount)
                && Objects.equals(this.accountHolderCode,
                                  accountHolderTransactionListRequest.accountHolderCode)
                && Objects.equals(this.transactionStatuses, accountHolderTransactionListRequest.transactionStatuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionListsPerAccount, accountHolderCode, transactionStatuses);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountHolderTransactionListRequest {\n");

        sb.append("    transactionListsPerAccount: ").append(toIndentedString(transactionListsPerAccount)).append("\n");
        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    transactionStatuses: ").append(toIndentedString(transactionStatuses)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

