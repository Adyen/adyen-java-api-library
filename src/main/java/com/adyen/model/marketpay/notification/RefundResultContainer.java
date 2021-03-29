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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.marketpay.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class RefundResultContainer {
    @SerializedName("RefundResult")
    @JsonProperty("RefundResult")
    private RefundResult refundResult;

    public RefundResult getRefundResult() {
        return refundResult;
    }

    public void setRefundResult(RefundResult refundResult) {
        this.refundResult = refundResult;
    }

    @Override
    public String toString() {
        return "RefundResultContainer{" + "refundResult=" + refundResult + '}';
    }
}
