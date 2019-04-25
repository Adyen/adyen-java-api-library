
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the batch of transactions to perform.
 * 
 * <p>Java class for TransactionToPerformType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionToPerformType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="PaymentRequest" type="{}PaymentRequestType" minOccurs="0"/>
 *         &lt;element name="LoyaltyRequest" type="{}LoyaltyRequestType" minOccurs="0"/>
 *         &lt;element name="ReversalRequest" type="{}ReversalRequestType" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionToPerformType", propOrder = {
    "paymentRequest",
    "loyaltyRequest",
    "reversalRequest"
})
public class TransactionToPerformType {

    @XmlElement(name = "PaymentRequest")
    protected PaymentRequestType paymentRequest;
    @XmlElement(name = "LoyaltyRequest")
    protected LoyaltyRequestType loyaltyRequest;
    @XmlElement(name = "ReversalRequest")
    protected ReversalRequestType reversalRequest;

    /**
     * Gets the value of the paymentRequest property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentRequestType }
     *     
     */
    public PaymentRequestType getPaymentRequest() {
        return paymentRequest;
    }

    /**
     * Sets the value of the paymentRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentRequestType }
     *     
     */
    public void setPaymentRequest(PaymentRequestType value) {
        this.paymentRequest = value;
    }

    /**
     * Gets the value of the loyaltyRequest property.
     * 
     * @return
     *     possible object is
     *     {@link LoyaltyRequestType }
     *     
     */
    public LoyaltyRequestType getLoyaltyRequest() {
        return loyaltyRequest;
    }

    /**
     * Sets the value of the loyaltyRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyaltyRequestType }
     *     
     */
    public void setLoyaltyRequest(LoyaltyRequestType value) {
        this.loyaltyRequest = value;
    }

    /**
     * Gets the value of the reversalRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ReversalRequestType }
     *     
     */
    public ReversalRequestType getReversalRequest() {
        return reversalRequest;
    }

    /**
     * Sets the value of the reversalRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReversalRequestType }
     *     
     */
    public void setReversalRequest(ReversalRequestType value) {
        this.reversalRequest = value;
    }

}
