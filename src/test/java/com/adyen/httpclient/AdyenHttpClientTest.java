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
 * Copyright (c) 2022 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.httpclient;

import com.adyen.Client;
import com.adyen.Config;
import com.adyen.constants.ApiConstants;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AdyenHttpClientTest {

    @Mock
    private CloseableHttpClient closeableHttpClient;

    @Mock
    private RequestHook requestHook;

    @Mock
    private ResponseHook responseHook;

    @Mock
    private AdyenResponse adyenResponse;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testRequestResponseHook() throws HTTPClientException, IOException {

        when(closeableHttpClient.execute(any(), any(AdyenResponseHandler.class))).thenReturn(adyenResponse);
        when(adyenResponse.getStatus()).thenReturn(200);
        Config config = new Config();
        AdyenRequest adyenRequest = new AdyenRequest();
        adyenRequest.setEndpoint(Client.ENDPOINT_TEST);
        adyenRequest.setHttpMethod(ApiConstants.HttpMethod.GET);

        Map<Config, CloseableHttpClient> httpClientMap = new ConcurrentHashMap<>();
        httpClientMap.put(config, closeableHttpClient);
        AdyenHttpClient adyenHttpClient = new AdyenHttpClient(httpClientMap);

        adyenHttpClient.addRequestHook(requestHook);
        adyenHttpClient.addResponseHook(responseHook);
        adyenHttpClient.request(adyenRequest, config);

        verify(requestHook).Run(adyenRequest);
        verify(responseHook).Run(adyenResponse);

    }

}
