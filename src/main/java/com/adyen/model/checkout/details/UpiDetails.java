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
import com.adyen.model.checkout.SubscriptionDetails;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * UpiDetails
 */

public class UpiDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String UPI = "upi";

    @SerializedName("shopperNotificationReference")
    private String shopperNotificationReference = null;

    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId = null;

    @SerializedName("subscriptionDetails")
    private SubscriptionDetails subscriptionDetails = null;

    @SerializedName("type")
    private String type = UPI;

    @SerializedName("virtualPaymentAddress")
    private String virtualPaymentAddress = null;

    public UpiDetails shopperNotificationReference(String shopperNotificationReference) {
        this.shopperNotificationReference = shopperNotificationReference;
        return this;
    }

    /**
     * The &#x60;shopperNotificationReference&#x60; returned in the response when you requested to notify the shopper. Used for recurring payment only.
     *
     * @return shopperNotificationReference
     **/
    public String getShopperNotificationReference() {
        return shopperNotificationReference;
    }

    public void setShopperNotificationReference(String shopperNotificationReference) {
        this.shopperNotificationReference = shopperNotificationReference;
    }

    public UpiDetails storedPaymentMethodId(String storedPaymentMethodId) {
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

    public UpiDetails subscriptionDetails(SubscriptionDetails subscriptionDetails) {
        this.subscriptionDetails = subscriptionDetails;
        return this;
    }

    /**
     * Get subscriptionDetails
     *
     * @return subscriptionDetails
     **/
    public SubscriptionDetails getSubscriptionDetails() {
        return subscriptionDetails;
    }

    public void setSubscriptionDetails(SubscriptionDetails subscriptionDetails) {
        this.subscriptionDetails = subscriptionDetails;
    }

    public UpiDetails type(String type) {
        this.type = type;
        return this;
    }

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

    public UpiDetails virtualPaymentAddress(String virtualPaymentAddress) {
        this.virtualPaymentAddress = virtualPaymentAddress;
        return this;
    }

    /**
     * The virtual payment address for UPI.
     *
     * @return virtualPaymentAddress
     **/
    public String getVirtualPaymentAddress() {
        return virtualPaymentAddress;
    }

    public void setVirtualPaymentAddress(String virtualPaymentAddress) {
        this.virtualPaymentAddress = virtualPaymentAddress;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpiDetails upiDetails = (UpiDetails) o;
        return Objects.equals(this.shopperNotificationReference, upiDetails.shopperNotificationReference) &&
                Objects.equals(this.storedPaymentMethodId, upiDetails.storedPaymentMethodId) &&
                Objects.equals(this.subscriptionDetails, upiDetails.subscriptionDetails) &&
                Objects.equals(this.type, upiDetails.type) &&
                Objects.equals(this.virtualPaymentAddress, upiDetails.virtualPaymentAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopperNotificationReference, storedPaymentMethodId, subscriptionDetails, type, virtualPaymentAddress);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpiDetails {\n");

        sb.append("    shopperNotificationReference: ").append(toIndentedString(shopperNotificationReference)).append("\n");
        sb.append("    storedPaymentMethodId: ").append(toIndentedString(storedPaymentMethodId)).append("\n");
        sb.append("    subscriptionDetails: ").append(toIndentedString(subscriptionDetails)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    virtualPaymentAddress: ").append(toIndentedString(virtualPaymentAddress)).append("\n");
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
