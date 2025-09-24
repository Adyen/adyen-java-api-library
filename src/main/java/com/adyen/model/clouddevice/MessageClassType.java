package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of message class. */
public enum MessageClassType {

  /**
   * A transaction messageType pair initiated by the Sale System, and requested to the POI System.
   */
  @Schema(
      description =
          "A transaction message pair initiated by the Sale System, and requested to the POI System.")
  SERVICE("Service"),

  /**
   * A device messageType pair either: Inside a Service request and response. This device
   * messageType pair is initiated by the POI System, and sent to Sale System,
   */
  @Schema(
      description =
          "A device message pair either: Inside a Service request and response. This device message pair is initiated by the POI System, and sent to Sale System,")
  DEVICE("Device"),

  /** An unsolicited event notification by the POI System to the Sale System. */
  @Schema(description = "An unsolicited event notification by the POI System to the Sale System.")
  EVENT("Event");

  private final String value;

  MessageClassType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the MessageClassType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a MessageClassType from a string value.
   *
   * @param v the string value
   * @return the corresponding MessageClassType
   */
  @JsonCreator
  public static MessageClassType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
