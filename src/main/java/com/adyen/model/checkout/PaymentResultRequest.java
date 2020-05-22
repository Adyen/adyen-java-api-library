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

import com.adyen.constants.TextConstants;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * PaymentResultRequest
 */
public class PaymentResultRequest {

    @SerializedName("payload")
    private String payload = null;

    public PaymentResultRequest payload(String payload) {
        this.payload = payload;
        return this;
    }


    /**
     * Encrypted and signed payment result data. You should receive this value from the Checkout SDK after the shopper completes the payment.
     *
     * @return payload
     **/
    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        PaymentResultRequest paymentResultRequest = (PaymentResultRequest) o;
        return Objects.equals(this.payload, paymentResultRequest.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentResultRequest {").append(TextConstants.LINE_BREAK);

        sb.append("    payload: ").append(toIndentedString(payload)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }


}



