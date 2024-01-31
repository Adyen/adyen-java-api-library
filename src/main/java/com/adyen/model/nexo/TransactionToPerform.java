package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

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
 * &lt;complexType name="TransactionToPerform"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="PaymentRequest" type="{}PaymentRequest" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyRequest" type="{}LoyaltyRequest" minOccurs="0"/&gt;
 *         &lt;element name="ReversalRequest" type="{}ReversalRequest" minOccurs="0"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionToPerform", propOrder = {
        "paymentRequest",
        "loyaltyRequest",
        "reversalRequest"
})
public class TransactionToPerform {

    /**
     * The Payment request.
     */
    @XmlElement(name = "PaymentRequest")
    @Schema(description = "Data related to the Payment transaction request.")
    protected PaymentRequest paymentRequest;
    /**
     * The Loyalty request.
     */
    @XmlElement(name = "LoyaltyRequest")
    @Schema(description = "Data related to the Loyalty transaction request.")
    protected LoyaltyRequest loyaltyRequest;
    /**
     * The Reversal request.
     */
    @XmlElement(name = "ReversalRequest")
    @Schema(description = "Data related to the Reveraal transaction request.")
    protected ReversalRequest reversalRequest;

    /**
     * Gets the value of the paymentRequest property.
     *
     * @return possible      object is     {@link PaymentRequest }
     */
    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    /**
     * Sets the value of the paymentRequest property.
     *
     * @param value allowed object is     {@link PaymentRequest }
     */
    public void setPaymentRequest(PaymentRequest value) {
        this.paymentRequest = value;
    }

    /**
     * Gets the value of the loyaltyRequest property.
     *
     * @return possible      object is     {@link LoyaltyRequest }
     */
    public LoyaltyRequest getLoyaltyRequest() {
        return loyaltyRequest;
    }

    /**
     * Sets the value of the loyaltyRequest property.
     *
     * @param value allowed object is     {@link LoyaltyRequest }
     */
    public void setLoyaltyRequest(LoyaltyRequest value) {
        this.loyaltyRequest = value;
    }

    /**
     * Gets the value of the reversalRequest property.
     *
     * @return possible      object is     {@link ReversalRequest }
     */
    public ReversalRequest getReversalRequest() {
        return reversalRequest;
    }

    /**
     * Sets the value of the reversalRequest property.
     *
     * @param value allowed object is     {@link ReversalRequest }
     */
    public void setReversalRequest(ReversalRequest value) {
        this.reversalRequest = value;
    }

}
