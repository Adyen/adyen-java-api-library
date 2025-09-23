package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of loyalty unit. */
public enum LoyaltyUnitType {

  /** The amount is expressed in point. */
  @Schema(description = "The amount is expressed in point.")
  POINT("Point"),

  /** The amount is expressed in a monetary value in a currency. */
  @Schema(description = "The amount is expressed in a monetary value in a currency.")
  MONETARY("Monetary");

  private final String value;

  LoyaltyUnitType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the LoyaltyUnitType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a LoyaltyUnitType from a string value.
   *
   * @param v the string value
   * @return the corresponding LoyaltyUnitType
   */
  @JsonCreator
  public static LoyaltyUnitType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}