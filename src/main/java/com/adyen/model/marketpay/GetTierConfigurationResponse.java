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
package com.adyen.model.marketpay;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * GetTierConfigurationResponse
 */
public class GetTierConfigurationResponse {
    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("tierConfiguration")
    private List<TierConfiguration> tierConfiguration = new ArrayList<>();

    @SerializedName("pspReference")
    private String pspReference = null;

    public GetTierConfigurationResponse submittedAsync(Boolean submittedAsync) {
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

    public GetTierConfigurationResponse tierConfiguration(List<TierConfiguration> tierConfiguration) {
        this.tierConfiguration = tierConfiguration;
        return this;
    }

    public GetTierConfigurationResponse addTierConfigurationItem(TierConfiguration tierConfigurationItem) {
        this.tierConfiguration.add(tierConfigurationItem);
        return this;
    }

    /**
     * Get tierConfiguration
     *
     * @return tierConfiguration
     **/
    public List<TierConfiguration> getTierConfiguration() {
        return tierConfiguration;
    }

    public void setTierConfiguration(List<TierConfiguration> tierConfiguration) {
        this.tierConfiguration = tierConfiguration;
    }

    public GetTierConfigurationResponse pspReference(String pspReference) {
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
        GetTierConfigurationResponse getTierConfigurationResponse = (GetTierConfigurationResponse) o;
        return Objects.equals(this.submittedAsync, getTierConfigurationResponse.submittedAsync)
                && Objects.equals(this.tierConfiguration, getTierConfigurationResponse.tierConfiguration)
                && Objects.equals(this.pspReference, getTierConfigurationResponse.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(submittedAsync, tierConfiguration, pspReference);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetTierConfigurationResponse {\n");

        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    tierConfiguration: ").append(toIndentedString(tierConfiguration)).append("\n");
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

