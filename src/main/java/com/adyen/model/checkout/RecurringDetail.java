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
 * Copyright (c) 2018 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.checkout;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * RecurringDetail
 */

public class RecurringDetail {
    @SerializedName("brand")
    private String brand = null;

    @SerializedName("brands")
    private List<String> brands = null;

    @SerializedName("configuration")
    private Map<String, String> configuration = null;

    /**
     * The funding source of the payment method.
     */
    @JsonAdapter(FundingSourceEnum.Adapter.class)
    public enum FundingSourceEnum {
        DEBIT("debit");

        private final String value;

        FundingSourceEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static FundingSourceEnum fromValue(String input) {
            for (FundingSourceEnum b : FundingSourceEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<FundingSourceEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final FundingSourceEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public FundingSourceEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return FundingSourceEnum.fromValue((String) (value));
            }
        }
    }  @SerializedName("fundingSource")
    private FundingSourceEnum fundingSource = null;

    @SerializedName("group")
    private PaymentMethodGroup group = null;

    @SerializedName("inputDetails")
    private List<InputDetail> inputDetails = null;

    @SerializedName("issuers")
    private List<PaymentMethodIssuer> issuers = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

    @SerializedName("storedDetails")
    private StoredDetails storedDetails = null;

    @SerializedName("type")
    private String type = null;

    public RecurringDetail brand(String brand) {
        this.brand = brand;
        return this;
    }

    /**
     * Brand for the selected gift card. For example: plastix, hmclub.
     * @return brand
     **/
    @Schema(description = "Brand for the selected gift card. For example: plastix, hmclub.")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public RecurringDetail brands(List<String> brands) {
        this.brands = brands;
        return this;
    }

    public RecurringDetail addBrandsItem(String brandsItem) {
        if (this.brands == null) {
            this.brands = new ArrayList<String>();
        }
        this.brands.add(brandsItem);
        return this;
    }

    /**
     * List of possible brands. For example: visa, mc.
     * @return brands
     **/
    @Schema(description = "List of possible brands. For example: visa, mc.")
    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public RecurringDetail configuration(Map<String, String> configuration) {
        this.configuration = configuration;
        return this;
    }

    public RecurringDetail putConfigurationItem(String key, String configurationItem) {
        if (this.configuration == null) {
            this.configuration = new HashMap<String, String>();
        }
        this.configuration.put(key, configurationItem);
        return this;
    }

    /**
     * The configuration of the payment method.
     * @return onfiguration
     **/
    @Schema(description = "The configuration of the payment method.")
    public Map<String, String> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Map<String, String> configuration) {
        this.configuration = configuration;
    }

    public RecurringDetail fundingSource(FundingSourceEnum fundingSource) {
        this.fundingSource = fundingSource;
        return this;
    }

    /**
     * The funding source of the payment method.
     * @return fundingSource
     **/
    @Schema(description = "The funding source of the payment method.")
    public FundingSourceEnum getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(FundingSourceEnum fundingSource) {
        this.fundingSource = fundingSource;
    }

    public RecurringDetail group(PaymentMethodGroup group) {
        this.group = group;
        return this;
    }

    /**
     * Get group
     * @return group
     **/
    @Schema(description = "")
    public PaymentMethodGroup getGroup() {
        return group;
    }

    public void setGroup(PaymentMethodGroup group) {
        this.group = group;
    }

    public RecurringDetail inputDetails(List<InputDetail> inputDetails) {
        this.inputDetails = inputDetails;
        return this;
    }

    public RecurringDetail addInputDetailsItem(InputDetail inputDetailsItem) {
        if (this.inputDetails == null) {
            this.inputDetails = new ArrayList<InputDetail>();
        }
        this.inputDetails.add(inputDetailsItem);
        return this;
    }

    /**
     * All input details to be provided to complete the payment with this payment method.
     * @return inputDetails
     **/
    @Schema(description = "All input details to be provided to complete the payment with this payment method.")
    public List<InputDetail> getInputDetails() {
        return inputDetails;
    }

    public void setInputDetails(List<InputDetail> inputDetails) {
        this.inputDetails = inputDetails;
    }

    public RecurringDetail issuers(List<PaymentMethodIssuer> issuers) {
        this.issuers = issuers;
        return this;
    }

    public RecurringDetail addIssuersItem(PaymentMethodIssuer issuersItem) {
        if (this.issuers == null) {
            this.issuers = new ArrayList<PaymentMethodIssuer>();
        }
        this.issuers.add(issuersItem);
        return this;
    }

    /**
     * A list of issuers for this payment method.
     * @return issuers
     **/
    @Schema(description = "A list of issuers for this payment method.")
    public List<PaymentMethodIssuer> getIssuers() {
        return issuers;
    }

    public void setIssuers(List<PaymentMethodIssuer> issuers) {
        this.issuers = issuers;
    }

    public RecurringDetail name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The displayable name of this payment method.
     * @return name
     **/
    @Schema(description = "The displayable name of this payment method.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RecurringDetail recurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
        return this;
    }

    /**
     * The reference that uniquely identifies the recurring detail.
     * @return recurringDetailReference
     **/
    @Schema(description = "The reference that uniquely identifies the recurring detail.")
    public String getRecurringDetailReference() {
        return recurringDetailReference;
    }

    public void setRecurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
    }

    public RecurringDetail storedDetails(StoredDetails storedDetails) {
        this.storedDetails = storedDetails;
        return this;
    }

    /**
     * Get storedDetails
     * @return storedDetails
     **/
    @Schema(description = "")
    public StoredDetails getStoredDetails() {
        return storedDetails;
    }

    public void setStoredDetails(StoredDetails storedDetails) {
        this.storedDetails = storedDetails;
    }

    public RecurringDetail type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The unique payment method code.
     * @return type
     **/
    @Schema(description = "The unique payment method code.")
    public String getType() {
        return type;
    }

    public void setType(String type) {
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
        RecurringDetail recurringDetail = (RecurringDetail) o;
        return Objects.equals(this.brand, recurringDetail.brand) &&
                Objects.equals(this.brands, recurringDetail.brands) &&
                Objects.equals(this.configuration, recurringDetail.configuration) &&
                Objects.equals(this.fundingSource, recurringDetail.fundingSource) &&
                Objects.equals(this.group, recurringDetail.group) &&
                Objects.equals(this.inputDetails, recurringDetail.inputDetails) &&
                Objects.equals(this.issuers, recurringDetail.issuers) &&
                Objects.equals(this.name, recurringDetail.name) &&
                Objects.equals(this.recurringDetailReference, recurringDetail.recurringDetailReference) &&
                Objects.equals(this.storedDetails, recurringDetail.storedDetails) &&
                Objects.equals(this.type, recurringDetail.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, brands, configuration, fundingSource, group, inputDetails, issuers, name, recurringDetailReference, storedDetails, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RecurringDetail {\n");

        sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
        sb.append("    brands: ").append(toIndentedString(brands)).append("\n");
        sb.append("    _configuration: ").append(toIndentedString(configuration)).append("\n");
        sb.append("    fundingSource: ").append(toIndentedString(fundingSource)).append("\n");
        sb.append("    group: ").append(toIndentedString(group)).append("\n");
        sb.append("    inputDetails: ").append(toIndentedString(inputDetails)).append("\n");
        sb.append("    issuers: ").append(toIndentedString(issuers)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    recurringDetailReference: ").append(toIndentedString(recurringDetailReference)).append("\n");
        sb.append("    storedDetails: ").append(toIndentedString(storedDetails)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
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
