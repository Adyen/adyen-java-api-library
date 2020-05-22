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

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<NotificationRequestItemContainer> getNotificationItemContainers() {
        return notificationItemContainers;
    }

    public void setNotificationItemContainers(List<NotificationRequestItemContainer> notificationItemContainers) {
        this.notificationItemContainers = notificationItemContainers;
    }

    public List<NotificationRequestItem> getNotificationItems() {
        if (this.notificationItemContainers == null) {
            return null;
        }
        return notificationItemContainers.stream().map(s -> s.getNotificationItem()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotificationRequestItem {").append(TextConstants.LINE_BREAK);

        sb.append("    live: ").append(Util.toIndentedString(live)).append(TextConstants.LINE_BREAK);
        sb.append("    notificationItems: ").append(Util.toIndentedString(notificationItemContainers)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }
}
