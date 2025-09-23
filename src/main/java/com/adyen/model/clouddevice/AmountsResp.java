package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

/** Various amounts related to the payment response from the POI System. */
public class AmountsResp {

  @JsonProperty("Currency")
  @Schema(description = "Currency of a monetary amount. --Rule: Mandatory for currency conversion.")
  protected String currency;

  @JsonProperty("AuthorizedAmount")
  @Schema(description = "The amount authorized by the Acquirer for the payment transaction.")
  protected BigDecimal authorizedAmount;

  @JsonProperty("TotalRebatesAmount")
  @Schema(
      description =
          "Sum of rebates in amount (total amount or line item amount) for all the loyalty programs.")
  protected BigDecimal totalRebatesAmount;

  @JsonProperty("TotalFeesAmount")
  @Schema(description = "Total amount of financial fees.")
  protected BigDecimal totalFeesAmount;

  @JsonProperty("CashBackAmount")
  @Schema(
      description =
          "The cash-back part of the amount requested by the Sale for the payment. --Rule: if payment with cash back")
  protected BigDecimal cashBackAmount;

  @JsonProperty("TipAmount")
  @Schema(
      description =
          "Amount paid for a tip. --Rule: If payment with tip requested by the Sale System.")
  protected BigDecimal tipAmount;

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
   * Gets authorized amount.
   *
   * @return the authorized amount
   */
  public BigDecimal getAuthorizedAmount() {
    return authorizedAmount;
  }

  /**
   * Sets authorized amount.
   *
   * @param authorizedAmount the authorized amount
   */
  public void setAuthorizedAmount(BigDecimal authorizedAmount) {
    this.authorizedAmount = authorizedAmount;
  }

  /**
   * Gets total rebates amount.
   *
   * @return the total rebates amount
   */
  public BigDecimal getTotalRebatesAmount() {
    return totalRebatesAmount;
  }

  /**
   * Sets total rebates amount.
   *
   * @param totalRebatesAmount the total rebates amount
   */
  public void setTotalRebatesAmount(BigDecimal totalRebatesAmount) {
    this.totalRebatesAmount = totalRebatesAmount;
  }

  /**
   * Gets total fees amount.
   *
   * @return the total fees amount
   */
  public BigDecimal getTotalFeesAmount() {
    return totalFeesAmount;
  }

  /**
   * Sets total fees amount.
   *
   * @param totalFeesAmount the total fees amount
   */
  public void setTotalFeesAmount(BigDecimal totalFeesAmount) {
    this.totalFeesAmount = totalFeesAmount;
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
}