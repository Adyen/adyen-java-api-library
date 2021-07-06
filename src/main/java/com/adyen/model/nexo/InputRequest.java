package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Input Request messageType. -- Usage: It conveys data to display and the way to process the display, and contains the complete content to display. In addition to the display on the Input Device, it might contain an operation (the DisplayOutput element) per Display Device type.
 *
 * <p>Java class for InputRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="InputRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DisplayOutput" type="{}DisplayOutput" minOccurs="0"/&gt;
 *         &lt;element name="InputData" type="{}InputData"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputRequest", propOrder = {
        "displayOutput",
        "inputData"
})
public class InputRequest {

    /**
     * The Display output.
     */
    @XmlElement(name = "DisplayOutput")
    @Schema(description = "Information to display and the way to process the display. --Rule: Mandatory if the display device is managed by the receiver.")
    protected DisplayOutput displayOutput;
    /**
     * The Input data.
     */
    @XmlElement(name = "InputData", required = true)
    @Schema(description = "Information related to an Input request.")
    protected InputData inputData;

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
     * Gets the value of the inputData property.
     *
     * @return possible      object is     {@link InputData }
     */
    public InputData getInputData() {
        return inputData;
    }

    /**
     * Sets the value of the inputData property.
     *
     * @param value allowed object is     {@link InputData }
     */
    public void setInputData(InputData value) {
        this.inputData = value;
    }

}
