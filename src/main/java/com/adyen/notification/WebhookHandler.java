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
package com.adyen.notification;

import com.adyen.model.notification.NotificationRequest;
import com.adyen.model.payout.JSON;
import com.adyen.model.terminal.TerminalAPIRequest;
import com.adyen.terminal.serialization.TerminalAPIGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

/**
 * Notification converter
 */
public class WebhookHandler {
    private static final Gson GSON = new Gson();
    private final Gson terminalGson;

    public WebhookHandler() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        terminalGson = TerminalAPIGsonBuilder.create();
    }

    public NotificationRequest handleNotificationJson(String json) throws IOException {
        return NotificationRequest.fromJson(json);
    }

    public NotificationRequest handleNotificationJsonJackson(String json) throws IOException {
        return JSON.getMapper().readValue(json, NotificationRequest.class);
    }

    // Note that terminal notifications are structured as TerminalAPIRequest objects
    public TerminalAPIRequest handleTerminalNotificationJson(String json) {
        return terminalGson.fromJson(json, new TypeToken<TerminalAPIRequest>() {
        }.getType());
    }
}
