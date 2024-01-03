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
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.terminal.cloud.ConnectedTerminals;
import com.adyen.terminal.ConnectedTerminalsRequest;
import com.adyen.terminal.ConnectedTerminalsResponse;

import java.io.IOException;

public class TerminalConnectedApi extends ApiKeyAuthenticatedService {
    private final ConnectedTerminals connectedTerminals;

    public TerminalConnectedApi(Client client) {
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
        String jsonRequest = connectedTerminalsRequest.toJson();
        String jsonResult = connectedTerminals.request(jsonRequest);
        return ConnectedTerminalsResponse.fromJson(jsonResult);
    }
}
