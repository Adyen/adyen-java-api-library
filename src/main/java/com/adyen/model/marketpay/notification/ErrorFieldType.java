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

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * ErrorFieldType
 */

public class ErrorFieldType {
    @SerializedName("errorCode")
    private Integer errorCode = null;

    @SerializedName("errorDescription")
    private String errorDescription = null;

    @SerializedName("fieldType")
    private FieldType fieldType = null;

    public ErrorFieldType errorCode(Integer errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    /**
     * The validation error code.
     *
     * @return errorCode
     **/
    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorFieldType errorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
        return this;
    }

    /**
     * A description of the validation error.
     *
     * @return errorDescription
     **/
    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public ErrorFieldType fieldType(FieldType fieldType) {
        this.fieldType = fieldType;
        return this;
    }

    /**
     * Get fieldType
     *
     * @return fieldType
     **/
    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorFieldType errorFieldType = (ErrorFieldType) o;
        return Objects.equals(this.errorCode, errorFieldType.errorCode) &&
                Objects.equals(this.errorDescription, errorFieldType.errorDescription) &&
                Objects.equals(this.fieldType, errorFieldType.fieldType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, errorDescription, fieldType);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorFieldType {\n");

        sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
        sb.append("    errorDescription: ").append(toIndentedString(errorDescription)).append("\n");
        sb.append("    fieldType: ").append(toIndentedString(fieldType)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
