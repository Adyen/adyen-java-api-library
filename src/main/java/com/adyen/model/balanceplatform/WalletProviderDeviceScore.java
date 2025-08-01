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

/** WalletProviderDeviceScore */
@JsonPropertyOrder({
  WalletProviderDeviceScore.JSON_PROPERTY_OPERATION,
  WalletProviderDeviceScore.JSON_PROPERTY_VALUE
})
public class WalletProviderDeviceScore {
  public static final String JSON_PROPERTY_OPERATION = "operation";
  private String operation;

  public static final String JSON_PROPERTY_VALUE = "value";
  private Integer value;

  public WalletProviderDeviceScore() {}

  /**
   * Defines how the condition must be evaluated.
   *
   * @param operation Defines how the condition must be evaluated.
   * @return the current {@code WalletProviderDeviceScore} instance, allowing for method chaining
   */
  public WalletProviderDeviceScore operation(String operation) {
    this.operation = operation;
    return this;
  }

  /**
   * Defines how the condition must be evaluated.
   *
   * @return operation Defines how the condition must be evaluated.
   */
  @JsonProperty(JSON_PROPERTY_OPERATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getOperation() {
    return operation;
  }

  /**
   * Defines how the condition must be evaluated.
   *
   * @param operation Defines how the condition must be evaluated.
   */
  @JsonProperty(JSON_PROPERTY_OPERATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOperation(String operation) {
    this.operation = operation;
  }

  /**
   * value
   *
   * @param value
   * @return the current {@code WalletProviderDeviceScore} instance, allowing for method chaining
   */
  public WalletProviderDeviceScore value(Integer value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   *
   * @return value
   */
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getValue() {
    return value;
  }

  /**
   * value
   *
   * @param value
   */
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValue(Integer value) {
    this.value = value;
  }

  /** Return true if this WalletProviderDeviceScore object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WalletProviderDeviceScore walletProviderDeviceScore = (WalletProviderDeviceScore) o;
    return Objects.equals(this.operation, walletProviderDeviceScore.operation)
        && Objects.equals(this.value, walletProviderDeviceScore.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operation, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WalletProviderDeviceScore {\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
   * Create an instance of WalletProviderDeviceScore given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of WalletProviderDeviceScore
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     WalletProviderDeviceScore
   */
  public static WalletProviderDeviceScore fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, WalletProviderDeviceScore.class);
  }

  /**
   * Convert an instance of WalletProviderDeviceScore to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
