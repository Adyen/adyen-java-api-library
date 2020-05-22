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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.checkout;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * CheckoutOrder
 */

public class CheckoutOrder {

    @SerializedName("orderData")
    private String orderData = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    public CheckoutOrder orderData(String orderData) {
        this.orderData = orderData;
        return this;
    }

    /**
     * The encrypted order data
     *
     * @return orderData
     **/
    public String getOrderData() {
        return orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }

    public CheckoutOrder pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * The pspReference that belongs to the order
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        CheckoutOrder checkoutOrder = (CheckoutOrder) o;
        return Objects.equals(this.orderData, checkoutOrder.orderData) &&
                Objects.equals(this.pspReference, checkoutOrder.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderData, pspReference);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CheckoutOrder {\n");

        sb.append("    orderData: ").append(toIndentedString(orderData)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (Objects.isNull(o)) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
