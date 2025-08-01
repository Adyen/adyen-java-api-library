/*
 * Configuration API
 *
 * The version of the OpenAPI document: 2
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.balanceplatform;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** NetworkTokenActivationDataRequest */
@JsonPropertyOrder({NetworkTokenActivationDataRequest.JSON_PROPERTY_SDK_OUTPUT})
public class NetworkTokenActivationDataRequest {
  public static final String JSON_PROPERTY_SDK_OUTPUT = "sdkOutput";
  private String sdkOutput;

  public NetworkTokenActivationDataRequest() {}

  /**
   * A block of data automatically generated by Adyen&#39;s SDK for network token provisioning. This
   * &#x60;sdkOutput&#x60; is required to create provisioning data for the network token. For more
   * information, see the repositories for Adyen&#39;s SDKs for network token provisioning: * [Adyen
   * Apple Pay Provisioning SDK](https://github.com/Adyen/adyen-apple-pay-provisioning-ios). *
   * [Adyen Google Wallet Provisioning SDK](https://github.com/Adyen/adyen-issuing-android)
   *
   * @param sdkOutput A block of data automatically generated by Adyen&#39;s SDK for network token
   *     provisioning. This &#x60;sdkOutput&#x60; is required to create provisioning data for the
   *     network token. For more information, see the repositories for Adyen&#39;s SDKs for network
   *     token provisioning: * [Adyen Apple Pay Provisioning
   *     SDK](https://github.com/Adyen/adyen-apple-pay-provisioning-ios). * [Adyen Google Wallet
   *     Provisioning SDK](https://github.com/Adyen/adyen-issuing-android)
   * @return the current {@code NetworkTokenActivationDataRequest} instance, allowing for method
   *     chaining
   */
  public NetworkTokenActivationDataRequest sdkOutput(String sdkOutput) {
    this.sdkOutput = sdkOutput;
    return this;
  }

  /**
   * A block of data automatically generated by Adyen&#39;s SDK for network token provisioning. This
   * &#x60;sdkOutput&#x60; is required to create provisioning data for the network token. For more
   * information, see the repositories for Adyen&#39;s SDKs for network token provisioning: * [Adyen
   * Apple Pay Provisioning SDK](https://github.com/Adyen/adyen-apple-pay-provisioning-ios). *
   * [Adyen Google Wallet Provisioning SDK](https://github.com/Adyen/adyen-issuing-android)
   *
   * @return sdkOutput A block of data automatically generated by Adyen&#39;s SDK for network token
   *     provisioning. This &#x60;sdkOutput&#x60; is required to create provisioning data for the
   *     network token. For more information, see the repositories for Adyen&#39;s SDKs for network
   *     token provisioning: * [Adyen Apple Pay Provisioning
   *     SDK](https://github.com/Adyen/adyen-apple-pay-provisioning-ios). * [Adyen Google Wallet
   *     Provisioning SDK](https://github.com/Adyen/adyen-issuing-android)
   */
  @JsonProperty(JSON_PROPERTY_SDK_OUTPUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getSdkOutput() {
    return sdkOutput;
  }

  /**
   * A block of data automatically generated by Adyen&#39;s SDK for network token provisioning. This
   * &#x60;sdkOutput&#x60; is required to create provisioning data for the network token. For more
   * information, see the repositories for Adyen&#39;s SDKs for network token provisioning: * [Adyen
   * Apple Pay Provisioning SDK](https://github.com/Adyen/adyen-apple-pay-provisioning-ios). *
   * [Adyen Google Wallet Provisioning SDK](https://github.com/Adyen/adyen-issuing-android)
   *
   * @param sdkOutput A block of data automatically generated by Adyen&#39;s SDK for network token
   *     provisioning. This &#x60;sdkOutput&#x60; is required to create provisioning data for the
   *     network token. For more information, see the repositories for Adyen&#39;s SDKs for network
   *     token provisioning: * [Adyen Apple Pay Provisioning
   *     SDK](https://github.com/Adyen/adyen-apple-pay-provisioning-ios). * [Adyen Google Wallet
   *     Provisioning SDK](https://github.com/Adyen/adyen-issuing-android)
   */
  @JsonProperty(JSON_PROPERTY_SDK_OUTPUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSdkOutput(String sdkOutput) {
    this.sdkOutput = sdkOutput;
  }

  /** Return true if this NetworkTokenActivationDataRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkTokenActivationDataRequest networkTokenActivationDataRequest =
        (NetworkTokenActivationDataRequest) o;
    return Objects.equals(this.sdkOutput, networkTokenActivationDataRequest.sdkOutput);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sdkOutput);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkTokenActivationDataRequest {\n");
    sb.append("    sdkOutput: ").append(toIndentedString(sdkOutput)).append("\n");
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
   * Create an instance of NetworkTokenActivationDataRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of NetworkTokenActivationDataRequest
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     NetworkTokenActivationDataRequest
   */
  public static NetworkTokenActivationDataRequest fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, NetworkTokenActivationDataRequest.class);
  }

  /**
   * Convert an instance of NetworkTokenActivationDataRequest to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
