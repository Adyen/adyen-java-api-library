package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

/** Height of the character. */
public enum CharacterHeightType {

  /** Single height character height type. */
  SINGLE_HEIGHT("SingleHeight"),
  /** Double height character height type. */
  DOUBLE_HEIGHT("DoubleHeight"),
  /** Half height character height type. */
  HALF_HEIGHT("HalfHeight");

  private final String value;

  CharacterHeightType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the CharacterHeightType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a CharacterHeightType from a string value.
   *
   * @param v the string value
   * @return the corresponding CharacterHeightType
   */
  @JsonCreator
  public static CharacterHeightType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
