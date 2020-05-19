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
 * AccountHolderTransactionListResponse
 */

public class AccountHolderTransactionListResponse {
    @SerializedName("accountTransactionLists")
    private List<AccountTransactionList> accountTransactionLists = null;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("resultCode")
    private String resultCode = null;

    public AccountHolderTransactionListResponse accountTransactionLists(List<AccountTransactionList> accountTransactionLists) {
        this.accountTransactionLists = accountTransactionLists;
        return this;
    }

    public AccountHolderTransactionListResponse addAccountTransactionListsItem(AccountTransactionList accountTransactionListsItem) {
        if (this.accountTransactionLists == null) {
            this.accountTransactionLists = new ArrayList<>();
        }
        this.accountTransactionLists.add(accountTransactionListsItem);
        return this;
    }

    /**
     * A list of the transactions.
     *
     * @return accountTransactionLists
     **/
    public List<AccountTransactionList> getAccountTransactionLists() {
        return accountTransactionLists;
    }

    public void setAccountTransactionLists(List<AccountTransactionList> accountTransactionLists) {
        this.accountTransactionLists = accountTransactionLists;
    }

    public AccountHolderTransactionListResponse invalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
        return this;
    }

    public AccountHolderTransactionListResponse addInvalidFieldsItem(ErrorFieldType invalidFieldsItem) {
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

    public AccountHolderTransactionListResponse pspReference(String pspReference) {
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

    public AccountHolderTransactionListResponse resultCode(String resultCode) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountHolderTransactionListResponse accountHolderTransactionListResponse = (AccountHolderTransactionListResponse) o;
        return Objects.equals(this.accountTransactionLists, accountHolderTransactionListResponse.accountTransactionLists) &&
                Objects.equals(this.invalidFields, accountHolderTransactionListResponse.invalidFields) &&
                Objects.equals(this.pspReference, accountHolderTransactionListResponse.pspReference) &&
                Objects.equals(this.resultCode, accountHolderTransactionListResponse.resultCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTransactionLists, invalidFields, pspReference, resultCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountHolderTransactionListResponse {\n");

        sb.append("    accountTransactionLists: ").append(toIndentedString(accountTransactionLists)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
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
