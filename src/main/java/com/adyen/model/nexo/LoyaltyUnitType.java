package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/**
 * Java class for LoyaltyUnitType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="LoyaltyUnitType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Point"/&gt;
 *     &lt;enumeration value="Monetary"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum LoyaltyUnitType {

  /** The amount is expressed in point. */
  @SerializedName("Point")
  @Schema(description = "The amount is expressed in point.")
  POINT("Point"),

  /** The amount is expressed in a monetary value in a currency. */
  @SerializedName("Monetary")
  @Schema(description = "The amount is expressed in a monetary value in a currency.")
  MONETARY("Monetary");
  private final String value;

  LoyaltyUnitType(String v) {
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
   * @return the LoyaltyUnitType, or {@code null} if no match is found.
   */
  public static LoyaltyUnitType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
