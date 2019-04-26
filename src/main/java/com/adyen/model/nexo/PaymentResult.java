
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the result of a processed payment transaction. -- Usage: In the Message Response, the result of card payment transaction.
 *
 * <p>Java class for PaymentResult complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PaymentResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaymentInstrumentData" type="{}PaymentInstrumentData" minOccurs="0"/>
 *         &lt;element name="AmountsResp" type="{}AmountsResp" minOccurs="0"/>
 *         &lt;element name="Instalment" type="{}Instalment" minOccurs="0"/>
 *         &lt;element name="CurrencyConversion" type="{}CurrencyConversion" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CapturedSignature" type="{}CapturedSignature" minOccurs="0"/>
 *         &lt;element name="ProtectedSignature" type="{}ContentInformation" minOccurs="0"/>
 *         &lt;element name="PaymentAcquirerData" type="{}PaymentAcquirerData" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Payment" type="{}PaymentType" default="Normal" />
 *       &lt;attribute name="MerchantOverrideFlag" type="{}MerchantOverrideFlag" default="false" />
 *       &lt;attribute name="CustomerLanguage" type="{}ISOLanguage2A" />
 *       &lt;attribute name="OnlineFlag" type="{}OnlineFlag" default="true" />
 *       &lt;attribute name="AuthenticationMethod" type="{}AuthenticationMethod" />
 *       &lt;attribute name="ValidityDate" type="{}ISODate" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
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

    @XmlElement(name = "PaymentInstrumentData")
    protected PaymentInstrumentData paymentInstrumentData;
    @XmlElement(name = "AmountsResp")
    protected AmountsResp amountsResp;
    @XmlElement(name = "Instalment")
    protected Instalment instalment;
    @XmlElement(name = "CurrencyConversion")
    protected List<CurrencyConversion> currencyConversion;
    @XmlElement(name = "CapturedSignature")
    protected CapturedSignature capturedSignature;
    @XmlElement(name = "ProtectedSignature")
    protected ContentInformation protectedSignature;
    @XmlElement(name = "PaymentAcquirerData")
    protected PaymentAcquirerData paymentAcquirerData;
    @XmlAttribute(name = "Payment")
    protected PaymentType payment;
    @XmlAttribute(name = "MerchantOverrideFlag")
    protected Boolean merchantOverrideFlag;
    @XmlAttribute(name = "CustomerLanguage")
    protected String customerLanguage;
    @XmlAttribute(name = "OnlineFlag")
    protected Boolean onlineFlag;
    @XmlAttribute(name = "AuthenticationMethod")
    protected List<AuthenticationMethodType> authenticationMethod;
    @XmlAttribute(name = "ValidityDate")
    protected String validityDate;

    /**
     * Gets the value of the paymentInstrumentData property.
     *
     * @return
     *     possible object is
     *     {@link PaymentInstrumentData }
     *
     */
    public PaymentInstrumentData getPaymentInstrumentData() {
        return paymentInstrumentData;
    }

    /**
     * Sets the value of the paymentInstrumentData property.
     *
     * @param value
     *     allowed object is
     *     {@link PaymentInstrumentData }
     *
     */
    public void setPaymentInstrumentData(PaymentInstrumentData value) {
        this.paymentInstrumentData = value;
    }

    /**
     * Gets the value of the amountsResp property.
     *
     * @return
     *     possible object is
     *     {@link AmountsResp }
     *
     */
    public AmountsResp getAmountsResp() {
        return amountsResp;
    }

    /**
     * Sets the value of the amountsResp property.
     *
     * @param value
     *     allowed object is
     *     {@link AmountsResp }
     *
     */
    public void setAmountsResp(AmountsResp value) {
        this.amountsResp = value;
    }

    /**
     * Gets the value of the instalment property.
     *
     * @return
     *     possible object is
     *     {@link Instalment }
     *
     */
    public Instalment getInstalment() {
        return instalment;
    }

    /**
     * Sets the value of the instalment property.
     *
     * @param value
     *     allowed object is
     *     {@link Instalment }
     *
     */
    public void setInstalment(Instalment value) {
        this.instalment = value;
    }

    /**
     * Gets the value of the currencyConversion property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currencyConversion property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrencyConversion().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CurrencyConversion }
     *
     *
     */
    public List<CurrencyConversion> getCurrencyConversion() {
        if (currencyConversion == null) {
            currencyConversion = new ArrayList<CurrencyConversion>();
        }
        return this.currencyConversion;
    }

    /**
     * Gets the value of the capturedSignature property.
     *
     * @return
     *     possible object is
     *     {@link CapturedSignature }
     *
     */
    public CapturedSignature getCapturedSignature() {
        return capturedSignature;
    }

    /**
     * Sets the value of the capturedSignature property.
     *
     * @param value
     *     allowed object is
     *     {@link CapturedSignature }
     *
     */
    public void setCapturedSignature(CapturedSignature value) {
        this.capturedSignature = value;
    }

    /**
     * Gets the value of the protectedSignature property.
     *
     * @return
     *     possible object is
     *     {@link ContentInformation }
     *
     */
    public ContentInformation getProtectedSignature() {
        return protectedSignature;
    }

    /**
     * Sets the value of the protectedSignature property.
     *
     * @param value
     *     allowed object is
     *     {@link ContentInformation }
     *
     */
    public void setProtectedSignature(ContentInformation value) {
        this.protectedSignature = value;
    }

    /**
     * Gets the value of the paymentAcquirerData property.
     *
     * @return
     *     possible object is
     *     {@link PaymentAcquirerData }
     *
     */
    public PaymentAcquirerData getPaymentAcquirerData() {
        return paymentAcquirerData;
    }

    /**
     * Sets the value of the paymentAcquirerData property.
     *
     * @param value
     *     allowed object is
     *     {@link PaymentAcquirerData }
     *
     */
    public void setPaymentAcquirerData(PaymentAcquirerData value) {
        this.paymentAcquirerData = value;
    }

    /**
     * Gets the value of the payment property.
     *
     * @return
     *     possible object is
     *     {@link PaymentType }
     *
     */
    public PaymentType getPayment() {
        if (payment == null) {
            return PaymentType.NORMAL;
        } else {
            return payment;
        }
    }

    /**
     * Sets the value of the payment property.
     *
     * @param value
     *     allowed object is
     *     {@link PaymentType }
     *
     */
    public void setPayment(PaymentType value) {
        this.payment = value;
    }

    /**
     * Gets the value of the merchantOverrideFlag property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
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
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setMerchantOverrideFlag(Boolean value) {
        this.merchantOverrideFlag = value;
    }

    /**
     * Gets the value of the customerLanguage property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCustomerLanguage() {
        return customerLanguage;
    }

    /**
     * Sets the value of the customerLanguage property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCustomerLanguage(String value) {
        this.customerLanguage = value;
    }

    /**
     * Gets the value of the onlineFlag property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
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
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setOnlineFlag(Boolean value) {
        this.onlineFlag = value;
    }

    /**
     * Gets the value of the authenticationMethod property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authenticationMethod property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthenticationMethod().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuthenticationMethodType }
     *
     *
     */
    public List<AuthenticationMethodType> getAuthenticationMethod() {
        if (authenticationMethod == null) {
            authenticationMethod = new ArrayList<AuthenticationMethodType>();
        }
        return this.authenticationMethod;
    }

    /**
     * Gets the value of the validityDate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getValidityDate() {
        return validityDate;
    }

    /**
     * Sets the value of the validityDate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setValidityDate(String value) {
        this.validityDate = value;
    }

}
