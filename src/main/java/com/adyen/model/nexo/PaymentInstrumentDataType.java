
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the instrument of payment for the transaction. -- Usage: Sent in the result of the payment transaction. For a card, it could also be sent in the CardAcquisition response, to be processed by the Sale System. In this case, the card or type of card has to be configured to have this behaviour. It is
 * 
 * <p>Java class for PaymentInstrumentDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentInstrumentDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardData" type="{}CardDataType" minOccurs="0"/>
 *         &lt;element name="CheckData" type="{}CheckDataType" minOccurs="0"/>
 *         &lt;element name="MobileData" type="{}MobileDataType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PaymentInstrumentType" use="required" type="{}PaymentInstrumentTypeTypeCode" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentInstrumentDataType", propOrder = {
    "cardData",
    "checkData",
    "mobileData"
})
public class PaymentInstrumentDataType {

    @XmlElement(name = "CardData")
    protected CardDataType cardData;
    @XmlElement(name = "CheckData")
    protected CheckDataType checkData;
    @XmlElement(name = "MobileData")
    protected MobileDataType mobileData;
    @XmlAttribute(name = "PaymentInstrumentType", required = true)
    protected String paymentInstrumentType;

    /**
     * Gets the value of the cardData property.
     * 
     * @return
     *     possible object is
     *     {@link CardDataType }
     *     
     */
    public CardDataType getCardData() {
        return cardData;
    }

    /**
     * Sets the value of the cardData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardDataType }
     *     
     */
    public void setCardData(CardDataType value) {
        this.cardData = value;
    }

    /**
     * Gets the value of the checkData property.
     * 
     * @return
     *     possible object is
     *     {@link CheckDataType }
     *     
     */
    public CheckDataType getCheckData() {
        return checkData;
    }

    /**
     * Sets the value of the checkData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckDataType }
     *     
     */
    public void setCheckData(CheckDataType value) {
        this.checkData = value;
    }

    /**
     * Gets the value of the mobileData property.
     * 
     * @return
     *     possible object is
     *     {@link MobileDataType }
     *     
     */
    public MobileDataType getMobileData() {
        return mobileData;
    }

    /**
     * Sets the value of the mobileData property.
     * 
     * @param value
     *     allowed object is
     *     {@link MobileDataType }
     *     
     */
    public void setMobileData(MobileDataType value) {
        this.mobileData = value;
    }

    /**
     * Gets the value of the paymentInstrumentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentInstrumentType() {
        return paymentInstrumentType;
    }

    /**
     * Sets the value of the paymentInstrumentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentInstrumentType(String value) {
        this.paymentInstrumentType = value;
    }

}
