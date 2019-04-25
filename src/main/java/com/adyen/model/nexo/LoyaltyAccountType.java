
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to a loyalty account processed in the transaction. -- Usage: This data structure conveys the identification of the account and the associated loyalty brand.
 * 
 * <p>Java class for LoyaltyAccountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoyaltyAccountType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LoyaltyAccountID" type="{}LoyaltyAccountIDType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="LoyaltyBrand" type="{}LoyaltyBrandType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyAccountType", propOrder = {
    "loyaltyAccountID"
})
public class LoyaltyAccountType {

    @XmlElement(name = "LoyaltyAccountID", required = true)
    protected LoyaltyAccountIDType loyaltyAccountID;
    @XmlAttribute(name = "LoyaltyBrand")
    protected String loyaltyBrand;

    /**
     * Gets the value of the loyaltyAccountID property.
     * 
     * @return
     *     possible object is
     *     {@link LoyaltyAccountIDType }
     *     
     */
    public LoyaltyAccountIDType getLoyaltyAccountID() {
        return loyaltyAccountID;
    }

    /**
     * Sets the value of the loyaltyAccountID property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyaltyAccountIDType }
     *     
     */
    public void setLoyaltyAccountID(LoyaltyAccountIDType value) {
        this.loyaltyAccountID = value;
    }

    /**
     * Gets the value of the loyaltyBrand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoyaltyBrand() {
        return loyaltyBrand;
    }

    /**
     * Sets the value of the loyaltyBrand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoyaltyBrand(String value) {
        this.loyaltyBrand = value;
    }

}
