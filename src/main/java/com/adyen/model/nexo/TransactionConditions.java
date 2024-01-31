package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
    @Schema(description = "Card payment brands allowed by the Sale System for the payment transaction. --Rule: Restrict brand if data sent")
    protected List<String> allowedPaymentBrand;
    /**
     * The Acquirer id.
     */
    @XmlElement(name = "AcquirerID")
    @Schema(description = "Identification of the Acquirer --Rule: Restrict to these Acquirer if present")
    protected List<String> acquirerID;
    /**
     * The Allowed loyalty brand.
     */
    @XmlElement(name = "AllowedLoyaltyBrand")
    @Schema(description = "Loyalty brands or programs allowed by the Sale System for the loyalty transaction. --Rule: Restrict brand if data sent")
    protected List<String> allowedLoyaltyBrand;
    /**
     * The Force entry mode.
     */
    @XmlElement(name = "ForceEntryMode")
    @Schema(description = "Payment instrument entry mode requested by the Sale System. --Rule: Restrict entry mode if sent")
    protected List<ForceEntryModeType> forceEntryMode;
    /**
     * The Debit preferred flag.
     */
    @XmlElement(name = "DebitPreferredFlag")
    @Schema(description = "The preferred type of payment is a debit transaction rather a credit transaction. --Rule: The preferred type of payment is a debit transaction rather a credit transaction.")
    protected Boolean debitPreferredFlag;
    /**
     * The Loyalty handling.
     */
    @XmlElement(name = "LoyaltyHandling")
    @Schema(description = "Type of Loyalty processing requested by the Sale System.")
    protected LoyaltyHandlingType loyaltyHandling;
    /**
     * The Customer language.
     */
    @XmlElement(name = "CustomerLanguage")
    @Schema(description = "Language of the Customer --Rule: If the language is selected by the Sale System before the request to the POI.")
    protected String customerLanguage;
    /**
     * The Force online flag.
     */
    @XmlElement(name = "ForceOnlineFlag")
    @Schema(description = "Indicates if the Cashier requires POI forces online access to the Acquirer. --Rule:  Go online if data sent")
    protected Boolean forceOnlineFlag;
    /**
     * The Merchant category code.
     */
    @XmlElement(name = "MerchantCategoryCode")
    @Schema(description = "The code which identifies the category of the transaction (MCC). --Rule: The payment implies a specific MCC.", minLength = 3, maxLength = 4)
    protected String merchantCategoryCode;

    /**
     * Gets the value of the allowedPaymentBrand property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedPaymentBrand property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedPaymentBrand().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
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
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acquirerID property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcquirerID().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
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
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedLoyaltyBrand property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedLoyaltyBrand().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
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
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the forceEntryMode property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForceEntryMode().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
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
