
package com.adyen.model.nexo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the result of a loyalty Balance Inquiry. -- Usage: In the Message Response, the result of each loyalty brand transaction.
 * 
 * <p>Java class for LoyaltyAccountStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoyaltyAccountStatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LoyaltyAccount" type="{}LoyaltyAccountType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CurrentBalance" type="{}SimpleAmountType" />
 *       &lt;attribute name="LoyaltyUnit" type="{}LoyaltyUnitTypeCode" default="Point" />
 *       &lt;attribute name="Currency" type="{}ISOCurrency3A" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyAccountStatusType", propOrder = {
    "loyaltyAccount"
})
public class LoyaltyAccountStatusType {

    @XmlElement(name = "LoyaltyAccount", required = true)
    protected LoyaltyAccountType loyaltyAccount;
    @XmlAttribute(name = "CurrentBalance")
    protected BigDecimal currentBalance;
    @XmlAttribute(name = "LoyaltyUnit")
    protected String loyaltyUnit;
    @XmlAttribute(name = "Currency")
    protected String currency;

    /**
     * Gets the value of the loyaltyAccount property.
     * 
     * @return
     *     possible object is
     *     {@link LoyaltyAccountType }
     *     
     */
    public LoyaltyAccountType getLoyaltyAccount() {
        return loyaltyAccount;
    }

    /**
     * Sets the value of the loyaltyAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyaltyAccountType }
     *     
     */
    public void setLoyaltyAccount(LoyaltyAccountType value) {
        this.loyaltyAccount = value;
    }

    /**
     * Gets the value of the currentBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    /**
     * Sets the value of the currentBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCurrentBalance(BigDecimal value) {
        this.currentBalance = value;
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
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

}
