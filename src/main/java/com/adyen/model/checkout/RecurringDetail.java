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

import com.fasterxml.jackson.annotation.JsonValue;
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
 * RecurringDetail
 */

public class RecurringDetail {
    @SerializedName("brand")
    private String brand = null;

    @SerializedName("brands")
    private List<String> brands = null;

    @SerializedName("configuration")
    private Map<String, String> configuration = null;

    @SerializedName("details")
    private List<InputDetail> details = null;

    /**
     * The funding source of the payment method.
     */
    @JsonAdapter(FundingSourceEnum.Adapter.class)
    public enum FundingSourceEnum {
        DEBIT("debit");

        @JsonValue
        private String value;

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

        public static FundingSourceEnum fromValue(String text) {
            for (FundingSourceEnum b : FundingSourceEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<FundingSourceEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final FundingSourceEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public FundingSourceEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return FundingSourceEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("fundingSource")
    private FundingSourceEnum fundingSource = null;

    @SerializedName("group")
    private PaymentMethodGroup group = null;

    @SerializedName("inputDetails")
    private List<InputDetail> inputDetails = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("paymentMethodData")
    private String paymentMethodData = null;

    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

    @SerializedName("storedDetails")
    private StoredDetails storedDetails = null;

    @SerializedName("supportsRecurring")
    private Boolean supportsRecurring = null;

    @SerializedName("type")
    private String type = null;

    public RecurringDetail brand(String brand) {
        this.brand = brand;
        return this;
    }

    /**
     * Brand for the selected gift card. For example: plastix, hmclub.
     *
     * @return brand
     **/
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
        if (brands == null) {
            brands = new ArrayList<>();
        }
        brands.add(brandsItem);
        return this;
    }

    /**
     * List of possible brands. For example: visa, mc.
     *
     * @return brands
     **/
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

        if (configuration == null) {
            configuration = new HashMap<>();
        }

        configuration.put(key, configurationItem);
        return this;
    }

    /**
     * The configuration of the payment method.
     *
     * @return configuration
     **/
    public Map<String, String> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Map<String, String> configuration) {
        this.configuration = configuration;
    }

    public RecurringDetail details(List<InputDetail> details) {
        this.details = details;
        return this;
    }

    public RecurringDetail addDetailsItem(InputDetail detailsItem) {
        if (details == null) {
            details = new ArrayList<>();
        }
        details.add(detailsItem);
        return this;
    }

    /**
     * All input details to be provided to complete the payment with this payment method.
     *
     * @return details
     **/
    public List<InputDetail> getDetails() {
        return details;
    }

    public void setDetails(List<InputDetail> details) {
        this.details = details;
    }

    public RecurringDetail fundingSource(FundingSourceEnum fundingSource) {
        this.fundingSource = fundingSource;
        return this;
    }

    /**
     * The funding source of the payment method.
     *
     * @return fundingSource
     **/
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
     *
     * @return group
     **/
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
     *
     * @return inputDetails
     **/
    public List<InputDetail> getInputDetails() {
        return inputDetails;
    }

    public void setInputDetails(List<InputDetail> inputDetails) {
        this.inputDetails = inputDetails;
    }


    public RecurringDetail name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The displayable name of this payment method.
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RecurringDetail paymentMethodData(String paymentMethodData) {
        this.paymentMethodData = paymentMethodData;
        return this;
    }

    /**
     * Echo data required to send in next calls.
     *
     * @return paymentMethodData
     **/
    public String getPaymentMethodData() {
        return paymentMethodData;
    }

    public void setPaymentMethodData(String paymentMethodData) {
        this.paymentMethodData = paymentMethodData;
    }

    public RecurringDetail recurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
        return this;
    }

    /**
     * The reference that uniquely identifies the recurring detail.
     *
     * @return recurringDetailReference
     **/
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
     *
     * @return storedDetails
     **/
    public StoredDetails getStoredDetails() {
        return storedDetails;
    }

    public void setStoredDetails(StoredDetails storedDetails) {
        this.storedDetails = storedDetails;
    }

    public RecurringDetail supportsRecurring(Boolean supportsRecurring) {
        this.supportsRecurring = supportsRecurring;
        return this;
    }

    /**
     * Indicates whether this payment method supports tokenization or not.
     *
     * @return supportsRecurring
     **/
    public Boolean isSupportsRecurring() {
        return supportsRecurring;
    }

    public void setSupportsRecurring(Boolean supportsRecurring) {
        this.supportsRecurring = supportsRecurring;
    }

    public RecurringDetail type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The unique payment method code.
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
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
                Objects.equals(this.details, recurringDetail.details) &&
                Objects.equals(this.fundingSource, recurringDetail.fundingSource) &&
                Objects.equals(this.group, recurringDetail.group) &&
                Objects.equals(this.inputDetails, recurringDetail.inputDetails) &&
                Objects.equals(this.name, recurringDetail.name) &&
                Objects.equals(this.recurringDetailReference, recurringDetail.recurringDetailReference) &&
                Objects.equals(this.storedDetails, recurringDetail.storedDetails) &&
                Objects.equals(this.type, recurringDetail.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, brands, configuration, details, fundingSource, group, inputDetails, name,
                recurringDetailReference, storedDetails, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RecurringDetail {\n");

        sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
        sb.append("    brands: ").append(toIndentedString(brands)).append("\n");
        sb.append("    configuration: ").append(toIndentedString(configuration)).append("\n");
        sb.append("    details: ").append(toIndentedString(details)).append("\n");
        sb.append("    fundingSource: ").append(toIndentedString(fundingSource)).append("\n");
        sb.append("    group: ").append(toIndentedString(group)).append("\n");
        sb.append("    inputDetails: ").append(toIndentedString(inputDetails)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    recurringDetailReference: ").append(toIndentedString(recurringDetailReference)).append("\n");
        sb.append("    storedDetails: ").append(toIndentedString(storedDetails)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
