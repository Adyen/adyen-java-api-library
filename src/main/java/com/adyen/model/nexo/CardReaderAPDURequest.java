package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Card Reader APDU Request messageType. -- Usage: It contains the APDU request to send to the chip of the card, and a possible invitation messageType to display on the CashierInterface or the CustomerInterface.
 *
 * <p>Java class for CardReaderAPDURequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CardReaderAPDURequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="APDUData" type="{}APDUData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="APDUClass" use="required" type="{}APDUClass" /&gt;
 *       &lt;attribute name="APDUInstruction" use="required" type="{}APDUInstruction" /&gt;
 *       &lt;attribute name="APDUPar1" use="required" type="{}APDUPar1" /&gt;
 *       &lt;attribute name="APDUPar2" use="required" type="{}APDUPar2" /&gt;
 *       &lt;attribute name="APDUExpectedLength" type="{}APDUExpectedLength" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardReaderAPDURequest", propOrder = {
        "apduData"
})
public class CardReaderAPDURequest {

    /**
     * The Apdu data.
     */
    @XmlElement(name = "APDUData")
    @Schema(description = "Data field of the APDU command (Lc + Data)")
    protected byte[] apduData;
    /**
     * The Apdu class.
     */
    @XmlElement(name = "APDUClass", required = true)
    @Schema(description = "Class field of the APDU command (CLA)", minLength = 1, maxLength = 1)
    protected byte[] apduClass;
    /**
     * The Apdu instruction.
     */
    @XmlElement(name = "APDUInstruction", required = true)
    @Schema(description = "Instruction field of the APDU command (INS)", minLength = 1, maxLength = 1)
    protected byte[] apduInstruction;
    /**
     * The Apdu par 1.
     */
    @XmlElement(name = "APDUPar1", required = true)
    @Schema(description = "Parameter 1 field of the APDU command (P1)", minLength = 1, maxLength = 1)
    protected byte[] apduPar1;
    /**
     * The Apdu par 2.
     */
    @XmlElement(name = "APDUPar2", required = true)
    @Schema(description = "Parameter 2 field of the APDU command(P2)", minLength = 1, maxLength = 1)
    protected byte[] apduPar2;
    /**
     * The Apdu expected length.
     */
    @XmlElement(name = "APDUExpectedLength")
    @Schema(description = "Expected length of the data field of the APDU response to the command (Le)", minLength = 1, maxLength = 1)
    protected byte[] apduExpectedLength;

    /**
     * Gets the value of the apduData property.
     *
     * @return possible      object is     byte[]
     */
    public byte[] getAPDUData() {
        return apduData;
    }

    /**
     * Sets the value of the apduData property.
     *
     * @param value allowed object is     byte[]
     */
    public void setAPDUData(byte[] value) {
        this.apduData = value;
    }

    /**
     * Gets the value of the apduClass property.
     *
     * @return possible      object is     byte[]
     */
    public byte[] getAPDUClass() {
        return apduClass;
    }

    /**
     * Sets the value of the apduClass property.
     *
     * @param value allowed object is     byte[]
     */
    public void setAPDUClass(byte[] value) {
        this.apduClass = value;
    }

    /**
     * Gets the value of the apduInstruction property.
     *
     * @return possible      object is     byte[]
     */
    public byte[] getAPDUInstruction() {
        return apduInstruction;
    }

    /**
     * Sets the value of the apduInstruction property.
     *
     * @param value allowed object is     byte[]
     */
    public void setAPDUInstruction(byte[] value) {
        this.apduInstruction = value;
    }

    /**
     * Gets the value of the apduPar1 property.
     *
     * @return possible      object is     byte[]
     */
    public byte[] getAPDUPar1() {
        return apduPar1;
    }

    /**
     * Sets the value of the apduPar1 property.
     *
     * @param value allowed object is     byte[]
     */
    public void setAPDUPar1(byte[] value) {
        this.apduPar1 = value;
    }

    /**
     * Gets the value of the apduPar2 property.
     *
     * @return possible      object is     byte[]
     */
    public byte[] getAPDUPar2() {
        return apduPar2;
    }

    /**
     * Sets the value of the apduPar2 property.
     *
     * @param value allowed object is     byte[]
     */
    public void setAPDUPar2(byte[] value) {
        this.apduPar2 = value;
    }

    /**
     * Gets the value of the apduExpectedLength property.
     *
     * @return possible      object is     byte[]
     */
    public byte[] getAPDUExpectedLength() {
        return apduExpectedLength;
    }

    /**
     * Sets the value of the apduExpectedLength property.
     *
     * @param value allowed object is     byte[]
     */
    public void setAPDUExpectedLength(byte[] value) {
        this.apduExpectedLength = value;
    }

}
