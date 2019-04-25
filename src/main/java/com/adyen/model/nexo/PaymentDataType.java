
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the payment transaction. -- Usage: Elements requested by the Sale System that are related to the payment only.
 * 
 * <p>Java class for PaymentDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardAcquisitionReference" type="{}TransactionIdentificationType" minOccurs="0"/>
 *         &lt;element name="RequestedValidityDate" type="{}ISODate" minOccurs="0"/>
 *         &lt;element name="Instalment" type="{}InstalmentType" minOccurs="0"/>
 *         &lt;element name="CustomerOrder" type="{}CustomerOrderType" minOccurs="0"/>
 *         &lt;element name="PaymentInstrumentData" type="{}PaymentInstrumentDataType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PaymentType" type="{}PaymentTypeTypeCode" default="Normal" />
 *       &lt;attribute name="SplitPaymentFlag" type="{}SplitPaymentFlagType" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentDataType", propOrder = {
    "cardAcquisitionReference",
    "requestedValidityDate",
    "instalment",
    "customerOrder",
    "paymentInstrumentData"
})
public class PaymentDataType {

    @XmlElement(name = "CardAcquisitionReference")
    protected TransactionIdentificationType cardAcquisitionReference;
    @XmlElement(name = "RequestedValidityDate")
    protected String requestedValidityDate;
    @XmlElement(name = "Instalment")
    protected InstalmentType instalment;
    @XmlElement(name = "CustomerOrder")
    protected CustomerOrderType customerOrder;
    @XmlElement(name = "PaymentInstrumentData")
    protected PaymentInstrumentDataType paymentInstrumentData;
    @XmlAttribute(name = "PaymentType")
    protected String paymentType;
    @XmlAttribute(name = "SplitPaymentFlag")
    protected Boolean splitPaymentFlag;

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
     * Gets the value of the requestedValidityDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestedValidityDate() {
        return requestedValidityDate;
    }

    /**
     * Sets the value of the requestedValidityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestedValidityDate(String value) {
        this.requestedValidityDate = value;
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
     * Gets the value of the customerOrder property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerOrderType }
     *     
     */
    public CustomerOrderType getCustomerOrder() {
        return customerOrder;
    }

    /**
     * Sets the value of the customerOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerOrderType }
     *     
     */
    public void setCustomerOrder(CustomerOrderType value) {
        this.customerOrder = value;
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
     * Gets the value of the splitPaymentFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isSplitPaymentFlag() {
        if (splitPaymentFlag == null) {
            return false;
        } else {
            return splitPaymentFlag;
        }
    }

    /**
     * Sets the value of the splitPaymentFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSplitPaymentFlag(Boolean value) {
        this.splitPaymentFlag = value;
    }

}
