package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for EntryModeType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="EntryModeType"&gt;
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
 *     &lt;enumeration value="Mobile"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "EntryModeType")
@XmlEnum
public enum EntryModeType {

  /** Payment instrument information are taken from RFID */
  RFID("RFID"),

  /** Manual key entry */
  @XmlEnumValue("Keyed")
  @Schema(description = "Manual key entry")
  KEYED("Keyed"),

  /**
   * Reading of embossing or OCR of printed data either at time of transaction or after the event.
   */
  @XmlEnumValue("Manual")
  @Schema(
      description =
          "Reading of embossing or OCR of printed data either at time of transaction or after the event.")
  MANUAL("Manual"),

  /** Account data on file */
  @XmlEnumValue("File")
  @Schema(description = "Account data on file")
  FILE("File"),

  /** Scanned by a bar code reader. */
  @XmlEnumValue("Scanned")
  @Schema(description = "Scanned by a bar code reader.")
  SCANNED("Scanned"),

  /** Magnetic stripe card reader. */
  @XmlEnumValue("MagStripe")
  @Schema(description = "Magnetic stripe  card reader.")
  MAG_STRIPE("MagStripe"),

  /** Contact ICC (asynchronous) */
  ICC("ICC"),

  /** Contact ICC (synchronous) */
  @XmlEnumValue("SynchronousICC")
  @Schema(description = "Contact ICC (synchronous)")
  SYNCHRONOUS_ICC("SynchronousICC"),

  /** Contactless card reader Magnetic Stripe */
  @XmlEnumValue("Tapped")
  @Schema(description = "Contactless card reader Magnetic Stripe")
  TAPPED("Tapped"),

  /** Contactless card reader conform to ISO 14443 */
  @XmlEnumValue("Contactless")
  @Schema(description = "Contactless card reader conform to ISO 14443")
  CONTACTLESS("Contactless"),

  /** Mobile phone. */
  @XmlEnumValue("Mobile")
  @Schema(description = "Mobile phone.")
  MOBILE("Mobile");
  private final String value;

  EntryModeType(String v) {
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
   * @return the EntryModeType, or {@code null} if no match is found.
   */
  public static EntryModeType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
