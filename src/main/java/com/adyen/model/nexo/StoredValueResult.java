package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * Definition: Result of loading/reloading a stored value card.. -- Usage: For each stored value card loaded or reloaded, in the StoredValue response messageType
 *
 * <p>Java class for StoredValueResult complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StoredValueResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StoredValueAccountStatus" type="{}StoredValueAccountStatus"/&gt;
 *         &lt;element name="HostTransactionID" type="{}TransactionIdentification" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="StoredValueTransaction" use="required" type="{}StoredValueTransactionType" /&gt;
 *       &lt;attribute name="ProductCode" use="required" type="{}ProductCode" /&gt;
 *       &lt;attribute name="EanUpc" type="{}EanUpc" /&gt;
 *       &lt;attribute name="ItemAmount" use="required" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="Currency" use="required" type="{}ISOCurrency3A" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoredValueResult", propOrder = {
        "storedValueAccountStatus",
        "hostTransactionID"
})
public class StoredValueResult {

    /**
     * The Stored value account status.
     */
    @XmlElement(name = "StoredValueAccountStatus", required = true)
    @Schema(description = "Data related to the result of the stored value card transaction.")
    protected StoredValueAccountStatus storedValueAccountStatus;
    /**
     * The Host transaction id.
     */
    @XmlElement(name = "HostTransactionID")
    @Schema(description = "Identification of the transaction by the host in charge of the stored value transaction --Rule: If provided by the Host")
    protected TransactionIdentification hostTransactionID;
    /**
     * The Stored value transaction.
     */
    @XmlElement(name = "StoredValueTransactionType", required = true)
    @Schema(description = "Identification of operation to proceed on the stored value account or the stored value card --Rule: Copy")
    protected StoredValueTransactionType storedValueTransactionType;
    /**
     * The Product code.
     */
    @XmlElement(name = "ProductCode", required = true)
    @Schema(description = "Product code of item purchased with the transaction. --Rule: Copy")
    protected String productCode;
    /**
     * The Ean upc.
     */
    @XmlElement(name = "EanUpc")
    @Schema(description = "Standard product code of item purchased with the transaction. --Rule: Copy")
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
    @Schema(description = "Currency of a monetary amount. --Rule: Copy")
    protected String currency;

    /**
     * Gets the value of the storedValueAccountStatus property.
     *
     * @return possible      object is     {@link StoredValueAccountStatus }
     */
    public StoredValueAccountStatus getStoredValueAccountStatus() {
        return storedValueAccountStatus;
    }

    /**
     * Sets the value of the storedValueAccountStatus property.
     *
     * @param value allowed object is     {@link StoredValueAccountStatus }
     */
    public void setStoredValueAccountStatus(StoredValueAccountStatus value) {
        this.storedValueAccountStatus = value;
    }

    /**
     * Gets the value of the hostTransactionID property.
     *
     * @return possible      object is     {@link TransactionIdentification }
     */
    public TransactionIdentification getHostTransactionID() {
        return hostTransactionID;
    }

    /**
     * Sets the value of the hostTransactionID property.
     *
     * @param value allowed object is     {@link TransactionIdentification }
     */
    public void setHostTransactionID(TransactionIdentification value) {
        this.hostTransactionID = value;
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
