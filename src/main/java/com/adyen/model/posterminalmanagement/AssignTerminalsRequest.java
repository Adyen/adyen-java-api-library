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
 * AssignTerminalsRequest
 */

public class AssignTerminalsRequest {
    @SerializedName("companyAccount")
    private String companyAccount = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("merchantInventory")
    private Boolean merchantInventory = null;

    @SerializedName("store")
    private String store = null;

    @SerializedName("terminals")
    private List<String> terminals = new ArrayList<String>();

    public AssignTerminalsRequest companyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
        return this;
    }

    /**
     * Your company account. To return terminals to the company inventory, specify only this parameter and the &#x60;terminals&#x60;.
     *
     * @return companyAccount
     **/
    public String getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
    }

    public AssignTerminalsRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * Name of the merchant account. Specify this parameter to assign terminals to this merchant account or to a store under this merchant account.
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public AssignTerminalsRequest merchantInventory(Boolean merchantInventory) {
        this.merchantInventory = merchantInventory;
        return this;
    }

    /**
     * Boolean that indicates if you are assigning the terminals to the merchant inventory. Do not use when assigning terminals to a store. Required when assigning the terminal to a merchant account.  - Set this to **true** to assign the terminals to the merchant inventory. This also means that the terminals cannot be boarded.  - Set this to **false** to assign the terminals to the merchant account as in-store terminals. This makes the terminals ready to be boarded and to process payments through the specified merchant account.
     *
     * @return merchantInventory
     **/
    public Boolean isMerchantInventory() {
        return merchantInventory;
    }

    public void setMerchantInventory(Boolean merchantInventory) {
        this.merchantInventory = merchantInventory;
    }

    public AssignTerminalsRequest store(String store) {
        this.store = store;
        return this;
    }

    /**
     * The store code of the store that you want to assign the terminals to.
     *
     * @return store
     **/
    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public AssignTerminalsRequest terminals(List<String> terminals) {
        this.terminals = terminals;
        return this;
    }

    public AssignTerminalsRequest addTerminalsItem(String terminalsItem) {
        this.terminals.add(terminalsItem);
        return this;
    }

    /**
     * Array containing a list of terminal IDs that you want to assign or reassign to the merchant account or store, or that you want to return to the company inventory.  For example, &#x60;[\&quot;V400m-324689776\&quot;,\&quot;P400Plus-329127412\&quot;]&#x60;.
     *
     * @return terminals
     **/
    public List<String> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<String> terminals) {
        this.terminals = terminals;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AssignTerminalsRequest assignTerminalsRequest = (AssignTerminalsRequest) o;
        return Objects.equals(this.companyAccount, assignTerminalsRequest.companyAccount) &&
                Objects.equals(this.merchantAccount, assignTerminalsRequest.merchantAccount) &&
                Objects.equals(this.merchantInventory, assignTerminalsRequest.merchantInventory) &&
                Objects.equals(this.store, assignTerminalsRequest.store) &&
                Objects.equals(this.terminals, assignTerminalsRequest.terminals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyAccount, merchantAccount, merchantInventory, store, terminals);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssignTerminalsRequest {\n");

        sb.append("    companyAccount: ").append(toIndentedString(companyAccount)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    merchantInventory: ").append(toIndentedString(merchantInventory)).append("\n");
        sb.append("    store: ").append(toIndentedString(store)).append("\n");
        sb.append("    terminals: ").append(toIndentedString(terminals)).append("\n");
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
