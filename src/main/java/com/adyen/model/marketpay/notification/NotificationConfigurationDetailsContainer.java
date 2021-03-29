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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.marketpay.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

public class NotificationConfigurationDetailsContainer {


    @SerializedName("NotificationConfigurationDetails")
    @JsonProperty("NotificationConfigurationDetails")
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
        if (o == null || getClass() != o.getClass()) {
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
        sb.append("class NotificationConfigurationDetailsContainer {\n");

        sb.append("    notificationConfigurationDetails: ").append(toIndentedString(notificationConfigurationDetails)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
