package com.adyen.model.clouddevice;

import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

public enum ServicesEnabledType {

  /**
   * Enable the POI to process a card acquisition before the request of the Sale System (e.g. the
   * same processing as the CardAcquisition command, but no more)
   */
  @Schema(
      description =
          "Enable the POI to process a card acquisition before the request of the Sale System (e.g. the same processing as the CardAcquisition command, but no more)")
  CARD_ACQUISITION("CardAcquisition"),

  /**
   * Enable the POI to start a payment transaction before the request of the Sale System (e.g. the
   * same processing as the Payment command)
   */
  @Schema(
      description =
          "Enable the POI to start a payment transaction before the request of the Sale System (e.g. the same processing as the Payment command)")
  PAYMENT("Payment"),

  /**
   * Enable the POI to start a loyalty transaction before the request of the Sale System (e.g. the
   * same processing as the Loyalty command)
   */
  @Schema(
      description =
          "Enable the POI to start a loyalty transaction before the request of the Sale System (e.g. the same processing as the Loyalty command)")
  LOYALTY("Loyalty");
  private final String value;

  ServicesEnabledType(String v) {
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
   * @return the ServicesEnabledType, or {@code null} if no match is found.
   */
  @JsonCreator
  public static ServicesEnabledType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
