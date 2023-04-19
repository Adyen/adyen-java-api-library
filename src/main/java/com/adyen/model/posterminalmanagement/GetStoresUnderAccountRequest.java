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
 * GetStoresUnderAccountRequest
 */

public class GetStoresUnderAccountRequest {
    @SerializedName("companyAccount")
    private String companyAccount = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    public GetStoresUnderAccountRequest companyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
        return this;
    }

    /**
     * The company account. If you only specify this parameter, the response includes the stores of all merchant accounts that are associated with the company account.
     *
     * @return companyAccount
     **/
    public String getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
    }

    public GetStoresUnderAccountRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * The merchant account. With this parameter, the response only includes the stores of the specified merchant account.
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetStoresUnderAccountRequest getStoresUnderAccountRequest = (GetStoresUnderAccountRequest) o;
        return Objects.equals(this.companyAccount, getStoresUnderAccountRequest.companyAccount) &&
                Objects.equals(this.merchantAccount, getStoresUnderAccountRequest.merchantAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyAccount, merchantAccount);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetStoresUnderAccountRequest {\n");

        sb.append("    companyAccount: ").append(toIndentedString(companyAccount)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
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
