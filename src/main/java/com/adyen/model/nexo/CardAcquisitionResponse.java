package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Card Acquisition Response messageType. -- Usage: It conveys Information related to the payment and loyalty cards read and processed by the POI System and entered by the Customer:As for the Payment request, the result of the CardAcquisition and the identification of the transaction.One
 *
 * <p>Java class for CardAcquisitionResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CardAcquisitionResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *         &lt;element name="SaleData" type="{}SaleData"/&gt;
 *         &lt;element name="POIData" type="{}POIData"/&gt;
 *         &lt;element name="PaymentBrand" type="{}PaymentBrand" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="PaymentInstrumentData" type="{}PaymentInstrumentData" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyAccount" type="{}LoyaltyAccount" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="CustomerOrder" type="{}CustomerOrder" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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

    /**
     * The Response.
     */
    @XmlElement(name = "Response", required = true)
    @Schema(description = "Result of a message request processing.")
    protected Response response;
    /**
     * The Sale data.
     */
    @XmlElement(name = "SaleData", required = true)
    @Schema(description = "Data related to the Sale System.")
    protected SaleData saleData;
    /**
     * The Poi data.
     */
    @XmlElement(name = "POIData", required = true)
    @Schema(description = "Data related to the POI System.")
    protected POIData poiData;
    /**
     * The Payment brand.
     */
    @XmlElement(name = "PaymentBrand")
    @Schema(description = "Type of payment card --Rule: Brands available for payment by the card and not chosen by the Customer")
    protected List<String> paymentBrand;
    /**
     * The Payment instrument data.
     */
    @XmlElement(name = "PaymentInstrumentData")
    @Schema(description = "Data related to the instrument of payment for the transaction. --Rule: If this type of payment card is configured to send information if the CardAcquisition response")
    protected PaymentInstrumentData paymentInstrumentData;
    /**
     * The Loyalty account.
     */
    @XmlElement(name = "LoyaltyAccount")
    @Schema(description = "Data related to a loyalty account processed in the transaction. --Rule: If loyalty card selected by the customer")
    protected List<LoyaltyAccount> loyaltyAccount;
    /**
     * The Customer order.
     */
    @XmlElement(name = "CustomerOrder")
    @Schema(description = "Customer order attached to a card, recorded in the POI system. --Rule: If the list of customer orders has been requested.")
    protected List<CustomerOrder> customerOrder;

    /**
     * Gets the value of the response property.
     *
     * @return possible      object is     {@link Response }
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value allowed object is     {@link Response }
     */
    public void setResponse(Response value) {
        this.response = value;
    }

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
     * Gets the value of the poiData property.
     *
     * @return possible      object is     {@link POIData }
     */
    public POIData getPOIData() {
        return poiData;
    }

    /**
     * Sets the value of the poiData property.
     *
     * @param value allowed object is     {@link POIData }
     */
    public void setPOIData(POIData value) {
        this.poiData = value;
    }

    /**
     * Gets the value of the paymentBrand property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentBrand property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentBrand().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     * @return the payment brand
     */
    public List<String> getPaymentBrand() {
        if (paymentBrand == null) {
            paymentBrand = new ArrayList<>();
        }
        return this.paymentBrand;
    }

    /**
     * Gets the value of the paymentInstrumentData property.
     *
     * @return possible      object is     {@link PaymentInstrumentData }
     */
    public PaymentInstrumentData getPaymentInstrumentData() {
        return paymentInstrumentData;
    }

    /**
     * Sets the value of the paymentInstrumentData property.
     *
     * @param value allowed object is     {@link PaymentInstrumentData }
     */
    public void setPaymentInstrumentData(PaymentInstrumentData value) {
        this.paymentInstrumentData = value;
    }

    /**
     * Gets the value of the loyaltyAccount property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loyaltyAccount property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoyaltyAccount().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LoyaltyAccount }
     *
     * @return the loyalty account
     */
    public List<LoyaltyAccount> getLoyaltyAccount() {
        if (loyaltyAccount == null) {
            loyaltyAccount = new ArrayList<>();
        }
        return this.loyaltyAccount;
    }

    /**
     * Gets the value of the customerOrder property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customerOrder property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomerOrder().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerOrder }
     *
     * @return the customer order
     */
    public List<CustomerOrder> getCustomerOrder() {
        if (customerOrder == null) {
            customerOrder = new ArrayList<>();
        }
        return this.customerOrder;
    }

}
