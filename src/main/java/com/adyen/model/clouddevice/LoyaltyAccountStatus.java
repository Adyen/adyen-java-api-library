package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

/** Data related to the result of a loyalty Balance Inquiry. */
@JsonPropertyOrder({"LoyaltyAccount", "CurrentBalance", "LoyaltyUnit", "Currency"})
public class LoyaltyAccountStatus {

  @JsonProperty("LoyaltyAccount")
  @Schema(description = "Data related to a loyalty account processed in the transaction.")
  protected LoyaltyAccount loyaltyAccount;

  @JsonProperty("CurrentBalance")
  @Schema(
      description =
          "Balance of an account. --Rule: if known (provided by the card or an external host)")
  protected BigDecimal currentBalance;

  @JsonProperty("LoyaltyUnit")
  @Schema(description = "Unit of a loyalty amount.")
  protected LoyaltyUnitType loyaltyUnit;

  @JsonProperty("Currency")
  @Schema(
      description =
          "Currency of a monetary amount. --Rule: If Result is Success and If LoyaltyUnit is \"Monetary\"")
  protected String currency;

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

  /**
   * Gets loyalty unit.
   *
   * @return the loyalty unit
   */
  public LoyaltyUnitType getLoyaltyUnit() {
    if (loyaltyUnit == null) {
      return LoyaltyUnitType.POINT;
    } else {
      return loyaltyUnit;
    }
  }

  /**
   * Sets loyalty unit.
   *
   * @param loyaltyUnit the loyalty unit
   */
  public void setLoyaltyUnit(LoyaltyUnitType loyaltyUnit) {
    this.loyaltyUnit = loyaltyUnit;
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
}