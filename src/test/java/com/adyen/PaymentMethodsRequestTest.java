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
import com.adyen.model.checkout.PaymentMethodsRequest;
import org.junit.Test;

import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PaymentMethodsRequestTest {

    @Test
    public void TestDefaultApplicationInfoAdyenLibrary() {
        PaymentMethodsRequest paymentMethodsRequest = new PaymentMethodsRequest();

        assertNotNull(paymentMethodsRequest.getApplicationInfo());
        assertNotNull(paymentMethodsRequest.getApplicationInfo().getAdyenLibrary());
        assertNotNull(paymentMethodsRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertEquals(LIB_NAME, paymentMethodsRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertNotNull(paymentMethodsRequest.getApplicationInfo().getAdyenLibrary().getVersion());
        assertEquals(LIB_VERSION, paymentMethodsRequest.getApplicationInfo().getAdyenLibrary().getVersion());
    }

    @Test
    public void TestCustomApplicationInfoAdyenLibrary() {
        PaymentMethodsRequest paymentMethodsRequest = new PaymentMethodsRequest();
        ApplicationInfo applicationInfo = new ApplicationInfo();
        paymentMethodsRequest.setApplicationInfo(applicationInfo);

        assertNotNull(paymentMethodsRequest.getApplicationInfo());
        assertNotNull(paymentMethodsRequest.getApplicationInfo().getAdyenLibrary());
        assertNotNull(paymentMethodsRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertEquals(LIB_NAME, paymentMethodsRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertNotNull(paymentMethodsRequest.getApplicationInfo().getAdyenLibrary().getVersion());
        assertEquals(LIB_VERSION, paymentMethodsRequest.getApplicationInfo().getAdyenLibrary().getVersion());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestNullApplicationInfoAdyenLibrary() {
        PaymentMethodsRequest paymentMethodsRequest = new PaymentMethodsRequest();
        paymentMethodsRequest.setApplicationInfo(null);
    }
}