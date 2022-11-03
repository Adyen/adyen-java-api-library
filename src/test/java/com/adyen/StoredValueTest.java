///*
// *                       ######
// *                       ######
// * ############    ####( ######  #####. ######  ############   ############
// * #############  #####( ######  #####. ######  #############  #############
// *        ######  #####( ######  #####. ######  #####  ######  #####  ######
// * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
// * ###### ######  #####( ######  #####. ######  #####          #####  ######
// * #############  #############  #############  #############  #####  ######
// *  ############   ############  #############   ############  #####  ######
// *                                      ######
// *                               #############
// *                               ############
// *
// * Adyen Java API Library
// *
// * Copyright (c) 2020 Adyen B.V.
// * This file is open source and available under the MIT license.
// * See the LICENSE file for more info.
// */
//package com.adyen;
//
//import com.adyen.model.Amount;
//import com.adyen.model.checkout.CardDetails;
//import com.adyen.model.storedvalue.StoredValueBalanceCheckRequest;
//import com.adyen.model.storedvalue.StoredValueBalanceCheckResponse;
//import com.adyen.model.storedvalue.StoredValueBalanceMergeRequest;
//import com.adyen.model.storedvalue.StoredValueBalanceMergeResponse;
//import com.adyen.model.storedvalue.StoredValueIssueRequest;
//import com.adyen.model.storedvalue.StoredValueIssueResponse;
//import com.adyen.model.storedvalue.StoredValueLoadRequest;
//import com.adyen.model.storedvalue.StoredValueLoadResponse;
//import com.adyen.model.storedvalue.StoredValueStatusChangeRequest;
//import com.adyen.model.storedvalue.StoredValueStatusChangeResponse;
//import com.adyen.model.storedvalue.StoredValueVoidRequest;
//import com.adyen.model.storedvalue.StoredValueVoidResponse;
//import com.adyen.service.StoredValue;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
///**
// * Tests for
// * /issue
// * /changeStatus
// * /load
// * /checkBalance
// * /mergeBalance
// * /voidTransaction
// */
//public class StoredValueTest extends BaseTest {
//
//
//    @Test
//    public void testIssueSuccessMocked() throws Exception {
//        Client client = createMockClientFromFile("mocks/storedvalue/issue-success.json");
//        StoredValue storedValue = new StoredValue(client);
//
//        StoredValueIssueRequest storedValueIssueRequest = new StoredValueIssueRequest();
//        storedValueIssueRequest.setMerchantAccount("merchantAccount");
//        storedValueIssueRequest.setReference("issueReference");
//        storedValueIssueRequest.setPaymentMethod(new CardDetails().type(CardDetails.TypeEnum.GIFTCARD));
//
//        Amount amount = new Amount();
//        amount.setCurrency("EUR");
//        amount.setValue(1000L);
//
//        storedValueIssueRequest.setAmount(amount);
//
//        StoredValueIssueResponse storedValueIssueResponse = storedValue.issue(storedValueIssueRequest);
//        assertEquals("EUR", storedValueIssueResponse.getCurrentBalance().getCurrency());
//        assertEquals(new Long(1000), storedValueIssueResponse.getCurrentBalance().getValue());
//        assertEquals("851591622730873A", storedValueIssueResponse.getPspReference());
//        assertEquals(StoredValueIssueResponse.ResultCodeEnum.SUCCESS, storedValueIssueResponse.getResultCode());
//        assertEquals("6036280000000000000", storedValueIssueResponse.getPaymentMethod().get("number"));
//        assertEquals("givex", storedValueIssueResponse.getPaymentMethod().get("type"));
//    }
//
//    @Test
//    public void testChangeStatusActiveSuccessMocked() throws Exception {
//        Client client = createMockClientFromFile("mocks/storedvalue/change-status-active-success.json");
//        StoredValue storedValue = new StoredValue(client);
//
//        StoredValueStatusChangeRequest storedValueStatusChangeRequest = new StoredValueStatusChangeRequest();
//        storedValueStatusChangeRequest.setStatus(StoredValueStatusChangeRequest.StatusEnum.ACTIVE);
//
//        Amount amount = new Amount();
//        amount.setCurrency("EUR");
//        amount.setValue(1000L);
//
//        storedValueStatusChangeRequest.setAmount(amount);
//        storedValueStatusChangeRequest.setMerchantAccount("merchantAccount");
//        storedValueStatusChangeRequest.setPaymentMethod(new CardDetails().type("givex").number("6036280000000000000").cvc("1111"));
//        storedValueStatusChangeRequest.setReference("changeStatusReference");
//
//        StoredValueStatusChangeResponse storedValueStatusChangeResponse = storedValue.changeStatus(storedValueStatusChangeRequest);
//        assertEquals("EUR", storedValueStatusChangeResponse.getCurrentBalance().getCurrency());
//        assertEquals(new Long(1000), storedValueStatusChangeResponse.getCurrentBalance().getValue());
//        assertEquals("851591629631298F", storedValueStatusChangeResponse.getPspReference());
//        assertEquals(StoredValueStatusChangeResponse.ResultCodeEnum.SUCCESS, storedValueStatusChangeResponse.getResultCode());
//        assertEquals("123456", storedValueStatusChangeResponse.getAuthCode());
//    }
//
//    @Test
//    public void testLoadSuccessMocked() throws Exception {
//        Client client = createMockClientFromFile("mocks/storedvalue/load-success.json");
//        StoredValue storedValue = new StoredValue(client);
//
//        StoredValueLoadRequest storedValueLoadRequest = new StoredValueLoadRequest();
//
//        Amount amount = new Amount();
//        amount.setCurrency("EUR");
//        amount.setValue(2000L);
//
//        storedValueLoadRequest.setAmount(amount);
//        storedValueLoadRequest.setLoadType(StoredValueLoadRequest.LoadTypeEnum.MERCHANDISERETURN);
//        storedValueLoadRequest.setMerchantAccount("merchantAccount");
//        storedValueLoadRequest.setPaymentMethod(new CardDetails().type("givex").number("603628672882001915092").cvc("5754"));
//        storedValueLoadRequest.setReference("loadReference");
//
//        StoredValueLoadResponse storedValueLoadResponse = storedValue.load(storedValueLoadRequest);
//        assertEquals("EUR", storedValueLoadResponse.getCurrentBalance().getCurrency());
//        assertEquals(new Long(1001999), storedValueLoadResponse.getCurrentBalance().getValue());
//        assertEquals("881591686892740H", storedValueLoadResponse.getPspReference());
//        assertEquals(StoredValueLoadResponse.ResultCodeEnum.SUCCESS, storedValueLoadResponse.getResultCode());
//        assertEquals("123456", storedValueLoadResponse.getAuthCode());
//    }
//
//    @Test
//    public void testCheckBalanceSuccessMocked() throws Exception {
//        Client client = createMockClientFromFile("mocks/storedvalue/check-balance-success.json");
//        StoredValue storedValue = new StoredValue(client);
//
//        StoredValueBalanceCheckRequest storedValueBalanceCheckRequest = new StoredValueBalanceCheckRequest();
//        storedValueBalanceCheckRequest.setMerchantAccount("merchantAccount");
//        storedValueBalanceCheckRequest.setPaymentMethod(new CardDetails().type("givex").number("603628672882001915092").cvc("5754"));
//        storedValueBalanceCheckRequest.setReference("checkBalanceReference");
//
//        StoredValueBalanceCheckResponse storedValueBalanceCheckResponse = storedValue.checkBalance(storedValueBalanceCheckRequest);
//        assertEquals("EUR", storedValueBalanceCheckResponse.getCurrentBalance().getCurrency());
//        assertEquals(new Long(999999), storedValueBalanceCheckResponse.getCurrentBalance().getValue());
//        assertEquals("851591688783359H", storedValueBalanceCheckResponse.getPspReference());
//        assertEquals(StoredValueBalanceCheckResponse.ResultCodeEnum.SUCCESS, storedValueBalanceCheckResponse.getResultCode());
//    }
//
//    @Test
//    public void testMergeBalanceSuccessMocked() throws Exception {
//        Client client = createMockClientFromFile("mocks/storedvalue/merge-balance-success.json");
//        StoredValue storedValue = new StoredValue(client);
//
//        StoredValueBalanceMergeRequest storedValueBalanceMergeRequest = new StoredValueBalanceMergeRequest();
//        storedValueBalanceMergeRequest.setMerchantAccount("merchantAccount");
//        storedValueBalanceMergeRequest.setSourcePaymentMethod(new CardDetails().number("7777182708544835").cvc("2329"));
//        storedValueBalanceMergeRequest.setPaymentMethod(new CardDetails().type("valuelink").number("8888182708544836").cvc("2330"));
//        storedValueBalanceMergeRequest.setReference("mergeBalanceReference");
//
//        StoredValueBalanceMergeResponse storedValueBalanceMergeResponse = storedValue.mergeBalance(storedValueBalanceMergeRequest);
//        assertEquals("EUR", storedValueBalanceMergeResponse.getCurrentBalance().getCurrency());
//        assertEquals(new Long(5600), storedValueBalanceMergeResponse.getCurrentBalance().getValue());
//        assertEquals("881564657480267D", storedValueBalanceMergeResponse.getPspReference());
//        assertEquals(StoredValueBalanceMergeResponse.ResultCodeEnum.SUCCESS, storedValueBalanceMergeResponse.getResultCode());
//    }
//
//    @Test
//    public void testVoidTransactionSuccessMocked() throws Exception {
//        Client client = createMockClientFromFile("mocks/storedvalue/void-transaction-success.json");
//        StoredValue storedValue = new StoredValue(client);
//
//        StoredValueVoidRequest storedValueVoidRequest = new StoredValueVoidRequest();
//        storedValueVoidRequest.setMerchantAccount("merchantAccount");
//        storedValueVoidRequest.setOriginalReference("originalReference");
//        storedValueVoidRequest.setReference("mergeBalanceReference");
//
//        StoredValueVoidResponse storedValueVoidResponse = storedValue.voidTransaction(storedValueVoidRequest);
//        assertEquals("EUR", storedValueVoidResponse.getCurrentBalance().getCurrency());
//        assertEquals(new Long(999999), storedValueVoidResponse.getCurrentBalance().getValue());
//        assertEquals("851591692895398C", storedValueVoidResponse.getPspReference());
//        assertEquals(StoredValueVoidResponse.ResultCodeEnum.SUCCESS, storedValueVoidResponse.getResultCode());
//    }
//
//
//}
