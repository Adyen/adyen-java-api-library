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
package com.adyen.service;

import com.adyen.Config;
import com.adyen.Service;
import com.adyen.httpclient.ClientInterface;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.model.ApiError;
import com.adyen.model.RequestOptions;
import com.adyen.service.exception.ApiException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

public class Resource {

    protected static final Gson GSON = new Gson();
    protected String endpoint;
    protected List<String> requiredFields;
    private Service service;

    public Resource(Service service, String endpoint, List<String> requiredFields) {
        this.service = service;
        this.endpoint = endpoint;
        this.requiredFields = requiredFields;
    }

    /**
     * Request using json String
     *
     * @param json request json
     * @return request
     * @throws ApiException ApiException
     * @throws IOException  IOException
     */
    public String request(String json) throws ApiException, IOException {
        return request(json, null);
    }

    /**
     * Request using json String with additional request parameters like idempotency-key
     *
     * @param json   json
     * @param requestOptions request options
     * @throws ApiException apiException
     * @throws IOException  IOException
     * @return request
     */
    public String request(String json, RequestOptions requestOptions) throws ApiException, IOException {
        ClientInterface clientInterface = service.getClient().getHttpClient();
        Config config = service.getClient().getConfig();
        String responseBody;
        ApiException apiException;

        try {
            return clientInterface.request(endpoint, json, config, service.isApiKeyRequired(), requestOptions);
        } catch (HTTPClientException e) {
            responseBody = e.getResponseBody();
            apiException = new ApiException(e.getMessage(), e.getCode(), e.getResponseHeaders());
        }

        // Enhance ApiException with more info from JSON payload
        try {
            ApiError apiError = GSON.fromJson(responseBody, new TypeToken<ApiError>() {
            }.getType());
            apiException.setError(apiError);
        } catch (JsonSyntaxException ignored) {
            throw new ApiException("Invalid response or an invalid X-API-Key key was used", apiException.getStatusCode());
        }

        throw apiException;
    }
}
