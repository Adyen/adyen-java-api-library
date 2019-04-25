
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Balance Inquiry Request message. -- Usage: It conveys Information related to the account for which a Balance Inquiry is requested
 * 
 * <p>Java class for BalanceInquiryRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BalanceInquiryRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaymentAccountReq" type="{}PaymentAccountReqType" minOccurs="0"/>
 *         &lt;element name="LoyaltyAccountReq" type="{}LoyaltyAccountReqType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BalanceInquiryRequestType", propOrder = {
    "paymentAccountReq",
    "loyaltyAccountReq"
})
public class BalanceInquiryRequestType {

    @XmlElement(name = "PaymentAccountReq")
    protected PaymentAccountReqType paymentAccountReq;
    @XmlElement(name = "LoyaltyAccountReq")
    protected LoyaltyAccountReqType loyaltyAccountReq;

    /**
     * Gets the value of the paymentAccountReq property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentAccountReqType }
     *     
     */
    public PaymentAccountReqType getPaymentAccountReq() {
        return paymentAccountReq;
    }

    /**
     * Sets the value of the paymentAccountReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentAccountReqType }
     *     
     */
    public void setPaymentAccountReq(PaymentAccountReqType value) {
        this.paymentAccountReq = value;
    }

    /**
     * Gets the value of the loyaltyAccountReq property.
     * 
     * @return
     *     possible object is
     *     {@link LoyaltyAccountReqType }
     *     
     */
    public LoyaltyAccountReqType getLoyaltyAccountReq() {
        return loyaltyAccountReq;
    }

    /**
     * Sets the value of the loyaltyAccountReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyaltyAccountReqType }
     *     
     */
    public void setLoyaltyAccountReq(LoyaltyAccountReqType value) {
        this.loyaltyAccountReq = value;
    }

}
