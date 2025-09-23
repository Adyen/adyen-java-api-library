package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

/** Amount of a loyalty account. */
@JsonPropertyOrder({"Value", "LoyaltyUnit", "Currency"})
public class LoyaltyAmount {

  @JsonProperty("Value")
  protected BigDecimal value;

  @JsonProperty("LoyaltyUnit")
  protected LoyaltyUnitType loyaltyUnit;

  @JsonProperty("Currency")
  @Schema(description = "Currency of a monetary amount. --Rule: if LoyaltyUnit is Monetary")
  protected String currency;

  /**
   * Gets value.
   *
   * @return the value
   */
  public BigDecimal getValue() {
    return value;
  }

  /**
   * Sets value.
   *
   * @param value the value
   */
  public void setValue(BigDecimal value) {
    this.value = value;
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