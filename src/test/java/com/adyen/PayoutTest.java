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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.model.payout.PayoutRequest;
import com.adyen.model.payout.PayoutResponse;
import com.adyen.service.exception.ApiException;
import org.junit.Test;
import com.adyen.model.payout.ConfirmThirdPartyRequest;
import com.adyen.model.payout.ConfirmThirdPartyResponse;
import com.adyen.model.payout.DeclineThirdPartyRequest;
import com.adyen.model.payout.DeclineThirdPartyResponse;
import com.adyen.model.payout.StoreDetailAndSubmitRequest;
import com.adyen.model.payout.StoreDetailAndSubmitResponse;
import com.adyen.model.payout.StoreDetailRequest;
import com.adyen.model.payout.StoreDetailResponse;
import com.adyen.model.payout.SubmitRequest;
import com.adyen.model.payout.SubmitResponse;
import com.adyen.service.Payout;
import static com.adyen.constants.ApiConstants.AdditionalData.FRAUD_MANUAL_REVIEW;
import static com.adyen.constants.ApiConstants.AdditionalData.FRAUD_RESULT_TYPE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

public class PayoutTest extends BaseTest {

    @Test
    public void testStoreDetailAndSubmitThirdPartySuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/payout/storeDetailAndSubmitThirdParty-success.json");
        Payout payout = new Payout(client);

        StoreDetailAndSubmitRequest request = new StoreDetailAndSubmitRequest();
        StoreDetailAndSubmitResponse result = payout.storeDetailAndSubmitThirdParty(request);

        assertEquals("[payout-submit-received]", result.getResultCode());
        assertEquals("8515131751004933", result.getPspReference());
        assertEquals("GREEN", result.getAdditionalData().get(FRAUD_RESULT_TYPE));
        assertEquals("false", result.getAdditionalData().get(FRAUD_MANUAL_REVIEW));
    }

    @Test
    public void testStoreDetailSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/payout/storeDetail-success.json");
        Payout payout = new Payout(client);

        StoreDetailRequest request = new StoreDetailRequest();
        StoreDetailResponse result = payout.storeDetail(request);

        assertEquals("Success", result.getResultCode());
        assertEquals("8515136787207087", result.getPspReference());
        assertEquals("8415088571022720", result.getRecurringDetailReference());
    }

    @Test
    public void testConfirmThirdPartySuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/payout/modifyResponse-success.json");
        Payout payout = new Payout(client);

        ConfirmThirdPartyRequest request = new ConfirmThirdPartyRequest();
        ConfirmThirdPartyResponse result = payout.confirmThirdParty(request);

        assertEquals("[payout-confirm-received]", result.getResponse());
        assertEquals("8815131762537886", result.getPspReference());
    }

    @Test
    public void testSubmitThirdPartySuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/payout/submitResponse-success.json");
        Payout payout = new Payout(client);

        SubmitRequest request = new SubmitRequest();
        SubmitResponse result = payout.submitThirdparty(request);

        assertEquals("[payout-submit-received]", result.getResultCode());
        assertEquals("8815131768219992", result.getPspReference());
        assertEquals("GREEN", result.getAdditionalData().get(FRAUD_RESULT_TYPE));
        assertEquals("false", result.getAdditionalData().get(FRAUD_MANUAL_REVIEW));
    }

    @Test
    public void testDeclineThirdPartySuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/payout/modifyResponse-success.json");
        Payout payout = new Payout(client);

        DeclineThirdPartyRequest request = new DeclineThirdPartyRequest();
        DeclineThirdPartyResponse result = payout.declineThirdParty(request);

        assertEquals("[payout-confirm-received]", result.getResponse());
        assertEquals("8815131762537886", result.getPspReference());
    }

    @Test
    public void testPayoutSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/payout/payout-success.json");
        Payout payout = new Payout(client);

        PayoutRequest request = new PayoutRequest();
        PayoutResponse result = payout.payout(request);

        assertEquals(PayoutResponse.ResultCodeEnum.AUTHORISED, result.getResultCode());
        assertEquals("8814689190961342", result.getPspReference());
        assertEquals("12345", result.getAuthCode());
    }

    @Test
    public void testPayoutErrorMerchant() throws Exception {
        Client client = createMockClientForErrors(403, "mocks/payout/payout-error-403.json");
        Payout payout = new Payout(client);

        PayoutRequest request = new PayoutRequest();

        try {
            payout.payout(request);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals("901", e.getError().getErrorCode());
            assertEquals(403, e.getError().getStatus());
        }
    }

    @Test
    public void testPayoutErrorReference() throws Exception {
        Client client = createMockClientForErrors(422, "mocks/payout/payout-error-422.json");
        Payout payout = new Payout(client);

        PayoutRequest request = new PayoutRequest();

        try {
            payout.payout(request);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals("130", e.getError().getErrorCode());
            assertEquals(422, e.getError().getStatus());
        }
    }
}
