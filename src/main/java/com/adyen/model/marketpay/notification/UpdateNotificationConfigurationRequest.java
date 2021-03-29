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

import com.google.gson.annotations.SerializedName;

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * UpdateNotificationConfigurationRequest
 */
public class UpdateNotificationConfigurationRequest {
    @SerializedName("configurationDetails")
    private NotificationConfigurationDetails configurationDetails = null;

    public UpdateNotificationConfigurationRequest configurationDetails(NotificationConfigurationDetails configurationDetails) {
        this.configurationDetails = configurationDetails;
        return this;
    }

    /**
     * details of notification configuration to be updated
     *
     * @return configurationDetails
     **/
    public NotificationConfigurationDetails getConfigurationDetails() {
        return configurationDetails;
    }

    public void setConfigurationDetails(NotificationConfigurationDetails configurationDetails) {
        this.configurationDetails = configurationDetails;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateNotificationConfigurationRequest updateNotificationConfigurationRequest = (UpdateNotificationConfigurationRequest) o;
        return Objects.equals(this.configurationDetails, updateNotificationConfigurationRequest.configurationDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(configurationDetails);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateNotificationConfigurationRequest {\n");

        sb.append("    configurationDetails: ").append(toIndentedString(configurationDetails)).append("\n");
        sb.append("}");
        return sb.toString();
    }


}

