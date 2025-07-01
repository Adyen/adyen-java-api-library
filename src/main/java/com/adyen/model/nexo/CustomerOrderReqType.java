package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for CustomerOrderReqType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="CustomerOrderReqType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Open"/&gt;
 *     &lt;enumeration value="Closed"/&gt;
 *     &lt;enumeration value="Both"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "CustomerOrderReqType")
@XmlEnum
public enum CustomerOrderReqType {

  /** Customer order not completed. */
  @XmlEnumValue("Open")
  @Schema(description = "Customer order not completed.")
  OPEN("Open"),

  /** Completed customer orders. */
  @XmlEnumValue("Closed")
  @Schema(description = "Completed customer orders.")
  CLOSED("Closed"),

  /** All type of CustomerOrder should be listed */
  @XmlEnumValue("Both")
  @Schema(description = "All type of CustomerOrder should be listed")
  BOTH("Both");
  private final String value;

  CustomerOrderReqType(String v) {
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
   * @return the CustomerOrderReqType, or {@code null} if no match is found.
   */
  public static CustomerOrderReqType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
