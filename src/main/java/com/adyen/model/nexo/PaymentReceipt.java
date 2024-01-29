package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * &lt;complexType name="PaymentReceipt"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OutputContent" type="{}OutputContent"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="DocumentQualifier" use="required" type="{}DocumentQualifierType" /&gt;
 *       &lt;attribute name="IntegratedPrintFlag" type="{}IntegratedPrintFlag" default="false" /&gt;
 *       &lt;attribute name="RequiredSignatureFlag" type="{}RequiredSignatureFlag" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentReceipt", propOrder = {
        "outputContent"
})
public class PaymentReceipt {

    /**
     * The Output content.
     */
    @XmlElement(name = "OutputContent", required = true)
    @Schema(description = "Content to display or print.")
    protected OutputContent outputContent;
    /**
     * The Document qualifier.
     */
    @XmlElement(name = "DocumentQualifier", required = true)
    @Schema(description = "Qualification of the document to print to the Cashier or the Customer. --Rule: SaleReceipt or CashierReceipt")
    protected DocumentQualifierType documentQualifier;
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
