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

package com.adyen.model.marketpay.notification;

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class KYCCheckSummary {

    @SerializedName("code")
    private Integer code = null;

    @SerializedName("description")
    private String description = null;

    public KYCCheckSummary code(Integer code) {
        this.code = code;
        return this;
    }

    /**
     * The code of the check.
     *
     * @return code
     **/
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public KYCCheckSummary description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the check.
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        KYCCheckSummary kyCCheckSummary = (KYCCheckSummary) o;
        return Objects.equals(this.code, kyCCheckSummary.code) &&
                Objects.equals(this.description, kyCCheckSummary.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KYCCheckSummary {").append(TextConstants.LINE_BREAK);

        sb.append("    code: ").append(Util.toIndentedString(code)).append(TextConstants.LINE_BREAK);
        sb.append("    description: ").append(Util.toIndentedString(description)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }
}