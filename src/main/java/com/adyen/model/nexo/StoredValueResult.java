
package com.adyen.model.nexo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Result of loading/reloading a stored value card.. -- Usage: For each stored value card loaded or reloaded, in the StoredValue response messageType
 *
 * <p>Java class for StoredValueResult complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StoredValueResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StoredValueAccountStatus" type="{}StoredValueAccountStatus"/>
 *         &lt;element name="HostTransactionID" type="{}TransactionIdentification" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="StoredValueTransaction" use="required" type="{}StoredValueTransactionType" />
 *       &lt;attribute name="ProductCode" use="required" type="{}ProductCode" />
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
@XmlType(name = "StoredValueResult", propOrder = {
    "storedValueAccountStatus",
    "hostTransactionID"
})
public class StoredValueResult {

    @XmlElement(name = "StoredValueAccountStatus", required = true)
    protected StoredValueAccountStatus storedValueAccountStatus;
    @XmlElement(name = "HostTransactionID")
    protected TransactionIdentification hostTransactionID;
    @XmlAttribute(name = "StoredValueTransaction", required = true)
    protected StoredValueTransactionType storedValueTransaction;
    @XmlAttribute(name = "ProductCode", required = true)
    protected String productCode;
    @XmlAttribute(name = "EanUpc")
    protected String eanUpc;
    @XmlAttribute(name = "ItemAmount", required = true)
    protected BigDecimal itemAmount;
    @XmlAttribute(name = "Currency", required = true)
    protected String currency;

    /**
     * Gets the value of the storedValueAccountStatus property.
     *
     * @return
     *     possible object is
     *     {@link StoredValueAccountStatus }
     *
     */
    public StoredValueAccountStatus getStoredValueAccountStatus() {
        return storedValueAccountStatus;
    }

    /**
     * Sets the value of the storedValueAccountStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link StoredValueAccountStatus }
     *
     */
    public void setStoredValueAccountStatus(StoredValueAccountStatus value) {
        this.storedValueAccountStatus = value;
    }

    /**
     * Gets the value of the hostTransactionID property.
     *
     * @return
     *     possible object is
     *     {@link TransactionIdentification }
     *
     */
    public TransactionIdentification getHostTransactionID() {
        return hostTransactionID;
    }

    /**
     * Sets the value of the hostTransactionID property.
     *
     * @param value
     *     allowed object is
     *     {@link TransactionIdentification }
     *
     */
    public void setHostTransactionID(TransactionIdentification value) {
        this.hostTransactionID = value;
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
