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

import com.google.gson.annotations.SerializedName;

import java.util.Map;

import static com.adyen.constants.TextConstants.LINE_BREAK;
import static com.adyen.util.Util.toIndentedString;

public class StoreDetailResponse {

    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

    @SerializedName("resultCode")
    private String resultCode = null;

    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public String getRecurringDetailReference() {
        return recurringDetailReference;
    }

    public void setRecurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StoreDetailResponse {").append(LINE_BREAK);
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append(LINE_BREAK);
        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append(LINE_BREAK);
        sb.append("    recurringDetailReference: ").append(toIndentedString(recurringDetailReference)).append(LINE_BREAK);
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append(LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }


}
