
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Input Response message. -- Usage: It conveys:The result of the outputs, parallel to the message request, except if response not required and absent.The result of the input
 * 
 * <p>Java class for InputResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InputResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OutputResult" type="{}OutputResultType" minOccurs="0"/>
 *         &lt;element name="InputResult" type="{}InputResultType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputResponseType", propOrder = {
    "outputResult",
    "inputResult"
})
public class InputResponseType {

    @XmlElement(name = "OutputResult")
    protected OutputResultType outputResult;
    @XmlElement(name = "InputResult", required = true)
    protected InputResultType inputResult;

    /**
     * Gets the value of the outputResult property.
     * 
     * @return
     *     possible object is
     *     {@link OutputResultType }
     *     
     */
    public OutputResultType getOutputResult() {
        return outputResult;
    }

    /**
     * Sets the value of the outputResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputResultType }
     *     
     */
    public void setOutputResult(OutputResultType value) {
        this.outputResult = value;
    }

    /**
     * Gets the value of the inputResult property.
     * 
     * @return
     *     possible object is
     *     {@link InputResultType }
     *     
     */
    public InputResultType getInputResult() {
        return inputResult;
    }

    /**
     * Sets the value of the inputResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputResultType }
     *     
     */
    public void setInputResult(InputResultType value) {
        this.inputResult = value;
    }

}
