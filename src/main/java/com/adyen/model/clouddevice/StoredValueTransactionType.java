package com.adyen.model.clouddevice;

import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

public enum StoredValueTransactionType {

  /** Reserve the account (e.g. get an activation code) */
  @Schema(description = "Reserve the account (e.g. get an activation code)")
  RESERVE("Reserve"),

  /** Activate the account or the card */
  @Schema(description = "Activate the account or the card")
  ACTIVATE("Activate"),

  /** Load the account or the card with money */
  @Schema(description = "Load the account or the card with money")
  LOAD("Load"),

  /** Unload the account */
  @Schema(description = "Unload the account")
  UNLOAD("Unload"),

  /** Reverse an activation or loading. */
  @Schema(description = "Reverse an activation or loading.")
  REVERSE("Reverse"),

  /** Duplicate the code or number provided by the loading or activation */
  @Schema(description = "Duplicate the code or number provided by the loading or activation")
  DUPLICATE("Duplicate");
  private final String value;

  StoredValueTransactionType(String v) {
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
   * @return the StoredValueTransactionType, or {@code null} if no match is found.
   */
  @JsonCreator
  public static StoredValueTransactionType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
