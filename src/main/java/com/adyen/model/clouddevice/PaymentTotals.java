package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.math.BigInteger;

/** Totals of the payment transaction during the reconciliation period. */
@JsonPropertyOrder({"TransactionType", "TransactionCount", "TransactionAmount"})
public class PaymentTotals {

  @JsonProperty("TransactionType")
  @Schema(
      description =
          "Type of transaction for which totals are grouped. --Rule: Debit, Credit, ReverseDebit, ReverseCredit, OneTimeReservation, CompletedDeffered, FirstReservation, UpdateReservation,")
  protected TransactionType transactionType;

  @JsonProperty("TransactionCount")
  @Schema(description = "Number of processed transaction during the period.")
  protected BigInteger transactionCount;

  @JsonProperty("TransactionAmount")
  @Schema(description = "Sum of amount of processed transaction during the period.")
  protected BigDecimal transactionAmount;

  /**
   * Gets transaction type.
   *
   * @return the transaction type
   */
  public TransactionType getTransactionType() {
    return transactionType;
  }

  /**
   * Sets transaction type.
   *
   * @param transactionType the transaction type
   */
  public void setTransactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
  }

  /**
   * Gets transaction count.
   *
   * @return the transaction count
   */
  public BigInteger getTransactionCount() {
    return transactionCount;
  }

  /**
   * Sets transaction count.
   *
   * @param transactionCount the transaction count
   */
  public void setTransactionCount(BigInteger transactionCount) {
    this.transactionCount = transactionCount;
  }

  /**
   * Gets transaction amount.
   *
   * @return the transaction amount
   */
  public BigDecimal getTransactionAmount() {
    return transactionAmount;
  }

  /**
   * Sets transaction amount.
   *
   * @param transactionAmount the transaction amount
   */
  public void setTransactionAmount(BigDecimal transactionAmount) {
    this.transactionAmount = transactionAmount;
  }
}
