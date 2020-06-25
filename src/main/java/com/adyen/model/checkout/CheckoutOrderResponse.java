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
package com.adyen.model.checkout;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;
import com.adyen.model.Amount;

/**
 * CheckoutOrderResponse
 */

public class CheckoutOrderResponse {
    @SerializedName("expiresAt")
    private String expiresAt = null;

    @SerializedName("orderData")
    private String orderData = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("reference")
    private String reference = null;

    @SerializedName("remainingAmount")
    private Amount remainingAmount = null;

    public CheckoutOrderResponse expiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

    /**
     * The expiry date for the order.
     *
     * @return expiresAt
     **/
    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public CheckoutOrderResponse orderData(String orderData) {
        this.orderData = orderData;
        return this;
    }

    /**
     * The encrypted order data.
     *
     * @return orderData
     **/
    public String getOrderData() {
        return orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }

    public CheckoutOrderResponse pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * The &#x60;pspReference&#x60; that belongs to the order.
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public CheckoutOrderResponse reference(String reference) {
        this.reference = reference;
        return this;
    }

    /**
     * The merchant reference for the order.
     *
     * @return reference
     **/
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public CheckoutOrderResponse remainingAmount(Amount remainingAmount) {
        this.remainingAmount = remainingAmount;
        return this;
    }

    /**
     * Get remainingAmount
     *
     * @return remainingAmount
     **/
    public Amount getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Amount remainingAmount) {
        this.remainingAmount = remainingAmount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CheckoutOrderResponse checkoutOrderResponse = (CheckoutOrderResponse) o;
        return Objects.equals(this.expiresAt, checkoutOrderResponse.expiresAt) &&
                Objects.equals(this.orderData, checkoutOrderResponse.orderData) &&
                Objects.equals(this.pspReference, checkoutOrderResponse.pspReference) &&
                Objects.equals(this.reference, checkoutOrderResponse.reference) &&
                Objects.equals(this.remainingAmount, checkoutOrderResponse.remainingAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expiresAt, orderData, pspReference, reference, remainingAmount);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CheckoutOrderResponse {\n");

        sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
        sb.append("    orderData: ").append(toIndentedString(orderData)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    remainingAmount: ").append(toIndentedString(remainingAmount)).append("\n");
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
