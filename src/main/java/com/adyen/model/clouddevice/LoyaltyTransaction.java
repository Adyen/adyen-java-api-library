package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/** Data related to the loyalty transaction. */
@JsonPropertyOrder({
    "OriginalPOITransaction",
    "TransactionConditions",
    "SaleItem",
    "LoyaltyTransactionType",
    "Currency",
    "TotalAmount"
})
public class LoyaltyTransaction {

  @JsonProperty("OriginalPOITransaction")
  @Schema(
      description =
          "Identification of a previous POI transaction. --Rule: if LoyaltyTransactionType is \"AwardRefund\", \"RebateRefund\" or \"RedemptionRefund\"")
  protected OriginalPOITransaction originalPOITransaction;

  @JsonProperty("TransactionConditions")
  @Schema(
      description =
          "Conditions on which the transaction must be processed. --Rule: If one data element is present")
  protected TransactionConditions transactionConditions;

  @JsonProperty("SaleItem")
  @Schema(description = "Sale items of a transaction.")
  protected List<SaleItem> saleItem;

  @JsonProperty("LoyaltyTransactionType")
  @Schema(description = "Type of loyalty transaction.")
  protected LoyaltyTransactionType loyaltyTransactionType;

  @JsonProperty("Currency")
  @Schema(description = "Currency of a monetary amount.")
  protected String currency;

  @JsonProperty("TotalAmount")
  @Schema(description = "Amount of a transaction.")
  protected BigDecimal totalAmount;

  /**
   * Gets original poi transaction.
   *
   * @return the original poi transaction
   */
  public OriginalPOITransaction getOriginalPOITransaction() {
    return originalPOITransaction;
  }

  /**
   * Sets original poi transaction.
   *
   * @param originalPOITransaction the original poi transaction
   */
  public void setOriginalPOITransaction(OriginalPOITransaction originalPOITransaction) {
    this.originalPOITransaction = originalPOITransaction;
  }

  /**
   * Gets transaction conditions.
   *
   * @return the transaction conditions
   */
  public TransactionConditions getTransactionConditions() {
    return transactionConditions;
  }

  /**
   * Sets transaction conditions.
   *
   * @param transactionConditions the transaction conditions
   */
  public void setTransactionConditions(TransactionConditions transactionConditions) {
    this.transactionConditions = transactionConditions;
  }

  /**
   * Gets sale item.
   *
   * @return the sale item
   */
  public List<SaleItem> getSaleItem() {
    if (saleItem == null) {
      saleItem = new ArrayList<>();
    }
    return this.saleItem;
  }

  /**
   * Sets sale item.
   *
   * @param saleItem the sale item
   */
  public void setSaleItem(List<SaleItem> saleItem) {
    this.saleItem = saleItem;
  }

  /**
   * Gets loyalty transaction type.
   *
   * @return the loyalty transaction type
   */
  public LoyaltyTransactionType getLoyaltyTransactionType() {
    return loyaltyTransactionType;
  }

  /**
   * Sets loyalty transaction type.
   *
   * @param loyaltyTransactionType the loyalty transaction type
   */
  public void setLoyaltyTransactionType(LoyaltyTransactionType loyaltyTransactionType) {
    this.loyaltyTransactionType = loyaltyTransactionType;
  }

  /**
   * Gets currency.
   *
   * @return the currency
   */
  public String getCurrency() {
    return currency;
  }

  /**
   * Sets currency.
   *
   * @param currency the currency
   */
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  /**
   * Gets total amount.
   *
   * @return the total amount
   */
  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  /**
   * Sets total amount.
   *
   * @param totalAmount the total amount
   */
  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }
}