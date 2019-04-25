
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data of a Chip Card related to the reset of the chip. -- Usage: Card reader device request
 * 
 * <p>Java class for ICCResetDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ICCResetDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="ATRValue" type="{}ATRValueType" />
 *       &lt;attribute name="CardStatusWords" type="{}CardStatusWordsType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ICCResetDataType")
public class ICCResetDataType {

    @XmlAttribute(name = "ATRValue")
    protected byte[] atrValue;
    @XmlAttribute(name = "CardStatusWords")
    protected byte[] cardStatusWords;

    /**
     * Gets the value of the atrValue property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getATRValue() {
        return atrValue;
    }

    /**
     * Sets the value of the atrValue property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setATRValue(byte[] value) {
        this.atrValue = value;
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
