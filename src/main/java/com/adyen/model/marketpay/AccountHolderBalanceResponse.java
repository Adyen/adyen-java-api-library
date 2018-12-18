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
 * AccountHolderBalanceResponse
 */
public class AccountHolderBalanceResponse {
    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("totalBalance")
    private DetailBalance totalBalance = null;

    @SerializedName("resultCode")
    private String resultCode = null;

    @SerializedName("balancePerAccount")
    private List<AccountDetailBalanceContainer> balancePerAccountContainers = null;

    private transient List<AccountDetailBalance> balancePerAccount = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    public AccountHolderBalanceResponse submittedAsync(Boolean submittedAsync) {
        this.submittedAsync = submittedAsync;
        return this;
    }

    /**
     * Get submittedAsync
     *
     * @return submittedAsync
     **/
    public Boolean getSubmittedAsync() {
        return submittedAsync;
    }

    public void setSubmittedAsync(Boolean submittedAsync) {
        this.submittedAsync = submittedAsync;
    }

    public AccountHolderBalanceResponse totalBalance(DetailBalance totalBalance) {
        this.totalBalance = totalBalance;
        return this;
    }

    /**
     * @return totalBalance
     **/
    public DetailBalance getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(DetailBalance totalBalance) {
        this.totalBalance = totalBalance;
    }

    public AccountHolderBalanceResponse resultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     * Get resultCode
     *
     * @return resultCode
     **/
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }


    /**
     * Populate the virtual balancePerAccount to bypass the balancePerAccountContainers list
     *
     * @return balancePerAccount
     **/
    public List<AccountDetailBalance> getBalancePerAccount() {

        if (balancePerAccount == null) {
            balancePerAccount = new ArrayList<AccountDetailBalance>();

            if (balancePerAccountContainers != null && ! balancePerAccountContainers.isEmpty()) {
                for (AccountDetailBalanceContainer balancePerAccountContainer : balancePerAccountContainers) {
                    balancePerAccount.add(balancePerAccountContainer.getAccountDetailBalance());
                }
            }
        }

        return balancePerAccount;
    }

    /**
     * Creating a new balancePerAccount list
     *
     * @param balancePerAccount balance per account
     */
    public void setBalancePerAccount(List<AccountDetailBalance> balancePerAccount) {

        this.balancePerAccount = balancePerAccount;

        // set as well the container list this will be send in the API request
        this.balancePerAccountContainers = new ArrayList<AccountDetailBalanceContainer>();

        for (AccountDetailBalance accountDetailBalance : balancePerAccount) {

            AccountDetailBalanceContainer accountDetailBalanceContainer = new AccountDetailBalanceContainer(accountDetailBalance);
            this.balancePerAccountContainers.add(accountDetailBalanceContainer);
        }
    }

    public AccountHolderBalanceResponse addBalancePerAccount(AccountDetailBalance accountDetailBalance) {
        AccountDetailBalanceContainer accountDetailBalanceContainer = new AccountDetailBalanceContainer(accountDetailBalance);

        if (balancePerAccountContainers == null) {
            balancePerAccountContainers = new ArrayList<AccountDetailBalanceContainer>();
        }
        this.balancePerAccountContainers.add(accountDetailBalanceContainer);

        if (balancePerAccount == null) {
            balancePerAccount = new ArrayList<AccountDetailBalance>();
        }
        this.balancePerAccount.add(accountDetailBalance);

        return this;
    }

    public AccountHolderBalanceResponse pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * psp reference
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountHolderBalanceResponse accountHolderBalanceResponse = (AccountHolderBalanceResponse) o;
        return Objects.equals(this.submittedAsync, accountHolderBalanceResponse.submittedAsync)
                && Objects.equals(this.totalBalance, accountHolderBalanceResponse.totalBalance)
                && Objects.equals(this.resultCode, accountHolderBalanceResponse.resultCode)
                && Objects.equals(this.balancePerAccountContainers, accountHolderBalanceResponse.balancePerAccountContainers)
                && Objects.equals(this.pspReference, accountHolderBalanceResponse.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(submittedAsync, totalBalance, resultCode, balancePerAccountContainers, pspReference);
    }


    @Override
    public String toString() {
        // Populate the balancePerAccount list to provide back in the toString() method
        this.getBalancePerAccount();
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountHolderBalanceResponse {\n");

        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    totalBalance: ").append(toIndentedString(totalBalance)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
        sb.append("    balancePerAccount: ").append(toIndentedString(balancePerAccount)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
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

