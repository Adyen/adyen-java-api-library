package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
    @Schema(description = "Sensitive information related to the payment card, protected by CMS. --Rule: SensitiveCardData protected by CMS EnvelopedData")
    protected ContentInformation protectedCardData;
    /**
     * The Sensitive card data.
     */
    @XmlElement(name = "SensitiveCardData")
    @Schema(description = "Sensitive information related to the payment card, entered or read by the Sale System. --Rule: If structure non empty and unprotected")
    protected SensitiveCardData sensitiveCardData;
    /**
     * The Allowed product code.
     */
    @XmlElement(name = "AllowedProductCode")
    @Schema(description = "Product codes that are payable by the payment card. --Rule: If ErrorCondition is \"PaymentRestriction\", some products are not payable by the payment card (payment response).", minLength = 1, maxLength = 20)
    protected List<String> allowedProductCode;
    /**
     * The Allowed product.
     */
    @XmlElement(name = "AllowedProduct")
    @Schema(description = "Product that are payable by the payment card. --Rule: If the card has restrictions on product that can be purchased (card acquisition or balance inquiry response).")
    protected List<AllowedProduct> allowedProduct;
    /**
     * The Payment token.
     */
    @XmlElement(name = "PaymentToken")
    @Schema(description = "Surrogate of the PAN (Primary Account Number) of the payment card to identify the payment mean of the customer. --Rule: Present in If requested in CardAcquisitionResponse or PaymentResponse if requested in the request or in the Login")
    protected PaymentToken paymentToken;
    /**
     * The Customer order.
     */
    @XmlElement(name = "CustomerOrder")
    @Schema(description = "Customer order attached to a card, recorded in the POI system. --Rule: If the list of customer orders has been requested.")
    protected List<CustomerOrder> customerOrder;
    /**
     * The Payment brand.
     */
    @XmlElement(name = "PaymentBrand")
    @Schema(description = "Type of payment card --Rule: If card PAN is readable ")
    protected String paymentBrand;
    /**
     * The Masked pan.
     */
    @XmlElement(name = "MaskedPan")
    protected String maskedPAN;
    /**
     * The Payment account ref.
     */
    @XmlElement(name = "PaymentAccountRef")
    @Schema(description = "Reference of the PAN, which identifies the PAN or the card uniquely, named also PAR (Payment Account Reference). This --Rule: Mandatory if available.")
    protected String paymentAccountRef;
    /**
     * The Entry mode.
     */
    @XmlElement(name = "EntryMode")
    @Schema(description = "Entry mode of the payment instrument information --Rule: Mandatory in the request")
    protected List<EntryModeType> entryMode;
    /**
     * The Card country code.
     */
    @XmlElement(name = "CardCountryCode")
    @Schema(description = "Country Code attached to the card (3 numerics). --Rule: If available in the card", minLength = 3, maxLength = 3)
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
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedProductCode property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedProductCode().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
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
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedProduct property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedProduct().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
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
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entryMode property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntryMode().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
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
