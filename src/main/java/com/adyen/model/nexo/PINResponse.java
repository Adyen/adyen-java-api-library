package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the PIN Response messageType. -- Usage: It contains the result of the requested service, with possibly the encrypted PIN.
 *
 * <p>Java class for PINResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PINResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *         &lt;element name="CardholderPIN" type="{}CardholderPIN" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PINResponse", propOrder = {
        "response",
        "cardholderPIN"
})
public class PINResponse {

    /**
     * The Response.
     */
    @XmlElement(name = "Response", required = true)
    @Schema(description = "Result of a message request processing.")
    protected Response response;
    /**
     * The Cardholder pin.
     */
    @XmlElement(name = "CardholderPIN")
    @Schema(description = "Encrypted PIN and related information")
    protected CardholderPIN cardholderPIN;

    /**
     * Gets the value of the response property.
     *
     * @return possible      object is     {@link Response }
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value allowed object is     {@link Response }
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the cardholderPIN property.
     *
     * @return possible      object is     {@link CardholderPIN }
     */
    public CardholderPIN getCardholderPIN() {
        return cardholderPIN;
    }

    /**
     * Sets the value of the cardholderPIN property.
     *
     * @param value allowed object is     {@link CardholderPIN }
     */
    public void setCardholderPIN(CardholderPIN value) {
        this.cardholderPIN = value;
    }

}
