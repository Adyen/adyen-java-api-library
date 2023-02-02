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
package com.adyen.service.resource;

import com.adyen.Config;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
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
import java.util.Map;

import static com.adyen.constants.ApiConstants.HttpMethod.POST;

public class Resource {

    protected static final Gson GSON = new Gson();
    protected String endpoint;
    protected List<String> requiredFields;
    private final Service service;

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
    public String request(String json, ApiConstants.HttpMethod httpMethod) throws ApiException, IOException {
        return request(json, null, httpMethod, null);
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
        return request(json, null, POST, null);
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
        return request(json, requestOptions, POST, null);
    }

    /**
     * Request without query string parameters
     */
    public String request(String json, RequestOptions requestOptions, ApiConstants.HttpMethod httpMethod, Map<String, String> pathParams) throws ApiException, IOException {
        return request(json, requestOptions, httpMethod, pathParams, null);
    }

    /**
     * Request using json String with additional request parameters like idempotency-key
     *
     * @param json   json
     * @param requestOptions request options
     * @param httpMethod http method
     * @param pathParams path parameters
     * @param queryString query string parameters
     * @throws ApiException apiException
     * @throws IOException  IOException
     * @return request
     */
    public String request(String json, RequestOptions requestOptions, ApiConstants.HttpMethod httpMethod, Map<String, String> pathParams, Map<String, String> queryString) throws ApiException, IOException {
        ClientInterface clientInterface = service.getClient().getHttpClient();
        Config config = service.getClient().getConfig();
        String responseBody;
        ApiException apiException;

        try {
            return clientInterface.request(resolve(pathParams), json, config, service.isApiKeyRequired(), requestOptions, httpMethod, queryString);
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

    private String resolve(Map<String, String> params) {
        if (endpoint == null || params == null || endpoint.isEmpty() || params.isEmpty()) {
            return endpoint;
        }

        StringBuilder path = new StringBuilder();
        int i = 0;
        do {
            int beginVar = endpoint.indexOf("{", i);
            if (beginVar < 0) {
                path.append(endpoint, i, endpoint.length());
                break;
            }
            path.append(endpoint, i, beginVar);
            int endVar = endpoint.indexOf("}", i);
            if (endVar < 0) {
                path.append(endpoint, beginVar, endpoint.length());
                break;
            }

            String varName = endpoint.substring(beginVar + 1, endVar);
            path.append(params.get(varName));
            i = endVar + 1;

        } while (i < endpoint.length());

        return path.toString();
    }
}
