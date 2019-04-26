
package com.adyen.model.nexo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the payment and loyalty card acquisition. -- Usage: Elements requested by the Sale System that are global to the payment or loyalty transaction.
 *
 * <p>Java class for CardAcquisitionTransaction complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CardAcquisitionTransaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AllowedPaymentBrand" type="{}AllowedPaymentBrand" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AllowedLoyaltyBrand" type="{}AllowedLoyaltyBrand" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ForceEntryMode" type="{}ForceEntryMode" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="LoyaltyHandling" type="{}LoyaltyHandlingType" default="Allowed" />
 *       &lt;attribute name="CustomerLanguage" type="{}ISOLanguage2A" />
 *       &lt;attribute name="ForceCustomerSelectionFlag" type="{}ForceCustomerSelectionFlag" default="false" />
 *       &lt;attribute name="TotalAmount" type="{}SimpleAmountType" />
 *       &lt;attribute name="Payment" type="{}PaymentType" />
 *       &lt;attribute name="CashBackFlag" type="{}CashBackFlag" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardAcquisitionTransaction", propOrder = {
    "allowedPaymentBrand",
    "allowedLoyaltyBrand",
    "forceEntryMode"
})
public class CardAcquisitionTransaction {

    @XmlElement(name = "AllowedPaymentBrand")
    protected List<String> allowedPaymentBrand;
    @XmlElement(name = "AllowedLoyaltyBrand")
    protected List<String> allowedLoyaltyBrand;
    @XmlElementRef(name = "ForceEntryMode", type = JAXBElement.class, required = false)
    protected List<JAXBElement<List<ForceEntryModeType>>> forceEntryMode;
    @XmlAttribute(name = "LoyaltyHandling")
    protected LoyaltyHandlingType loyaltyHandling;
    @XmlAttribute(name = "CustomerLanguage")
    protected String customerLanguage;
    @XmlAttribute(name = "ForceCustomerSelectionFlag")
    protected Boolean forceCustomerSelectionFlag;
    @XmlAttribute(name = "TotalAmount")
    protected BigDecimal totalAmount;
    @XmlAttribute(name = "Payment")
    protected PaymentType payment;
    @XmlAttribute(name = "CashBackFlag")
    protected Boolean cashBackFlag;

    /**
     * Gets the value of the allowedPaymentBrand property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedPaymentBrand property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedPaymentBrand().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getAllowedPaymentBrand() {
        if (allowedPaymentBrand == null) {
            allowedPaymentBrand = new ArrayList<String>();
        }
        return this.allowedPaymentBrand;
    }

    /**
     * Gets the value of the allowedLoyaltyBrand property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedLoyaltyBrand property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedLoyaltyBrand().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getAllowedLoyaltyBrand() {
        if (allowedLoyaltyBrand == null) {
            allowedLoyaltyBrand = new ArrayList<String>();
        }
        return this.allowedLoyaltyBrand;
    }

    /**
     * Gets the value of the forceEntryMode property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the forceEntryMode property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForceEntryMode().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link ForceEntryModeType }{@code >}{@code >}
     *
     *
     */
    public List<JAXBElement<List<ForceEntryModeType>>> getForceEntryMode() {
        if (forceEntryMode == null) {
            forceEntryMode = new ArrayList<JAXBElement<List<ForceEntryModeType>>>();
        }
        return this.forceEntryMode;
    }

    /**
     * Gets the value of the loyaltyHandling property.
     *
     * @return
     *     possible object is
     *     {@link LoyaltyHandlingType }
     *
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
     * @param value
     *     allowed object is
     *     {@link LoyaltyHandlingType }
     *
     */
    public void setLoyaltyHandling(LoyaltyHandlingType value) {
        this.loyaltyHandling = value;
    }

    /**
     * Gets the value of the customerLanguage property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCustomerLanguage() {
        return customerLanguage;
    }

    /**
     * Sets the value of the customerLanguage property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCustomerLanguage(String value) {
        this.customerLanguage = value;
    }

    /**
     * Gets the value of the forceCustomerSelectionFlag property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
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
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setForceCustomerSelectionFlag(Boolean value) {
        this.forceCustomerSelectionFlag = value;
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

    /**
     * Gets the value of the payment property.
     *
     * @return
     *     possible object is
     *     {@link PaymentType }
     *
     */
    public PaymentType getPayment() {
        return payment;
    }

    /**
     * Sets the value of the payment property.
     *
     * @param value
     *     allowed object is
     *     {@link PaymentType }
     *
     */
    public void setPayment(PaymentType value) {
        this.payment = value;
    }

    /**
     * Gets the value of the cashBackFlag property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isCashBackFlag() {
        return cashBackFlag;
    }

    /**
     * Sets the value of the cashBackFlag property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setCashBackFlag(Boolean value) {
        this.cashBackFlag = value;
    }

}
