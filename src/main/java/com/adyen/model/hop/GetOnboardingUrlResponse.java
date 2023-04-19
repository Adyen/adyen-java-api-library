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

package com.adyen.model.hop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.adyen.model.marketpay.ErrorFieldType;
import com.google.gson.annotations.SerializedName;

/**
 * GetOnboardingUrlResponse
 */

public class GetOnboardingUrlResponse {
    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("redirectUrl")
    private String redirectUrl = null;

    @SerializedName("resultCode")
    private String resultCode = null;

    public GetOnboardingUrlResponse invalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
        return this;
    }

    public GetOnboardingUrlResponse addInvalidFieldsItem(ErrorFieldType invalidFieldsItem) {
        if (this.invalidFields == null) {
            this.invalidFields = new ArrayList<ErrorFieldType>();
        }
        this.invalidFields.add(invalidFieldsItem);
        return this;
    }

    /**
     * Contains field validation errors that would prevent requests from being processed.
     *
     * @return invalidFields
     **/
    public List<ErrorFieldType> getInvalidFields() {
        return invalidFields;
    }

    public void setInvalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
    }

    public GetOnboardingUrlResponse pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * The reference of a request. Can be used to uniquely identify the request.
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public GetOnboardingUrlResponse redirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
        return this;
    }

    /**
     * The URL to the Hosted Onboarding Page where you should redirect your sub-merchant. This URL must be used within 15 seconds and can only be used once.
     *
     * @return redirectUrl
     **/
    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public GetOnboardingUrlResponse resultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     * The result code.
     *
     * @return resultCode
     **/
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetOnboardingUrlResponse getOnboardingUrlResponse = (GetOnboardingUrlResponse) o;
        return Objects.equals(this.invalidFields, getOnboardingUrlResponse.invalidFields) &&
                Objects.equals(this.pspReference, getOnboardingUrlResponse.pspReference) &&
                Objects.equals(this.redirectUrl, getOnboardingUrlResponse.redirectUrl) &&
                Objects.equals(this.resultCode, getOnboardingUrlResponse.resultCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invalidFields, pspReference, redirectUrl, resultCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetOnboardingUrlResponse {\n");

        sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    redirectUrl: ").append(toIndentedString(redirectUrl)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
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
