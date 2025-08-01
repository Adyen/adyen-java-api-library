/*
 * Management API
 *
 * The version of the OpenAPI document: 3
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.management;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** TerminalConnectivityBluetooth */
@JsonPropertyOrder({
  TerminalConnectivityBluetooth.JSON_PROPERTY_IP_ADDRESS,
  TerminalConnectivityBluetooth.JSON_PROPERTY_MAC_ADDRESS
})
public class TerminalConnectivityBluetooth {
  public static final String JSON_PROPERTY_IP_ADDRESS = "ipAddress";
  private String ipAddress;

  public static final String JSON_PROPERTY_MAC_ADDRESS = "macAddress";
  private String macAddress;

  public TerminalConnectivityBluetooth() {}

  /**
   * The terminal&#39;s Bluetooth IP address.
   *
   * @param ipAddress The terminal&#39;s Bluetooth IP address.
   * @return the current {@code TerminalConnectivityBluetooth} instance, allowing for method
   *     chaining
   */
  public TerminalConnectivityBluetooth ipAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return this;
  }

  /**
   * The terminal&#39;s Bluetooth IP address.
   *
   * @return ipAddress The terminal&#39;s Bluetooth IP address.
   */
  @JsonProperty(JSON_PROPERTY_IP_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getIpAddress() {
    return ipAddress;
  }

  /**
   * The terminal&#39;s Bluetooth IP address.
   *
   * @param ipAddress The terminal&#39;s Bluetooth IP address.
   */
  @JsonProperty(JSON_PROPERTY_IP_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  /**
   * The terminal&#39;s Bluetooth MAC address.
   *
   * @param macAddress The terminal&#39;s Bluetooth MAC address.
   * @return the current {@code TerminalConnectivityBluetooth} instance, allowing for method
   *     chaining
   */
  public TerminalConnectivityBluetooth macAddress(String macAddress) {
    this.macAddress = macAddress;
    return this;
  }

  /**
   * The terminal&#39;s Bluetooth MAC address.
   *
   * @return macAddress The terminal&#39;s Bluetooth MAC address.
   */
  @JsonProperty(JSON_PROPERTY_MAC_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMacAddress() {
    return macAddress;
  }

  /**
   * The terminal&#39;s Bluetooth MAC address.
   *
   * @param macAddress The terminal&#39;s Bluetooth MAC address.
   */
  @JsonProperty(JSON_PROPERTY_MAC_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMacAddress(String macAddress) {
    this.macAddress = macAddress;
  }

  /** Return true if this TerminalConnectivityBluetooth object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TerminalConnectivityBluetooth terminalConnectivityBluetooth = (TerminalConnectivityBluetooth) o;
    return Objects.equals(this.ipAddress, terminalConnectivityBluetooth.ipAddress)
        && Objects.equals(this.macAddress, terminalConnectivityBluetooth.macAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ipAddress, macAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TerminalConnectivityBluetooth {\n");
    sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
    sb.append("    macAddress: ").append(toIndentedString(macAddress)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Create an instance of TerminalConnectivityBluetooth given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of TerminalConnectivityBluetooth
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     TerminalConnectivityBluetooth
   */
  public static TerminalConnectivityBluetooth fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, TerminalConnectivityBluetooth.class);
  }

  /**
   * Convert an instance of TerminalConnectivityBluetooth to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
