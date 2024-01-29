package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the response from the payment Acquirer.
 *
 * <p>Java class for PaymentAcquirerData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PaymentAcquirerData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AcquirerTransactionID" type="{}TransactionIdentification" minOccurs="0"/&gt;
 *         &lt;element name="ApprovalCode" type="{}ApprovalCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="AcquirerID" type="{}AcquirerID" /&gt;
 *       &lt;attribute name="MerchantID" use="required" type="{}MerchantID" /&gt;
 *       &lt;attribute name="AcquirerPOIID" use="required" type="{}AcquirerPOIID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentAcquirerData", propOrder = {
        "acquirerTransactionID",
        "approvalCode"
})
public class PaymentAcquirerData {

    /**
     * The Acquirer transaction id.
     */
    @XmlElement(name = "AcquirerTransactionID")
    @Schema(description = "Identification of the Transaction for the Acquirer. --Rule: If provided by the Acquirer")
    protected TransactionIdentification acquirerTransactionID;
    /**
     * The Approval code.
     */
    @XmlElement(name = "ApprovalCode")
    @Schema(description = "Code assigned to a transaction approval by the Acquirer. --Rule: If available")
    protected String approvalCode;
    /**
     * The Acquirer id.
     */
    @XmlElement(name = "AcquirerID")
    @Schema(description = "Identification of the Acquirer --Rule: If several Acquirers")
    protected String acquirerID;
    /**
     * The Merchant id.
     */
    @XmlElement(name = "MerchantID", required = true)
    @Schema(description = "Identification of the Merchant for the Acquirer")
    protected String merchantID;
    /**
     * The Acquirer poiid.
     */
    @XmlElement(name = "AcquirerPOIID", required = true)
    @Schema(description = "Identification of the POI for the payment Acquirer")
    protected String acquirerPOIID;

    /**
     * Gets the value of the acquirerTransactionID property.
     *
     * @return possible      object is     {@link TransactionIdentification }
     */
    public TransactionIdentification getAcquirerTransactionID() {
        return acquirerTransactionID;
    }

    /**
     * Sets the value of the acquirerTransactionID property.
     *
     * @param value allowed object is     {@link TransactionIdentification }
     */
    public void setAcquirerTransactionID(TransactionIdentification value) {
        this.acquirerTransactionID = value;
    }

    /**
     * Gets the value of the approvalCode property.
     *
     * @return possible      object is     {@link String }
     */
    public String getApprovalCode() {
        return approvalCode;
    }

    /**
     * Sets the value of the approvalCode property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setApprovalCode(String value) {
        this.approvalCode = value;
    }

    /**
     * Gets the value of the acquirerID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getAcquirerID() {
        return acquirerID;
    }

    /**
     * Sets the value of the acquirerID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setAcquirerID(String value) {
        this.acquirerID = value;
    }

    /**
     * Gets the value of the merchantID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getMerchantID() {
        return merchantID;
    }

    /**
     * Sets the value of the merchantID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setMerchantID(String value) {
        this.merchantID = value;
    }

    /**
     * Gets the value of the acquirerPOIID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getAcquirerPOIID() {
        return acquirerPOIID;
    }

    /**
     * Sets the value of the acquirerPOIID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setAcquirerPOIID(String value) {
        this.acquirerPOIID = value;
    }

}
