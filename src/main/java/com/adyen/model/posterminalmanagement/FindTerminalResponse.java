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
 * FindTerminalResponse
 */

public class FindTerminalResponse {
    @SerializedName("companyAccount")
    private String companyAccount = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("merchantInventory")
    private Boolean merchantInventory = null;

    @SerializedName("store")
    private String store = null;

    @SerializedName("terminal")
    private String terminal = null;

    public FindTerminalResponse companyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
        return this;
    }

    /**
     * The company account that the terminal is associated with. If this is the only account level shown in the response, the terminal is assigned to the inventory of the company account.
     *
     * @return companyAccount
     **/
    public String getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
    }

    public FindTerminalResponse merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * The merchant account that the terminal is associated with. If the response doesn&#x27;t contain a &#x60;store&#x60; the terminal is assigned to this merchant account.
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public FindTerminalResponse merchantInventory(Boolean merchantInventory) {
        this.merchantInventory = merchantInventory;
        return this;
    }

    /**
     * Boolean that indicates if the terminal is assigned to the merchant inventory. This is returned when the terminal is assigned to a merchant account.  - If **true**, this indicates that the terminal is in the merchant inventory. This also means that the terminal cannot be boarded.  - If **false**, this indicates that the terminal is assigned to the merchant account as an in-store terminal. This means that the terminal is ready to be boarded, or is already boarded.
     *
     * @return merchantInventory
     **/
    public Boolean isMerchantInventory() {
        return merchantInventory;
    }

    public void setMerchantInventory(Boolean merchantInventory) {
        this.merchantInventory = merchantInventory;
    }

    public FindTerminalResponse store(String store) {
        this.store = store;
        return this;
    }

    /**
     * The store code of the store that the terminal is assigned to.
     *
     * @return store
     **/
    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public FindTerminalResponse terminal(String terminal) {
        this.terminal = terminal;
        return this;
    }

    /**
     * The unique terminal ID.
     *
     * @return terminal
     **/
    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FindTerminalResponse findTerminalResponse = (FindTerminalResponse) o;
        return Objects.equals(this.companyAccount, findTerminalResponse.companyAccount) &&
                Objects.equals(this.merchantAccount, findTerminalResponse.merchantAccount) &&
                Objects.equals(this.merchantInventory, findTerminalResponse.merchantInventory) &&
                Objects.equals(this.store, findTerminalResponse.store) &&
                Objects.equals(this.terminal, findTerminalResponse.terminal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyAccount, merchantAccount, merchantInventory, store, terminal);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FindTerminalResponse {\n");

        sb.append("    companyAccount: ").append(toIndentedString(companyAccount)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    merchantInventory: ").append(toIndentedString(merchantInventory)).append("\n");
        sb.append("    store: ").append(toIndentedString(store)).append("\n");
        sb.append("    terminal: ").append(toIndentedString(terminal)).append("\n");
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
