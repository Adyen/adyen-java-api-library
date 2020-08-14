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

package com.adyen.model.posterminalmanagement;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * GetTerminalsUnderAccountRequest
 */

public class GetTerminalsUnderAccountRequest {
    @SerializedName("companyAccount")
    private String companyAccount = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("store")
    private String store = null;

    public GetTerminalsUnderAccountRequest companyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
        return this;
    }

    /**
     * Your company account. If you only specify this parameter, the response includes all terminals at all account levels.
     *
     * @return companyAccount
     **/
    public String getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
    }

    public GetTerminalsUnderAccountRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * The merchant account. This is required if you are retrieving the terminals assigned to a store.If you don&#x27;t specify a &#x60;store&#x60; the response includes the terminals assigned to the specified merchant account and the terminals assigned to the stores under this merchant account.
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public GetTerminalsUnderAccountRequest store(String store) {
        this.store = store;
        return this;
    }

    /**
     * The store code of the store. With this parameter, the response only includes the terminals assigned to the specified store.
     *
     * @return store
     **/
    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetTerminalsUnderAccountRequest getTerminalsUnderAccountRequest = (GetTerminalsUnderAccountRequest) o;
        return Objects.equals(this.companyAccount, getTerminalsUnderAccountRequest.companyAccount) &&
                Objects.equals(this.merchantAccount, getTerminalsUnderAccountRequest.merchantAccount) &&
                Objects.equals(this.store, getTerminalsUnderAccountRequest.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyAccount, merchantAccount, store);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetTerminalsUnderAccountRequest {\n");

        sb.append("    companyAccount: ").append(toIndentedString(companyAccount)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    store: ").append(toIndentedString(store)).append("\n");
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
