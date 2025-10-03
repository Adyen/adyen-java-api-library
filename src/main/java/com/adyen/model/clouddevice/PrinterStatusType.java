package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of printer status. */
public enum PrinterStatusType {

  /** The printer is operational. */
  OK("OK"),

  /** The printer is operational but paper roll is almost empty. */
  @Schema(description = "The printer is operational but paper roll is almost empty.")
  PAPER_LOW("PaperLow"),

  /** Paper roll is empty, an operator must insert a new paper roll. */
  @Schema(description = "Paper roll is empty, an operator must insert a new paper roll.")
  NO_PAPER("NoPaper"),

  /** An operator must remove the paper jam manually. */
  @Schema(description = "An operator must remove the paper jam manually.")
  PAPER_JAM("PaperJam"),

  /** The printer is out of order. */
  @Schema(description = "The printer is out of order.")
  OUT_OF_ORDER("OutOfOrder");

  private final String value;

  PrinterStatusType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the PrinterStatusType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a PrinterStatusType from a string value.
   *
   * @param v the string value
   * @return the corresponding PrinterStatusType
   */
  @JsonCreator
  public static PrinterStatusType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
