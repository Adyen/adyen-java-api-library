package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Encrypted PIN and related information -- Usage: To request PIN Verify to the POI, or to get the encrypted PIN block.
 *
 * <p>Java class for CardholderPIN complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CardholderPIN"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EncrPINBlock" type="{}ContentInformation"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="PINFormat" use="required" type="{}PINFormatType" /&gt;
 *       &lt;attribute name="AdditionalInput" type="{}AdditionalInput" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardholderPIN", propOrder = {
        "encrPINBlock"
})
public class CardholderPIN {

    /**
     * The Encr pin block.
     */
    @XmlElement(name = "EncrPINBlock", required = true)
    @Schema(description = "Encrypted PIN")
    protected ContentInformation encrPINBlock;
    /**
     * The Pin format.
     */
    @XmlElement(name = "PINFormat", required = true)
    @Schema(description = "Identify the format of the PIN before encryption.")
    protected PINFormatType pinFormat;
    /**
     * The Additional input.
     */
    @XmlElement(name = "AdditionalInput")
    @Schema(description = "Additional information required to verify the PIN like part of the PAN, or driver ID.")
    protected String additionalInput;

    /**
     * Gets the value of the encrPINBlock property.
     *
     * @return possible      object is     {@link ContentInformation }
     */
    public ContentInformation getEncrPINBlock() {
        return encrPINBlock;
    }

    /**
     * Sets the value of the encrPINBlock property.
     *
     * @param value allowed object is     {@link ContentInformation }
     */
    public void setEncrPINBlock(ContentInformation value) {
        this.encrPINBlock = value;
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

}
