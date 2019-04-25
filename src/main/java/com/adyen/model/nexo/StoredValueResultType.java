
package com.adyen.model.nexo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Result of loading/reloading a stored value card.. -- Usage: For each stored value card loaded or reloaded, in the StoredValue response message
 * 
 * <p>Java class for StoredValueResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StoredValueResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StoredValueAccountStatus" type="{}StoredValueAccountStatusType"/>
 *         &lt;element name="HostTransactionID" type="{}TransactionIdentificationType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="StoredValueTransactionType" use="required" type="{}StoredValueTransactionTypeTypeCode" />
 *       &lt;attribute name="ProductCode" use="required" type="{}ProductCodeType" />
 *       &lt;attribute name="EanUpc" type="{}EanUpcType" />
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
@XmlType(name = "StoredValueResultType", propOrder = {
    "storedValueAccountStatus",
    "hostTransactionID"
})
public class StoredValueResultType {

    @XmlElement(name = "StoredValueAccountStatus", required = true)
    protected StoredValueAccountStatusType storedValueAccountStatus;
    @XmlElement(name = "HostTransactionID")
    protected TransactionIdentificationType hostTransactionID;
    @XmlAttribute(name = "StoredValueTransactionType", required = true)
    protected String storedValueTransactionType;
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
     *     {@link StoredValueAccountStatusType }
     *     
     */
    public StoredValueAccountStatusType getStoredValueAccountStatus() {
        return storedValueAccountStatus;
    }

    /**
     * Sets the value of the storedValueAccountStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StoredValueAccountStatusType }
     *     
     */
    public void setStoredValueAccountStatus(StoredValueAccountStatusType value) {
        this.storedValueAccountStatus = value;
    }

    /**
     * Gets the value of the hostTransactionID property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionIdentificationType }
     *     
     */
    public TransactionIdentificationType getHostTransactionID() {
        return hostTransactionID;
    }

    /**
     * Sets the value of the hostTransactionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionIdentificationType }
     *     
     */
    public void setHostTransactionID(TransactionIdentificationType value) {
        this.hostTransactionID = value;
    }

    /**
     * Gets the value of the storedValueTransactionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStoredValueTransactionType() {
        return storedValueTransactionType;
    }

    /**
     * Sets the value of the storedValueTransactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStoredValueTransactionType(String value) {
        this.storedValueTransactionType = value;
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
