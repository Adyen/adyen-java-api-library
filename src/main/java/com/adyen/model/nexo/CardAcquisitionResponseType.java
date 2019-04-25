
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
 * <p>Java class for CardAcquisitionResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardAcquisitionResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}ResponseType"/>
 *         &lt;element name="SaleData" type="{}SaleDataType"/>
 *         &lt;element name="POIData" type="{}POIDataType"/>
 *         &lt;element name="PaymentBrand" type="{}PaymentBrandType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PaymentInstrumentData" type="{}PaymentInstrumentDataType" minOccurs="0"/>
 *         &lt;element name="LoyaltyAccount" type="{}LoyaltyAccountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CustomerOrder" type="{}CustomerOrderType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardAcquisitionResponseType", propOrder = {
    "response",
    "saleData",
    "poiData",
    "paymentBrand",
    "paymentInstrumentData",
    "loyaltyAccount",
    "customerOrder"
})
public class CardAcquisitionResponseType {

    @XmlElement(name = "Response", required = true)
    protected ResponseType response;
    @XmlElement(name = "SaleData", required = true)
    protected SaleDataType saleData;
    @XmlElement(name = "POIData", required = true)
    protected POIDataType poiData;
    @XmlElement(name = "PaymentBrand")
    protected List<String> paymentBrand;
    @XmlElement(name = "PaymentInstrumentData")
    protected PaymentInstrumentDataType paymentInstrumentData;
    @XmlElement(name = "LoyaltyAccount")
    protected List<LoyaltyAccountType> loyaltyAccount;
    @XmlElement(name = "CustomerOrder")
    protected List<CustomerOrderType> customerOrder;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseType }
     *     
     */
    public ResponseType getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseType }
     *     
     */
    public void setResponse(ResponseType value) {
        this.response = value;
    }

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
     * Gets the value of the poiData property.
     * 
     * @return
     *     possible object is
     *     {@link POIDataType }
     *     
     */
    public POIDataType getPOIData() {
        return poiData;
    }

    /**
     * Sets the value of the poiData property.
     * 
     * @param value
     *     allowed object is
     *     {@link POIDataType }
     *     
     */
    public void setPOIData(POIDataType value) {
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
     * {@link LoyaltyAccountType }
     * 
     * 
     */
    public List<LoyaltyAccountType> getLoyaltyAccount() {
        if (loyaltyAccount == null) {
            loyaltyAccount = new ArrayList<LoyaltyAccountType>();
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
     * {@link CustomerOrderType }
     * 
     * 
     */
    public List<CustomerOrderType> getCustomerOrder() {
        if (customerOrder == null) {
            customerOrder = new ArrayList<CustomerOrderType>();
        }
        return this.customerOrder;
    }

}
