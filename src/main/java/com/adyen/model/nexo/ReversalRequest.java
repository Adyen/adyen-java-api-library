
package com.adyen.model.nexo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Reversal Request messageType. -- Usage: It conveys Information related to the reversal of a previous payment or a loyalty transaction.
 *
 * <p>Java class for ReversalRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ReversalRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OriginalPOITransaction" type="{}OriginalPOITransaction"/>
 *         &lt;element name="CustomerOrderID" type="{}CustomerOrder" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="SaleReferenceID" type="{}SaleReferenceID" />
 *       &lt;attribute name="ReversalReason" use="required" type="{}ReversalReasonType" />
 *       &lt;attribute name="ReversedAmount" type="{}SimpleAmountType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReversalRequest", propOrder = {
    "originalPOITransaction",
    "customerOrderID"
})
public class ReversalRequest {

    @XmlElement(name = "OriginalPOITransaction", required = true)
    protected OriginalPOITransaction originalPOITransaction;
    @XmlElement(name = "CustomerOrderID")
    protected CustomerOrder customerOrderID;
    @XmlAttribute(name = "SaleReferenceID")
    protected String saleReferenceID;
    @XmlAttribute(name = "ReversalReason", required = true)
    protected ReversalReasonType reversalReason;
    @XmlAttribute(name = "ReversedAmount")
    protected BigDecimal reversedAmount;

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
     * Gets the value of the customerOrderID property.
     *
     * @return
     *     possible object is
     *     {@link CustomerOrder }
     *
     */
    public CustomerOrder getCustomerOrderID() {
        return customerOrderID;
    }

    /**
     * Sets the value of the customerOrderID property.
     *
     * @param value
     *     allowed object is
     *     {@link CustomerOrder }
     *
     */
    public void setCustomerOrderID(CustomerOrder value) {
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
     *     {@link ReversalReasonType }
     *
     */
    public ReversalReasonType getReversalReason() {
        return reversalReason;
    }

    /**
     * Sets the value of the reversalReason property.
     *
     * @param value
     *     allowed object is
     *     {@link ReversalReasonType }
     *
     */
    public void setReversalReason(ReversalReasonType value) {
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
