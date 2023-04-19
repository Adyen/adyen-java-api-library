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
 * Copyright (c) 2022 Adyen B.V.
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
import java.util.Objects;

/**
 * CreateAccountHolderRequest
 */
public class CreateAccountHolderRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("accountHolderDetails")
    private AccountHolderDetails accountHolderDetails = null;

    @SerializedName("createDefaultAccount")
    private Boolean createDefaultAccount = null;

    @SerializedName("description")
    private String description = null;

    /**
     * The legal entity type of the account holder. This determines the information that should be provided in the request.  Possible values: **Business**, **Individual**, or **NonProfit**.  * If set to **Business** or **NonProfit**, then &#x60;accountHolderDetails.businessDetails&#x60; must be provided, with at least one entry in the &#x60;accountHolderDetails.businessDetails.shareholders&#x60; list.  * If set to **Individual**, then &#x60;accountHolderDetails.individualDetails&#x60; must be provided.
     */
    @JsonAdapter(LegalEntityEnum.Adapter.class)
    public enum LegalEntityEnum {
        BUSINESS("Business"),
        INDIVIDUAL("Individual"),
        NONPROFIT("NonProfit"),
        PARTNERSHIP("Partnership"),
        PUBLICCOMPANY("PublicCompany");


        private final String value;

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
        public static LegalEntityEnum fromValue(String input) {
            for (LegalEntityEnum b : LegalEntityEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<LegalEntityEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final LegalEntityEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public LegalEntityEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return LegalEntityEnum.fromValue(value);
            }
        }
    }  @SerializedName("legalEntity")
    private LegalEntityEnum legalEntity = null;

    @SerializedName("primaryCurrency")
    private String primaryCurrency = null;

    @SerializedName("processingTier")
    private Integer processingTier = null;

    @SerializedName("verificationProfile")
    private String verificationProfile = null;

    public CreateAccountHolderRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * Your unique identifier for the prospective account holder. The length must be between three (3) and fifty (50) characters long. Only letters, digits, and hyphens (-) are allowed.
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public CreateAccountHolderRequest accountHolderDetails(AccountHolderDetails accountHolderDetails) {
        this.accountHolderDetails = accountHolderDetails;
        return this;
    }

    /**
     * Get accountHolderDetails
     * @return accountHolderDetails
     **/
    public AccountHolderDetails getAccountHolderDetails() {
        return accountHolderDetails;
    }

    public void setAccountHolderDetails(AccountHolderDetails accountHolderDetails) {
        this.accountHolderDetails = accountHolderDetails;
    }

    public CreateAccountHolderRequest createDefaultAccount(Boolean createDefaultAccount) {
        this.createDefaultAccount = createDefaultAccount;
        return this;
    }

    /**
     * If set to **true**, an account with the default options is automatically created for the account holder. By default, this field is set to **true**.
     * @return createDefaultAccount
     **/
    public Boolean isCreateDefaultAccount() {
        return createDefaultAccount;
    }

    public void setCreateDefaultAccount(Boolean createDefaultAccount) {
        this.createDefaultAccount = createDefaultAccount;
    }

    public CreateAccountHolderRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the prospective account holder, maximum 256 characters. You can use alphanumeric characters (A-Z, a-z, 0-9), white spaces, and underscores &#x60;_&#x60;.
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CreateAccountHolderRequest legalEntity(LegalEntityEnum legalEntity) {
        this.legalEntity = legalEntity;
        return this;
    }

    /**
     * The legal entity type of the account holder. This determines the information that should be provided in the request.  Possible values: **Business**, **Individual**, or **NonProfit**.  * If set to **Business** or **NonProfit**, then &#x60;accountHolderDetails.businessDetails&#x60; must be provided, with at least one entry in the &#x60;accountHolderDetails.businessDetails.shareholders&#x60; list.  * If set to **Individual**, then &#x60;accountHolderDetails.individualDetails&#x60; must be provided.
     * @return legalEntity
     **/
    public LegalEntityEnum getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(LegalEntityEnum legalEntity) {
        this.legalEntity = legalEntity;
    }

    public CreateAccountHolderRequest primaryCurrency(String primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
        return this;
    }

    /**
     * The three-character [ISO currency code](https://docs.adyen.com/development-resources/currency-codes), with which the prospective account holder primarily deals.
     * @return primaryCurrency
     **/
    public String getPrimaryCurrency() {
        return primaryCurrency;
    }

    public void setPrimaryCurrency(String primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
    }

    public CreateAccountHolderRequest processingTier(Integer processingTier) {
        this.processingTier = processingTier;
        return this;
    }

    /**
     * The starting [processing tier](https://docs.adyen.com/platforms/onboarding-and-verification/precheck-kyc-information) for the prospective account holder.
     * @return processingTier
     **/
    public Integer getProcessingTier() {
        return processingTier;
    }

    public void setProcessingTier(Integer processingTier) {
        this.processingTier = processingTier;
    }

    public CreateAccountHolderRequest verificationProfile(String verificationProfile) {
        this.verificationProfile = verificationProfile;
        return this;
    }

    /**
     * The identifier of the profile that applies to this entity.
     * @return verificationProfile
     **/
    public String getVerificationProfile() {
        return verificationProfile;
    }

    public void setVerificationProfile(String verificationProfile) {
        this.verificationProfile = verificationProfile;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateAccountHolderRequest createAccountHolderRequest = (CreateAccountHolderRequest) o;
        return Objects.equals(this.accountHolderCode, createAccountHolderRequest.accountHolderCode) &&
                Objects.equals(this.accountHolderDetails, createAccountHolderRequest.accountHolderDetails) &&
                Objects.equals(this.createDefaultAccount, createAccountHolderRequest.createDefaultAccount) &&
                Objects.equals(this.description, createAccountHolderRequest.description) &&
                Objects.equals(this.legalEntity, createAccountHolderRequest.legalEntity) &&
                Objects.equals(this.primaryCurrency, createAccountHolderRequest.primaryCurrency) &&
                Objects.equals(this.processingTier, createAccountHolderRequest.processingTier) &&
                Objects.equals(this.verificationProfile, createAccountHolderRequest.verificationProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, accountHolderDetails, createDefaultAccount, description, legalEntity, primaryCurrency, processingTier, verificationProfile);
    }


    @Override
    public String toString() {

        String sb = "class CreateAccountHolderRequest {\n" +
                "    accountHolderCode: " + toIndentedString(accountHolderCode) + "\n" +
                "    accountHolderDetails: " + toIndentedString(accountHolderDetails) + "\n" +
                "    createDefaultAccount: " + toIndentedString(createDefaultAccount) + "\n" +
                "    description: " + toIndentedString(description) + "\n" +
                "    legalEntity: " + toIndentedString(legalEntity) + "\n" +
                "    primaryCurrency: " + toIndentedString(primaryCurrency) + "\n" +
                "    processingTier: " + toIndentedString(processingTier) + "\n" +
                "    verificationProfile: " + toIndentedString(verificationProfile) + "\n" +
                "}";
        return sb;
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

