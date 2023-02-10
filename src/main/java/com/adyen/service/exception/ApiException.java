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
package com.adyen.service.exception;

import java.util.List;
import java.util.Map;
import com.adyen.model.ApiError;

/**
 * API Exception class
 */
public class ApiException extends Exception {
    //Describes the error
    private ApiError error;

    //HTTP status code
    private int statusCode;

    private Map<String, List<String>> responseHeaders;
    private String responseBody;

    public ApiException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public ApiException(String message, int statusCode, Map<String, List<String>> responseHeaders) {
        this(message, statusCode);
        this.responseHeaders = responseHeaders;
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

    public Map<String, List<String>> getResponseHeaders() {
        return responseHeaders;
    }

    public String getResponseBody() {
        return responseBody;
    }
    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }
    @Override
    public String toString() {
        return "ApiException{" + "error=" + error +
                ", statusCode=" + statusCode +
                ", message=" + getMessage() +
                ", responseHeaders=" + getResponseHeaders() +
                ", responseBody=" + getResponseBody() + "}";
    }
}
