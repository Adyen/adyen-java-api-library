/*
 * Configuration webhooks
 *
 * The version of the OpenAPI document: 2
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.configurationwebhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** SweepConfigurationNotificationData */
@JsonPropertyOrder({
  SweepConfigurationNotificationData.JSON_PROPERTY_ACCOUNT_ID,
  SweepConfigurationNotificationData.JSON_PROPERTY_BALANCE_PLATFORM,
  SweepConfigurationNotificationData.JSON_PROPERTY_SWEEP
})
public class SweepConfigurationNotificationData {
  public static final String JSON_PROPERTY_ACCOUNT_ID = "accountId";
  private String accountId;

  public static final String JSON_PROPERTY_BALANCE_PLATFORM = "balancePlatform";
  private String balancePlatform;

  public static final String JSON_PROPERTY_SWEEP = "sweep";
  private SweepConfigurationV2 sweep;

  public SweepConfigurationNotificationData() {}

  /**
   * The unique identifier of the balance account for which the sweep was configured.
   *
   * @param accountId The unique identifier of the balance account for which the sweep was
   *     configured.
   * @return the current {@code SweepConfigurationNotificationData} instance, allowing for method
   *     chaining
   */
  public SweepConfigurationNotificationData accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * The unique identifier of the balance account for which the sweep was configured.
   *
   * @return accountId The unique identifier of the balance account for which the sweep was
   *     configured.
   */
  @JsonProperty(JSON_PROPERTY_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAccountId() {
    return accountId;
  }

  /**
   * The unique identifier of the balance account for which the sweep was configured.
   *
   * @param accountId The unique identifier of the balance account for which the sweep was
   *     configured.
   */
  @JsonProperty(JSON_PROPERTY_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  /**
   * The unique identifier of the balance platform.
   *
   * @param balancePlatform The unique identifier of the balance platform.
   * @return the current {@code SweepConfigurationNotificationData} instance, allowing for method
   *     chaining
   */
  public SweepConfigurationNotificationData balancePlatform(String balancePlatform) {
    this.balancePlatform = balancePlatform;
    return this;
  }

  /**
   * The unique identifier of the balance platform.
   *
   * @return balancePlatform The unique identifier of the balance platform.
   */
  @JsonProperty(JSON_PROPERTY_BALANCE_PLATFORM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getBalancePlatform() {
    return balancePlatform;
  }

  /**
   * The unique identifier of the balance platform.
   *
   * @param balancePlatform The unique identifier of the balance platform.
   */
  @JsonProperty(JSON_PROPERTY_BALANCE_PLATFORM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBalancePlatform(String balancePlatform) {
    this.balancePlatform = balancePlatform;
  }

  /**
   * sweep
   *
   * @param sweep
   * @return the current {@code SweepConfigurationNotificationData} instance, allowing for method
   *     chaining
   */
  public SweepConfigurationNotificationData sweep(SweepConfigurationV2 sweep) {
    this.sweep = sweep;
    return this;
  }

  /**
   * Get sweep
   *
   * @return sweep
   */
  @JsonProperty(JSON_PROPERTY_SWEEP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SweepConfigurationV2 getSweep() {
    return sweep;
  }

  /**
   * sweep
   *
   * @param sweep
   */
  @JsonProperty(JSON_PROPERTY_SWEEP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSweep(SweepConfigurationV2 sweep) {
    this.sweep = sweep;
  }

  /** Return true if this SweepConfigurationNotificationData object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SweepConfigurationNotificationData sweepConfigurationNotificationData =
        (SweepConfigurationNotificationData) o;
    return Objects.equals(this.accountId, sweepConfigurationNotificationData.accountId)
        && Objects.equals(this.balancePlatform, sweepConfigurationNotificationData.balancePlatform)
        && Objects.equals(this.sweep, sweepConfigurationNotificationData.sweep);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, balancePlatform, sweep);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SweepConfigurationNotificationData {\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    balancePlatform: ").append(toIndentedString(balancePlatform)).append("\n");
    sb.append("    sweep: ").append(toIndentedString(sweep)).append("\n");
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
   * Create an instance of SweepConfigurationNotificationData given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of SweepConfigurationNotificationData
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     SweepConfigurationNotificationData
   */
  public static SweepConfigurationNotificationData fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, SweepConfigurationNotificationData.class);
  }

  /**
   * Convert an instance of SweepConfigurationNotificationData to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
