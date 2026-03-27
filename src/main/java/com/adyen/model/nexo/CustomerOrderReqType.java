package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/**
 * Java class for CustomerOrderReqType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="CustomerOrderReqType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Open"/&gt;
 *     &lt;enumeration value="Closed"/&gt;
 *     &lt;enumeration value="Both"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum CustomerOrderReqType {

  /** Customer order not completed. */
  @SerializedName("Open")
  @Schema(description = "Customer order not completed.")
  OPEN("Open"),

  /** Completed customer orders. */
  @SerializedName("Closed")
  @Schema(description = "Completed customer orders.")
  CLOSED("Closed"),

  /** All type of CustomerOrder should be listed */
  @SerializedName("Both")
  @Schema(description = "All type of CustomerOrder should be listed")
  BOTH("Both");
  private final String value;

  CustomerOrderReqType(String v) {
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
   * @return the CustomerOrderReqType, or {@code null} if no match is found.
   */
  public static CustomerOrderReqType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
