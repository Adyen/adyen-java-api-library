
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the account pointed by the payment card -- Usage: Information provided by the Sale System related to the payment account requesting a balance.
 *
 * <p>Java class for PaymentAccountReq complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PaymentAccountReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardAcquisitionReference" type="{}TransactionIdentification" minOccurs="0"/>
 *         &lt;element name="PaymentInstrumentData" type="{}PaymentInstrumentData" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Account" type="{}AccountType" default="Default" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentAccountReq", propOrder = {
    "cardAcquisitionReference",
    "paymentInstrumentData"
})
public class PaymentAccountReq {

    @XmlElement(name = "CardAcquisitionReference")
    protected TransactionIdentification cardAcquisitionReference;
    @XmlElement(name = "PaymentInstrumentData")
    protected PaymentInstrumentData paymentInstrumentData;
    @XmlAttribute(name = "Account")
    protected AccountType account;

    /**
     * Gets the value of the cardAcquisitionReference property.
     *
     * @return
     *     possible object is
     *     {@link TransactionIdentification }
     *
     */
    public TransactionIdentification getCardAcquisitionReference() {
        return cardAcquisitionReference;
    }

    /**
     * Sets the value of the cardAcquisitionReference property.
     *
     * @param value
     *     allowed object is
     *     {@link TransactionIdentification }
     *
     */
    public void setCardAcquisitionReference(TransactionIdentification value) {
        this.cardAcquisitionReference = value;
    }

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
     * Gets the value of the account property.
     *
     * @return
     *     possible object is
     *     {@link AccountType }
     *
     */
    public AccountType getAccount() {
        if (account == null) {
            return AccountType.DEFAULT;
        } else {
            return account;
        }
    }

    /**
     * Sets the value of the account property.
     *
     * @param value
     *     allowed object is
     *     {@link AccountType }
     *
     */
    public void setAccount(AccountType value) {
        this.account = value;
    }

}
