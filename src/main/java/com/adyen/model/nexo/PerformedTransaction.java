package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Result of performed transactions. -- Usage: Contains result of transaction performed without the Sale system.
 *
 * <p>Java class for PerformedTransaction complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PerformedTransaction"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *         &lt;element name="SaleData" type="{}SaleData" minOccurs="0"/&gt;
 *         &lt;element name="POIData" type="{}POIData"/&gt;
 *         &lt;element name="PaymentResult" type="{}PaymentResult" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyResult" type="{}LoyaltyResult" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ReversedAmount" type="{}SimpleAmountType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PerformedTransaction", propOrder = {
        "response",
        "saleData",
        "poiData",
        "paymentResult",
        "loyaltyResult"
})
public class PerformedTransaction {

    /**
     * The Response.
     */
    @XmlElement(name = "Response", required = true)
    protected Response response;
    /**
     * The Sale data.
     */
    @XmlElement(name = "SaleData")
    protected SaleData saleData;
    /**
     * The Poi data.
     */
    @XmlElement(name = "POIData", required = true)
    protected POIData poiData;
    /**
     * The Payment result.
     */
    @XmlElement(name = "PaymentResult")
    protected PaymentResult paymentResult;
    /**
     * The Loyalty result.
     */
    @XmlElement(name = "LoyaltyResult")
    protected List<LoyaltyResult> loyaltyResult;
    /**
     * The Reversed amount.
     */
    @XmlAttribute(name = "ReversedAmount")
    protected BigDecimal reversedAmount;

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
     * Gets the value of the paymentResult property.
     *
     * @return possible      object is     {@link PaymentResult }
     */
    public PaymentResult getPaymentResult() {
        return paymentResult;
    }

    /**
     * Sets the value of the paymentResult property.
     *
     * @param value allowed object is     {@link PaymentResult }
     */
    public void setPaymentResult(PaymentResult value) {
        this.paymentResult = value;
    }

    /**
     * Gets the value of the loyaltyResult property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loyaltyResult property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoyaltyResult().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link LoyaltyResult }
     *
     * @return the loyalty result
     */
    public List<LoyaltyResult> getLoyaltyResult() {
        if (loyaltyResult == null) {
            loyaltyResult = new ArrayList<>();
        }
        return this.loyaltyResult;
    }

    /**
     * Gets the value of the reversedAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getReversedAmount() {
        return reversedAmount;
    }

    /**
     * Sets the value of the reversedAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setReversedAmount(BigDecimal value) {
        this.reversedAmount = value;
    }

}
