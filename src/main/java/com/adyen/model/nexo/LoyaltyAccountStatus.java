
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
 * <p>Java class for LoyaltyAccountStatus complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LoyaltyAccountStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LoyaltyAccount" type="{}LoyaltyAccount"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CurrentBalance" type="{}SimpleAmountType" />
 *       &lt;attribute name="LoyaltyUnit" type="{}LoyaltyUnitType" default="Point" />
 *       &lt;attribute name="Currency" type="{}ISOCurrency3A" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyAccountStatus", propOrder = {
    "loyaltyAccount"
})
public class LoyaltyAccountStatus {

    @XmlElement(name = "LoyaltyAccount", required = true)
    protected LoyaltyAccount loyaltyAccount;
    @XmlAttribute(name = "CurrentBalance")
    protected BigDecimal currentBalance;
    @XmlAttribute(name = "LoyaltyUnit")
    protected LoyaltyUnitType loyaltyUnit;
    @XmlAttribute(name = "Currency")
    protected String currency;

    /**
     * Gets the value of the loyaltyAccount property.
     *
     * @return
     *     possible object is
     *     {@link LoyaltyAccount }
     *
     */
    public LoyaltyAccount getLoyaltyAccount() {
        return loyaltyAccount;
    }

    /**
     * Sets the value of the loyaltyAccount property.
     *
     * @param value
     *     allowed object is
     *     {@link LoyaltyAccount }
     *
     */
    public void setLoyaltyAccount(LoyaltyAccount value) {
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
     *     {@link LoyaltyUnitType }
     *
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
     * @param value
     *     allowed object is
     *     {@link LoyaltyUnitType }
     *
     */
    public void setLoyaltyUnit(LoyaltyUnitType value) {
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
