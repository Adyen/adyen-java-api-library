package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Data related to the payment and loyalty transaction. */
@JsonPropertyOrder({"AmountsReq", "OriginalPOITransaction", "TransactionConditions", "SaleItem"})
public class PaymentTransaction {

  @JsonProperty("AmountsReq")
  @Schema(
      description =
          "Various amounts related to the payment and loyalty request from the Sale System.")
  protected AmountsReq amountsReq;

  @JsonProperty("OriginalPOITransaction")
  @Schema(
      description =
          "Identification of a previous POI transaction. --Rule: if UpdateReservation, Completion or Refund")
  protected OriginalPOITransaction originalPOITransaction;

  @JsonProperty("TransactionConditions")
  @Schema(
      description =
          "Conditions on which the transaction must be processed. --Rule: If one data element is present")
  protected TransactionConditions transactionConditions;

  @JsonProperty("SaleItem")
  @Schema(
      description =
          "Sale items of a transaction. --Rule: If purchased products are required for the payment")
  protected List<SaleItem> saleItem;

  /**
   * Gets amounts req.
   *
   * @return the amounts req
   */
  public AmountsReq getAmountsReq() {
    return amountsReq;
  }

  /**
   * Sets amounts req.
   *
   * @param amountsReq the amounts req
   */
  public void setAmountsReq(AmountsReq amountsReq) {
    this.amountsReq = amountsReq;
  }

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
}
