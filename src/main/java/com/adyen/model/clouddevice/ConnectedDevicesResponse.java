package com.adyen.model.clouddevice;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import java.util.Objects;

/** ConnectedDevicesResponse */
public class ConnectedDevicesResponse {

  List<String> uniqueDeviceIds = null;

  public List<String> getUniqueDeviceIds() {
    return uniqueDeviceIds;
  }

  public void setUniqueDeviceIds(List<String> uniqueDeviceIds) {
    this.uniqueDeviceIds = uniqueDeviceIds;
  }

  /**
   * Create an instance of ConnectedDevicesResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ConnectedDevicesResponse
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     ConnectedDevicesResponse
   */
  public static ConnectedDevicesResponse fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, ConnectedDevicesResponse.class);
  }

  /**
   * Convert an instance of ConnectedDevicesResponse to an JSON string
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
    ConnectedDevicesResponse that = (ConnectedDevicesResponse) o;
    return Objects.equals(uniqueDeviceIds, that.uniqueDeviceIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uniqueDeviceIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("ConnectedDevicesResponse{");
    sb.append("uniqueDeviceIds=").append(uniqueDeviceIds);
    sb.append('}');
    return sb.toString();
  }
}
