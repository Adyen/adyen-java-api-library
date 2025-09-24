package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

/** Various amounts related to the payment and loyalty request from the Sale System. */
public class AmountsReq {

  @JsonProperty("Currency")
  @Schema(description = "Currency of a monetary amount.")
  protected String currency;

  @JsonProperty("RequestedAmount")
  @Schema(
      description =
          "Amount requested by the Sale for the payment. --Rule: Absent if the maximum amount is unknown for a OneTimeReservationThe value has to be greater than 0.")
  protected BigDecimal requestedAmount;

  @JsonProperty("CashBackAmount")
  @Schema(
      description =
          "The cash-back part of the amount requested by the Sale for the payment. --Rule: if payment with cash back. This data has to be performed by the POI. If cash back is not allowed, the payment is")
  protected BigDecimal cashBackAmount;

  @JsonProperty("TipAmount")
  @Schema(
      description =
          "Amount paid for a tip. --Rule: If payment with tip requested by the Sale System.")
  protected BigDecimal tipAmount;

  @JsonProperty("PaidAmount")
  @Schema(
      description =
          "Amount already paid amount in case of split payment. --Rule: If SplitPaymentFlag is True (split amount of a split payment).")
  protected BigDecimal paidAmount;

  @JsonProperty("MinimumAmountToDeliver")
  @Schema(
      description =
          "Minimum amount the Sale System is allowed to deliver for this payment. --Rule: if unknown maximum amount for a OneTimeReservation or minimum amount requested by the Sale System")
  protected BigDecimal minimumAmountToDeliver;

  @JsonProperty("MaximumCashBackAmount")
  @Schema(
      description =
          "Maximum amount which could be requested for cash-back to the Sale System. --Rule: Maximum amount which could be requested for cash-back to the Sale System.")
  protected BigDecimal maximumCashBackAmount;

  @JsonProperty("MinimumSplitAmount")
  @Schema(
      description =
          "Minimum amount of a split, which could be requested by a Customer. --Rule: Minimum amount of a split, which could be requested.")
  protected BigDecimal minimumSplitAmount;

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
   * Gets requested amount.
   *
   * @return the requested amount
   */
  public BigDecimal getRequestedAmount() {
    return requestedAmount;
  }

  /**
   * Sets requested amount.
   *
   * @param requestedAmount the requested amount
   */
  public void setRequestedAmount(BigDecimal requestedAmount) {
    this.requestedAmount = requestedAmount;
  }

  /**
   * Gets cash back amount.
   *
   * @return the cash back amount
   */
  public BigDecimal getCashBackAmount() {
    return cashBackAmount;
  }

  /**
   * Sets cash back amount.
   *
   * @param cashBackAmount the cash back amount
   */
  public void setCashBackAmount(BigDecimal cashBackAmount) {
    this.cashBackAmount = cashBackAmount;
  }

  /**
   * Gets tip amount.
   *
   * @return the tip amount
   */
  public BigDecimal getTipAmount() {
    return tipAmount;
  }

  /**
   * Sets tip amount.
   *
   * @param tipAmount the tip amount
   */
  public void setTipAmount(BigDecimal tipAmount) {
    this.tipAmount = tipAmount;
  }

  /**
   * Gets paid amount.
   *
   * @return the paid amount
   */
  public BigDecimal getPaidAmount() {
    return paidAmount;
  }

  /**
   * Sets paid amount.
   *
   * @param paidAmount the paid amount
   */
  public void setPaidAmount(BigDecimal paidAmount) {
    this.paidAmount = paidAmount;
  }

  /**
   * Gets minimum amount to deliver.
   *
   * @return the minimum amount to deliver
   */
  public BigDecimal getMinimumAmountToDeliver() {
    return minimumAmountToDeliver;
  }

  /**
   * Sets minimum amount to deliver.
   *
   * @param minimumAmountToDeliver the minimum amount to deliver
   */
  public void setMinimumAmountToDeliver(BigDecimal minimumAmountToDeliver) {
    this.minimumAmountToDeliver = minimumAmountToDeliver;
  }

  /**
   * Gets maximum cash back amount.
   *
   * @return the maximum cash back amount
   */
  public BigDecimal getMaximumCashBackAmount() {
    return maximumCashBackAmount;
  }

  /**
   * Sets maximum cash back amount.
   *
   * @param maximumCashBackAmount the maximum cash back amount
   */
  public void setMaximumCashBackAmount(BigDecimal maximumCashBackAmount) {
    this.maximumCashBackAmount = maximumCashBackAmount;
  }

  /**
   * Gets minimum split amount.
   *
   * @return the minimum split amount
   */
  public BigDecimal getMinimumSplitAmount() {
    return minimumSplitAmount;
  }

  /**
   * Sets minimum split amount.
   *
   * @param minimumSplitAmount the minimum split amount
   */
  public void setMinimumSplitAmount(BigDecimal minimumSplitAmount) {
    this.minimumSplitAmount = minimumSplitAmount;
  }
}
