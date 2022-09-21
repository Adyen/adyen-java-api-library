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

package com.adyen.model.marketpay.notification;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * UpdateAccountResponse
 */

public class UpdateAccountResponse {
    @SerializedName("accountCode")
    private String accountCode = null;

    @SerializedName("bankAccountUUID")
    private String bankAccountUUID = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    @SerializedName("metadata")
    private Map<String, String> metadata = null;

    @SerializedName("payoutMethodCode")
    private String payoutMethodCode = null;

    @SerializedName("payoutSchedule")
    private PayoutScheduleResponse payoutSchedule = null;

    /**
     * Speed with which payouts for this account are processed. Permitted values: &#x60;STANDARD&#x60;, &#x60;SAME_DAY&#x60;.
     */
    @JsonAdapter(PayoutSpeedEnum.Adapter.class)
    public enum PayoutSpeedEnum {
        SAME_DAY("SAME_DAY"),
        STANDARD("STANDARD");

        private final String value;

        PayoutSpeedEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static PayoutSpeedEnum fromValue(String text) {
            for (PayoutSpeedEnum b : PayoutSpeedEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<PayoutSpeedEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final PayoutSpeedEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public PayoutSpeedEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return PayoutSpeedEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("payoutSpeed")
    private PayoutSpeedEnum payoutSpeed = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("resultCode")
    private String resultCode = null;

    public UpdateAccountResponse accountCode(String accountCode) {
        this.accountCode = accountCode;
        return this;
    }

    /**
     * The code of the account.
     *
     * @return accountCode
     **/
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public UpdateAccountResponse bankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
        return this;
    }

    /**
     * The bankAccountUUID of the bank account held by the account holder to couple the account with. Scheduled payouts in currencies matching the currency of this bank account will be sent to this bank account. Payouts in different currencies will be sent to a matching bank account of the account holder.
     *
     * @return bankAccountUUID
     **/
    public String getBankAccountUUID() {
        return bankAccountUUID;
    }

    public void setBankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
    }

    public UpdateAccountResponse description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the account.
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UpdateAccountResponse invalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
        return this;
    }

    public UpdateAccountResponse addInvalidFieldsItem(ErrorFieldType invalidFieldsItem) {
        if (this.invalidFields == null) {
            this.invalidFields = new ArrayList<>();
        }
        this.invalidFields.add(invalidFieldsItem);
        return this;
    }

    /**
     * A list of fields that caused the &#x60;/updateAccount&#x60; request to fail.
     *
     * @return invalidFields
     **/
    public List<ErrorFieldType> getInvalidFields() {
        return invalidFields;
    }

    public void setInvalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
    }

    public UpdateAccountResponse metadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    public UpdateAccountResponse putMetadataItem(String key, String metadataItem) {
        if (this.metadata == null) {
            this.metadata = new HashMap<>();
        }
        this.metadata.put(key, metadataItem);
        return this;
    }

    /**
     * Get metadata
     *
     * @return metadata
     **/
    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public UpdateAccountResponse payoutMethodCode(String payoutMethodCode) {
        this.payoutMethodCode = payoutMethodCode;
        return this;
    }

    /**
     * The payout method code held by the account holder to couple the account with. Scheduled card payouts will be sent using this payout method code.
     *
     * @return payoutMethodCode
     **/
    public String getPayoutMethodCode() {
        return payoutMethodCode;
    }

    public void setPayoutMethodCode(String payoutMethodCode) {
        this.payoutMethodCode = payoutMethodCode;
    }

    public UpdateAccountResponse payoutSchedule(PayoutScheduleResponse payoutSchedule) {
        this.payoutSchedule = payoutSchedule;
        return this;
    }

    /**
     * Get payoutSchedule
     *
     * @return payoutSchedule
     **/
    public PayoutScheduleResponse getPayoutSchedule() {
        return payoutSchedule;
    }

    public void setPayoutSchedule(PayoutScheduleResponse payoutSchedule) {
        this.payoutSchedule = payoutSchedule;
    }

    public UpdateAccountResponse payoutSpeed(PayoutSpeedEnum payoutSpeed) {
        this.payoutSpeed = payoutSpeed;
        return this;
    }

    /**
     * Speed with which payouts for this account are processed. Permitted values: &#x60;STANDARD&#x60;, &#x60;SAME_DAY&#x60;.
     *
     * @return payoutSpeed
     **/
    public PayoutSpeedEnum getPayoutSpeed() {
        return payoutSpeed;
    }

    public void setPayoutSpeed(PayoutSpeedEnum payoutSpeed) {
        this.payoutSpeed = payoutSpeed;
    }

    public UpdateAccountResponse pspReference(String pspReference) {
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

    public UpdateAccountResponse resultCode(String resultCode) {
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
        UpdateAccountResponse updateAccountResponse = (UpdateAccountResponse) o;
        return Objects.equals(this.accountCode, updateAccountResponse.accountCode) &&
                Objects.equals(this.bankAccountUUID, updateAccountResponse.bankAccountUUID) &&
                Objects.equals(this.description, updateAccountResponse.description) &&
                Objects.equals(this.invalidFields, updateAccountResponse.invalidFields) &&
                Objects.equals(this.metadata, updateAccountResponse.metadata) &&
                Objects.equals(this.payoutMethodCode, updateAccountResponse.payoutMethodCode) &&
                Objects.equals(this.payoutSchedule, updateAccountResponse.payoutSchedule) &&
                Objects.equals(this.payoutSpeed, updateAccountResponse.payoutSpeed) &&
                Objects.equals(this.pspReference, updateAccountResponse.pspReference) &&
                Objects.equals(this.resultCode, updateAccountResponse.resultCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountCode, bankAccountUUID, description, invalidFields, metadata, payoutMethodCode, payoutSchedule, payoutSpeed, pspReference, resultCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateAccountResponse {\n");

        sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
        sb.append("    bankAccountUUID: ").append(toIndentedString(bankAccountUUID)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    payoutMethodCode: ").append(toIndentedString(payoutMethodCode)).append("\n");
        sb.append("    payoutSchedule: ").append(toIndentedString(payoutSchedule)).append("\n");
        sb.append("    payoutSpeed: ").append(toIndentedString(payoutSpeed)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
