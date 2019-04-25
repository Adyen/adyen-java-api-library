
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Result of the Sale to POI Reconciliation processing. -- Usage: If Result is Success, contains all the totals, classified as required by the Sale in the message request. At least, transaction totals are provided per Acquirer, Acquirer Settlement, and Card Brand.
 * 
 * <p>Java class for TransactionTotalsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionTotalsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaymentTotals" type="{}PaymentTotalsType" maxOccurs="10" minOccurs="0"/>
 *         &lt;element name="LoyaltyTotals" type="{}LoyaltyTotalsType" maxOccurs="6" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PaymentInstrumentType" use="required" type="{}PaymentInstrumentTypeTypeCode" />
 *       &lt;attribute name="AcquirerID" type="{}AcquirerIDType" />
 *       &lt;attribute name="ErrorCondition" type="{}ErrorConditionTypeCode" />
 *       &lt;attribute name="HostReconciliationID" type="{}HostReconciliationIDType" />
 *       &lt;attribute name="CardBrand" type="{}CardBrandType" />
 *       &lt;attribute name="POIID" type="{}POIIDType" />
 *       &lt;attribute name="SaleID" type="{}SaleIDType" />
 *       &lt;attribute name="OperatorID" type="{}OperatorIDType" />
 *       &lt;attribute name="ShiftNumber" type="{}ShiftNumberType" />
 *       &lt;attribute name="TotalsGroupID" type="{}TotalsGroupIDType" />
 *       &lt;attribute name="PaymentCurrency" type="{}ISOCurrency3A" />
 *       &lt;attribute name="LoyaltyUnit" type="{}LoyaltyUnitTypeCode" default="Point" />
 *       &lt;attribute name="LoyaltyCurrency" type="{}ISOCurrency3A" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionTotalsType", propOrder = {
    "paymentTotals",
    "loyaltyTotals"
})
public class TransactionTotalsType {

    @XmlElement(name = "PaymentTotals")
    protected List<PaymentTotalsType> paymentTotals;
    @XmlElement(name = "LoyaltyTotals")
    protected List<LoyaltyTotalsType> loyaltyTotals;
    @XmlAttribute(name = "PaymentInstrumentType", required = true)
    protected String paymentInstrumentType;
    @XmlAttribute(name = "AcquirerID")
    protected String acquirerID;
    @XmlAttribute(name = "ErrorCondition")
    protected String errorCondition;
    @XmlAttribute(name = "HostReconciliationID")
    protected String hostReconciliationID;
    @XmlAttribute(name = "CardBrand")
    protected String cardBrand;
    @XmlAttribute(name = "POIID")
    protected String poiid;
    @XmlAttribute(name = "SaleID")
    protected String saleID;
    @XmlAttribute(name = "OperatorID")
    protected String operatorID;
    @XmlAttribute(name = "ShiftNumber")
    protected String shiftNumber;
    @XmlAttribute(name = "TotalsGroupID")
    protected String totalsGroupID;
    @XmlAttribute(name = "PaymentCurrency")
    protected String paymentCurrency;
    @XmlAttribute(name = "LoyaltyUnit")
    protected String loyaltyUnit;
    @XmlAttribute(name = "LoyaltyCurrency")
    protected String loyaltyCurrency;

    /**
     * Gets the value of the paymentTotals property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentTotals property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentTotals().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentTotalsType }
     * 
     * 
     */
    public List<PaymentTotalsType> getPaymentTotals() {
        if (paymentTotals == null) {
            paymentTotals = new ArrayList<PaymentTotalsType>();
        }
        return this.paymentTotals;
    }

    /**
     * Gets the value of the loyaltyTotals property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loyaltyTotals property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoyaltyTotals().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LoyaltyTotalsType }
     * 
     * 
     */
    public List<LoyaltyTotalsType> getLoyaltyTotals() {
        if (loyaltyTotals == null) {
            loyaltyTotals = new ArrayList<LoyaltyTotalsType>();
        }
        return this.loyaltyTotals;
    }

    /**
     * Gets the value of the paymentInstrumentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentInstrumentType() {
        return paymentInstrumentType;
    }

    /**
     * Sets the value of the paymentInstrumentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentInstrumentType(String value) {
        this.paymentInstrumentType = value;
    }

    /**
     * Gets the value of the acquirerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcquirerID() {
        return acquirerID;
    }

    /**
     * Sets the value of the acquirerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcquirerID(String value) {
        this.acquirerID = value;
    }

    /**
     * Gets the value of the errorCondition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCondition() {
        return errorCondition;
    }

    /**
     * Sets the value of the errorCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCondition(String value) {
        this.errorCondition = value;
    }

    /**
     * Gets the value of the hostReconciliationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostReconciliationID() {
        return hostReconciliationID;
    }

    /**
     * Sets the value of the hostReconciliationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostReconciliationID(String value) {
        this.hostReconciliationID = value;
    }

    /**
     * Gets the value of the cardBrand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardBrand() {
        return cardBrand;
    }

    /**
     * Sets the value of the cardBrand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardBrand(String value) {
        this.cardBrand = value;
    }

    /**
     * Gets the value of the poiid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOIID() {
        return poiid;
    }

    /**
     * Sets the value of the poiid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOIID(String value) {
        this.poiid = value;
    }

    /**
     * Gets the value of the saleID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaleID() {
        return saleID;
    }

    /**
     * Sets the value of the saleID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaleID(String value) {
        this.saleID = value;
    }

    /**
     * Gets the value of the operatorID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorID() {
        return operatorID;
    }

    /**
     * Sets the value of the operatorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorID(String value) {
        this.operatorID = value;
    }

    /**
     * Gets the value of the shiftNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShiftNumber() {
        return shiftNumber;
    }

    /**
     * Sets the value of the shiftNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShiftNumber(String value) {
        this.shiftNumber = value;
    }

    /**
     * Gets the value of the totalsGroupID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalsGroupID() {
        return totalsGroupID;
    }

    /**
     * Sets the value of the totalsGroupID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalsGroupID(String value) {
        this.totalsGroupID = value;
    }

    /**
     * Gets the value of the paymentCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    /**
     * Sets the value of the paymentCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentCurrency(String value) {
        this.paymentCurrency = value;
    }

    /**
     * Gets the value of the loyaltyUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoyaltyUnit() {
        if (loyaltyUnit == null) {
            return "Point";
        } else {
            return loyaltyUnit;
        }
    }

    /**
     * Sets the value of the loyaltyUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoyaltyUnit(String value) {
        this.loyaltyUnit = value;
    }

    /**
     * Gets the value of the loyaltyCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoyaltyCurrency() {
        return loyaltyCurrency;
    }

    /**
     * Sets the value of the loyaltyCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoyaltyCurrency(String value) {
        this.loyaltyCurrency = value;
    }

}
