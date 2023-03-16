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

import com.adyen.deserializer.MarketPayNotificationMessageDeserializer;
import com.adyen.model.marketpay.notification.GenericNotification;
import com.adyen.model.notification.NotificationRequest;
import com.adyen.model.terminal.TerminalAPIRequest;
import com.adyen.terminal.serialization.TerminalAPIGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Notification converter
 */
public class NotificationHandler {
    private static final Gson GSON = new Gson();
    private final Gson marketPayGson;
    private final Gson terminalGson;

    public NotificationHandler() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(GenericNotification.class, new MarketPayNotificationMessageDeserializer());
        marketPayGson = gsonBuilder.create();
        terminalGson = TerminalAPIGsonBuilder.create();
    }

    public NotificationRequest handleNotificationJson(String json) {
        return GSON.fromJson(json, new TypeToken<NotificationRequest>() {
        }.getType());
    }

    public GenericNotification handleMarketpayNotificationJson(String json) {
        return marketPayGson.fromJson(json, GenericNotification.class);
    }

    // Note that terminal notifications are structured as TerminalAPIRequest objects
    public TerminalAPIRequest handleTerminalNotificationJson(String json) {
        return terminalGson.fromJson(json, new TypeToken<TerminalAPIRequest>() {
        }.getType());
    }
}
