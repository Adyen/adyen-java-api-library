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

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * AccountTransactionListContainer
 */
public class AccountTransactionListContainer {
    @SerializedName("AccountTransactionList")
    private AccountTransactionList accountTransactionList = null;

    public AccountTransactionListContainer(AccountTransactionList accountTransactionList) {
        this.accountTransactionList = accountTransactionList;
    }

    /**
     * accountTransactionList
     *
     * @return accountTransactionList
     */
    public AccountTransactionList getAccountTransactionList() {
        return accountTransactionList;
    }

    public void setAccountTransactionList(AccountTransactionList accountTransactionList) {
        this.accountTransactionList = accountTransactionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountTransactionListContainer accountTransactionListContainer = (AccountTransactionListContainer) o;
        return Objects.equals(this.accountTransactionList, accountTransactionListContainer.accountTransactionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTransactionList);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountTransactionListContainer {\n");

        sb.append("    accountTransactionList: ").append(toIndentedString(accountTransactionList)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
