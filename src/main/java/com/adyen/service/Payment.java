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
import com.adyen.model.PaymentRequest;
import com.adyen.model.PaymentRequest3d;
import com.adyen.model.PaymentResult;
import com.adyen.model.RequestOptions;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.payment.Authorise;
import com.adyen.service.resource.payment.Authorise3D;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Payment extends Service {

    private Authorise authorise;
    private Authorise3D authorise3D;

    public Payment(Client client) {
        super(client);

        authorise = new Authorise(this);
        authorise3D = new Authorise3D(this);
    }

    /**
     * POST /authorise API call
     *
     * @param paymentRequest
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
     * @param paymentRequest3d
     * @return
     * @throws Exception
     */
    public PaymentResult authorise3D(PaymentRequest3d paymentRequest3d) throws Exception {
        String jsonRequest = GSON.toJson(paymentRequest3d);

        String jsonResult = authorise3D.request(jsonRequest);

        PaymentResult paymentResult = GSON.fromJson(jsonResult, new TypeToken<PaymentResult>() {
        }.getType());

        return paymentResult;
    }
}
