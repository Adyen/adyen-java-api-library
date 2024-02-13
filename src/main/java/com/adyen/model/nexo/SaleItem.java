package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * Definition: Sale items of a transaction. -- Usage: In loyalty or value added payment card transaction, the items of the sale are entering in the processing of the transaction. The sum of the item amount could be more than the Requested amount in case of split payment without split of the
 *
 * <p>Java class for SaleItem complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SaleItem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UnitOfMeasure" type="{}UnitOfMeasureType" minOccurs="0"/&gt;
 *         &lt;element name="Quantity" type="{}Quantity" minOccurs="0"/&gt;
 *         &lt;element name="UnitPrice" type="{}SimpleAmountType" minOccurs="0"/&gt;
 *         &lt;element name="TaxCode" type="{}TaxCode" minOccurs="0"/&gt;
 *         &lt;element name="SaleChannel" type="{}SaleChannel" minOccurs="0"/&gt;
 *         &lt;element name="ProductLabel" type="{}ProductLabel" minOccurs="0"/&gt;
 *         &lt;element name="AdditionalProductInfo" type="{}AdditionalProductInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ItemID" use="required" type="{}ItemID" /&gt;
 *       &lt;attribute name="ProductCode" use="required" type="{}ProductCode" /&gt;
 *       &lt;attribute name="EanUpc" type="{}EanUpc" /&gt;
 *       &lt;attribute name="ItemAmount" use="required" type="{}SimpleAmountType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaleItem", propOrder = {
        "unitOfMeasure",
        "quantity",
        "unitPrice",
        "taxCode",
        "saleChannel",
        "productLabel",
        "additionalProductInfo"
})
public class SaleItem {

    /**
     * The Unit of measure.
     */
    @XmlElement(name = "UnitOfMeasure")
    @Schema(description = "Unit of measure of a quantity --Rule: if Quantity present")
    @XmlSchemaType(name = "string")
    protected UnitOfMeasureType unitOfMeasure;
    /**
     * The Quantity.
     */
    @XmlElement(name = "Quantity")
    @Schema(description = "Product quantity --Rule: If data sent, POI has to store it and send it if the host protocol allows it")
    protected BigDecimal quantity;
    /**
     * The Unit price.
     */
    @XmlElement(name = "UnitPrice")
    @Schema(description = "Price per unit of product --Rule: if Quantity present")
    protected BigDecimal unitPrice;
    /**
     * The Tax code.
     */
    @XmlElement(name = "TaxCode")
    @Schema(description = "Type of taxes associated to the line item. --Rule: If data sent, POI has to store it and send it if the host protocol allows it")
    protected String taxCode;
    /**
     * The Sale channel.
     */
    @XmlElement(name = "SaleChannel")
    @Schema(description = "Commercial or distribution channel associated to the line item. --Rule: If data sent, POI has to store it and send it if the host protocol allows it")
    protected String saleChannel;
    /**
     * The Product label.
     */
    @XmlElement(name = "ProductLabel")
    @Schema(description = "Product name of an item purchased with the transaction.")
    protected String productLabel;
    /**
     * The Additional product info.
     */
    @XmlElement(name = "AdditionalProductInfo")
    @Schema(description = "Additionl information related to the line item. --Rule: If data sent, POI has to store it and send it if the host protocol allows it")
    protected String additionalProductInfo;
    /**
     * The Item id.
     */
    @XmlElement(name = "ItemID", required = true)
    @Schema(description = "Item identification inside a transaction (0 to n).")
    protected BigInteger itemID;
    /**
     * The Product code.
     */
    @XmlElement(name = "ProductCode", required = true)
    @Schema(description = "Product code of item purchased with the transaction.")
    protected String productCode;
    /**
     * The Ean upc.
     */
    @XmlElement(name = "EanUpc")
    @Schema(description = "Standard product code of item purchased with the transaction. --Rule: If data sent, POI has to store it and send it if the host protocol allows it")
    protected String eanUpc;
    /**
     * The Item amount.
     */
    @XmlElement(name = "ItemAmount", required = true)
    @Schema(description = "Total amount of the item line.")
    protected BigDecimal itemAmount;

    /**
     * Gets the value of the unitOfMeasure property.
     *
     * @return possible      object is     {@link UnitOfMeasureType }
     */
    public UnitOfMeasureType getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * Sets the value of the unitOfMeasure property.
     *
     * @param value allowed object is     {@link UnitOfMeasureType }
     */
    public void setUnitOfMeasure(UnitOfMeasureType value) {
        this.unitOfMeasure = value;
    }

    /**
     * Gets the value of the quantity property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setQuantity(BigDecimal value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the unitPrice property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets the value of the unitPrice property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setUnitPrice(BigDecimal value) {
        this.unitPrice = value;
    }

    /**
     * Gets the value of the taxCode property.
     *
     * @return possible      object is     {@link String }
     */
    public String getTaxCode() {
        return taxCode;
    }

    /**
     * Sets the value of the taxCode property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setTaxCode(String value) {
        this.taxCode = value;
    }

    /**
     * Gets the value of the saleChannel property.
     *
     * @return possible      object is     {@link String }
     */
    public String getSaleChannel() {
        return saleChannel;
    }

    /**
     * Sets the value of the saleChannel property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setSaleChannel(String value) {
        this.saleChannel = value;
    }

    /**
     * Gets the value of the productLabel property.
     *
     * @return possible      object is     {@link String }
     */
    public String getProductLabel() {
        return productLabel;
    }

    /**
     * Sets the value of the productLabel property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setProductLabel(String value) {
        this.productLabel = value;
    }

    /**
     * Gets the value of the additionalProductInfo property.
     *
     * @return possible      object is     {@link String }
     */
    public String getAdditionalProductInfo() {
        return additionalProductInfo;
    }

    /**
     * Sets the value of the additionalProductInfo property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setAdditionalProductInfo(String value) {
        this.additionalProductInfo = value;
    }

    /**
     * Gets the value of the itemID property.
     *
     * @return possible      object is     {@link BigInteger }
     */
    public BigInteger getItemID() {
        return itemID;
    }

    /**
     * Sets the value of the itemID property.
     *
     * @param value allowed object is     {@link BigInteger }
     */
    public void setItemID(BigInteger value) {
        this.itemID = value;
    }

    /**
     * Gets the value of the productCode property.
     *
     * @return possible      object is     {@link String }
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Sets the value of the productCode property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setProductCode(String value) {
        this.productCode = value;
    }

    /**
     * Gets the value of the eanUpc property.
     *
     * @return possible      object is     {@link String }
     */
    public String getEanUpc() {
        return eanUpc;
    }

    /**
     * Sets the value of the eanUpc property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setEanUpc(String value) {
        this.eanUpc = value;
    }

    /**
     * Gets the value of the itemAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getItemAmount() {
        return itemAmount;
    }

    /**
     * Sets the value of the itemAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setItemAmount(BigDecimal value) {
        this.itemAmount = value;
    }

}
