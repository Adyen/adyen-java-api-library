package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

/** Alignment of the text. */
public enum AlignmentType {

  /** Left alignment type. */
  LEFT("Left"),
  /** Right alignment type. */
  RIGHT("Right"),
  /** Centred alignment type. */
  CENTRED("Centred"),
  /** Justified alignment type. */
  JUSTIFIED("Justified");

  private final String value;

  AlignmentType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the AlignmentType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates an AlignmentType from a string value.
   *
   * @param v the string value
   * @return the corresponding AlignmentType
   */
  @JsonCreator
  public static AlignmentType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}