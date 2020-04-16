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

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * RecurringDetail
 */

public class RecurringDetail {
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

    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

    @SerializedName("storedDetails")
    private StoredDetails storedDetails = null;

    @SerializedName("supportsRecurring")
    private Boolean supportsRecurring = null;

    @SerializedName("type")
    private String type = null;

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
        return Objects.equals(brands, recurringDetail.brands) &&
                Objects.equals(configuration, recurringDetail.configuration) &&
                Objects.equals(details, recurringDetail.details) &&
                Objects.equals(group, recurringDetail.group) &&
                Objects.equals(name, recurringDetail.name) &&
                Objects.equals(paymentMethodData, recurringDetail.paymentMethodData) &&
                Objects.equals(recurringDetailReference, recurringDetail.recurringDetailReference) &&
                Objects.equals(storedDetails, recurringDetail.storedDetails) &&
                Objects.equals(supportsRecurring, recurringDetail.supportsRecurring) &&
                Objects.equals(type, recurringDetail.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brands, configuration, details, group, name, paymentMethodData, recurringDetailReference, storedDetails, supportsRecurring, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RecurringDetail {\n");

        sb.append("    brands: ").append(toIndentedString(brands)).append("\n");
        sb.append("    configuration: ").append(toIndentedString(configuration)).append("\n");
        sb.append("    details: ").append(toIndentedString(details)).append("\n");
        sb.append("    group: ").append(toIndentedString(group)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    paymentMethodData: ").append(toIndentedString(paymentMethodData)).append("\n");
        sb.append("    recurringDetailReference: ").append(toIndentedString(recurringDetailReference)).append("\n");
        sb.append("    storedDetails: ").append(toIndentedString(storedDetails)).append("\n");
        sb.append("    supportsRecurring: ").append(toIndentedString(supportsRecurring)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private static String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
