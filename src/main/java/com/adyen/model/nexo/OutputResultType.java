
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Information related to the result the output (display, print, input). -- Usage: In the message response, it contains the result of the output, if required in the message request.
 * 
 * <p>Java class for OutputResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OutputResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}ResponseType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Device" use="required" type="{}DeviceTypeCode" />
 *       &lt;attribute name="InfoQualify" use="required" type="{}InfoQualifyTypeCode" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputResultType", propOrder = {
    "response"
})
public class OutputResultType {

    @XmlElement(name = "Response", required = true)
    protected ResponseType response;
    @XmlAttribute(name = "Device", required = true)
    protected String device;
    @XmlAttribute(name = "InfoQualify", required = true)
    protected String infoQualify;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseType }
     *     
     */
    public ResponseType getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseType }
     *     
     */
    public void setResponse(ResponseType value) {
        this.response = value;
    }

    /**
     * Gets the value of the device property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevice(String value) {
        this.device = value;
    }

    /**
     * Gets the value of the infoQualify property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoQualify() {
        return infoQualify;
    }

    /**
     * Sets the value of the infoQualify property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoQualify(String value) {
        this.infoQualify = value;
    }

}
