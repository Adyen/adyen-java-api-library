package com.adyen.model.clouddevice;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Objects;

/** Status of the device */
public class DeviceStatusResponse {

  private String deviceId;
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
