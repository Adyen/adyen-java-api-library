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
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * GenericIssuerPaymentMethodDetails
 */

public class GenericIssuerPaymentMethodDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String ONLINEBANKING_IN = "onlinebanking_IN";
    public static final String WALLET_IN = "wallet_IN";

    @SerializedName("issuer")
    private String issuer = null;

    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

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

    public GenericIssuerPaymentMethodDetails recurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
        return this;
    }

    /**
     * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the token.
     * @return recurringDetailReference
     **/
    @Schema(description = "This is the `recurringDetailReference` returned in the response when you created the token.")
    public String getRecurringDetailReference() {
        return recurringDetailReference;
    }

    public void setRecurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
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
                Objects.equals(this.recurringDetailReference, genericIssuerPaymentMethodDetails.recurringDetailReference) &&
                Objects.equals(this.storedPaymentMethodId, genericIssuerPaymentMethodDetails.storedPaymentMethodId) &&
                Objects.equals(this.type, genericIssuerPaymentMethodDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuer, recurringDetailReference, storedPaymentMethodId, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GenericIssuerPaymentMethodDetails {\n");

        sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
        sb.append("    recurringDetailReference: ").append(toIndentedString(recurringDetailReference)).append("\n");
        sb.append("    storedPaymentMethodId: ").append(toIndentedString(storedPaymentMethodId)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}
