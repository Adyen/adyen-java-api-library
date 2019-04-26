
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the requested Message Response. -- Usage: Allow the knowledge of the last Payment, Loyalty or Reversal transaction
 *
 * <p>Java class for RepeatedMessageResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="RepeatedMessageResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageHeader" type="{}MessageHeader"/>
 *         &lt;choice>
 *           &lt;element name="LoyaltyResponse" type="{}LoyaltyResponse"/>
 *           &lt;element name="PaymentResponse" type="{}PaymentResponse"/>
 *           &lt;element name="ReversalResponse" type="{}ReversalResponse"/>
 *           &lt;element name="StoredValueResponse" type="{}StoredValueResponse"/>
 *           &lt;element name="CardAcquisitionResponse" type="{}CardAcquisitionResponse"/>
 *           &lt;element name="CardReaderAPDUResponse" type="{}CardReaderAPDUResponse"/>
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
@XmlType(name = "RepeatedMessageResponse", propOrder = {
    "messageHeader",
    "loyaltyResponse",
    "paymentResponse",
    "reversalResponse",
    "storedValueResponse",
    "cardAcquisitionResponse",
    "cardReaderAPDUResponse"
})
public class RepeatedMessageResponse {

    @XmlElement(name = "MessageHeader", required = true)
    protected MessageHeader messageHeader;
    @XmlElement(name = "LoyaltyResponse")
    protected LoyaltyResponse loyaltyResponse;
    @XmlElement(name = "PaymentResponse")
    protected PaymentResponse paymentResponse;
    @XmlElement(name = "ReversalResponse")
    protected ReversalResponse reversalResponse;
    @XmlElement(name = "StoredValueResponse")
    protected StoredValueResponse storedValueResponse;
    @XmlElement(name = "CardAcquisitionResponse")
    protected CardAcquisitionResponse cardAcquisitionResponse;
    @XmlElement(name = "CardReaderAPDUResponse")
    protected CardReaderAPDUResponse cardReaderAPDUResponse;

    /**
     * Gets the value of the messageHeader property.
     *
     * @return
     *     possible object is
     *     {@link MessageHeader }
     *
     */
    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    /**
     * Sets the value of the messageHeader property.
     *
     * @param value
     *     allowed object is
     *     {@link MessageHeader }
     *
     */
    public void setMessageHeader(MessageHeader value) {
        this.messageHeader = value;
    }

    /**
     * Gets the value of the loyaltyResponse property.
     *
     * @return
     *     possible object is
     *     {@link LoyaltyResponse }
     *
     */
    public LoyaltyResponse getLoyaltyResponse() {
        return loyaltyResponse;
    }

    /**
     * Sets the value of the loyaltyResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link LoyaltyResponse }
     *
     */
    public void setLoyaltyResponse(LoyaltyResponse value) {
        this.loyaltyResponse = value;
    }

    /**
     * Gets the value of the paymentResponse property.
     *
     * @return
     *     possible object is
     *     {@link PaymentResponse }
     *
     */
    public PaymentResponse getPaymentResponse() {
        return paymentResponse;
    }

    /**
     * Sets the value of the paymentResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link PaymentResponse }
     *
     */
    public void setPaymentResponse(PaymentResponse value) {
        this.paymentResponse = value;
    }

    /**
     * Gets the value of the reversalResponse property.
     *
     * @return
     *     possible object is
     *     {@link ReversalResponse }
     *
     */
    public ReversalResponse getReversalResponse() {
        return reversalResponse;
    }

    /**
     * Sets the value of the reversalResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link ReversalResponse }
     *
     */
    public void setReversalResponse(ReversalResponse value) {
        this.reversalResponse = value;
    }

    /**
     * Gets the value of the storedValueResponse property.
     *
     * @return
     *     possible object is
     *     {@link StoredValueResponse }
     *
     */
    public StoredValueResponse getStoredValueResponse() {
        return storedValueResponse;
    }

    /**
     * Sets the value of the storedValueResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link StoredValueResponse }
     *
     */
    public void setStoredValueResponse(StoredValueResponse value) {
        this.storedValueResponse = value;
    }

    /**
     * Gets the value of the cardAcquisitionResponse property.
     *
     * @return
     *     possible object is
     *     {@link CardAcquisitionResponse }
     *
     */
    public CardAcquisitionResponse getCardAcquisitionResponse() {
        return cardAcquisitionResponse;
    }

    /**
     * Sets the value of the cardAcquisitionResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link CardAcquisitionResponse }
     *
     */
    public void setCardAcquisitionResponse(CardAcquisitionResponse value) {
        this.cardAcquisitionResponse = value;
    }

    /**
     * Gets the value of the cardReaderAPDUResponse property.
     *
     * @return
     *     possible object is
     *     {@link CardReaderAPDUResponse }
     *
     */
    public CardReaderAPDUResponse getCardReaderAPDUResponse() {
        return cardReaderAPDUResponse;
    }

    /**
     * Sets the value of the cardReaderAPDUResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link CardReaderAPDUResponse }
     *
     */
    public void setCardReaderAPDUResponse(CardReaderAPDUResponse value) {
        this.cardReaderAPDUResponse = value;
    }

}
