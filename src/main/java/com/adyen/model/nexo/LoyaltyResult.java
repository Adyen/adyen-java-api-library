
package com.adyen.model.nexo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the result of a processed loyalty transaction. -- Usage: In the Message Response, the result of each loyalty brand transaction.
 *
 * <p>Java class for LoyaltyResult complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LoyaltyResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LoyaltyAccount" type="{}LoyaltyAccount"/>
 *         &lt;element name="LoyaltyAmount" type="{}LoyaltyAmount" minOccurs="0"/>
 *         &lt;element name="LoyaltyAcquirerData" type="{}LoyaltyAcquirerData" minOccurs="0"/>
 *         &lt;element name="Rebates" type="{}Rebates" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CurrentBalance" type="{}SimpleAmountType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyResult", propOrder = {
    "loyaltyAccount",
    "loyaltyAmount",
    "loyaltyAcquirerData",
    "rebates"
})
public class LoyaltyResult {

    @XmlElement(name = "LoyaltyAccount", required = true)
    protected LoyaltyAccount loyaltyAccount;
    @XmlElement(name = "LoyaltyAmount")
    protected LoyaltyAmount loyaltyAmount;
    @XmlElement(name = "LoyaltyAcquirerData")
    protected LoyaltyAcquirerData loyaltyAcquirerData;
    @XmlElement(name = "Rebates")
    protected Rebates rebates;
    @XmlAttribute(name = "CurrentBalance")
    protected BigDecimal currentBalance;

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
     * Gets the value of the loyaltyAmount property.
     *
     * @return
     *     possible object is
     *     {@link LoyaltyAmount }
     *
     */
    public LoyaltyAmount getLoyaltyAmount() {
        return loyaltyAmount;
    }

    /**
     * Sets the value of the loyaltyAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link LoyaltyAmount }
     *
     */
    public void setLoyaltyAmount(LoyaltyAmount value) {
        this.loyaltyAmount = value;
    }

    /**
     * Gets the value of the loyaltyAcquirerData property.
     *
     * @return
     *     possible object is
     *     {@link LoyaltyAcquirerData }
     *
     */
    public LoyaltyAcquirerData getLoyaltyAcquirerData() {
        return loyaltyAcquirerData;
    }

    /**
     * Sets the value of the loyaltyAcquirerData property.
     *
     * @param value
     *     allowed object is
     *     {@link LoyaltyAcquirerData }
     *
     */
    public void setLoyaltyAcquirerData(LoyaltyAcquirerData value) {
        this.loyaltyAcquirerData = value;
    }

    /**
     * Gets the value of the rebates property.
     *
     * @return
     *     possible object is
     *     {@link Rebates }
     *
     */
    public Rebates getRebates() {
        return rebates;
    }

    /**
     * Sets the value of the rebates property.
     *
     * @param value
     *     allowed object is
     *     {@link Rebates }
     *
     */
    public void setRebates(Rebates value) {
        this.rebates = value;
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

}
