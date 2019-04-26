
package com.adyen.model.nexo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the stored value card. -- Usage: It contains: - the identification of the stored value accounts or the stored value cards, if provided by the Sale System, and - the associated products sold by the Sale System..
 *
 * <p>Java class for StoredValueData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StoredValueData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StoredValueAccountID" type="{}StoredValueAccountID" minOccurs="0"/>
 *         &lt;element name="OriginalPOITransaction" type="{}OriginalPOITransaction" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="StoredValueProvider" type="{}StoredValueProvider" />
 *       &lt;attribute name="StoredValueTransaction" use="required" type="{}StoredValueTransactionType" />
 *       &lt;attribute name="ProductCode" type="{}ProductCode" />
 *       &lt;attribute name="EanUpc" type="{}EanUpc" />
 *       &lt;attribute name="ItemAmount" use="required" type="{}SimpleAmountType" />
 *       &lt;attribute name="Currency" use="required" type="{}ISOCurrency3A" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoredValueData", propOrder = {
    "storedValueAccountID",
    "originalPOITransaction"
})
public class StoredValueData {

    @XmlElement(name = "StoredValueAccountID")
    protected StoredValueAccountID storedValueAccountID;
    @XmlElement(name = "OriginalPOITransaction")
    protected OriginalPOITransaction originalPOITransaction;
    @XmlAttribute(name = "StoredValueProvider")
    protected String storedValueProvider;
    @XmlAttribute(name = "StoredValueTransaction", required = true)
    protected StoredValueTransactionType storedValueTransaction;
    @XmlAttribute(name = "ProductCode")
    protected String productCode;
    @XmlAttribute(name = "EanUpc")
    protected String eanUpc;
    @XmlAttribute(name = "ItemAmount", required = true)
    protected BigDecimal itemAmount;
    @XmlAttribute(name = "Currency", required = true)
    protected String currency;

    /**
     * Gets the value of the storedValueAccountID property.
     *
     * @return
     *     possible object is
     *     {@link StoredValueAccountID }
     *
     */
    public StoredValueAccountID getStoredValueAccountID() {
        return storedValueAccountID;
    }

    /**
     * Sets the value of the storedValueAccountID property.
     *
     * @param value
     *     allowed object is
     *     {@link StoredValueAccountID }
     *
     */
    public void setStoredValueAccountID(StoredValueAccountID value) {
        this.storedValueAccountID = value;
    }

    /**
     * Gets the value of the originalPOITransaction property.
     *
     * @return
     *     possible object is
     *     {@link OriginalPOITransaction }
     *
     */
    public OriginalPOITransaction getOriginalPOITransaction() {
        return originalPOITransaction;
    }

    /**
     * Sets the value of the originalPOITransaction property.
     *
     * @param value
     *     allowed object is
     *     {@link OriginalPOITransaction }
     *
     */
    public void setOriginalPOITransaction(OriginalPOITransaction value) {
        this.originalPOITransaction = value;
    }

    /**
     * Gets the value of the storedValueProvider property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStoredValueProvider() {
        return storedValueProvider;
    }

    /**
     * Sets the value of the storedValueProvider property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStoredValueProvider(String value) {
        this.storedValueProvider = value;
    }

    /**
     * Gets the value of the storedValueTransaction property.
     *
     * @return
     *     possible object is
     *     {@link StoredValueTransactionType }
     *
     */
    public StoredValueTransactionType getStoredValueTransaction() {
        return storedValueTransaction;
    }

    /**
     * Sets the value of the storedValueTransaction property.
     *
     * @param value
     *     allowed object is
     *     {@link StoredValueTransactionType }
     *
     */
    public void setStoredValueTransaction(StoredValueTransactionType value) {
        this.storedValueTransaction = value;
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

    /**
     * Gets the value of the currency property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

}
