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

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.RequestOptions;
import com.adyen.model.payout.JSON;
import com.adyen.model.payout.ModifyRequest;
import com.adyen.model.payout.ModifyResponse;
import com.adyen.model.payout.PayoutRequest;
import com.adyen.model.payout.PayoutResponse;
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

import java.io.IOException;

public class Payout extends Service {
    private final StoreDetailAndSubmitThirdParty storeDetailAndSubmitThirdParty;
    private final ConfirmThirdParty confirmThirdParty;
    private final DeclineThirdParty declineThirdParty;
    private final StoreDetail storeDetail;
    private final SubmitThirdParty submitThirdparty;
    private final com.adyen.service.resource.payout.Payout payout;

    public Payout(Client client) {
        super(client);

        storeDetailAndSubmitThirdParty = new StoreDetailAndSubmitThirdParty(this);
        confirmThirdParty = new ConfirmThirdParty(this);
        declineThirdParty = new DeclineThirdParty(this);
        storeDetail = new StoreDetail(this);
        submitThirdparty = new SubmitThirdParty(this);
        payout = new com.adyen.service.resource.payout.Payout(this);
        new JSON();
    }

    /**
     * Issues a storeDetailAndSubmitThirdParty API call
     *
     * @param request StoreDetailAndSubmitRequest
     * @return StoreDetailAndSubmitResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public StoreDetailAndSubmitResponse storeDetailAndSubmitThirdParty(StoreDetailAndSubmitRequest request) throws IOException, ApiException {
        return storeDetailAndSubmitThirdParty(request, null);
    }

    /**
     * Issues a storeDetailAndSubmitThirdParty API call
     *
     * @param request StoreDetailAndSubmitRequest
     * @param requestOptions RequestOptions
     * @return StoreDetailAndSubmitResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public StoreDetailAndSubmitResponse storeDetailAndSubmitThirdParty(StoreDetailAndSubmitRequest request, RequestOptions requestOptions) throws IOException, ApiException {
        String jsonRequest = request.toJson();

        String jsonResult = storeDetailAndSubmitThirdParty.request(jsonRequest, requestOptions);

        return StoreDetailAndSubmitResponse.fromJson(jsonResult);
    }

    /**
     * Issues a ConfirmThirdParty API call
     *
     * @param request ConfirmThirdPartyRequest
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public ModifyResponse confirmThirdParty(ModifyRequest request) throws IOException, ApiException {
        String jsonRequest = request.toJson();

        String jsonResult = confirmThirdParty.request(jsonRequest);

        return ModifyResponse.fromJson(jsonResult);
    }

    /**
     * Issues a DeclineThirdParty API call
     *
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public ModifyResponse declineThirdParty(ModifyRequest request) throws IOException, ApiException {
        String jsonRequest = request.toJson();

        String jsonResult = declineThirdParty.request(jsonRequest);

        return ModifyResponse.fromJson(jsonResult);
    }

    /**
     * Issues a storeDetail API call
     *
     * @param request StoreDetailRequest
     * @return StoreDetailResponse
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public StoreDetailResponse storeDetail(StoreDetailRequest request) throws IOException, ApiException {
        String jsonRequest = request.toJson();

        String jsonResult = storeDetail.request(jsonRequest);

        return StoreDetailResponse.fromJson(jsonResult);
    }

    /**
     * Issues a SubmitThirdParty API call
     *
     * @param request SubmitRequest
     * @return submitThirdparty
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public SubmitResponse submitThirdparty(SubmitRequest request) throws IOException, ApiException {
        String jsonRequest = request.toJson();

        String jsonResult = submitThirdparty.request(jsonRequest);

        return SubmitResponse.fromJson(jsonResult);
    }

    /**
     * Issues a payout API call
     *
     * @param request
     * @return
     * @throws IOException
     * @throws ApiException
     */
    public PayoutResponse payout(PayoutRequest request) throws IOException, ApiException {
        return payout(request, null);
    }

    /**
     * Issues a payout API call
     *
     * @param request
     * @param requestOptions
     * @return
     * @throws IOException
     * @throws ApiException
     */
    public PayoutResponse payout(PayoutRequest request, RequestOptions requestOptions) throws IOException, ApiException {
        String jsonRequest = request.toJson();

        String jsonResult = payout.request(jsonRequest, requestOptions);

        return PayoutResponse.fromJson(jsonResult);
    }
}
