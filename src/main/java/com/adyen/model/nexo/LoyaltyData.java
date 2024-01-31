package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to a Loyalty program or account. -- Usage: In the Payment, Loyalty or Balance Inquiry Request messageType, it allows the Sale Terminal to send the identification of the loyalty account or an awarded amount or an amount to redeem to the loyalty account.
 *
 * <p>Java class for LoyaltyData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LoyaltyData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CardAcquisitionReference" type="{}TransactionIdentification" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyAccountID" type="{}LoyaltyAccountID" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyAmount" type="{}LoyaltyAmount" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyData", propOrder = {
        "cardAcquisitionReference",
        "loyaltyAccountID",
        "loyaltyAmount"
})
public class LoyaltyData {

    /**
     * The Card acquisition reference.
     */
    @XmlElement(name = "CardAcquisitionReference")
    @Schema(description = "Reference to the last CardAcquisition, to use the same card. --Rule: If the loyalty account ID comes from a previous CardAcquisition")
    protected TransactionIdentification cardAcquisitionReference;
    /**
     * The Loyalty account id.
     */
    @XmlElement(name = "LoyaltyAccountID")
    @Schema(description = "Identification of a Loyalty account. --Rule: If loyalty identification of the loyalty account is realised by the Sale System")
    protected LoyaltyAccountID loyaltyAccountID;
    /**
     * The Loyalty amount.
     */
    @XmlElement(name = "LoyaltyAmount")
    @Schema(description = "Amount of a loyalty account. --Rule: When the Sale System want to award the Loyalty account  (not for BalanceInquiryRequest)")
    protected LoyaltyAmount loyaltyAmount;

    /**
     * Gets the value of the cardAcquisitionReference property.
     *
     * @return possible      object is     {@link TransactionIdentification }
     */
    public TransactionIdentification getCardAcquisitionReference() {
        return cardAcquisitionReference;
    }

    /**
     * Sets the value of the cardAcquisitionReference property.
     *
     * @param value allowed object is     {@link TransactionIdentification }
     */
    public void setCardAcquisitionReference(TransactionIdentification value) {
        this.cardAcquisitionReference = value;
    }

    /**
     * Gets the value of the loyaltyAccountID property.
     *
     * @return possible      object is     {@link LoyaltyAccountID }
     */
    public LoyaltyAccountID getLoyaltyAccountID() {
        return loyaltyAccountID;
    }

    /**
     * Sets the value of the loyaltyAccountID property.
     *
     * @param value allowed object is     {@link LoyaltyAccountID }
     */
    public void setLoyaltyAccountID(LoyaltyAccountID value) {
        this.loyaltyAccountID = value;
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

}
