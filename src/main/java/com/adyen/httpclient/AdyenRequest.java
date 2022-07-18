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
 * Copyright (c) 2022 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.httpclient;

import com.adyen.constants.ApiConstants;
import com.adyen.model.RequestOptions;

import java.util.Map;

public class AdyenRequest {

    private String endpoint;
    private String requestBody;
    private boolean isApiKeyRequired;
    private RequestOptions requestOptions;
    private ApiConstants.HttpMethod httpMethod;
    private Map<String, String> params;

    public AdyenRequest() {
    }

    public AdyenRequest(String endpoint, String requestBody, boolean isApiKeyRequired, RequestOptions requestOptions, ApiConstants.HttpMethod httpMethod, Map<String, String> params) {
        this.endpoint = endpoint;
        this.requestBody = requestBody;
        this.isApiKeyRequired = isApiKeyRequired;
        this.requestOptions = requestOptions;
        this.httpMethod = httpMethod;
        this.params = params;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public boolean isApiKeyRequired() {
        return isApiKeyRequired;
    }

    public void setApiKeyRequired(boolean apiKeyRequired) {
        isApiKeyRequired = apiKeyRequired;
    }

    public RequestOptions getRequestOptions() {
        return requestOptions;
    }

    public void setRequestOptions(RequestOptions requestOptions) {
        this.requestOptions = requestOptions;
    }

    public ApiConstants.HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(ApiConstants.HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
