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
 * Copyright (c) 2018 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service;

import com.adyen.ApiKeyAuthenticatedService;
import com.adyen.Client;
import com.adyen.model.RequestOptions;
import com.adyen.model.checkoututility.OriginKeysRequest;
import com.adyen.model.checkoututility.OriginKeysResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.checkoututility.OriginKeys;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class CheckoutUtility extends ApiKeyAuthenticatedService {

    protected static final Gson GSON = new GsonBuilder().disableHtmlEscaping().create();
    private final OriginKeys originKeys;

    public CheckoutUtility(Client client) {
        super(client);
        originKeys = new OriginKeys(this);
    }

    /**
     * POST /originKeys API call
     *
     * @param originKeysRequest OriginKeysRequest
     * @return originKeysResponse
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public OriginKeysResponse originKeys(OriginKeysRequest originKeysRequest) throws ApiException, IOException {
        return originKeys(originKeysRequest, null);
    }

    public OriginKeysResponse originKeys(OriginKeysRequest originKeysRequest, RequestOptions requestOptions) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(originKeysRequest);
        String jsonResult = originKeys.request(jsonRequest, requestOptions);
        return GSON.fromJson(jsonResult, new TypeToken<OriginKeysResponse>() {
        }.getType());
    }
}
