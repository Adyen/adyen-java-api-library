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
import com.adyen.model.checkout.PaymentSessionRequest;
import org.junit.Test;

import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PaymentSessionRequestTest {

    @Test
    public void TestDefaultApplicationInfoAdyenLibrary() {
        PaymentSessionRequest paymentSessionRequest = new PaymentSessionRequest();

        assertNotNull(paymentSessionRequest.getApplicationInfo());
        assertNotNull(paymentSessionRequest.getApplicationInfo().getAdyenLibrary());
        assertNotNull(paymentSessionRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertEquals(LIB_NAME, paymentSessionRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertNotNull(paymentSessionRequest.getApplicationInfo().getAdyenLibrary().getVersion());
        assertEquals(LIB_VERSION, paymentSessionRequest.getApplicationInfo().getAdyenLibrary().getVersion());
    }

    @Test
    public void TestCustomApplicationInfoAdyenLibrary() {
        PaymentSessionRequest paymentSessionRequest = new PaymentSessionRequest();
        ApplicationInfo applicationInfo = new ApplicationInfo();
        paymentSessionRequest.setApplicationInfo(applicationInfo);

        assertNotNull(paymentSessionRequest.getApplicationInfo());
        assertNotNull(paymentSessionRequest.getApplicationInfo().getAdyenLibrary());
        assertNotNull(paymentSessionRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertEquals(LIB_NAME, paymentSessionRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertNotNull(paymentSessionRequest.getApplicationInfo().getAdyenLibrary().getVersion());
        assertEquals(LIB_VERSION, paymentSessionRequest.getApplicationInfo().getAdyenLibrary().getVersion());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestNullApplicationInfoAdyenLibrary() {
        PaymentSessionRequest paymentSessionRequest = new PaymentSessionRequest();
        paymentSessionRequest.setApplicationInfo(null);
    }
}