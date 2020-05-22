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

import com.adyen.constants.TextConstants;
import com.google.gson.annotations.SerializedName;

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
    @SerializedName("brands")
    private List<String> brands = null;

    @SerializedName("configuration")
    private Map<String, String> configuration = null;

    @SerializedName("details")
    private List<InputDetail> details = null;

    @SerializedName("group")
    private PaymentMethodGroup group = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("paymentMethodData")
    private String paymentMethodData = null;

    @SerializedName("supportsRecurring")
    private Boolean supportsRecurring = null;

    @SerializedName("type")
    private String type = null;

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

    public PaymentMethod paymentMethodData(String paymentMethodData) {
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

    public PaymentMethod supportsRecurring(Boolean supportsRecurring) {
        this.supportsRecurring = supportsRecurring;
        return this;
    }

    /**
     * Indicates whether this payment method supports tokenization or not.
     *
     * @return supportsRecurring
     **/
    public Boolean getSupportsRecurring() {
        return supportsRecurring;
    }

    public void setSupportsRecurring(Boolean supportsRecurring) {
        this.supportsRecurring = supportsRecurring;
    }

    public PaymentMethod type(String type) {
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
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        PaymentMethod paymentMethod = (PaymentMethod) o;
        return Objects.equals(brands, paymentMethod.brands)
                && Objects.equals(configuration, paymentMethod.configuration)
                && Objects.equals(details, paymentMethod.details)
                && Objects.equals(group, paymentMethod.group)
                && Objects.equals(name, paymentMethod.name)
                && Objects.equals(paymentMethodData, paymentMethod.paymentMethodData)
                && Objects.equals(supportsRecurring, paymentMethod.supportsRecurring)
                && Objects.equals(type, paymentMethod.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brands, configuration, details, group, name, paymentMethodData, supportsRecurring, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentMethod {").append(TextConstants.LINE_BREAK);

        sb.append("    brands: ").append(toIndentedString(brands)).append(TextConstants.LINE_BREAK);
        sb.append("    configuration: ").append(toIndentedString(configuration)).append(TextConstants.LINE_BREAK);
        sb.append("    details: ").append(toIndentedString(details)).append(TextConstants.LINE_BREAK);
        sb.append("    group: ").append(toIndentedString(group)).append(TextConstants.LINE_BREAK);
        sb.append("    name: ").append(toIndentedString(name)).append(TextConstants.LINE_BREAK);
        sb.append("    paymentMethodData: ").append(toIndentedString(paymentMethodData)).append(TextConstants.LINE_BREAK);
        sb.append("    supportsRecurring: ").append(toIndentedString(supportsRecurring)).append(TextConstants.LINE_BREAK);
        sb.append("    type: ").append(toIndentedString(type)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }
}



