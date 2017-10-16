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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/**
 * CreateNotificationConfigurationRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-11T12:23:08.541Z")
public class CreateNotificationConfigurationRequest {
    @SerializedName("configurationDetails")
    private CreateNotificationConfigurationConfigurationDetails configurationDetails = null;

    public CreateNotificationConfigurationRequest configurationDetails(CreateNotificationConfigurationConfigurationDetails configurationDetails) {
        this.configurationDetails = configurationDetails;
        return this;
    }

    /**
     * Get configurationDetails
     *
     * @return configurationDetails
     **/
    public CreateNotificationConfigurationConfigurationDetails getConfigurationDetails() {
        return configurationDetails;
    }

    public void setConfigurationDetails(CreateNotificationConfigurationConfigurationDetails configurationDetails) {
        this.configurationDetails = configurationDetails;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
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
        sb.append("class CreateNotificationConfigurationRequest {\n");

        sb.append("    configurationDetails: ").append(toIndentedString(configurationDetails)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

