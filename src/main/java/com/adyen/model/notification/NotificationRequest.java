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
package com.adyen.model.notification;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.adyen.util.Util.toIndentedString;

/**
 * NotificationRequest model class
 */
public class NotificationRequest {
    @SerializedName("live")
    private String live = null;

    @SerializedName("notificationItems")
    private List<NotificationRequestItemContainer> notificationItemContainers = null;

    public String getLive() {
        return live;
    }

    public NotificationRequest setLive(String live) {
        this.live = live;
        return this;
    }

    @JsonProperty("notificationItems")
    public List<NotificationRequestItemContainer> getNotificationItemContainers() {
        return notificationItemContainers;
    }

    @JsonProperty("notificationItems")
    public void setNotificationItemContainers(List<NotificationRequestItemContainer> notificationItemContainers) {
        this.notificationItemContainers = notificationItemContainers;
    }

    
    public List<NotificationRequestItem> getNotificationItems() {
        if (notificationItemContainers == null) {
            return null;
        }
        return notificationItemContainers.stream().map(s -> s.getNotificationItem()).collect(Collectors.toList());
    }

    public void setNotificationItems(List<NotificationRequestItem> notificationItems) {
        notificationItemContainers = new ArrayList<NotificationRequestItemContainer>();
        for(NotificationRequestItem requestItem: notificationItems) {
            NotificationRequestItemContainer requestItemContainer = new NotificationRequestItemContainer();
            requestItemContainer.setNotificationItem(requestItem);
            notificationItemContainers.add(requestItemContainer);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotificationRequestItem {\n");

        sb.append("    live: ").append(toIndentedString(live)).append("\n");
        sb.append("    notificationItems: ").append(toIndentedString(notificationItemContainers)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Create an instance of NotificationRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of NotificationRequest
     * @throws IOException if the JSON string is invalid with respect to NotificationRequest
     */
    public static NotificationRequest fromJson(String jsonString) throws IOException {
        return new Gson().fromJson(jsonString, NotificationRequest.class);
    }

    /**
     * Convert an instance of NotificationRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return new Gson().toJson(this);
    }
}
