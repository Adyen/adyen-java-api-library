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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.management;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * AllowedOriginsResponse
 */

public class AllowedOriginsResponse {
    @SerializedName("data")
    private List<AllowedOrigin> data = null;

    public AllowedOriginsResponse data(List<AllowedOrigin> data) {
        this.data = data;
        return this;
    }

    public AllowedOriginsResponse addDataItem(AllowedOrigin dataItem) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(dataItem);
        return this;
    }

    /**
     * The list of allowed origins.
     *
     * @return data
     **/
    public List<AllowedOrigin> getData() {
        return data;
    }

    public void setData(List<AllowedOrigin> data) {
        this.data = data;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AllowedOriginsResponse allowedOriginsResponse = (AllowedOriginsResponse) o;
        return Objects.equals(this.data, allowedOriginsResponse.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AllowedOriginsResponse {\n");

        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
