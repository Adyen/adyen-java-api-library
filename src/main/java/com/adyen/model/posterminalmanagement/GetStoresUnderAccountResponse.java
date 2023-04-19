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

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * GetStoresUnderAccountResponse
 */

public class GetStoresUnderAccountResponse {
    @SerializedName("stores")
    private List<Store> stores = null;

    public GetStoresUnderAccountResponse stores(List<Store> stores) {
        this.stores = stores;
        return this;
    }

    public GetStoresUnderAccountResponse addStoresItem(Store storesItem) {
        if (this.stores == null) {
            this.stores = new ArrayList<Store>();
        }
        this.stores.add(storesItem);
        return this;
    }

    /**
     * Array that returns a list of all stores for the specified merchant account, or for all merchant accounts under the company account.
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
        GetStoresUnderAccountResponse getStoresUnderAccountResponse = (GetStoresUnderAccountResponse) o;
        return Objects.equals(this.stores, getStoresUnderAccountResponse.stores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stores);
    }


    @Override
    public String toString() {

        String sb = "class GetStoresUnderAccountResponse {\n" +
                "    stores: " + toIndentedString(stores) + "\n" +
                "}";
        return sb;
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
