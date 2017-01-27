package com.adyen.model.notification;

import com.google.gson.annotations.SerializedName;

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
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
