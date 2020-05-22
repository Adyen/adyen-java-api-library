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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.payout;

import com.adyen.constants.TextConstants;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

import static com.adyen.util.Util.toIndentedString;

/**
 * PaymentResult
 */
public class StoreDetailAndSubmitResponse {
    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("resultCode")
    private String resultCode = null;

    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    @SerializedName("refusalReason")
    private String refusalReason = null;

    public String getRefusalReason() {
        return refusalReason;
    }

    public void setRefusalReason(String refusalReason) {
        this.refusalReason = refusalReason;
    }

    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StoreDetailAndSubmitResponse {").append(TextConstants.LINE_BREAK);
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append(TextConstants.LINE_BREAK);
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append(TextConstants.LINE_BREAK);
        sb.append("    refusalReason: ").append(toIndentedString(refusalReason)).append(TextConstants.LINE_BREAK);
        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }
}