package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Merchant using the payment services of a payment facilitator, acting as a card acceptor. -- Usage: Identifies the merchant purchasing items, using the payment facilitator to perform the payment of the items.
 *
 * <p>Java class for SponsoredMerchant complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SponsoredMerchant"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="MerchantName" use="required" type="{}MerchantName" /&gt;
 *       &lt;attribute name="MerchantAddress" type="{}MerchantAddress" /&gt;
 *       &lt;attribute name="MerchantCountry" use="required" type="{}MerchantCountry" /&gt;
 *       &lt;attribute name="MerchantCategoryCode" use="required" type="{}MerchantCategoryCode" /&gt;
 *       &lt;attribute name="RegistrationID" use="required" type="{}RegistrationID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SponsoredMerchant")
public class SponsoredMerchant {

    /**
     * The Merchant name.
     */
    @XmlAttribute(name = "MerchantName", required = true)
    protected String merchantName;
    /**
     * The Merchant address.
     */
    @XmlAttribute(name = "MerchantAddress")
    protected String merchantAddress;
    /**
     * The Merchant country.
     */
    @XmlAttribute(name = "MerchantCountry", required = true)
    protected String merchantCountry;
    /**
     * The Merchant category code.
     */
    @XmlAttribute(name = "MerchantCategoryCode", required = true)
    protected String merchantCategoryCode;
    /**
     * The Registration id.
     */
    @XmlAttribute(name = "RegistrationID", required = true)
    protected String registrationID;

    /**
     * Gets the value of the merchantName property.
     *
     * @return possible      object is     {@link String }
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * Sets the value of the merchantName property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setMerchantName(String value) {
        this.merchantName = value;
    }

    /**
     * Gets the value of the merchantAddress property.
     *
     * @return possible      object is     {@link String }
     */
    public String getMerchantAddress() {
        return merchantAddress;
    }

    /**
     * Sets the value of the merchantAddress property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setMerchantAddress(String value) {
        this.merchantAddress = value;
    }

    /**
     * Gets the value of the merchantCountry property.
     *
     * @return possible      object is     {@link String }
     */
    public String getMerchantCountry() {
        return merchantCountry;
    }

    /**
     * Sets the value of the merchantCountry property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setMerchantCountry(String value) {
        this.merchantCountry = value;
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

    /**
     * Gets the value of the registrationID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getRegistrationID() {
        return registrationID;
    }

    /**
     * Sets the value of the registrationID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setRegistrationID(String value) {
        this.registrationID = value;
    }

}
