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

/**
 * NotificationEventConfiguration
 */
public class NotificationEventConfigurationContainer {
    @SerializedName("NotificationEventConfiguration")
    NotificationEventConfiguration notificationEventConfiguration = new NotificationEventConfiguration();

    public NotificationEventConfiguration getNotificationEventConfiguration() {
        return notificationEventConfiguration;
    }

    public void setNotificationEventConfiguration(NotificationEventConfiguration notificationEventConfiguration) {
        this.notificationEventConfiguration = notificationEventConfiguration;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        NotificationEventConfigurationContainer notificationEventConfigurationContainer = (NotificationEventConfigurationContainer) o;
        return Objects.equals(this.notificationEventConfiguration, notificationEventConfigurationContainer.notificationEventConfiguration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationEventConfiguration);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotificationEventConfigurationContainer {").append(TextConstants.LINE_BREAK);

        sb.append("    notificationEventConfiguration: ").append(Util.toIndentedString(notificationEventConfiguration)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}

