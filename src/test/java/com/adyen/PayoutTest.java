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

import org.junit.Test;
import com.adyen.model.payout.ModifyRequest;
import com.adyen.model.payout.ModifyResponse;
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

        ModifyRequest request = new ModifyRequest();
        ModifyResponse result = payout.confirmThirdParty(request);

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

        ModifyRequest request = new ModifyRequest();
        ModifyResponse result = payout.declineThirdParty(request);

        assertEquals("[payout-confirm-received]", result.getResponse());
        assertEquals("8815131762537886", result.getPspReference());
    }
}
