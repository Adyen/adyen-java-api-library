package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

/**
 * Java class for ColorType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="ColorType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="White"/&gt;
 *     &lt;enumeration value="Black"/&gt;
 *     &lt;enumeration value="Red"/&gt;
 *     &lt;enumeration value="Green"/&gt;
 *     &lt;enumeration value="Blue"/&gt;
 *     &lt;enumeration value="Yellow"/&gt;
 *     &lt;enumeration value="Magenta"/&gt;
 *     &lt;enumeration value="Cyan"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum ColorType {

  /** White color type. */
  @SerializedName("White")
  WHITE("White"),
  /** Black color type. */
  @SerializedName("Black")
  BLACK("Black"),
  /** Red color type. */
  @SerializedName("Red")
  RED("Red"),
  /** Green color type. */
  @SerializedName("Green")
  GREEN("Green"),
  /** Blue color type. */
  @SerializedName("Blue")
  BLUE("Blue"),
  /** Yellow color type. */
  @SerializedName("Yellow")
  YELLOW("Yellow"),
  /** Magenta color type. */
  @SerializedName("Magenta")
  MAGENTA("Magenta"),
  /** Cyan color type. */
  @SerializedName("Cyan")
  CYAN("Cyan");
  private final String value;

  ColorType(String v) {
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
   * @return the ColorType, or {@code null} if no match is found.
   */
  public static ColorType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
