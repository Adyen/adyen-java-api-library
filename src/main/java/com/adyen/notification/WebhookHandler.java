package com.adyen.notification;

import com.adyen.model.notification.NotificationRequest;
import com.adyen.model.payout.JSON;
import com.adyen.terminal.TerminalAPIRequest;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

/**
 * Notification converter
 */
public class WebhookHandler {
    public WebhookHandler() {
    }

    public NotificationRequest handleNotificationJson(String json) throws IOException {
        return NotificationRequest.fromJson(json);
    }

    public NotificationRequest handleNotificationJsonJackson(String json) throws IOException {
        return JSON.getMapper().readValue(json, NotificationRequest.class);
    }

    // Note that terminal notifications are structured as TerminalAPIRequest objects
    public TerminalAPIRequest handleTerminalNotificationJson(String json) throws JsonProcessingException {
        return TerminalAPIRequest.fromJson(json);
    }
}
