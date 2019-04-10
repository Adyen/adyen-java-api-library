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
package com.adyen;

import com.adyen.model.applicationinfo.ApplicationInfo;
import com.adyen.model.checkout.PaymentsRequest;
import org.junit.Test;

import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PaymentsRequestTest {

    @Test
    public void TestDefaultApplicationInfoAdyenLibrary() {
        PaymentsRequest paymentsRequest = new PaymentsRequest();

        assertNotNull(paymentsRequest.getApplicationInfo());
        assertNotNull(paymentsRequest.getApplicationInfo().getAdyenLibrary());
        assertNotNull(paymentsRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertEquals(LIB_NAME, paymentsRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertNotNull(paymentsRequest.getApplicationInfo().getAdyenLibrary().getVersion());
        assertEquals(LIB_VERSION, paymentsRequest.getApplicationInfo().getAdyenLibrary().getVersion());
    }

    @Test
    public void TestCustomApplicationInfoAdyenLibrary() {
        PaymentsRequest paymentsRequest = new PaymentsRequest();
        ApplicationInfo applicationInfo = new ApplicationInfo();
        paymentsRequest.setApplicationInfo(applicationInfo);

        assertNotNull(paymentsRequest.getApplicationInfo());
        assertNotNull(paymentsRequest.getApplicationInfo().getAdyenLibrary());
        assertNotNull(paymentsRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertEquals(LIB_NAME, paymentsRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertNotNull(paymentsRequest.getApplicationInfo().getAdyenLibrary().getVersion());
        assertEquals(LIB_VERSION, paymentsRequest.getApplicationInfo().getAdyenLibrary().getVersion());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestNullApplicationInfoAdyenLibrary() {
        PaymentsRequest paymentsRequest = new PaymentsRequest();
        paymentsRequest.setApplicationInfo(null);
    }
}