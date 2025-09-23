package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of forced entry mode. */
public enum ForceEntryModeType {

  /** Payment instrument information are taken from RFID */
  RFID("RFID"),

  /** Manual key entry */
  @Schema(description = "Manual key entry")
  KEYED("Keyed"),

  /**
   * Reading of embossing or OCR of printed data either at time of transaction or after the event.
   */
  @Schema(
      description =
          "Reading of embossing or OCR of printed data either at time of transaction or after the event.")
  MANUAL("Manual"),

  /** Account data on file */
  @Schema(description = "Account data on file")
  FILE("File"),

  /** Scanned by a bar code reader. */
  @Schema(description = "Scanned by a bar code reader.")
  SCANNED("Scanned"),

  /** Magnetic stripe */
  @Schema(description = "Magnetic stripe ")
  MAG_STRIPE("MagStripe"),

  /** Contact ICC (asynchronous) */
  ICC("ICC"),

  /** Contact ICC (synchronous) */
  @Schema(description = "Contact ICC (synchronous)")
  SYNCHRONOUS_ICC("SynchronousICC"),

  /** Contactless card reader Magnetic Stripe */
  @Schema(description = "Contactless card reader Magnetic Stripe")
  TAPPED("Tapped"),

  /** Contactless card reader conform to ISO 14443 */
  @Schema(description = "Contactless card reader conform to ISO 14443")
  CONTACTLESS("Contactless"),

  /** Check Reader */
  @Schema(description = "Check Reader")
  CHECK_READER("CheckReader");

  private final String value;

  ForceEntryModeType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the ForceEntryModeType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a ForceEntryModeType from a string value.
   *
   * @param v the string value
   * @return the corresponding ForceEntryModeType
   */
  @JsonCreator
  public static ForceEntryModeType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}