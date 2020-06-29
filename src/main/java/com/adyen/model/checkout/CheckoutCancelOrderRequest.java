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

/**
 * CheckoutCancelOrderRequest
 */

public class CheckoutCancelOrderRequest {
    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("order")
    private CheckoutOrder order = null;

    public CheckoutCancelOrderRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * The merchant account identifier that orderData belongs to.
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public CheckoutCancelOrderRequest order(CheckoutOrder order) {
        this.order = order;
        return this;
    }

    /**
     * Get order
     *
     * @return order
     **/
    public CheckoutOrder getOrder() {
        return order;
    }

    public void setOrder(CheckoutOrder order) {
        this.order = order;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CheckoutCancelOrderRequest checkoutCancelOrderRequest = (CheckoutCancelOrderRequest) o;
        return Objects.equals(this.merchantAccount, checkoutCancelOrderRequest.merchantAccount) &&
                Objects.equals(this.order, checkoutCancelOrderRequest.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantAccount, order);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CheckoutCancelOrderRequest {\n");

        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    order: ").append(toIndentedString(order)).append("\n");
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
