/*
 * Adyen Payout API
 *
 * The version of the OpenAPI document: 68
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.payout;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** FraudCheckResultWrapper */
@JsonPropertyOrder({FraudCheckResultWrapper.JSON_PROPERTY_FRAUD_CHECK_RESULT})
public class FraudCheckResultWrapper {
  public static final String JSON_PROPERTY_FRAUD_CHECK_RESULT = "FraudCheckResult";
  private FraudCheckResult fraudCheckResult;

  public FraudCheckResultWrapper() {}

  /**
   * fraudCheckResult
   *
   * @param fraudCheckResult
   * @return the current {@code FraudCheckResultWrapper} instance, allowing for method chaining
   */
  public FraudCheckResultWrapper fraudCheckResult(FraudCheckResult fraudCheckResult) {
    this.fraudCheckResult = fraudCheckResult;
    return this;
  }

  /**
   * Get fraudCheckResult
   *
   * @return fraudCheckResult
   */
  @JsonProperty(JSON_PROPERTY_FRAUD_CHECK_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public FraudCheckResult getFraudCheckResult() {
    return fraudCheckResult;
  }

  /**
   * fraudCheckResult
   *
   * @param fraudCheckResult
   */
  @JsonProperty(JSON_PROPERTY_FRAUD_CHECK_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFraudCheckResult(FraudCheckResult fraudCheckResult) {
    this.fraudCheckResult = fraudCheckResult;
  }

  /** Return true if this FraudCheckResultWrapper object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FraudCheckResultWrapper fraudCheckResultWrapper = (FraudCheckResultWrapper) o;
    return Objects.equals(this.fraudCheckResult, fraudCheckResultWrapper.fraudCheckResult);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fraudCheckResult);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudCheckResultWrapper {\n");
    sb.append("    fraudCheckResult: ").append(toIndentedString(fraudCheckResult)).append("\n");
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
   * Create an instance of FraudCheckResultWrapper given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of FraudCheckResultWrapper
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     FraudCheckResultWrapper
   */
  public static FraudCheckResultWrapper fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, FraudCheckResultWrapper.class);
  }

  /**
   * Convert an instance of FraudCheckResultWrapper to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
