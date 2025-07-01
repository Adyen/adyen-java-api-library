package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for TrackFormatType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="TrackFormatType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ISO"/&gt;
 *     &lt;enumeration value="JIS-I"/&gt;
 *     &lt;enumeration value="JIS-II"/&gt;
 *     &lt;enumeration value="AAMVA"/&gt;
 *     &lt;enumeration value="CMC-7"/&gt;
 *     &lt;enumeration value="E-13B"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "TrackFormatType")
@XmlEnum
public enum TrackFormatType {

  /** ISO card track format - ISO 7813 - ISO 4909 */
  ISO("ISO"),

  /** Japenese track format I */
  @XmlEnumValue("JIS-I")
  @Schema(description = "Japenese track format I")
  JIS_I("JIS-I"),

  /** Japenese track format II */
  @XmlEnumValue("JIS-II")
  @Schema(description = "Japenese track format II")
  JIS_II("JIS-II"),

  /** American driver license */
  AAMVA("AAMVA"),

  /**
   * ((Magnetic Ink Character Recognition, using the CMC-7 font - ISO 1004) Line at the bottom of a
   * check containing the bank account and the check number.
   */
  @XmlEnumValue("CMC-7")
  @Schema(
      description =
          "((Magnetic Ink Character Recognition, using the CMC-7 font - ISO 1004) Line at the bottom of a check containing the bank account and the check number.")
  CMC_7("CMC-7"),

  /**
   * (Magnetic Ink Character Recognition, using the E-13B font) Line at the bottom of a check
   * containing the bank account and the check number.
   */
  @XmlEnumValue("E-13B")
  @Schema(
      description =
          "(Magnetic Ink Character Recognition, using the E-13B font) Line at the bottom of a check containing the bank account and the check number.")
  E_13_B("E-13B");
  private final String value;

  TrackFormatType(String v) {
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
   * @return the TrackFormatType, or {@code null} if no match is found.
   */
  public static TrackFormatType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
