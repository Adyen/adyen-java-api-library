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
import com.google.gson.reflect.TypeToken;
import java.io.IOException;

/**
 * Handler for Adyen webhooks. It provides methods to parse incoming JSON webhook payloads into Java
 * objects.
 */
public class WebhookHandler {
  private final Gson terminalGson;

  /** Initializes a new instance of the {@link WebhookHandler}. */
  public WebhookHandler() {
    terminalGson = TerminalAPIGsonBuilder.create();
  }

  /**
   * Deserializes a JSON string into a {@link NotificationRequest} object. This method uses Gson for
   * deserialization.
   *
   * @param json The JSON string to deserialize.
   * @return The deserialized {@link NotificationRequest}.
   * @throws IOException if the JSON string cannot be deserialized.
   */
  public NotificationRequest handleNotificationJson(String json) throws IOException {
    return NotificationRequest.fromJson(json);
  }

  /**
   * Deserializes a JSON string into a {@link NotificationRequest} object using Jackson.
   *
   * @param json The JSON string to deserialize.
   * @return The deserialized {@link NotificationRequest}.
   * @throws IOException if the JSON string cannot be deserialized.
   */
  public NotificationRequest handleNotificationJsonJackson(String json) throws IOException {
    return JSON.getMapper().readValue(json, NotificationRequest.class);
  }

  /**
   * Deserializes a terminal notification JSON string into a {@link TerminalAPIRequest} object. Note
   * that terminal notifications are structured as {@link TerminalAPIRequest} objects.
   *
   * @param json The JSON string to deserialize.
   * @return The deserialized {@link TerminalAPIRequest}.
   */
  public TerminalAPIRequest handleTerminalNotificationJson(String json) {
    return terminalGson.fromJson(json, new TypeToken<TerminalAPIRequest>() {}.getType());
  }
}
