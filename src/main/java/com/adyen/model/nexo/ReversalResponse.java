package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Reversal Response messageType. -- Usage: It conveys Information related to the reversal processed by the POI System.
 *
 * <p>Java class for ReversalResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ReversalResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *         &lt;element name="POIData" type="{}POIData" minOccurs="0"/&gt;
 *         &lt;element name="OriginalPOITransaction" type="{}OriginalPOITransaction" minOccurs="0"/&gt;
 *         &lt;element name="PaymentReceipt" type="{}PaymentReceipt" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ReversedAmount" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="CustomerOrderID" type="{}CustomerOrderID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReversalResponse", propOrder = {
        "response",
        "poiData",
        "originalPOITransaction",
        "paymentReceipt"
})
public class ReversalResponse {

    /**
     * The Response.
     */
    @XmlElement(name = "Response", required = true)
    protected Response response;
    /**
     * The Poi data.
     */
    @XmlElement(name = "POIData")
    protected POIData poiData;
    /**
     * The Original poi transaction.
     */
    @XmlElement(name = "OriginalPOITransaction")
    protected OriginalPOITransaction originalPOITransaction;
    /**
     * The Payment receipt.
     */
    @XmlElement(name = "PaymentReceipt")
    protected List<PaymentReceipt> paymentReceipt;
    /**
     * The Reversed amount.
     */
    @XmlAttribute(name = "ReversedAmount")
    protected BigDecimal reversedAmount;
    /**
     * The Customer order id.
     */
    @XmlAttribute(name = "CustomerOrderID")
    protected String customerOrderID;

    /**
     * Gets the value of the response property.
     *
     * @return possible      object is     {@link Response }
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value allowed object is     {@link Response }
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the poiData property.
     *
     * @return possible      object is     {@link POIData }
     */
    public POIData getPOIData() {
        return poiData;
    }

    /**
     * Sets the value of the poiData property.
     *
     * @param value allowed object is     {@link POIData }
     */
    public void setPOIData(POIData value) {
        this.poiData = value;
    }

    /**
     * Gets the value of the originalPOITransaction property.
     *
     * @return possible      object is     {@link OriginalPOITransaction }
     */
    public OriginalPOITransaction getOriginalPOITransaction() {
        return originalPOITransaction;
    }

    /**
     * Sets the value of the originalPOITransaction property.
     *
     * @param value allowed object is     {@link OriginalPOITransaction }
     */
    public void setOriginalPOITransaction(OriginalPOITransaction value) {
        this.originalPOITransaction = value;
    }

    /**
     * Gets the value of the paymentReceipt property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentReceipt property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentReceipt().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentReceipt }
     *
     * @return the payment receipt
     */
    public List<PaymentReceipt> getPaymentReceipt() {
        if (paymentReceipt == null) {
            paymentReceipt = new ArrayList<>();
        }
        return this.paymentReceipt;
    }

    /**
     * Gets the value of the reversedAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getReversedAmount() {
        return reversedAmount;
    }

    /**
     * Sets the value of the reversedAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setReversedAmount(BigDecimal value) {
        this.reversedAmount = value;
    }

    /**
     * Gets the value of the customerOrderID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCustomerOrderID() {
        return customerOrderID;
    }

    /**
     * Sets the value of the customerOrderID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCustomerOrderID(String value) {
        this.customerOrderID = value;
    }

}
