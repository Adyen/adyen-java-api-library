package com.adyen.model.clouddevice;

import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

public enum TrackFormatType {

  /** ISO card track format - ISO 7813 - ISO 4909 */
  ISO("ISO"),

  /** Japenese track format I */
  @Schema(description = "Japenese track format I")
  JIS_I("JIS-I"),

  /** Japenese track format II */
  @Schema(description = "Japenese track format II")
  JIS_II("JIS-II"),

  /** American driver license */
  AAMVA("AAMVA"),

  /**
   * ((Magnetic Ink Character Recognition, using the CMC-7 font - ISO 1004) Line at the bottom of a
   * check containing the bank account and the check number.
   */
  @Schema(
      description =
          "((Magnetic Ink Character Recognition, using the CMC-7 font - ISO 1004) Line at the bottom of a check containing the bank account and the check number.")
  CMC_7("CMC-7"),

  /**
   * (Magnetic Ink Character Recognition, using the E-13B font) Line at the bottom of a check
   * containing the bank account and the check number.
   */
  @Schema(
      description =
          "(Magnetic Ink Character Recognition, using the E-13B font) Line at the bottom of a check containing the bank account and the check number.")
  E_13_B("E-13B");
  private final String value;

  TrackFormatType(String v) {
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
   * @return the TrackFormatType, or {@code null} if no match is found.
   */
  @JsonCreator
  public static TrackFormatType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
