package com.adyen.service.exception;

import com.adyen.model.ApiError;

/**
 * API Exception class
 */
public class ApiException extends Exception {
    private ApiError error;

    public ApiException(String message) {
        super(message);
    }

    public ApiError getError() {
        return error;
    }

    public void setError(ApiError error) {
        this.error = error;
    }
}
