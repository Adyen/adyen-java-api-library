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
 * MerchantAccount
 */

public class MerchantAccount {
    @SerializedName("inStoreTerminals")
    private List<String> inStoreTerminals = null;

    @SerializedName("inventoryTerminals")
    private List<String> inventoryTerminals = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("stores")
    private List<Store> stores = null;

    public MerchantAccount inStoreTerminals(List<String> inStoreTerminals) {
        this.inStoreTerminals = inStoreTerminals;
        return this;
    }

    public MerchantAccount addInStoreTerminalsItem(String inStoreTerminalsItem) {
        if (this.inStoreTerminals == null) {
            this.inStoreTerminals = new ArrayList<String>();
        }
        this.inStoreTerminals.add(inStoreTerminalsItem);
        return this;
    }

    /**
     * List of terminals assigned to this merchant account as in-store terminals. This means that the terminal is ready to be boarded, or is already boarded.
     *
     * @return inStoreTerminals
     **/
    public List<String> getInStoreTerminals() {
        return inStoreTerminals;
    }

    public void setInStoreTerminals(List<String> inStoreTerminals) {
        this.inStoreTerminals = inStoreTerminals;
    }

    public MerchantAccount inventoryTerminals(List<String> inventoryTerminals) {
        this.inventoryTerminals = inventoryTerminals;
        return this;
    }

    public MerchantAccount addInventoryTerminalsItem(String inventoryTerminalsItem) {
        if (this.inventoryTerminals == null) {
            this.inventoryTerminals = new ArrayList<String>();
        }
        this.inventoryTerminals.add(inventoryTerminalsItem);
        return this;
    }

    /**
     * List of terminals assigned to the inventory of this merchant account.
     *
     * @return inventoryTerminals
     **/
    public List<String> getInventoryTerminals() {
        return inventoryTerminals;
    }

    public void setInventoryTerminals(List<String> inventoryTerminals) {
        this.inventoryTerminals = inventoryTerminals;
    }

    public MerchantAccount merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * The merchant account.
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public MerchantAccount stores(List<Store> stores) {
        this.stores = stores;
        return this;
    }

    public MerchantAccount addStoresItem(Store storesItem) {
        if (this.stores == null) {
            this.stores = new ArrayList<Store>();
        }
        this.stores.add(storesItem);
        return this;
    }

    /**
     * Array of stores under this merchant account.
     *
     * @return stores
     **/
    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MerchantAccount merchantAccount = (MerchantAccount) o;
        return Objects.equals(this.inStoreTerminals, merchantAccount.inStoreTerminals) &&
                Objects.equals(this.inventoryTerminals, merchantAccount.inventoryTerminals) &&
                Objects.equals(this.merchantAccount, merchantAccount.merchantAccount) &&
                Objects.equals(this.stores, merchantAccount.stores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inStoreTerminals, inventoryTerminals, merchantAccount, stores);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MerchantAccount {\n");

        sb.append("    inStoreTerminals: ").append(toIndentedString(inStoreTerminals)).append("\n");
        sb.append("    inventoryTerminals: ").append(toIndentedString(inventoryTerminals)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    stores: ").append(toIndentedString(stores)).append("\n");
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
