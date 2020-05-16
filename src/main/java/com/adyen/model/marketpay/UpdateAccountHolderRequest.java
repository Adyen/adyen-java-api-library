
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
import java.util.Arrays;
import java.util.Objects;

/**
 * UpdateAccountHolderRequest
 */
public class UpdateAccountHolderRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("accountHolderDetails")
    private AccountHolderDetails accountHolderDetails = null;

    @SerializedName("description")
    private String description = null;

    /**
     * The entity type. Permitted values: &#x60;Business&#x60;, &#x60;Individual&#x60;  If an account holder is &#x27;Business&#x27;, then &#x60;accountHolderDetails.businessDetails&#x60; must be provided, as well as at least one entry in the &#x60;accountHolderDetails.businessDetails.shareholders&#x60; list.  If an account holder is &#x27;Individual&#x27;, then &#x60;accountHolderDetails.individualDetails&#x60; must be provided.
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

    @SerializedName("processingTier")
    private Integer processingTier = null;

    public UpdateAccountHolderRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * The code of the Account Holder to be updated.
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public UpdateAccountHolderRequest accountHolderDetails(AccountHolderDetails accountHolderDetails) {
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

    public UpdateAccountHolderRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description to which the Account Holder should be updated.
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UpdateAccountHolderRequest legalEntity(LegalEntityEnum legalEntity) {
        this.legalEntity = legalEntity;
        return this;
    }

    /**
     * The entity type. Permitted values: &#x60;Business&#x60;, &#x60;Individual&#x60;  If an account holder is &#x27;Business&#x27;, then &#x60;accountHolderDetails.businessDetails&#x60; must be provided, as well as at least one entry in the &#x60;accountHolderDetails.businessDetails.shareholders&#x60; list.  If an account holder is &#x27;Individual&#x27;, then &#x60;accountHolderDetails.individualDetails&#x60; must be provided.
     *
     * @return legalEntity
     **/
    public LegalEntityEnum getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(LegalEntityEnum legalEntity) {
        this.legalEntity = legalEntity;
    }

    public UpdateAccountHolderRequest primaryCurrency(String primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
        return this;
    }

    /**
     * The primary three-character [ISO currency code](https://docs.adyen.com/development-resources/currency-codes), to which the account holder should be updated.
     *
     * @return primaryCurrency
     **/
    public String getPrimaryCurrency() {
        return primaryCurrency;
    }

    public void setPrimaryCurrency(String primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
    }

    public UpdateAccountHolderRequest processingTier(Integer processingTier) {
        this.processingTier = processingTier;
        return this;
    }

    /**
     * The processing tier to which the Account Holder should be updated. &gt;The processing tier can not be lowered through this request.  &gt;Required if accountHolderDetails are not provided.
     *
     * @return processingTier
     **/
    public Integer getProcessingTier() {
        return processingTier;
    }

    public void setProcessingTier(Integer processingTier) {
        this.processingTier = processingTier;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateAccountHolderRequest updateAccountHolderRequest = (UpdateAccountHolderRequest) o;
        return Objects.equals(this.accountHolderCode, updateAccountHolderRequest.accountHolderCode) &&
                Objects.equals(this.accountHolderDetails, updateAccountHolderRequest.accountHolderDetails) &&
                Objects.equals(this.description, updateAccountHolderRequest.description) &&
                Objects.equals(this.legalEntity, updateAccountHolderRequest.legalEntity) &&
                Objects.equals(this.primaryCurrency, updateAccountHolderRequest.primaryCurrency) &&
                Objects.equals(this.processingTier, updateAccountHolderRequest.processingTier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, accountHolderDetails, description, legalEntity, primaryCurrency, processingTier);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateAccountHolderRequest {\n");

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    accountHolderDetails: ").append(toIndentedString(accountHolderDetails)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    legalEntity: ").append(toIndentedString(legalEntity)).append("\n");
        sb.append("    primaryCurrency: ").append(toIndentedString(primaryCurrency)).append("\n");
        sb.append("    processingTier: ").append(toIndentedString(processingTier)).append("\n");
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
