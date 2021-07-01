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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.Config;
import com.adyen.httpclient.ClientInterface;
import com.adyen.model.RequestOptions;
import com.adyen.model.checkout.PaymentsRequest;
import com.adyen.model.checkout.PaymentsResponse;
import com.adyen.model.checkout.ThreeDSecureData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutTest extends BaseTest {
    @Mock
    Client client;

    @Mock
    ClientInterface clientInterface;

    @Mock
    Config config;

    @Test
    public void testPaymentsRequestWithXidAndCavv() throws Exception {
        when(client.getConfig()).thenReturn(config);
        when(config.getCheckoutEndpoint()).thenReturn("checkout");
        when(client.getHttpClient()).thenReturn(clientInterface);
        when(clientInterface.request(anyString(), anyString(), eq(config), anyBoolean(), nullable(RequestOptions.class), any())).thenReturn("{\"pspReference\": \"12345\"}");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        PaymentsRequest request = new PaymentsRequest();
        ThreeDSecureData mpiData = new ThreeDSecureData();
        mpiData.setXid("AQIDBAUGBwgJCgsMDQ4PEBESExQ=");
        mpiData.setCavv("AQIDBAUGBwgJCgsMDQ4PEBESExQ=");
        request.setMpiData(mpiData);
        PaymentsResponse response = new Checkout(client).payments(request);

        assertNotNull(response);
        assertEquals("12345", response.getPspReference());
        verify(clientInterface).request(anyString(), captor.capture(), any(Config.class), anyBoolean(), nullable(RequestOptions.class), any());
        //html escaped
        assertFalse(captor.getValue().contains("\"mpiData\":{\"cavv\":\"AQIDBAUGBwgJCgsMDQ4PEBESExQ\\u003d\",\"xid\":\"AQIDBAUGBwgJCgsMDQ4PEBESExQ\\u003d\"}"));
        //not html escaped
        assertTrue(captor.getValue().contains("\"mpiData\":{\"cavv\":\"AQIDBAUGBwgJCgsMDQ4PEBESExQ=\",\"xid\":\"AQIDBAUGBwgJCgsMDQ4PEBESExQ=\"}"));
    }
}
