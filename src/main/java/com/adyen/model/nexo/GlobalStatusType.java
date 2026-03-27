package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/**
 * Java class for GlobalStatusType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="GlobalStatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="OK"/&gt;
 *     &lt;enumeration value="Busy"/&gt;
 *     &lt;enumeration value="Maintenance"/&gt;
 *     &lt;enumeration value="Unreachable"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum GlobalStatusType {

  /** The POI is ready to receive and process a request */
  OK("OK"),

  /** The POI Terminal cannot process a request because another processing is in progress. */
  @SerializedName("Busy")
  @Schema(
      description =
          "The POI Terminal cannot process a request because another processing is in progress.")
  BUSY("Busy"),

  /** The POI is in maintenance processing */
  @SerializedName("Maintenance")
  @Schema(description = "The POI is in maintenance processing")
  MAINTENANCE("Maintenance"),

  /** The POI is unreachable or not responding */
  @SerializedName("Unreachable")
  @Schema(description = "The POI is unreachable or not responding")
  UNREACHABLE("Unreachable");
  private final String value;

  GlobalStatusType(String v) {
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
   * @return the GlobalStatusType, or {@code null} if no match is found.
   */
  public static GlobalStatusType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
