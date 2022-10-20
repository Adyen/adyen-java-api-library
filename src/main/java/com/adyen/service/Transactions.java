package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.transfer.JSON;
import com.adyen.model.transfer.Transaction;
import com.adyen.model.transfer.TransactionSearchResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.transfers.TransfersResource;

import java.io.IOException;

import static com.adyen.constants.ApiConstants.HttpMethod.GET;

public class Transactions extends Service {

    public Transactions(Client client) {
        super(client);
        new JSON();
    }

    public TransactionSearchResponse list() throws IOException, ApiException {
        TransfersResource transfersResource = new TransfersResource(this, "/transactions");
        String jsonResult = transfersResource.request(null, GET);
        return TransactionSearchResponse.fromJson(jsonResult);
    }

    public Transaction retrieve(String transactionsId) throws IOException, ApiException {
        TransfersResource transfersResource = new TransfersResource(this, String.format("/transactions/%s", transactionsId));
        String jsonResult = transfersResource.request(null, GET);
        return Transaction.fromJson(jsonResult);
    }
}
