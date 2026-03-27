package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

/**
 * Java class for VersionType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="VersionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="v0"/&gt;
 *     &lt;enumeration value="v1"/&gt;
 *     &lt;enumeration value="v2"/&gt;
 *     &lt;enumeration value="v3"/&gt;
 *     &lt;enumeration value="v4"/&gt;
 *     &lt;enumeration value="v5"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum VersionType {

  /** Version 0 */
  @SerializedName("v0")
  V_0("v0"),

  /** Version 1 */
  @SerializedName("v1")
  V_1("v1"),

  /** Version 2 */
  @SerializedName("v2")
  V_2("v2"),

  /** Version 3 */
  @SerializedName("v3")
  V_3("v3"),

  /** Version 4 */
  @SerializedName("v4")
  V_4("v4"),

  /** Version 5 */
  @SerializedName("v5")
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
  public String value() {
    return value;
  }

  /**
   * Returns the enum constant matching the given string, or {@code null} if no match is found.
   *
   * @param v string value
   * @return the VersionType, or {@code null} if no match is found.
   */
  public static VersionType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
