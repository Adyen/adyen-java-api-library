
package com.adyen.model.nexo;

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
 * Definition: Conditions on which the transaction must be processed.
 *
 * <p>Java class for TransactionConditions complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TransactionConditions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AllowedPaymentBrand" type="{}AllowedPaymentBrand" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AcquirerID" type="{}AcquirerID" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AllowedLoyaltyBrand" type="{}AllowedLoyaltyBrand" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ForceEntryMode" type="{}ForceEntryMode" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="DebitPreferredFlag" type="{}DebitPreferredFlag" default="false" />
 *       &lt;attribute name="LoyaltyHandling" type="{}LoyaltyHandlingType" default="Forbidden" />
 *       &lt;attribute name="CustomerLanguage" type="{}ISOLanguage2A" />
 *       &lt;attribute name="ForceOnlineFlag" type="{}ForceOnlineFlag" default="false" />
 *       &lt;attribute name="MerchantCategoryCode" type="{}MerchantCategoryCode" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionConditions", propOrder = {
    "allowedPaymentBrand",
    "acquirerID",
    "allowedLoyaltyBrand",
    "forceEntryMode"
})
public class TransactionConditions {

    @XmlElement(name = "AllowedPaymentBrand")
    protected List<String> allowedPaymentBrand;
    @XmlElement(name = "AcquirerID")
    protected List<String> acquirerID;
    @XmlElement(name = "AllowedLoyaltyBrand")
    protected List<String> allowedLoyaltyBrand;
    @XmlElementRef(name = "ForceEntryMode", type = JAXBElement.class, required = false)
    protected List<JAXBElement<List<ForceEntryModeType>>> forceEntryMode;
    @XmlAttribute(name = "DebitPreferredFlag")
    protected Boolean debitPreferredFlag;
    @XmlAttribute(name = "LoyaltyHandling")
    protected LoyaltyHandlingType loyaltyHandling;
    @XmlAttribute(name = "CustomerLanguage")
    protected String customerLanguage;
    @XmlAttribute(name = "ForceOnlineFlag")
    protected Boolean forceOnlineFlag;
    @XmlAttribute(name = "MerchantCategoryCode")
    protected String merchantCategoryCode;

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
     * Gets the value of the acquirerID property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acquirerID property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcquirerID().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getAcquirerID() {
        if (acquirerID == null) {
            acquirerID = new ArrayList<String>();
        }
        return this.acquirerID;
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
     * Gets the value of the debitPreferredFlag property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
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
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setDebitPreferredFlag(Boolean value) {
        this.debitPreferredFlag = value;
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
            return LoyaltyHandlingType.FORBIDDEN;
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
     * Gets the value of the forceOnlineFlag property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
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
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setForceOnlineFlag(Boolean value) {
        this.forceOnlineFlag = value;
    }

    /**
     * Gets the value of the merchantCategoryCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    /**
     * Sets the value of the merchantCategoryCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMerchantCategoryCode(String value) {
        this.merchantCategoryCode = value;
    }

}
