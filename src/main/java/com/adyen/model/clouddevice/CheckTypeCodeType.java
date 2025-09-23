package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

/** Type of check. */
public enum CheckTypeCodeType {

  /** Personal check type code type. */
  PERSONAL("Personal"),
  /** Company check type code type. */
  COMPANY("Company");

  private final String value;

  CheckTypeCodeType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the CheckTypeCodeType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a CheckTypeCodeType from a string value.
   *
   * @param v the string value
   * @return the corresponding CheckTypeCodeType
   */
  @JsonCreator
  public static CheckTypeCodeType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}