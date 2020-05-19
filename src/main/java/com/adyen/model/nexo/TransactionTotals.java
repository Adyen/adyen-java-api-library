package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Result of the Sale to POI Reconciliation processing. -- Usage: If Result is Success, contains all the totals, classified as required by the Sale in the messageType request. At least, transaction totals are provided per Acquirer, Acquirer Settlement, and Card Brand.
 *
 * <p>Java class for TransactionTotals complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TransactionTotals"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PaymentTotals" type="{}PaymentTotals" maxOccurs="10" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyTotals" type="{}LoyaltyTotals" maxOccurs="6" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="PaymentInstrument" use="required" type="{}PaymentInstrumentType" /&gt;
 *       &lt;attribute name="AcquirerID" type="{}AcquirerID" /&gt;
 *       &lt;attribute name="ErrorCondition" type="{}ErrorConditionType" /&gt;
 *       &lt;attribute name="HostReconciliationID" type="{}HostReconciliationID" /&gt;
 *       &lt;attribute name="CardBrand" type="{}CardBrand" /&gt;
 *       &lt;attribute name="POIID" type="{}POIID" /&gt;
 *       &lt;attribute name="SaleID" type="{}SaleID" /&gt;
 *       &lt;attribute name="OperatorID" type="{}OperatorID" /&gt;
 *       &lt;attribute name="ShiftNumber" type="{}ShiftNumber" /&gt;
 *       &lt;attribute name="TotalsGroupID" type="{}TotalsGroupID" /&gt;
 *       &lt;attribute name="PaymentCurrency" type="{}ISOCurrency3A" /&gt;
 *       &lt;attribute name="LoyaltyUnit" type="{}LoyaltyUnitType" default="Point" /&gt;
 *       &lt;attribute name="LoyaltyCurrency" type="{}ISOCurrency3A" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionTotals", propOrder = {
        "paymentTotals",
        "loyaltyTotals"
})
public class TransactionTotals {

    /**
     * The Payment totals.
     */
    @XmlElement(name = "PaymentTotals")
    protected List<PaymentTotals> paymentTotals;
    /**
     * The Loyalty totals.
     */
    @XmlElement(name = "LoyaltyTotals")
    protected List<LoyaltyTotals> loyaltyTotals;
    /**
     * The Payment instrument.
     */
    @XmlAttribute(name = "PaymentInstrumentType", required = true)
    protected PaymentInstrumentType paymentInstrumentType;
    /**
     * The Acquirer id.
     */
    @XmlAttribute(name = "AcquirerID")
    protected String acquirerID;
    /**
     * The Error condition.
     */
    @XmlAttribute(name = "ErrorCondition")
    protected ErrorConditionType errorCondition;
    /**
     * The Host reconciliation id.
     */
    @XmlAttribute(name = "HostReconciliationID")
    protected String hostReconciliationID;
    /**
     * The Card brand.
     */
    @XmlAttribute(name = "CardBrand")
    protected String cardBrand;
    /**
     * The Poiid.
     */
    @XmlAttribute(name = "POIID")
    protected String poiid;
    /**
     * The Sale id.
     */
    @XmlAttribute(name = "SaleID")
    protected String saleID;
    /**
     * The Operator id.
     */
    @XmlAttribute(name = "OperatorID")
    protected String operatorID;
    /**
     * The Shift number.
     */
    @XmlAttribute(name = "ShiftNumber")
    protected String shiftNumber;
    /**
     * The Totals group id.
     */
    @XmlAttribute(name = "TotalsGroupID")
    protected String totalsGroupID;
    /**
     * The Payment currency.
     */
    @XmlAttribute(name = "PaymentCurrency")
    protected String paymentCurrency;
    /**
     * The Loyalty unit.
     */
    @XmlAttribute(name = "LoyaltyUnit")
    protected LoyaltyUnitType loyaltyUnit;
    /**
     * The Loyalty currency.
     */
    @XmlAttribute(name = "LoyaltyCurrency")
    protected String loyaltyCurrency;

    /**
     * Gets the value of the paymentTotals property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentTotals property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentTotals().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentTotals }
     *
     * @return the payment totals
     */
    public List<PaymentTotals> getPaymentTotals() {
        if (paymentTotals == null) {
            paymentTotals = new ArrayList<>();
        }
        return this.paymentTotals;
    }

