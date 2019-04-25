
package com.adyen.model.nexo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Reversal Response message. -- Usage: It conveys Information related to the reversal processed by the POI System.
 * 
 * <p>Java class for ReversalResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReversalResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}ResponseType"/>
 *         &lt;element name="POIData" type="{}POIDataType" minOccurs="0"/>
 *         &lt;element name="OriginalPOITransaction" type="{}OriginalPOITransactionType" minOccurs="0"/>
 *         &lt;element name="PaymentReceipt" type="{}PaymentReceiptType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ReversedAmount" type="{}SimpleAmountType" />
 *       &lt;attribute name="CustomerOrderID" type="{}CustomerOrderIDType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReversalResponseType", propOrder = {
    "response",
    "poiData",
    "originalPOITransaction",
    "paymentReceipt"
})
public class ReversalResponseType {

    @XmlElement(name = "Response", required = true)
    protected ResponseType response;
    @XmlElement(name = "POIData")
    protected POIDataType poiData;
    @XmlElement(name = "OriginalPOITransaction")
    protected OriginalPOITransactionType originalPOITransaction;
    @XmlElement(name = "PaymentReceipt")
    protected List<PaymentReceiptType> paymentReceipt;
    @XmlAttribute(name = "ReversedAmount")
    protected BigDecimal reversedAmount;
    @XmlAttribute(name = "CustomerOrderID")
    protected String customerOrderID;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseType }
     *     
     */
    public ResponseType getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseType }
     *     
     */
    public void setResponse(ResponseType value) {
        this.response = value;
    }

    /**
     * Gets the value of the poiData property.
     * 
     * @return
     *     possible object is
     *     {@link POIDataType }
     *     
     */
    public POIDataType getPOIData() {
        return poiData;
    }

    /**
     * Sets the value of the poiData property.
     * 
     * @param value
     *     allowed object is
     *     {@link POIDataType }
     *     
     */
    public void setPOIData(POIDataType value) {
        this.poiData = value;
    }

    /**
     * Gets the value of the originalPOITransaction property.
     * 
     * @return
     *     possible object is
     *     {@link OriginalPOITransactionType }
     *     
     */
    public OriginalPOITransactionType getOriginalPOITransaction() {
        return originalPOITransaction;
    }

    /**
     * Sets the value of the originalPOITransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalPOITransactionType }
     *     
     */
    public void setOriginalPOITransaction(OriginalPOITransactionType value) {
        this.originalPOITransaction = value;
    }

    /**
     * Gets the value of the paymentReceipt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentReceipt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentReceipt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentReceiptType }
     * 
     * 
     */
    public List<PaymentReceiptType> getPaymentReceipt() {
        if (paymentReceipt == null) {
            paymentReceipt = new ArrayList<PaymentReceiptType>();
        }
        return this.paymentReceipt;
    }

    /**
     * Gets the value of the reversedAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getReversedAmount() {
        return reversedAmount;
    }

    /**
     * Sets the value of the reversedAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setReversedAmount(BigDecimal value) {
        this.reversedAmount = value;
    }

    /**
     * Gets the value of the customerOrderID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerOrderID() {
        return customerOrderID;
    }

    /**
     * Sets the value of the customerOrderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerOrderID(String value) {
        this.customerOrderID = value;
    }

}
