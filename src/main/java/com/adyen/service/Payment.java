/**
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

import java.util.HashMap;
import java.util.Map;
import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.PaymentRequest;
import com.adyen.model.PaymentRequest3d;
import com.adyen.model.PaymentResult;
import com.adyen.service.resource.payment.Authorise;
import com.adyen.service.resource.payment.Authorise3D;
import com.google.gson.reflect.TypeToken;

public class Payment extends Service {

    private Authorise authorise;
    private Authorise3D authorise3D;

    public Payment(Client client) {
        super(client);

        authorise = new Authorise(this);
        authorise3D = new Authorise3D(this);
    }

    public Map<String, Object> authorise(Map<String, Object> params) throws Exception {
        return authorise.request(params);
    }

    public Map<String, Object> authorise(String json) throws Exception {

        // convert to Map<String, Object>
        Map<String, Object> params = GSON.fromJson(json, new TypeToken<HashMap<String, Object>>() {
        }.getType());

        return authorise.request(params);
    }


    public Map<String, Object> authorise3D(Map<String, Object> params) throws Exception {
        return authorise3D.request(params);
    }

    /**
     * POST /authorise API call
     *
     * @param paymentRequest
     * @return
     * @throws Exception
     */
    public PaymentResult authorise(PaymentRequest paymentRequest) throws Exception {
        String jsonRequest = GSON.toJson(paymentRequest);

        String jsonResult = authorise.request(jsonRequest);

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
