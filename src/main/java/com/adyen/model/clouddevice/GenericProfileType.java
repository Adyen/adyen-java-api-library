package com.adyen.model.clouddevice;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for GenericProfileType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="GenericProfileType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Basic"/&gt;
 *     &lt;enumeration value="Standard"/&gt;
 *     &lt;enumeration value="Extended"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "GenericProfileType")
@XmlEnum
public enum GenericProfileType {

  /** Protocol services that needs to be implemented by all the Sale and POI */
  @XmlEnumValue("Basic")
  @Schema(description = "Protocol services that needs to be implemented by all the Sale and POI")
  BASIC("Basic"),

  /**
   * Protocol services involving interaction between Sale System and POI System as devices shared
   * between the two Systems.
   */
  @XmlEnumValue("Standard")
  @Schema(
      description =
          "Protocol services involving interaction between Sale System and POI System as devices shared between the two Systems.")
  STANDARD("Standard"),

  /** Complete Protocol services */
  @XmlEnumValue("Extended")
  @Schema(description = "Complete Protocol services")
  EXTENDED("Extended");
  private final String value;

  GenericProfileType(String v) {
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
   * @return the GenericProfileType, or {@code null} if no match is found.
   */
  public static GenericProfileType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
