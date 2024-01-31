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
 * Definition: The awarded amount that is attached to an item as a rebate. -- Usage: To be differentiated from the award which is the amount or quantity earned on the loyalty account.
 *
 * <p>Java class for SaleItemRebate complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SaleItemRebate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UnitOfMeasure" type="{}UnitOfMeasureType" minOccurs="0"/&gt;
 *         &lt;element name="Quantity" type="{}Quantity" minOccurs="0"/&gt;
 *         &lt;element name="RebateLabel" type="{}RebateLabel" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ItemID" use="required" type="{}ItemID" /&gt;
 *       &lt;attribute name="ProductCode" use="required" type="{}ProductCode" /&gt;
 *       &lt;attribute name="EanUpc" type="{}EanUpc" /&gt;
 *       &lt;attribute name="ItemAmount" type="{}SimpleAmountType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaleItemRebate", propOrder = {
        "unitOfMeasure",
        "quantity",
        "rebateLabel"
})
public class SaleItemRebate {

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
    @Schema(description = "Product quantity --Rule: if rebate is additional units")
    protected BigDecimal quantity;
    /**
     * The Rebate label.
     */
    @XmlElement(name = "RebateLabel")
    @Schema(description = "Short text to qualify a rebate on an line item. --Rule: If provided by the Acquirer")
    protected String rebateLabel;
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
    @Schema(description = "Standard product code of item purchased with the transaction. --Rule: if present in the related SaleItem")
    protected String eanUpc;
    /**
     * The Item amount.
     */
    @XmlElement(name = "ItemAmount")
    @Schema(description = "Total amount of the item line. --Rule: if rebate on the line item amount")
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
     * Gets the value of the rebateLabel property.
     *
     * @return possible      object is     {@link String }
     */
    public String getRebateLabel() {
        return rebateLabel;
    }

    /**
     * Sets the value of the rebateLabel property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setRebateLabel(String value) {
        this.rebateLabel = value;
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
