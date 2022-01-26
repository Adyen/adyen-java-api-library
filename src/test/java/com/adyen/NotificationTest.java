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

import com.adyen.model.Amount;
import com.adyen.model.notification.NotificationRequest;
import com.adyen.model.notification.NotificationRequestItem;
import com.adyen.model.notification.NotificationRequestItemContainer;
import com.adyen.notification.NotificationHandler;
import com.google.gson.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests notification messages
 */
public class NotificationTest extends BaseTest {

    private NotificationHandler notificationHandler;

    @Before
    public void init() {
        notificationHandler = new NotificationHandler();
    }

    @Test
    public void testAuthorisationSuccess() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/authorisation-true.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_AUTHORISATION, notificationRequestItem.getEventCode());
        assertTrue(notificationRequestItem.isSuccess());
        assertEquals("123456789", notificationRequestItem.getPspReference());
    }

    @Test
    public void testCaptureSuccess() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/capture-true.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_CAPTURE, notificationRequestItem.getEventCode());
        assertTrue(notificationRequestItem.isSuccess());
        assertEquals("PSP_REFERENCE", notificationRequestItem.getPspReference());
        assertEquals("ORIGINAL_PSP", notificationRequestItem.getOriginalReference());
    }

    @Test
    public void testCaptureFail() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/capture-false.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_CAPTURE, notificationRequestItem.getEventCode());
        assertFalse(notificationRequestItem.isSuccess());
        assertEquals("PSP_REFERENCE", notificationRequestItem.getPspReference());
        assertEquals("ORIGINAL_PSP", notificationRequestItem.getOriginalReference());
    }

    @Test
    public void testRefundSuccess() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/refund-true.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_REFUND, notificationRequestItem.getEventCode());
        assertTrue(notificationRequestItem.isSuccess());
        assertEquals("PSP_REFERENCE", notificationRequestItem.getPspReference());
        assertEquals("ORIGINAL_PSP", notificationRequestItem.getOriginalReference());
        assertNotNull(notificationRequestItem.getEventDate());
    }

    @Test
    public void testRefundFail() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/refund-false.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_REFUND, notificationRequestItem.getEventCode());
        assertFalse(notificationRequestItem.isSuccess());
        assertEquals("PSP_REFERENCE", notificationRequestItem.getPspReference());
        assertEquals("ORIGINAL_PSP", notificationRequestItem.getOriginalReference());
        assertNotNull(notificationRequestItem.getEventDate());
    }

    @Test
    public void testChargeback() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/chargeback.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_CHARGEBACK, notificationRequestItem.getEventCode());
        assertTrue(notificationRequestItem.isSuccess());
        assertEquals("9915555555555555", notificationRequestItem.getPspReference());
        assertEquals("9913333333333333", notificationRequestItem.getOriginalReference());
        assertNotNull(notificationRequestItem.getAmount());
        assertEquals("EUR", notificationRequestItem.getAmount().getCurrency());
        assertEquals(new Long(1000), notificationRequestItem.getAmount().getValue());

        assertNotNull(notificationRequestItem.getEventDate());
    }

    @Test
    public void testAuthorisationAdjustmentTrue() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/chargeback.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_CHARGEBACK, notificationRequestItem.getEventCode());
        assertTrue(notificationRequestItem.isSuccess());
        assertEquals("9915555555555555", notificationRequestItem.getPspReference());
        assertEquals("9913333333333333", notificationRequestItem.getOriginalReference());
        assertNotNull(notificationRequestItem.getAmount());
        assertEquals("EUR", notificationRequestItem.getAmount().getCurrency());
        assertEquals(new Long(1000), notificationRequestItem.getAmount().getValue());

        assertNotNull(notificationRequestItem.getEventDate());
    }

    @Test
    public void testCancellationTrue() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/cancellation-true.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_CANCELLATION, notificationRequestItem.getEventCode());
        assertTrue(notificationRequestItem.isSuccess());
        assertEquals("8412534564722331", notificationRequestItem.getPspReference());
        assertEquals("8313547924770610", notificationRequestItem.getOriginalReference());
        assertNotNull(notificationRequestItem.getAmount());
        assertEquals("EUR", notificationRequestItem.getAmount().getCurrency());
        assertEquals(new Long(500), notificationRequestItem.getAmount().getValue());

        assertNotNull(notificationRequestItem.getEventDate());
    }

    @Test
    public void testOfferClosed() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/offer-closed.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_OFFER_CLOSED, notificationRequestItem.getEventCode());
        assertTrue(notificationRequestItem.isSuccess());
        assertEquals("8532565401975321", notificationRequestItem.getPspReference());
        assertEquals("ideal", notificationRequestItem.getPaymentMethod());
        assertNotNull(notificationRequestItem.getAmount());
        assertEquals("EUR", notificationRequestItem.getAmount().getCurrency());
        assertEquals(new Long(27211), notificationRequestItem.getAmount().getValue());

        assertNotNull(notificationRequestItem.getEventDate());
    }

    @Test
    public void testGsonAndJacksonSerializeNotificationRequest() throws JsonProcessingException {
        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setLive("live");
        NotificationRequestItemContainer notificationContainer = new NotificationRequestItemContainer();
        NotificationRequestItem notificationRequestItem = new NotificationRequestItem();
        notificationRequestItem.setAmount(new Amount());
        notificationRequestItem.setEventCode("eventcode");
        notificationContainer.setNotificationItem(notificationRequestItem);
        notificationRequest.setNotificationItemContainers(Collections.singletonList(notificationContainer));

        String gson = GSON.toJson(notificationRequest);
        String jackson = OBJECT_MAPPER.writeValueAsString(notificationRequest);

        assertJsonStringEquals(jackson, gson);
    }

    private void assertJsonStringEquals(String firstInput, String secondInput) {
        JsonParser parser = new JsonParser();
        assertEquals(parser.parse(firstInput), parser.parse(secondInput));
    }

    private NotificationRequest readNotificationRequestFromFile(String resourcePath) {
        String json = getFileContents(resourcePath);
        return notificationHandler.handleNotificationJson(json);
    }
}
