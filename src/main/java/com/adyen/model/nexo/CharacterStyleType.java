package com.adyen.model.nexo;

import java.util.Arrays;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for CharacterStyleType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="CharacterStyleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Normal"/&gt;
 *     &lt;enumeration value="Bold"/&gt;
 *     &lt;enumeration value="Italic"/&gt;
 *     &lt;enumeration value="Underlined"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "CharacterStyleType")
@XmlEnum
public enum CharacterStyleType {

  /** Normal character style type. */
  @XmlEnumValue("Normal")
  NORMAL("Normal"),
  /** Bold character style type. */
  @XmlEnumValue("Bold")
  BOLD("Bold"),
  /** Italic character style type. */
  @XmlEnumValue("Italic")
  ITALIC("Italic"),
  /** Underlined character style type. */
  @XmlEnumValue("Underlined")
  UNDERLINED("Underlined");
  private final String value;

  CharacterStyleType(String v) {
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
   * @return the CharacterStyleType, or {@code null} if no match is found.
   */
  public static CharacterStyleType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
