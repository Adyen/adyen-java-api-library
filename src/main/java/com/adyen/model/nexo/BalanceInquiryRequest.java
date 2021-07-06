package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Balance Inquiry Request messageType. -- Usage: It conveys Information related to the account for which a Balance Inquiry is requested
 *
 * <p>Java class for BalanceInquiryRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BalanceInquiryRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PaymentAccountReq" type="{}PaymentAccountReq" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyAccountReq" type="{}LoyaltyAccountReq" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BalanceInquiryRequest", propOrder = {
        "paymentAccountReq",
        "loyaltyAccountReq"
})
public class BalanceInquiryRequest {

    /**
     * The Payment account req.
     */
    @XmlElement(name = "PaymentAccountReq")
    @Schema(description = "Data related to the account pointed by the payment card")
    protected PaymentAccountReq paymentAccountReq;
    /**
     * The Loyalty account req.
     */
    @XmlElement(name = "LoyaltyAccountReq")
    @Schema(description = "Data related to a requested Loyalty program or account.")
    protected LoyaltyAccountReq loyaltyAccountReq;

    /**
     * Gets the value of the paymentAccountReq property.
     *
     * @return possible      object is     {@link PaymentAccountReq }
     */
    public PaymentAccountReq getPaymentAccountReq() {
        return paymentAccountReq;
    }

    /**
     * Sets the value of the paymentAccountReq property.
     *
     * @param value allowed object is     {@link PaymentAccountReq }
     */
    public void setPaymentAccountReq(PaymentAccountReq value) {
        this.paymentAccountReq = value;
    }

    /**
     * Gets the value of the loyaltyAccountReq property.
     *
     * @return possible      object is     {@link LoyaltyAccountReq }
     */
    public LoyaltyAccountReq getLoyaltyAccountReq() {
        return loyaltyAccountReq;
    }

    /**
     * Sets the value of the loyaltyAccountReq property.
     *
     * @param value allowed object is     {@link LoyaltyAccountReq }
     */
    public void setLoyaltyAccountReq(LoyaltyAccountReq value) {
        this.loyaltyAccountReq = value;
    }

}
