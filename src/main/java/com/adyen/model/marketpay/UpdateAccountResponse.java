
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

package com.adyen.model.marketpay;

import com.google.gson.annotations.SerializedName;

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

    @SerializedName("description")
    private String description = null;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    @SerializedName("metadata")
    private Map<String, String> metadata = null;

    @SerializedName("payoutSchedule")
    private PayoutScheduleResponse payoutSchedule = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("resultCode")
    private String resultCode = null;

    @SerializedName("bankAccountUUID")
    private String bankAccountUUID = null;

    @SerializedName("payoutMethodCode")
    private String payoutMethodCode = null;

    @SerializedName("payoutSpeed")
    private PayoutSpeedEnum payoutSpeed = null;

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

    public UpdateAccountResponse pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * The reference of a request.  Can be used to uniquely identify the request.
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

    public UpdateAccountResponse bankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
        return this;
    }

    public String getBankAccountUUID() {
        return bankAccountUUID;
    }

    public void setBankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
    }

    public UpdateAccountResponse payoutMethodCode(String payoutMethodCode) {
        this.payoutMethodCode = payoutMethodCode;
        return this;
    }

    public String getPayoutMethodCode() {
        return payoutMethodCode;
    }

    public void setPayoutMethodCode(String payoutMethodCode) {
        this.payoutMethodCode = payoutMethodCode;
    }

    public UpdateAccountResponse payoutSpeed(PayoutSpeedEnum payoutSpeed) {
        this.payoutSpeed = payoutSpeed;
        return this;
    }

    public PayoutSpeedEnum getPayoutSpeed() {
        return payoutSpeed;
    }

    public void setPayoutSpeed(PayoutSpeedEnum payoutSpeed) {
        this.payoutSpeed = payoutSpeed;
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
                Objects.equals(this.description, updateAccountResponse.description) &&
                Objects.equals(this.invalidFields, updateAccountResponse.invalidFields) &&
                Objects.equals(this.metadata, updateAccountResponse.metadata) &&
                Objects.equals(this.payoutSchedule, updateAccountResponse.payoutSchedule) &&
                Objects.equals(this.pspReference, updateAccountResponse.pspReference) &&
                Objects.equals(this.resultCode, updateAccountResponse.resultCode) &&
                Objects.equals(this.bankAccountUUID, updateAccountResponse.bankAccountUUID) &&
                Objects.equals(this.payoutMethodCode, updateAccountResponse.payoutMethodCode) &&
                Objects.equals(this.payoutSpeed, updateAccountResponse.payoutSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountCode, description, invalidFields, metadata, payoutSchedule, pspReference, resultCode, bankAccountUUID, payoutMethodCode, payoutSpeed);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateAccountResponse {\n");

        sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    payoutSchedule: ").append(toIndentedString(payoutSchedule)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
        sb.append("    bankAccountUUID").append(toIndentedString(bankAccountUUID)).append("\n");
        sb.append("    payoutMethodCode").append(toIndentedString(payoutMethodCode)).append("\n");
        sb.append("    payoutSpeed").append(toIndentedString(payoutSpeed)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}
