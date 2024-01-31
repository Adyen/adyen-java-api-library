package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content to display or print. -- Usage: This is a sequence of elements if they have different formats.
 *
 * <p>Java class for OutputContent complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OutputContent"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PredefinedContent" type="{}PredefinedContent" minOccurs="0"/&gt;
 *         &lt;element name="OutputText" type="{}OutputText" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="OutputXHTML" type="{}OutputXHTML" minOccurs="0"/&gt;
 *         &lt;element name="OutputBarcode" type="{}OutputBarcode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="OutputFormat" use="required" type="{}OutputFormatType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputContent", propOrder = {
        "predefinedContent",
        "outputText",
        "outputXHTML",
        "outputBarcode"
})
public class OutputContent {

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
     * The Output barcode.
     */
    @XmlElement(name = "OutputBarcode")
    @Schema(description = "BarCode content to display or print. --Rule: Mandatory, if OutputFormat is BarCode, not allowed otherwise.")
    protected OutputBarcode outputBarcode;
    /**
     * The Output format.
     */
    @XmlElement(name = "OutputFormat", required = true)
    @Schema(description = "Format of the content to display or print")
    protected OutputFormatType outputFormat;

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
     * Gets the value of the outputBarcode property.
     *
     * @return possible      object is     {@link OutputBarcode }
     */
    public OutputBarcode getOutputBarcode() {
        return outputBarcode;
    }

    /**
     * Sets the value of the outputBarcode property.
     *
     * @param value allowed object is     {@link OutputBarcode }
     */
    public void setOutputBarcode(OutputBarcode value) {
        this.outputBarcode = value;
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

}
