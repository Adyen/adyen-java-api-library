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
 * CreateNotificationConfigurationRequest
 */
public class CreateNotificationConfigurationRequest {
    @SerializedName("configurationDetails")
    private NotificationConfigurationDetails configurationDetails = null;

    public CreateNotificationConfigurationRequest configurationDetails(NotificationConfigurationDetails configurationDetails) {
        this.configurationDetails = configurationDetails;
        return this;
    }

    /**
     * details of notification configuration to be created
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
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        CreateNotificationConfigurationRequest createNotificationConfigurationRequest = (CreateNotificationConfigurationRequest) o;
        return Objects.equals(this.configurationDetails, createNotificationConfigurationRequest.configurationDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(configurationDetails);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateNotificationConfigurationRequest {").append(TextConstants.LINE_BREAK);

        sb.append("    configurationDetails: ").append(Util.toIndentedString(configurationDetails)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }
}

