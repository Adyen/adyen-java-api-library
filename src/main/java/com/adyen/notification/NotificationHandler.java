package com.adyen.notification;

import com.adyen.model.notification.NotificationRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Notification converter
 */
public class NotificationHandler {
	private static final Gson GSON = new Gson();
	
    public NotificationRequest handleNotificationJson(String json) {
        NotificationRequest notificationRequest = GSON.fromJson(json, new TypeToken<NotificationRequest>() {
        }.getType());

        return notificationRequest;
    }
}
