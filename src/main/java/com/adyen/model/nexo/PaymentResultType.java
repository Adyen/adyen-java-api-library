
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
 * <p>Java class for PaymentResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaymentInstrumentData" type="{}PaymentInstrumentDataType" minOccurs="0"/>
 *         &lt;element name="AmountsResp" type="{}AmountsRespType" minOccurs="0"/>
 *         &lt;element name="Instalment" type="{}InstalmentType" minOccurs="0"/>
 *         &lt;element name="CurrencyConversion" type="{}CurrencyConversionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CapturedSignature" type="{}CapturedSignatureType" minOccurs="0"/>
 *         &lt;element name="ProtectedSignature" type="{}ContentInformationType" minOccurs="0"/>
 *         &lt;element name="PaymentAcquirerData" type="{}PaymentAcquirerDataType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PaymentType" type="{}PaymentTypeTypeCode" default="Normal" />
 *       &lt;attribute name="MerchantOverrideFlag" type="{}MerchantOverrideFlagType" default="false" />
 *       &lt;attribute name="CustomerLanguage" type="{}ISOLanguage2A" />
 *       &lt;attribute name="OnlineFlag" type="{}OnlineFlagType" default="true" />
 *       &lt;attribute name="AuthenticationMethod" type="{}AuthenticationMethodType" />
 *       &lt;attribute name="ValidityDate" type="{}ISODate" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentResultType", propOrder = {
    "paymentInstrumentData",
    "amountsResp",
    "instalment",
    "currencyConversion",
    "capturedSignature",
    "protectedSignature",
    "paymentAcquirerData"
})
public class PaymentResultType {

    @XmlElement(name = "PaymentInstrumentData")
    protected PaymentInstrumentDataType paymentInstrumentData;
    @XmlElement(name = "AmountsResp")
    protected AmountsRespType amountsResp;
    @XmlElement(name = "Instalment")
    protected InstalmentType instalment;
    @XmlElement(name = "CurrencyConversion")
    protected List<CurrencyConversionType> currencyConversion;
    @XmlElement(name = "CapturedSignature")
    protected CapturedSignatureType capturedSignature;
    @XmlElement(name = "ProtectedSignature")
    protected ContentInformationType protectedSignature;
    @XmlElement(name = "PaymentAcquirerData")
    protected PaymentAcquirerDataType paymentAcquirerData;
    @XmlAttribute(name = "PaymentType")
    protected String paymentType;
    @XmlAttribute(name = "MerchantOverrideFlag")
    protected Boolean merchantOverrideFlag;
    @XmlAttribute(name = "CustomerLanguage")
    protected String customerLanguage;
    @XmlAttribute(name = "OnlineFlag")
    protected Boolean onlineFlag;
    @XmlAttribute(name = "AuthenticationMethod")
    protected List<String> authenticationMethod;
    @XmlAttribute(name = "ValidityDate")
    protected String validityDate;

    /**
     * Gets the value of the paymentInstrumentData property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentInstrumentDataType }
     *     
     */
    public PaymentInstrumentDataType getPaymentInstrumentData() {
        return paymentInstrumentData;
    }

    /**
     * Sets the value of the paymentInstrumentData property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentInstrumentDataType }
     *     
     */
    public void setPaymentInstrumentData(PaymentInstrumentDataType value) {
        this.paymentInstrumentData = value;
    }

    /**
     * Gets the value of the amountsResp property.
     * 
     * @return
     *     possible object is
     *     {@link AmountsRespType }
     *     
     */
    public AmountsRespType getAmountsResp() {
        return amountsResp;
    }

    /**
     * Sets the value of the amountsResp property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountsRespType }
     *     
     */
    public void setAmountsResp(AmountsRespType value) {
        this.amountsResp = value;
    }

    /**
     * Gets the value of the instalment property.
     * 
     * @return
     *     possible object is
     *     {@link InstalmentType }
     *     
     */
    public InstalmentType getInstalment() {
        return instalment;
    }

    /**
     * Sets the value of the instalment property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstalmentType }
     *     
     */
    public void setInstalment(InstalmentType value) {
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
     * {@link CurrencyConversionType }
     * 
     * 
     */
    public List<CurrencyConversionType> getCurrencyConversion() {
        if (currencyConversion == null) {
            currencyConversion = new ArrayList<CurrencyConversionType>();
        }
        return this.currencyConversion;
    }

    /**
     * Gets the value of the capturedSignature property.
     * 
     * @return
     *     possible object is
     *     {@link CapturedSignatureType }
     *     
     */
    public CapturedSignatureType getCapturedSignature() {
        return capturedSignature;
    }

    /**
     * Sets the value of the capturedSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapturedSignatureType }
     *     
     */
    public void setCapturedSignature(CapturedSignatureType value) {
        this.capturedSignature = value;
    }

    /**
     * Gets the value of the protectedSignature property.
     * 
     * @return
     *     possible object is
     *     {@link ContentInformationType }
     *     
     */
    public ContentInformationType getProtectedSignature() {
        return protectedSignature;
    }

    /**
     * Sets the value of the protectedSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentInformationType }
     *     
     */
    public void setProtectedSignature(ContentInformationType value) {
        this.protectedSignature = value;
    }

    /**
     * Gets the value of the paymentAcquirerData property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentAcquirerDataType }
     *     
     */
    public PaymentAcquirerDataType getPaymentAcquirerData() {
        return paymentAcquirerData;
    }

    /**
     * Sets the value of the paymentAcquirerData property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentAcquirerDataType }
     *     
     */
    public void setPaymentAcquirerData(PaymentAcquirerDataType value) {
        this.paymentAcquirerData = value;
    }

    /**
     * Gets the value of the paymentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentType() {
        if (paymentType == null) {
            return "Normal";
        } else {
            return paymentType;
        }
    }

    /**
     * Sets the value of the paymentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentType(String value) {
        this.paymentType = value;
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
     * {@link String }
     * 
     * 
     */
    public List<String> getAuthenticationMethod() {
        if (authenticationMethod == null) {
            authenticationMethod = new ArrayList<String>();
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
