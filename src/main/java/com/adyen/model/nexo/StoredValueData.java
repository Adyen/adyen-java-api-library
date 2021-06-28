package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * Definition: Data related to the stored value card. -- Usage: It contains: - the identification of the stored value accounts or the stored value cards, if provided by the Sale System, and - the associated products sold by the Sale System..
 *
 * <p>Java class for StoredValueData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StoredValueData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StoredValueAccountID" type="{}StoredValueAccountID" minOccurs="0"/&gt;
 *         &lt;element name="OriginalPOITransaction" type="{}OriginalPOITransaction" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="StoredValueProvider" type="{}StoredValueProvider" /&gt;
 *       &lt;attribute name="StoredValueTransaction" use="required" type="{}StoredValueTransactionType" /&gt;
 *       &lt;attribute name="ProductCode" type="{}ProductCode" /&gt;
 *       &lt;attribute name="EanUpc" type="{}EanUpc" /&gt;
 *       &lt;attribute name="ItemAmount" use="required" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="Currency" use="required" type="{}ISOCurrency3A" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoredValueData", propOrder = {
        "storedValueAccountID",
        "originalPOITransaction"
})
public class StoredValueData {

    /**
     * The Stored value account id.
     */
    @XmlElement(name = "StoredValueAccountID")
    @Schema(description = "Identification of the stored value account or the stored value card --Rule: If the identification of the Stored Value account or card has been made by the Sale System before the request")
    protected StoredValueAccountID storedValueAccountID;
    /**
     * The Original poi transaction.
     */
    @XmlElement(name = "OriginalPOITransaction")
    @Schema(description = "Identification of a previous POI transaction. --Rule: if StoredValueTransactionType  is Reverse or Duplicate")
    protected OriginalPOITransaction originalPOITransaction;
    /**
     * The Stored value provider.
     */
    @XmlElement(name = "StoredValueProvider")
    @Schema(description = "Identification of the provider of the stored value account load/reload --Rule: If more than one provider to manage on the POI, and StoredValueAccountID absent.")
    protected String storedValueProvider;
    /**
     * The Stored value transaction.
     */
    @XmlElement(name = "StoredValueTransactionType", required = true)
    @Schema(description = "Identification of operation to proceed on the stored value account or the stored value card")
    protected StoredValueTransactionType storedValueTransactionType;
    /**
     * The Product code.
     */
    @XmlElement(name = "ProductCode")
    @Schema(description = "Product code of item purchased with the transaction.", minLength = 1, maxLength = 20)
    protected String productCode;
    /**
     * The Ean upc.
     */
    @XmlElement(name = "EanUpc")
    @Schema(description = "Standard product code of item purchased with the transaction.")
    protected String eanUpc;
    /**
     * The Item amount.
     */
    @XmlElement(name = "ItemAmount", required = true)
    @Schema(description = "Total amount of the item line.")
    protected BigDecimal itemAmount;
    /**
     * The Currency.
     */
    @XmlElement(name = "Currency", required = true)
    @Schema(description = "Currency of a monetary amount.")
    protected String currency;

    /**
     * Gets the value of the storedValueAccountID property.
     *
     * @return possible      object is     {@link StoredValueAccountID }
     */
    public StoredValueAccountID getStoredValueAccountID() {
        return storedValueAccountID;
    }

    /**
     * Sets the value of the storedValueAccountID property.
     *
     * @param value allowed object is     {@link StoredValueAccountID }
     */
    public void setStoredValueAccountID(StoredValueAccountID value) {
        this.storedValueAccountID = value;
    }

    /**
     * Gets the value of the originalPOITransaction property.
     *
     * @return possible      object is     {@link OriginalPOITransaction }
     */
    public OriginalPOITransaction getOriginalPOITransaction() {
        return originalPOITransaction;
    }

    /**
     * Sets the value of the originalPOITransaction property.
     *
     * @param value allowed object is     {@link OriginalPOITransaction }
     */
    public void setOriginalPOITransaction(OriginalPOITransaction value) {
        this.originalPOITransaction = value;
    }

    /**
     * Gets the value of the storedValueProvider property.
     *
     * @return possible      object is     {@link String }
     */
    public String getStoredValueProvider() {
        return storedValueProvider;
    }

    /**
     * Sets the value of the storedValueProvider property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setStoredValueProvider(String value) {
        this.storedValueProvider = value;
    }

    /**
     * Gets the value of the storedValueTransactionType property.
     *
     * @return possible      object is     {@link StoredValueTransactionType }
     */
    public StoredValueTransactionType getStoredValueTransactionType() {
        return storedValueTransactionType;
    }

    /**
     * Sets the value of the storedValueTransactionType property.
     *
     * @param value allowed object is     {@link StoredValueTransactionType }
     */
    public void setStoredValueTransactionType(StoredValueTransactionType value) {
        this.storedValueTransactionType = value;
    }

    /**
     * Gets the value of the productCode property.
     *
     * @return possible      object is     {@link String }
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Sets the value of the productCode property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setProductCode(String value) {
        this.productCode = value;
    }

    /**
     * Gets the value of the eanUpc property.
     *
     * @return possible      object is     {@link String }
     */
    public String getEanUpc() {
        return eanUpc;
    }

    /**
     * Sets the value of the eanUpc property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setEanUpc(String value) {
        this.eanUpc = value;
    }

    /**
     * Gets the value of the itemAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getItemAmount() {
        return itemAmount;
    }

    /**
     * Sets the value of the itemAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setItemAmount(BigDecimal value) {
        this.itemAmount = value;
    }

    /**
     * Gets the value of the currency property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

}
