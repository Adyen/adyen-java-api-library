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

import com.adyen.model.tapi.JSON;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Objects;

/** DeviceStatusResponse */
public class DeviceStatusResponse {
  @JsonProperty("deviceId")
  private String deviceId;
  @JsonProperty("status")
  private DeviceStatus status;

  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public DeviceStatus getStatus() {
    return status;
  }

  public void setStatus(DeviceStatus status) {
    this.status = status;
  }

  /**
   * Create an instance of DeviceStatus given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of DeviceStatus
   * @throws JsonProcessingException if the JSON string is invalid with respect to DeviceStatus
   */
  public static DeviceStatusResponse fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, DeviceStatusResponse.class);
  }

  /**
   * Convert an instance of DeviceStatus to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeviceStatusResponse that = (DeviceStatusResponse) o;
    return Objects.equals(deviceId, that.deviceId) && status == that.status;
  }

  @Override
  public int hashCode() {
    return Objects.hash(deviceId, status);
  }

  @Override
  public String toString() {
    return "DeviceStatusResponse{" + "deviceId='" + deviceId + '\'' + ", status=" + status + '}';
  }
}
