package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Entry mode of the payment instrument information. */
public enum EntryModeType {

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

  /** Magnetic stripe card reader. */
  @Schema(description = "Magnetic stripe  card reader.")
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

  /** Mobile phone. */
  @Schema(description = "Mobile phone.")
  MOBILE("Mobile");

  private final String value;

  EntryModeType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the EntryModeType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a EntryModeType from a string value.
   *
   * @param v the string value
   * @return the corresponding EntryModeType
   */
  @JsonCreator
  public static EntryModeType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}