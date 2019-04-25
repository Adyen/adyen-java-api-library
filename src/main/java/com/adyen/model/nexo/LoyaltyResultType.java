
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
 * <p>Java class for LoyaltyResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoyaltyResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LoyaltyAccount" type="{}LoyaltyAccountType"/>
 *         &lt;element name="LoyaltyAmount" type="{}LoyaltyAmountType" minOccurs="0"/>
 *         &lt;element name="LoyaltyAcquirerData" type="{}LoyaltyAcquirerDataType" minOccurs="0"/>
 *         &lt;element name="Rebates" type="{}RebatesType" minOccurs="0"/>
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
@XmlType(name = "LoyaltyResultType", propOrder = {
    "loyaltyAccount",
    "loyaltyAmount",
    "loyaltyAcquirerData",
    "rebates"
})
public class LoyaltyResultType {

    @XmlElement(name = "LoyaltyAccount", required = true)
    protected LoyaltyAccountType loyaltyAccount;
    @XmlElement(name = "LoyaltyAmount")
    protected LoyaltyAmountType loyaltyAmount;
    @XmlElement(name = "LoyaltyAcquirerData")
    protected LoyaltyAcquirerDataType loyaltyAcquirerData;
    @XmlElement(name = "Rebates")
    protected RebatesType rebates;
    @XmlAttribute(name = "CurrentBalance")
    protected BigDecimal currentBalance;

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
     * Gets the value of the loyaltyAmount property.
     * 
     * @return
     *     possible object is
     *     {@link LoyaltyAmountType }
     *     
     */
    public LoyaltyAmountType getLoyaltyAmount() {
        return loyaltyAmount;
    }

    /**
     * Sets the value of the loyaltyAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyaltyAmountType }
     *     
     */
    public void setLoyaltyAmount(LoyaltyAmountType value) {
        this.loyaltyAmount = value;
    }

    /**
     * Gets the value of the loyaltyAcquirerData property.
     * 
     * @return
     *     possible object is
     *     {@link LoyaltyAcquirerDataType }
     *     
     */
    public LoyaltyAcquirerDataType getLoyaltyAcquirerData() {
        return loyaltyAcquirerData;
    }

    /**
     * Sets the value of the loyaltyAcquirerData property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyaltyAcquirerDataType }
     *     
     */
    public void setLoyaltyAcquirerData(LoyaltyAcquirerDataType value) {
        this.loyaltyAcquirerData = value;
    }

    /**
     * Gets the value of the rebates property.
     * 
     * @return
     *     possible object is
     *     {@link RebatesType }
     *     
     */
    public RebatesType getRebates() {
        return rebates;
    }

    /**
     * Sets the value of the rebates property.
     * 
     * @param value
     *     allowed object is
     *     {@link RebatesType }
     *     
     */
    public void setRebates(RebatesType value) {
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
