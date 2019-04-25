
package com.adyen.model.nexo;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the PIN Request message. -- Usage: It contains the type of request related to the PIN, and the associated parameters.
 * 
 * <p>Java class for PINRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PINRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardholderPIN" type="{}CardholderPINType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PINRequestType" use="required" type="{}PINRequestTypeTypeCode" />
 *       &lt;attribute name="PINVerifMethod" type="{}PINVerifMethodType" />
 *       &lt;attribute name="AdditionalInput" type="{}AdditionalInputType" />
 *       &lt;attribute name="PINEncAlgorithm" type="{}PINEncAlgorithmType" />
 *       &lt;attribute name="PINFormat" type="{}PINFormatTypeCode" />
 *       &lt;attribute name="KeyReference" type="{}KeyReferenceType" />
 *       &lt;attribute name="MaxWaitingTime" type="{}MaxWaitingTimeType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PINRequestType", propOrder = {
    "cardholderPIN"
})
public class PINRequestType {

    @XmlElement(name = "CardholderPIN")
    protected CardholderPINType cardholderPIN;
    @XmlAttribute(name = "PINRequestType", required = true)
    protected String pinRequestType;
    @XmlAttribute(name = "PINVerifMethod")
    protected String pinVerifMethod;
    @XmlAttribute(name = "AdditionalInput")
    protected String additionalInput;
    @XmlAttribute(name = "PINEncAlgorithm")
    protected String pinEncAlgorithm;
    @XmlAttribute(name = "PINFormat")
    protected String pinFormat;
    @XmlAttribute(name = "KeyReference")
    protected String keyReference;
    @XmlAttribute(name = "MaxWaitingTime")
    protected BigInteger maxWaitingTime;

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

    /**
     * Gets the value of the pinRequestType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPINRequestType() {
        return pinRequestType;
    }

    /**
     * Sets the value of the pinRequestType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPINRequestType(String value) {
        this.pinRequestType = value;
    }

    /**
     * Gets the value of the pinVerifMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPINVerifMethod() {
        return pinVerifMethod;
    }

    /**
     * Sets the value of the pinVerifMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPINVerifMethod(String value) {
        this.pinVerifMethod = value;
    }

    /**
     * Gets the value of the additionalInput property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalInput() {
        return additionalInput;
    }

    /**
     * Sets the value of the additionalInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalInput(String value) {
        this.additionalInput = value;
    }

    /**
     * Gets the value of the pinEncAlgorithm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPINEncAlgorithm() {
        return pinEncAlgorithm;
    }

    /**
     * Sets the value of the pinEncAlgorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPINEncAlgorithm(String value) {
        this.pinEncAlgorithm = value;
    }

    /**
     * Gets the value of the pinFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPINFormat() {
        return pinFormat;
    }

    /**
     * Sets the value of the pinFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPINFormat(String value) {
        this.pinFormat = value;
    }

    /**
     * Gets the value of the keyReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyReference() {
        return keyReference;
    }

    /**
     * Sets the value of the keyReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyReference(String value) {
        this.keyReference = value;
    }

    /**
     * Gets the value of the maxWaitingTime property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxWaitingTime() {
        return maxWaitingTime;
    }

    /**
     * Sets the value of the maxWaitingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxWaitingTime(BigInteger value) {
        this.maxWaitingTime = value;
    }

}
