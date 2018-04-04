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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service;

import java.io.IOException;
import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.payout.ConfirmThirdPartyRequest;
import com.adyen.model.payout.ConfirmThirdPartyResponse;
import com.adyen.model.payout.DeclineThirdPartyRequest;
import com.adyen.model.payout.DeclineThirdPartyResponse;
import com.adyen.model.payout.ModifyRequest;
import com.adyen.model.payout.ModifyResponse;
import com.adyen.model.payout.StoreDetailAndSubmitRequest;
import com.adyen.model.payout.StoreDetailAndSubmitResponse;
import com.adyen.model.payout.StoreDetailRequest;
import com.adyen.model.payout.StoreDetailResponse;
import com.adyen.model.payout.SubmitRequest;
import com.adyen.model.payout.SubmitResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.payout.ConfirmThirdParty;
import com.adyen.service.resource.payout.DeclineThirdParty;
import com.adyen.service.resource.payout.StoreDetail;
import com.adyen.service.resource.payout.StoreDetailAndSubmitThirdParty;
import com.adyen.service.resource.payout.SubmitThirdParty;
import com.google.gson.reflect.TypeToken;

public class Payout extends Service {
    private StoreDetailAndSubmitThirdParty storeDetailAndSubmitThirdParty;
    private ConfirmThirdParty confirmThirdParty;
    private DeclineThirdParty declineThirdParty;
    private StoreDetail storeDetail;
    private SubmitThirdParty submitThirdparty;

    public Payout(Client client) {
        super(client);

        storeDetailAndSubmitThirdParty = new StoreDetailAndSubmitThirdParty(this);
        confirmThirdParty = new ConfirmThirdParty(this);
        declineThirdParty = new DeclineThirdParty(this);
        storeDetail = new StoreDetail(this);
        submitThirdparty = new SubmitThirdParty(this);
    }

    /**
     * Issues a storeDetailAndSubmitThirdParty API call
     *
     * @param request
     * @return
     * @throws IOException
     * @throws ApiException
     */
    public StoreDetailAndSubmitResponse storeDetailAndSubmitThirdParty(StoreDetailAndSubmitRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);

        String jsonResult = storeDetailAndSubmitThirdParty.request(jsonRequest);

        StoreDetailAndSubmitResponse result = GSON.fromJson(jsonResult, new TypeToken<StoreDetailAndSubmitResponse>() {
        }.getType());
        return result;
    }

    /**
     * Issues a ConfirmThirdParty API call
     *
     * @param request
     * @return
     * @throws IOException
     * @throws ApiException
     */
    public ConfirmThirdPartyResponse confirmThirdParty(ConfirmThirdPartyRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);

        String jsonResult = confirmThirdParty.request(jsonRequest);

        ConfirmThirdPartyResponse result = GSON.fromJson(jsonResult, new TypeToken<ConfirmThirdPartyResponse>() {
        }.getType());
        return result;
    }

    /**
     * Issues a DeclineThirdParty API call
     *
     * @param request
     * @return
     * @throws IOException
     * @throws ApiException
     */
    public DeclineThirdPartyResponse declineThirdParty(DeclineThirdPartyRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);

        String jsonResult = declineThirdParty.request(jsonRequest);

        DeclineThirdPartyResponse result = GSON.fromJson(jsonResult, new TypeToken<DeclineThirdPartyResponse>() {
        }.getType());
        return result;
    }

    /**
     * Issues a storeDetail API call
     *
     * @param request
     * @return
     * @throws IOException
     * @throws ApiException
     */
    public StoreDetailResponse storeDetail(StoreDetailRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);

        String jsonResult = storeDetail.request(jsonRequest);

        StoreDetailResponse result = GSON.fromJson(jsonResult, new TypeToken<StoreDetailResponse>() {
        }.getType());
        return result;
    }

    /**
     * Issues a SubmitThirdParty API call
     *
     * @param request
     * @return
     * @throws IOException
     * @throws ApiException
     */
    public SubmitResponse submitThirdparty(SubmitRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);

        String jsonResult = submitThirdparty.request(jsonRequest);

        SubmitResponse result = GSON.fromJson(jsonResult, new TypeToken<SubmitResponse>() {
        }.getType());
        return result;
    }
}
