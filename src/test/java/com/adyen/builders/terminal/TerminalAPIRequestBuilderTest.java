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

package com.adyen.builders.terminal;

import com.adyen.model.nexo.MessageCategoryType;
import com.adyen.model.nexo.MessageClassType;
import com.adyen.model.nexo.PaymentRequest;
import com.adyen.model.nexo.TransactionStatusRequest;
import com.adyen.model.terminal.TerminalAPIRequest;
import com.adyen.builders.terminal.TerminalAPIRequestBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class TerminalAPIRequestBuilderTest {

    private TerminalAPIRequestBuilder terminalAPIRequestBuilder;

    @Mock
    private PaymentRequest paymentRequest;
    @Mock
    private TransactionStatusRequest transactionStatusRequest;

    private final String SALE_ID = "test-sale-id";
    private final String SERVICE_ID = "test-service-id";
    private final String POI_ID = "test-poi";

    @Before
    public void setUp() {
        terminalAPIRequestBuilder = new TerminalAPIRequestBuilder(SALE_ID, SERVICE_ID, POI_ID);
    }

    @Test
    public void testPaymentRequest() {
        TerminalAPIRequest terminalAPIRequest = terminalAPIRequestBuilder.withPaymentRequest(paymentRequest).build();

        assertNotNull(terminalAPIRequest);
        assertNotNull(terminalAPIRequest.getSaleToPOIRequest());
        assertNotNull(terminalAPIRequest.getSaleToPOIRequest().getMessageHeader());
        assertEquals(SALE_ID, terminalAPIRequest.getSaleToPOIRequest().getMessageHeader().getSaleID());
        assertEquals(SERVICE_ID, terminalAPIRequest.getSaleToPOIRequest().getMessageHeader().getServiceID());
        assertEquals(POI_ID, terminalAPIRequest.getSaleToPOIRequest().getMessageHeader().getPOIID());
        assertEquals(MessageClassType.SERVICE, terminalAPIRequest.getSaleToPOIRequest().getMessageHeader().getMessageClass());
        assertEquals(MessageCategoryType.PAYMENT, terminalAPIRequest.getSaleToPOIRequest().getMessageHeader().getMessageCategory());
        assertNotNull(terminalAPIRequest.getSaleToPOIRequest().getPaymentRequest());
    }

    @Test
    public void testMultipleRequestObjects() {
        TerminalAPIRequest terminalAPIRequest = terminalAPIRequestBuilder
                .withTransactionStatusRequest(transactionStatusRequest)
                .withPaymentRequest(paymentRequest)
                .build();

        assertNotNull(terminalAPIRequest);
        assertNotNull(terminalAPIRequest.getSaleToPOIRequest());
        assertNotNull(terminalAPIRequest.getSaleToPOIRequest().getMessageHeader());
        assertEquals(SALE_ID, terminalAPIRequest.getSaleToPOIRequest().getMessageHeader().getSaleID());
        assertEquals(SERVICE_ID, terminalAPIRequest.getSaleToPOIRequest().getMessageHeader().getServiceID());
        assertEquals(POI_ID, terminalAPIRequest.getSaleToPOIRequest().getMessageHeader().getPOIID());
        assertEquals(MessageClassType.SERVICE, terminalAPIRequest.getSaleToPOIRequest().getMessageHeader().getMessageClass());
        assertEquals(MessageCategoryType.PAYMENT, terminalAPIRequest.getSaleToPOIRequest().getMessageHeader().getMessageCategory());
        assertNotNull(terminalAPIRequest.getSaleToPOIRequest().getPaymentRequest());
        assertNull(terminalAPIRequest.getSaleToPOIRequest().getTransactionStatusRequest());
    }

    @Test
    public void testNoRequest() {
        TerminalAPIRequest terminalAPIRequest = terminalAPIRequestBuilder.build();

        assertNotNull(terminalAPIRequest);
        assertNotNull(terminalAPIRequest.getSaleToPOIRequest());
        assertNotNull(terminalAPIRequest.getSaleToPOIRequest().getMessageHeader());
        assertEquals(SALE_ID, terminalAPIRequest.getSaleToPOIRequest().getMessageHeader().getSaleID());
        assertEquals(SERVICE_ID, terminalAPIRequest.getSaleToPOIRequest().getMessageHeader().getServiceID());
        assertEquals(POI_ID, terminalAPIRequest.getSaleToPOIRequest().getMessageHeader().getPOIID());
        assertNull(terminalAPIRequest.getSaleToPOIRequest().getMessageHeader().getMessageClass());
        assertNull(terminalAPIRequest.getSaleToPOIRequest().getMessageHeader().getMessageCategory());
    }
}
