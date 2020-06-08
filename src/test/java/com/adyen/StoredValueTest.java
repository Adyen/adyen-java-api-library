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

import com.adyen.model.Amount;
import com.adyen.model.binlookup.*;
import com.adyen.model.checkout.DefaultPaymentMethodDetails;
import com.adyen.model.storedvalue.StoredValueIssueRequest;
import com.adyen.model.storedvalue.StoredValueIssueResponse;
import com.adyen.model.storedvalue.StoredValueStatusChangeRequest;
import com.adyen.model.storedvalue.StoredValueStatusChangeResponse;
import com.adyen.service.BinLookup;
import com.adyen.service.StoredValue;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for
 * todo
 */
public class StoredValueTest extends BaseTest {


    @Test
    public void TestIssueSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/storedvalue/issue-success.json");
        StoredValue storedValue = new StoredValue(client);

        StoredValueIssueRequest storedValueIssueRequest = new StoredValueIssueRequest();
        storedValueIssueRequest.setMerchantAccount("merchantAccount");
        storedValueIssueRequest.setReference("issueReference");
        storedValueIssueRequest.setPaymentMethod(new DefaultPaymentMethodDetails().type("givex"));

        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(1000L);

        storedValueIssueRequest.setAmount(amount);

        StoredValueIssueResponse storedValueIssueResponse = storedValue.issue(storedValueIssueRequest);
        assertEquals("EUR", storedValueIssueResponse.getCurrentBalance().getCurrency());
        assertEquals(new Long(1000), storedValueIssueResponse.getCurrentBalance().getValue());
        assertEquals("851591622730873A", storedValueIssueResponse.getPspReference());
        assertEquals(StoredValueIssueResponse.ResultCodeEnum.SUCCESS, storedValueIssueResponse.getResultCode());
        assertEquals("6036280000000000000", storedValueIssueResponse.getPaymentMethod().get("number"));
        assertEquals("givex", storedValueIssueResponse.getPaymentMethod().get("type"));
    }

    @Test
    public void TestChangeStatusActiveSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/storedvalue/change-status-active-success.json");
        StoredValue storedValue = new StoredValue(client);

        StoredValueStatusChangeRequest storedValueStatusChangeRequest = new StoredValueStatusChangeRequest();
        storedValueStatusChangeRequest.setStatus(StoredValueStatusChangeRequest.StatusEnum.ACTIVE);

        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(1000L);

        storedValueStatusChangeRequest.setAmount(amount);
        storedValueStatusChangeRequest.setMerchantAccount("merchantAccount");
        storedValueStatusChangeRequest.setPaymentMethod(new DefaultPaymentMethodDetails().type("givex").number("6036280000000000000").securityCode("1111"));
        storedValueStatusChangeRequest.setReference("changeStatusReference");

        StoredValueStatusChangeResponse storedValueStatusChangeResponse = storedValue.changeStatus(storedValueStatusChangeRequest);
        assertEquals("EUR", storedValueStatusChangeResponse.getCurrentBalance().getCurrency());
        assertEquals(new Long(1000), storedValueStatusChangeResponse.getCurrentBalance().getValue());
        assertEquals("851591629631298F", storedValueStatusChangeResponse.getPspReference());
        assertEquals(StoredValueStatusChangeResponse.ResultCodeEnum.SUCCESS, storedValueStatusChangeResponse.getResultCode());
        assertEquals("123456", storedValueStatusChangeResponse.getAuthCode());
    }



    }