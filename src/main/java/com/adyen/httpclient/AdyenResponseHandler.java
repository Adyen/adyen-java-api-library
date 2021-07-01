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
package com.adyen.httpclient;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdyenResponseHandler implements HttpClientResponseHandler<AdyenResponse> {

    @Override
    public AdyenResponse handleResponse(ClassicHttpResponse httpResponse) throws IOException, ParseException {
        AdyenResponse adyenResponse = new AdyenResponse();
        adyenResponse.setStatus(httpResponse.getCode());
        adyenResponse.setHeaders(getHeaders(httpResponse.getHeaders()));

        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            adyenResponse.setBody(EntityUtils.toString(entity));
        }
        return adyenResponse;
    }

    private Map<String, List<String>> getHeaders(Header[] allHeaders) {
        Map<String, List<String>> headers = new HashMap<>();
        for (Header header : allHeaders) {
            headers.put(header.getName(), Collections.singletonList(header.getValue()));
        }
        return headers;
    }
}