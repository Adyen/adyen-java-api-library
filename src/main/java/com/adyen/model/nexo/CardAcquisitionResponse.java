
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Card Acquisition Response message. -- Usage: It conveys Information related to the payment and loyalty cards read and processed by the POI System and entered by the Customer:As for the Payment request, the result of the CardAcquisition and the identification of the transaction.One
 *
 * <p>Java class for CardAcquisitionResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CardAcquisitionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}Response"/>
 *         &lt;element name="SaleData" type="{}SaleData"/>
 *         &lt;element name="POIData" type="{}POIData"/>
 *         &lt;element name="PaymentBrand" type="{}PaymentBrand" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PaymentInstrumentData" type="{}PaymentInstrumentData" minOccurs="0"/>
 *         &lt;element name="LoyaltyAccount" type="{}LoyaltyAccount" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "CardAcquisitionResponse", propOrder = {
    "response",
    "saleData",
    "poiData",
    "paymentBrand",
    "paymentInstrumentData",
    "loyaltyAccount",
    "customerOrder"
})
public class CardAcquisitionResponse {

    @XmlElement(name = "Response", required = true)
    protected Response response;
    @XmlElement(name = "SaleData", required = true)
    protected SaleData saleData;
    @XmlElement(name = "POIData", required = true)
    protected POIData poiData;
    @XmlElement(name = "PaymentBrand")
    protected List<String> paymentBrand;
    @XmlElement(name = "PaymentInstrumentData")
    protected PaymentInstrumentData paymentInstrumentData;
    @XmlElement(name = "LoyaltyAccount")
    protected List<LoyaltyAccount> loyaltyAccount;
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
     * Gets the value of the paymentBrand property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentBrand property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentBrand().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getPaymentBrand() {
        if (paymentBrand == null) {
            paymentBrand = new ArrayList<String>();
        }
        return this.paymentBrand;
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
     * Gets the value of the loyaltyAccount property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loyaltyAccount property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoyaltyAccount().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LoyaltyAccount }
     *
     *
     */
    public List<LoyaltyAccount> getLoyaltyAccount() {
        if (loyaltyAccount == null) {
            loyaltyAccount = new ArrayList<LoyaltyAccount>();
        }
        return this.loyaltyAccount;
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
