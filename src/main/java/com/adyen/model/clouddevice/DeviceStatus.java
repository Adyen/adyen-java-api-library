/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2026 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

/** DeviceStatus */
public enum DeviceStatus {
  ONLINE("ONLINE"),
  OFFLINE("OFFLINE");

  private final String value;

  DeviceStatus(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the DeviceStatus.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates an DeviceStatus from a string value.
   *
   * @param v the string value
   * @return the corresponding DeviceStatus
   */
  @JsonCreator
  public static DeviceStatus fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
