package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;

/** Common amount definition with currency. */
@JsonPropertyOrder({"AmountValue", "Currency"})
public class Amount {

  @JsonProperty("AmountValue")
  protected BigDecimal amountValue;

  @JsonProperty("Currency")
  protected String currency;

  /**
   * Gets amount value.
   *
   * @return the amount value
   */
  public BigDecimal getAmountValue() {
    return amountValue;
  }

  /**
   * Sets amount value.
   *
   * @param amountValue the amount value
   */
  public void setAmountValue(BigDecimal amountValue) {
    this.amountValue = amountValue;
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
