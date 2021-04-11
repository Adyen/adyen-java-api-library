package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Input Response messageType. -- Usage: It conveys:The result of the outputs, parallel to the messageType request, except if response not required and absent.The result of the input
 *
 * <p>Java class for InputResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="InputResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OutputResult" type="{}OutputResult" minOccurs="0"/&gt;
 *         &lt;element name="InputResult" type="{}InputResult"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputResponse", propOrder = {
        "outputResult",
        "inputResult"
})
public class InputResponse {

    /**
     * The Output result.
     */
    @XmlElement(name = "OutputResult")
    @Schema(description = "Information related to the result the output (display, print, input). --Rule: If DisplayOutput present in the request.")
    protected OutputResult outputResult;
    /**
     * The Input result.
     */
    @XmlElement(name = "InputResult", required = true)
    @Schema(description = "Information related to the result the input.")
    protected InputResult inputResult;

    /**
     * Gets the value of the outputResult property.
     *
     * @return possible      object is     {@link OutputResult }
     */
    public OutputResult getOutputResult() {
        return outputResult;
    }

    /**
     * Sets the value of the outputResult property.
     *
     * @param value allowed object is     {@link OutputResult }
     */
    public void setOutputResult(OutputResult value) {
        this.outputResult = value;
    }

    /**
     * Gets the value of the inputResult property.
     *
     * @return possible      object is     {@link InputResult }
     */
    public InputResult getInputResult() {
        return inputResult;
    }

    /**
     * Sets the value of the inputResult property.
     *
     * @param value allowed object is     {@link InputResult }
     */
    public void setInputResult(InputResult value) {
        this.inputResult = value;
    }

}
