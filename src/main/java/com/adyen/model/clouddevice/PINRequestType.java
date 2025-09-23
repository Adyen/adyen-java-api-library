package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of PIN request. */
public enum PINRequestType {

  /** The PIN Entering and Verify. */
  @Schema(description = "The PIN Entering and Verify.")
  PIN_VERIFY("PINVerify"),

  /**
   * The PIN Verify only, the PIN is entered before and the PIN Block (encrypted PIN) is provided.
   */
  @Schema(
      description =
          "The PIN Verify only, the PIN is entered before and the PIN Block (encrypted PIN) is provided.")
  PIN_VERIFY_ONLY("PINVerifyOnly"),

  /** The PIN is entered by the Cardholder, encrypted by the POI, and provided as a result. */
  @Schema(
      description =
          "The PIN is entered by the Cardholder, encrypted by the POI, and provided as a result.")
  PIN_ENTER("PINEnter");

  private final String value;

  PINRequestType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the PINRequestType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a PINRequestType from a string value.
   *
   * @param v the string value
   * @return the corresponding PINRequestType
   */
  @JsonCreator
  public static PINRequestType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}