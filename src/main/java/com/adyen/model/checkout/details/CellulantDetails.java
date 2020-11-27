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

import com.adyen.model.checkout.PaymentMethodDetails;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * CellulantDetails
 */

public class CellulantDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String CELLULANT = "cellulant";

    @SerializedName("issuerId")
    private String issuerId = null;

    @SerializedName("type")
    private String type = CELLULANT;

    public CellulantDetails issuerId(String issuerId) {
        this.issuerId = issuerId;
        return this;
    }

    /**
     * The issuer&#x27;s ID
     *
     * @return issuerId
     **/
    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public CellulantDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **Cellulant**
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CellulantDetails cellulantDetails = (CellulantDetails) o;
        return Objects.equals(this.issuerId, cellulantDetails.issuerId) &&
                Objects.equals(this.type, cellulantDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuerId, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CellulantDetails {\n");

        sb.append("    issuerId: ").append(toIndentedString(issuerId)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
