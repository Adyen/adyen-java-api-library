package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

/** Color of the text. */
public enum ColorType {

  /** White color type. */
  WHITE("White"),
  /** Black color type. */
  BLACK("Black"),
  /** Red color type. */
  RED("Red"),
  /** Green color type. */
  GREEN("Green"),
  /** Blue color type. */
  BLUE("Blue"),
  /** Yellow color type. */
  YELLOW("Yellow"),
  /** Magenta color type. */
  MAGENTA("Magenta"),
  /** Cyan color type. */
  CYAN("Cyan");

  private final String value;

  ColorType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the ColorType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a ColorType from a string value.
   *
   * @param v the string value
   * @return the corresponding ColorType
   */
  @JsonCreator
  public static ColorType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}