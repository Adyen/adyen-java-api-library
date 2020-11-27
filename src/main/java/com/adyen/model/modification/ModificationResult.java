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

import com.adyen.model.Split;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;
import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * ModificationResult
 */
public class ModificationResult {

    /**
     * Response constants
     */
    public static class ModificationResponse {
        public static final String CAPTURE_RECEIVED = "[capture-received]";
        public static final String CANCEL_RECEIVED = "[cancel-received]";
        public static final String TECHNICAL_CANCEL_RECEIVED = "[technical-cancel-received]";
        public static final String REFUND_RECEIVED = "[refund-received]";
        public static final String CANCELORREFUND_RECEIVED = "[cancelOrRefund-received]";
        public static final String ADJUST_AUTHORISATION_RECEIVED = "[adjustAuthorisation-received]";
        public static final String VOIDPENDINGREFUND_RECEIVED = "[voidPendingRefund-received]";
        public static final String DONATION_RECEIVED = "[donation-received]";
    }

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("applicationInfo")
    private ApplicationInfo applicationInfo = null;

    @SerializedName("splits")
    private List<Split> splits = null;

    @SerializedName("response")
    private String response = null;

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

    public ModificationResult response(String response) {
        this.response = response;
        return this;
    }

    /**
     * the response which indicates if the modification request has been received for processing.
     *
     * @return response
     **/
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
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

}

