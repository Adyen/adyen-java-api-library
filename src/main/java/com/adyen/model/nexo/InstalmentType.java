
package com.adyen.model.nexo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Information related an instalment transaction. -- Usage: To request an instalment to the issuer, or to make individual instalments of a payment transaction.
 * 
 * <p>Java class for InstalmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InstalmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InstalmentType" type="{}InstalmentTypeType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="SequenceNumber" type="{}SequenceNumberType" />
 *       &lt;attribute name="PlanID" type="{}PlanIDType" />
 *       &lt;attribute name="Period" type="{}PeriodType" />
 *       &lt;attribute name="PeriodUnit" type="{}PeriodUnitTypeCode" />
 *       &lt;attribute name="FirstPaymentDate" type="{}ISODate" />
 *       &lt;attribute name="TotalNbOfPayments" type="{}TotalNbOfPaymentsType" />
 *       &lt;attribute name="CumulativeAmount" type="{}SimpleAmountType" />
 *       &lt;attribute name="FirstAmount" type="{}SimpleAmountType" />
 *       &lt;attribute name="Charges" type="{}SimpleAmountType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InstalmentType", propOrder = {
    "instalmentType"
})
public class InstalmentType {

    @XmlList
    @XmlElement(name = "InstalmentType")
    protected List<String> instalmentType;
    @XmlAttribute(name = "SequenceNumber")
    protected BigInteger sequenceNumber;
    @XmlAttribute(name = "PlanID")
    protected String planID;
    @XmlAttribute(name = "Period")
    protected BigInteger period;
    @XmlAttribute(name = "PeriodUnit")
    protected String periodUnit;
    @XmlAttribute(name = "FirstPaymentDate")
    protected String firstPaymentDate;
    @XmlAttribute(name = "TotalNbOfPayments")
    protected BigInteger totalNbOfPayments;
    @XmlAttribute(name = "CumulativeAmount")
    protected BigDecimal cumulativeAmount;
    @XmlAttribute(name = "FirstAmount")
    protected BigDecimal firstAmount;
    @XmlAttribute(name = "Charges")
    protected BigDecimal charges;

    /**
     * Gets the value of the instalmentType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instalmentType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstalmentType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getInstalmentType() {
        if (instalmentType == null) {
            instalmentType = new ArrayList<String>();
        }
        return this.instalmentType;
    }

    /**
     * Gets the value of the sequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Sets the value of the sequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSequenceNumber(BigInteger value) {
        this.sequenceNumber = value;
    }

    /**
     * Gets the value of the planID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanID() {
        return planID;
    }

    /**
     * Sets the value of the planID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanID(String value) {
        this.planID = value;
    }

    /**
     * Gets the value of the period property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPeriod(BigInteger value) {
        this.period = value;
    }

    /**
     * Gets the value of the periodUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodUnit() {
        return periodUnit;
    }

    /**
     * Sets the value of the periodUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodUnit(String value) {
        this.periodUnit = value;
    }

    /**
     * Gets the value of the firstPaymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstPaymentDate() {
        return firstPaymentDate;
    }

    /**
     * Sets the value of the firstPaymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstPaymentDate(String value) {
        this.firstPaymentDate = value;
    }

    /**
     * Gets the value of the totalNbOfPayments property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalNbOfPayments() {
        return totalNbOfPayments;
    }

    /**
     * Sets the value of the totalNbOfPayments property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalNbOfPayments(BigInteger value) {
        this.totalNbOfPayments = value;
    }

    /**
     * Gets the value of the cumulativeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCumulativeAmount() {
        return cumulativeAmount;
    }

    /**
     * Sets the value of the cumulativeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCumulativeAmount(BigDecimal value) {
        this.cumulativeAmount = value;
    }

    /**
     * Gets the value of the firstAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFirstAmount() {
        return firstAmount;
    }

    /**
     * Sets the value of the firstAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFirstAmount(BigDecimal value) {
        this.firstAmount = value;
    }

    /**
     * Gets the value of the charges property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCharges() {
        return charges;
    }

    /**
     * Sets the value of the charges property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCharges(BigDecimal value) {
        this.charges = value;
    }

}
