package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of global status. */
public enum GlobalStatusType {

  /** The POI is ready to receive and process a request */
  OK("OK"),

  /** The POI Terminal cannot process a request because another processing is in progress. */
  @Schema(
      description =
          "The POI Terminal cannot process a request because another processing is in progress.")
  BUSY("Busy"),

  /** The POI is in maintenance processing */
  @Schema(description = "The POI is in maintenance processing")
  MAINTENANCE("Maintenance"),

  /** The POI is unreachable or not responding */
  @Schema(description = "The POI is unreachable or not responding")
  UNREACHABLE("Unreachable");

  private final String value;

  GlobalStatusType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the GlobalStatusType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a GlobalStatusType from a string value.
   *
   * @param v the string value
   * @return the corresponding GlobalStatusType
   */
  @JsonCreator
  public static GlobalStatusType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}