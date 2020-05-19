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

package com.adyen.model.checkout.details;

import java.util.Objects;

import com.adyen.model.checkout.PaymentMethodDetails;
import com.google.gson.annotations.SerializedName;
/**
 * BlikDetails
 */

public class BlikDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String BLIK = "blik";

    @SerializedName("blikCode")
    private String blikCode = null;

    @SerializedName("type")
    private String type = BLIK;

    public BlikDetails blikCode(String blikCode) {
        this.blikCode = blikCode;
        return this;
    }

    /**
     * BLIK code consisting of 6 digits.
     * @return blikCode
     **/
    public String getBlikCode() {
        return blikCode;
    }

    public void setBlikCode(String blikCode) {
        this.blikCode = blikCode;
    }

    public BlikDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **blik**
     * @return type
     **/
    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BlikDetails blikDetails = (BlikDetails) o;
        return Objects.equals(this.blikCode, blikDetails.blikCode) &&
                Objects.equals(this.type, blikDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blikCode, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BlikDetails {\n");

        sb.append("    blikCode: ").append(toIndentedString(blikCode)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
