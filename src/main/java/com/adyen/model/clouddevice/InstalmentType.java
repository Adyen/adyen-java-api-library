package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

public enum InstalmentType {

  /** The payment of the service or goods is deferred. */
  @Schema(description = "The payment of the service or goods is deferred.")
  DEFERRED_INSTALMENTS("DeferredInstalments"),

  /** The payment is split in several instalments of equal amounts. */
  @Schema(description = "The payment is split in several instalments of equal amounts.")
  EQUAL_INSTALMENTS("EqualInstalments"),

  /** The payment is split in several instalments of different amounts. */
  @Schema(description = "The payment is split in several instalments of different amounts.")
  INEQUAL_INSTALMENTS("InequalInstalments");
  private final String value;

  InstalmentType(String v) {
    value = v;
  }

  /**
   * Value string.
   *
   * @return the string
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Returns the enum constant matching the given string, or {@code null} if no match is found.
   *
   * @param v string value
   * @return the InstalmentType, or {@code null} if no match is found.
   */
  @JsonCreator
  public static InstalmentType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
