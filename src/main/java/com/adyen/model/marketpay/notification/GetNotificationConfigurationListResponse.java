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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * GetNotificationConfigurationListResponse
 */
public class GetNotificationConfigurationListResponse {
    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("configurations")
    private List<NotificationConfigurationDetailsContainer> configurationsContainers = null;

    private transient List<NotificationConfigurationDetails> configurations = null;


    @SerializedName("pspReference")
    private String pspReference = null;

    public GetNotificationConfigurationListResponse submittedAsync(Boolean submittedAsync) {
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

    /**
     * Populate the virtual configurations to bypass the notificationConfigurationDetails list
     *
     * @return configurations
     **/
    public List<NotificationConfigurationDetails> getConfigurations() {
        if (configurations == null) {
            configurations = new ArrayList<>();

            if (configurationsContainers != null && ! configurationsContainers.isEmpty()) {
                for (NotificationConfigurationDetailsContainer notificationConfigurationDetailsContainer : configurationsContainers) {
                    configurations.add(notificationConfigurationDetailsContainer.getNotificationConfigurationDetails());
                }
            }
        }
        return configurations;
    }

    public void setConfigurations(List<NotificationConfigurationDetails> configurations) {

        this.configurations = configurations;

        // set as well the container list this will be send in the API request
        this.configurationsContainers = new ArrayList<>();
        for (NotificationConfigurationDetails notificationConfigurationDetails : configurations) {
            NotificationConfigurationDetailsContainer notificationConfigurationDetailsContainer = createNotificationConfigurationDetailsContainerFromConfiguration(notificationConfigurationDetails);
            this.configurationsContainers.add(notificationConfigurationDetailsContainer);
        }
    }

    private NotificationConfigurationDetailsContainer createNotificationConfigurationDetailsContainerFromConfiguration(NotificationConfigurationDetails configuration) {
        NotificationConfigurationDetailsContainer notificationConfigurationDetailsContainer = new NotificationConfigurationDetailsContainer();
        notificationConfigurationDetailsContainer.setNotificationConfigurationDetails(configuration);
        return notificationConfigurationDetailsContainer;
    }

    public GetNotificationConfigurationListResponse pspReference(String pspReference) {
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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetNotificationConfigurationListResponse getNotificationConfigurationListResponse = (GetNotificationConfigurationListResponse) o;
        return Objects.equals(this.submittedAsync, getNotificationConfigurationListResponse.submittedAsync)
                && Objects.equals(this.configurations,
                                  getNotificationConfigurationListResponse.configurations)
                && Objects.equals(this.pspReference, getNotificationConfigurationListResponse.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(submittedAsync, configurations, pspReference);
    }


    @Override
    public String toString() {
        // Populate the configurations list to provide back in the toString() method
        this.getConfigurations();
        StringBuilder sb = new StringBuilder();
        sb.append("class GetNotificationConfigurationListResponse {\n");

        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    configurations: ").append(toIndentedString(configurations)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

