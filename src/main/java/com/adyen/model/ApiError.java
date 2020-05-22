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
import com.adyen.model.marketpay.ErrorFieldType;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Represents the API error responses
 */
public class ApiError {
    @SerializedName("status")
    private int status;

    @SerializedName("errorCode")
    private String errorCode = null;

    @SerializedName("message")
    private String message = null;

    @SerializedName("errorType")
    private String errorType = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public List<ErrorFieldType> getInvalidFields() {
        return invalidFields;
    }

    public void setInvalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiError {").append(TextConstants.LINE_BREAK);

        sb.append("    status: ").append(Util.toIndentedString(status)).append(TextConstants.LINE_BREAK);
        sb.append("    errorCode: ").append(Util.toIndentedString(errorCode)).append(TextConstants.LINE_BREAK);
        sb.append("    message: ").append(Util.toIndentedString(message)).append(TextConstants.LINE_BREAK);
        sb.append("    errorType: ").append(Util.toIndentedString(errorType)).append(TextConstants.LINE_BREAK);
        sb.append("    pspReference: ").append(Util.toIndentedString(pspReference)).append(TextConstants.LINE_BREAK);
        sb.append("    invalidFields: ").append(Util.toIndentedString(invalidFields)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }


}
