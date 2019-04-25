
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Information related to the payment card used for the transaction. -- Usage: Allows acquisition of the card data by the Sale System before the Payment, CardAcquisition  or BalanceInquiry request to the POI. It could also be sent in the CardAcquisition response, to be processed by the Sale System. In this case, the
 * 
 * <p>Java class for CardDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProtectedCardData" type="{}ContentInformationType" minOccurs="0"/>
 *         &lt;element name="SensitiveCardData" type="{}SensitiveCardDataType" minOccurs="0"/>
 *         &lt;element name="AllowedProductCode" type="{}AllowedProductCodeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AllowedProduct" type="{}AllowedProductType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PaymentToken" type="{}PaymentTokenType" minOccurs="0"/>
 *         &lt;element name="CustomerOrder" type="{}CustomerOrderType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PaymentBrand" type="{}PaymentBrandType" />
 *       &lt;attribute name="MaskedPAN" type="{}MaskedPANType" />
 *       &lt;attribute name="PaymentAccountRef" type="{}PaymentAccountRefType" />
 *       &lt;attribute name="EntryMode" type="{}EntryModeType" />
 *       &lt;attribute name="CardCountryCode" type="{}CardCountryCodeType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardDataType", propOrder = {
    "protectedCardData",
    "sensitiveCardData",
    "allowedProductCode",
    "allowedProduct",
    "paymentToken",
    "customerOrder"
})
public class CardDataType {

    @XmlElement(name = "ProtectedCardData")
    protected ContentInformationType protectedCardData;
    @XmlElement(name = "SensitiveCardData")
    protected SensitiveCardDataType sensitiveCardData;
    @XmlElement(name = "AllowedProductCode")
    protected List<String> allowedProductCode;
    @XmlElement(name = "AllowedProduct")
    protected List<AllowedProductType> allowedProduct;
    @XmlElement(name = "PaymentToken")
    protected PaymentTokenType paymentToken;
    @XmlElement(name = "CustomerOrder")
    protected List<CustomerOrderType> customerOrder;
    @XmlAttribute(name = "PaymentBrand")
    protected String paymentBrand;
    @XmlAttribute(name = "MaskedPAN")
    protected String maskedPAN;
    @XmlAttribute(name = "PaymentAccountRef")
    protected String paymentAccountRef;
    @XmlAttribute(name = "EntryMode")
    protected List<String> entryMode;
    @XmlAttribute(name = "CardCountryCode")
    protected String cardCountryCode;

    /**
     * Gets the value of the protectedCardData property.
     * 
     * @return
     *     possible object is
     *     {@link ContentInformationType }
     *     
     */
    public ContentInformationType getProtectedCardData() {
        return protectedCardData;
    }

    /**
     * Sets the value of the protectedCardData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentInformationType }
     *     
     */
    public void setProtectedCardData(ContentInformationType value) {
        this.protectedCardData = value;
    }

    /**
     * Gets the value of the sensitiveCardData property.
     * 
     * @return
     *     possible object is
     *     {@link SensitiveCardDataType }
     *     
     */
    public SensitiveCardDataType getSensitiveCardData() {
        return sensitiveCardData;
    }

    /**
     * Sets the value of the sensitiveCardData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SensitiveCardDataType }
     *     
     */
    public void setSensitiveCardData(SensitiveCardDataType value) {
        this.sensitiveCardData = value;
    }

    /**
     * Gets the value of the allowedProductCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedProductCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedProductCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAllowedProductCode() {
        if (allowedProductCode == null) {
            allowedProductCode = new ArrayList<String>();
        }
        return this.allowedProductCode;
    }

    /**
     * Gets the value of the allowedProduct property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedProduct property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedProduct().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllowedProductType }
     * 
     * 
     */
    public List<AllowedProductType> getAllowedProduct() {
        if (allowedProduct == null) {
            allowedProduct = new ArrayList<AllowedProductType>();
        }
        return this.allowedProduct;
    }

    /**
     * Gets the value of the paymentToken property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTokenType }
     *     
     */
    public PaymentTokenType getPaymentToken() {
        return paymentToken;
    }

    /**
     * Sets the value of the paymentToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTokenType }
     *     
     */
    public void setPaymentToken(PaymentTokenType value) {
        this.paymentToken = value;
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

    /**
     * Gets the value of the paymentBrand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentBrand() {
        return paymentBrand;
    }

    /**
     * Sets the value of the paymentBrand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentBrand(String value) {
        this.paymentBrand = value;
    }

    /**
     * Gets the value of the maskedPAN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaskedPAN() {
        return maskedPAN;
    }

    /**
     * Sets the value of the maskedPAN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaskedPAN(String value) {
        this.maskedPAN = value;
    }

    /**
     * Gets the value of the paymentAccountRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentAccountRef() {
        return paymentAccountRef;
    }

    /**
     * Sets the value of the paymentAccountRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentAccountRef(String value) {
        this.paymentAccountRef = value;
    }

    /**
     * Gets the value of the entryMode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entryMode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntryMode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEntryMode() {
        if (entryMode == null) {
            entryMode = new ArrayList<String>();
        }
        return this.entryMode;
    }

    /**
     * Gets the value of the cardCountryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardCountryCode() {
        return cardCountryCode;
    }

    /**
     * Sets the value of the cardCountryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardCountryCode(String value) {
        this.cardCountryCode = value;
    }

}
