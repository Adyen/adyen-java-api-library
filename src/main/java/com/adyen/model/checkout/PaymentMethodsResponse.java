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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PaymentMethodsResponse
 */
public class PaymentMethodsResponse {

    @SerializedName("oneClickPaymentMethods")
    private List<RecurringDetail> oneClickPaymentMethods = null;

    @SerializedName("paymentMethods")
    private List<PaymentMethod> paymentMethods = null;

    @SerializedName("storedPaymentMethods")
    private List<StoredPaymentMethod> storedPaymentMethods;

    @SerializedName("groups")
    private List<PaymentMethodsGroup> groups;

    public PaymentMethodsResponse oneClickPaymentMethods(List<RecurringDetail> oneClickPaymentMethods) {
        this.oneClickPaymentMethods = oneClickPaymentMethods;
        return this;
    }

    public PaymentMethodsResponse addOneClickPaymentMethodsItem(RecurringDetail oneClickPaymentMethodsItem) {

        if (this.oneClickPaymentMethods == null) {
            this.oneClickPaymentMethods = new ArrayList<>();
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
            this.paymentMethods = new ArrayList<>();
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

    /**
     * List of all stored payment methods.
     *
     * @return storedPaymentMethods
     **/
    public List<StoredPaymentMethod> getStoredPaymentMethods() {
        return storedPaymentMethods;
    }

    public void setStoredPaymentMethods(List<StoredPaymentMethod> storedPaymentMethods) {
        this.storedPaymentMethods = storedPaymentMethods;
    }

    public PaymentMethodsResponse storedPaymentMethods(List<StoredPaymentMethod> storedPaymentMethods) {
        this.storedPaymentMethods = storedPaymentMethods;
        return this;
    }

    public PaymentMethodsResponse addStoredPaymentMethodItem(StoredPaymentMethod storedPaymentMethodItem) {
        if (this.storedPaymentMethods == null) {
            this.storedPaymentMethods = new ArrayList<>();
        }
        this.storedPaymentMethods.add(storedPaymentMethodItem);
        return this;
    }

    /**
     * Groups of payment methods.
     *
     * @return groups
     **/
    public List<PaymentMethodsGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<PaymentMethodsGroup> groups) {
        this.groups = groups;
    }

    public PaymentMethodsResponse groups(List<PaymentMethodsGroup> groups) {
        this.groups = groups;
        return this;
    }

    public PaymentMethodsResponse addGroupsItem(PaymentMethodsGroup groupsItem) {
        if (this.groups == null) {
            this.groups = new ArrayList<>();
        }
        this.groups.add(groupsItem);
        return this;
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
        return Objects.equals(this.oneClickPaymentMethods, paymentMethodsResponse.oneClickPaymentMethods)
                && Objects.equals(this.paymentMethods, paymentMethodsResponse.paymentMethods)
                && Objects.equals(this.storedPaymentMethods, paymentMethodsResponse.storedPaymentMethods)
                && Objects.equals(this.groups, paymentMethodsResponse.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oneClickPaymentMethods, paymentMethods, storedPaymentMethods, groups);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentMethodsResponse {\n");

        sb.append("    oneClickPaymentMethods: ").append(toIndentedString(oneClickPaymentMethods)).append("\n");
        sb.append("    paymentMethods: ").append(toIndentedString(paymentMethods)).append("\n");
        sb.append("    storedPaymentMethods: ").append(toIndentedString(storedPaymentMethods)).append("\n");
        sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
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



