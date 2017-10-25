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

package com.adyen.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * AccountDetailBalanceContainer
 */
public class AccountDetailBalanceContainer {
    @SerializedName("AccountDetailBalance")
    private AccountDetailBalance accountDetailBalance = null;

    /**
     * accountDetailBalance
     *
     * @return accountDetailBalance
     */
    public AccountDetailBalance getAccountDetailBalance() {
        return accountDetailBalance;
    }

    public void setAccountDetailBalance(AccountDetailBalance accountDetailBalance) {
        this.accountDetailBalance = accountDetailBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountDetailBalanceContainer accountDetailBalanceContainer = (AccountDetailBalanceContainer) o;
        return Objects.equals(this.accountDetailBalance, accountDetailBalanceContainer.accountDetailBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountDetailBalance);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountDetailBalanceContainer {\n");

        sb.append("    accountDetailBalance: ").append(toIndentedString(accountDetailBalance)).append("\n");
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
