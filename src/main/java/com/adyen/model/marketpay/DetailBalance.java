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

package com.adyen.model.marketpay;

import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * DetailBalance
 */
public class DetailBalance {
    @SerializedName("balance")
    private List<Amount> balance = null;

    @SerializedName("onHoldBalance")
    private List<Amount> onHoldBalance = null;

    @SerializedName("pendingBalance")
    private List<Amount> pendingBalance = null;

    public DetailBalance balance(List<Amount> balance) {
        this.balance = balance;
        return this;
    }

    public DetailBalance addBalanceItem(Amount balanceItem) {
        if (this.balance == null) {
            this.balance = new ArrayList<>();
        }
        this.balance.add(balanceItem);
        return this;
    }

    /**
     * The list of balances held by the account.
     *
     * @return balance
     **/
    public List<Amount> getBalance() {
        return balance;
    }

    public void setBalance(List<Amount> balance) {
        this.balance = balance;
    }

    public DetailBalance onHoldBalance(List<Amount> onHoldBalance) {
        this.onHoldBalance = onHoldBalance;
        return this;
    }

    public DetailBalance addOnHoldBalanceItem(Amount onHoldBalanceItem) {
        if (this.onHoldBalance == null) {
            this.onHoldBalance = new ArrayList<>();
        }
        this.onHoldBalance.add(onHoldBalanceItem);
        return this;
    }

    /**
     * The list of on hold balances held by the account.
     *
     * @return onHoldBalance
     **/
    public List<Amount> getOnHoldBalance() {
        return onHoldBalance;
    }

    public void setOnHoldBalance(List<Amount> onHoldBalance) {
        this.onHoldBalance = onHoldBalance;
    }

    public DetailBalance pendingBalance(List<Amount> pendingBalance) {
        this.pendingBalance = pendingBalance;
        return this;
    }

    public DetailBalance addPendingBalanceItem(Amount pendingBalanceItem) {
        if (this.pendingBalance == null) {
            this.pendingBalance = new ArrayList<>();
        }
        this.pendingBalance.add(pendingBalanceItem);
        return this;
    }

    /**
     * The list of pending balances held by the account.
     *
     * @return pendingBalance
     **/
    public List<Amount> getPendingBalance() {
        return pendingBalance;
    }

    public void setPendingBalance(List<Amount> pendingBalance) {
        this.pendingBalance = pendingBalance;
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
        return Objects.equals(this.balance, detailBalance.balance) &&
                Objects.equals(this.onHoldBalance, detailBalance.onHoldBalance) &&
                Objects.equals(this.pendingBalance, detailBalance.pendingBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, onHoldBalance, pendingBalance);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DetailBalance {\n");

        sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
        sb.append("    onHoldBalance: ").append(toIndentedString(onHoldBalance)).append("\n");
        sb.append("    pendingBalance: ").append(toIndentedString(pendingBalance)).append("\n");
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
