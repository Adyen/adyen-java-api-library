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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.service;

import com.adyen.ApiKeyAuthenticatedService;
import com.adyen.Client;
import com.adyen.model.RequestOptions;
import com.adyen.model.dispute.RetriveApplicableDefenseReasonsRequest;
import com.adyen.model.dispute.RetriveApplicableDefenseReasonsResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.dispute.RetrieveApplicableDefenseReasons;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Dispute extends ApiKeyAuthenticatedService {

    private RetrieveApplicableDefenseReasons retriveApplicableDefenseReasons;

    public Dispute(Client client) {

        super(client);
        this.setApiKeyRequired(true);
        this.retriveApplicableDefenseReasons = new RetrieveApplicableDefenseReasons(this);

    }

    /**
     * POST /retrieveApplicableDefenseReasons API call
     *
     * @param retriveApplicableDefenseReasonsRequest RetriveApplicableDefenseReasonsRequest
     * @return RetriveApplicableDefenseReasonsResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public RetriveApplicableDefenseReasonsResponse retriveApplicableDefenseReasons(RetriveApplicableDefenseReasonsRequest retriveApplicableDefenseReasonsRequest) throws ApiException, IOException {
        return retriveApplicableDefenseReasons(retriveApplicableDefenseReasonsRequest, null);
    }


    public RetriveApplicableDefenseReasonsResponse retriveApplicableDefenseReasons(RetriveApplicableDefenseReasonsRequest retriveApplicableDefenseReasonsRequest, RequestOptions requestOptions) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(retriveApplicableDefenseReasonsRequest);
        String jsonResult = this.retriveApplicableDefenseReasons.request(jsonRequest, requestOptions);
        return GSON.fromJson(jsonResult, new TypeToken<RetriveApplicableDefenseReasonsResponse>() {
        }.getType());
    }
}
