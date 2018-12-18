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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * UpdateAccountHolderResponse
 */
public class UpdateAccountHolderResponse {
    @SerializedName("accountStatus")
    private AccountStatus accountStatus = null;

    @SerializedName("verification")
    private KYCVerificationResult verificationResult = null;

    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("updatedFields")
    private List<FieldType> updatedFields = new ArrayList<FieldType>();

    @SerializedName("requirementsForNextAccountState")
    private List<AccountStateRequirement> requirementsForNextAccountState = new ArrayList<AccountStateRequirement>();

    @SerializedName("invalidFields")
    public List<ErrorFieldTypeContainer> invalidFieldsContainers = null;

    @SerializedName("description")
    private String description = null;

    private transient List<ErrorFieldType> invalidFields = null;

    @SerializedName("accountHolderDetails")
    private AccountHolderDetails accountHolderDetails = null;

    @SerializedName("accountHolderStatus")
    private AccountHolderStatus accountHolderStatus = null;

    public enum LegalEntityEnum {

        BUSINESS("Business"),
        INDIVIDUAL("Individual"),
        NONPROFIT("NonProfit");

        private String value;

        LegalEntityEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static LegalEntityEnum fromValue(String text) {
            for (LegalEntityEnum b : LegalEntityEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<LegalEntityEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final LegalEntityEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public LegalEntityEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return LegalEntityEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("legalEntity")
    private LegalEntityEnum legalEntity = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    public UpdateAccountHolderResponse accountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }

    /**
     * account holder status after update
     *
     * @return accountStatus
     **/
    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public UpdateAccountHolderResponse verificationResult(KYCVerificationResult verificationResult) {
        this.verificationResult = verificationResult;
        return this;
    }

    /**
     * verification result
     *
     * @return verificationResult
     **/
    public KYCVerificationResult getVerificationResult() {
        return verificationResult;
    }

    public void setVerificationResult(KYCVerificationResult verificationResult) {
        this.verificationResult = verificationResult;
    }

    public UpdateAccountHolderResponse submittedAsync(Boolean submittedAsync) {
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

    public UpdateAccountHolderResponse accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * account holder code
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public UpdateAccountHolderResponse updatedFields(List<FieldType> updatedFields) {
        this.updatedFields = updatedFields;
        return this;
    }

    public UpdateAccountHolderResponse addUpdatedFieldsItem(FieldType updatedFieldsItem) {
        this.updatedFields.add(updatedFieldsItem);
        return this;
    }

    /**
     * in case the account holder has been updated, contains account holder updated fields
     *
     * @return updatedFields
     **/
    public List<FieldType> getUpdatedFields() {
        return updatedFields;
    }

    public void setUpdatedFields(List<FieldType> updatedFields) {
        this.updatedFields = updatedFields;
    }

    public UpdateAccountHolderResponse requirementsForNextAccountState(List<AccountStateRequirement> requirementsForNextAccountState) {
        this.requirementsForNextAccountState = requirementsForNextAccountState;
        return this;
    }

    public UpdateAccountHolderResponse addRequirementsForNextAccountStateItem(AccountStateRequirement requirementsForNextAccountStateItem) {
        this.requirementsForNextAccountState.add(requirementsForNextAccountStateItem);
        return this;
    }

    /**
     * account holder properties that must be provided, in order for the account holder to reach the next processing state level
     *
     * @return requirementsForNextAccountState
     **/
    public List<AccountStateRequirement> getRequirementsForNextAccountState() {
        return requirementsForNextAccountState;
    }

    public void setRequirementsForNextAccountState(List<AccountStateRequirement> requirementsForNextAccountState) {
        this.requirementsForNextAccountState = requirementsForNextAccountState;
    }

    /**
     * Populate the virtual invalidFields to bypass the invalidFieldsContainers list
     *
     * @return invalidFields
     **/
    public List<ErrorFieldType> getInvalidFields() {
        if (invalidFields == null) {
            invalidFields = new ArrayList<ErrorFieldType>();

            if (invalidFieldsContainers != null && ! invalidFieldsContainers.isEmpty()) {
                for (ErrorFieldTypeContainer invalidFieldsContainer : invalidFieldsContainers) {
                    invalidFields.add(invalidFieldsContainer.getErrorFieldType());
                }
            }
        }

        return invalidFields;
    }

    /**
     * Creating a new invalidFields list
     *
     * @param invalidFields invalidFields
     */
    public void setInvalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;

        // set as well the container list this will be send in the API request
        this.invalidFieldsContainers = new ArrayList<ErrorFieldTypeContainer>();
        for (ErrorFieldType invalidField : invalidFields) {

            ErrorFieldTypeContainer invalidFieldContainer = new ErrorFieldTypeContainer(invalidField);
            this.invalidFieldsContainers.add(invalidFieldContainer);
        }
    }

    public UpdateAccountHolderResponse addInvalidField(ErrorFieldType invalidField) {
        ErrorFieldTypeContainer invalidFieldContainer = new ErrorFieldTypeContainer(invalidField);

        if (invalidFieldsContainers == null) {
            invalidFieldsContainers = new ArrayList<ErrorFieldTypeContainer>();
        }
        this.invalidFieldsContainers.add(invalidFieldContainer);

        if (invalidFields == null) {
            invalidFields = new ArrayList<ErrorFieldType>();
        }
        this.invalidFields.add(invalidField);

        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UpdateAccountHolderResponse accountHolderDetails(AccountHolderDetails accountHolderDetails) {
        this.accountHolderDetails = accountHolderDetails;
        return this;
    }

    /**
     * details of updated account holder
     *
     * @return accountHolderDetails
     **/
    public AccountHolderDetails getAccountHolderDetails() {
        return accountHolderDetails;
    }

    public void setAccountHolderDetails(AccountHolderDetails accountHolderDetails) {
        this.accountHolderDetails = accountHolderDetails;
    }

    public UpdateAccountHolderResponse accountHolderStatus(AccountHolderStatus accountHolderStatus) {
        this.accountHolderStatus = accountHolderStatus;
        return this;
    }

    /**
     * account holder status
     *
     * @return accountHolderStatus
     **/
    public AccountHolderStatus getAccountHolderStatus() {
        return accountHolderStatus;
    }

    public void setAccountHolderStatus(AccountHolderStatus accountHolderStatus) {
        this.accountHolderStatus = accountHolderStatus;
    }

    public UpdateAccountHolderResponse pspReference(String pspReference) {
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
        UpdateAccountHolderResponse updateAccountHolderResponse = (UpdateAccountHolderResponse) o;
        return Objects.equals(this.accountStatus, updateAccountHolderResponse.accountStatus)
                && Objects.equals(this.verificationResult, updateAccountHolderResponse.verificationResult)
                && Objects.equals(this.submittedAsync, updateAccountHolderResponse.submittedAsync)
                && Objects.equals(this.accountHolderCode, updateAccountHolderResponse.accountHolderCode)
                && Objects.equals(this.updatedFields, updateAccountHolderResponse.updatedFields)
                && Objects.equals(this.requirementsForNextAccountState, updateAccountHolderResponse.requirementsForNextAccountState)
                && Objects.equals(this.invalidFieldsContainers, updateAccountHolderResponse.invalidFieldsContainers)
                && Objects.equals(this.description, updateAccountHolderResponse.description)
                && Objects.equals(this.accountHolderDetails, updateAccountHolderResponse.accountHolderDetails)
                && Objects.equals(this.accountHolderStatus, updateAccountHolderResponse.accountHolderStatus)
                && Objects.equals(this.legalEntity, updateAccountHolderResponse.legalEntity)
                && Objects.equals(this.pspReference, updateAccountHolderResponse.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountStatus,
                            verificationResult,
                            submittedAsync,
                            accountHolderCode,
                            updatedFields,
                            requirementsForNextAccountState,
                            invalidFieldsContainers,
                            description,
                            accountHolderDetails,
                            accountHolderStatus,
                            legalEntity,
                            pspReference);
    }


    @Override
    public String toString() {
        // Populate the invalidFields list to provide back in the toString() method
        this.getInvalidFields();

        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateAccountHolderResponse {\n");

        sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
        sb.append("    verificationResult: ").append(toIndentedString(verificationResult)).append("\n");
        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    updatedFields: ").append(toIndentedString(updatedFields)).append("\n");
        sb.append("    requirementsForNextAccountState: ").append(toIndentedString(requirementsForNextAccountState)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    accountHolderDetails: ").append(toIndentedString(accountHolderDetails)).append("\n");
        sb.append("    accountHolderStatus: ").append(toIndentedString(accountHolderStatus)).append("\n");
        sb.append("    legalEntity: ").append(toIndentedString(legalEntity)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

