package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

public enum StoredValueAccountType {

  /** Payment mean issued by retailers or banks as a substitute to a non-monetary gift. */
  @Schema(
      description =
          "Payment mean issued by retailers or banks as a substitute to a non-monetary gift.")
  GIFT_CARD("GiftCard"),

  /** Stored value instrument used to pay telephone services (e.g. card or identifier). */
  @Schema(
      description =
          "Stored value instrument used to pay telephone services (e.g. card or identifier).")
  PHONE_CARD("PhoneCard"),

  /** Other stored value instrument. */
  @Schema(description = "Other stored value instrument.")
  OTHER("Other");
  private final String value;

  StoredValueAccountType(String v) {
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
   * @return the StoredValueAccountType, or {@code null} if no match is found.
   */
  @JsonCreator
  public static StoredValueAccountType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
