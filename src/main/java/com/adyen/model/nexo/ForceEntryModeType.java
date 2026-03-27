package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/**
 * Java class for ForceEntryModeType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="ForceEntryModeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="RFID"/&gt;
 *     &lt;enumeration value="Keyed"/&gt;
 *     &lt;enumeration value="Manual"/&gt;
 *     &lt;enumeration value="File"/&gt;
 *     &lt;enumeration value="Scanned"/&gt;
 *     &lt;enumeration value="MagStripe"/&gt;
 *     &lt;enumeration value="ICC"/&gt;
 *     &lt;enumeration value="SynchronousICC"/&gt;
 *     &lt;enumeration value="Tapped"/&gt;
 *     &lt;enumeration value="Contactless"/&gt;
 *     &lt;enumeration value="CheckReader"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum ForceEntryModeType {

  /** Payment instrument information are taken from RFID */
  RFID("RFID"),

  /** Manual key entry */
  @SerializedName("Keyed")
  @Schema(description = "Manual key entry")
  KEYED("Keyed"),

  /**
   * Reading of embossing or OCR of printed data either at time of transaction or after the event.
   */
  @SerializedName("Manual")
  @Schema(
      description =
          "Reading of embossing or OCR of printed data either at time of transaction or after the event.")
  MANUAL("Manual"),

  /** Account data on file */
  @SerializedName("File")
  @Schema(description = "Account data on file")
  FILE("File"),

  /** Scanned by a bar code reader. */
  @SerializedName("Scanned")
  @Schema(description = "Scanned by a bar code reader.")
  SCANNED("Scanned"),

  /** Magnetic stripe */
  @SerializedName("MagStripe")
  @Schema(description = "Magnetic stripe ")
  MAG_STRIPE("MagStripe"),

  /** Contact ICC (asynchronous) */
  ICC("ICC"),

  /** Contact ICC (synchronous) */
  @SerializedName("SynchronousICC")
  @Schema(description = "Contact ICC (synchronous)")
  SYNCHRONOUS_ICC("SynchronousICC"),

  /** Contactless card reader Magnetic Stripe */
  @SerializedName("Tapped")
  @Schema(description = "Contactless card reader Magnetic Stripe")
  TAPPED("Tapped"),

  /** Contactless card reader conform to ISO 14443 */
  @SerializedName("Contactless")
  @Schema(description = "Contactless card reader conform to ISO 14443")
  CONTACTLESS("Contactless"),

  /** Check Reader */
  @SerializedName("CheckReader")
  @Schema(description = "Check Reader")
  CHECK_READER("CheckReader");
  private final String value;

  ForceEntryModeType(String v) {
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
   * @return the ForceEntryModeType, or {@code null} if no match is found.
   */
  public static ForceEntryModeType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
