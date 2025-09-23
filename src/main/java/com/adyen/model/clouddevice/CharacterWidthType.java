package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

/** Width of the character. */
public enum CharacterWidthType {

  /** Single width character width type. */
  SINGLE_WIDTH("SingleWidth"),
  /** Double width character width type. */
  DOUBLE_WIDTH("DoubleWidth");

  private final String value;

  CharacterWidthType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the CharacterWidthType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a CharacterWidthType from a string value.
   *
   * @param v the string value
   * @return the corresponding CharacterWidthType
   */
  @JsonCreator
  public static CharacterWidthType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}