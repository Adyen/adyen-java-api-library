
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Balance Inquiry Response messageType. -- Usage: It conveys the balance and the identification of the associated payment, loyalty or stored value account.
 *
 * <p>Java class for BalanceInquiryResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BalanceInquiryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}Response"/>
 *         &lt;element name="PaymentAccountStatus" type="{}PaymentAccountStatus" minOccurs="0"/>
 *         &lt;element name="LoyaltyAccountStatus" type="{}LoyaltyAccountStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BalanceInquiryResponse", propOrder = {
    "response",
    "paymentAccountStatus",
    "loyaltyAccountStatus"
})
public class BalanceInquiryResponse {

    @XmlElement(name = "Response", required = true)
    protected Response response;
    @XmlElement(name = "PaymentAccountStatus")
    protected PaymentAccountStatus paymentAccountStatus;
    @XmlElement(name = "LoyaltyAccountStatus")
    protected LoyaltyAccountStatus loyaltyAccountStatus;

    /**
     * Gets the value of the response property.
     *
     * @return
     *     possible object is
     *     {@link Response }
     *
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value
     *     allowed object is
     *     {@link Response }
     *
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the paymentAccountStatus property.
     *
     * @return
     *     possible object is
     *     {@link PaymentAccountStatus }
     *
     */
    public PaymentAccountStatus getPaymentAccountStatus() {
        return paymentAccountStatus;
    }

    /**
     * Sets the value of the paymentAccountStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link PaymentAccountStatus }
     *
     */
    public void setPaymentAccountStatus(PaymentAccountStatus value) {
        this.paymentAccountStatus = value;
    }

    /**
     * Gets the value of the loyaltyAccountStatus property.
     *
     * @return
     *     possible object is
     *     {@link LoyaltyAccountStatus }
     *
     */
    public LoyaltyAccountStatus getLoyaltyAccountStatus() {
        return loyaltyAccountStatus;
    }

    /**
     * Sets the value of the loyaltyAccountStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link LoyaltyAccountStatus }
     *
     */
    public void setLoyaltyAccountStatus(LoyaltyAccountStatus value) {
        this.loyaltyAccountStatus = value;
    }

}
