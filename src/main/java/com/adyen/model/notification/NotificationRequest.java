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

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

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
        List<NotificationRequestItem> notificationRequestItems = new ArrayList<>();
        for(NotificationRequestItemContainer container: this.notificationItemContainers) {
            notificationRequestItems.add(container.getNotificationItem());
        }

        return notificationRequestItems;
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
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
