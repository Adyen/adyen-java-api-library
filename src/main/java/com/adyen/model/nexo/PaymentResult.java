package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Data related to the result of a processed payment transaction. -- Usage: In the Message Response, the result of card payment transaction.
 *
 * <p>Java class for PaymentResult complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PaymentResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PaymentInstrumentData" type="{}PaymentInstrumentData" minOccurs="0"/&gt;
 *         &lt;element name="AmountsResp" type="{}AmountsResp" minOccurs="0"/&gt;
 *         &lt;element name="Instalment" type="{}Instalment" minOccurs="0"/&gt;
 *         &lt;element name="CurrencyConversion" type="{}CurrencyConversion" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="CapturedSignature" type="{}CapturedSignature" minOccurs="0"/&gt;
 *         &lt;element name="ProtectedSignature" type="{}ContentInformation" minOccurs="0"/&gt;
 *         &lt;element name="PaymentAcquirerData" type="{}PaymentAcquirerData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Payment" type="{}PaymentType" default="Normal" /&gt;
 *       &lt;attribute name="MerchantOverrideFlag" type="{}MerchantOverrideFlag" default="false" /&gt;
 *       &lt;attribute name="CustomerLanguage" type="{}ISOLanguage2A" /&gt;
 *       &lt;attribute name="OnlineFlag" type="{}OnlineFlag" default="true" /&gt;
 *       &lt;attribute name="AuthenticationMethod" type="{}AuthenticationMethod" /&gt;
 *       &lt;attribute name="ValidityDate" type="{}ISODate" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentResult", propOrder = {
        "paymentInstrumentData",
        "amountsResp",
        "instalment",
        "currencyConversion",
        "capturedSignature",
        "protectedSignature",
        "paymentAcquirerData"
})
public class PaymentResult {

    /**
     * The Payment instrument data.
     */
    @XmlElement(name = "PaymentInstrumentData")
    @Schema(description = "Data related to the instrument of payment for the transaction. --Rule: If a payment instrument is analysed by the POI")
    protected PaymentInstrumentData paymentInstrumentData;
    /**
     * The Amounts resp.
     */
    @XmlElement(name = "AmountsResp")
    @Schema(description = "Various amounts related to the payment response from the POI System. --Rule: If Result is Success or Partial")
    protected AmountsResp amountsResp;
    /**
     * The Instalment.
     */
    @XmlElement(name = "Instalment")
    @Schema(description = "Information related an instalment transaction. --Rule: Absent if PaymentType is not \"IssuerInstalment\"")
    protected Instalment instalment;
    /**
     * The Currency conversion.
     */
    @XmlElement(name = "CurrencyConversion")
    @Schema(description = "Information related to a currency conversion --Rule: If currency conversion the Sale needs to know")
    protected List<CurrencyConversion> currencyConversion;
    /**
     * The Captured signature.
     */
    @XmlElement(name = "CapturedSignature")
    @Schema(description = "Numeric value of a handwritten signature. --Rule: If handwritten signature is captured on the POI by a signature capture device.")
    protected CapturedSignature capturedSignature;
    /**
     * The Protected signature.
     */
    @XmlElement(name = "ProtectedSignature")
    @Schema(description = "Numeric value of a handwritten signature. --Rule: Encrypted handwritten signature captured on the POI by a signature capture device.")
    protected ContentInformation protectedSignature;
    /**
     * The Payment acquirer data.
     */
    @XmlElement(name = "PaymentAcquirerData")
    @Schema(description = "Data related to the response from the payment Acquirer. --Rule: If a card is analysed and data available")
    protected PaymentAcquirerData paymentAcquirerData;
    /**
     * The Payment type.
     */
    @XmlElement(name = "PaymentType")
    @Schema(description = "Type of payment transaction. --Rule: Copy")
    protected PaymentType paymentType;
    /**
     * The Merchant override flag.
     */
    @XmlElement(name = "MerchantOverrideFlag")
    @Schema(description = "Indicate that the Merchant forced the result of the payment to successfull. --Rule: If payment forced by the Cashier")
    protected Boolean merchantOverrideFlag;
    /**
     * The Customer language.
     */
    @XmlElement(name = "CustomerLanguage")
    @Schema(description = "Language of the Customer --Rule: If the customer language is different from the default language or different from the CustomerLanguage of the")
    protected String customerLanguage;
    /**
     * The Online flag.
     */
    @XmlElement(name = "OnlineFlag")
    @Schema(description = "Indicate that the payment transaction processing has required the approval of a host. --Rule: \"True\" if the payment transaction processing has required the approval of a host.")
    protected Boolean onlineFlag;
    /**
     * The Authentication method.
     */
    @XmlElement(name = "AuthenticationMethod")
    @Schema(description = "Method for customer authentication. --Rule: Method for customer authentication.")
    protected List<AuthenticationMethodType> authenticationMethod;
    /**
     * The Validity date.
     */
    @XmlElement(name = "ValidityDate")
    @Schema(description = "End of the validity period for the reservation. --Rule: if OneTimeReservation, FirstReservation or UpdateReservation")
    protected String validityDate;

