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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * PaymentMethodsResponse
 */
public class PaymentMethodsResponse {

    @SerializedName("oneClickPaymentMethods")
    private List<RecurringDetail> oneClickPaymentMethods = null;

    @SerializedName("paymentMethods")
    private List<PaymentMethod> paymentMethods = null;

    public PaymentMethodsResponse oneClickPaymentMethods(List<RecurringDetail> oneClickPaymentMethods) {
        this.oneClickPaymentMethods = oneClickPaymentMethods;
        return this;
    }

    public PaymentMethodsResponse addOneClickPaymentMethodsItem(RecurringDetail oneClickPaymentMethodsItem) {

        if (this.oneClickPaymentMethods == null) {
            this.oneClickPaymentMethods = new ArrayList<RecurringDetail>();
        }

        this.oneClickPaymentMethods.add(oneClickPaymentMethodsItem);
        return this;
    }

    /**
     * Detailed list of one-click payment methods.
     *
     * @return oneClickPaymentMethods
     **/
    public List<RecurringDetail> getOneClickPaymentMethods() {
        return oneClickPaymentMethods;
    }

    public void setOneClickPaymentMethods(List<RecurringDetail> oneClickPaymentMethods) {
        this.oneClickPaymentMethods = oneClickPaymentMethods;
    }

    public PaymentMethodsResponse paymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
        return this;
    }

    public PaymentMethodsResponse addPaymentMethodsItem(PaymentMethod paymentMethodsItem) {

        if (this.paymentMethods == null) {
            this.paymentMethods = new ArrayList<PaymentMethod>();
        }

        this.paymentMethods.add(paymentMethodsItem);
        return this;
    }

    /**
     * Detailed list of payment methods required to generate payment forms.
     *
     * @return paymentMethods
     **/
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentMethodsResponse paymentMethodsResponse = (PaymentMethodsResponse) o;
        return Objects.equals(this.oneClickPaymentMethods, paymentMethodsResponse.oneClickPaymentMethods) && Objects.equals(this.paymentMethods, paymentMethodsResponse.paymentMethods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oneClickPaymentMethods, paymentMethods);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentMethodsResponse {\n");

        sb.append("    oneClickPaymentMethods: ").append(toIndentedString(oneClickPaymentMethods)).append("\n");
        sb.append("    paymentMethods: ").append(toIndentedString(paymentMethods)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }


}



