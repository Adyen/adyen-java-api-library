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
 * Copyright (c) 2022 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.marketpay;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static com.adyen.util.Util.toIndentedString;
/**
 * CloseStoresRequest
 */
public class CloseStoresRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("stores")
    private List<String> stores = new ArrayList<String>();

    public CloseStoresRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * The code of the account holder.
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public CloseStoresRequest stores(List<String> stores) {
        this.stores = stores;
        return this;
    }

    public CloseStoresRequest addStoresItem(String storesItem) {
        this.stores.add(storesItem);
        return this;
    }

    /**
     * List of stores to be closed.
     * @return stores
     **/
    public List<String> getStores() {
        return stores;
    }

    public void setStores(List<String> stores) {
        this.stores = stores;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CloseStoresRequest closeStoresRequest = (CloseStoresRequest) o;
        return Objects.equals(this.accountHolderCode, closeStoresRequest.accountHolderCode) &&
                Objects.equals(this.stores, closeStoresRequest.stores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, stores);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CloseStoresRequest {\n");

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    stores: ").append(toIndentedString(stores)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}