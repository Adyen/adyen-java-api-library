package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;


/**
 * Definition: Data related to the result of a loyalty Balance Inquiry. -- Usage: In the Message Response, the result of each loyalty brand transaction.
 *
 * <p>Java class for LoyaltyAccountStatus complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LoyaltyAccountStatus"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LoyaltyAccount" type="{}LoyaltyAccount"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="CurrentBalance" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="LoyaltyUnit" type="{}LoyaltyUnitType" default="Point" /&gt;
 *       &lt;attribute name="Currency" type="{}ISOCurrency3A" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyAccountStatus", propOrder = {
        "loyaltyAccount"
})
public class LoyaltyAccountStatus {

    /**
     * The Loyalty account.
     */
    @XmlElement(name = "LoyaltyAccount", required = true)
    @Schema(description = "Data related to a loyalty account processed in the transaction.")
    protected LoyaltyAccount loyaltyAccount;
    /**
     * The Current balance.
     */
    @XmlAttribute(name = "CurrentBalance")
    protected BigDecimal currentBalance;
    /**
     * The Loyalty unit.
     */
    @XmlAttribute(name = "LoyaltyUnit")
    protected LoyaltyUnitType loyaltyUnit;
    /**
     * The Currency.
     */
    @XmlAttribute(name = "Currency")
    protected String currency;

    /**
     * Gets the value of the loyaltyAccount property.
     *
     * @return possible      object is     {@link LoyaltyAccount }
     */
    public LoyaltyAccount getLoyaltyAccount() {
        return loyaltyAccount;
    }

    /**
     * Sets the value of the loyaltyAccount property.
     *
     * @param value allowed object is     {@link LoyaltyAccount }
     */
    public void setLoyaltyAccount(LoyaltyAccount value) {
        this.loyaltyAccount = value;
    }

    /**
     * Gets the value of the currentBalance property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    /**
     * Sets the value of the currentBalance property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setCurrentBalance(BigDecimal value) {
        this.currentBalance = value;
    }

    /**
     * Gets the value of the loyaltyUnit property.
     *
     * @return possible      object is     {@link LoyaltyUnitType }
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
     * @param value allowed object is     {@link LoyaltyUnitType }
     */
    public void setLoyaltyUnit(LoyaltyUnitType value) {
        this.loyaltyUnit = value;
    }

    /**
     * Gets the value of the currency property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

}
