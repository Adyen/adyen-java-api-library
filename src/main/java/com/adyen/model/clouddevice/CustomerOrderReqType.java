package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of customer order requests. */
public enum CustomerOrderReqType {

  /** Customer order not completed. */
  @Schema(description = "Customer order not completed.")
  OPEN("Open"),

  /** Completed customer orders. */
  @Schema(description = "Completed customer orders.")
  CLOSED("Closed"),

  /** All type of CustomerOrder should be listed */
  @Schema(description = "All type of CustomerOrder should be listed")
  BOTH("Both");

  private final String value;

  CustomerOrderReqType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the CustomerOrderReqType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a CustomerOrderReqType from a string value.
   *
   * @param v the string value
   * @return the corresponding CustomerOrderReqType
   */
  @JsonCreator
  public static CustomerOrderReqType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
