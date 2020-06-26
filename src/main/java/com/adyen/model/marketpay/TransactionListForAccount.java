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

import com.google.gson.annotations.SerializedName;

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * TransactionListForAccount
 */
public class TransactionListForAccount {
    @SerializedName("accountCode")
    private String accountCode = null;

    @SerializedName("page")
    private Integer page = null;

    public TransactionListForAccount accountCode(String accountCode) {
        this.accountCode = accountCode;
        return this;
    }

    /**
     * The account to get the transaction list for.
     *
     * @return accountCode
     **/
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public TransactionListForAccount page(Integer page) {
        this.page = page;
        return this;
    }

    /**
     * The page number, starting at 1.
     *
     * @return page
     **/
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TransactionListForAccount transactionListForAccount = (TransactionListForAccount) o;
        return Objects.equals(this.accountCode, transactionListForAccount.accountCode) && Objects.equals(this.page, transactionListForAccount.page);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountCode, page);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TransactionListForAccount {\n");

        sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
        sb.append("    page: ").append(toIndentedString(page)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}

