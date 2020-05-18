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
package com.adyen.model.modification;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.adyen.model.applicationinfo.ApplicationInfo;
import com.adyen.model.Split;
import com.google.gson.annotations.SerializedName;

/**
 * ModificationResult
 */
public class ModificationResult {

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("applicationInfo")
    private ApplicationInfo applicationInfo = null;

    @SerializedName("splits")
    private List<Split> splits = null;


    /**
     * the response which indicates if the modification request has been received for processing.
     */
    public enum ResponseEnum {
        @SerializedName("[capture-received]")
        CAPTURE_RECEIVED_("[capture-received]"),

        @SerializedName("[cancel-received]")
        CANCEL_RECEIVED_("[cancel-received]"),

        @SerializedName("[technical-cancel-received]")
        TECHNICAL_CANCEL_RECEIVED_("[technical-cancel-received]"),

        @SerializedName("[refund-received]")
        REFUND_RECEIVED_("[refund-received]"),

        @SerializedName("[cancelOrRefund-received]")
        CANCELORREFUND_RECEIVED_("[cancelOrRefund-received]"),

        @SerializedName("[adjustAuthorisation-received]")
        ADJUSTAUTHORISATION_RECEIVED_("[adjustAuthorisation-received]"),

        @SerializedName("[voidPendingRefund-received]")
        VOIDPENDINGREFUND_RECEIVED_("[voidPendingRefund-received]"),

        @SerializedName("[donation-received]")
        DONATION_RECEIVED_("[donation-received]");

        private String value;

        ResponseEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("response")
    private ResponseEnum response = null;

    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    public ModificationResult pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * the unique identifier assigned to this modification.
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public ModificationResult response(ResponseEnum response) {
        this.response = response;
        return this;
    }

    /**
     * the response which indicates if the modification request has been received for processing.
     *
     * @return response
     **/
    public ResponseEnum getResponse() {
        return response;
    }

    public void setResponse(ResponseEnum response) {
        this.response = response;
    }

    public ModificationResult additionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
        return this;
    }

    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ModificationResult modificationResult = (ModificationResult) o;
        return Objects.equals(this.pspReference, modificationResult.pspReference) && Objects.equals(this.response, modificationResult.response) && Objects.equals(this.additionalData,
                                                                                                                                                                  modificationResult.additionalData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pspReference, response, additionalData);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModificationResult {\n");
        sb.append("    applicationInfo: ").append(toIndentedString(applicationInfo)).append("\n");
        sb.append("    splits: ").append(toIndentedString(splits)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    response: ").append(toIndentedString(response)).append("\n");
        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
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

