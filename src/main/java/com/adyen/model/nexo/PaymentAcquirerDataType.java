
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the response from the payment Acquirer.
 * 
 * <p>Java class for PaymentAcquirerDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentAcquirerDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AcquirerTransactionID" type="{}TransactionIdentificationType" minOccurs="0"/>
 *         &lt;element name="ApprovalCode" type="{}ApprovalCodeType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="AcquirerID" type="{}AcquirerIDType" />
 *       &lt;attribute name="MerchantID" use="required" type="{}MerchantIDType" />
 *       &lt;attribute name="AcquirerPOIID" use="required" type="{}AcquirerPOIIDType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentAcquirerDataType", propOrder = {
    "acquirerTransactionID",
    "approvalCode"
})
public class PaymentAcquirerDataType {

    @XmlElement(name = "AcquirerTransactionID")
    protected TransactionIdentificationType acquirerTransactionID;
    @XmlElement(name = "ApprovalCode")
    protected String approvalCode;
    @XmlAttribute(name = "AcquirerID")
    protected String acquirerID;
    @XmlAttribute(name = "MerchantID", required = true)
    protected String merchantID;
    @XmlAttribute(name = "AcquirerPOIID", required = true)
    protected String acquirerPOIID;

    /**
     * Gets the value of the acquirerTransactionID property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionIdentificationType }
     *     
     */
    public TransactionIdentificationType getAcquirerTransactionID() {
        return acquirerTransactionID;
    }

    /**
     * Sets the value of the acquirerTransactionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionIdentificationType }
     *     
     */
    public void setAcquirerTransactionID(TransactionIdentificationType value) {
        this.acquirerTransactionID = value;
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

    /**
     * Gets the value of the merchantID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantID() {
        return merchantID;
    }

    /**
     * Sets the value of the merchantID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantID(String value) {
        this.merchantID = value;
    }

    /**
     * Gets the value of the acquirerPOIID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcquirerPOIID() {
        return acquirerPOIID;
    }

    /**
     * Sets the value of the acquirerPOIID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcquirerPOIID(String value) {
        this.acquirerPOIID = value;
    }

}
