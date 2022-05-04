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
 * Copyright (c) 2022 Adyen N.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.checkout.details;

import java.util.Objects;
import com.adyen.model.checkout.PaymentMethodDetails;
import com.google.gson.annotations.SerializedName;

/**
 * UpiIntentDetails
 */
public class UpiIntentDetails implements PaymentMethodDetails {

    public static final String UPI_INTENT = "upi_intent";

    @SerializedName("type")
    private String type = UPI_INTENT;

    /**
     * **upi**
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UpiIntentDetails type(String type) {
        this.type = type;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpiIntentDetails upiIntentDetails = (UpiIntentDetails) o;
        return Objects.equals(this.type, upiIntentDetails.type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpiIntentDetails {\n");
        sb.append("    type: ").append(type).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
