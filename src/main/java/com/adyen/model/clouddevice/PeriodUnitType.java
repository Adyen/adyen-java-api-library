package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of period unit. */
public enum PeriodUnitType {

  /** The day is the unit of the period. */
  @Schema(description = "The day is the unit of the period.")
  DAILY("Daily"),

  /** The week is the unit of the period. */
  @Schema(description = "The week is the unit of the period.")
  WEEKLY("Weekly"),

  /** The month is the unit of the period. */
  @Schema(description = "The month is the unit of the period.")
  MONTHLY("Monthly"),

  /** The year is the unit of the period. */
  @Schema(description = "The year is the unit of the period.")
  ANNUAL("Annual");

  private final String value;

  PeriodUnitType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the PeriodUnitType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a PeriodUnitType from a string value.
   *
   * @param v the string value
   * @return the corresponding PeriodUnitType
   */
  @JsonCreator
  public static PeriodUnitType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
