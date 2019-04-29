
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Result of a messageType request processing. -- Usage: If Result is Success, ErrorCondition is absent or not used in the processing of the messageType. In the other cases, the ErrorCondition has to be present and can refine the processing of the messageType response. AdditionalResponse gives more
 *
 * <p>Java class for Response complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AdditionalResponse" type="{}AdditionalResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Result" use="required" type="{}ResultType" />
 *       &lt;attribute name="ErrorCondition" type="{}ErrorConditionType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Response", propOrder = {
    "additionalResponse"
})
public class Response {

    @XmlElement(name = "AdditionalResponse")
    protected String additionalResponse;
    @XmlAttribute(name = "Result", required = true)
    protected ResultType result;
    @XmlAttribute(name = "ErrorCondition")
    protected ErrorConditionType errorCondition;

    /**
     * Gets the value of the additionalResponse property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAdditionalResponse() {
        return additionalResponse;
    }

    /**
     * Sets the value of the additionalResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAdditionalResponse(String value) {
        this.additionalResponse = value;
    }

    /**
     * Gets the value of the result property.
     *
     * @return
     *     possible object is
     *     {@link ResultType }
     *
     */
    public ResultType getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     *
     * @param value
     *     allowed object is
     *     {@link ResultType }
     *
     */
    public void setResult(ResultType value) {
        this.result = value;
    }

    /**
     * Gets the value of the errorCondition property.
     *
     * @return
     *     possible object is
     *     {@link ErrorConditionType }
     *
     */
    public ErrorConditionType getErrorCondition() {
        return errorCondition;
    }

    /**
     * Sets the value of the errorCondition property.
     *
     * @param value
     *     allowed object is
     *     {@link ErrorConditionType }
     *
     */
    public void setErrorCondition(ErrorConditionType value) {
        this.errorCondition = value;
    }

}
