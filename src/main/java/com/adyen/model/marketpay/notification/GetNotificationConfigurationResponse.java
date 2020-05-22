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
 * GetNotificationConfigurationResponse
 */
public class GetNotificationConfigurationResponse {
    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("configurationDetails")
    private NotificationConfigurationDetails configurationDetails = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    public GetNotificationConfigurationResponse submittedAsync(Boolean submittedAsync) {
        this.submittedAsync = submittedAsync;
        return this;
    }

    /**
     * Get submittedAsync
     *
     * @return submittedAsync
     **/
    public Boolean getSubmittedAsync() {
        return submittedAsync;
    }

    public void setSubmittedAsync(Boolean submittedAsync) {
        this.submittedAsync = submittedAsync;
    }

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

    public GetNotificationConfigurationResponse pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * psp reference
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        GetNotificationConfigurationResponse getNotificationConfigurationResponse = (GetNotificationConfigurationResponse) o;
        return Objects.equals(this.submittedAsync, getNotificationConfigurationResponse.submittedAsync) && Objects.equals(this.configurationDetails,
                                                                                                                          getNotificationConfigurationResponse.configurationDetails) && Objects.equals(
                this.pspReference,
                getNotificationConfigurationResponse.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(submittedAsync, configurationDetails, pspReference);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetNotificationConfigurationResponse {").append(TextConstants.LINE_BREAK);

        sb.append("    submittedAsync: ").append(Util.toIndentedString(submittedAsync)).append(TextConstants.LINE_BREAK);
        sb.append("    configurationDetails: ").append(Util.toIndentedString(configurationDetails)).append(TextConstants.LINE_BREAK);
        sb.append("    pspReference: ").append(Util.toIndentedString(pspReference)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }



}

