package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * Definition: Information related an instalment transaction. -- Usage: To request an instalment to the issuer, or to make individual instalments of a payment transaction.
 *
 * <p>Java class for Instalment complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Instalment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Instalment" type="{}InstalmentType" /&gt;
 *       &lt;attribute name="SequenceNumber" type="{}SequenceNumber" /&gt;
 *       &lt;attribute name="PlanID" type="{}PlanID" /&gt;
 *       &lt;attribute name="Period" type="{}Period" /&gt;
 *       &lt;attribute name="PeriodUnit" type="{}PeriodUnitType" /&gt;
 *       &lt;attribute name="FirstPaymentDate" type="{}ISODate" /&gt;
 *       &lt;attribute name="TotalNbOfPayments" type="{}TotalNbOfPayments" /&gt;
 *       &lt;attribute name="CumulativeAmount" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="FirstAmount" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="Charges" type="{}SimpleAmountType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Instalment")
public class Instalment {

    /**
     * The Instalment type.
     */
    @XmlElement(name = "InstalmentType")
    @Schema(description = "Type of instalment transaction.")
    protected InstalmentType instalmentType;
    /**
     * The Sequence number.
     */
    @XmlElement(name = "SequenceNumber")
    @Schema(description = "Sequence number of the instalment.")
    protected BigInteger sequenceNumber;
    /**
     * The Plan id.
     */
    @XmlElement(name = "PlanID")
    @Schema(description = "Identification of an instalment plan.")
    protected String planID;
    /**
     * The Period.
     */
    @XmlElement(name = "Period")
    @Schema(description = "Period of time with defined unit of time.")
    protected BigInteger period;
    /**
     * The Period unit.
     */
    @XmlElement(name = "PeriodUnit")
    protected PeriodUnitType periodUnit;
    /**
     * The First payment date.
     */
    @XmlElement(name = "FirstPaymentDate")
    @Schema(description = "First date of a payment.")
    protected String firstPaymentDate;
    /**
     * The Total nb of payments.
     */
    @XmlElement(name = "TotalNbOfPayments")
    @Schema(description = "Total number of payments.")
    protected BigInteger totalNbOfPayments;
    /**
     * The Cumulative amount.
     */
    @XmlElement(name = "CumulativeAmount")
    @Schema(description = "Sum of a collection of amounts.")
    protected BigDecimal cumulativeAmount;
    /**
     * The First amount.
     */
    @XmlElement(name = "FirstAmount")
    @Schema(description = "First amount of a payment.")
    protected BigDecimal firstAmount;
    /**
     * The Charges.
     */
    @XmlElement(name = "Charges")
    @Schema(description = "Charges related to a transaction.")
    protected BigDecimal charges;

    /**
     * Gets the value of the instalment property.
     *
     * @return possible      object is     {@link InstalmentType }
     */
    public InstalmentType getInstalmentType() {
        return instalmentType;
    }

    /**
     * Sets the value of the instalmentType property.
     *
     * @param value allowed object is     {@link InstalmentType }
     */
    public void setInstalmentType(InstalmentType value) {
        this.instalmentType = value;
    }

    /**
     * Gets the value of the sequenceNumber property.
     *
     * @return possible      object is     {@link BigInteger }
     */
    public BigInteger getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Sets the value of the sequenceNumber property.
     *
     * @param value allowed object is     {@link BigInteger }
     */
    public void setSequenceNumber(BigInteger value) {
        this.sequenceNumber = value;
    }

    /**
     * Gets the value of the planID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getPlanID() {
        return planID;
    }

    /**
     * Sets the value of the planID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setPlanID(String value) {
        this.planID = value;
    }

    /**
     * Gets the value of the period property.
     *
     * @return possible      object is     {@link BigInteger }
     */
    public BigInteger getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     *
     * @param value allowed object is     {@link BigInteger }
     */
    public void setPeriod(BigInteger value) {
        this.period = value;
    }

    /**
     * Gets the value of the periodUnit property.
     *
     * @return possible      object is     {@link PeriodUnitType }
     */
    public PeriodUnitType getPeriodUnit() {
        return periodUnit;
    }

    /**
     * Sets the value of the periodUnit property.
     *
     * @param value allowed object is     {@link PeriodUnitType }
     */
    public void setPeriodUnit(PeriodUnitType value) {
        this.periodUnit = value;
    }

    /**
     * Gets the value of the firstPaymentDate property.
     *
     * @return possible      object is     {@link String }
     */
    public String getFirstPaymentDate() {
        return firstPaymentDate;
    }

    /**
     * Sets the value of the firstPaymentDate property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setFirstPaymentDate(String value) {
        this.firstPaymentDate = value;
    }

    /**
     * Gets the value of the totalNbOfPayments property.
     *
     * @return possible      object is     {@link BigInteger }
     */
    public BigInteger getTotalNbOfPayments() {
        return totalNbOfPayments;
    }

    /**
     * Sets the value of the totalNbOfPayments property.
     *
     * @param value allowed object is     {@link BigInteger }
     */
    public void setTotalNbOfPayments(BigInteger value) {
        this.totalNbOfPayments = value;
    }

    /**
     * Gets the value of the cumulativeAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getCumulativeAmount() {
        return cumulativeAmount;
    }

    /**
     * Sets the value of the cumulativeAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setCumulativeAmount(BigDecimal value) {
        this.cumulativeAmount = value;
    }

    /**
     * Gets the value of the firstAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getFirstAmount() {
        return firstAmount;
    }

    /**
     * Sets the value of the firstAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setFirstAmount(BigDecimal value) {
        this.firstAmount = value;
    }

    /**
     * Gets the value of the charges property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getCharges() {
        return charges;
    }

    /**
     * Sets the value of the charges property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setCharges(BigDecimal value) {
        this.charges = value;
    }

}
