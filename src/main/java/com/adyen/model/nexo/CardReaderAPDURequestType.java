
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Card Reader APDU Request message. -- Usage: It contains the APDU request to send to the chip of the card, and a possible invitation message to display on the CashierInterface or the CustomerInterface.
 * 
 * <p>Java class for CardReaderAPDURequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardReaderAPDURequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="APDUData" type="{}APDUDataType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="APDUClass" use="required" type="{}APDUClassType" />
 *       &lt;attribute name="APDUInstruction" use="required" type="{}APDUInstructionType" />
 *       &lt;attribute name="APDUPar1" use="required" type="{}APDUPar1Type" />
 *       &lt;attribute name="APDUPar2" use="required" type="{}APDUPar2Type" />
 *       &lt;attribute name="APDUExpectedLength" type="{}APDUExpectedLengthType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardReaderAPDURequestType", propOrder = {
    "apduData"
})
public class CardReaderAPDURequestType {

    @XmlElement(name = "APDUData")
    protected byte[] apduData;
    @XmlAttribute(name = "APDUClass", required = true)
    protected byte[] apduClass;
    @XmlAttribute(name = "APDUInstruction", required = true)
    protected byte[] apduInstruction;
    @XmlAttribute(name = "APDUPar1", required = true)
    protected byte[] apduPar1;
    @XmlAttribute(name = "APDUPar2", required = true)
    protected byte[] apduPar2;
    @XmlAttribute(name = "APDUExpectedLength")
    protected byte[] apduExpectedLength;

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
     * Gets the value of the apduClass property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAPDUClass() {
        return apduClass;
    }

    /**
     * Sets the value of the apduClass property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAPDUClass(byte[] value) {
        this.apduClass = value;
    }

    /**
     * Gets the value of the apduInstruction property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAPDUInstruction() {
        return apduInstruction;
    }

    /**
     * Sets the value of the apduInstruction property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAPDUInstruction(byte[] value) {
        this.apduInstruction = value;
    }

    /**
     * Gets the value of the apduPar1 property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAPDUPar1() {
        return apduPar1;
    }

    /**
     * Sets the value of the apduPar1 property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAPDUPar1(byte[] value) {
        this.apduPar1 = value;
    }

    /**
     * Gets the value of the apduPar2 property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAPDUPar2() {
        return apduPar2;
    }

    /**
     * Sets the value of the apduPar2 property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAPDUPar2(byte[] value) {
        this.apduPar2 = value;
    }

    /**
     * Gets the value of the apduExpectedLength property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAPDUExpectedLength() {
        return apduExpectedLength;
    }

    /**
     * Sets the value of the apduExpectedLength property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAPDUExpectedLength(byte[] value) {
        this.apduExpectedLength = value;
    }

}
