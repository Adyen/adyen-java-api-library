
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the PIN Response message. -- Usage: It contains the result of the requested service, with possibly the encrypted PIN.
 *
 * <p>Java class for PINResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PINResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}Response"/>
 *         &lt;element name="CardholderPIN" type="{}CardholderPIN" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PINResponse", propOrder = {
    "response",
    "cardholderPIN"
})
public class PINResponse {

    @XmlElement(name = "Response", required = true)
    protected Response response;
    @XmlElement(name = "CardholderPIN")
    protected CardholderPIN cardholderPIN;

    /**
     * Gets the value of the response property.
     *
     * @return
     *     possible object is
     *     {@link Response }
     *
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value
     *     allowed object is
     *     {@link Response }
     *
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the cardholderPIN property.
     *
     * @return
     *     possible object is
     *     {@link CardholderPIN }
     *
     */
    public CardholderPIN getCardholderPIN() {
        return cardholderPIN;
    }

    /**
     * Sets the value of the cardholderPIN property.
     *
     * @param value
     *     allowed object is
     *     {@link CardholderPIN }
     *
     */
    public void setCardholderPIN(CardholderPIN value) {
        this.cardholderPIN = value;
    }

}
