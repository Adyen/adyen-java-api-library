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

package com.adyen.model.marketpay.notification;

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class NotificationConfigurationDetailsContainer {


    @SerializedName("NotificationConfigurationDetails")
    NotificationConfigurationDetails notificationConfigurationDetails = new NotificationConfigurationDetails();


    public NotificationConfigurationDetails getNotificationConfigurationDetails() {
        return notificationConfigurationDetails;
    }

    public void setNotificationConfigurationDetails(NotificationConfigurationDetails notificationConfigurationDetails) {
        this.notificationConfigurationDetails = notificationConfigurationDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        NotificationConfigurationDetailsContainer notificationConfigurationDetailsContainer = (NotificationConfigurationDetailsContainer) o;
        return Objects.equals(this.notificationConfigurationDetails, notificationConfigurationDetailsContainer.notificationConfigurationDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationConfigurationDetails);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotificationConfigurationDetailsContainer {").append(TextConstants.LINE_BREAK);

        sb.append("    notificationConfigurationDetails: ").append(Util.toIndentedString(notificationConfigurationDetails)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }
}
