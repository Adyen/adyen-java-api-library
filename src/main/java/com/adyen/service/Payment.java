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
import com.adyen.model.PaymentRequest;
import com.adyen.model.PaymentRequest3d;
import com.adyen.model.PaymentRequest3ds2;
import com.adyen.model.PaymentResult;
import com.adyen.model.RequestOptions;
import com.adyen.model.ThreeDS2ResultRequest;
import com.adyen.model.ThreeDS2ResultResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.payment.Authorise;
import com.adyen.service.resource.payment.Authorise3D;
import com.adyen.service.resource.payment.Authorise3DS2;
import com.adyen.service.resource.payment.Retrieve3DS2Result;
import com.google.gson.reflect.TypeToken;

public class Payment extends Service {

    private Authorise authorise;
    private Authorise3D authorise3D;
    private Authorise3DS2 authorise3DS;
    private Retrieve3DS2Result retrieve3DS2Result;

    public Payment(Client client) {
        super(client);

        authorise = new Authorise(this);
        authorise3D = new Authorise3D(this);
        authorise3DS = new Authorise3DS2(this);
        retrieve3DS2Result = new Retrieve3DS2Result(this);
    }

    /**
     * POST /authorise API call
     *
     * @param paymentRequest paymentRequest
     * @return PaymentResult
     * @throws ApiException ApiException
     * @throws IOException  IOException
     */
    public PaymentResult authorise(PaymentRequest paymentRequest) throws ApiException, IOException {
        return authorise(paymentRequest, null);
    }

    public PaymentResult authorise(PaymentRequest paymentRequest, RequestOptions requestOptions) throws ApiException, IOException {
        String jsonRequest = GSON.toJson(paymentRequest);
        String jsonResult = authorise.request(jsonRequest, requestOptions);
        PaymentResult paymentResult = GSON.fromJson(jsonResult, new TypeToken<PaymentResult>() {
        }.getType());

        return paymentResult;
    }

    /**
     * POST /authorise3d API call
     *
     * @param paymentRequest3d authorise3D
     * @return PaymentResult
     * @throws Exception Exception
     */
    public PaymentResult authorise3D(PaymentRequest3d paymentRequest3d) throws Exception {
        String jsonRequest = GSON.toJson(paymentRequest3d);

        String jsonResult = authorise3D.request(jsonRequest);

        PaymentResult paymentResult = GSON.fromJson(jsonResult, new TypeToken<PaymentResult>() {
        }.getType());

        return paymentResult;
    }

    /**
     * POST /authorise3ds2 API call
     *
     * @param paymentRequest3ds2 PaymentRequest3ds2
     * @return PaymentResult
     * @throws Exception Exception
     */
    public PaymentResult authorise3DS2(PaymentRequest3ds2 paymentRequest3ds2) throws Exception {
        String jsonRequest = GSON.toJson(paymentRequest3ds2);

        String jsonResult = authorise3DS.request(jsonRequest);

        PaymentResult paymentResult = GSON.fromJson(jsonResult, new TypeToken<PaymentResult>() {
        }.getType());

        return paymentResult;
    }

    /**
     * POST /retrieve3ds2Result API call
     *
     * @param threeDS2ResultRequest PaymentRequest3ds2
     * @return PaymentResult
     * @throws Exception Exception
     */
    public ThreeDS2ResultResponse retrieve3ds2Result(ThreeDS2ResultRequest threeDS2ResultRequest) throws Exception {
        String jsonRequest = GSON.toJson(threeDS2ResultRequest);

        String jsonResult = retrieve3DS2Result.request(jsonRequest);

        ThreeDS2ResultResponse threeDS2ResultResponse = GSON.fromJson(jsonResult, new TypeToken<ThreeDS2ResultResponse>() {
        }.getType());

        return threeDS2ResultResponse;
    }
}
