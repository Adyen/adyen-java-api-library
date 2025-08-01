package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for StoredValueAccountType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="StoredValueAccountType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="GiftCard"/&gt;
 *     &lt;enumeration value="PhoneCard"/&gt;
 *     &lt;enumeration value="Other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "StoredValueAccountType")
@XmlEnum
public enum StoredValueAccountType {

  /** Payment mean issued by retailers or banks as a substitute to a non-monetary gift. */
  @XmlEnumValue("GiftCard")
  @Schema(
      description =
          "Payment mean issued by retailers or banks as a substitute to a non-monetary gift.")
  GIFT_CARD("GiftCard"),

  /** Stored value instrument used to pay telephone services (e.g. card or identifier). */
  @XmlEnumValue("PhoneCard")
  @Schema(
      description =
          "Stored value instrument used to pay telephone services (e.g. card or identifier).")
  PHONE_CARD("PhoneCard"),

  /** Other stored value instrument. */
  @XmlEnumValue("Other")
  @Schema(description = "Other stored value instrument.")
  OTHER("Other");
  private final String value;

  StoredValueAccountType(String v) {
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
   * @return the StoredValueAccountType, or {@code null} if no match is found.
   */
  public static StoredValueAccountType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
