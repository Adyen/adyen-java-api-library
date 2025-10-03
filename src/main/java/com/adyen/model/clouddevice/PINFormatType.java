package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of PIN format. */
public enum PINFormatType {

  /** ISO 0 */
  @Schema(description = "ISO 0")
  ISO_0("ISO0"),

  /** ISO 1 */
  @Schema(description = "ISO 1")
  ISO_1("ISO1"),

  /** ISO 2 */
  @Schema(description = "ISO 2")
  ISO_2("ISO2"),

  /** ISO 3 */
  @Schema(description = "ISO 3")
  ISO_3("ISO3");

  private final String value;

  PINFormatType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the PINFormatType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a PINFormatType from a string value.
   *
   * @param v the string value
   * @return the corresponding PINFormatType
   */
  @JsonCreator
  public static PINFormatType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
