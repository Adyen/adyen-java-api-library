package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

public enum VersionType {

  /** Version 0 */
  V_0("v0"),

  /** Version 1 */
  V_1("v1"),

  /** Version 2 */
  V_2("v2"),

  /** Version 3 */
  V_3("v3"),

  /** Version 4 */
  V_4("v4"),

  /** Version 5 */
  V_5("v5");
  private final String value;

  VersionType(String v) {
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
   * @return the VersionType, or {@code null} if no match is found.
   */
  @JsonCreator
  public static VersionType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
