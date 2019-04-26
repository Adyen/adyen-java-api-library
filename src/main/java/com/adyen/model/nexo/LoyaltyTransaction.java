
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
 * <p>Java class for LoyaltyTransaction complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LoyaltyTransaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OriginalPOITransaction" type="{}OriginalPOITransaction" minOccurs="0"/>
 *         &lt;element name="TransactionConditions" type="{}TransactionConditions" minOccurs="0"/>
 *         &lt;element name="SaleItem" type="{}SaleItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="LoyaltyTransaction" use="required" type="{}LoyaltyTransactionType" />
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
@XmlType(name = "LoyaltyTransaction", propOrder = {
    "originalPOITransaction",
    "transactionConditions",
    "saleItem"
})
public class LoyaltyTransaction {

    @XmlElement(name = "OriginalPOITransaction")
    protected OriginalPOITransaction originalPOITransaction;
    @XmlElement(name = "TransactionConditions")
    protected TransactionConditions transactionConditions;
    @XmlElement(name = "SaleItem")
    protected List<SaleItem> saleItem;
    @XmlAttribute(name = "LoyaltyTransaction", required = true)
    protected LoyaltyTransactionType loyaltyTransaction;
    @XmlAttribute(name = "Currency")
    protected String currency;
    @XmlAttribute(name = "TotalAmount")
    protected BigDecimal totalAmount;

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
     * Gets the value of the transactionConditions property.
     *
     * @return
     *     possible object is
     *     {@link TransactionConditions }
     *
     */
    public TransactionConditions getTransactionConditions() {
        return transactionConditions;
    }

    /**
     * Sets the value of the transactionConditions property.
     *
     * @param value
     *     allowed object is
     *     {@link TransactionConditions }
     *
     */
    public void setTransactionConditions(TransactionConditions value) {
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
     * {@link SaleItem }
     *
     *
     */
    public List<SaleItem> getSaleItem() {
        if (saleItem == null) {
            saleItem = new ArrayList<SaleItem>();
        }
        return this.saleItem;
    }

    /**
     * Gets the value of the loyaltyTransaction property.
     *
     * @return
     *     possible object is
     *     {@link LoyaltyTransactionType }
     *
     */
    public LoyaltyTransactionType getLoyaltyTransaction() {
        return loyaltyTransaction;
    }

    /**
     * Sets the value of the loyaltyTransaction property.
     *
     * @param value
     *     allowed object is
     *     {@link LoyaltyTransactionType }
     *
     */
    public void setLoyaltyTransaction(LoyaltyTransactionType value) {
        this.loyaltyTransaction = value;
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
