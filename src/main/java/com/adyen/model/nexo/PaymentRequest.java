package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Payment Request messageType. -- Usage: It conveys Information related to the Payment transaction to process
 *
 * <p>Java class for PaymentRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PaymentRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SaleData" type="{}SaleData"/&gt;
 *         &lt;element name="PaymentTransaction" type="{}PaymentTransaction"/&gt;
 *         &lt;element name="PaymentData" type="{}PaymentData" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyData" type="{}LoyaltyData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentRequest", propOrder = {
        "saleData",
        "paymentTransaction",
        "paymentData",
        "loyaltyData"
})
public class PaymentRequest {

    /**
     * The Sale data.
     */
    @XmlElement(name = "SaleData", required = true)
    protected SaleData saleData;
    /**
     * The Payment transaction.
     */
    @XmlElement(name = "PaymentTransaction", required = true)
    protected PaymentTransaction paymentTransaction;
    /**
     * The Payment data.
     */
    @XmlElement(name = "PaymentData")
    protected PaymentData paymentData;
    /**
     * The Loyalty data.
     */
    @XmlElement(name = "LoyaltyData")
    protected List<LoyaltyData> loyaltyData;

    /**
     * Gets the value of the saleData property.
     *
     * @return possible      object is     {@link SaleData }
     */
    public SaleData getSaleData() {
        return saleData;
    }

    /**
     * Sets the value of the saleData property.
     *
     * @param value allowed object is     {@link SaleData }
     */
    public void setSaleData(SaleData value) {
        this.saleData = value;
    }

    /**
     * Gets the value of the paymentTransaction property.
     *
     * @return possible      object is     {@link PaymentTransaction }
     */
    public PaymentTransaction getPaymentTransaction() {
        return paymentTransaction;
    }

    /**
     * Sets the value of the paymentTransaction property.
     *
     * @param value allowed object is     {@link PaymentTransaction }
     */
    public void setPaymentTransaction(PaymentTransaction value) {
        this.paymentTransaction = value;
    }

    /**
     * Gets the value of the paymentData property.
     *
     * @return possible      object is     {@link PaymentData }
     */
    public PaymentData getPaymentData() {
        return paymentData;
    }

    /**
     * Sets the value of the paymentData property.
     *
     * @param value allowed object is     {@link PaymentData }
     */
    public void setPaymentData(PaymentData value) {
        this.paymentData = value;
    }

    /**
     * Gets the value of the loyaltyData property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loyaltyData property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoyaltyData().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link LoyaltyData }
     *
     * @return the loyalty data
     */
    public List<LoyaltyData> getLoyaltyData() {
        if (loyaltyData == null) {
            loyaltyData = new ArrayList<>();
        }
        return this.loyaltyData;
    }

}
