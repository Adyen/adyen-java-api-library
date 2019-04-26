
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Card Reader APDU Response message. -- Usage: It contains the result of the requested service, APDU response sent by the chip of the card in response to the APDU request.
 *
 * <p>Java class for CardReaderAPDUResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CardReaderAPDUResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}Response"/>
 *         &lt;element name="APDUData" type="{}APDUData" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CardStatusWords" use="required" type="{}CardStatusWords" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardReaderAPDUResponse", propOrder = {
    "response",
    "apduData"
})
public class CardReaderAPDUResponse {

    @XmlElement(name = "Response", required = true)
    protected Response response;
    @XmlElement(name = "APDUData")
    protected byte[] apduData;
    @XmlAttribute(name = "CardStatusWords", required = true)
    protected byte[] cardStatusWords;

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
     * Gets the value of the apduData property.
     *
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAPDUData() {
        return apduData;
    }

    /**
     * Sets the value of the apduData property.
     *
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAPDUData(byte[] value) {
        this.apduData = value;
    }

    /**
     * Gets the value of the cardStatusWords property.
     *
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getCardStatusWords() {
        return cardStatusWords;
    }

    /**
     * Sets the value of the cardStatusWords property.
     *
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setCardStatusWords(byte[] value) {
        this.cardStatusWords = value;
    }

}
