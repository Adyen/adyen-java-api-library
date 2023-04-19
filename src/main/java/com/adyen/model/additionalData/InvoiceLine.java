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
package com.adyen.model.additionalData;

import com.adyen.enums.VatCategory;

import static com.adyen.util.Util.toIndentedString;


public class InvoiceLine {

    private String currencyCode = null;
    private String description = null;
    private Long itemAmount = null;
    private Long itemVATAmount = null;
    private Long itemVatPercentage = null;
    private Integer numberOfItems = null;
    private VatCategory vatCategory = null;
    private String itemId = null;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(Long itemAmount) {
        this.itemAmount = itemAmount;
    }

    public Long getItemVATAmount() {
        return itemVATAmount;
    }

    public void setItemVATAmount(Long itemVATAmount) {
        this.itemVATAmount = itemVATAmount;
    }

    public Long getItemVatPercentage() {
        return itemVatPercentage;
    }

    public void setItemVatPercentage(Long itemVatPercentage) {
        this.itemVatPercentage = itemVatPercentage;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public VatCategory getVatCategory() {
        return vatCategory;
    }

    public void setVatCategory(VatCategory vatCategory) {
        this.vatCategory = vatCategory;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        String sb = "class InvoiceLine {\n" +
                "    currencyCode: " + toIndentedString(currencyCode) + "\n" +
                "    description: " + toIndentedString(description) + "\n" +
                "    itemAmount: " + toIndentedString(itemAmount) + "\n" +
                "    itemVATAmount: " + toIndentedString(itemVATAmount) + "\n" +
                "    itemVatPercentage: " + toIndentedString(itemVatPercentage) + "\n" +
                "    numberOfItems: " + toIndentedString(numberOfItems) + "\n" +
                "    vatCategory: " + toIndentedString(vatCategory) + "\n" +
                "    itemId: " + toIndentedString(itemId) + "\n" +
                "}";
        return sb;
    }
}
