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
 * Copyright (c) 2018 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.checkout;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.constants.TextConstants.LINE_BREAK;
import static com.adyen.util.Util.toIndentedString;

/**
 * PaymentMethodGroup
 */
public class PaymentMethodGroup {

    @SerializedName("name")
    private String name = null;

    @SerializedName("paymentMethodData")
    private String paymentMethodData = null;

    @SerializedName("type")
    private String type = null;

    public PaymentMethodGroup name(String name) {
        this.name = name;
        return this;
    }


    /**
     * The name of the group.
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PaymentMethodGroup paymentMethodData(String paymentMethodData) {
        this.paymentMethodData = paymentMethodData;
        return this;
    }


    /**
     * Echo data to be used if the payment method is displayed as part of this group.
     *
     * @return paymentMethodData
     **/
    public String getPaymentMethodData() {
        return paymentMethodData;
    }

    public void setPaymentMethodData(String paymentMethodData) {
        this.paymentMethodData = paymentMethodData;
    }

    public PaymentMethodGroup type(String type) {
        this.type = type;
        return this;
    }


    /**
     * The unique code of the group.
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
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        PaymentMethodGroup paymentMethodGroup = (PaymentMethodGroup) o;
        return Objects.equals(this.name, paymentMethodGroup.name) &&
                Objects.equals(this.paymentMethodData, paymentMethodGroup.paymentMethodData) &&
                Objects.equals(this.type, paymentMethodGroup.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, paymentMethodData, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentMethodGroup {").append(LINE_BREAK);

        sb.append("    name: ").append(toIndentedString(name)).append(LINE_BREAK);
        sb.append("    paymentMethodData: ").append(toIndentedString(paymentMethodData)).append(LINE_BREAK);
        sb.append("    type: ").append(toIndentedString(type)).append(LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }




}



