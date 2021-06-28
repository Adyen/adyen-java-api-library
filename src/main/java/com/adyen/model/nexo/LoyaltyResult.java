package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * Definition: Data related to the result of a processed loyalty transaction. -- Usage: In the Message Response, the result of each loyalty brand transaction.
 *
 * <p>Java class for LoyaltyResult complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LoyaltyResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LoyaltyAccount" type="{}LoyaltyAccount"/&gt;
 *         &lt;element name="LoyaltyAmount" type="{}LoyaltyAmount" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyAcquirerData" type="{}LoyaltyAcquirerData" minOccurs="0"/&gt;
 *         &lt;element name="Rebates" type="{}Rebates" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="CurrentBalance" type="{}SimpleAmountType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyResult", propOrder = {
        "loyaltyAccount",
        "loyaltyAmount",
        "loyaltyAcquirerData",
        "rebates"
})
public class LoyaltyResult {

    /**
     * The Loyalty account.
     */
    @XmlElement(name = "LoyaltyAccount", required = true)
    @Schema(description = "Data related to a loyalty account processed in the transaction.")
    protected LoyaltyAccount loyaltyAccount;
    /**
     * The Loyalty amount.
     */
    @XmlElement(name = "LoyaltyAmount")
    @Schema(description = "Amount of a loyalty account. --Rule: If awarded amount")
    protected LoyaltyAmount loyaltyAmount;
    /**
     * The Loyalty acquirer data.
     */
    @XmlElement(name = "LoyaltyAcquirerData")
    @Schema(description = "Data related to the loyalty Acquirer during a loyalty transaction. --Rule: if content not empty")
    protected LoyaltyAcquirerData loyaltyAcquirerData;
    /**
     * The Rebates.
     */
    @XmlElement(name = "Rebates")
    @Schema(description = "Rebate form to an award; --Rule: if rebates awarded")
    protected Rebates rebates;
    /**
     * The Current balance.
     */
    @XmlElement(name = "CurrentBalance")
    @Schema(description = "Balance of an account. --Rule: if known (provided by the card or an external host)")
    protected BigDecimal currentBalance;

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
     * Gets the value of the loyaltyAmount property.
     *
     * @return possible      object is     {@link LoyaltyAmount }
     */
    public LoyaltyAmount getLoyaltyAmount() {
        return loyaltyAmount;
    }

    /**
     * Sets the value of the loyaltyAmount property.
     *
     * @param value allowed object is     {@link LoyaltyAmount }
     */
    public void setLoyaltyAmount(LoyaltyAmount value) {
        this.loyaltyAmount = value;
    }

    /**
     * Gets the value of the loyaltyAcquirerData property.
     *
     * @return possible      object is     {@link LoyaltyAcquirerData }
     */
    public LoyaltyAcquirerData getLoyaltyAcquirerData() {
        return loyaltyAcquirerData;
    }

    /**
     * Sets the value of the loyaltyAcquirerData property.
     *
     * @param value allowed object is     {@link LoyaltyAcquirerData }
     */
    public void setLoyaltyAcquirerData(LoyaltyAcquirerData value) {
        this.loyaltyAcquirerData = value;
    }

    /**
     * Gets the value of the rebates property.
     *
     * @return possible      object is     {@link Rebates }
     */
    public Rebates getRebates() {
        return rebates;
    }

    /**
     * Sets the value of the rebates property.
     *
     * @param value allowed object is     {@link Rebates }
     */
    public void setRebates(Rebates value) {
        this.rebates = value;
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

}
