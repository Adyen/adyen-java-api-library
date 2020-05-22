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

import static com.adyen.constants.TextConstants.LINE_BREAK;
import static com.adyen.util.Util.toIndentedString;

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
        sb.append("class NotificationRequestItemContainer {").append(LINE_BREAK);

        sb.append("    notificationItem: ").append(toIndentedString(notificationItem)).append(LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }


}
