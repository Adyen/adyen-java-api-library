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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service;

import com.adyen.ApiKeyAuthenticatedService;
import com.adyen.Client;
import com.adyen.constants.ApiConstants;
import com.adyen.model.checkout.CreatePaymentLinkRequest;
import com.adyen.model.checkout.PaymentLinkResource;
import com.adyen.model.checkout.UpdatePaymentLinkRequest;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.checkout.PaymentLink;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class PaymentLinks extends ApiKeyAuthenticatedService {
    private static final String LINK_ID = "linkId";

    private com.adyen.service.resource.checkout.PaymentLinks paymentLinks;
    private PaymentLink paymentLink;

    public PaymentLinks(Client client) {
        super(client);
        this.paymentLinks = new com.adyen.service.resource.checkout.PaymentLinks(this);
        this.paymentLink = new PaymentLink(this);
    }

    /**
     * POST /paymentLinks API call
     *
     * @param createPaymentLinkRequest CreatePaymentLinkRequest
     * @return createPaymentLinkResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public PaymentLinkResource create(CreatePaymentLinkRequest createPaymentLinkRequest) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(createPaymentLinkRequest);
        String jsonResult = paymentLinks.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentLinkResource>() {
        }.getType());
    }

    /**
     * GET /paymentLinks API call
     *
     * @param linkId String
     * @return PaymentLinkResource
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public PaymentLinkResource retrieve(String linkId) throws ApiException, IOException {
        Map<String, String> params = Collections.singletonMap(LINK_ID, linkId);
        String jsonResult = paymentLink.request(null, null, ApiConstants.HttpMethod.GET, params);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentLinkResource>() {
        }.getType());
    }

    /**
     * PATCH /paymentLinks API call
     *
     * @param linkId String
     * @return PaymentLinkResource
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public PaymentLinkResource update(String linkId, UpdatePaymentLinkRequest updatePaymentLinkRequest) throws ApiException, IOException {
        Map<String, String> params = Collections.singletonMap(LINK_ID, linkId);
        String jsonRequest = GSON.toJson(updatePaymentLinkRequest);
        String jsonResult = paymentLink.request(jsonRequest, null, ApiConstants.HttpMethod.PATCH, params);
        return GSON.fromJson(jsonResult, new TypeToken<PaymentLinkResource>() {
        }.getType());
    }
}
