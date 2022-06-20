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
 * KlarnaDetails
 */

public class KlarnaDetails implements PaymentMethodDetails {

    /**
     * Possible types
     */
    public static final String KLARNA = "klarna";
    public static final String KLARNA_PAYMENTS = "klarnapayments";
    public static final String KLARNA_PAYMENTS_ACCOUNT = "klarnapayments_account";
    public static final String KLARNA_PAYMENTS_B2B = "klarnapayments_b2b";
    public static final String KLARNA_PAY_NOW = "klarna_paynow";
    public static final String KLARNA_ACCOUNT = "klarna_account";
    public static final String KLARNA_B2B = "klarna_b2b";

    @SerializedName("billingAddress")
    private String billingAddress = null;

    @SerializedName("deliveryAddress")
    private String deliveryAddress = null;

    @SerializedName("personalDetails")
    private String personalDetails = null;

    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId = null;

    @SerializedName("type")
    private String type = null;

    public KlarnaDetails billingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    /**
     * Get billingAddress
     *
     * @return billingAddress
     **/
    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public KlarnaDetails deliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    /**
     * Get deliveryAddress
     *
     * @return deliveryAddress
     **/
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public KlarnaDetails personalDetails(String personalDetails) {
        this.personalDetails = personalDetails;
        return this;
    }

    /**
     * Get personalDetails
     *
     * @return personalDetails
     **/
    public String getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(String personalDetails) {
        this.personalDetails = personalDetails;
    }

    public KlarnaDetails recurringDetailReference(String recurringDetailReference) {
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

    public KlarnaDetails storedPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
        return this;
    }

    /**
     * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the token.
     *
     * @return storedPaymentMethodId
     **/
    public String getStoredPaymentMethodId() {
        return storedPaymentMethodId;
    }

    public void setStoredPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
    }

    public KlarnaDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The payment method type.
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
        KlarnaDetails klarnaDetails = (KlarnaDetails) o;
        return Objects.equals(this.billingAddress, klarnaDetails.billingAddress) &&
                Objects.equals(this.deliveryAddress, klarnaDetails.deliveryAddress) &&
                Objects.equals(this.personalDetails, klarnaDetails.personalDetails) &&
                Objects.equals(this.recurringDetailReference, klarnaDetails.recurringDetailReference) &&
                Objects.equals(this.storedPaymentMethodId, klarnaDetails.storedPaymentMethodId) &&
                Objects.equals(this.type, klarnaDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingAddress, deliveryAddress, personalDetails, recurringDetailReference, storedPaymentMethodId, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KlarnaDetails {\n");

        sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
        sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
        sb.append("    personalDetails: ").append(toIndentedString(personalDetails)).append("\n");
        sb.append("    recurringDetailReference: ").append(toIndentedString(recurringDetailReference)).append("\n");
        sb.append("    storedPaymentMethodId: ").append(toIndentedString(storedPaymentMethodId)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
