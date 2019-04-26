
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Customer or Merchant payment receipt. -- Usage: If the payment receipts are printed by the Sale system and the POI or the Sale does not implement the Print exchange (Basic profile).
 *
 * <p>Java class for PaymentReceipt complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PaymentReceipt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OutputContent" type="{}OutputContent"/>
 *       &lt;/sequence>
 *       &lt;attribute name="DocumentQualifier" use="required" type="{}DocumentQualifierType" />
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
@XmlType(name = "PaymentReceipt", propOrder = {
    "outputContent"
})
public class PaymentReceipt {

    @XmlElement(name = "OutputContent", required = true)
    protected OutputContent outputContent;
    @XmlAttribute(name = "DocumentQualifier", required = true)
    protected DocumentQualifierType documentQualifier;
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
