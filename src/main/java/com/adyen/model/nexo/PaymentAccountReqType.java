
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the account pointed by the payment card -- Usage: Information provided by the Sale System related to the payment account requesting a balance.
 * 
 * <p>Java class for PaymentAccountReqType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentAccountReqType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardAcquisitionReference" type="{}TransactionIdentificationType" minOccurs="0"/>
 *         &lt;element name="PaymentInstrumentData" type="{}PaymentInstrumentDataType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="AccountType" type="{}AccountTypeTypeCode" default="Default" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentAccountReqType", propOrder = {
    "cardAcquisitionReference",
    "paymentInstrumentData"
})
public class PaymentAccountReqType {

    @XmlElement(name = "CardAcquisitionReference")
    protected TransactionIdentificationType cardAcquisitionReference;
    @XmlElement(name = "PaymentInstrumentData")
    protected PaymentInstrumentDataType paymentInstrumentData;
    @XmlAttribute(name = "AccountType")
    protected String accountType;

    /**
     * Gets the value of the cardAcquisitionReference property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionIdentificationType }
     *     
     */
    public TransactionIdentificationType getCardAcquisitionReference() {
        return cardAcquisitionReference;
    }

    /**
     * Sets the value of the cardAcquisitionReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionIdentificationType }
     *     
     */
    public void setCardAcquisitionReference(TransactionIdentificationType value) {
        this.cardAcquisitionReference = value;
    }

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
     * Gets the value of the accountType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountType() {
        if (accountType == null) {
            return "Default";
        } else {
            return accountType;
        }
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountType(String value) {
        this.accountType = value;
    }

}
