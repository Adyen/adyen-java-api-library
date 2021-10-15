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
 * PaymentMethod
 */
public class PaymentMethod {
    @SerializedName("brand")
    private String brand = null;

    @SerializedName("brands")
    private List<String> brands = null;

    @SerializedName("configuration")
    private Map<String, String> configuration = null;

    @SerializedName("details")
    private List<InputDetail> details = null;

    @SerializedName("issuers")
    private List<PaymentMethodIssuer> issuers = null;

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

    @SerializedName("name")
    private String name = null;

    @SerializedName("type")
    private String type = null;

    public PaymentMethod brand(String brand) {
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

    public PaymentMethod brands(List<String> brands) {
        this.brands = brands;
        return this;
    }

    public PaymentMethod addBrandsItem(String brandsItem) {
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

    public PaymentMethod configuration(Map<String, String> configuration) {
        this.configuration = configuration;
        return this;
    }

    public PaymentMethod putConfigurationItem(String key, String configurationItem) {

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

    public PaymentMethod details(List<InputDetail> details) {
        this.details = details;
        return this;
    }

    public PaymentMethod addDetailsItem(InputDetail detailsItem) {

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

    public PaymentMethod fundingSource(FundingSourceEnum fundingSource) {
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


    public PaymentMethod group(PaymentMethodGroup group) {
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

    public PaymentMethod name(String name) {
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

    public PaymentMethod supportsRecurring(Boolean supportsRecurring) {
        return this;
    }

    public PaymentMethod type(String type) {
        this.type = type;
        return this;
    }


    public PaymentMethod issuers(List<PaymentMethodIssuer> issuers) {

        this.issuers = issuers;
        return this;
    }

    public PaymentMethod addIssuersItem(PaymentMethodIssuer issuersItem) {
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
    public List<PaymentMethodIssuer> getIssuers() {
        return issuers;
    }


    public void setIssuers(List<PaymentMethodIssuer> issuers) {
        this.issuers = issuers;
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
        PaymentMethod paymentMethod = (PaymentMethod) o;
        return Objects.equals(this.brand, paymentMethod.brand) &&
                Objects.equals(this.brands, paymentMethod.brands) &&
                Objects.equals(this.configuration, paymentMethod.configuration) &&
                Objects.equals(this.details, paymentMethod.details) &&
                Objects.equals(this.fundingSource, paymentMethod.fundingSource) &&
                Objects.equals(this.group, paymentMethod.group) &&
                Objects.equals(this.name, paymentMethod.name) &&
                Objects.equals(this.issuers, paymentMethod.issuers) &&
                Objects.equals(this.type, paymentMethod.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, brands, configuration, details, fundingSource, group,
                name, issuers, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentMethod {\n");

        sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
        sb.append("    brands: ").append(toIndentedString(brands)).append("\n");
        sb.append("    configuration: ").append(toIndentedString(configuration)).append("\n");
        sb.append("    details: ").append(toIndentedString(details)).append("\n");
        sb.append("    fundingSource: ").append(toIndentedString(fundingSource)).append("\n");
        sb.append("    group: ").append(toIndentedString(group)).append("\n");
        sb.append("    issuers: ").append(toIndentedString(issuers)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
