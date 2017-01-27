package com.adyen;

import com.adyen.model.notification.NotificationRequest;
import com.adyen.model.notification.NotificationRequestItem;
import com.adyen.notification.NotificationHandler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
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
        assertEquals("8514853640987132", notificationRequestItem.getPspReference());
        assertEquals("7914853620991813", notificationRequestItem.getOriginalReference());
    }
}
