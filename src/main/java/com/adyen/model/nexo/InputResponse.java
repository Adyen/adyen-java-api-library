
package com.adyen.model.nexo;

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
 * &lt;complexType name="InputResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OutputResult" type="{}OutputResult" minOccurs="0"/>
 *         &lt;element name="InputResult" type="{}InputResult"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputResponse", propOrder = {
    "outputResult",
    "inputResult"
})
public class InputResponse {

    @XmlElement(name = "OutputResult")
    protected OutputResult outputResult;
    @XmlElement(name = "InputResult", required = true)
    protected InputResult inputResult;

    /**
     * Gets the value of the outputResult property.
     *
     * @return
     *     possible object is
     *     {@link OutputResult }
     *
     */
    public OutputResult getOutputResult() {
        return outputResult;
    }

    /**
     * Sets the value of the outputResult property.
     *
     * @param value
     *     allowed object is
     *     {@link OutputResult }
     *
     */
    public void setOutputResult(OutputResult value) {
        this.outputResult = value;
    }

    /**
     * Gets the value of the inputResult property.
     *
     * @return
     *     possible object is
     *     {@link InputResult }
     *
     */
    public InputResult getInputResult() {
        return inputResult;
    }

    /**
     * Sets the value of the inputResult property.
     *
     * @param value
     *     allowed object is
     *     {@link InputResult }
     *
     */
    public void setInputResult(InputResult value) {
        this.inputResult = value;
    }

}
