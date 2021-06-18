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

package com.adyen.service.management;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.management.AllowedOrigin;
import com.adyen.model.management.AllowedOriginsResponse;
import com.adyen.model.management.ApiCredential;
import com.adyen.model.management.CreateAllowedOriginRequest;
import com.adyen.service.Resource;
import com.adyen.service.exception.ApiException;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class Me extends Service {

    private final Resource me;
    private final Resource allowedOrigin;
    private final Resource allowedOrigins;

    public Me(Client client) {
        super(client);
        String baseMeEndpoint = String.format("%s/%s/me", client.getConfig().getManagementEndpoint(), Client.MANAGEMENT_API_VERSION);
        this.me = new Resource(this, baseMeEndpoint, null);
        this.allowedOrigin = new Resource(this, String.format("%s/allowedOrigins/{%s}", baseMeEndpoint, ApiConstants.ManagementAPI.ORIGIN_ID), null);
        this.allowedOrigins = new Resource(this, String.format("%s/allowedOrigins", baseMeEndpoint), null);
    }

    public ApiCredential retrieveMe() throws IOException, ApiException {
        String jsonResult = me.request(null, null, ApiConstants.HttpMethod.GET, null);
        return GSON.fromJson(jsonResult, new TypeToken<ApiCredential>() {
        }.getType());
    }

    public AllowedOriginsResponse listAllowedOrigins() throws IOException, ApiException {
        String jsonResult = allowedOrigins.request(null, null, ApiConstants.HttpMethod.GET, null);
        return GSON.fromJson(jsonResult, new TypeToken<AllowedOriginsResponse>() {
        }.getType());
    }

    public AllowedOrigin retrieveAllowedOrigin(String originId) throws IOException, ApiException {
        Map<String, String> params = Collections.singletonMap(ApiConstants.ManagementAPI.ORIGIN_ID, originId);
        String jsonResult = allowedOrigin.request(null, null, ApiConstants.HttpMethod.GET, params);
        return GSON.fromJson(jsonResult, new TypeToken<com.adyen.model.management.AllowedOrigin>() {
        }.getType());
    }

    public void deleteAllowedOrigin(String originId) throws IOException, ApiException {
        Map<String, String> params = Collections.singletonMap(ApiConstants.ManagementAPI.ORIGIN_ID, originId);
        allowedOrigin.request(null, null, ApiConstants.HttpMethod.DELETE, params);
    }

    public AllowedOrigin createAllowedOrigin(String domain) throws IOException, ApiException {
        CreateAllowedOriginRequest createAllowedOriginRequest = new CreateAllowedOriginRequest();
        createAllowedOriginRequest.setDomain(domain);
        String jsonResult = allowedOrigins.request(GSON.toJson(createAllowedOriginRequest), null, ApiConstants.HttpMethod.POST, null);
        return GSON.fromJson(jsonResult, new TypeToken<com.adyen.model.management.AllowedOrigin>() {
        }.getType());
    }
}
