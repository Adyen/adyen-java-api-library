
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to a Loyalty program or account. -- Usage: In the Payment, Loyalty or Balance Inquiry Request message, it allows the Sale Terminal to send the identification of the loyalty account or an awarded amount or an amount to redeem to the loyalty account.
 * 
 * <p>Java class for LoyaltyDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoyaltyDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardAcquisitionReference" type="{}TransactionIdentificationType" minOccurs="0"/>
 *         &lt;element name="LoyaltyAccountID" type="{}LoyaltyAccountIDType" minOccurs="0"/>
 *         &lt;element name="LoyaltyAmount" type="{}LoyaltyAmountType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyDataType", propOrder = {
    "cardAcquisitionReference",
    "loyaltyAccountID",
    "loyaltyAmount"
})
public class LoyaltyDataType {

    @XmlElement(name = "CardAcquisitionReference")
    protected TransactionIdentificationType cardAcquisitionReference;
    @XmlElement(name = "LoyaltyAccountID")
    protected LoyaltyAccountIDType loyaltyAccountID;
    @XmlElement(name = "LoyaltyAmount")
    protected LoyaltyAmountType loyaltyAmount;

    /**
     * Gets the value of the cardAcquisitionReference property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionIdentificationType }
     *     
     */
    public TransactionIdentificationType getCardAcquisitionReference() {
        return cardAcquisitionReference;
    }

    /**
     * Sets the value of the cardAcquisitionReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionIdentificationType }
     *     
     */
    public void setCardAcquisitionReference(TransactionIdentificationType value) {
        this.cardAcquisitionReference = value;
    }

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

}
