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
