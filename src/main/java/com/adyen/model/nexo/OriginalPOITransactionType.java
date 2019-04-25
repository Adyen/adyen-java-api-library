
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Identification of a previous POI transaction. -- Usage: In the Payment or the Loyalty Request message, it allows using the card of a previous CardAcquisition or Payment/Loyalty request. To reverse a Payment or the Loyalty transaction. By default, the reversal is requested from the same Sale
 * 
 * <p>Java class for OriginalPOITransactionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OriginalPOITransactionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="POITransactionID" type="{}TransactionIdentificationType" minOccurs="0"/>
 *         &lt;element name="ApprovalCode" type="{}ApprovalCodeType" minOccurs="0"/>
 *         &lt;element name="HostTransactionID" type="{}TransactionIdentificationType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="SaleID" type="{}SaleIDType" />
 *       &lt;attribute name="POIID" type="{}POIIDType" />
 *       &lt;attribute name="ReuseCardDataFlag" type="{}ReuseCardDataFlagType" default="true" />
 *       &lt;attribute name="CustomerLanguage" type="{}ISOLanguage2A" />
 *       &lt;attribute name="AcquirerID" type="{}AcquirerIDType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginalPOITransactionType", propOrder = {
    "poiTransactionID",
    "approvalCode",
    "hostTransactionID"
})
public class OriginalPOITransactionType {

    @XmlElement(name = "POITransactionID")
    protected TransactionIdentificationType poiTransactionID;
    @XmlElement(name = "ApprovalCode")
    protected String approvalCode;
    @XmlElement(name = "HostTransactionID")
    protected TransactionIdentificationType hostTransactionID;
    @XmlAttribute(name = "SaleID")
    protected String saleID;
    @XmlAttribute(name = "POIID")
    protected String poiid;
    @XmlAttribute(name = "ReuseCardDataFlag")
    protected Boolean reuseCardDataFlag;
    @XmlAttribute(name = "CustomerLanguage")
    protected String customerLanguage;
    @XmlAttribute(name = "AcquirerID")
    protected String acquirerID;

    /**
     * Gets the value of the poiTransactionID property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionIdentificationType }
     *     
     */
    public TransactionIdentificationType getPOITransactionID() {
        return poiTransactionID;
    }

    /**
     * Sets the value of the poiTransactionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionIdentificationType }
     *     
     */
    public void setPOITransactionID(TransactionIdentificationType value) {
        this.poiTransactionID = value;
    }

    /**
     * Gets the value of the approvalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovalCode() {
        return approvalCode;
    }

    /**
     * Sets the value of the approvalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovalCode(String value) {
        this.approvalCode = value;
    }

    /**
     * Gets the value of the hostTransactionID property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionIdentificationType }
     *     
     */
    public TransactionIdentificationType getHostTransactionID() {
        return hostTransactionID;
    }

    /**
     * Sets the value of the hostTransactionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionIdentificationType }
     *     
     */
    public void setHostTransactionID(TransactionIdentificationType value) {
        this.hostTransactionID = value;
    }

    /**
     * Gets the value of the saleID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaleID() {
        return saleID;
    }

    /**
     * Sets the value of the saleID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaleID(String value) {
        this.saleID = value;
    }

    /**
     * Gets the value of the poiid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOIID() {
        return poiid;
    }

    /**
     * Sets the value of the poiid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOIID(String value) {
        this.poiid = value;
    }

    /**
     * Gets the value of the reuseCardDataFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
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
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReuseCardDataFlag(Boolean value) {
        this.reuseCardDataFlag = value;
    }

    /**
     * Gets the value of the customerLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerLanguage() {
        return customerLanguage;
    }

    /**
     * Sets the value of the customerLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerLanguage(String value) {
        this.customerLanguage = value;
    }

    /**
     * Gets the value of the acquirerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcquirerID() {
        return acquirerID;
    }

    /**
     * Sets the value of the acquirerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcquirerID(String value) {
        this.acquirerID = value;
    }

}
