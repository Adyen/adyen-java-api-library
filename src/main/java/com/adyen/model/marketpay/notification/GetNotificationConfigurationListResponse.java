
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-11T12:23:08.541Z")
public class GetNotificationConfigurationListResponse {
    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("configurations")
    private List<CreateNotificationConfigurationConfigurationDetails> configurations = null;

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

    public GetNotificationConfigurationListResponse configurations(List<CreateNotificationConfigurationConfigurationDetails> configurations) {
        this.configurations = configurations;
        return this;
    }

    public GetNotificationConfigurationListResponse addConfigurationsItem(CreateNotificationConfigurationConfigurationDetails configurationsItem) {
        if (this.configurations == null) {
            this.configurations = new ArrayList<CreateNotificationConfigurationConfigurationDetails>();
        }
        this.configurations.add(configurationsItem);
        return this;
    }

    /**
     * notification configurations
     *
     * @return configurations
     **/
    public List<CreateNotificationConfigurationConfigurationDetails> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<CreateNotificationConfigurationConfigurationDetails> configurations) {
        this.configurations = configurations;
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
    public boolean equals(java.lang.Object o) {
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
        StringBuilder sb = new StringBuilder();
        sb.append("class GetNotificationConfigurationListResponse {\n");

        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    configurations: ").append(toIndentedString(configurations)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
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

