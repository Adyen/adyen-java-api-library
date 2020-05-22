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

import com.adyen.constants.TextConstants;
import com.adyen.model.checkout.PaymentMethodDetails;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * DotpayDetails
 */

public class DotpayDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String DOTPAY = "dotpay";

    @SerializedName("issuer")
    private String issuer = null;

    @SerializedName("type")
    private String type = DOTPAY;

    public DotpayDetails issuer(String issuer) {
        this.issuer = issuer;
        return this;
    }

    /**
     * The Dotpay issuer value of the shopper&#x27;s selected bank. Set this to an **id** of a Dotpay issuer to preselect it.
     *
     * @return issuer
     **/
    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public DotpayDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **dotpay**
     *
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        DotpayDetails dotpayDetails = (DotpayDetails) o;
        return Objects.equals(this.issuer, dotpayDetails.issuer) &&
                Objects.equals(this.type, dotpayDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuer, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DotpayDetails {").append(TextConstants.LINE_BREAK);

        sb.append("    issuer: ").append(toIndentedString(issuer)).append(TextConstants.LINE_BREAK);
        sb.append("    type: ").append(toIndentedString(type)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}
