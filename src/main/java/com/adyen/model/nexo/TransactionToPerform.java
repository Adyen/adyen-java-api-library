
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the batch of transactions to perform.
 *
 * <p>Java class for TransactionToPerform complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TransactionToPerform">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="PaymentRequest" type="{}PaymentRequest" minOccurs="0"/>
 *         &lt;element name="LoyaltyRequest" type="{}LoyaltyRequest" minOccurs="0"/>
 *         &lt;element name="ReversalRequest" type="{}ReversalRequest" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionToPerform", propOrder = {
    "paymentRequest",
    "loyaltyRequest",
    "reversalRequest"
})
public class TransactionToPerform {

    @XmlElement(name = "PaymentRequest")
    protected PaymentRequest paymentRequest;
    @XmlElement(name = "LoyaltyRequest")
    protected LoyaltyRequest loyaltyRequest;
    @XmlElement(name = "ReversalRequest")
    protected ReversalRequest reversalRequest;

    /**
     * Gets the value of the paymentRequest property.
     *
     * @return
     *     possible object is
     *     {@link PaymentRequest }
     *
     */
    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    /**
     * Sets the value of the paymentRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link PaymentRequest }
     *
     */
    public void setPaymentRequest(PaymentRequest value) {
        this.paymentRequest = value;
    }

    /**
     * Gets the value of the loyaltyRequest property.
     *
     * @return
     *     possible object is
     *     {@link LoyaltyRequest }
     *
     */
    public LoyaltyRequest getLoyaltyRequest() {
        return loyaltyRequest;
    }

    /**
     * Sets the value of the loyaltyRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link LoyaltyRequest }
     *
     */
    public void setLoyaltyRequest(LoyaltyRequest value) {
        this.loyaltyRequest = value;
    }

    /**
     * Gets the value of the reversalRequest property.
     *
     * @return
     *     possible object is
     *     {@link ReversalRequest }
     *
     */
    public ReversalRequest getReversalRequest() {
        return reversalRequest;
    }

    /**
     * Sets the value of the reversalRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link ReversalRequest }
     *
     */
    public void setReversalRequest(ReversalRequest value) {
        this.reversalRequest = value;
    }

}
