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
 * PayUUpiDetails
 */

public class PayUUpiDetails implements PaymentMethodDetails {
    private static final String PAYUINUPI = "payu_IN_upi";
    @SerializedName("type")
    private String type = PAYUINUPI;

    @SerializedName("vpa")
    private String vpa = null;

    public PayUUpiDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **payu_IN_upi**
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PayUUpiDetails vpa(String vpa) {
        this.vpa = vpa;
        return this;
    }

    /**
     * The VPA (Virtual Payment Address) for UPI.
     *
     * @return vpa
     **/
    public String getVpa() {
        return vpa;
    }

    public void setVpa(String vpa) {
        this.vpa = vpa;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PayUUpiDetails payUUpiDetails = (PayUUpiDetails) o;
        return Objects.equals(this.type, payUUpiDetails.type) &&
                Objects.equals(this.vpa, payUUpiDetails.vpa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, vpa);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PayUUpiDetails {\n");

        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    vpa: ").append(toIndentedString(vpa)).append("\n");
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
