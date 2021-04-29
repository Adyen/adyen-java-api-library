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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.marketpay;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * KYCCheckStatusData
 */

public class KYCCheckStatusData {
    @SerializedName("requiredFields")
    private List<String> requiredFields = null;

    /**
     * The status of the check. &gt;Permitted Values: &#x60;DATA_PROVIDED&#x60;, &#x60;PASSED&#x60;, &#x60;PENDING&#x60;, &#x60;AWAITING_DATA&#x60;, &#x60;RETRY_LIMIT_REACHED&#x60;, &#x60;INVALID_DATA&#x60;, &#x60;FAILED&#x60;.
     */
    @JsonAdapter(StatusEnum.Adapter.class)
    public enum StatusEnum {
        AWAITING_DATA("AWAITING_DATA"),
        DATA_PROVIDED("DATA_PROVIDED"),
        FAILED("FAILED"),
        INVALID_DATA("INVALID_DATA"),
        PASSED("PASSED"),
        PENDING("PENDING"),
        PENDING_REVIEW("PENDING_REVIEW"),
        RETRY_LIMIT_REACHED("RETRY_LIMIT_REACHED"),
        UNCHECKED("UNCHECKED");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static StatusEnum fromValue(String text) {
            for (StatusEnum b : StatusEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<StatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public StatusEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return StatusEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("status")
    private StatusEnum status = null;

    @SerializedName("summary")
    private KYCCheckSummary summary = null;

    /**
     * The type of check. &gt;Permitted Values: &#x60;COMPANY_VERIFICATION&#x60;, &#x60;IDENTITY_VERIFICATION&#x60;, &#x60;PASSPORT_VERIFICATION&#x60;, &#x60;BANK_ACCOUNT_VERIFICATION&#x60;, &#x60;NONPROFIT_VERIFICATION&#x60;, &#x60;CARD_VERIFICATION&#x60;.
     */
    @JsonAdapter(TypeEnum.Adapter.class)
    public enum TypeEnum {
        BANK_ACCOUNT_VERIFICATION("BANK_ACCOUNT_VERIFICATION"),
        CARD_VERIFICATION("CARD_VERIFICATION"),
        COMPANY_VERIFICATION("COMPANY_VERIFICATION"),
        CRIMINAL_BACKGROUND_EXTENSIVE_VERIFICATION("CRIMINAL_BACKGROUND_EXTENSIVE_VERIFICATION"),
        CRIMINAL_BACKGROUND_MEDIUM_VERIFICATION("CRIMINAL_BACKGROUND_MEDIUM_VERIFICATION"),
        IDENTITY_VERIFICATION("IDENTITY_VERIFICATION"),
        LEGAL_ARRANGEMENT_VERIFICATION("LEGAL_ARRANGEMENT_VERIFICATION"),
        NONPROFIT_VERIFICATION("NONPROFIT_VERIFICATION"),
        PASSPORT_VERIFICATION("PASSPORT_VERIFICATION"),
        PAYOUT_METHOD_VERIFICATION("PAYOUT_METHOD_VERIFICATION"),
        PCI_SELF_ASSESSMENT_PRESENCE_VERIFICATION("PCI_SELF_ASSESSMENT_PRESENCE_VERIFICATION"),
        PCI_VERIFICATION("PCI_VERIFICATION"),
        POLITICALLY_EXPOSED_IDENTIFICATION_VERIFICATION("POLITICALLY_EXPOSED_IDENTIFICATION_VERIFICATION"),
        POLITICALLY_EXPOSED_VERIFICATION("POLITICALLY_EXPOSED_VERIFICATION");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TypeEnum fromValue(String text) {
            for (TypeEnum b : TypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<TypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TypeEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return TypeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("type")
    private TypeEnum type = null;

    public KYCCheckStatusData requiredFields(List<String> requiredFields) {
        this.requiredFields = requiredFields;
        return this;
    }

    public KYCCheckStatusData addRequiredFieldsItem(String requiredFieldsItem) {
        if (this.requiredFields == null) {
            this.requiredFields = new ArrayList<String>();
        }
        this.requiredFields.add(requiredFieldsItem);
        return this;
    }

    /**
     * A list of the fields required for execution of the check.
     *
     * @return requiredFields
     **/
    public List<String> getRequiredFields() {
        return requiredFields;
    }

    public void setRequiredFields(List<String> requiredFields) {
        this.requiredFields = requiredFields;
    }

    public KYCCheckStatusData status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * The status of the check. &gt;Permitted Values: &#x60;DATA_PROVIDED&#x60;, &#x60;PASSED&#x60;, &#x60;PENDING&#x60;, &#x60;AWAITING_DATA&#x60;, &#x60;RETRY_LIMIT_REACHED&#x60;, &#x60;INVALID_DATA&#x60;, &#x60;FAILED&#x60;.
     *
     * @return status
     **/
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public KYCCheckStatusData summary(KYCCheckSummary summary) {
        this.summary = summary;
        return this;
    }

    /**
     * Get summary
     *
     * @return summary
     **/
    public KYCCheckSummary getSummary() {
        return summary;
    }

    public void setSummary(KYCCheckSummary summary) {
        this.summary = summary;
    }

    public KYCCheckStatusData type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of check. &gt;Permitted Values: &#x60;COMPANY_VERIFICATION&#x60;, &#x60;IDENTITY_VERIFICATION&#x60;, &#x60;PASSPORT_VERIFICATION&#x60;, &#x60;BANK_ACCOUNT_VERIFICATION&#x60;, &#x60;NONPROFIT_VERIFICATION&#x60;, &#x60;CARD_VERIFICATION&#x60;.
     *
     * @return type
     **/
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KYCCheckStatusData kyCCheckStatusData = (KYCCheckStatusData) o;
        return Objects.equals(this.requiredFields, kyCCheckStatusData.requiredFields) &&
                Objects.equals(this.status, kyCCheckStatusData.status) &&
                Objects.equals(this.summary, kyCCheckStatusData.summary) &&
                Objects.equals(this.type, kyCCheckStatusData.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requiredFields, status, summary, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KYCCheckStatusData {\n");

        sb.append("    requiredFields: ").append(toIndentedString(requiredFields)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }


}
