package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for TransactionActionType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="TransactionActionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="StartTransaction"/&gt;
 *     &lt;enumeration value="AbortTransaction"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "TransactionActionType")
@XmlEnum
public enum TransactionActionType {

  /** Start a transaction by a swipe ahead mechanism, with the services which are enabled. */
  @XmlEnumValue("StartTransaction")
  @Schema(
      description =
          "Start a transaction by a swipe ahead mechanism, with the services which are enabled.")
  START_TRANSACTION("StartTransaction"),

  /**
   * Abort a transaction started either by a CardAcquisition or EnableService with TransactionAction
   * to "StartTransaction", not followed by a service request from
   */
  @XmlEnumValue("AbortTransaction")
  @Schema(
      description =
          "Abort a transaction started either by a CardAcquisition or EnableService with TransactionAction to \"StartTransaction\", not followed by a service request from")
  ABORT_TRANSACTION("AbortTransaction");
  private final String value;

  TransactionActionType(String v) {
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
   * @return the TransactionActionType, or {@code null} if no match is found.
   */
  public static TransactionActionType fromValue(String v) {
    return Arrays.stream(values())
            .filter(s -> s.value.equals(v))
            .findFirst()
            .orElse(null);
  }
}
