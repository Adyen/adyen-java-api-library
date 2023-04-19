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
 * GetNotificationConfigurationResponse
 */
public class GetNotificationConfigurationResponse extends GenericResponse {
    @SerializedName("configurationDetails")
    private NotificationConfigurationDetails configurationDetails = null;

    public GetNotificationConfigurationResponse configurationDetails(NotificationConfigurationDetails configurationDetails) {
        this.configurationDetails = configurationDetails;
        return this;
    }

    /**
     * notification configuration details
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
        GetNotificationConfigurationResponse getNotificationConfigurationResponse = (GetNotificationConfigurationResponse) o;
        return Objects.equals(this.configurationDetails, getNotificationConfigurationResponse.configurationDetails) &&
                Objects.equals(this.getInvalidFields(), getNotificationConfigurationResponse.getInvalidFields()) &&
                Objects.equals(this.getPspReference(), getNotificationConfigurationResponse.getPspReference()) &&
                Objects.equals(this.getResultCode(), getNotificationConfigurationResponse.getResultCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(configurationDetails, getInvalidFields(), getPspReference(), getResultCode());
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetNotificationConfigurationResponse {\n");

        sb.append("    configurationDetails: ").append(toIndentedString(configurationDetails)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(getInvalidFields())).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(getPspReference())).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(getResultCode())).append("\n");
        sb.append("}");
        return sb.toString();
    }


}

