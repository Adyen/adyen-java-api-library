
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Information to display and the way to process the display. -- Usage: It contains a complete display operation for a Display or an Input Device type. For the Input Devices, Diagnosis and EnableService, ResponseRequiredFlag and MinimumDisplayTime shall be absent.
 * 
 * <p>Java class for DisplayOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DisplayOutputType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OutputContent" type="{}OutputContentType"/>
 *         &lt;element name="MenuEntry" type="{}MenuEntryType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OutputSignature" type="{}OutputSignatureType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ResponseRequiredFlag" type="{}ResponseRequiredFlagType" default="true" />
 *       &lt;attribute name="MinimumDisplayTime" type="{}MinimumDisplayTimeType" default="0" />
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
@XmlType(name = "DisplayOutputType", propOrder = {
    "outputContent",
    "menuEntry",
    "outputSignature"
})
public class DisplayOutputType {

    @XmlElement(name = "OutputContent", required = true)
    protected OutputContentType outputContent;
    @XmlElement(name = "MenuEntry")
    protected List<MenuEntryType> menuEntry;
    @XmlElement(name = "OutputSignature")
    protected byte[] outputSignature;
    @XmlAttribute(name = "ResponseRequiredFlag")
    protected Boolean responseRequiredFlag;
    @XmlAttribute(name = "MinimumDisplayTime")
    protected Integer minimumDisplayTime;
    @XmlAttribute(name = "Device", required = true)
    protected String device;
    @XmlAttribute(name = "InfoQualify", required = true)
    protected String infoQualify;

    /**
     * Gets the value of the outputContent property.
     * 
     * @return
     *     possible object is
     *     {@link OutputContentType }
     *     
     */
    public OutputContentType getOutputContent() {
        return outputContent;
    }

    /**
     * Sets the value of the outputContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputContentType }
     *     
     */
    public void setOutputContent(OutputContentType value) {
        this.outputContent = value;
    }

    /**
     * Gets the value of the menuEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the menuEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMenuEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MenuEntryType }
     * 
     * 
     */
    public List<MenuEntryType> getMenuEntry() {
        if (menuEntry == null) {
            menuEntry = new ArrayList<MenuEntryType>();
        }
        return this.menuEntry;
    }

    /**
     * Gets the value of the outputSignature property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getOutputSignature() {
        return outputSignature;
    }

    /**
     * Sets the value of the outputSignature property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setOutputSignature(byte[] value) {
        this.outputSignature = value;
    }

    /**
     * Gets the value of the responseRequiredFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
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
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setResponseRequiredFlag(Boolean value) {
        this.responseRequiredFlag = value;
    }

    /**
     * Gets the value of the minimumDisplayTime property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getMinimumDisplayTime() {
        if (minimumDisplayTime == null) {
            return  0;
        } else {
            return minimumDisplayTime;
        }
    }

    /**
     * Sets the value of the minimumDisplayTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinimumDisplayTime(Integer value) {
        this.minimumDisplayTime = value;
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
