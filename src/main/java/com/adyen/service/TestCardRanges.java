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
import com.adyen.model.testcard.CreateTestCardRangesRequest;
import com.adyen.model.testcard.CreateTestCardRangesResult;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.testcard.TestCard;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class TestCardRanges extends ApiKeyAuthenticatedService {

    private final TestCard testCard;

    public TestCardRanges(Client client) {
        super(client);
        testCard = new TestCard(this);
    }

    /**
     * POST /createTestCardRanges API call
     * @param request CreateTestCardRangesRequest
     * @return TestCardRangeCreationResult
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public CreateTestCardRangesResult createTestCardRanges(CreateTestCardRangesRequest request) throws IOException, ApiException {
        return createTestCardRanges(request, null);
    }

    public CreateTestCardRangesResult createTestCardRanges(CreateTestCardRangesRequest request, RequestOptions requestOptions) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);
        String jsonResult = testCard.request(jsonRequest, requestOptions);

        return GSON.fromJson(jsonResult, new TypeToken<CreateTestCardRangesResult>() {}.getType());
    }

}
