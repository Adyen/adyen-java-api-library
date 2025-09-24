package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

/** Data related to the result of a processed loyalty transaction. */
@JsonPropertyOrder({
  "LoyaltyAccount",
  "LoyaltyAmount",
  "LoyaltyAcquirerData",
  "Rebates",
  "CurrentBalance"
})
public class LoyaltyResult {

  @JsonProperty("LoyaltyAccount")
  @Schema(description = "Data related to a loyalty account processed in the transaction.")
  protected LoyaltyAccount loyaltyAccount;

  @JsonProperty("LoyaltyAmount")
  @Schema(description = "Amount of a loyalty account. --Rule: If awarded amount")
  protected LoyaltyAmount loyaltyAmount;

  @JsonProperty("LoyaltyAcquirerData")
  @Schema(
      description =
          "Data related to the loyalty Acquirer during a loyalty transaction. --Rule: if content not empty")
  protected LoyaltyAcquirerData loyaltyAcquirerData;

  @JsonProperty("Rebates")
  @Schema(description = "Rebate form to an award; --Rule: if rebates awarded")
  protected Rebates rebates;

  @JsonProperty("CurrentBalance")
  @Schema(
      description =
          "Balance of an account. --Rule: if known (provided by the card or an external host)")
  protected BigDecimal currentBalance;

  /**
   * Gets loyalty account.
   *
   * @return the loyalty account
   */
  public LoyaltyAccount getLoyaltyAccount() {
    return loyaltyAccount;
  }

  /**
   * Sets loyalty account.
   *
   * @param loyaltyAccount the loyalty account
   */
  public void setLoyaltyAccount(LoyaltyAccount loyaltyAccount) {
    this.loyaltyAccount = loyaltyAccount;
  }

  /**
   * Gets loyalty amount.
   *
   * @return the loyalty amount
   */
  public LoyaltyAmount getLoyaltyAmount() {
    return loyaltyAmount;
  }

  /**
   * Sets loyalty amount.
   *
   * @param loyaltyAmount the loyalty amount
   */
  public void setLoyaltyAmount(LoyaltyAmount loyaltyAmount) {
    this.loyaltyAmount = loyaltyAmount;
  }

  /**
   * Gets loyalty acquirer data.
   *
   * @return the loyalty acquirer data
   */
  public LoyaltyAcquirerData getLoyaltyAcquirerData() {
    return loyaltyAcquirerData;
  }

  /**
   * Sets loyalty acquirer data.
   *
   * @param loyaltyAcquirerData the loyalty acquirer data
   */
  public void setLoyaltyAcquirerData(LoyaltyAcquirerData loyaltyAcquirerData) {
    this.loyaltyAcquirerData = loyaltyAcquirerData;
  }

  /**
   * Gets rebates.
   *
   * @return the rebates
   */
  public Rebates getRebates() {
    return rebates;
  }

  /**
   * Sets rebates.
   *
   * @param rebates the rebates
   */
  public void setRebates(Rebates rebates) {
    this.rebates = rebates;
  }

  /**
   * Gets current balance.
   *
   * @return the current balance
   */
  public BigDecimal getCurrentBalance() {
    return currentBalance;
  }

  /**
   * Sets current balance.
   *
   * @param currentBalance the current balance
   */
  public void setCurrentBalance(BigDecimal currentBalance) {
    this.currentBalance = currentBalance;
  }
}
