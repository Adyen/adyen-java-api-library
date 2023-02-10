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

import com.adyen.model.terminal.ConnectedTerminalsRequest;
import com.adyen.model.terminal.ConnectedTerminalsResponse;
import com.adyen.service.PosPayment;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PosPaymentTest extends BaseTest {

    @Test
    public void testConnectedTerminalsSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/pos/connectedTerminals-success.json");
        PosPayment posPayment = new PosPayment(client);

        ConnectedTerminalsRequest request = new ConnectedTerminalsRequest();
        ConnectedTerminalsResponse result = posPayment.connectedTerminals(request);

        assertEquals(2, result.getUniqueTerminalIds().size());
    }

    @Test
    public void testConnectedTerminalsErrorInvalidMerchant() throws Exception {
        Client client = createMockClientForErrors(403, "mocks/pos/connectedTerminals-error-403.json");
        PosPayment posPayment = new PosPayment(client);

        ConnectedTerminalsRequest request = new ConnectedTerminalsRequest();

        try {
            posPayment.connectedTerminals(request);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getResponseBody());
            assertTrue(e.getResponseBody().contains("901"));
            assertEquals(403, e.getStatusCode());
        }
    }

    @Test
    public void testConnectedTerminalsErrorMissingMerchant() throws Exception {
        Client client = createMockClientForErrors(500, "mocks/pos/connectedTerminals-error-500.json");
        PosPayment posPayment = new PosPayment(client);

        ConnectedTerminalsRequest request = new ConnectedTerminalsRequest();

        try {
            posPayment.connectedTerminals(request);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getResponseBody());
            assertTrue(e.getResponseBody().contains("702"));
            assertEquals(500, e.getStatusCode());
        }
    }
}
