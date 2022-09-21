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
 * Copyright (c) 2022 Adyen B.V.
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
 * AfterpayDetails
 */

public class AfterpayDetails implements PaymentMethodDetails  {
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


    public static final String AFTERPAY_DEFAULT = "afterpay_default";
    public static final String AFTERPAYTOUCH = "afterpaytouch";
    public static final String AFTERPAY_B2B = "afterpay_b2b";
    @SerializedName("type")
    private String type = null;

    public AfterpayDetails billingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    /**
     * The address where to send the invoice.
     * @return billingAddress
     **/
    @Schema(description = "The address where to send the invoice.")
    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public AfterpayDetails deliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    /**
     * The address where the goods should be delivered.
     * @return deliveryAddress
     **/
    @Schema(description = "The address where the goods should be delivered.")
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public AfterpayDetails personalDetails(String personalDetails) {
        this.personalDetails = personalDetails;
        return this;
    }

    /**
     * Shopper name, date of birth, phone number, and email address.
     * @return personalDetails
     **/
    @Schema(description = "Shopper name, date of birth, phone number, and email address.")
    public String getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(String personalDetails) {
        this.personalDetails = personalDetails;
    }

    public AfterpayDetails recurringDetailReference(String recurringDetailReference) {
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

    public AfterpayDetails storedPaymentMethodId(String storedPaymentMethodId) {
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

    public AfterpayDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **afterpay_default**
     * @return type
     **/
    @Schema(required = true, description = "**afterpay_default**")
    public String getType() {
        return type;
    }

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
        AfterpayDetails afterpayDetails = (AfterpayDetails) o;
        return Objects.equals(this.billingAddress, afterpayDetails.billingAddress) &&
                Objects.equals(this.deliveryAddress, afterpayDetails.deliveryAddress) &&
                Objects.equals(this.personalDetails, afterpayDetails.personalDetails) &&
                Objects.equals(this.recurringDetailReference, afterpayDetails.recurringDetailReference) &&
                Objects.equals(this.storedPaymentMethodId, afterpayDetails.storedPaymentMethodId) &&
                Objects.equals(this.type, afterpayDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingAddress, deliveryAddress, personalDetails, recurringDetailReference, storedPaymentMethodId, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AfterpayDetails {\n");

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
