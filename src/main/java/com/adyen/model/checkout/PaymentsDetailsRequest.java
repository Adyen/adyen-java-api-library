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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * PaymentsDetailsRequest
 */
public class PaymentsDetailsRequest {

    @SerializedName("details")
    private Map<String, String> details = null;

    @SerializedName("paymentData")
    private String paymentData = null;

    public PaymentsDetailsRequest details(Map<String, String> details) {
        this.details = details;
        return this;
    }

    public PaymentsDetailsRequest putDetailsItem(String key, String detailsItem) {

        this.details.put(key, detailsItem);
        return this;
    }

    /**
     * Use this collection to submit the details that were returned as a result of the &#x60;/payments&#x60; call.
     *
     * @return details
     **/
    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }

    public PaymentsDetailsRequest paymentData(String paymentData) {
        this.paymentData = paymentData;
        return this;
    }


    /**
     * The &#x60;paymentData&#x60; value that you received in the response to the &#x60;/payments&#x60; call.
     *
     * @return paymentData
     **/
    public String getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(String paymentData) {
        this.paymentData = paymentData;
    }

    public PaymentsDetailsRequest set3DRequestData(String md, String paRes, String paymentData) {
        if (this.details == null) {
            this.details = new HashMap<>();
        }

        this.details.put("MD", md);
        this.details.put("PaRes", paRes);

        this.paymentData(paymentData);
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
        PaymentsDetailsRequest paymentsDetailsRequest = (PaymentsDetailsRequest) o;
        return Objects.equals(this.details, paymentsDetailsRequest.details) &&
                Objects.equals(this.paymentData, paymentsDetailsRequest.paymentData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(details, paymentData);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentsDetailsRequest {\n");

        sb.append("    details: ").append(toIndentedString(details)).append("\n");
        sb.append("    paymentData: ").append(toIndentedString(paymentData)).append("\n");
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



