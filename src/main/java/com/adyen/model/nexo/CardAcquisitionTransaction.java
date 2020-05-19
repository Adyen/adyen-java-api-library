package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Data related to the payment and loyalty card acquisition. -- Usage: Elements requested by the Sale System that are global to the payment or loyalty transaction.
 *
 * <p>Java class for CardAcquisitionTransaction complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CardAcquisitionTransaction"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AllowedPaymentBrand" type="{}AllowedPaymentBrand" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="AllowedLoyaltyBrand" type="{}AllowedLoyaltyBrand" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ForceEntryMode" type="{}ForceEntryMode" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="LoyaltyHandling" type="{}LoyaltyHandlingType" default="Allowed" /&gt;
 *       &lt;attribute name="CustomerLanguage" type="{}ISOLanguage2A" /&gt;
 *       &lt;attribute name="ForceCustomerSelectionFlag" type="{}ForceCustomerSelectionFlag" default="false" /&gt;
 *       &lt;attribute name="TotalAmount" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="Payment" type="{}PaymentType" /&gt;
 *       &lt;attribute name="CashBackFlag" type="{}CashBackFlag" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardAcquisitionTransaction", propOrder = {
        "allowedPaymentBrand",
        "allowedLoyaltyBrand",
        "forceEntryMode"
})
public class CardAcquisitionTransaction {

    /**
     * The Allowed payment brand.
     */
    @XmlElement(name = "AllowedPaymentBrand")
    protected List<String> allowedPaymentBrand;
    /**
     * The Allowed loyalty brand.
     */
    @XmlElement(name = "AllowedLoyaltyBrand")
    protected List<String> allowedLoyaltyBrand;
    /**
     * The Force entry mode.
     */
    @XmlElement(name = "ForceEntryMode")
    protected List<ForceEntryModeType> forceEntryMode;
    /**
     * The Loyalty handling.
     */
    @XmlAttribute(name = "LoyaltyHandling")
    protected LoyaltyHandlingType loyaltyHandling;
    /**
     * The Customer language.
     */
    @XmlAttribute(name = "CustomerLanguage")
    protected String customerLanguage;
    /**
     * The Force customer selection flag.
     */
    @XmlAttribute(name = "ForceCustomerSelectionFlag")
    protected Boolean forceCustomerSelectionFlag;
    /**
     * The Total amount.
     */
    @XmlAttribute(name = "TotalAmount")
    protected BigDecimal totalAmount;
    /**
     * The Payment.
     */
    @XmlAttribute(name = "PaymentType")
    protected PaymentType paymentType;
    /**
     * The Cash back flag.
     */
    @XmlAttribute(name = "CashBackFlag")
    protected Boolean cashBackFlag;

    /**
     * Gets the value of the allowedPaymentBrand property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedPaymentBrand property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedPaymentBrand().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     * @return the allowed payment brand
     */
    public List<String> getAllowedPaymentBrand() {
        if (allowedPaymentBrand == null) {
            allowedPaymentBrand = new ArrayList<>();
        }
        return this.allowedPaymentBrand;
    }

    /**
     * Gets the value of the allowedLoyaltyBrand property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedLoyaltyBrand property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedLoyaltyBrand().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     * @return the allowed loyalty brand
     */
    public List<String> getAllowedLoyaltyBrand() {
        if (allowedLoyaltyBrand == null) {
            allowedLoyaltyBrand = new ArrayList<>();
        }
        return this.allowedLoyaltyBrand;
    }

    /**
     * Gets the value of the forceEntryMode property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the forceEntryMode property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForceEntryMode().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link ForceEntryModeType }
     *
     * @return the force entry mode
     */
    public List<ForceEntryModeType> getForceEntryMode() {
        if (forceEntryMode == null) {
            forceEntryMode = new ArrayList<>();
        }
        return this.forceEntryMode;
    }

    /**
     * Gets the value of the loyaltyHandling property.
     *
     * @return possible      object is     {@link LoyaltyHandlingType }
     */
    public LoyaltyHandlingType getLoyaltyHandling() {
        if (loyaltyHandling == null) {
            return LoyaltyHandlingType.ALLOWED;
        } else {
            return loyaltyHandling;
        }
    }

    /**
     * Sets the value of the loyaltyHandling property.
     *
     * @param value allowed object is     {@link LoyaltyHandlingType }
     */
    public void setLoyaltyHandling(LoyaltyHandlingType value) {
        this.loyaltyHandling = value;
    }

    /**
     * Gets the value of the customerLanguage property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCustomerLanguage() {
        return customerLanguage;
    }

    /**
     * Sets the value of the customerLanguage property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCustomerLanguage(String value) {
        this.customerLanguage = value;
    }

    /**
     * Gets the value of the forceCustomerSelectionFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public boolean isForceCustomerSelectionFlag() {
        if (forceCustomerSelectionFlag == null) {
            return false;
        } else {
            return forceCustomerSelectionFlag;
        }
    }

    /**
     * Sets the value of the forceCustomerSelectionFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setForceCustomerSelectionFlag(Boolean value) {
        this.forceCustomerSelectionFlag = value;
    }

    /**
     * Gets the value of the totalAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setTotalAmount(BigDecimal value) {
        this.totalAmount = value;
    }

    /**
     * Gets the value of the paymentType property.
     *
     * @return possible      object is     {@link PaymentType }
     */
    public PaymentType getPaymentType() {
        return paymentType;
    }

    /**
     * Sets the value of the paymentType property.
     *
     * @param value allowed object is     {@link PaymentType }
     */
    public void setPaymentType(PaymentType value) {
        this.paymentType = value;
    }

    /**
     * Gets the value of the cashBackFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public Boolean isCashBackFlag() {
        return cashBackFlag;
    }

    /**
     * Sets the value of the cashBackFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setCashBackFlag(Boolean value) {
        this.cashBackFlag = value;
    }

}
