
package com.adyen.model.nexo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Reversal Request message. -- Usage: It conveys Information related to the reversal of a previous payment or a loyalty transaction.
 * 
 * <p>Java class for ReversalRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReversalRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OriginalPOITransaction" type="{}OriginalPOITransactionType"/>
 *         &lt;element name="CustomerOrderID" type="{}CustomerOrderType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="SaleReferenceID" type="{}SaleReferenceIDType" />
 *       &lt;attribute name="ReversalReason" use="required" type="{}ReversalReasonTypeCode" />
 *       &lt;attribute name="ReversedAmount" type="{}SimpleAmountType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReversalRequestType", propOrder = {
    "originalPOITransaction",
    "customerOrderID"
})
public class ReversalRequestType {

    @XmlElement(name = "OriginalPOITransaction", required = true)
    protected OriginalPOITransactionType originalPOITransaction;
    @XmlElement(name = "CustomerOrderID")
    protected CustomerOrderType customerOrderID;
    @XmlAttribute(name = "SaleReferenceID")
    protected String saleReferenceID;
    @XmlAttribute(name = "ReversalReason", required = true)
    protected String reversalReason;
    @XmlAttribute(name = "ReversedAmount")
    protected BigDecimal reversedAmount;

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
     * Gets the value of the customerOrderID property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerOrderType }
     *     
     */
    public CustomerOrderType getCustomerOrderID() {
        return customerOrderID;
    }

    /**
     * Sets the value of the customerOrderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerOrderType }
     *     
     */
    public void setCustomerOrderID(CustomerOrderType value) {
        this.customerOrderID = value;
    }

    /**
     * Gets the value of the saleReferenceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaleReferenceID() {
        return saleReferenceID;
    }

    /**
     * Sets the value of the saleReferenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaleReferenceID(String value) {
        this.saleReferenceID = value;
    }

    /**
     * Gets the value of the reversalReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReversalReason() {
        return reversalReason;
    }

    /**
     * Sets the value of the reversalReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReversalReason(String value) {
        this.reversalReason = value;
    }

    /**
     * Gets the value of the reversedAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getReversedAmount() {
        return reversedAmount;
    }

    /**
     * Sets the value of the reversedAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setReversedAmount(BigDecimal value) {
        this.reversedAmount = value;
    }

}
