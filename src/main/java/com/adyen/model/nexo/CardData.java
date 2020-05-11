package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Information related to the payment card used for the transaction. -- Usage: Allows acquisition of the card data by the Sale System before the Payment, CardAcquisition  or BalanceInquiry request to the POI. It could also be sent in the CardAcquisition response, to be processed by the Sale System. In this case, the
 *
 * <p>Java class for CardData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CardData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ProtectedCardData" type="{}ContentInformation" minOccurs="0"/&gt;
 *         &lt;element name="SensitiveCardData" type="{}SensitiveCardData" minOccurs="0"/&gt;
 *         &lt;element name="AllowedProductCode" type="{}AllowedProductCode" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="AllowedProduct" type="{}AllowedProduct" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="PaymentToken" type="{}PaymentToken" minOccurs="0"/&gt;
 *         &lt;element name="CustomerOrder" type="{}CustomerOrder" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="PaymentBrand" type="{}PaymentBrand" /&gt;
 *       &lt;attribute name="MaskedPAN" type="{}MaskedPAN" /&gt;
 *       &lt;attribute name="PaymentAccountRef" type="{}PaymentAccountRef" /&gt;
 *       &lt;attribute name="EntryMode" type="{}EntryMode" /&gt;
 *       &lt;attribute name="CardCountryCode" type="{}CardCountryCode" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardData", propOrder = {
        "protectedCardData",
        "sensitiveCardData",
        "allowedProductCode",
        "allowedProduct",
        "paymentToken",
        "customerOrder"
})
public class CardData {

    /**
     * The Protected card data.
     */
    @XmlElement(name = "ProtectedCardData")
    protected ContentInformation protectedCardData;
    /**
     * The Sensitive card data.
     */
    @XmlElement(name = "SensitiveCardData")
    protected SensitiveCardData sensitiveCardData;
    /**
     * The Allowed product code.
     */
    @XmlElement(name = "AllowedProductCode")
    protected List<String> allowedProductCode;
    /**
     * The Allowed product.
     */
    @XmlElement(name = "AllowedProduct")
    protected List<AllowedProduct> allowedProduct;
    /**
     * The Payment token.
     */
    @XmlElement(name = "PaymentToken")
    protected PaymentToken paymentToken;
    /**
     * The Customer order.
     */
    @XmlElement(name = "CustomerOrder")
    protected List<CustomerOrder> customerOrder;
    /**
     * The Payment brand.
     */
    @XmlAttribute(name = "PaymentBrand")
    protected String paymentBrand;
    /**
     * The Masked pan.
     */
    @XmlAttribute(name = "MaskedPan")
    protected String maskedPAN;
    /**
     * The Payment account ref.
     */
    @XmlAttribute(name = "PaymentAccountRef")
    protected String paymentAccountRef;
    /**
     * The Entry mode.
     */
    @XmlAttribute(name = "EntryMode")
    protected List<EntryModeType> entryMode;
    /**
     * The Card country code.
     */
    @XmlAttribute(name = "CardCountryCode")
    protected String cardCountryCode;

    /**
     * Gets the value of the protectedCardData property.
     *
     * @return possible      object is     {@link ContentInformation }
     */
    public ContentInformation getProtectedCardData() {
        return protectedCardData;
    }

    /**
     * Sets the value of the protectedCardData property.
     *
     * @param value allowed object is     {@link ContentInformation }
     */
    public void setProtectedCardData(ContentInformation value) {
        this.protectedCardData = value;
    }

    /**
     * Gets the value of the sensitiveCardData property.
     *
     * @return possible      object is     {@link SensitiveCardData }
     */
    public SensitiveCardData getSensitiveCardData() {
        return sensitiveCardData;
    }

    /**
     * Sets the value of the sensitiveCardData property.
     *
     * @param value allowed object is     {@link SensitiveCardData }
     */
    public void setSensitiveCardData(SensitiveCardData value) {
        this.sensitiveCardData = value;
    }

    /**
     * Gets the value of the allowedProductCode property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedProductCode property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedProductCode().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     * @return the allowed product code
     */
    public List<String> getAllowedProductCode() {
        if (allowedProductCode == null) {
            allowedProductCode = new ArrayList<>();
        }
        return this.allowedProductCode;
    }

    /**
     * Gets the value of the allowedProduct property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedProduct property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedProduct().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link AllowedProduct }
     *
     * @return the allowed product
     */
    public List<AllowedProduct> getAllowedProduct() {
        if (allowedProduct == null) {
            allowedProduct = new ArrayList<>();
        }
        return this.allowedProduct;
    }

    /**
     * Gets the value of the paymentToken property.
     *
     * @return possible      object is     {@link PaymentToken }
     */
    public PaymentToken getPaymentToken() {
        return paymentToken;
    }

    /**
     * Sets the value of the paymentToken property.
     *
     * @param value allowed object is     {@link PaymentToken }
     */
    public void setPaymentToken(PaymentToken value) {
        this.paymentToken = value;
    }

    /**
     * Gets the value of the customerOrder property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customerOrder property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomerOrder().add(newItem);
     * </pre>
     *
     *
     *
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

    /**
     * Gets the value of the paymentBrand property.
     *
     * @return possible      object is     {@link String }
     */
    public String getPaymentBrand() {
        return paymentBrand;
    }

    /**
     * Sets the value of the paymentBrand property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setPaymentBrand(String value) {
        this.paymentBrand = value;
    }

    /**
     * Gets the value of the maskedPAN property.
     *
     * @return possible      object is     {@link String }
     */
    public String getMaskedPAN() {
        return maskedPAN;
    }

    /**
     * Sets the value of the maskedPAN property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setMaskedPAN(String value) {
        this.maskedPAN = value;
    }

    /**
     * Gets the value of the paymentAccountRef property.
     *
     * @return possible      object is     {@link String }
     */
    public String getPaymentAccountRef() {
        return paymentAccountRef;
    }

    /**
     * Sets the value of the paymentAccountRef property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setPaymentAccountRef(String value) {
        this.paymentAccountRef = value;
    }

    /**
     * Gets the value of the entryMode property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entryMode property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntryMode().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link EntryModeType }
     *
     * @return the entry mode
     */
    public List<EntryModeType> getEntryMode() {
        if (entryMode == null) {
            entryMode = new ArrayList<>();
        }
        return this.entryMode;
    }

    /**
     * Gets the value of the cardCountryCode property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCardCountryCode() {
        return cardCountryCode;
    }

    /**
     * Sets the value of the cardCountryCode property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCardCountryCode(String value) {
        this.cardCountryCode = value;
    }

}
