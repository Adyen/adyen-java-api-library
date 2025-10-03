package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

public class StoredValueData {

  /** The Stored value account id. */
  @JsonProperty("StoredValueAccountID")
  @Schema(
      description =
          "Identification of the stored value account or the stored value card --Rule: If the identification of the Stored Value account or card has been made by the Sale System before the request")
  protected StoredValueAccountID storedValueAccountID;

  /** The Original poi transaction. */
  @JsonProperty("OriginalPOITransaction")
  @Schema(
      description =
          "Identification of a previous POI transaction. --Rule: if StoredValueTransactionType  is Reverse or Duplicate")
  protected OriginalPOITransaction originalPOITransaction;

  /** The Stored value provider. */
  @JsonProperty("StoredValueProvider")
  @Schema(
      description =
          "Identification of the provider of the stored value account load/reload --Rule: If more than one provider to manage on the POI, and StoredValueAccountID absent.")
  protected String storedValueProvider;

  /** The Stored value transaction. */
  @JsonProperty("StoredValueTransactionType")
  @Schema(
      description =
          "Identification of operation to proceed on the stored value account or the stored value card")
  protected StoredValueTransactionType storedValueTransactionType;

  /** The Product code. */
  @JsonProperty("ProductCode")
  @Schema(
      description = "Product code of item purchased with the transaction.",
      minLength = 1,
      maxLength = 20)
  protected String productCode;

  /** The Ean upc. */
  @JsonProperty("EanUpc")
  @Schema(description = "Standard product code of item purchased with the transaction.")
  protected String eanUpc;

  /** The Item amount. */
  @JsonProperty("ItemAmount")
  @Schema(description = "Total amount of the item line.")
  protected BigDecimal itemAmount;

  /** The Currency. */
  @JsonProperty("Currency")
  @Schema(description = "Currency of a monetary amount.")
  protected String currency;

  /**
   * Gets the value of the storedValueAccountID property.
   *
   * @return possible object is {@link StoredValueAccountID }
   */
  public StoredValueAccountID getStoredValueAccountID() {
    return storedValueAccountID;
  }

  /**
   * Sets the value of the storedValueAccountID property.
   *
   * @param value allowed object is {@link StoredValueAccountID }
   */
  public void setStoredValueAccountID(StoredValueAccountID value) {
    this.storedValueAccountID = value;
  }

  /**
   * Gets the value of the originalPOITransaction property.
   *
   * @return possible object is {@link OriginalPOITransaction }
   */
  public OriginalPOITransaction getOriginalPOITransaction() {
    return originalPOITransaction;
  }

  /**
   * Sets the value of the originalPOITransaction property.
   *
   * @param value allowed object is {@link OriginalPOITransaction }
   */
  public void setOriginalPOITransaction(OriginalPOITransaction value) {
    this.originalPOITransaction = value;
  }

  /**
   * Gets the value of the storedValueProvider property.
   *
   * @return possible object is {@link String }
   */
  public String getStoredValueProvider() {
    return storedValueProvider;
  }

  /**
   * Sets the value of the storedValueProvider property.
   *
   * @param value allowed object is {@link String }
   */
  public void setStoredValueProvider(String value) {
    this.storedValueProvider = value;
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
