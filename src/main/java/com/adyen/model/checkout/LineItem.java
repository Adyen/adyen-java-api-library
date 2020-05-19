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

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/**
 * LineItem
 */
public class LineItem {

    @SerializedName("amountExcludingTax")
    private Long amountExcludingTax = null;

    @SerializedName("amountIncludingTax")
    private Long amountIncludingTax = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("id")
    private String id = null;

    @SerializedName("quantity")
    private Long quantity = null;

    @SerializedName("taxAmount")
    private Long taxAmount = null;
    @SerializedName("taxCategory")
    private TaxCategoryEnum taxCategory = null;
    @SerializedName("taxPercentage")
    private Long taxPercentage = null;

    public LineItem amountExcludingTax(Long amountExcludingTax) {
        this.amountExcludingTax = amountExcludingTax;
        return this;
    }

    /**
     * Item amount excluding the tax, in minor units.
     *
     * @return amountExcludingTax
     **/
    public Long getAmountExcludingTax() {
        return amountExcludingTax;
    }

    public void setAmountExcludingTax(Long amountExcludingTax) {
        this.amountExcludingTax = amountExcludingTax;
    }

    public LineItem amountIncludingTax(Long amountIncludingTax) {
        this.amountIncludingTax = amountIncludingTax;
        return this;
    }

    /**
     * Item amount including the tax, in minor units.
     *
     * @return amountIncludingTax
     **/
    public Long getAmountIncludingTax() {
        return amountIncludingTax;
    }

    public void setAmountIncludingTax(Long amountIncludingTax) {
        this.amountIncludingTax = amountIncludingTax;
    }

    public LineItem description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description of the line item.
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LineItem id(String id) {
        this.id = id;
        return this;
    }

    /**
     * ID of the line item.
     *
     * @return id
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LineItem quantity(Long quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Number of items.
     *
     * @return quantity
     **/
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public LineItem taxAmount(Long taxAmount) {
        this.taxAmount = taxAmount;
        return this;
    }

    /**
     * Tax amount, in minor units.
     *
     * @return taxAmount
     **/
    public Long getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Long taxAmount) {
        this.taxAmount = taxAmount;
    }

    public LineItem taxCategory(TaxCategoryEnum taxCategory) {
        this.taxCategory = taxCategory;
        return this;
    }

    /**
     * Tax category: High, Low, None, Zero
     *
     * @return taxCategory
     **/
    public TaxCategoryEnum getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(TaxCategoryEnum taxCategory) {
        this.taxCategory = taxCategory;
    }

    public LineItem taxPercentage(Long taxPercentage) {
        this.taxPercentage = taxPercentage;
        return this;
    }

    /**
     * Tax percentage, in minor units.
     *
     * @return taxPercentage
     **/
    public Long getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Long taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LineItem lineItem = (LineItem) o;
        return Objects.equals(this.amountExcludingTax, lineItem.amountExcludingTax) &&
                Objects.equals(this.amountIncludingTax, lineItem.amountIncludingTax) &&
                Objects.equals(this.description, lineItem.description) &&
                Objects.equals(this.id, lineItem.id) &&
                Objects.equals(this.quantity, lineItem.quantity) &&
                Objects.equals(this.taxAmount, lineItem.taxAmount) &&
                Objects.equals(this.taxCategory, lineItem.taxCategory) &&
                Objects.equals(this.taxPercentage, lineItem.taxPercentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountExcludingTax, amountIncludingTax, description, id, quantity, taxAmount, taxCategory, taxPercentage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LineItem {\n");

        sb.append("    amountExcludingTax: ").append(toIndentedString(amountExcludingTax)).append("\n");
        sb.append("    amountIncludingTax: ").append(toIndentedString(amountIncludingTax)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
        sb.append("    taxAmount: ").append(toIndentedString(taxAmount)).append("\n");
        sb.append("    taxCategory: ").append(toIndentedString(taxCategory)).append("\n");
        sb.append("    taxPercentage: ").append(toIndentedString(taxPercentage)).append("\n");
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

    /**
     * Tax category: High, Low, None, Zero
     */
    @JsonAdapter(TaxCategoryEnum.Adapter.class)
    public enum TaxCategoryEnum {

        HIGH("High"),
        LOW("Low"),
        NONE("None"),
        ZERO("Zero");

        private String value;

        TaxCategoryEnum(String value) {
            this.value = value;
        }

        public static TaxCategoryEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static class Adapter extends TypeAdapter<TaxCategoryEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TaxCategoryEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TaxCategoryEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return TaxCategoryEnum.fromValue(String.valueOf(value));
            }
        }
    }


}



