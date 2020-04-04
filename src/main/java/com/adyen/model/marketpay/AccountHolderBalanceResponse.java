
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

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * AccountHolderBalanceResponse
 */
public class AccountHolderBalanceResponse {
    @SerializedName("balancePerAccount")
    private List<AccountDetailBalance> balancePerAccount = null;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("resultCode")
    private String resultCode = null;

    @SerializedName("totalBalance")
    private DetailBalance totalBalance = null;

    public AccountHolderBalanceResponse balancePerAccount(List<AccountDetailBalance> balancePerAccount) {
        this.balancePerAccount = balancePerAccount;
        return this;
    }

    public AccountHolderBalanceResponse addBalancePerAccountItem(AccountDetailBalance balancePerAccountItem) {
        if (this.balancePerAccount == null) {
            this.balancePerAccount = new ArrayList<>();
        }
        this.balancePerAccount.add(balancePerAccountItem);
        return this;
    }

    /**
     * A list of each account and their balances.
     *
     * @return balancePerAccount
     **/
    public List<AccountDetailBalance> getBalancePerAccount() {
        return balancePerAccount;
    }

    public void setBalancePerAccount(List<AccountDetailBalance> balancePerAccount) {
        this.balancePerAccount = balancePerAccount;
    }

    public AccountHolderBalanceResponse invalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
        return this;
    }

    public AccountHolderBalanceResponse addInvalidFieldsItem(ErrorFieldType invalidFieldsItem) {
        if (this.invalidFields == null) {
            this.invalidFields = new ArrayList<>();
        }
        this.invalidFields.add(invalidFieldsItem);
        return this;
    }

    /**
     * Contains field validation errors that would prevent requests from being processed.
     *
     * @return invalidFields
     **/
    public List<ErrorFieldType> getInvalidFields() {
        return invalidFields;
    }

    public void setInvalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
    }

    public AccountHolderBalanceResponse pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * The reference of a request.  Can be used to uniquely identify the request.
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public AccountHolderBalanceResponse resultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     * The result code.
     *
     * @return resultCode
     **/
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public AccountHolderBalanceResponse totalBalance(DetailBalance totalBalance) {
        this.totalBalance = totalBalance;
        return this;
    }

    /**
     * Get totalBalance
     *
     * @return totalBalance
     **/
    public DetailBalance getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(DetailBalance totalBalance) {
        this.totalBalance = totalBalance;
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
        return Objects.equals(this.balancePerAccount, accountHolderBalanceResponse.balancePerAccount) &&
                Objects.equals(this.invalidFields, accountHolderBalanceResponse.invalidFields) &&
                Objects.equals(this.pspReference, accountHolderBalanceResponse.pspReference) &&
                Objects.equals(this.resultCode, accountHolderBalanceResponse.resultCode) &&
                Objects.equals(this.totalBalance, accountHolderBalanceResponse.totalBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balancePerAccount, invalidFields, pspReference, resultCode, totalBalance);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountHolderBalanceResponse {\n");

        sb.append("    balancePerAccount: ").append(toIndentedString(balancePerAccount)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
        sb.append("    totalBalance: ").append(toIndentedString(totalBalance)).append("\n");
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
