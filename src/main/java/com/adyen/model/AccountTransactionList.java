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
package com.adyen.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * AccountTransactionList
 */
public class AccountTransactionList {
    @SerializedName("accountCode")
    private String accountCode = null;

    @SerializedName("hasNextPage")
    private Boolean hasNextPage = null;

    @SerializedName("transactions")
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public AccountTransactionList accountCode(String accountCode) {
        this.accountCode = accountCode;
        return this;
    }

    /**
     * The code of the account
     *
     * @return accountCode
     **/
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public AccountTransactionList hasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
        return this;
    }

    /**
     * Flag determines if there is next page available
     *
     * @return hasNextPage
     **/
    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public AccountTransactionList transactions(List<Transaction> transactions) {
        this.transactions = transactions;
        return this;
    }

    public AccountTransactionList addTransactionsItem(Transaction transactionsItem) {
        this.transactions.add(transactionsItem);
        return this;
    }

    /**
     * The list of most recent transactions for this account
     *
     * @return transactions
     **/
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountTransactionList accountTransactionList = (AccountTransactionList) o;
        return Objects.equals(this.accountCode, accountTransactionList.accountCode) && Objects.equals(this.hasNextPage, accountTransactionList.hasNextPage) && Objects.equals(this.transactions,
                                                                                                                                                                              accountTransactionList.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountCode, hasNextPage, transactions);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountTransactionList {\n");

        sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
        sb.append("    hasNextPage: ").append(toIndentedString(hasNextPage)).append("\n");
        sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
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

