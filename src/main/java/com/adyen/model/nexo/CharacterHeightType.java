package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

/**
 * Java class for CharacterHeightType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="CharacterHeightType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SingleHeight"/&gt;
 *     &lt;enumeration value="DoubleHeight"/&gt;
 *     &lt;enumeration value="HalfHeight"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum CharacterHeightType {

  /** Single height character height type. */
  @SerializedName("SingleHeight")
  SINGLE_HEIGHT("SingleHeight"),
  /** Double height character height type. */
  @SerializedName("DoubleHeight")
  DOUBLE_HEIGHT("DoubleHeight"),
  /** Half height character height type. */
  @SerializedName("HalfHeight")
  HALF_HEIGHT("HalfHeight");
  private final String value;

  CharacterHeightType(String v) {
    value = v;
  }

  /**
   * Value string.
   *
   * @return the string
   */
  public String value() {
    return value;
  }

  /**
   * Returns the enum constant matching the given string, or {@code null} if no match is found.
   *
   * @param v string value
   * @return the CharacterHeightType, or {@code null} if no match is found.
   */
  public static CharacterHeightType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
