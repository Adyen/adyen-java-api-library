package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * Definition: Content of the PIN Request messageType. -- Usage: It contains the type of request related to the PIN, and the associated parameters.
 *
 * <p>Java class for PINRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PINRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CardholderPIN" type="{}CardholderPIN" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="PINRequest" use="required" type="{}PINRequestType" /&gt;
 *       &lt;attribute name="PINVerifMethod" type="{}PINVerifMethod" /&gt;
 *       &lt;attribute name="AdditionalInput" type="{}AdditionalInput" /&gt;
 *       &lt;attribute name="PINEncAlgorithm" type="{}PINEncAlgorithm" /&gt;
 *       &lt;attribute name="PINFormat" type="{}PINFormatType" /&gt;
 *       &lt;attribute name="KeyReference" type="{}KeyReference" /&gt;
 *       &lt;attribute name="MaxWaitingTime" type="{}MaxWaitingTime" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PINRequest", propOrder = {
        "cardholderPIN"
})
public class PINRequest {

    /**
     * The Cardholder pin.
     */
    @XmlElement(name = "CardholderPIN")
    @Schema(description = "Encrypted PIN and related information --Rule: PINRequestTypeConformed to EPAS Acquirer protocol.")
    protected CardholderPIN cardholderPIN;
    /**
     * The Pin request.
     */
    @XmlElement(name = "PINRequestType", required = true)
    @Schema(description = "Type of PIN Service.")
    protected PINRequestType pinRequestType;
    /**
     * The Pin verif method.
     */
    @XmlElement(name = "PINVerifMethod")
    @Schema(description = "Identify the PIN verification method and keys. --Rule: PINRequestType")
    protected String pinVerifMethod;
    /**
     * The Additional input.
     */
    @XmlElement(name = "AdditionalInput")
    @Schema(description = "Additional information required to verify the PIN like part of the PAN, or driver ID. --Rule: PINRequestType")
    protected String additionalInput;
    /**
     * The Pin enc algorithm.
     */
    @XmlElement(name = "PINEncAlgorithm")
    @Schema(description = "Identify the encrypted PIN block algorithm. --Rule: PINRequestType")
    protected String pinEncAlgorithm;
    /**
     * The Pin format.
     */
    @XmlElement(name = "PINFormat")
    @Schema(description = "Identify the format of the PIN before encryption. --Rule: PINRequestType")
    protected PINFormatType pinFormat;
    /**
     * The Key reference.
     */
    @XmlElement(name = "KeyReference")
    @Schema(description = "Identify the key to use to encrypt the PIN block. --Rule: PINRequestType")
    protected String keyReference;
    /**
     * The Max waiting time.
     */
    @XmlElement(name = "MaxWaitingTime")
    @Schema(description = "Maximum time to wait for the request processing in seconds. --Rule: PINRequestTypePINRequestType")
    protected BigInteger maxWaitingTime;

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

    /**
     * Gets the value of the pinRequestType property.
     *
     * @return possible      object is     {@link PINRequestType }
     */
    public PINRequestType getPINRequestType() {
        return pinRequestType;
    }

    /**
     * Sets the value of the pinRequestType property.
     *
     * @param value allowed object is     {@link PINRequestType }
     */
    public void setPINRequestType(PINRequestType value) {
        this.pinRequestType = value;
    }

    /**
     * Gets the value of the pinVerifMethod property.
     *
     * @return possible      object is     {@link String }
     */
    public String getPINVerifMethod() {
        return pinVerifMethod;
    }

    /**
     * Sets the value of the pinVerifMethod property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setPINVerifMethod(String value) {
        this.pinVerifMethod = value;
    }

    /**
     * Gets the value of the additionalInput property.
     *
     * @return possible      object is     {@link String }
     */
    public String getAdditionalInput() {
        return additionalInput;
    }

    /**
     * Sets the value of the additionalInput property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setAdditionalInput(String value) {
        this.additionalInput = value;
    }

    /**
     * Gets the value of the pinEncAlgorithm property.
     *
     * @return possible      object is     {@link String }
     */
    public String getPINEncAlgorithm() {
        return pinEncAlgorithm;
    }

    /**
     * Sets the value of the pinEncAlgorithm property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setPINEncAlgorithm(String value) {
        this.pinEncAlgorithm = value;
    }

    /**
     * Gets the value of the pinFormat property.
     *
     * @return possible      object is     {@link PINFormatType }
     */
    public PINFormatType getPINFormat() {
        return pinFormat;
    }

    /**
     * Sets the value of the pinFormat property.
     *
     * @param value allowed object is     {@link PINFormatType }
     */
    public void setPINFormat(PINFormatType value) {
        this.pinFormat = value;
    }

    /**
     * Gets the value of the keyReference property.
     *
     * @return possible      object is     {@link String }
     */
    public String getKeyReference() {
        return keyReference;
    }

    /**
     * Sets the value of the keyReference property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setKeyReference(String value) {
        this.keyReference = value;
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
