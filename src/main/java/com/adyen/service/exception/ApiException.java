package com.adyen.service.exception;

import com.adyen.model.ApiError;

/**
 * API Exception class
 */
public class ApiException extends Exception {
    //Describes the error
    private ApiError error;

    //HTTP status code
    private int statusCode;

    public ApiException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public ApiError getError() {
        return error;
    }

    public void setError(ApiError error) {
        this.error = error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
