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
 * CreateAccountHolderResponse
 */
public class CreateAccountHolderResponse {
    @SerializedName("verification")
    private KYCVerificationResult verification;

    @SerializedName("submittedAsync")
    private Boolean submittedAsync;

    @SerializedName("accountHolderCode")
    private String accountHolderCode;

    @SerializedName("accountCode")
    private String accountCode;

    @SerializedName("invalidFields")
    public List<ErrorFieldTypeContainer> invalidFieldsContainers;

    private transient List<ErrorFieldType> invalidFields;

    @SerializedName("accountHolderDetails")
    private AccountHolderDetails accountHolderDetails;

    @SerializedName("accountHolderStatus")
    private AccountHolderStatus accountHolderStatus;

    @SerializedName("description")
    private String description = null;

    @SerializedName("pspReference")
    private String pspReference;

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

    public CreateAccountHolderResponse submittedAsync(Boolean submittedAsync) {
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

    public CreateAccountHolderResponse accountHolderCode(String accountHolderCode) {
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

    public CreateAccountHolderResponse accountCode(String accountCode) {
        this.accountCode = accountCode;
        return this;
    }

    /**
     * account holder's account code (if an account has been created for the account holder)
     *
     * @return accountCode
     **/
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    /**
     * Populate the virtual invalidFields to bypass the invalidFieldsContainers list
     *
     * @return invalidFields
     **/
    public List<ErrorFieldType> getInvalidFields() {
        if (invalidFields == null) {
            invalidFields = new ArrayList<ErrorFieldType>();

            if (invalidFieldsContainers != null && !invalidFieldsContainers.isEmpty()) {
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

    public CreateAccountHolderResponse addInvalidField(ErrorFieldType invalidField) {
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

    public CreateAccountHolderResponse accountHolderDetails(AccountHolderDetails accountHolderDetails) {
        this.accountHolderDetails = accountHolderDetails;
        return this;
    }

    public AccountHolderDetails getAccountHolderDetails() {
        return accountHolderDetails;
    }

    public void setAccountHolderDetails(AccountHolderDetails accountHolderDetails) {
        this.accountHolderDetails = accountHolderDetails;
    }

    public CreateAccountHolderResponse accountHolderStatus(AccountHolderStatus accountHolderStatus) {
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

    public CreateAccountHolderResponse pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public KYCVerificationResult getVerification() {
        return verification;
    }

    public void setVerification(KYCVerificationResult verification) {
        this.verification = verification;
    }

    public List<ErrorFieldTypeContainer> getInvalidFieldsContainers() {
        return invalidFieldsContainers;
    }

    public void setInvalidFieldsContainers(List<ErrorFieldTypeContainer> invalidFieldsContainers) {
        this.invalidFieldsContainers = invalidFieldsContainers;
    }

    public LegalEntityEnum getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(LegalEntityEnum legalEntity) {
        this.legalEntity = legalEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateAccountHolderResponse createAccountHolderResponse = (CreateAccountHolderResponse) o;
        return Objects.equals(this.verification, createAccountHolderResponse.verification)
                && Objects.equals(this.submittedAsync, createAccountHolderResponse.submittedAsync)
                && Objects.equals(this.accountHolderCode, createAccountHolderResponse.accountHolderCode)
                && Objects.equals(this.accountCode, createAccountHolderResponse.accountCode)
                && Objects.equals(this.invalidFieldsContainers, createAccountHolderResponse.invalidFieldsContainers)
                && Objects.equals(this.accountHolderDetails, createAccountHolderResponse.accountHolderDetails)
                && Objects.equals(this.accountHolderStatus, createAccountHolderResponse.accountHolderStatus)
                && Objects.equals(this.description, createAccountHolderResponse.description)
                && Objects.equals(this.pspReference, createAccountHolderResponse.pspReference)
                && Objects.equals(this.legalEntity, createAccountHolderResponse.legalEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(verification,
                submittedAsync,
                accountHolderCode,
                accountCode,
                invalidFieldsContainers,
                accountHolderDetails,
                accountHolderStatus,
                description,
                pspReference,
                legalEntity);
    }


    @Override
    public String toString() {
        // Populate the invalidFields list to provide back in the toString() method
        this.getInvalidFields();

        StringBuilder sb = new StringBuilder();
        sb.append("class CreateAccountHolderResponse {\n");
        sb.append("    verification: ").append(toIndentedString(verification)).append("\n");
        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
        sb.append("    accountHolderDetails: ").append(toIndentedString(accountHolderDetails)).append("\n");
        sb.append("    accountHolderStatus: ").append(toIndentedString(accountHolderStatus)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    legalEntity: ").append(toIndentedString(legalEntity)).append("\n");
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

