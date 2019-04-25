
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Information to print and the way to process the print. -- Usage: It contains a complete print operation for a Print Device type.
 * 
 * <p>Java class for PrintOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrintOutputType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OutputContent" type="{}OutputContentType"/>
 *         &lt;element name="OutputSignature" type="{}OutputSignatureType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="DocumentQualifier" use="required" type="{}DocumentQualifierTypeCode" />
 *       &lt;attribute name="ResponseMode" use="required" type="{}ResponseModeTypeCode" />
 *       &lt;attribute name="IntegratedPrintFlag" type="{}IntegratedPrintFlagType" default="false" />
 *       &lt;attribute name="RequiredSignatureFlag" type="{}RequiredSignatureFlagType" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrintOutputType", propOrder = {
    "outputContent",
    "outputSignature"
})
public class PrintOutputType {

    @XmlElement(name = "OutputContent", required = true)
    protected OutputContentType outputContent;
    @XmlElement(name = "OutputSignature")
    protected byte[] outputSignature;
    @XmlAttribute(name = "DocumentQualifier", required = true)
    protected String documentQualifier;
    @XmlAttribute(name = "ResponseMode", required = true)
    protected String responseMode;
    @XmlAttribute(name = "IntegratedPrintFlag")
    protected Boolean integratedPrintFlag;
    @XmlAttribute(name = "RequiredSignatureFlag")
    protected Boolean requiredSignatureFlag;

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
     * Gets the value of the documentQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentQualifier() {
        return documentQualifier;
    }

    /**
     * Sets the value of the documentQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentQualifier(String value) {
        this.documentQualifier = value;
    }

    /**
     * Gets the value of the responseMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseMode() {
        return responseMode;
    }

    /**
     * Sets the value of the responseMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseMode(String value) {
        this.responseMode = value;
    }

    /**
     * Gets the value of the integratedPrintFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIntegratedPrintFlag() {
        if (integratedPrintFlag == null) {
            return false;
        } else {
            return integratedPrintFlag;
        }
    }

    /**
     * Sets the value of the integratedPrintFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIntegratedPrintFlag(Boolean value) {
        this.integratedPrintFlag = value;
    }

    /**
     * Gets the value of the requiredSignatureFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isRequiredSignatureFlag() {
        if (requiredSignatureFlag == null) {
            return false;
        } else {
            return requiredSignatureFlag;
        }
    }

    /**
     * Sets the value of the requiredSignatureFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequiredSignatureFlag(Boolean value) {
        this.requiredSignatureFlag = value;
    }

}
