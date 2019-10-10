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

import java.io.IOException;
import com.adyen.ApiKeyAuthenticatedService;
import com.adyen.Client;
import com.adyen.Util.Util;
import com.adyen.model.terminal.SaleToAcquirerDataModel;
import com.adyen.model.terminal.TerminalAPIRequest;
import com.adyen.model.terminal.TerminalAPIResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.terminal.cloud.Async;
import com.adyen.service.resource.terminal.cloud.Sync;
import com.adyen.terminal.serialization.TerminalAPIGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TerminalCloudAPI extends ApiKeyAuthenticatedService {

    private Async terminalApiAsync;
    private Sync terminalApiSync;

    private Gson terminalApiGson;

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
        terminalAPIRequest = this.checkSaleToAcquirerDataApplicationInfo(terminalAPIRequest);
        String jsonRequest = terminalApiGson.toJson(terminalAPIRequest);
        String response = terminalApiAsync.request(jsonRequest);
        return response;
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
        terminalAPIRequest = this.checkSaleToAcquirerDataApplicationInfo(terminalAPIRequest);
        String jsonRequest = terminalApiGson.toJson(terminalAPIRequest);
        String jsonResponse = terminalApiSync.request(jsonRequest);
        if (jsonResponse == null || jsonResponse.isEmpty() || "ok".equals(jsonResponse)) {
            return null;
        }

        TerminalAPIResponse terminalAPIResponse = terminalApiGson.fromJson(jsonResponse, new TypeToken<TerminalAPIResponse>() {
        }.getType());
        return terminalAPIResponse;
    }

    /**
     * Checks if SaleToAcquirerData is set. If it is not creates an encoded base 64 string with application info.
     *
     * @param terminalAPIRequest TerminalAPIRequest
     * @return TerminalAPIRequest
     */
    private static TerminalAPIRequest checkSaleToAcquirerDataApplicationInfo(TerminalAPIRequest terminalAPIRequest) {
        if (terminalAPIRequest != null
                && terminalAPIRequest.getSaleToPOIRequest() != null
                && terminalAPIRequest.getSaleToPOIRequest().getPaymentRequest() != null
                && terminalAPIRequest.getSaleToPOIRequest().getPaymentRequest().getSaleData() != null
                && terminalAPIRequest.getSaleToPOIRequest().getPaymentRequest().getSaleData().getSaleToAcquirerData() == null) {
            SaleToAcquirerDataModel saleToAcquirerDataModel = new SaleToAcquirerDataModel();
            String saleToAcquirerDataJson = saleToAcquirerDataModel.toJson();
            String saleToAcqurerDataJsonBase64 = Util.toBase64Encode(saleToAcquirerDataJson);
            terminalAPIRequest.getSaleToPOIRequest().getPaymentRequest().getSaleData().setSaleToAcquirerData(saleToAcqurerDataJsonBase64);
        }
        return terminalAPIRequest;
    }
}
