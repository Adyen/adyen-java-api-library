
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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * GetAccountHolderResponse
 */
public class GetAccountHolderResponse {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("accountHolderDetails")
    private AccountHolderDetails accountHolderDetails = null;

    @SerializedName("accountHolderStatus")
    private AccountHolderStatus accountHolderStatus = null;

    @SerializedName("accounts")
    private List<Account> accounts = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    /**
     * The legal entity of the account holder.
     */
    @JsonAdapter(LegalEntityEnum.Adapter.class)
    public enum LegalEntityEnum {
        BUSINESS("Business"),
        INDIVIDUAL("Individual"),
        NONPROFIT("NonProfit"),
        PUBLICCOMPANY("PublicCompany");

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
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
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

    @SerializedName("primaryCurrency")
    private String primaryCurrency = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("resultCode")
    private String resultCode = null;

    @SerializedName("systemUpToDateTime")
    private Date systemUpToDateTime = null;

    @SerializedName("verification")
    private KYCVerificationResult verification = null;

    public GetAccountHolderResponse accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * The code of the account holder.
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public GetAccountHolderResponse accountHolderDetails(AccountHolderDetails accountHolderDetails) {
        this.accountHolderDetails = accountHolderDetails;
        return this;
    }

    /**
     * Get accountHolderDetails
     *
     * @return accountHolderDetails
     **/
    public AccountHolderDetails getAccountHolderDetails() {
        return accountHolderDetails;
    }

    public void setAccountHolderDetails(AccountHolderDetails accountHolderDetails) {
        this.accountHolderDetails = accountHolderDetails;
    }

    public GetAccountHolderResponse accountHolderStatus(AccountHolderStatus accountHolderStatus) {
        this.accountHolderStatus = accountHolderStatus;
        return this;
    }

    /**
     * Get accountHolderStatus
     *
     * @return accountHolderStatus
     **/
    public AccountHolderStatus getAccountHolderStatus() {
        return accountHolderStatus;
    }

    public void setAccountHolderStatus(AccountHolderStatus accountHolderStatus) {
        this.accountHolderStatus = accountHolderStatus;
    }

    public GetAccountHolderResponse accounts(List<Account> accounts) {
        this.accounts = accounts;
        return this;
    }

    public GetAccountHolderResponse addAccountsItem(Account accountsItem) {
        if (this.accounts == null) {
            this.accounts = new ArrayList<>();
        }
        this.accounts.add(accountsItem);
        return this;
    }

    /**
     * A list of the accounts under the account holder.
     *
     * @return accounts
     **/
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public GetAccountHolderResponse description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the account holder.
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GetAccountHolderResponse invalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
        return this;
    }

    public GetAccountHolderResponse addInvalidFieldsItem(ErrorFieldType invalidFieldsItem) {
        if (this.invalidFields == null) {
            this.invalidFields = new ArrayList<>();
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

    public GetAccountHolderResponse legalEntity(LegalEntityEnum legalEntity) {
        this.legalEntity = legalEntity;
        return this;
    }

    /**
     * The legal entity of the account holder.
     *
     * @return legalEntity
     **/
    public LegalEntityEnum getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(LegalEntityEnum legalEntity) {
        this.legalEntity = legalEntity;
    }

    public GetAccountHolderResponse primaryCurrency(String primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
        return this;
    }

    /**
     * The three-character [ISO currency code](https://docs.adyen.com/development-resources/currency-codes), with which the prospective account holder primarily deals.
     *
     * @return primaryCurrency
     **/
    public String getPrimaryCurrency() {
        return primaryCurrency;
    }

    public void setPrimaryCurrency(String primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
    }

    public GetAccountHolderResponse pspReference(String pspReference) {
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

    public GetAccountHolderResponse resultCode(String resultCode) {
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

    public GetAccountHolderResponse systemUpToDateTime(Date systemUpToDateTime) {
        this.systemUpToDateTime = systemUpToDateTime;
        return this;
    }

    /**
     * The time that shows how up to date is the information in the response.
     *
     * @return systemUpToDateTime
     **/
    public Date getSystemUpToDateTime() {
        return systemUpToDateTime;
    }

    public void setSystemUpToDateTime(Date systemUpToDateTime) {
        this.systemUpToDateTime = systemUpToDateTime;
    }

    public GetAccountHolderResponse verification(KYCVerificationResult verification) {
        this.verification = verification;
        return this;
    }

    /**
     * Get verification
     *
     * @return verification
     **/
    public KYCVerificationResult getVerification() {
        return verification;
    }

    public void setVerification(KYCVerificationResult verification) {
        this.verification = verification;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetAccountHolderResponse getAccountHolderResponse = (GetAccountHolderResponse) o;
        return Objects.equals(this.accountHolderCode, getAccountHolderResponse.accountHolderCode) &&
                Objects.equals(this.accountHolderDetails, getAccountHolderResponse.accountHolderDetails) &&
                Objects.equals(this.accountHolderStatus, getAccountHolderResponse.accountHolderStatus) &&
                Objects.equals(this.accounts, getAccountHolderResponse.accounts) &&
                Objects.equals(this.description, getAccountHolderResponse.description) &&
                Objects.equals(this.invalidFields, getAccountHolderResponse.invalidFields) &&
                Objects.equals(this.legalEntity, getAccountHolderResponse.legalEntity) &&
                Objects.equals(this.primaryCurrency, getAccountHolderResponse.primaryCurrency) &&
                Objects.equals(this.pspReference, getAccountHolderResponse.pspReference) &&
                Objects.equals(this.resultCode, getAccountHolderResponse.resultCode) &&
                Objects.equals(this.systemUpToDateTime, getAccountHolderResponse.systemUpToDateTime) &&
                Objects.equals(this.verification, getAccountHolderResponse.verification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, accountHolderDetails, accountHolderStatus, accounts, description, invalidFields, legalEntity, primaryCurrency, pspReference, resultCode, systemUpToDateTime, verification);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetAccountHolderResponse {\n");

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    accountHolderDetails: ").append(toIndentedString(accountHolderDetails)).append("\n");
        sb.append("    accountHolderStatus: ").append(toIndentedString(accountHolderStatus)).append("\n");
        sb.append("    accounts: ").append(toIndentedString(accounts)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
        sb.append("    legalEntity: ").append(toIndentedString(legalEntity)).append("\n");
        sb.append("    primaryCurrency: ").append(toIndentedString(primaryCurrency)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
        sb.append("    systemUpToDateTime: ").append(toIndentedString(systemUpToDateTime)).append("\n");
        sb.append("    verification: ").append(toIndentedString(verification)).append("\n");
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
