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
        StringBuilder sb = new StringBuilder();
        sb.append("class InvoiceLine {\n");
        sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    itemAmount: ").append(toIndentedString(itemAmount)).append("\n");
        sb.append("    itemVATAmount: ").append(toIndentedString(itemVATAmount)).append("\n");
        sb.append("    itemVatPercentage: ").append(toIndentedString(itemVatPercentage)).append("\n");
        sb.append("    numberOfItems: ").append(toIndentedString(numberOfItems)).append("\n");
        sb.append("    vatCategory: ").append(toIndentedString(vatCategory)).append("\n");
        sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
