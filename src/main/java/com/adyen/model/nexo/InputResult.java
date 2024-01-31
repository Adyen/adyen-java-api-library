package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Information related to the result the input. -- Usage: In the messageType response, it contains the result and the content of the input.
 *
 * <p>Java class for InputResult complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="InputResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *         &lt;element name="Input" type="{}Input" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Device" use="required" type="{}DeviceType" /&gt;
 *       &lt;attribute name="InfoQualify" use="required" type="{}InfoQualifyType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputResult", propOrder = {
        "response",
        "input"
})
public class InputResult {

    /**
     * The Response.
     */
    @XmlElement(name = "Response", required = true)
    @Schema(description = "Result of a message request processing.")
    protected Response response;
    /**
     * The Input.
     */
    @XmlElement(name = "Input")
    @Schema(description = "Data entered by the user, related to the input command. --Rule: If Response.Result is Success")
    protected Input input;
    /**
     * The Device.
     */
    @XmlElement(name = "Device", required = true)
    @Schema(description = "Logical device located on a Sale Terminal or a POI Terminal, in term of class of information to output (display, print --Rule: Copy")
    protected DeviceType device;
    /**
     * The Info qualify.
     */
    @XmlElement(name = "InfoQualify", required = true)
    @Schema(description = "Qualification of the information to sent to an output logical device, to display or print to the Cashier or the --Rule: Copy")
    protected InfoQualifyType infoQualify;

    /**
     * Gets the value of the response property.
     *
     * @return possible      object is     {@link Response }
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value allowed object is     {@link Response }
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the input property.
     *
     * @return possible      object is     {@link Input }
     */
    public Input getInput() {
        return input;
    }

    /**
     * Sets the value of the input property.
     *
     * @param value allowed object is     {@link Input }
     */
    public void setInput(Input value) {
        this.input = value;
    }

    /**
     * Gets the value of the device property.
     *
     * @return possible      object is     {@link DeviceType }
     */
    public DeviceType getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     *
     * @param value allowed object is     {@link DeviceType }
     */
    public void setDevice(DeviceType value) {
        this.device = value;
    }

    /**
     * Gets the value of the infoQualify property.
     *
     * @return possible      object is     {@link InfoQualifyType }
     */
    public InfoQualifyType getInfoQualify() {
        return infoQualify;
    }

    /**
     * Sets the value of the infoQualify property.
     *
     * @param value allowed object is     {@link InfoQualifyType }
     */
    public void setInfoQualify(InfoQualifyType value) {
        this.infoQualify = value;
    }

}
