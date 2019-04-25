
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the requested Message Response. -- Usage: Allow the knowledge of the last Payment, Loyalty or Reversal transaction
 * 
 * <p>Java class for RepeatedMessageResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RepeatedMessageResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageHeader" type="{}MessageHeaderType"/>
 *         &lt;choice>
 *           &lt;element name="LoyaltyResponse" type="{}LoyaltyResponseType"/>
 *           &lt;element name="PaymentResponse" type="{}PaymentResponseType"/>
 *           &lt;element name="ReversalResponse" type="{}ReversalResponseType"/>
 *           &lt;element name="StoredValueResponse" type="{}StoredValueResponseType"/>
 *           &lt;element name="CardAcquisitionResponse" type="{}CardAcquisitionResponseType"/>
 *           &lt;element name="CardReaderAPDUResponse" type="{}CardReaderAPDUResponseType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RepeatedMessageResponseType", propOrder = {
    "messageHeader",
    "loyaltyResponse",
    "paymentResponse",
    "reversalResponse",
    "storedValueResponse",
    "cardAcquisitionResponse",
    "cardReaderAPDUResponse"
})
public class RepeatedMessageResponseType {

    @XmlElement(name = "MessageHeader", required = true)
    protected MessageHeaderType messageHeader;
    @XmlElement(name = "LoyaltyResponse")
    protected LoyaltyResponseType loyaltyResponse;
    @XmlElement(name = "PaymentResponse")
    protected PaymentResponseType paymentResponse;
    @XmlElement(name = "ReversalResponse")
    protected ReversalResponseType reversalResponse;
    @XmlElement(name = "StoredValueResponse")
    protected StoredValueResponseType storedValueResponse;
    @XmlElement(name = "CardAcquisitionResponse")
    protected CardAcquisitionResponseType cardAcquisitionResponse;
    @XmlElement(name = "CardReaderAPDUResponse")
    protected CardReaderAPDUResponseType cardReaderAPDUResponse;

    /**
     * Gets the value of the messageHeader property.
     * 
     * @return
     *     possible object is
     *     {@link MessageHeaderType }
     *     
     */
    public MessageHeaderType getMessageHeader() {
        return messageHeader;
    }

    /**
     * Sets the value of the messageHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageHeaderType }
     *     
     */
    public void setMessageHeader(MessageHeaderType value) {
        this.messageHeader = value;
    }

    /**
     * Gets the value of the loyaltyResponse property.
     * 
     * @return
     *     possible object is
     *     {@link LoyaltyResponseType }
     *     
     */
    public LoyaltyResponseType getLoyaltyResponse() {
        return loyaltyResponse;
    }

    /**
     * Sets the value of the loyaltyResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyaltyResponseType }
     *     
     */
    public void setLoyaltyResponse(LoyaltyResponseType value) {
        this.loyaltyResponse = value;
    }

    /**
     * Gets the value of the paymentResponse property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentResponseType }
     *     
     */
    public PaymentResponseType getPaymentResponse() {
        return paymentResponse;
    }

    /**
     * Sets the value of the paymentResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentResponseType }
     *     
     */
    public void setPaymentResponse(PaymentResponseType value) {
        this.paymentResponse = value;
    }

    /**
     * Gets the value of the reversalResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ReversalResponseType }
     *     
     */
    public ReversalResponseType getReversalResponse() {
        return reversalResponse;
    }

    /**
     * Sets the value of the reversalResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReversalResponseType }
     *     
     */
    public void setReversalResponse(ReversalResponseType value) {
        this.reversalResponse = value;
    }

    /**
     * Gets the value of the storedValueResponse property.
     * 
     * @return
     *     possible object is
     *     {@link StoredValueResponseType }
     *     
     */
    public StoredValueResponseType getStoredValueResponse() {
        return storedValueResponse;
    }

    /**
     * Sets the value of the storedValueResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link StoredValueResponseType }
     *     
     */
    public void setStoredValueResponse(StoredValueResponseType value) {
        this.storedValueResponse = value;
    }

    /**
     * Gets the value of the cardAcquisitionResponse property.
     * 
     * @return
     *     possible object is
     *     {@link CardAcquisitionResponseType }
     *     
     */
    public CardAcquisitionResponseType getCardAcquisitionResponse() {
        return cardAcquisitionResponse;
    }

    /**
     * Sets the value of the cardAcquisitionResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardAcquisitionResponseType }
     *     
     */
    public void setCardAcquisitionResponse(CardAcquisitionResponseType value) {
        this.cardAcquisitionResponse = value;
    }

    /**
     * Gets the value of the cardReaderAPDUResponse property.
     * 
     * @return
     *     possible object is
     *     {@link CardReaderAPDUResponseType }
     *     
     */
    public CardReaderAPDUResponseType getCardReaderAPDUResponse() {
        return cardReaderAPDUResponse;
    }

    /**
     * Sets the value of the cardReaderAPDUResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardReaderAPDUResponseType }
     *     
     */
    public void setCardReaderAPDUResponse(CardReaderAPDUResponseType value) {
        this.cardReaderAPDUResponse = value;
    }

}
