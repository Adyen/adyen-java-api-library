package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

public class StoredValueResult {

  /** The Stored value account status. */
  @JsonProperty("StoredValueAccountStatus")
  @Schema(description = "Data related to the result of the stored value card transaction.")
  protected StoredValueAccountStatus storedValueAccountStatus;

  /** The Host transaction id. */
  @JsonProperty("HostTransactionID")
  @Schema(
      description =
          "Identification of the transaction by the host in charge of the stored value transaction --Rule: If provided by the Host")
  protected TransactionIdentification hostTransactionID;

  /** The Stored value transaction. */
  @JsonProperty("StoredValueTransactionType")
  @Schema(
      description =
          "Identification of operation to proceed on the stored value account or the stored value card --Rule: Copy")
  protected StoredValueTransactionType storedValueTransactionType;

  /** The Product code. */
  @JsonProperty("ProductCode")
  @Schema(description = "Product code of item purchased with the transaction. --Rule: Copy")
  protected String productCode;

  /** The Ean upc. */
  @JsonProperty("EanUpc")
  @Schema(
      description = "Standard product code of item purchased with the transaction. --Rule: Copy")
  protected String eanUpc;

  /** The Item amount. */
  @JsonProperty("ItemAmount")
  @Schema(description = "Total amount of the item line.")
  protected BigDecimal itemAmount;

  /** The Currency. */
  @JsonProperty("Currency")
  @Schema(description = "Currency of a monetary amount. --Rule: Copy")
  protected String currency;

  /**
   * Gets the value of the storedValueAccountStatus property.
   *
   * @return possible object is {@link StoredValueAccountStatus }
   */
  public StoredValueAccountStatus getStoredValueAccountStatus() {
    return storedValueAccountStatus;
  }

  /**
   * Sets the value of the storedValueAccountStatus property.
   *
   * @param value allowed object is {@link StoredValueAccountStatus }
   */
  public void setStoredValueAccountStatus(StoredValueAccountStatus value) {
    this.storedValueAccountStatus = value;
  }

  /**
   * Gets the value of the hostTransactionID property.
   *
   * @return possible object is {@link TransactionIdentification }
   */
  public TransactionIdentification getHostTransactionID() {
    return hostTransactionID;
  }

  /**
   * Sets the value of the hostTransactionID property.
   *
   * @param value allowed object is {@link TransactionIdentification }
   */
  public void setHostTransactionID(TransactionIdentification value) {
    this.hostTransactionID = value;
  }

  /**
   * Gets the value of the storedValueTransactionType property.
   *
   * @return possible object is {@link StoredValueTransactionType }
   */
  public StoredValueTransactionType getStoredValueTransactionType() {
    return storedValueTransactionType;
  }

  /**
   * Sets the value of the storedValueTransactionType property.
   *
   * @param value allowed object is {@link StoredValueTransactionType }
   */
  public void setStoredValueTransactionType(StoredValueTransactionType value) {
    this.storedValueTransactionType = value;
  }

  /**
   * Gets the value of the productCode property.
   *
   * @return possible object is {@link String }
   */
  public String getProductCode() {
    return productCode;
  }

  /**
   * Sets the value of the productCode property.
   *
   * @param value allowed object is {@link String }
   */
  public void setProductCode(String value) {
    this.productCode = value;
  }

  /**
   * Gets the value of the eanUpc property.
   *
   * @return possible object is {@link String }
   */
  public String getEanUpc() {
    return eanUpc;
  }

  /**
   * Sets the value of the eanUpc property.
   *
   * @param value allowed object is {@link String }
   */
  public void setEanUpc(String value) {
    this.eanUpc = value;
  }

  /**
   * Gets the value of the itemAmount property.
   *
   * @return possible object is {@link BigDecimal }
   */
  public BigDecimal getItemAmount() {
    return itemAmount;
  }

  /**
   * Sets the value of the itemAmount property.
   *
   * @param value allowed object is {@link BigDecimal }
   */
  public void setItemAmount(BigDecimal value) {
    this.itemAmount = value;
  }

  /**
   * Gets the value of the currency property.
   *
   * @return possible object is {@link String }
   */
  public String getCurrency() {
    return currency;
  }

  /**
   * Sets the value of the currency property.
   *
   * @param value allowed object is {@link String }
   */
  public void setCurrency(String value) {
    this.currency = value;
  }
}