    /**
     * Gets the value of the loyaltyTotals property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loyaltyTotals property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoyaltyTotals().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link LoyaltyTotals }
     *
     * @return the loyalty totals
     */
    public List<LoyaltyTotals> getLoyaltyTotals() {
        if (loyaltyTotals == null) {
            loyaltyTotals = new ArrayList<>();
        }
        return this.loyaltyTotals;
    }

    /**
     * Gets the value of the paymentInstrumentType property.
     *
     * @return possible      object is     {@link PaymentInstrumentType }
     */
    public PaymentInstrumentType getPaymentInstrumentType() {
        return paymentInstrumentType;
    }

    /**
     * Sets the value of the paymentInstrumentType property.
     *
     * @param value allowed object is     {@link PaymentInstrumentType }
     */
    public void setPaymentInstrumentType(PaymentInstrumentType value) {
        this.paymentInstrumentType = value;
    }

    /**
     * Gets the value of the acquirerID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getAcquirerID() {
        return acquirerID;
    }

    /**
     * Sets the value of the acquirerID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setAcquirerID(String value) {
        this.acquirerID = value;
    }

    /**
     * Gets the value of the errorCondition property.
     *
     * @return possible      object is     {@link ErrorConditionType }
     */
    public ErrorConditionType getErrorCondition() {
        return errorCondition;
    }

    /**
     * Sets the value of the errorCondition property.
     *
     * @param value allowed object is     {@link ErrorConditionType }
     */
    public void setErrorCondition(ErrorConditionType value) {
        this.errorCondition = value;
    }

    /**
     * Gets the value of the hostReconciliationID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getHostReconciliationID() {
        return hostReconciliationID;
    }

    /**
     * Sets the value of the hostReconciliationID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setHostReconciliationID(String value) {
        this.hostReconciliationID = value;
    }

    /**
     * Gets the value of the cardBrand property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCardBrand() {
        return cardBrand;
    }

    /**
     * Sets the value of the cardBrand property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCardBrand(String value) {
        this.cardBrand = value;
    }

    /**
     * Gets the value of the poiid property.
     *
     * @return possible      object is     {@link String }
     */
    public String getPOIID() {
        return poiid;
    }

    /**
     * Sets the value of the poiid property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setPOIID(String value) {
        this.poiid = value;
    }

    /**
     * Gets the value of the saleID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getSaleID() {
        return saleID;
    }

    /**
     * Sets the value of the saleID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setSaleID(String value) {
        this.saleID = value;
    }

    /**
     * Gets the value of the operatorID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getOperatorID() {
        return operatorID;
    }

    /**
     * Sets the value of the operatorID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setOperatorID(String value) {
        this.operatorID = value;
    }

    /**
     * Gets the value of the shiftNumber property.
     *
     * @return possible      object is     {@link String }
     */
    public String getShiftNumber() {
        return shiftNumber;
    }

    /**
     * Sets the value of the shiftNumber property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setShiftNumber(String value) {
        this.shiftNumber = value;
    }

    /**
     * Gets the value of the totalsGroupID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getTotalsGroupID() {
        return totalsGroupID;
    }

    /**
     * Sets the value of the totalsGroupID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setTotalsGroupID(String value) {
        this.totalsGroupID = value;
    }

    /**
     * Gets the value of the paymentCurrency property.
     *
     * @return possible      object is     {@link String }
     */
    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    /**
     * Sets the value of the paymentCurrency property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setPaymentCurrency(String value) {
        this.paymentCurrency = value;
    }

    /**
     * Gets the value of the loyaltyUnit property.
     *
     * @return possible      object is     {@link LoyaltyUnitType }
     */
    public LoyaltyUnitType getLoyaltyUnit() {
        if (loyaltyUnit == null) {
            return LoyaltyUnitType.POINT;
        } else {
            return loyaltyUnit;
        }
    }

    /**
     * Sets the value of the loyaltyUnit property.
     *
     * @param value allowed object is     {@link LoyaltyUnitType }
     */
    public void setLoyaltyUnit(LoyaltyUnitType value) {
        this.loyaltyUnit = value;
    }

    /**
     * Gets the value of the loyaltyCurrency property.
     *
     * @return possible      object is     {@link String }
     */
    public String getLoyaltyCurrency() {
        return loyaltyCurrency;
    }

    /**
     * Sets the value of the loyaltyCurrency property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setLoyaltyCurrency(String value) {
        this.loyaltyCurrency = value;
    }

}
