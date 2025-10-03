package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

/** Style of the character. */
public enum CharacterStyleType {

  /** Normal character style type. */
  NORMAL("Normal"),
  /** Bold character style type. */
  BOLD("Bold"),
  /** Italic character style type. */
  ITALIC("Italic"),
  /** Underlined character style type. */
  UNDERLINED("Underlined");

  private final String value;

  CharacterStyleType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the CharacterStyleType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a CharacterStyleType from a string value.
   *
   * @param v the string value
   * @return the corresponding CharacterStyleType
   */
  @JsonCreator
  public static CharacterStyleType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
