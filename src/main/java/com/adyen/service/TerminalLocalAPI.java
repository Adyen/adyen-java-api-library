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
import com.adyen.model.terminal.TerminalAPISecuredRequest;
import com.adyen.model.terminal.TerminalAPISecuredResponse;
import com.adyen.model.terminal.security.SaleToPOISecuredMessage;
import com.adyen.model.terminal.security.SecurityKey;
import com.adyen.service.resource.terminal.local.LocalRequest;
import com.adyen.terminal.security.NexoCrypto;
import com.adyen.terminal.serialization.TerminalAPIGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TerminalLocalAPI extends ApiKeyAuthenticatedService {

    private final LocalRequest localRequest;

    private final NexoCrypto nexoCrypto;
    private final Gson terminalApiGson;

    public TerminalLocalAPI(Client client) {
        super(client);
        localRequest = new LocalRequest(this);
        nexoCrypto = new NexoCrypto();
        terminalApiGson = TerminalAPIGsonBuilder.create();
    }

    /**
     * POST /sync API call
     *
     * @param terminalAPIRequest TerminalAPIRequest
     * @return TerminalAPIResponse
     * @throws Exception exception
     */
    public TerminalAPIResponse request(TerminalAPIRequest terminalAPIRequest, SecurityKey securityKey) throws Exception {
        String jsonRequest = terminalApiGson.toJson(terminalAPIRequest);
        SaleToPOISecuredMessage saleToPOISecuredRequest = nexoCrypto.encrypt(jsonRequest, terminalAPIRequest.getSaleToPOIRequest().getMessageHeader(), securityKey);

        TerminalAPISecuredRequest securedPaymentRequest = new TerminalAPISecuredRequest();
        securedPaymentRequest.setSaleToPOIRequest(saleToPOISecuredRequest);
        String jsonEncryptedRequest = terminalApiGson.toJson(securedPaymentRequest);

        String jsonResponse = localRequest.request(jsonEncryptedRequest);

        if (jsonResponse == null || jsonResponse.isEmpty()) {
            return null;
        }

        TerminalAPISecuredResponse securedPaymentResponse = terminalApiGson.fromJson(jsonResponse, new TypeToken<TerminalAPISecuredResponse>() {
        }.getType());
        SaleToPOISecuredMessage saleToPOISecuredResponse = securedPaymentResponse.getSaleToPOIResponse();
        String jsonDecryptedResponse = nexoCrypto.decrypt(saleToPOISecuredResponse, securityKey);
        return terminalApiGson.fromJson(jsonDecryptedResponse, new TypeToken<TerminalAPIResponse>() {
        }.getType());
    }
}
