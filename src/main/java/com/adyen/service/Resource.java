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

import java.io.IOException;
import java.util.List;
import com.adyen.Config;
import com.adyen.Service;
import com.adyen.httpclient.ClientInterface;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.model.ApiError;
import com.adyen.service.exception.ApiException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Resource {

    private Service service;
    protected String endpoint;
    protected List<String> requiredFields;

    protected static final Gson GSON = new Gson();

    public Resource(Service service, String endpoint, List<String> requiredFields) {
        this.service = service;
        this.endpoint = endpoint;
        this.requiredFields = requiredFields;
    }

    /**
     * Request using json String
     *
     * @param json
     * @return
     * @throws ApiException
     * @throws IOException
     */
    public String request(String json) throws ApiException, IOException {
        ClientInterface clientInterface = (ClientInterface) this.service.getClient().getHttpClient();
        Config config = this.service.getClient().getConfig();
        String result = null;
        try {
            result = clientInterface.request(this.endpoint, json, config, this.service.isApiKeySupported());
        } catch (HTTPClientException e) {
            String responseBody = e.getResponseBody();

            ApiError apiError = GSON.fromJson(responseBody, new TypeToken<ApiError>() {
            }.getType());
            ApiException apiException = new ApiException(e.getMessage(), e.getCode());
            apiException.setError(apiError);

            throw apiException;
        }
        return result;
    }
}
