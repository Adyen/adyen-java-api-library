
package com.adyen.model.nexo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the loyalty transaction.
 * 
 * <p>Java class for LoyaltyTransactionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoyaltyTransactionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OriginalPOITransaction" type="{}OriginalPOITransactionType" minOccurs="0"/>
 *         &lt;element name="TransactionConditions" type="{}TransactionConditionsType" minOccurs="0"/>
 *         &lt;element name="SaleItem" type="{}SaleItemType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="LoyaltyTransactionType" use="required" type="{}LoyaltyTransactionTypeTypeCode" />
 *       &lt;attribute name="Currency" type="{}ISOCurrency3A" />
 *       &lt;attribute name="TotalAmount" type="{}SimpleAmountType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyTransactionType", propOrder = {
    "originalPOITransaction",
    "transactionConditions",
    "saleItem"
})
public class LoyaltyTransactionType {

    @XmlElement(name = "OriginalPOITransaction")
    protected OriginalPOITransactionType originalPOITransaction;
    @XmlElement(name = "TransactionConditions")
    protected TransactionConditionsType transactionConditions;
    @XmlElement(name = "SaleItem")
    protected List<SaleItemType> saleItem;
    @XmlAttribute(name = "LoyaltyTransactionType", required = true)
    protected String loyaltyTransactionType;
    @XmlAttribute(name = "Currency")
    protected String currency;
    @XmlAttribute(name = "TotalAmount")
    protected BigDecimal totalAmount;

    /**
     * Gets the value of the originalPOITransaction property.
     * 
     * @return
     *     possible object is
     *     {@link OriginalPOITransactionType }
     *     
     */
    public OriginalPOITransactionType getOriginalPOITransaction() {
        return originalPOITransaction;
    }

    /**
     * Sets the value of the originalPOITransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalPOITransactionType }
     *     
     */
    public void setOriginalPOITransaction(OriginalPOITransactionType value) {
        this.originalPOITransaction = value;
    }

    /**
     * Gets the value of the transactionConditions property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionConditionsType }
     *     
     */
    public TransactionConditionsType getTransactionConditions() {
        return transactionConditions;
    }

    /**
     * Sets the value of the transactionConditions property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionConditionsType }
     *     
     */
    public void setTransactionConditions(TransactionConditionsType value) {
        this.transactionConditions = value;
    }

    /**
     * Gets the value of the saleItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the saleItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSaleItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SaleItemType }
     * 
     * 
     */
    public List<SaleItemType> getSaleItem() {
        if (saleItem == null) {
            saleItem = new ArrayList<SaleItemType>();
        }
        return this.saleItem;
    }

    /**
     * Gets the value of the loyaltyTransactionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoyaltyTransactionType() {
        return loyaltyTransactionType;
    }

    /**
     * Sets the value of the loyaltyTransactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoyaltyTransactionType(String value) {
        this.loyaltyTransactionType = value;
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

    /**
     * Gets the value of the totalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalAmount(BigDecimal value) {
        this.totalAmount = value;
    }

}
