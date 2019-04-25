
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Encrypted PIN and related information -- Usage: To request PIN Verify to the POI, or to get the encrypted PIN block.
 * 
 * <p>Java class for CardholderPINType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardholderPINType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EncrPINBlock" type="{}ContentInformationType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PINFormat" use="required" type="{}PINFormatTypeCode" />
 *       &lt;attribute name="AdditionalInput" type="{}AdditionalInputType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardholderPINType", propOrder = {
    "encrPINBlock"
})
public class CardholderPINType {

    @XmlElement(name = "EncrPINBlock", required = true)
    protected ContentInformationType encrPINBlock;
    @XmlAttribute(name = "PINFormat", required = true)
    protected String pinFormat;
    @XmlAttribute(name = "AdditionalInput")
    protected String additionalInput;

    /**
     * Gets the value of the encrPINBlock property.
     * 
     * @return
     *     possible object is
     *     {@link ContentInformationType }
     *     
     */
    public ContentInformationType getEncrPINBlock() {
        return encrPINBlock;
    }

    /**
     * Sets the value of the encrPINBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentInformationType }
     *     
     */
    public void setEncrPINBlock(ContentInformationType value) {
        this.encrPINBlock = value;
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

}
