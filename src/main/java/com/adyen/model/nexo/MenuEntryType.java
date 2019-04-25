
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: An entryof the menu to present to the Cashier -- Usage: It conveys message text and parameters of the menu entry. This output data could be only provided for an input command, in order to choose an entryof the menu.
 * 
 * <p>Java class for MenuEntryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MenuEntryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PredefinedContent" type="{}PredefinedContentType" minOccurs="0"/>
 *         &lt;element name="OutputText" type="{}OutputTextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OutputXHTML" type="{}OutputXHTMLType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="MenuEntryTag" type="{}MenuEntryTagTypeCode" default="Selectable" />
 *       &lt;attribute name="OutputFormat" use="required" type="{}OutputFormatTypeCode" />
 *       &lt;attribute name="DefaultSelectedFlag" type="{}DefaultSelectedFlagType" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MenuEntryType", propOrder = {
    "predefinedContent",
    "outputText",
    "outputXHTML"
})
public class MenuEntryType {

    @XmlElement(name = "PredefinedContent")
    protected PredefinedContentType predefinedContent;
    @XmlElement(name = "OutputText")
    protected List<OutputTextType> outputText;
    @XmlElement(name = "OutputXHTML")
    protected byte[] outputXHTML;
    @XmlAttribute(name = "MenuEntryTag")
    protected String menuEntryTag;
    @XmlAttribute(name = "OutputFormat", required = true)
    protected String outputFormat;
    @XmlAttribute(name = "DefaultSelectedFlag")
    protected Boolean defaultSelectedFlag;

    /**
     * Gets the value of the predefinedContent property.
     * 
     * @return
     *     possible object is
     *     {@link PredefinedContentType }
     *     
     */
    public PredefinedContentType getPredefinedContent() {
        return predefinedContent;
    }

    /**
     * Sets the value of the predefinedContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link PredefinedContentType }
     *     
     */
    public void setPredefinedContent(PredefinedContentType value) {
        this.predefinedContent = value;
    }

    /**
     * Gets the value of the outputText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutputText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OutputTextType }
     * 
     * 
     */
    public List<OutputTextType> getOutputText() {
        if (outputText == null) {
            outputText = new ArrayList<OutputTextType>();
        }
        return this.outputText;
    }

    /**
     * Gets the value of the outputXHTML property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getOutputXHTML() {
        return outputXHTML;
    }

    /**
     * Sets the value of the outputXHTML property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setOutputXHTML(byte[] value) {
        this.outputXHTML = value;
    }

    /**
     * Gets the value of the menuEntryTag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMenuEntryTag() {
        if (menuEntryTag == null) {
            return "Selectable";
        } else {
            return menuEntryTag;
        }
    }

    /**
     * Sets the value of the menuEntryTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMenuEntryTag(String value) {
        this.menuEntryTag = value;
    }

    /**
     * Gets the value of the outputFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputFormat() {
        return outputFormat;
    }

    /**
     * Sets the value of the outputFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputFormat(String value) {
        this.outputFormat = value;
    }

    /**
     * Gets the value of the defaultSelectedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDefaultSelectedFlag() {
        if (defaultSelectedFlag == null) {
            return false;
        } else {
            return defaultSelectedFlag;
        }
    }

    /**
     * Sets the value of the defaultSelectedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDefaultSelectedFlag(Boolean value) {
        this.defaultSelectedFlag = value;
    }

}
