package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.math.BigDecimal;


/**
 * Definition: Amount of a loyalty account. -- Usage: An awarded amount or an amount to redeem to the loyalty account might be sent in the Payment request messageType. The amount to apply on the requested loyalty service, if not computed from the TotalAmount of the Loyalty request messageType. The
 *
 * <p>Java class for LoyaltyAmount complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LoyaltyAmount"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="Decimal"&gt;
 *       &lt;attribute name="LoyaltyUnit" type="{}LoyaltyUnitType" default="Point" /&gt;
 *       &lt;attribute name="Currency" type="{}ISOCurrency3A" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyAmount", propOrder = {
        "value"
})
public class LoyaltyAmount {

    /**
     * The Value.
     */
    @XmlValue
    protected BigDecimal value;
    /**
     * The Loyalty unit.
     */
    @XmlElement(name = "LoyaltyUnit")
    protected LoyaltyUnitType loyaltyUnit;
    /**
     * The Currency.
     */
    @XmlElement(name = "Currency")
    @Schema(description = "Currency of a monetary amount. --Rule: if LoyaltyUnit is Monetary")
    protected String currency;

    /**
     * Gets the value of the value property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setValue(BigDecimal value) {
        this.value = value;
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
