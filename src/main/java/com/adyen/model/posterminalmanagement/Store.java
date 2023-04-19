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
 * Store
 */

public class Store {
    @SerializedName("address")
    private Address address = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("inStoreTerminals")
    private List<String> inStoreTerminals = null;

    @SerializedName("merchantAccountCode")
    private String merchantAccountCode = null;

    @SerializedName("status")
    private String status = null;

    @SerializedName("store")
    private String store = null;

    public Store address(Address address) {
        this.address = address;
        return this;
    }

    /**
     * Get address
     *
     * @return address
     **/
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Store description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The store description
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Store inStoreTerminals(List<String> inStoreTerminals) {
        this.inStoreTerminals = inStoreTerminals;
        return this;
    }

    public Store addInStoreTerminalsItem(String inStoreTerminalsItem) {
        if (this.inStoreTerminals == null) {
            this.inStoreTerminals = new ArrayList<String>();
        }
        this.inStoreTerminals.add(inStoreTerminalsItem);
        return this;
    }

    /**
     * List of unique terminal IDs assigned to this store
     *
     * @return inStoreTerminals
     **/
    public List<String> getInStoreTerminals() {
        return inStoreTerminals;
    }

    public void setInStoreTerminals(List<String> inStoreTerminals) {
        this.inStoreTerminals = inStoreTerminals;
    }

    public Store merchantAccountCode(String merchantAccountCode) {
        this.merchantAccountCode = merchantAccountCode;
        return this;
    }

    /**
     * Merchant account code
     *
     * @return merchantAccountCode
     **/
    public String getMerchantAccountCode() {
        return merchantAccountCode;
    }

    public void setMerchantAccountCode(String merchantAccountCode) {
        this.merchantAccountCode = merchantAccountCode;
    }

    public Store status(String status) {
        this.status = status;
        return this;
    }

    /**
     * Store status. Possible values:   - &#x60;PreActive&#x60;: The store has been created, but not yet activated.   - &#x60;Active&#x60;: The store has been activated. This means you can process payments over the store.   - &#x60;Inactive&#x60;: The store is currently not active.   - &#x60;InactiveWithModifications&#x60;: The store is currently not active, but payment modifications such as refunds are still allowed.   - &#x60;Closed&#x60;: The store has been closed.
     *
     * @return status
     **/
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Store store(String store) {
        this.store = store;
        return this;
    }

    /**
     * The store code of the store.
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
        Store store = (Store) o;
        return Objects.equals(this.address, store.address) &&
                Objects.equals(this.description, store.description) &&
                Objects.equals(this.inStoreTerminals, store.inStoreTerminals) &&
                Objects.equals(this.merchantAccountCode, store.merchantAccountCode) &&
                Objects.equals(this.status, store.status) &&
                Objects.equals(this.store, store.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, description, inStoreTerminals, merchantAccountCode, status, store);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Store {\n");

        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    inStoreTerminals: ").append(toIndentedString(inStoreTerminals)).append("\n");
        sb.append("    merchantAccountCode: ").append(toIndentedString(merchantAccountCode)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
