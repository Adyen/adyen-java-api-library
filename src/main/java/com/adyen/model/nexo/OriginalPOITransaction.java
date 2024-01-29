package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Identification of a previous POI transaction. -- Usage: In the Payment or the Loyalty Request messageType, it allows using the card of a previous CardAcquisition or Payment/Loyalty request. To reverse a Payment or the Loyalty transaction. By default, the reversal is requested from the same Sale
 *
 * <p>Java class for OriginalPOITransaction complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OriginalPOITransaction"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="POITransactionID" type="{}TransactionIdentification" minOccurs="0"/&gt;
 *         &lt;element name="ApprovalCode" type="{}ApprovalCode" minOccurs="0"/&gt;
 *         &lt;element name="HostTransactionID" type="{}TransactionIdentification" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="SaleID" type="{}SaleID" /&gt;
 *       &lt;attribute name="POIID" type="{}POIID" /&gt;
 *       &lt;attribute name="ReuseCardDataFlag" type="{}ReuseCardDataFlag" default="true" /&gt;
 *       &lt;attribute name="CustomerLanguage" type="{}ISOLanguage2A" /&gt;
 *       &lt;attribute name="AcquirerID" type="{}AcquirerID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginalPOITransaction", propOrder = {
        "poiTransactionID",
        "approvalCode",
        "hostTransactionID"
})
public class OriginalPOITransaction {

    /**
     * The Poi transaction id.
     */
    @XmlElement(name = "POITransactionID")
    @Schema(description = "Unique identification of a POI transaction for a POI --Rule: Absent if SaleReferenceID is sufficient to identify the transaction, or for some reversal cases.")
    protected TransactionIdentification poiTransactionID;
    /**
     * The Approval code.
     */
    @XmlElement(name = "ApprovalCode")
    @Schema(description = "Code assigned to a transaction approval by the Acquirer. --Rule: If referral")
    protected String approvalCode;
    /**
     * The Host transaction id.
     */
    @XmlElement(name = "HostTransactionID")
    @Schema(description = "Identification of the transaction by the host in charge of the stored value transaction --Rule: If POITransactionID not present")
    protected TransactionIdentification hostTransactionID;
    /**
     * The Sale id.
     */
    @XmlElement(name = "SaleID")
    @Schema(description = "Identification of a Sale System or a Sale Terminal for the Sale to POI protocol")
    protected String saleID;
    /**
     * The Poiid.
     */
    @XmlElement(name = "POIID")
    @Schema(description = "Identification of a POI System or a POI Terminal for the Sale to POI protocol --Rule: If original transaction is coming from another POI")
    protected String poiid;
    /**
     * The Reuse card data flag.
     */
    @XmlElement(name = "ReuseCardDataFlag")
    @Schema(description = "Indicate if the card data has to be got from a previous transaction.")
    protected Boolean reuseCardDataFlag;
    /**
     * The Customer language.
     */
    @XmlElement(name = "CustomerLanguage")
    @Schema(description = "Language of the Customer --Rule: Optional for Reversal, otherwise absent.")
    protected String customerLanguage;
    /**
     * The Acquirer id.
     */
    @XmlElement(name = "AcquirerID")
    @Schema(description = "Identification of the Acquirer --Rule: Optional for Reversal, otherwise absent.")
    protected String acquirerID;

    /**
     * Gets the value of the poiTransactionID property.
     *
     * @return possible      object is     {@link TransactionIdentification }
     */
    public TransactionIdentification getPOITransactionID() {
        return poiTransactionID;
    }

    /**
     * Sets the value of the poiTransactionID property.
     *
     * @param value allowed object is     {@link TransactionIdentification }
     */
    public void setPOITransactionID(TransactionIdentification value) {
        this.poiTransactionID = value;
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
     * Gets the value of the hostTransactionID property.
     *
     * @return possible      object is     {@link TransactionIdentification }
     */
    public TransactionIdentification getHostTransactionID() {
        return hostTransactionID;
    }

    /**
     * Sets the value of the hostTransactionID property.
     *
     * @param value allowed object is     {@link TransactionIdentification }
     */
    public void setHostTransactionID(TransactionIdentification value) {
        this.hostTransactionID = value;
    }

    /**
     * Gets the value of the saleID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getSaleID() {
        return saleID;
    }

    /**
     * Sets the value of the saleID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setSaleID(String value) {
        this.saleID = value;
    }

    /**
     * Gets the value of the poiid property.
     *
     * @return possible      object is     {@link String }
     */
    public String getPOIID() {
        return poiid;
    }

    /**
     * Sets the value of the poiid property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setPOIID(String value) {
        this.poiid = value;
    }

    /**
     * Gets the value of the reuseCardDataFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public boolean isReuseCardDataFlag() {
        if (reuseCardDataFlag == null) {
            return true;
        } else {
            return reuseCardDataFlag;
        }
    }

    /**
     * Sets the value of the reuseCardDataFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setReuseCardDataFlag(Boolean value) {
        this.reuseCardDataFlag = value;
    }

    /**
     * Gets the value of the customerLanguage property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCustomerLanguage() {
        return customerLanguage;
    }

    /**
     * Sets the value of the customerLanguage property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCustomerLanguage(String value) {
        this.customerLanguage = value;
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

}
