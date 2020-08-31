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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.model.ThreeDSecureData;
import com.adyen.model.testcard.*;
import com.adyen.service.TestCardRanges;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import java.io.IOException;
import java.time.Month;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Tests for
 * /createTestCardRanges
 */
public class TestCardTest extends BaseTest {

    @Test
    public void testCreateTestCardRangesSuccess() throws IOException, ApiException {

        Client client = createMockClientFromFile("mocks/testcard/create-test-card-ranges-success.json");
        TestCardRanges testCard = new TestCardRanges(client);
        CreateTestCardRangesRequest request = createTestCardRangesRequest();

        CreateTestCardRangesResult result = testCard.createTestCardRanges(request);

        assertEquals(1, result.getRangeCreationResults().size());
        TestCardRangeCreationResult testCardRangeCreationResult = result.getRangeCreationResults().get(0).getTestCardRangeCreationResult();
        assertEquals(TestCardRangeCreationResult.CreationResult.ALREADY_EXISTS, testCardRangeCreationResult.getCreationResultCode());
        assertEquals("5232492669190772", testCardRangeCreationResult.getCardNumberRangeStart());
        assertEquals("5232492670020681", testCardRangeCreationResult.getCardNumberRangeEnd());
    }

    @Test
    public void testCreateTestCardRangesError() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/testcard/create-test-card-ranges-error.json");
        TestCardRanges testCard = new TestCardRanges(client);
        CreateTestCardRangesRequest request = new CreateTestCardRangesRequest();

        CreateTestCardRangesResult result = testCard.createTestCardRanges(request);

        assertNull(result.getRangeCreationResults());
    }

    private CreateTestCardRangesRequest createTestCardRangesRequest() {
        CreateTestCardRangesRequest request = new CreateTestCardRangesRequest();
        request.setAccountCode("TestMerchant");
        request.setAccountTypeCode(CreateTestCardRangesRequest.AccountTypeCode.MerchantAccount);

        TestCardRange range = new TestCardRange();
        range.setRangeStart("5232492669190772");
        range.setRangeEnd("5232492670020681");
        range.setCvc("123");
        range.setCardHolderName("S Hopper");
        range.setThreeDUserName("simonhopper");
        range.setThreeDPassword("mypassword");
        range.setThreeDDirectoryServerResponse(ThreeDSecureData.DirectoryResponseEnum.Y);

        ExpiryDate expiryDate = new ExpiryDate();
        expiryDate.setExpiryMonth(Month.DECEMBER);
        expiryDate.setExpiryYear("2020");
        range.setExpiryDates(Collections.singletonList(expiryDate));

        AvsAddress avsAddress = new AvsAddress();
        avsAddress.setStreetAddress("1 Infinite Loop, Cupertino");
        avsAddress.setZip("CA 95014");
        range.setAddress(avsAddress);

        request.setTestCardRanges(Collections.singletonList(range));

        return request;
    }
}
