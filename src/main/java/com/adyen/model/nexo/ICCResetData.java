package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data of a Chip Card related to the reset of the chip. -- Usage: Card reader device request
 *
 * <p>Java class for ICCResetData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ICCResetData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="ATRValue" type="{}ATRValue" /&gt;
 *       &lt;attribute name="CardStatusWords" type="{}CardStatusWords" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ICCResetData")
public class ICCResetData {

    /**
     * The Atr value.
     */
    @XmlAttribute(name = "ATRValue")
    protected byte[] atrValue;
    /**
     * The Card status words.
     */
    @XmlAttribute(name = "CardStatusWords")
    protected byte[] cardStatusWords;

    /**
     * Gets the value of the atrValue property.
     *
     * @return possible      object is     byte[]
     */
    public byte[] getATRValue() {
        return atrValue;
    }

    /**
     * Sets the value of the atrValue property.
     *
     * @param value allowed object is     byte[]
     */
    public void setATRValue(byte[] value) {
        this.atrValue = value;
    }

    /**
     * Gets the value of the cardStatusWords property.
     *
     * @return possible      object is     byte[]
     */
    public byte[] getCardStatusWords() {
        return cardStatusWords;
    }

    /**
     * Sets the value of the cardStatusWords property.
     *
     * @param value allowed object is     byte[]
     */
    public void setCardStatusWords(byte[] value) {
        this.cardStatusWords = value;
    }

}
