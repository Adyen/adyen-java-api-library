
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Balance Inquiry Response message. -- Usage: It conveys the balance and the identification of the associated payment, loyalty or stored value account.
 * 
 * <p>Java class for BalanceInquiryResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BalanceInquiryResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}ResponseType"/>
 *         &lt;element name="PaymentAccountStatus" type="{}PaymentAccountStatusType" minOccurs="0"/>
 *         &lt;element name="LoyaltyAccountStatus" type="{}LoyaltyAccountStatusType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BalanceInquiryResponseType", propOrder = {
    "response",
    "paymentAccountStatus",
    "loyaltyAccountStatus"
})
public class BalanceInquiryResponseType {

    @XmlElement(name = "Response", required = true)
    protected ResponseType response;
    @XmlElement(name = "PaymentAccountStatus")
    protected PaymentAccountStatusType paymentAccountStatus;
    @XmlElement(name = "LoyaltyAccountStatus")
    protected LoyaltyAccountStatusType loyaltyAccountStatus;

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
     * Gets the value of the paymentAccountStatus property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentAccountStatusType }
     *     
     */
    public PaymentAccountStatusType getPaymentAccountStatus() {
        return paymentAccountStatus;
    }

    /**
     * Sets the value of the paymentAccountStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentAccountStatusType }
     *     
     */
    public void setPaymentAccountStatus(PaymentAccountStatusType value) {
        this.paymentAccountStatus = value;
    }

    /**
     * Gets the value of the loyaltyAccountStatus property.
     * 
     * @return
     *     possible object is
     *     {@link LoyaltyAccountStatusType }
     *     
     */
    public LoyaltyAccountStatusType getLoyaltyAccountStatus() {
        return loyaltyAccountStatus;
    }

    /**
     * Sets the value of the loyaltyAccountStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyaltyAccountStatusType }
     *     
     */
    public void setLoyaltyAccountStatus(LoyaltyAccountStatusType value) {
        this.loyaltyAccountStatus = value;
    }

}
