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

package com.adyen;

import com.adyen.model.PaymentResult;
import com.google.gson.Gson;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PaymentResultTest extends BaseTest {

    @Test
    public void TestAuthenticationFinishedResultCodeDeserialization() {
        Gson gson = new Gson();
        String response = "{\"resultCode\": \"AuthenticationFinished\"}";
        PaymentResult result = gson.fromJson(response, PaymentResult.class);
        assertNotNull(result.getResultCode());
    }
}