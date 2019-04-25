
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Payment Request message. -- Usage: It conveys Information related to the Payment transaction to process
 * 
 * <p>Java class for PaymentRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SaleData" type="{}SaleDataType"/>
 *         &lt;element name="PaymentTransaction" type="{}PaymentTransactionType"/>
 *         &lt;element name="PaymentData" type="{}PaymentDataType" minOccurs="0"/>
 *         &lt;element name="LoyaltyData" type="{}LoyaltyDataType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentRequestType", propOrder = {
    "saleData",
    "paymentTransaction",
    "paymentData",
    "loyaltyData"
})
public class PaymentRequestType {

    @XmlElement(name = "SaleData", required = true)
    protected SaleDataType saleData;
    @XmlElement(name = "PaymentTransaction", required = true)
    protected PaymentTransactionType paymentTransaction;
    @XmlElement(name = "PaymentData")
    protected PaymentDataType paymentData;
    @XmlElement(name = "LoyaltyData")
    protected List<LoyaltyDataType> loyaltyData;

    /**
     * Gets the value of the saleData property.
     * 
     * @return
     *     possible object is
     *     {@link SaleDataType }
     *     
     */
    public SaleDataType getSaleData() {
        return saleData;
    }

    /**
     * Sets the value of the saleData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaleDataType }
     *     
     */
    public void setSaleData(SaleDataType value) {
        this.saleData = value;
    }

    /**
     * Gets the value of the paymentTransaction property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTransactionType }
     *     
     */
    public PaymentTransactionType getPaymentTransaction() {
        return paymentTransaction;
    }

    /**
     * Sets the value of the paymentTransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTransactionType }
     *     
     */
    public void setPaymentTransaction(PaymentTransactionType value) {
        this.paymentTransaction = value;
    }

    /**
     * Gets the value of the paymentData property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentDataType }
     *     
     */
    public PaymentDataType getPaymentData() {
        return paymentData;
    }

    /**
     * Sets the value of the paymentData property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentDataType }
     *     
     */
    public void setPaymentData(PaymentDataType value) {
        this.paymentData = value;
    }

    /**
     * Gets the value of the loyaltyData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loyaltyData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoyaltyData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LoyaltyDataType }
     * 
     * 
     */
    public List<LoyaltyDataType> getLoyaltyData() {
        if (loyaltyData == null) {
            loyaltyData = new ArrayList<LoyaltyDataType>();
        }
        return this.loyaltyData;
    }

}
