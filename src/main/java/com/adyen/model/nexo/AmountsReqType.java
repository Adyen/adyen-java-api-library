
package com.adyen.model.nexo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Various amounts related to the payment and loyalty request from the Sale System. -- Usage: Amounts requested by the Sale System for the payment and loyalty transaction, containing: The currency which is the same for all these amounts The requested amount to pay The cash back part of the requested amount for a payment with cash
 * 
 * <p>Java class for AmountsReqType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AmountsReqType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Currency" use="required" type="{}ISOCurrency3A" />
 *       &lt;attribute name="RequestedAmount" type="{}SimpleAmountType" />
 *       &lt;attribute name="CashBackAmount" type="{}SimpleAmountType" />
 *       &lt;attribute name="TipAmount" type="{}SimpleAmountType" />
 *       &lt;attribute name="PaidAmount" type="{}SimpleAmountType" />
 *       &lt;attribute name="MinimumAmountToDeliver" type="{}SimpleAmountType" />
 *       &lt;attribute name="MaximumCashBackAmount" type="{}SimpleAmountType" />
 *       &lt;attribute name="MinimumSplitAmount" type="{}SimpleAmountType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountsReqType")
public class AmountsReqType {

    @XmlAttribute(name = "Currency", required = true)
    protected String currency;
    @XmlAttribute(name = "RequestedAmount")
    protected BigDecimal requestedAmount;
    @XmlAttribute(name = "CashBackAmount")
    protected BigDecimal cashBackAmount;
    @XmlAttribute(name = "TipAmount")
    protected BigDecimal tipAmount;
    @XmlAttribute(name = "PaidAmount")
    protected BigDecimal paidAmount;
    @XmlAttribute(name = "MinimumAmountToDeliver")
    protected BigDecimal minimumAmountToDeliver;
    @XmlAttribute(name = "MaximumCashBackAmount")
    protected BigDecimal maximumCashBackAmount;
    @XmlAttribute(name = "MinimumSplitAmount")
    protected BigDecimal minimumSplitAmount;

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
     * Gets the value of the requestedAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    /**
     * Sets the value of the requestedAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRequestedAmount(BigDecimal value) {
        this.requestedAmount = value;
    }

    /**
     * Gets the value of the cashBackAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCashBackAmount() {
        return cashBackAmount;
    }

    /**
     * Sets the value of the cashBackAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCashBackAmount(BigDecimal value) {
        this.cashBackAmount = value;
    }

    /**
     * Gets the value of the tipAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTipAmount() {
        return tipAmount;
    }

    /**
     * Sets the value of the tipAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTipAmount(BigDecimal value) {
        this.tipAmount = value;
    }

    /**
     * Gets the value of the paidAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    /**
     * Sets the value of the paidAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPaidAmount(BigDecimal value) {
        this.paidAmount = value;
    }

    /**
     * Gets the value of the minimumAmountToDeliver property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinimumAmountToDeliver() {
        return minimumAmountToDeliver;
    }

    /**
     * Sets the value of the minimumAmountToDeliver property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinimumAmountToDeliver(BigDecimal value) {
        this.minimumAmountToDeliver = value;
    }

    /**
     * Gets the value of the maximumCashBackAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaximumCashBackAmount() {
        return maximumCashBackAmount;
    }

    /**
     * Sets the value of the maximumCashBackAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaximumCashBackAmount(BigDecimal value) {
        this.maximumCashBackAmount = value;
    }

    /**
     * Gets the value of the minimumSplitAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinimumSplitAmount() {
        return minimumSplitAmount;
    }

    /**
     * Sets the value of the minimumSplitAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinimumSplitAmount(BigDecimal value) {
        this.minimumSplitAmount = value;
    }

}