    /**
     * Gets the value of the paymentInstrumentData property.
     *
     * @return possible      object is     {@link PaymentInstrumentData }
     */
    public PaymentInstrumentData getPaymentInstrumentData() {
        return paymentInstrumentData;
    }

    /**
     * Sets the value of the paymentInstrumentData property.
     *
     * @param value allowed object is     {@link PaymentInstrumentData }
     */
    public void setPaymentInstrumentData(PaymentInstrumentData value) {
        this.paymentInstrumentData = value;
    }

    /**
     * Gets the value of the amountsResp property.
     *
     * @return possible      object is     {@link AmountsResp }
     */
    public AmountsResp getAmountsResp() {
        return amountsResp;
    }

    /**
     * Sets the value of the amountsResp property.
     *
     * @param value allowed object is     {@link AmountsResp }
     */
    public void setAmountsResp(AmountsResp value) {
        this.amountsResp = value;
    }

    /**
     * Gets the value of the instalment property.
     *
     * @return possible      object is     {@link Instalment }
     */
    public Instalment getInstalment() {
        return instalment;
    }

    /**
     * Sets the value of the instalment property.
     *
     * @param value allowed object is     {@link Instalment }
     */
    public void setInstalment(Instalment value) {
        this.instalment = value;
    }

    /**
     * Gets the value of the currencyConversion property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currencyConversion property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrencyConversion().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CurrencyConversion }
     *
     * @return the currency conversion
     */
    public List<CurrencyConversion> getCurrencyConversion() {
        if (currencyConversion == null) {
            currencyConversion = new ArrayList<>();
        }
        return this.currencyConversion;
    }

    /**
     * Gets the value of the capturedSignature property.
     *
     * @return possible      object is     {@link CapturedSignature }
     */
    public CapturedSignature getCapturedSignature() {
        return capturedSignature;
    }

    /**
     * Sets the value of the capturedSignature property.
     *
     * @param value allowed object is     {@link CapturedSignature }
     */
    public void setCapturedSignature(CapturedSignature value) {
        this.capturedSignature = value;
    }

    /**
     * Gets the value of the protectedSignature property.
     *
     * @return possible      object is     {@link ContentInformation }
     */
    public ContentInformation getProtectedSignature() {
        return protectedSignature;
    }

    /**
     * Sets the value of the protectedSignature property.
     *
     * @param value allowed object is     {@link ContentInformation }
     */
    public void setProtectedSignature(ContentInformation value) {
        this.protectedSignature = value;
    }

    /**
     * Gets the value of the paymentAcquirerData property.
     *
     * @return possible      object is     {@link PaymentAcquirerData }
     */
    public PaymentAcquirerData getPaymentAcquirerData() {
        return paymentAcquirerData;
    }

    /**
     * Sets the value of the paymentAcquirerData property.
     *
     * @param value allowed object is     {@link PaymentAcquirerData }
     */
    public void setPaymentAcquirerData(PaymentAcquirerData value) {
        this.paymentAcquirerData = value;
    }

    /**
     * Gets the value of the PaymentType property.
     *
     * @return possible      object is     {@link PaymentType }
     */
    public PaymentType getPaymentType() {
        if (paymentType == null) {
            return PaymentType.NORMAL;
        } else {
            return paymentType;
        }
    }

    /**
     * Sets the value of the PaymentType property.
     *
     * @param value allowed object is     {@link PaymentType }
     */
    public void setPaymentType(PaymentType value) {
        this.paymentType = value;
    }

    /**
     * Gets the value of the merchantOverrideFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public boolean isMerchantOverrideFlag() {
        if (merchantOverrideFlag == null) {
            return false;
        } else {
            return merchantOverrideFlag;
        }
    }

    /**
     * Sets the value of the merchantOverrideFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setMerchantOverrideFlag(Boolean value) {
        this.merchantOverrideFlag = value;
    }

    /**
     * Gets the value of the customerLanguage property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCustomerLanguage() {
        return customerLanguage;
    }

    /**
     * Sets the value of the customerLanguage property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCustomerLanguage(String value) {
        this.customerLanguage = value;
    }

    /**
     * Gets the value of the onlineFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public boolean isOnlineFlag() {
        if (onlineFlag == null) {
            return true;
        } else {
            return onlineFlag;
        }
    }

    /**
     * Sets the value of the onlineFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setOnlineFlag(Boolean value) {
        this.onlineFlag = value;
    }

    /**
     * Gets the value of the authenticationMethod property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authenticationMethod property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthenticationMethod().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuthenticationMethodType }
     *
     * @return the authentication method
     */
    public List<AuthenticationMethodType> getAuthenticationMethod() {
        if (authenticationMethod == null) {
            authenticationMethod = new ArrayList<>();
        }
        return this.authenticationMethod;
    }

    /**
     * Gets the value of the validityDate property.
     *
     * @return possible      object is     {@link String }
     */
    public String getValidityDate() {
        return validityDate;
    }

    /**
     * Sets the value of the validityDate property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setValidityDate(String value) {
        this.validityDate = value;
    }

}
