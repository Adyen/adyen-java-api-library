package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * Definition: Content of the Card Reader Power-Off Request messageType. -- Usage: It contains a possible invitation messageType to display on the CashierInterface or the CustomerInterface, for removing the card.
 *
 * <p>Java class for CardReaderPowerOffRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CardReaderPowerOffRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DisplayOutput" type="{}DisplayOutput" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="MaxWaitingTime" type="{}MaxWaitingTime" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardReaderPowerOffRequest", propOrder = {
        "displayOutput"
})
public class CardReaderPowerOffRequest {

    /**
     * The Display output.
     */
    @XmlElement(name = "DisplayOutput")
    protected DisplayOutput displayOutput;
    /**
     * The Max waiting time.
     */
    @XmlAttribute(name = "MaxWaitingTime")
    protected BigInteger maxWaitingTime;

    /**
     * Gets the value of the displayOutput property.
     *
     * @return possible      object is     {@link DisplayOutput }
     */
    public DisplayOutput getDisplayOutput() {
        return displayOutput;
    }

    /**
     * Sets the value of the displayOutput property.
     *
     * @param value allowed object is     {@link DisplayOutput }
     */
    public void setDisplayOutput(DisplayOutput value) {
        this.displayOutput = value;
    }

    /**
     * Gets the value of the maxWaitingTime property.
     *
     * @return possible      object is     {@link BigInteger }
     */
    public BigInteger getMaxWaitingTime() {
        return maxWaitingTime;
    }

    /**
     * Sets the value of the maxWaitingTime property.
     *
     * @param value allowed object is     {@link BigInteger }
     */
    public void setMaxWaitingTime(BigInteger value) {
        this.maxWaitingTime = value;
    }

}
