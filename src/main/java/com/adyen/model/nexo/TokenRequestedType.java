package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for TokenRequestedType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="TokenRequestedType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Transaction"/&gt;
 *     &lt;enumeration value="Customer"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "TokenRequestedType")
@XmlEnum
public enum TokenRequestedType {

  /** The token is generated to recognise a customer during the time of a transaction. */
  @XmlEnumValue("Transaction")
  @Schema(
      description =
          "The token is generated to recognise a customer during the time of a transaction.")
  TRANSACTION("Transaction"),

  /** The token is generated to recognise a customer for a longer period. */
  @XmlEnumValue("Customer")
  @Schema(description = "The token is generated to recognise a customer for a longer period.")
  CUSTOMER("Customer");
  private final String value;

  TokenRequestedType(String v) {
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
   * @return the TokenRequestedType, or {@code null} if no match is found.
   */
  public static TokenRequestedType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
