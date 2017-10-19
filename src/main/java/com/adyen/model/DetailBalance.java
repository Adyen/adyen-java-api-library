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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * DetailBalance
 */
public class DetailBalance {
    @SerializedName("pendingBalance")
    private List<AmountContainer> pendingBalance = new ArrayList<AmountContainer>();

    @SerializedName("balance")
    private List<AmountContainer> balance = new ArrayList<AmountContainer>();

    public DetailBalance pendingBalance(List<AmountContainer> pendingBalance) {
        this.pendingBalance = pendingBalance;
        return this;
    }

    public DetailBalance addPendingBalanceItem(AmountContainer pendingBalanceItem) {
        this.pendingBalance.add(pendingBalanceItem);
        return this;
    }

    /**
     * Get pendingBalance
     *
     * @return pendingBalance
     **/
    public List<AmountContainer> getPendingBalance() {
        return pendingBalance;
    }

    public void setPendingBalance(List<AmountContainer> pendingBalance) {
        this.pendingBalance = pendingBalance;
    }

    public DetailBalance balance(List<AmountContainer> balance) {
        this.balance = balance;
        return this;
    }

    public DetailBalance addBalanceItem(AmountContainer balanceItem) {
        this.balance.add(balanceItem);
        return this;
    }

    /**
     * Get balance
     *
     * @return balance
     **/
    public List<AmountContainer> getBalance() {
        return balance;
    }

    public void setBalance(List<AmountContainer> balance) {
        this.balance = balance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DetailBalance detailBalance = (DetailBalance) o;
        return Objects.equals(this.pendingBalance, detailBalance.pendingBalance) && Objects.equals(this.balance, detailBalance.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pendingBalance, balance);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DetailBalance {\n");

        sb.append("    pendingBalance: ").append(toIndentedString(pendingBalance)).append("\n");
        sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
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

