
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content to display or print. -- Usage: This is a sequence of elements if they have different formats.
 *
 * <p>Java class for OutputContent complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OutputContent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PredefinedContent" type="{}PredefinedContent" minOccurs="0"/>
 *         &lt;element name="OutputText" type="{}OutputText" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OutputXHTML" type="{}OutputXHTML" minOccurs="0"/>
 *         &lt;element name="OutputBarcode" type="{}OutputBarcode" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="OutputFormat" use="required" type="{}OutputFormatType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputContent", propOrder = {
    "predefinedContent",
    "outputText",
    "outputXHTML",
    "outputBarcode"
})
public class OutputContent {

    @XmlElement(name = "PredefinedContent")
    protected PredefinedContent predefinedContent;
    @XmlElement(name = "OutputText")
    protected List<OutputText> outputText;
    @XmlElement(name = "OutputXHTML")
    protected byte[] outputXHTML;
    @XmlElement(name = "OutputBarcode")
    protected OutputBarcode outputBarcode;
    @XmlAttribute(name = "OutputFormat", required = true)
    protected OutputFormatType outputFormat;

    /**
     * Gets the value of the predefinedContent property.
     *
     * @return
     *     possible object is
     *     {@link PredefinedContent }
     *
     */
    public PredefinedContent getPredefinedContent() {
        return predefinedContent;
    }

    /**
     * Sets the value of the predefinedContent property.
     *
     * @param value
     *     allowed object is
     *     {@link PredefinedContent }
     *
     */
    public void setPredefinedContent(PredefinedContent value) {
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
     * {@link OutputText }
     *
     *
     */
    public List<OutputText> getOutputText() {
        if (outputText == null) {
            outputText = new ArrayList<OutputText>();
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
     * Gets the value of the outputBarcode property.
     *
     * @return
     *     possible object is
     *     {@link OutputBarcode }
     *
     */
    public OutputBarcode getOutputBarcode() {
        return outputBarcode;
    }

    /**
     * Sets the value of the outputBarcode property.
     *
     * @param value
     *     allowed object is
     *     {@link OutputBarcode }
     *
     */
    public void setOutputBarcode(OutputBarcode value) {
        this.outputBarcode = value;
    }

    /**
     * Gets the value of the outputFormat property.
     *
     * @return
     *     possible object is
     *     {@link OutputFormatType }
     *
     */
    public OutputFormatType getOutputFormat() {
        return outputFormat;
    }

    /**
     * Sets the value of the outputFormat property.
     *
     * @param value
     *     allowed object is
     *     {@link OutputFormatType }
     *
     */
    public void setOutputFormat(OutputFormatType value) {
        this.outputFormat = value;
    }

}
