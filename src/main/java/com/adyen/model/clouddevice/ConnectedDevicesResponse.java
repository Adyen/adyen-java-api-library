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
import java.util.List;
import java.util.Objects;
import tools.jackson.core.JacksonException;

/** ConnectedDevicesResponse */
public class ConnectedDevicesResponse {
  @JsonProperty("uniqueDeviceIds")
  private List<String> uniqueDeviceIds = null;

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
   * @throws JacksonException if the JSON string is invalid with respect to ConnectedDevicesResponse
   */
  public static ConnectedDevicesResponse fromJson(String jsonString) throws JacksonException {
    return JSON.getMapper().readValue(jsonString, ConnectedDevicesResponse.class);
  }

  /**
   * Convert an instance of ConnectedDevicesResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JacksonException {
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
