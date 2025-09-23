package com.adyen.model.clouddevice;

import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

public enum TokenRequestedType {

  /** The token is generated to recognise a customer during the time of a transaction. */
  @Schema(
      description =
          "The token is generated to recognise a customer during the time of a transaction.")
  TRANSACTION("Transaction"),

  /** The token is generated to recognise a customer for a longer period. */
  @Schema(description = "The token is generated to recognise a customer for a longer period.")
  CUSTOMER("Customer");
  private final String value;

  TokenRequestedType(String v) {
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
   * @return the TokenRequestedType, or {@code null} if no match is found.
   */
  @JsonCreator
  public static TokenRequestedType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
