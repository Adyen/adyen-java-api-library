
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Information to print and the way to process the print. -- Usage: It contains a complete print operation for a Print Device type.
 *
 * <p>Java class for PrintOutput complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PrintOutput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OutputContent" type="{}OutputContent"/>
 *         &lt;element name="OutputSignature" type="{}OutputSignature" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="DocumentQualifier" use="required" type="{}DocumentQualifierType" />
 *       &lt;attribute name="ResponseMode" use="required" type="{}ResponseModeType" />
 *       &lt;attribute name="IntegratedPrintFlag" type="{}IntegratedPrintFlag" default="false" />
 *       &lt;attribute name="RequiredSignatureFlag" type="{}RequiredSignatureFlag" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrintOutput", propOrder = {
    "outputContent",
    "outputSignature"
})
public class PrintOutput {

    @XmlElement(name = "OutputContent", required = true)
    protected OutputContent outputContent;
    @XmlElement(name = "OutputSignature")
    protected byte[] outputSignature;
    @XmlAttribute(name = "DocumentQualifier", required = true)
    protected DocumentQualifierType documentQualifier;
    @XmlAttribute(name = "ResponseMode", required = true)
    protected ResponseModeType responseMode;
    @XmlAttribute(name = "IntegratedPrintFlag")
    protected Boolean integratedPrintFlag;
    @XmlAttribute(name = "RequiredSignatureFlag")
    protected Boolean requiredSignatureFlag;

    /**
     * Gets the value of the outputContent property.
     *
     * @return
     *     possible object is
     *     {@link OutputContent }
     *
     */
    public OutputContent getOutputContent() {
        return outputContent;
    }

    /**
     * Sets the value of the outputContent property.
     *
     * @param value
     *     allowed object is
     *     {@link OutputContent }
     *
     */
    public void setOutputContent(OutputContent value) {
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
     *     {@link DocumentQualifierType }
     *
     */
    public DocumentQualifierType getDocumentQualifier() {
        return documentQualifier;
    }

    /**
     * Sets the value of the documentQualifier property.
     *
     * @param value
     *     allowed object is
     *     {@link DocumentQualifierType }
     *
     */
    public void setDocumentQualifier(DocumentQualifierType value) {
        this.documentQualifier = value;
    }

    /**
     * Gets the value of the responseMode property.
     *
     * @return
     *     possible object is
     *     {@link ResponseModeType }
     *
     */
    public ResponseModeType getResponseMode() {
        return responseMode;
    }

    /**
     * Sets the value of the responseMode property.
     *
     * @param value
     *     allowed object is
     *     {@link ResponseModeType }
     *
     */
    public void setResponseMode(ResponseModeType value) {
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
