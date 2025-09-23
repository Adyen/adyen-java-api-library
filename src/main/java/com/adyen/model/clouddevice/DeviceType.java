package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of device. */
public enum DeviceType {

  /**
   * Used by the POI System (or the Sale System when the device is managed by the POI Terminal), to
   * display some information to the Cashier.
   */
  @Schema(
      description =
          "Used by the POI System (or the Sale System when the device is managed by the POI Terminal), to display some information to the Cashier.")
  CASHIER_DISPLAY("CashierDisplay"),

  /**
   * Used by the Sale System (or the POI System when the device is managed by the Sale Terminal), to
   * display some information to the Customer.
   */
  @Schema(
      description =
          "Used by the Sale System (or the POI System when the device is managed by the Sale Terminal), to display some information to the Customer.")
  CUSTOMER_DISPLAY("CustomerDisplay"),

  /**
   * Any kind of keyboard allowing all or part of the commands of the Input messageType request from
   * the Sale System to the POI System (InputCommand data element). The
   */
  @Schema(
      description =
          "Any kind of keyboard allowing all or part of the commands of the Input message request from the Sale System to the POI System (InputCommand data element). The")
  CASHIER_INPUT("CashierInput"),

  /**
   * Any kind of keyboard allowing all or part of the commands of the Input messageType request from
   * the POI System to the Sale System (InputCommand data element). The
   */
  @Schema(
      description =
          "Any kind of keyboard allowing all or part of the commands of the Input message request from the POI System to the Sale System (InputCommand data element). The")
  CUSTOMER_INPUT("CustomerInput");

  private final String value;

  DeviceType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the DeviceType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a DeviceType from a string value.
   *
   * @param v the string value
   * @return the corresponding DeviceType
   */
  @JsonCreator
  public static DeviceType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}