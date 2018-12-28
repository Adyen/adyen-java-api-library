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
import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;

/**
 * DetailBalance
 */
public class DetailBalance {
    @SerializedName("pendingBalance")
    private List<AmountContainer> pendingBalanceContainers = null;

    private transient List<Amount> pendingBalance = null;

    @SerializedName("balance")
    private List<AmountContainer> balanceContainers = null;

    private transient List<Amount> balance = null;

    /**
     * Populate the virtual pendingBalance to bypass the pendingBalanceContainers list
     *
     * @return pendingBalance
     **/
    public List<Amount> getPendingBalance() {
        if (pendingBalance == null) {
            pendingBalance = new ArrayList<Amount>();
        }

        if (pendingBalanceContainers != null && ! pendingBalanceContainers.isEmpty()) {
            for (AmountContainer amountContainer : pendingBalanceContainers) {
                pendingBalance.add(amountContainer.getAmount());
            }
        }
        return pendingBalance;
    }

    /**
     * Creating a new pendingBalance list
     *
     * @param pendingBalance pendingBalance
     */
    public void setPendingBalance(List<Amount> pendingBalance) {

        this.pendingBalance = pendingBalance;

        // set as well the container list this will be send in the API request
        this.pendingBalanceContainers = new ArrayList<AmountContainer>();
        for (Amount amount : pendingBalance) {

            AmountContainer amountContainer = createAmountContainerFromAmount(amount);
            this.pendingBalanceContainers.add(amountContainer);
        }
    }

    /**
     * Add amount to the pendingBalanceContainers and pendingBalance list
     * @param amount amount
     * @return DetailBalance
     */
    public DetailBalance addPendingBalanceItem(Amount amount) {
        AmountContainer amountContainer = createAmountContainerFromAmount(amount);

        if (pendingBalanceContainers == null) {
            pendingBalanceContainers = new ArrayList<AmountContainer>();
        }
        this.pendingBalanceContainers.add(amountContainer);

        if (pendingBalance == null) {
            pendingBalance = new ArrayList<Amount>();
        }
        this.pendingBalance.add(amount);

        return this;
    }

    private AmountContainer createAmountContainerFromAmount(Amount amount) {
        AmountContainer amountContainer = new AmountContainer();
        amountContainer.setAmount(amount);
        return amountContainer;
    }

    /**
     * Populate the virtual balance to bypass the balanceContainers list
     *
     * @return balance
     **/
    public List<Amount> getBalance() {

        if (balance == null) {
            balance = new ArrayList<Amount>();

            if (balanceContainers != null && ! balanceContainers.isEmpty()) {
                for (AmountContainer amountContainer : balanceContainers) {
                    balance.add(amountContainer.getAmount());
                }
            }
        }
        return balance;
    }

    /**
     * Creating a new balance list
     *
     * @param balance balance
     */
    public void setBalance(List<Amount> balance) {

        this.balance = balance;

        // set as well the container list this will be send in the API request
        this.balanceContainers = new ArrayList<AmountContainer>();
        for (Amount amount : balance) {

            AmountContainer amountContainer = createAmountContainerFromAmount(amount);
            this.balanceContainers.add(amountContainer);
        }
    }

    /**
     * Add amount to the balanceContainers and balance list
     *
     * @param amount amount
     * @return DetailBalance
     */
    public DetailBalance addBalanceItem(Amount amount) {
        AmountContainer amountContainer = createAmountContainerFromAmount(amount);

        if (balanceContainers == null) {
            balanceContainers = new ArrayList<AmountContainer>();
        }
        this.balanceContainers.add(amountContainer);

        if (balance == null) {
            balance = new ArrayList<Amount>();
        }
        this.balance.add(amount);

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
        DetailBalance detailBalance = (DetailBalance) o;
        return Objects.equals(this.pendingBalanceContainers, detailBalance.pendingBalanceContainers) && Objects.equals(this.balanceContainers, detailBalance.balanceContainers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pendingBalanceContainers, balanceContainers);
    }


    @Override
    public String toString() {
        // Populate the pendingBalance list to provide back in the toString() method
        this.getPendingBalance();

        // Populate the balance list to provide back in the toString() method
        this.getBalance();

        StringBuilder sb = new StringBuilder();
        sb.append("class DetailBalance {\n");

        sb.append("    pendingBalance: ").append(toIndentedString(pendingBalance)).append("\n");
        sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     * @param o string
     * @return indented string
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

