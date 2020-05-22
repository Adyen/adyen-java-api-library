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
package com.adyen.model.notification;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Container for NotificationRequestItem
 */
public class NotificationRequestItemContainer {
    @SerializedName("NotificationRequestItem")
    private NotificationRequestItem notificationItem = null;

    public NotificationRequestItem getNotificationItem() {
        return notificationItem;
    }

    public void setNotificationItem(NotificationRequestItem notificationItem) {
        this.notificationItem = notificationItem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotificationRequestItemContainer {\n");

        sb.append("    notificationItem: ").append(toIndentedString(notificationItem)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (Objects.isNull(o)) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
