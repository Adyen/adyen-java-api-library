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
 * KYCCheckStatusData
 */
public class KYCCheckStatusData {
    /**
     * check type
     */
    public enum CheckTypeEnum {
        @SerializedName("BANK_ACCOUNT_VERIFICATION")
        BANK_ACCOUNT_VERIFICATION("BANK_ACCOUNT_VERIFICATION"),

        @SerializedName("COMPANY_VERIFICATION")
        COMPANY_VERIFICATION("COMPANY_VERIFICATION"),

        @SerializedName("IDENTITY_VERIFICATION")
        IDENTITY_VERIFICATION("IDENTITY_VERIFICATION"),

        @SerializedName("PASSPORT_VERIFICATION")
        PASSPORT_VERIFICATION("PASSPORT_VERIFICATION");

        private String value;

        CheckTypeEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("type")
    private CheckTypeEnum checkType = null;

    @SerializedName("summary")
    private KYCCheckSummary summary = null;

    /**
     * check status
     */
    public enum CheckStatusEnum {
        @SerializedName("AWAITING_DATA")
        AWAITING_DATA("AWAITING_DATA"),

        @SerializedName("DATA_PROVIDED")
        DATA_PROVIDED("DATA_PROVIDED"),

        @SerializedName("FAILED")
        FAILED("FAILED"),

        @SerializedName("INVALID_DATA")
        INVALID_DATA("INVALID_DATA"),

        @SerializedName("PASSED")
        PASSED("PASSED"),

        @SerializedName("PENDING")
        PENDING("PENDING"),

        @SerializedName("PENDING_REVIEW")
        PENDING_REVIEW("PENDING_REVIEW"),

        @SerializedName("RETRY_LIMIT_REACHED")
        RETRY_LIMIT_REACHED("RETRY_LIMIT_REACHED"),

        @SerializedName("UNCHECKED")
        UNCHECKED("UNCHECKED");

        private String value;

        CheckStatusEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("status")
    private CheckStatusEnum checkStatus = null;

    @SerializedName("requiredFields")
    private List<String> requiredFields = new ArrayList<>();

    public KYCCheckStatusData checkType(CheckTypeEnum checkType) {
        this.checkType = checkType;
        return this;
    }

    /**
     * check type
     *
     * @return checkType
     **/
    public CheckTypeEnum getCheckType() {
        return checkType;
    }

    public void setCheckType(CheckTypeEnum checkType) {
        this.checkType = checkType;
    }

    public KYCCheckStatusData summary(KYCCheckSummary summary) {
        this.summary = summary;
        return this;
    }

    /**
     * check execution summary
     *
     * @return summary
     **/
    public KYCCheckSummary getSummary() {
        return summary;
    }

    public void setSummary(KYCCheckSummary summary) {
        this.summary = summary;
    }

    public KYCCheckStatusData checkStatus(CheckStatusEnum checkStatus) {
        this.checkStatus = checkStatus;
        return this;
    }

    /**
     * check status
     *
     * @return checkStatus
     **/
    public CheckStatusEnum getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(CheckStatusEnum checkStatus) {
        this.checkStatus = checkStatus;
    }

    public KYCCheckStatusData requiredFields(List<String> requiredFields) {
        this.requiredFields = requiredFields;
        return this;
    }

    public KYCCheckStatusData addRequiredFieldsItem(String requiredFieldsItem) {
        this.requiredFields.add(requiredFieldsItem);
        return this;
    }

    /**
     * required fields
     *
     * @return requiredFields
     **/
    public List<String> getRequiredFields() {
        return requiredFields;
    }

    public void setRequiredFields(List<String> requiredFields) {
        this.requiredFields = requiredFields;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KYCCheckStatusData kyCCheckStatusData = (KYCCheckStatusData) o;
        return Objects.equals(this.checkType, kyCCheckStatusData.checkType)
                && Objects.equals(this.summary, kyCCheckStatusData.summary)
                && Objects.equals(this.checkStatus,
                                  kyCCheckStatusData.checkStatus)
                && Objects.equals(this.requiredFields, kyCCheckStatusData.requiredFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkType, summary, checkStatus, requiredFields);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KYCCheckStatusData {\n");

        sb.append("    checkType: ").append(toIndentedString(checkType)).append("\n");
        sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
        sb.append("    checkStatus: ").append(toIndentedString(checkStatus)).append("\n");
        sb.append("    requiredFields: ").append(toIndentedString(requiredFields)).append("\n");
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

