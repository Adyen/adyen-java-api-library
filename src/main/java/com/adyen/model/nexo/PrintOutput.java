package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * &lt;complexType name="PrintOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OutputContent" type="{}OutputContent"/&gt;
 *         &lt;element name="OutputSignature" type="{}OutputSignature" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="DocumentQualifier" use="required" type="{}DocumentQualifierType" /&gt;
 *       &lt;attribute name="ResponseMode" use="required" type="{}ResponseModeType" /&gt;
 *       &lt;attribute name="IntegratedPrintFlag" type="{}IntegratedPrintFlag" default="false" /&gt;
 *       &lt;attribute name="RequiredSignatureFlag" type="{}RequiredSignatureFlag" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrintOutput", propOrder = {
        "outputContent",
        "outputSignature"
})
public class PrintOutput {

    /**
     * The Output content.
     */
    @XmlElement(name = "OutputContent", required = true)
    @Schema(description = "Content to display or print.")
    protected OutputContent outputContent;
    /**
     * The Output signature.
     */
    @XmlElement(name = "OutputSignature")
    @Schema(description = "Vendor specific signature of text message to display or print. --Rule: If protection has to be provided to the vendor on the text to display or print.")
    protected byte[] outputSignature;
    /**
     * The Document qualifier.
     */
    @XmlElement(name = "DocumentQualifier", required = true)
    @Schema(description = "Qualification of the document to print to the Cashier or the Customer.")
    protected DocumentQualifierType documentQualifier;
    /**
     * The Response mode.
     */
    @XmlElement(name = "ResponseMode", required = true)
    @Schema(description = "Message response awaited by the initiator of the Request")
    protected ResponseModeType responseMode;
    /**
     * The Integrated print flag.
     */
    @XmlElement(name = "IntegratedPrintFlag")
    @Schema(description = "Type of the print integrated to other prints.")
    protected Boolean integratedPrintFlag;
    /**
     * The Required signature flag.
     */
    @XmlElement(name = "RequiredSignatureFlag")
    @Schema(description = "Indicate that the cardholder payment receipt requires a physical signature by the Customer.")
    protected Boolean requiredSignatureFlag;

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
     * Gets the value of the documentQualifier property.
     *
     * @return possible      object is     {@link DocumentQualifierType }
     */
    public DocumentQualifierType getDocumentQualifier() {
        return documentQualifier;
    }

    /**
     * Sets the value of the documentQualifier property.
     *
     * @param value allowed object is     {@link DocumentQualifierType }
     */
    public void setDocumentQualifier(DocumentQualifierType value) {
        this.documentQualifier = value;
    }

    /**
     * Gets the value of the responseMode property.
     *
     * @return possible      object is     {@link ResponseModeType }
     */
    public ResponseModeType getResponseMode() {
        return responseMode;
    }

    /**
     * Sets the value of the responseMode property.
     *
     * @param value allowed object is     {@link ResponseModeType }
     */
    public void setResponseMode(ResponseModeType value) {
        this.responseMode = value;
    }

    /**
     * Gets the value of the integratedPrintFlag property.
     *
     * @return possible      object is     {@link Boolean }
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
     * @param value allowed object is     {@link Boolean }
     */
    public void setIntegratedPrintFlag(Boolean value) {
        this.integratedPrintFlag = value;
    }

    /**
     * Gets the value of the requiredSignatureFlag property.
     *
     * @return possible      object is     {@link Boolean }
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
     * @param value allowed object is     {@link Boolean }
     */
    public void setRequiredSignatureFlag(Boolean value) {
        this.requiredSignatureFlag = value;
    }

}
