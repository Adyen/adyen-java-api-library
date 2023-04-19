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

import java.util.ArrayList;
import java.util.List;

/**
 * GetTerminalsUnderAccountResponse
 */

public class GetTerminalsUnderAccountResponse {
    @SerializedName("companyAccount")
    private String companyAccount = null;

    @SerializedName("inventoryTerminals")
    private List<String> inventoryTerminals = null;

    @SerializedName("merchantAccounts")
    private List<MerchantAccount> merchantAccounts = null;

    public GetTerminalsUnderAccountResponse companyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
        return this;
    }

    /**
     * Your company account.
     *
     * @return companyAccount
     **/
    public String getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
    }

    public GetTerminalsUnderAccountResponse inventoryTerminals(List<String> inventoryTerminals) {
        this.inventoryTerminals = inventoryTerminals;
        return this;
    }

    public GetTerminalsUnderAccountResponse addInventoryTerminalsItem(String inventoryTerminalsItem) {
        if (this.inventoryTerminals == null) {
            this.inventoryTerminals = new ArrayList<String>();
        }
        this.inventoryTerminals.add(inventoryTerminalsItem);
        return this;
    }

    /**
     * Array that returns a list of all terminals that are in the inventory of the company account.
     *
     * @return inventoryTerminals
     **/
    public List<String> getInventoryTerminals() {
        return inventoryTerminals;
    }

    public void setInventoryTerminals(List<String> inventoryTerminals) {
        this.inventoryTerminals = inventoryTerminals;
    }

    public GetTerminalsUnderAccountResponse merchantAccounts(List<MerchantAccount> merchantAccounts) {
        this.merchantAccounts = merchantAccounts;
        return this;
    }

    public GetTerminalsUnderAccountResponse addMerchantAccountsItem(MerchantAccount merchantAccountsItem) {
        if (this.merchantAccounts == null) {
            this.merchantAccounts = new ArrayList<MerchantAccount>();
        }
        this.merchantAccounts.add(merchantAccountsItem);
        return this;
    }

    /**
     * Array that returns a list of all merchant accounts belonging to the company account.
     *
     * @return merchantAccounts
     **/
    public List<MerchantAccount> getMerchantAccounts() {
        return merchantAccounts;
    }

    public void setMerchantAccounts(List<MerchantAccount> merchantAccounts) {
        this.merchantAccounts = merchantAccounts;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetTerminalsUnderAccountResponse getTerminalsUnderAccountResponse = (GetTerminalsUnderAccountResponse) o;
        return Objects.equals(this.companyAccount, getTerminalsUnderAccountResponse.companyAccount) &&
                Objects.equals(this.inventoryTerminals, getTerminalsUnderAccountResponse.inventoryTerminals) &&
                Objects.equals(this.merchantAccounts, getTerminalsUnderAccountResponse.merchantAccounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyAccount, inventoryTerminals, merchantAccounts);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetTerminalsUnderAccountResponse {\n");

        sb.append("    companyAccount: ").append(toIndentedString(companyAccount)).append("\n");
        sb.append("    inventoryTerminals: ").append(toIndentedString(inventoryTerminals)).append("\n");
        sb.append("    merchantAccounts: ").append(toIndentedString(merchantAccounts)).append("\n");
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
