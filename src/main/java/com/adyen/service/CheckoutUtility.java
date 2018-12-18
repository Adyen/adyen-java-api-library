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
import com.adyen.model.checkoututility.OriginKeysRequest;
import com.adyen.model.checkoututility.OriginKeysResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.checkoututility.OriginKeys;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class CheckoutUtility extends ApiKeyAuthenticatedService {

    private OriginKeys originKeys;

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
        String jsonRequest = GSON.toJson(originKeysRequest);
        String jsonResult = originKeys.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<OriginKeysResponse>() {
        }.getType());
    }
}
