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

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.terminal.TerminalAPIRequest;
import com.adyen.terminal.TerminalAPIResponse;
import com.adyen.terminal.security.*;
import com.adyen.service.resource.terminal.local.LocalRequest;
import com.adyen.terminal.security.NexoCrypto;
import com.adyen.terminal.security.exception.NexoCryptoException;

public class TerminalLocalAPI extends Service {

    private final LocalRequest localRequest;

    private final NexoCrypto nexoCrypto;

    public TerminalLocalAPI(Client client, SecurityKey securityKey) throws NexoCryptoException {
        super(client);
        localRequest = new LocalRequest(this);
        nexoCrypto = new NexoCrypto(securityKey);
    }

    /**
     * POST /sync API call
     *
     * @param terminalAPIRequest TerminalAPIRequest
     * @return TerminalAPIResponse
     * @throws Exception exception
     */
    public TerminalAPIResponse request(TerminalAPIRequest terminalAPIRequest) throws Exception {
        String jsonRequest = terminalAPIRequest.toJson();
        SaleToPOISecuredMessage saleToPOISecuredRequest = nexoCrypto.encrypt(jsonRequest, terminalAPIRequest.getSaleToPOIRequest().getMessageHeader());

        TerminalAPISecuredRequest securedPaymentRequest = new TerminalAPISecuredRequest();
        securedPaymentRequest.setSaleToPOIRequest(saleToPOISecuredRequest);
        String jsonEncryptedRequest = securedPaymentRequest.toJson();

        String jsonResponse = localRequest.request(jsonEncryptedRequest);

        if (jsonResponse == null || jsonResponse.isEmpty()) {
            return null;
        }

        TerminalAPISecuredResponse securedPaymentResponse = TerminalAPISecuredResponse.fromJson(jsonResponse);

        SaleToPOISecuredMessage saleToPOISecuredResponse = securedPaymentResponse.getSaleToPOIResponse();
        String jsonDecryptedResponse = nexoCrypto.decrypt(saleToPOISecuredResponse);

        return TerminalAPIResponse.fromJson(jsonDecryptedResponse);
    }
}
