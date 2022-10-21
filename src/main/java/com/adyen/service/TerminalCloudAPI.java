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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service;

import com.adyen.ApiKeyAuthenticatedService;
import com.adyen.Client;
import com.adyen.model.terminal.TerminalAPIRequest;
import com.adyen.model.terminal.TerminalAPIResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.terminal.cloud.Async;
import com.adyen.service.resource.terminal.cloud.Sync;
import com.adyen.terminal.serialization.TerminalAPIGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class TerminalCloudAPI extends ApiKeyAuthenticatedService {

    private final Async terminalApiAsync;
    private final Sync terminalApiSync;

    private final Gson terminalApiGson;

    public TerminalCloudAPI(Client client) {
        super(client);
        terminalApiAsync = new Async(this);
        terminalApiSync = new Sync(this);
        terminalApiGson = TerminalAPIGsonBuilder.create();
    }

    /**
     * POST /async API call
     *
     * @param terminalAPIRequest TerminalAPIRequest
     * @return String string
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public String async(TerminalAPIRequest terminalAPIRequest) throws IOException, ApiException {
        String jsonRequest = terminalApiGson.toJson(terminalAPIRequest);

        return terminalApiAsync.request(jsonRequest);
    }

    /**
     * POST /sync API call
     *
     * @param terminalAPIRequest TerminalAPIRequest
     * @return TerminalAPIResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public TerminalAPIResponse sync(TerminalAPIRequest terminalAPIRequest) throws IOException, ApiException {
        String jsonRequest = terminalApiGson.toJson(terminalAPIRequest);

        String jsonResponse = terminalApiSync.request(jsonRequest);

        if (jsonResponse == null || jsonResponse.isEmpty() || "ok".equals(jsonResponse)) {
            return null;
        }

        return terminalApiGson.fromJson(jsonResponse, new TypeToken<TerminalAPIResponse>() {
        }.getType());
    }
}
