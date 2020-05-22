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
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class ModifyRequest {
    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("originalReference")
    private String originalReference = null;

    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getOriginalReference() {
        return originalReference;
    }

    public void setOriginalReference(String originalReference) {
        this.originalReference = originalReference;
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
        sb.append("class ModifyRequest {").append(TextConstants.LINE_BREAK);
        sb.append("    merchantAccount: ").append(Util.toIndentedString(merchantAccount)).append(TextConstants.LINE_BREAK);
        sb.append("    originalReference: ").append(Util.toIndentedString(originalReference)).append(TextConstants.LINE_BREAK);
        sb.append("    additionalData: ").append(Util.toIndentedString(additionalData)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }
}
