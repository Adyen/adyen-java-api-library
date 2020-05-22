/**
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
package com.adyen.model;

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

/**
 * Container for FraudCheckResult
 */
public class FraudCheckResultContainer {

    @SerializedName("FraudCheckResult")
    private FraudCheckResult fraudCheckResult;

    public FraudCheckResult getFraudCheckResult() {
        return fraudCheckResult;
    }

    public void setFraudCheckResult(FraudCheckResult fraudCheckResult) {
        this.fraudCheckResult = fraudCheckResult;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FraudCheckResultContainer {").append(TextConstants.LINE_BREAK);

        sb.append("    fraudCheckResult: ").append(Util.toIndentedString(fraudCheckResult)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }
}
