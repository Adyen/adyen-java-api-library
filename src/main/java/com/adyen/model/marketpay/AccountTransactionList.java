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
 * AccountTransactionList
 */
public class AccountTransactionList {
    @SerializedName("accountCode")
    private String accountCode = null;

    @SerializedName("hasNextPage")
    private Boolean hasNextPage = null;

    @SerializedName("transactions")
    private List<TransactionContainer> transactionContainers = null;

    private transient List<Transaction> transactions = null;

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

    public AccountTransactionList transactionContainers(List<TransactionContainer> transactionContainers) {
        this.transactionContainers = transactionContainers;
        return this;
    }

    public AccountTransactionList addTransactionContainerItem(TransactionContainer transactionContainerItem) {
        this.transactionContainers.add(transactionContainerItem);
        return this;
    }

    /**
     * Populate the virtual transactions to bypass the transactionContainers list
     *
     * @return transactions
     **/
    public List<Transaction> getTransactions() {
        if (transactions == null) {
            transactions = new ArrayList<Transaction>();
            if (transactionContainers != null && ! transactionContainers.isEmpty()) {
                for (TransactionContainer transactionContainer : transactionContainers) {
                    transactions.add(transactionContainer.getTransaction());
                }
            }
        }
        return transactions;
    }

    /**
     * Creating a new transactions list
     * @param transactions transactions
     */
    public void setTransactions(List<Transaction> transactions) {

        this.transactions = transactions;

        // set as well the container list this will be send in the API request
        this.transactionContainers = new ArrayList<TransactionContainer>();

        for (Transaction transaction : transactions) {

            TransactionContainer transactionContainer = new TransactionContainer(transaction);
            this.transactionContainers.add(transactionContainer);
        }
    }

    public AccountTransactionList addTransaction(Transaction transaction) {
        TransactionContainer transactionContainer = new TransactionContainer(transaction);

        if (transactionContainers == null) {
            transactionContainers = new ArrayList<TransactionContainer>();
        }
        this.transactionContainers.add(transactionContainer);

        if (transactions == null) {
            transactions = new ArrayList<Transaction>();
        }
        return this;
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
        return Objects.equals(this.accountCode, accountTransactionList.accountCode)
                && Objects.equals(this.hasNextPage, accountTransactionList.hasNextPage)
                && Objects.equals(this.transactionContainers, accountTransactionList.transactionContainers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountCode, hasNextPage, transactionContainers);
    }


    @Override
    public String toString() {
        // Populate the accounts list to provide back in the toString() method
        this.getTransactions();
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountTransactionList {\n");

        sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
        sb.append("    hasNextPage: ").append(toIndentedString(hasNextPage)).append("\n");
        sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

