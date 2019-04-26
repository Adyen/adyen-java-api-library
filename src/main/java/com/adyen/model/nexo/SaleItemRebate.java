
package com.adyen.model.nexo;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: The awarded amount that is attached to an item as a rebate. -- Usage: To be differentiated from the award which is the amount or quantity earned on the loyalty account.
 *
 * <p>Java class for SaleItemRebate complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SaleItemRebate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnitOfMeasure" type="{}UnitOfMeasureType" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{}Quantity" minOccurs="0"/>
 *         &lt;element name="RebateLabel" type="{}RebateLabel" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ItemID" use="required" type="{}ItemID" />
 *       &lt;attribute name="ProductCode" use="required" type="{}ProductCode" />
 *       &lt;attribute name="EanUpc" type="{}EanUpc" />
 *       &lt;attribute name="ItemAmount" type="{}SimpleAmountType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaleItemRebate", propOrder = {
    "unitOfMeasure",
    "quantity",
    "rebateLabel"
})
public class SaleItemRebate {

    @XmlElement(name = "UnitOfMeasure")
    @XmlSchemaType(name = "string")
    protected UnitOfMeasureType unitOfMeasure;
    @XmlElement(name = "Quantity")
    protected BigDecimal quantity;
    @XmlElement(name = "RebateLabel")
    protected String rebateLabel;
    @XmlAttribute(name = "ItemID", required = true)
    protected BigInteger itemID;
    @XmlAttribute(name = "ProductCode", required = true)
    protected String productCode;
    @XmlAttribute(name = "EanUpc")
    protected String eanUpc;
    @XmlAttribute(name = "ItemAmount")
    protected BigDecimal itemAmount;

    /**
     * Gets the value of the unitOfMeasure property.
     *
     * @return
     *     possible object is
     *     {@link UnitOfMeasureType }
     *
     */
    public UnitOfMeasureType getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * Sets the value of the unitOfMeasure property.
     *
     * @param value
     *     allowed object is
     *     {@link UnitOfMeasureType }
     *
     */
    public void setUnitOfMeasure(UnitOfMeasureType value) {
        this.unitOfMeasure = value;
    }

    /**
     * Gets the value of the quantity property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setQuantity(BigDecimal value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the rebateLabel property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRebateLabel() {
        return rebateLabel;
    }

    /**
     * Sets the value of the rebateLabel property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRebateLabel(String value) {
        this.rebateLabel = value;
    }

    /**
     * Gets the value of the itemID property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getItemID() {
        return itemID;
    }

    /**
     * Sets the value of the itemID property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setItemID(BigInteger value) {
        this.itemID = value;
    }

    /**
     * Gets the value of the productCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Sets the value of the productCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProductCode(String value) {
        this.productCode = value;
    }

    /**
     * Gets the value of the eanUpc property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEanUpc() {
        return eanUpc;
    }

    /**
     * Sets the value of the eanUpc property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEanUpc(String value) {
        this.eanUpc = value;
    }

    /**
     * Gets the value of the itemAmount property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getItemAmount() {
        return itemAmount;
    }

    /**
     * Sets the value of the itemAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setItemAmount(BigDecimal value) {
        this.itemAmount = value;
    }

}
