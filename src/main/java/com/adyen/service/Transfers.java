package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.transfer.JSON;
import com.adyen.model.transfer.Transfer;
import com.adyen.model.transfer.TransferInfo;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.transfers.TransfersResource;

import java.io.IOException;

public class Transfers extends Service {

    public Transfers(Client client) {
        super(client);
        new JSON();
    }

    public Transfer transfers(TransferInfo transferInfo) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(transferInfo);
        TransfersResource transfersResource = new TransfersResource(this);
        String jsonResult = transfersResource.request(jsonRequest);
        return Transfer.fromJson(jsonResult);
    }
}