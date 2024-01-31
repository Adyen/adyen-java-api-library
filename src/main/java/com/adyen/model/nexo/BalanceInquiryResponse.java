package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

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
 * &lt;complexType name="BalanceInquiryResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *         &lt;element name="PaymentAccountStatus" type="{}PaymentAccountStatus" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyAccountStatus" type="{}LoyaltyAccountStatus" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BalanceInquiryResponse", propOrder = {
        "response",
        "paymentAccountStatus",
        "loyaltyAccountStatus"
})
public class BalanceInquiryResponse {

    /**
     * The Response.
     */
    @XmlElement(name = "Response", required = true)
    @Schema(description = "Result of a message request processing.")
    protected Response response;
    /**
     * The Payment account status.
     */
    @XmlElement(name = "PaymentAccountStatus")
    @Schema(description = "Data related to the result of a Balance Inquiry request. --Rule: If BalanceInquiryRequest. PaymentAccount present")
    protected PaymentAccountStatus paymentAccountStatus;
    /**
     * The Loyalty account status.
     */
    @XmlElement(name = "LoyaltyAccountStatus")
    @Schema(description = "Data related to the result of a loyalty Balance Inquiry. --Rule: If BalanceInquiryRequest. LoyaltyData present")
    protected LoyaltyAccountStatus loyaltyAccountStatus;

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
     * Gets the value of the paymentAccountStatus property.
     *
     * @return possible      object is     {@link PaymentAccountStatus }
     */
    public PaymentAccountStatus getPaymentAccountStatus() {
        return paymentAccountStatus;
    }

    /**
     * Sets the value of the paymentAccountStatus property.
     *
     * @param value allowed object is     {@link PaymentAccountStatus }
     */
    public void setPaymentAccountStatus(PaymentAccountStatus value) {
        this.paymentAccountStatus = value;
    }

    /**
     * Gets the value of the loyaltyAccountStatus property.
     *
     * @return possible      object is     {@link LoyaltyAccountStatus }
     */
    public LoyaltyAccountStatus getLoyaltyAccountStatus() {
        return loyaltyAccountStatus;
    }

    /**
     * Sets the value of the loyaltyAccountStatus property.
     *
     * @param value allowed object is     {@link LoyaltyAccountStatus }
     */
    public void setLoyaltyAccountStatus(LoyaltyAccountStatus value) {
        this.loyaltyAccountStatus = value;
    }

}
