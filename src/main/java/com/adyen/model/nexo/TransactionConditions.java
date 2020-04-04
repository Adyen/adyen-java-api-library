package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Conditions on which the transaction must be processed.
 *
 * <p>Java class for TransactionConditions complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TransactionConditions"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AllowedPaymentBrand" type="{}AllowedPaymentBrand" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="AcquirerID" type="{}AcquirerID" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="AllowedLoyaltyBrand" type="{}AllowedLoyaltyBrand" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ForceEntryMode" type="{}ForceEntryMode" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="DebitPreferredFlag" type="{}DebitPreferredFlag" default="false" /&gt;
 *       &lt;attribute name="LoyaltyHandling" type="{}LoyaltyHandlingType" default="Forbidden" /&gt;
 *       &lt;attribute name="CustomerLanguage" type="{}ISOLanguage2A" /&gt;
 *       &lt;attribute name="ForceOnlineFlag" type="{}ForceOnlineFlag" default="false" /&gt;
 *       &lt;attribute name="MerchantCategoryCode" type="{}MerchantCategoryCode" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionConditions", propOrder = {
        "allowedPaymentBrand",
        "acquirerID",
        "allowedLoyaltyBrand",
        "forceEntryMode"
})
public class TransactionConditions {

    /**
     * The Allowed payment brand.
     */
    @XmlElement(name = "AllowedPaymentBrand")
    protected List<String> allowedPaymentBrand;
    /**
     * The Acquirer id.
     */
    @XmlElement(name = "AcquirerID")
    protected List<String> acquirerID;
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
     * The Debit preferred flag.
     */
    @XmlAttribute(name = "DebitPreferredFlag")
    protected Boolean debitPreferredFlag;
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
     * The Force online flag.
     */
    @XmlAttribute(name = "ForceOnlineFlag")
    protected Boolean forceOnlineFlag;
    /**
     * The Merchant category code.
     */
    @XmlAttribute(name = "MerchantCategoryCode")
    protected String merchantCategoryCode;

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
     * Gets the value of the acquirerID property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acquirerID property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcquirerID().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     * @return the acquirer id
     */
    public List<String> getAcquirerID() {
        if (acquirerID == null) {
            acquirerID = new ArrayList<>();
        }
        return this.acquirerID;
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
     * Gets the value of the debitPreferredFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public boolean isDebitPreferredFlag() {
        if (debitPreferredFlag == null) {
            return false;
        } else {
            return debitPreferredFlag;
        }
    }

    /**
     * Sets the value of the debitPreferredFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setDebitPreferredFlag(Boolean value) {
        this.debitPreferredFlag = value;
    }

    /**
     * Gets the value of the loyaltyHandling property.
     *
     * @return possible      object is     {@link LoyaltyHandlingType }
     */
    public LoyaltyHandlingType getLoyaltyHandling() {
        if (loyaltyHandling == null) {
            return LoyaltyHandlingType.FORBIDDEN;
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
     * Gets the value of the forceOnlineFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public boolean isForceOnlineFlag() {
        if (forceOnlineFlag == null) {
            return false;
        } else {
            return forceOnlineFlag;
        }
    }

    /**
     * Sets the value of the forceOnlineFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setForceOnlineFlag(Boolean value) {
        this.forceOnlineFlag = value;
    }

    /**
     * Gets the value of the merchantCategoryCode property.
     *
     * @return possible      object is     {@link String }
     */
    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    /**
     * Sets the value of the merchantCategoryCode property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setMerchantCategoryCode(String value) {
        this.merchantCategoryCode = value;
    }

}
