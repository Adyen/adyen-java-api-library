package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Information to display and the way to process the display. -- Usage: It contains a complete display operation for a Display or an Input Device type. For the Input Devices, Diagnosis and EnableService, ResponseRequiredFlag and MinimumDisplayTime shall be absent.
 *
 * <p>Java class for DisplayOutput complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DisplayOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OutputContent" type="{}OutputContent"/&gt;
 *         &lt;element name="MenuEntry" type="{}MenuEntry" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="OutputSignature" type="{}OutputSignature" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ResponseRequiredFlag" type="{}ResponseRequiredFlag" default="true" /&gt;
 *       &lt;attribute name="MinimumDisplayTime" type="{}MinimumDisplayTime" default="0" /&gt;
 *       &lt;attribute name="Device" use="required" type="{}DeviceType" /&gt;
 *       &lt;attribute name="InfoQualify" use="required" type="{}InfoQualifyType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DisplayOutput", propOrder = {
        "outputContent",
        "menuEntry",
        "outputSignature"
})
public class DisplayOutput {

    /**
     * The Output content.
     */
    @XmlElement(name = "OutputContent", required = true)
    @Schema(description = "Content to display or print.")
    protected OutputContent outputContent;
    /**
     * The Menu entry.
     */
    @XmlElement(name = "MenuEntry")
    @Schema(description = "An entryof the menu to present to the Cashier --Rule: One instance of MenuEntry per item to display in the menu for the get menu input command.")
    protected List<MenuEntry> menuEntry;
    /**
     * The Output signature.
     */
    @XmlElement(name = "OutputSignature")
    @Schema(description = "Vendor specific signature of text message to display or print. --Rule: If protection has to be provided to the vendor on the text to display or print.")
    protected byte[] outputSignature;
    /**
     * The Response required flag.
     */
    @XmlElement(name = "ResponseRequiredFlag")
    @Schema(description = "Request of a message response.")
    protected Boolean responseRequiredFlag;
    /**
     * The Minimum display time.
     */
    @XmlElement(name = "MinimumDisplayTime")
    @Schema(description = "Number of seconds the message has to be displayed")
    protected Integer minimumDisplayTime;
    /**
     * The Device.
     */
    @XmlElement(name = "Device", required = true)
    @Schema(description = "Logical device located on a Sale Terminal or a POI Terminal, in term of class of information to output (display, print --Rule: CashierDisplay, CustomerDisplay")
    protected DeviceType device;
    /**
     * The Info qualify.
     */
    @XmlElement(name = "InfoQualify", required = true)
    @Schema(description = "Qualification of the information to sent to an output logical device, to display or print to the Cashier or the --Rule: Status, Error, Display, POIReplication")
    protected InfoQualifyType infoQualify;

    /**
     * Gets the value of the outputContent property.
     *
     * @return possible      object is     {@link OutputContent }
     */
    public OutputContent getOutputContent() {
        return outputContent;
    }

    /**
     * Sets the value of the outputContent property.
     *
     * @param value allowed object is     {@link OutputContent }
     */
    public void setOutputContent(OutputContent value) {
        this.outputContent = value;
    }

    /**
     * Gets the value of the menuEntry property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the menuEntry property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMenuEntry().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MenuEntry }
     *
     * @return the menu entry
     */
    public List<MenuEntry> getMenuEntry() {
        if (menuEntry == null) {
            menuEntry = new ArrayList<>();
        }
        return this.menuEntry;
    }

    /**
     * Gets the value of the outputSignature property.
     *
     * @return possible      object is     byte[]
     */
    public byte[] getOutputSignature() {
        return outputSignature;
    }

    /**
     * Sets the value of the outputSignature property.
     *
     * @param value allowed object is     byte[]
     */
    public void setOutputSignature(byte[] value) {
        this.outputSignature = value;
    }

    /**
     * Gets the value of the responseRequiredFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public boolean isResponseRequiredFlag() {
        if (responseRequiredFlag == null) {
            return true;
        } else {
            return responseRequiredFlag;
        }
    }

    /**
     * Sets the value of the responseRequiredFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setResponseRequiredFlag(Boolean value) {
        this.responseRequiredFlag = value;
    }

    /**
     * Gets the value of the minimumDisplayTime property.
     *
     * @return possible      object is     {@link Integer }
     */
    public int getMinimumDisplayTime() {
        if (minimumDisplayTime == null) {
            return 0;
        } else {
            return minimumDisplayTime;
        }
    }

    /**
     * Sets the value of the minimumDisplayTime property.
     *
     * @param value allowed object is     {@link Integer }
     */
    public void setMinimumDisplayTime(Integer value) {
        this.minimumDisplayTime = value;
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
