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

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * NotificationEventConfiguration
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-26T07:34:47.963Z")
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
        if (o == null || getClass() != o.getClass()) {
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
        sb.append("class NotificationEventConfigurationContainer {\n");

        sb.append("    notificationEventConfiguration: ").append(toIndentedString(notificationEventConfiguration)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

