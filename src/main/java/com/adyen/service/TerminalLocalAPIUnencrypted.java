package com.adyen.service;

import com.adyen.ApiKeyAuthenticatedService;
import com.adyen.Client;
import com.adyen.model.terminal.TerminalAPIRequest;
import com.adyen.model.terminal.TerminalAPIResponse;
import com.adyen.service.resource.terminal.local.LocalRequest;
import com.adyen.terminal.serialization.TerminalAPIGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * [UNENCRYPTED] Local Terminal Api.
 * Use this class (in TEST only) to experiment with the Local Terminal API separately
 * from the encryption implementation required for live payments.
 * <p>
 * Be sure to remove the encryption key details on the Customer Area as it will not work with encryption key details set up.
 */
public class TerminalLocalAPIUnencrypted extends ApiKeyAuthenticatedService {

    private final LocalRequest localRequest;

    private final Gson terminalApiGson;

    public TerminalLocalAPIUnencrypted(Client client) {
        super(client);
        localRequest = new LocalRequest(this);
        terminalApiGson = TerminalAPIGsonBuilder.create();
    }

    /**
     * Local Terminal API call
     *
     * @param terminalAPIRequest TerminalAPIRequest
     * @return TerminalAPIResponse
     * @throws Exception exception
     */
    public TerminalAPIResponse request(TerminalAPIRequest terminalAPIRequest) throws Exception {
        String jsonRequest = terminalApiGson.toJson(terminalAPIRequest);

        String jsonResponse = localRequest.request(jsonRequest);

        if (jsonResponse == null || jsonResponse.isEmpty() || "ok".equals(jsonResponse)) {
            return null;
        }

        return terminalApiGson.fromJson(jsonResponse, new TypeToken<TerminalAPIResponse>() {
        }.getType());
    }
}
