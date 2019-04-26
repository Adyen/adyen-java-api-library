
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Payment Response message. -- Usage: It conveys Information related to the Payment transaction processed by the POI System
 *
 * <p>Java class for PaymentResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PaymentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}Response"/>
 *         &lt;element name="SaleData" type="{}SaleData"/>
 *         &lt;element name="POIData" type="{}POIData"/>
 *         &lt;element name="PaymentResult" type="{}PaymentResult" minOccurs="0"/>
 *         &lt;element name="LoyaltyResult" type="{}LoyaltyResult" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PaymentReceipt" type="{}PaymentReceipt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CustomerOrder" type="{}CustomerOrder" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentResponse", propOrder = {
    "response",
    "saleData",
    "poiData",
    "paymentResult",
    "loyaltyResult",
    "paymentReceipt",
    "customerOrder"
})
public class PaymentResponse {

    @XmlElement(name = "Response", required = true)
    protected Response response;
    @XmlElement(name = "SaleData", required = true)
    protected SaleData saleData;
    @XmlElement(name = "POIData", required = true)
    protected POIData poiData;
    @XmlElement(name = "PaymentResult")
    protected PaymentResult paymentResult;
    @XmlElement(name = "LoyaltyResult")
    protected List<LoyaltyResult> loyaltyResult;
    @XmlElement(name = "PaymentReceipt")
    protected List<PaymentReceipt> paymentReceipt;
    @XmlElement(name = "CustomerOrder")
    protected List<CustomerOrder> customerOrder;

    /**
     * Gets the value of the response property.
     *
     * @return
     *     possible object is
     *     {@link Response }
     *
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value
     *     allowed object is
     *     {@link Response }
     *
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the saleData property.
     *
     * @return
     *     possible object is
     *     {@link SaleData }
     *
     */
    public SaleData getSaleData() {
        return saleData;
    }

    /**
     * Sets the value of the saleData property.
     *
     * @param value
     *     allowed object is
     *     {@link SaleData }
     *
     */
    public void setSaleData(SaleData value) {
        this.saleData = value;
    }

    /**
     * Gets the value of the poiData property.
     *
     * @return
     *     possible object is
     *     {@link POIData }
     *
     */
    public POIData getPOIData() {
        return poiData;
    }

    /**
     * Sets the value of the poiData property.
     *
     * @param value
     *     allowed object is
     *     {@link POIData }
     *
     */
    public void setPOIData(POIData value) {
        this.poiData = value;
    }

    /**
     * Gets the value of the paymentResult property.
     *
     * @return
     *     possible object is
     *     {@link PaymentResult }
     *
     */
    public PaymentResult getPaymentResult() {
        return paymentResult;
    }

    /**
     * Sets the value of the paymentResult property.
     *
     * @param value
     *     allowed object is
     *     {@link PaymentResult }
     *
     */
    public void setPaymentResult(PaymentResult value) {
        this.paymentResult = value;
    }

    /**
     * Gets the value of the loyaltyResult property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loyaltyResult property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoyaltyResult().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LoyaltyResult }
     *
     *
     */
    public List<LoyaltyResult> getLoyaltyResult() {
        if (loyaltyResult == null) {
            loyaltyResult = new ArrayList<LoyaltyResult>();
        }
        return this.loyaltyResult;
    }

    /**
     * Gets the value of the paymentReceipt property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentReceipt property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentReceipt().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentReceipt }
     *
     *
     */
    public List<PaymentReceipt> getPaymentReceipt() {
        if (paymentReceipt == null) {
            paymentReceipt = new ArrayList<PaymentReceipt>();
        }
        return this.paymentReceipt;
    }

    /**
     * Gets the value of the customerOrder property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customerOrder property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomerOrder().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerOrder }
     *
     *
     */
    public List<CustomerOrder> getCustomerOrder() {
        if (customerOrder == null) {
            customerOrder = new ArrayList<CustomerOrder>();
        }
        return this.customerOrder;
    }

}
