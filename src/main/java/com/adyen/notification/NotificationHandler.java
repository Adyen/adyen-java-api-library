package com.adyen.notification;

import com.adyen.model.notification.NotificationRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Notification converter
 */
public class NotificationHandler {
    public NotificationRequest handleNotificationJson(String json) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Gson gson = gsonBuilder.create();

        NotificationRequest notificationRequest = gson.fromJson(json, new TypeToken<NotificationRequest>() {
        }.getType());

        return notificationRequest;
    }
}
