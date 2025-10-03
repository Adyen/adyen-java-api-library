package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.math.BigInteger;

/** Number of coins or bills of a given value. */
@JsonPropertyOrder({"UnitValue", "Number"})
public class CoinsOrBills {

  @JsonProperty("UnitValue")
  @Schema(description = "Value of a coin or bill.")
  protected BigDecimal unitValue;

  @JsonProperty("Number")
  @Schema(description = "Number of elements")
  protected BigInteger number;

  /**
   * Gets unit value.
   *
   * @return the unit value
   */
  public BigDecimal getUnitValue() {
    return unitValue;
  }

  /**
   * Sets unit value.
   *
   * @param unitValue the unit value
   */
  public void setUnitValue(BigDecimal unitValue) {
    this.unitValue = unitValue;
  }

  /**
   * Gets number.
   *
   * @return the number
   */
  public BigInteger getNumber() {
    return number;
  }

  /**
   * Sets number.
   *
   * @param number the number
   */
  public void setNumber(BigInteger number) {
    this.number = number;
  }
}
