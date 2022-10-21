package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.transfer.JSON;
import com.adyen.model.transfer.Transaction;
import com.adyen.model.transfer.TransactionSearchResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.transfers.TransactionResource;
import com.adyen.service.resource.transfers.TransfersResource;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import static com.adyen.constants.ApiConstants.HttpMethod.GET;

public class Transactions extends Service {

    private static final String ID = "Id";

    public Transactions(Client client) {
        super(client);
        new JSON();
    }

    public TransactionSearchResponse list() throws IOException, ApiException {
        TransactionResource transfersResource = new TransactionResource(this);
        String jsonResult = transfersResource.request(null, null, ApiConstants.HttpMethod.GET, null);
        return TransactionSearchResponse.fromJson(jsonResult);
    }

    public Transaction retrieve(String transactionId) throws IOException, ApiException {
        Map<String, String> params = Collections.singletonMap(ID, transactionId);
        TransactionResource transfersResource = new TransactionResource(this);
        String jsonResult = transfersResource.request(null, null, ApiConstants.HttpMethod.GET, params);
        return Transaction.fromJson(jsonResult);
    }
}

