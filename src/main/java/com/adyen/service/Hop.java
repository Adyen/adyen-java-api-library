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

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.hop.GetOnboardingUrlRequest;
import com.adyen.model.hop.GetOnboardingUrlResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.hop.GetOnboardingUrl;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Hop extends Service {

    private final GetOnboardingUrl getOnboardingUrl;

    public Hop(Client client) {
        super(client);
        getOnboardingUrl = new GetOnboardingUrl(this);
    }

    public GetOnboardingUrlResponse getOnboardingUrl(GetOnboardingUrlRequest getOnboardingUrlRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(getOnboardingUrlRequest);

        String jsonResult = getOnboardingUrl.request(jsonRequest);

        return GSON.fromJson(jsonResult, new TypeToken<GetOnboardingUrlResponse>() {
        }.getType());
    }
}
