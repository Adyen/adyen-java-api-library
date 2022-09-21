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
 * BlikDetails
 */

public class BlikDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String BLIK = "blik";

    @SerializedName("blikCode")
    private String blikCode = null;

    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId = null;

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

    public BlikDetails recurringDetailReference(String recurringDetailReference) {
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

    public BlikDetails storedPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
        return this;
    }

    /**
     * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the token.
     * @return storedPaymentMethodId
     **/
    @Schema(description = "This is the `recurringDetailReference` returned in the response when you created the token.")
    public String getStoredPaymentMethodId() {
        return storedPaymentMethodId;
    }

    public void setStoredPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
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
                Objects.equals(this.recurringDetailReference, blikDetails.recurringDetailReference) &&
                Objects.equals(this.storedPaymentMethodId, blikDetails.storedPaymentMethodId) &&
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
        sb.append("    recurringDetailReference: ").append(toIndentedString(recurringDetailReference)).append("\n");
        sb.append("    storedPaymentMethodId: ").append(toIndentedString(storedPaymentMethodId)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}
