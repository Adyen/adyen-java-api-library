package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: An entryof the menu to present to the Cashier -- Usage: It conveys messageType text and parameters of the menu entry. This output data could be only provided for an input command, in order to choose an entryof the menu.
 *
 * <p>Java class for MenuEntry complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MenuEntry"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PredefinedContent" type="{}PredefinedContent" minOccurs="0"/&gt;
 *         &lt;element name="OutputText" type="{}OutputText" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="OutputXHTML" type="{}OutputXHTML" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="MenuEntryTag" type="{}MenuEntryTagType" default="Selectable" /&gt;
 *       &lt;attribute name="OutputFormat" use="required" type="{}OutputFormatType" /&gt;
 *       &lt;attribute name="DefaultSelectedFlag" type="{}DefaultSelectedFlag" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MenuEntry", propOrder = {
        "predefinedContent",
        "outputText",
        "outputXHTML"
})
public class MenuEntry {

    /**
     * The Predefined content.
     */
    @XmlElement(name = "PredefinedContent")
    @Schema(description = "Reference of a predefined message to display or print. --Rule: Mandatory, if OutputFormat is MessageRef, not allowed otherwise.")
    protected PredefinedContent predefinedContent;
    /**
     * The Output text.
     */
    @XmlElement(name = "OutputText")
    @Schema(description = "Content of text message to display or print. --Rule: Mandatory, if OutputFormat is Text, not allowed otherwise. One instance of OutputText per shared format")
    protected List<OutputText> outputText;
    /**
     * The Output xhtml.
     */
    @XmlElement(name = "OutputXHTML")
    @Schema(description = "XHTML document body containing the message to display or print. --Rule: Mandatory, if OutputFormat is XHTML, not allowed otherwise.")
    protected byte[] outputXHTML;
    /**
     * The Menu entry tag.
     */
    @XmlElement(name = "MenuEntryTag")
    @Schema(description = "Characteristics related to the selection of a menu entry")
    protected MenuEntryTagType menuEntryTag;
    /**
     * The Output format.
     */
    @XmlElement(name = "OutputFormat", required = true)
    @Schema(description = "Format of the content to display or print --Rule: MessageRef, Text, XHTML")
    protected OutputFormatType outputFormat;
    /**
     * The Default selected flag.
     */
    @XmlElement(name = "DefaultSelectedFlag")
    @Schema(description = "Selection of a menu entry to be displayed.")
    protected Boolean defaultSelectedFlag;

    /**
     * Gets the value of the predefinedContent property.
     *
     * @return possible      object is     {@link PredefinedContent }
     */
    public PredefinedContent getPredefinedContent() {
        return predefinedContent;
    }

    /**
     * Sets the value of the predefinedContent property.
     *
     * @param value allowed object is     {@link PredefinedContent }
     */
    public void setPredefinedContent(PredefinedContent value) {
        this.predefinedContent = value;
    }

    /**
     * Gets the value of the outputText property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputText property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutputText().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OutputText }
     *
     * @return the output text
     */
    public List<OutputText> getOutputText() {
        if (outputText == null) {
            outputText = new ArrayList<>();
        }
        return this.outputText;
    }

    /**
     * Sets the value of the outputText property.
     *
     * @param outputText the new list of OutputText objects
     */

    public void setOutputText(List<OutputText> outputText) {
        this.outputText = outputText;
    }

    /**
     * Gets the value of the outputXHTML property.
     *
     * @return possible      object is     byte[]
     */
    public byte[] getOutputXHTML() {
        return outputXHTML;
    }

    /**
     * Sets the value of the outputXHTML property.
     *
     * @param value allowed object is     byte[]
     */
    public void setOutputXHTML(byte[] value) {
        this.outputXHTML = value;
    }

    /**
     * Gets the value of the menuEntryTag property.
     *
     * @return possible      object is     {@link MenuEntryTagType }
     */
    public MenuEntryTagType getMenuEntryTag() {
        if (menuEntryTag == null) {
            return MenuEntryTagType.SELECTABLE;
        } else {
            return menuEntryTag;
        }
    }

    /**
     * Sets the value of the menuEntryTag property.
     *
     * @param value allowed object is     {@link MenuEntryTagType }
     */
    public void setMenuEntryTag(MenuEntryTagType value) {
        this.menuEntryTag = value;
    }

    /**
     * Gets the value of the outputFormat property.
     *
     * @return possible      object is     {@link OutputFormatType }
     */
    public OutputFormatType getOutputFormat() {
        return outputFormat;
    }

    /**
     * Sets the value of the outputFormat property.
     *
     * @param value allowed object is     {@link OutputFormatType }
     */
    public void setOutputFormat(OutputFormatType value) {
        this.outputFormat = value;
    }

    /**
     * Gets the value of the defaultSelectedFlag property.
     *
     * @return possible      object is     {@link Boolean }
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
     * @param value allowed object is     {@link Boolean }
     */
    public void setDefaultSelectedFlag(Boolean value) {
        this.defaultSelectedFlag = value;
    }

}
