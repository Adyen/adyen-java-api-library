package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * Definition: Various amounts related to the payment and loyalty request from the Sale System. -- Usage: Amounts requested by the Sale System for the payment and loyalty transaction, containing: The currency which is the same for all these amounts The requested amount to pay The cash back part of the requested amount for a payment with cash
 *
 * <p>Java class for AmountsReq complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AmountsReq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Currency" use="required" type="{}ISOCurrency3A" /&gt;
 *       &lt;attribute name="RequestedAmount" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="CashBackAmount" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="TipAmount" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="PaidAmount" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="MinimumAmountToDeliver" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="MaximumCashBackAmount" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="MinimumSplitAmount" type="{}SimpleAmountType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountsReq")
public class AmountsReq {

    /**
     * The Currency.
     */
    @XmlElement(name = "Currency", required = true)
    @Schema(description = "Currency of a monetary amount.")
    protected String currency;
    /**
     * The Requested amount.
     */
    @XmlElement(name = "RequestedAmount")
    @Schema(description = "Amount requested by the Sale for the payment. --Rule: Absent if the maximum amount is unknown for a OneTimeReservationThe value has to be greater than 0.")
    protected BigDecimal requestedAmount;
    /**
     * The Cash back amount.
     */
    @XmlElement(name = "CashBackAmount")
    @Schema(description = "The cash-back part of the amount requested by the Sale for the payment. --Rule: if payment with cash back. This data has to be performed by the POI. If cash back is not allowed, the payment is")
    protected BigDecimal cashBackAmount;
    /**
     * The Tip amount.
     */
    @XmlElement(name = "TipAmount")
    @Schema(description = "Amount paid for a tip. --Rule: If payment with tip requested by the Sale System.")
    protected BigDecimal tipAmount;
    /**
     * The Paid amount.
     */
    @XmlElement(name = "PaidAmount")
    @Schema(description = "Amount already paid amount in case of split payment. --Rule: If SplitPaymentFlag is True (split amount of a split payment).")
    protected BigDecimal paidAmount;
    /**
     * The Minimum amount to deliver.
     */
    @XmlElement(name = "MinimumAmountToDeliver")
    @Schema(description = "Minimum amount the Sale System is allowed to deliver for this payment. --Rule: if unknown maximum amount for a OneTimeReservation or minimum amount requested by the Sale System")
    protected BigDecimal minimumAmountToDeliver;
    /**
     * The Maximum cash back amount.
     */
    @XmlElement(name = "MaximumCashBackAmount")
    @Schema(description = "Maximum amount which could be requested for cash-back to the Sale System. --Rule: Maximum amount which could be requested for cash-back to the Sale System.")
    protected BigDecimal maximumCashBackAmount;
    /**
     * The Minimum split amount.
     */
    @XmlElement(name = "MinimumSplitAmount")
    @Schema(description = "Minimum amount of a split, which could be requested by a Customer. --Rule: Minimum amount of a split, which could be requested.")
    protected BigDecimal minimumSplitAmount;

    /**
     * Gets the value of the currency property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the requestedAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    /**
     * Sets the value of the requestedAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setRequestedAmount(BigDecimal value) {
        this.requestedAmount = value;
    }

    /**
     * Gets the value of the cashBackAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getCashBackAmount() {
        return cashBackAmount;
    }

    /**
     * Sets the value of the cashBackAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setCashBackAmount(BigDecimal value) {
        this.cashBackAmount = value;
    }

    /**
     * Gets the value of the tipAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getTipAmount() {
        return tipAmount;
    }

    /**
     * Sets the value of the tipAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setTipAmount(BigDecimal value) {
        this.tipAmount = value;
    }

    /**
     * Gets the value of the paidAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    /**
     * Sets the value of the paidAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setPaidAmount(BigDecimal value) {
        this.paidAmount = value;
    }

    /**
     * Gets the value of the minimumAmountToDeliver property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getMinimumAmountToDeliver() {
        return minimumAmountToDeliver;
    }

    /**
     * Sets the value of the minimumAmountToDeliver property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setMinimumAmountToDeliver(BigDecimal value) {
        this.minimumAmountToDeliver = value;
    }

    /**
     * Gets the value of the maximumCashBackAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getMaximumCashBackAmount() {
        return maximumCashBackAmount;
    }

    /**
     * Sets the value of the maximumCashBackAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setMaximumCashBackAmount(BigDecimal value) {
        this.maximumCashBackAmount = value;
    }

    /**
     * Gets the value of the minimumSplitAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getMinimumSplitAmount() {
        return minimumSplitAmount;
    }

    /**
     * Sets the value of the minimumSplitAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setMinimumSplitAmount(BigDecimal value) {
        this.minimumSplitAmount = value;
    }

}
