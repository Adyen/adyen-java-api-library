/**
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
import com.adyen.model.notification.NotificationRequest;
import com.adyen.model.notification.NotificationRequestItem;
import com.adyen.notification.NotificationHandler;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests notification messages
 */
public class NotificationTest extends BaseTest {
    @Test
    public void testAuthorisationSuccess() throws Exception {
        String json = getFileContents("mocks/notification/authorisation-true.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        NotificationRequest notificationRequest = notificationHandler.handleNotificationJson(json);

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_AUTHORISATION, notificationRequestItem.getEventCode());
        assertTrue(notificationRequestItem.isSuccess());
        assertEquals("123456789", notificationRequestItem.getPspReference());
    }

    @Test
    public void testCaptureSuccess() throws Exception {
        String json = getFileContents("mocks/notification/capture-true.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        NotificationRequest notificationRequest = notificationHandler.handleNotificationJson(json);

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_CAPTURE, notificationRequestItem.getEventCode());
        assertTrue(notificationRequestItem.isSuccess());
        assertEquals("PSP_REFERENCE", notificationRequestItem.getPspReference());
        assertEquals("ORIGINAL_PSP", notificationRequestItem.getOriginalReference());
    }

    @Test
    public void testCaptureFail() throws Exception {
        String json = getFileContents("mocks/notification/capture-false.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        NotificationRequest notificationRequest = notificationHandler.handleNotificationJson(json);

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_CAPTURE, notificationRequestItem.getEventCode());
        assertFalse(notificationRequestItem.isSuccess());
        assertEquals("PSP_REFERENCE", notificationRequestItem.getPspReference());
        assertEquals("ORIGINAL_PSP", notificationRequestItem.getOriginalReference());
    }

    @Test
    public void testRefundSuccess() throws Exception {
        String json = getFileContents("mocks/notification/refund-true.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        NotificationRequest notificationRequest = notificationHandler.handleNotificationJson(json);

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
        String json = getFileContents("mocks/notification/refund-false.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        NotificationRequest notificationRequest = notificationHandler.handleNotificationJson(json);

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_REFUND, notificationRequestItem.getEventCode());
        assertFalse(notificationRequestItem.isSuccess());
        assertEquals("PSP_REFERENCE", notificationRequestItem.getPspReference());
        assertEquals("ORIGINAL_PSP", notificationRequestItem.getOriginalReference());
        assertNotNull(notificationRequestItem.getEventDate());
    }
}
