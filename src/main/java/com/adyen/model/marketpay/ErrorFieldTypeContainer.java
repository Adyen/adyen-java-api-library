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
package com.adyen.model.marketpay;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.constants.TextConstants.LINE_BREAK;
import static com.adyen.util.Util.toIndentedString;

public class ErrorFieldTypeContainer {
    @SerializedName("ErrorFieldType")
    private ErrorFieldType errorFieldType;

    public ErrorFieldTypeContainer(ErrorFieldType errorFieldType) {
        this.errorFieldType = errorFieldType;
    }

    /**
     * errorFieldType
     *
     * @return errorFieldType
     */
    public ErrorFieldType getErrorFieldType() {
        return errorFieldType;
    }

    public void setErrorFieldType(ErrorFieldType errorFieldType) {
        this.errorFieldType = errorFieldType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorFieldTypeContainer errorFieldTypeContainer = (ErrorFieldTypeContainer) o;
        return Objects.equals(this.errorFieldType, errorFieldTypeContainer.errorFieldType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorFieldType);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorFieldTypeContainer {").append(LINE_BREAK);

        sb.append("    errorFieldType: ").append(toIndentedString(errorFieldType)).append(LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }
}
