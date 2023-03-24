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

import com.adyen.model.nexo.DeviceType;
import com.adyen.model.nexo.DisplayOutput;
import com.adyen.model.nexo.DisplayRequest;
import com.adyen.model.nexo.DisplayResponse;
import com.adyen.model.nexo.EventNotification;
import com.adyen.model.nexo.EventToNotifyType;
import com.adyen.model.nexo.InfoQualifyType;
import com.adyen.model.notification.Amount;
import com.adyen.model.notification.NotificationRequest;
import com.adyen.model.notification.NotificationRequestItem;
import com.adyen.model.notification.NotificationRequestItemContainer;
import com.adyen.model.terminal.TerminalAPIRequest;
import com.adyen.model.terminal.TerminalAPIResponse;
import com.adyen.notification.NotificationHandler;
import com.adyen.service.TerminalCloudAPI;
import com.adyen.terminal.serialization.TerminalAPIGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

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
        assertEquals(Long.valueOf(27211), notificationRequestItem.getAmount().getValue());

        assertNotNull(notificationRequestItem.getEventDate());
    }

    @Test
    public void testTerminalDisplayNotification() throws Exception {
        String json = getFileContents("mocks/notification/display-notification.json");
        TerminalAPIRequest notification = notificationHandler.handleTerminalNotificationJson(json);
        DisplayOutput displayOutput = notification.getSaleToPOIRequest().getDisplayRequest().getDisplayOutput().get(0);

        assertEquals(InfoQualifyType.STATUS, displayOutput.getInfoQualify());
        assertEquals(DeviceType.CASHIER_DISPLAY, displayOutput.getDevice());
        assertEquals(false, displayOutput.isResponseRequiredFlag());
    }

    @Test
    public void testTerminalEventNotification() throws Exception {
        String json = getFileContents("mocks/notification/event-notification.json");
        TerminalAPIRequest notification = notificationHandler.handleTerminalNotificationJson(json);
        EventNotification eventNotification = notification.getSaleToPOIRequest().getEventNotification();

        assertEquals("newstate=IDLE&oldstate=START", eventNotification.getEventDetails());
        assertEquals(EventToNotifyType.SHUTDOWN, eventNotification.getEventToNotify());
    }

    @Test
    public void testSetNotificationItem() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/authorisation-true.json");
        assertEquals("123456789", notificationRequest.getNotificationItems().get(0).getPspReference());
        NotificationRequestItem requestItem = new NotificationRequestItem();
        requestItem.setPspReference("987654321");
        ArrayList<NotificationRequestItem> notificationRequestItems = new ArrayList<NotificationRequestItem>();
        notificationRequestItems.add(requestItem);
        notificationRequest.setNotificationItems(notificationRequestItems);

        assertEquals(1, notificationRequest.getNotificationItems().size());
        assertEquals("987654321", notificationRequest.getNotificationItems().get(0).getPspReference());
    }

    private void assertJsonStringEquals(String firstInput, String secondInput) {
        JsonParser parser = new JsonParser();
        assertEquals(parser.parse(firstInput), parser.parse(secondInput));
    }

    private NotificationRequest readNotificationRequestFromFile(String resourcePath) throws IOException {
        String json = getFileContents(resourcePath);
        return notificationHandler.handleNotificationJson(json);
    }
}
