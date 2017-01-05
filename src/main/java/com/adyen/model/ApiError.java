package com.adyen.model;

import com.google.gson.annotations.SerializedName;

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
}
