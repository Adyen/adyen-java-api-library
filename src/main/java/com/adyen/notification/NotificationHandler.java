package com.adyen.notification;

import com.adyen.model.notification.NotificationRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Notification converter
 */
public class NotificationHandler {
    public NotificationRequest handleNotificationJson(String json) {
        Gson gson = new Gson();

        NotificationRequest notificationRequest = gson.fromJson(json, new TypeToken<NotificationRequest>() {
        }.getType());

        return notificationRequest;
    }
}
