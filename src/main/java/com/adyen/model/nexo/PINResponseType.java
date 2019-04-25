
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the PIN Response message. -- Usage: It contains the result of the requested service, with possibly the encrypted PIN.
 * 
 * <p>Java class for PINResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PINResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}ResponseType"/>
 *         &lt;element name="CardholderPIN" type="{}CardholderPINType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PINResponseType", propOrder = {
    "response",
    "cardholderPIN"
})
public class PINResponseType {

    @XmlElement(name = "Response", required = true)
    protected ResponseType response;
    @XmlElement(name = "CardholderPIN")
    protected CardholderPINType cardholderPIN;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseType }
     *     
     */
    public ResponseType getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseType }
     *     
     */
    public void setResponse(ResponseType value) {
        this.response = value;
    }

    /**
     * Gets the value of the cardholderPIN property.
     * 
     * @return
     *     possible object is
     *     {@link CardholderPINType }
     *     
     */
    public CardholderPINType getCardholderPIN() {
        return cardholderPIN;
    }

    /**
     * Sets the value of the cardholderPIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardholderPINType }
     *     
     */
    public void setCardholderPIN(CardholderPINType value) {
        this.cardholderPIN = value;
    }

}
