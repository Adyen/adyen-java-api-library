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
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * PayUUpiDetails
 */

public class PayUUpiDetails implements PaymentMethodDetails {
    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

    @SerializedName("shopperNotificationReference")
    private String shopperNotificationReference = null;

    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId = null;

    /**
     * **payu_IN_upi**
     */
    public static final String PAYUINUPI = "payu_IN_upi";

    @SerializedName("type")
    private String type = PAYUINUPI;

    @SerializedName("virtualPaymentAddress")
    private String virtualPaymentAddress = null;

    public PayUUpiDetails recurringDetailReference(String recurringDetailReference) {
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

    public PayUUpiDetails shopperNotificationReference(String shopperNotificationReference) {
        this.shopperNotificationReference = shopperNotificationReference;
        return this;
    }

    /**
     * The &#x60;shopperNotificationReference&#x60; returned in the response when you requested to notify the shopper. Used for recurring payment only.
     * @return shopperNotificationReference
     **/
    @Schema(description = "The `shopperNotificationReference` returned in the response when you requested to notify the shopper. Used for recurring payment only.")
    public String getShopperNotificationReference() {
        return shopperNotificationReference;
    }

    public void setShopperNotificationReference(String shopperNotificationReference) {
        this.shopperNotificationReference = shopperNotificationReference;
    }

    public PayUUpiDetails storedPaymentMethodId(String storedPaymentMethodId) {
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

    public PayUUpiDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **payu_IN_upi**
     * @return type
     **/
    @Schema(required = true, description = "**payu_IN_upi**")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PayUUpiDetails virtualPaymentAddress(String virtualPaymentAddress) {
        this.virtualPaymentAddress = virtualPaymentAddress;
        return this;
    }

    /**
     * The virtual payment address for UPI.
     * @return virtualPaymentAddress
     **/
    @Schema(description = "The virtual payment address for UPI.")
    public String getVirtualPaymentAddress() {
        return virtualPaymentAddress;
    }

    public void setVirtualPaymentAddress(String virtualPaymentAddress) {
        this.virtualPaymentAddress = virtualPaymentAddress;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PayUUpiDetails payUUpiDetails = (PayUUpiDetails) o;
        return Objects.equals(this.recurringDetailReference, payUUpiDetails.recurringDetailReference) &&
                Objects.equals(this.shopperNotificationReference, payUUpiDetails.shopperNotificationReference) &&
                Objects.equals(this.storedPaymentMethodId, payUUpiDetails.storedPaymentMethodId) &&
                Objects.equals(this.type, payUUpiDetails.type) &&
                Objects.equals(this.virtualPaymentAddress, payUUpiDetails.virtualPaymentAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recurringDetailReference, shopperNotificationReference, storedPaymentMethodId, type, virtualPaymentAddress);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PayUUpiDetails {\n");

        sb.append("    recurringDetailReference: ").append(toIndentedString(recurringDetailReference)).append("\n");
        sb.append("    shopperNotificationReference: ").append(toIndentedString(shopperNotificationReference)).append("\n");
        sb.append("    storedPaymentMethodId: ").append(toIndentedString(storedPaymentMethodId)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    virtualPaymentAddress: ").append(toIndentedString(virtualPaymentAddress)).append("\n");
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
