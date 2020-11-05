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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.checkout;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * RiskData
 */

public class RiskData {
    @SerializedName("clientData")
    private String clientData = null;

    @SerializedName("customFields")
    private Map<String, String> customFields = null;

    @SerializedName("fraudOffset")
    private Integer fraudOffset = null;

    @SerializedName("profileReference")
    private String profileReference = null;

    public RiskData clientData(String clientData) {
        this.clientData = clientData;
        return this;
    }

    /**
     * Contains client-side data, like the device fingerprint, cookies, and specific browser settings.
     *
     * @return clientData
     **/
    public String getClientData() {
        return clientData;
    }

    public void setClientData(String clientData) {
        this.clientData = clientData;
    }

    public RiskData customFields(Map<String, String> customFields) {
        this.customFields = customFields;
        return this;
    }

    public RiskData putCustomFieldsItem(String key, String customFieldsItem) {
        if (this.customFields == null) {
            this.customFields = new HashMap<String, String>();
        }
        this.customFields.put(key, customFieldsItem);
        return this;
    }

    /**
     * Any custom fields used as part of the input to configured risk rules.
     *
     * @return customFields
     **/
    public Map<String, String> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(Map<String, String> customFields) {
        this.customFields = customFields;
    }

    public RiskData fraudOffset(Integer fraudOffset) {
        this.fraudOffset = fraudOffset;
        return this;
    }

    /**
     * An integer value that is added to the normal fraud score. The value can be either positive or negative.
     *
     * @return fraudOffset
     **/
    public Integer getFraudOffset() {
        return fraudOffset;
    }

    public void setFraudOffset(Integer fraudOffset) {
        this.fraudOffset = fraudOffset;
    }

    public RiskData profileReference(String profileReference) {
        this.profileReference = profileReference;
        return this;
    }

    /**
     * The risk profile to assign to this payment. When left empty, the merchant-level account&#x27;s default risk profile will be applied.
     *
     * @return profileReference
     **/
    public String getProfileReference() {
        return profileReference;
    }

    public void setProfileReference(String profileReference) {
        this.profileReference = profileReference;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RiskData riskData = (RiskData) o;
        return Objects.equals(this.clientData, riskData.clientData) &&
                Objects.equals(this.customFields, riskData.customFields) &&
                Objects.equals(this.fraudOffset, riskData.fraudOffset) &&
                Objects.equals(this.profileReference, riskData.profileReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientData, customFields, fraudOffset, profileReference);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RiskData {\n");

        sb.append("    clientData: ").append(toIndentedString(clientData)).append("\n");
        sb.append("    customFields: ").append(toIndentedString(customFields)).append("\n");
        sb.append("    fraudOffset: ").append(toIndentedString(fraudOffset)).append("\n");
        sb.append("    profileReference: ").append(toIndentedString(profileReference)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}