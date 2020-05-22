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

import static com.adyen.util.Util.toIndentedString;

public class ModifyResponse {
    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("response")
    private String response = null;

    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModifyResponse {").append(TextConstants.LINE_BREAK);
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append(TextConstants.LINE_BREAK);
        sb.append("    response: ").append(toIndentedString(response)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }
}
