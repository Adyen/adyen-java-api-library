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

import static com.adyen.constants.TextConstants.LINE_BREAK;
import static com.adyen.util.Util.toIndentedString;

/**
 * GenericIssuerPaymentMethodDetails
 */

public class GenericIssuerPaymentMethodDetails implements PaymentMethodDetails {
    @SerializedName("issuer")
    private String issuer = null;

    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId = null;

    @SerializedName("type")
    private String type = null;

    public GenericIssuerPaymentMethodDetails issuer(String issuer) {
        this.issuer = issuer;
        return this;
    }

    /**
     * The issuer id of the shopper&#x27;s selected bank.
     *
     * @return issuer
     **/
    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public GenericIssuerPaymentMethodDetails storedPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
        return this;
    }

    /**
     * This is the recurringDetailReference returned in the response when you created the token.
     *
     * @return storedPaymentMethodId
     **/
    public String getStoredPaymentMethodId() {
        return storedPaymentMethodId;
    }

    public void setStoredPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
    }

    public GenericIssuerPaymentMethodDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **genericissuer**
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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GenericIssuerPaymentMethodDetails genericIssuerPaymentMethodDetails = (GenericIssuerPaymentMethodDetails) o;
        return Objects.equals(this.issuer, genericIssuerPaymentMethodDetails.issuer) &&
                Objects.equals(this.storedPaymentMethodId, genericIssuerPaymentMethodDetails.storedPaymentMethodId) &&
                Objects.equals(this.type, genericIssuerPaymentMethodDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuer, storedPaymentMethodId, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GenericIssuerPaymentMethodDetails {").append(LINE_BREAK);

        sb.append("    issuer: ").append(toIndentedString(issuer)).append(LINE_BREAK);
        sb.append("    storedPaymentMethodId: ").append(toIndentedString(storedPaymentMethodId)).append(LINE_BREAK);
        sb.append("    type: ").append(toIndentedString(type)).append(LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }



}
