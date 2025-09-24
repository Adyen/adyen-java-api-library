package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

public enum TerminalEnvironmentType {

  /**
   * The Sale Terminal is managed by a Cashier through the Sale System. A Cashier Interface is
   * provided by the POI System during the process of a request from the
   */
  @Schema(
      description =
          "The Sale Terminal is managed by a Cashier through the Sale System. A Cashier Interface is provided by the POI System during the process of a request from the")
  ATTENDED("Attended"),

  /**
   * Without a Cashier Interface. The POI Terminal is managed by the Customer through the Customer
   * Interface. A Cashier could help the Cardholder during the
   */
  @Schema(
      description =
          "Without a Cashier Interface. The POI Terminal is managed by the Customer through the Customer Interface. A Cashier could help the Cardholder during the")
  SEMI_ATTENDED("SemiAttended"),

  /**
   * The Sale Terminal is managed as a logical terminal without any Cashier Interface (typically a
   * background process). The POI Terminal is managed by the Customer
   */
  @Schema(
      description =
          "The Sale Terminal is managed as a logical terminal without any Cashier Interface (typically a background process). The POI Terminal is managed by the Customer")
  UNATTENDED("Unattended");
  private final String value;

  TerminalEnvironmentType(String v) {
    value = v;
  }

  /**
   * Value string.
   *
   * @return the string
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Returns the enum constant matching the given string, or {@code null} if no match is found.
   *
   * @param v string value
   * @return the TerminalEnvironmentType, or {@code null} if no match is found.
   */
  @JsonCreator
  public static TerminalEnvironmentType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
