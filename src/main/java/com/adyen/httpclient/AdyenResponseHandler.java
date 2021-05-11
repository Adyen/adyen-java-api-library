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

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdyenResponseHandler implements ResponseHandler<AdyenResponse> {

    @Override
    public AdyenResponse handleResponse(HttpResponse httpResponse) throws IOException {
        AdyenResponse adyenResponse = new AdyenResponse();
        adyenResponse.setStatus(httpResponse.getStatusLine().getStatusCode());
        adyenResponse.setHeaders(getHeaders(httpResponse.getAllHeaders()));

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