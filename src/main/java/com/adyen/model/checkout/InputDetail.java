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
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * InputDetail
 */
public class InputDetail {

    @SerializedName("configuration")
    private Map<String, String> _configuration = null;

    @SerializedName("details")
    private List<SubInputDetail> details = null;

    @SerializedName("itemSearchUrl")
    private String itemSearchUrl = null;

    @SerializedName("items")
    private List<Item> items = null;

    @SerializedName("key")
    private String key = null;

    @SerializedName("optional")
    private Boolean optional = null;

    @SerializedName("type")
    private String type = null;

    @SerializedName("value")
    private String value = null;

    public InputDetail _configuration(Map<String, String> _configuration) {
        this._configuration = _configuration;
        return this;
    }

    public InputDetail putConfigurationItem(String key, String _configurationItem) {

        if (this._configuration == null) {
            this._configuration = null;
        }

        this._configuration.put(key, _configurationItem);
        return this;
    }

    /**
     * Configuration parameters for the required input.
     *
     * @return _configuration
     **/
    public Map<String, String> getConfiguration() {
        return _configuration;
    }

    public void setConfiguration(Map<String, String> _configuration) {
        this._configuration = _configuration;
    }

    public InputDetail details(List<SubInputDetail> details) {
        this.details = details;
        return this;
    }

    public InputDetail addDetailsItem(SubInputDetail detailsItem) {

        if (this.details == null) {
            this.details = new ArrayList<SubInputDetail>();
        }

        this.details.add(detailsItem);
        return this;
    }

    /**
     * Input details can also be provided recursively.
     *
     * @return details
     **/
    public List<SubInputDetail> getDetails() {
        return details;
    }

    public void setDetails(List<SubInputDetail> details) {
        this.details = details;
    }

    public InputDetail itemSearchUrl(String itemSearchUrl) {
        this.itemSearchUrl = itemSearchUrl;
        return this;
    }


    /**
     * In case of a select, the URL from which to query the items.
     *
     * @return itemSearchUrl
     **/
    public String getItemSearchUrl() {
        return itemSearchUrl;
    }

    public void setItemSearchUrl(String itemSearchUrl) {
        this.itemSearchUrl = itemSearchUrl;
    }

    public InputDetail items(List<Item> items) {
        this.items = items;
        return this;
    }

    public InputDetail addItemsItem(Item itemsItem) {

        if (this.items == null) {
            this.items = new ArrayList<Item>();
        }

        this.items.add(itemsItem);
        return this;
    }

    /**
     * In case of a select, the items to choose from.
     *
     * @return items
     **/
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public InputDetail key(String key) {
        this.key = key;
        return this;
    }


    /**
     * The value to provide in the result.
     *
     * @return key
     **/
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public InputDetail optional(Boolean optional) {
        this.optional = optional;
        return this;
    }


    /**
     * True if this input is optional to provide.
     *
     * @return optional
     **/
    public Boolean isOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    public InputDetail type(String type) {
        this.type = type;
        return this;
    }


    /**
     * The type of the required input.
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public InputDetail value(String value) {
        this.value = value;
        return this;
    }


    /**
     * The value can be pre-filled, if available.
     *
     * @return value
     **/
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InputDetail inputDetail = (InputDetail) o;
        return Objects.equals(this._configuration, inputDetail._configuration) &&
                Objects.equals(this.details, inputDetail.details) &&
                Objects.equals(this.itemSearchUrl, inputDetail.itemSearchUrl) &&
                Objects.equals(this.items, inputDetail.items) &&
                Objects.equals(this.key, inputDetail.key) &&
                Objects.equals(this.optional, inputDetail.optional) &&
                Objects.equals(this.type, inputDetail.type) &&
                Objects.equals(this.value, inputDetail.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_configuration, details, itemSearchUrl, items, key, optional, type, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InputDetail {\n");

        sb.append("    _configuration: ").append(toIndentedString(_configuration)).append("\n");
        sb.append("    details: ").append(toIndentedString(details)).append("\n");
        sb.append("    itemSearchUrl: ").append(toIndentedString(itemSearchUrl)).append("\n");
        sb.append("    items: ").append(toIndentedString(items)).append("\n");
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    optional: ").append(toIndentedString(optional)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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



