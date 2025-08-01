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

/** StoreSplitConfiguration */
@JsonPropertyOrder({
  StoreSplitConfiguration.JSON_PROPERTY_BALANCE_ACCOUNT_ID,
  StoreSplitConfiguration.JSON_PROPERTY_SPLIT_CONFIGURATION_ID
})
public class StoreSplitConfiguration {
  public static final String JSON_PROPERTY_BALANCE_ACCOUNT_ID = "balanceAccountId";
  private String balanceAccountId;

  public static final String JSON_PROPERTY_SPLIT_CONFIGURATION_ID = "splitConfigurationId";
  private String splitConfigurationId;

  public StoreSplitConfiguration() {}

  /**
   * The [unique identifier of the balance
   * account](https://docs.adyen.com/api-explorer/#/balanceplatform/latest/get/balanceAccounts/{id}__queryParam_id)
   * to which the split amount must be booked, depending on the defined [split
   * logic](https://docs.adyen.com/api-explorer/Management/latest/post/merchants/_merchantId_/splitConfigurations#request-rules-splitLogic).
   *
   * @param balanceAccountId The [unique identifier of the balance
   *     account](https://docs.adyen.com/api-explorer/#/balanceplatform/latest/get/balanceAccounts/{id}__queryParam_id)
   *     to which the split amount must be booked, depending on the defined [split
   *     logic](https://docs.adyen.com/api-explorer/Management/latest/post/merchants/_merchantId_/splitConfigurations#request-rules-splitLogic).
   * @return the current {@code StoreSplitConfiguration} instance, allowing for method chaining
   */
  public StoreSplitConfiguration balanceAccountId(String balanceAccountId) {
    this.balanceAccountId = balanceAccountId;
    return this;
  }

  /**
   * The [unique identifier of the balance
   * account](https://docs.adyen.com/api-explorer/#/balanceplatform/latest/get/balanceAccounts/{id}__queryParam_id)
   * to which the split amount must be booked, depending on the defined [split
   * logic](https://docs.adyen.com/api-explorer/Management/latest/post/merchants/_merchantId_/splitConfigurations#request-rules-splitLogic).
   *
   * @return balanceAccountId The [unique identifier of the balance
   *     account](https://docs.adyen.com/api-explorer/#/balanceplatform/latest/get/balanceAccounts/{id}__queryParam_id)
   *     to which the split amount must be booked, depending on the defined [split
   *     logic](https://docs.adyen.com/api-explorer/Management/latest/post/merchants/_merchantId_/splitConfigurations#request-rules-splitLogic).
   */
  @JsonProperty(JSON_PROPERTY_BALANCE_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getBalanceAccountId() {
    return balanceAccountId;
  }

  /**
   * The [unique identifier of the balance
   * account](https://docs.adyen.com/api-explorer/#/balanceplatform/latest/get/balanceAccounts/{id}__queryParam_id)
   * to which the split amount must be booked, depending on the defined [split
   * logic](https://docs.adyen.com/api-explorer/Management/latest/post/merchants/_merchantId_/splitConfigurations#request-rules-splitLogic).
   *
   * @param balanceAccountId The [unique identifier of the balance
   *     account](https://docs.adyen.com/api-explorer/#/balanceplatform/latest/get/balanceAccounts/{id}__queryParam_id)
   *     to which the split amount must be booked, depending on the defined [split
   *     logic](https://docs.adyen.com/api-explorer/Management/latest/post/merchants/_merchantId_/splitConfigurations#request-rules-splitLogic).
   */
  @JsonProperty(JSON_PROPERTY_BALANCE_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBalanceAccountId(String balanceAccountId) {
    this.balanceAccountId = balanceAccountId;
  }

  /**
   * The unique identifier of the [split configuration
   * profile](https://docs.adyen.com/platforms/automatic-split-configuration/create-split-configuration/).
   *
   * @param splitConfigurationId The unique identifier of the [split configuration
   *     profile](https://docs.adyen.com/platforms/automatic-split-configuration/create-split-configuration/).
   * @return the current {@code StoreSplitConfiguration} instance, allowing for method chaining
   */
  public StoreSplitConfiguration splitConfigurationId(String splitConfigurationId) {
    this.splitConfigurationId = splitConfigurationId;
    return this;
  }

  /**
   * The unique identifier of the [split configuration
   * profile](https://docs.adyen.com/platforms/automatic-split-configuration/create-split-configuration/).
   *
   * @return splitConfigurationId The unique identifier of the [split configuration
   *     profile](https://docs.adyen.com/platforms/automatic-split-configuration/create-split-configuration/).
   */
  @JsonProperty(JSON_PROPERTY_SPLIT_CONFIGURATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getSplitConfigurationId() {
    return splitConfigurationId;
  }

  /**
   * The unique identifier of the [split configuration
   * profile](https://docs.adyen.com/platforms/automatic-split-configuration/create-split-configuration/).
   *
   * @param splitConfigurationId The unique identifier of the [split configuration
   *     profile](https://docs.adyen.com/platforms/automatic-split-configuration/create-split-configuration/).
   */
  @JsonProperty(JSON_PROPERTY_SPLIT_CONFIGURATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSplitConfigurationId(String splitConfigurationId) {
    this.splitConfigurationId = splitConfigurationId;
  }

  /** Return true if this StoreSplitConfiguration object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoreSplitConfiguration storeSplitConfiguration = (StoreSplitConfiguration) o;
    return Objects.equals(this.balanceAccountId, storeSplitConfiguration.balanceAccountId)
        && Objects.equals(this.splitConfigurationId, storeSplitConfiguration.splitConfigurationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(balanceAccountId, splitConfigurationId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StoreSplitConfiguration {\n");
    sb.append("    balanceAccountId: ").append(toIndentedString(balanceAccountId)).append("\n");
    sb.append("    splitConfigurationId: ")
        .append(toIndentedString(splitConfigurationId))
        .append("\n");
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
   * Create an instance of StoreSplitConfiguration given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of StoreSplitConfiguration
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     StoreSplitConfiguration
   */
  public static StoreSplitConfiguration fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, StoreSplitConfiguration.class);
  }

  /**
   * Convert an instance of StoreSplitConfiguration to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
