package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.terminal.TerminalAPIRequest;
import com.adyen.terminal.TerminalAPIResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.terminal.cloud.Async;
import com.adyen.service.resource.terminal.cloud.Sync;

import java.io.IOException;

public class TerminalCloudAPI extends Service {

    private final Async terminalApiAsync;
    private final Sync terminalApiSync;

    public TerminalCloudAPI(Client client) {
        super(client);
        terminalApiAsync = new Async(this);
        terminalApiSync = new Sync(this);
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
        String jsonRequest = terminalAPIRequest.toJson();

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
        String jsonRequest = terminalAPIRequest.toJson();

        String jsonResponse = terminalApiSync.request(jsonRequest);

        if (jsonResponse == null || jsonResponse.isEmpty() || "ok".equals(jsonResponse)) {
            return null;
        }

        return TerminalAPIResponse.fromJson(jsonResponse);
    }
}
