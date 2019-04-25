
package com.adyen.model.nexo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Result of performed transactions. -- Usage: Contains result of transaction performed without the Sale system.
 * 
 * <p>Java class for PerformedTransactionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PerformedTransactionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}ResponseType"/>
 *         &lt;element name="SaleData" type="{}SaleDataType" minOccurs="0"/>
 *         &lt;element name="POIData" type="{}POIDataType"/>
 *         &lt;element name="PaymentResult" type="{}PaymentResultType" minOccurs="0"/>
 *         &lt;element name="LoyaltyResult" type="{}LoyaltyResultType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ReversedAmount" type="{}SimpleAmountType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PerformedTransactionType", propOrder = {
    "response",
    "saleData",
    "poiData",
    "paymentResult",
    "loyaltyResult"
})
public class PerformedTransactionType {

    @XmlElement(name = "Response", required = true)
    protected ResponseType response;
    @XmlElement(name = "SaleData")
    protected SaleDataType saleData;
    @XmlElement(name = "POIData", required = true)
    protected POIDataType poiData;
    @XmlElement(name = "PaymentResult")
    protected PaymentResultType paymentResult;
    @XmlElement(name = "LoyaltyResult")
    protected List<LoyaltyResultType> loyaltyResult;
    @XmlAttribute(name = "ReversedAmount")
    protected BigDecimal reversedAmount;

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
     * Gets the value of the paymentResult property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentResultType }
     *     
     */
    public PaymentResultType getPaymentResult() {
        return paymentResult;
    }

    /**
     * Sets the value of the paymentResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentResultType }
     *     
     */
    public void setPaymentResult(PaymentResultType value) {
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
     * {@link LoyaltyResultType }
     * 
     * 
     */
    public List<LoyaltyResultType> getLoyaltyResult() {
        if (loyaltyResult == null) {
            loyaltyResult = new ArrayList<LoyaltyResultType>();
        }
        return this.loyaltyResult;
    }

    /**
     * Gets the value of the reversedAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getReversedAmount() {
        return reversedAmount;
    }

    /**
     * Sets the value of the reversedAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setReversedAmount(BigDecimal value) {
        this.reversedAmount = value;
    }

}
