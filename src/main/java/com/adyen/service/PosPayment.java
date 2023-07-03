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
import com.adyen.model.terminal.ConnectedTerminalsRequest;
import com.adyen.model.terminal.ConnectedTerminalsResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.terminal.cloud.ConnectedTerminals;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class PosPayment extends ApiKeyAuthenticatedService {
    protected static final Gson GSON = new GsonBuilder().disableHtmlEscaping().create();
    private final ConnectedTerminals connectedTerminals;

    public PosPayment(Client client) {
        super(client);
        connectedTerminals = new ConnectedTerminals(this);
    }

    /**
     * POST /connectedTerminals API call
     *
     * @param connectedTerminalsRequest ConnectedTerminalsRequest
     * @return ConnectedTerminalsResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public ConnectedTerminalsResponse connectedTerminals(ConnectedTerminalsRequest connectedTerminalsRequest) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(connectedTerminalsRequest);
        String jsonResult = connectedTerminals.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<ConnectedTerminalsResponse>() {
        }.getType());
    }
}
