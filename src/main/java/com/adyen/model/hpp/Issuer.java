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
package com.adyen.model.hpp;

import com.adyen.constants.TextConstants;
import com.google.gson.annotations.SerializedName;

import static com.adyen.util.Util.toIndentedString;

public class Issuer {
    @SerializedName("issuerId")
    private String issuerId = null;

    @SerializedName("name")
    private String name = null;

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Issuer {").append(TextConstants.LINE_BREAK);

        sb.append("    issuerId: ").append(toIndentedString(issuerId)).append(TextConstants.LINE_BREAK);
        sb.append("    name: ").append(toIndentedString(name)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }
}
