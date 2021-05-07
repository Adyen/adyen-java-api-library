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

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


import static com.adyen.util.Util.toIndentedString;

/**
 * GetNotificationConfigurationListResponse
 */
public class GetNotificationConfigurationListResponse extends GenericResponse {
    @SerializedName("configurations")
    private List<NotificationConfigurationDetails> configurations = null;

    private GetNotificationConfigurationListResponse configurations(List<NotificationConfigurationDetails> configurations) {
        this.configurations = configurations;
        return this;
    }

    /**
     * Populate the virtual configurations to bypass the notificationConfigurationDetails list
     *
     * @return configurations
     **/
    public List<NotificationConfigurationDetails> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<NotificationConfigurationDetails> configurations) {
        this.configurations = configurations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetNotificationConfigurationListResponse getNotificationConfigurationListResponse = (GetNotificationConfigurationListResponse) o;
        return Objects.equals(this.configurations, getNotificationConfigurationListResponse.configurations)
                && Objects.equals(this.getInvalidFields(), getNotificationConfigurationListResponse.getInvalidFields())
                && Objects.equals(this.getPspReference(), getNotificationConfigurationListResponse.getPspReference())
                && Objects.equals(this.getResultCode(), getNotificationConfigurationListResponse.getResultCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(configurations, getInvalidFields(), getPspReference(), getResultCode());
    }


    @Override
    public String toString() {
        // Populate the configurations list to provide back in the toString() method
        this.getConfigurations();
        StringBuilder sb = new StringBuilder();
        sb.append("class GetNotificationConfigurationListResponse {\n");

        sb.append("    configurations: ").append(toIndentedString(configurations)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(getInvalidFields())).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(getPspReference())).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(getResultCode())).append("\n");
        sb.append("}");
        return sb.toString();
    }

}

