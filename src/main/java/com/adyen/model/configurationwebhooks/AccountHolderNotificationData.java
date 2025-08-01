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

/** AccountHolderNotificationData */
@JsonPropertyOrder({
  AccountHolderNotificationData.JSON_PROPERTY_ACCOUNT_HOLDER,
  AccountHolderNotificationData.JSON_PROPERTY_BALANCE_PLATFORM
})
public class AccountHolderNotificationData {
  public static final String JSON_PROPERTY_ACCOUNT_HOLDER = "accountHolder";
  private AccountHolder accountHolder;

  public static final String JSON_PROPERTY_BALANCE_PLATFORM = "balancePlatform";
  private String balancePlatform;

  public AccountHolderNotificationData() {}

  /**
   * accountHolder
   *
   * @param accountHolder
   * @return the current {@code AccountHolderNotificationData} instance, allowing for method
   *     chaining
   */
  public AccountHolderNotificationData accountHolder(AccountHolder accountHolder) {
    this.accountHolder = accountHolder;
    return this;
  }

  /**
   * Get accountHolder
   *
   * @return accountHolder
   */
  @JsonProperty(JSON_PROPERTY_ACCOUNT_HOLDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public AccountHolder getAccountHolder() {
    return accountHolder;
  }

  /**
   * accountHolder
   *
   * @param accountHolder
   */
  @JsonProperty(JSON_PROPERTY_ACCOUNT_HOLDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccountHolder(AccountHolder accountHolder) {
    this.accountHolder = accountHolder;
  }

  /**
   * The unique identifier of the balance platform.
   *
   * @param balancePlatform The unique identifier of the balance platform.
   * @return the current {@code AccountHolderNotificationData} instance, allowing for method
   *     chaining
   */
  public AccountHolderNotificationData balancePlatform(String balancePlatform) {
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

  /** Return true if this AccountHolderNotificationData object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountHolderNotificationData accountHolderNotificationData = (AccountHolderNotificationData) o;
    return Objects.equals(this.accountHolder, accountHolderNotificationData.accountHolder)
        && Objects.equals(this.balancePlatform, accountHolderNotificationData.balancePlatform);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountHolder, balancePlatform);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountHolderNotificationData {\n");
    sb.append("    accountHolder: ").append(toIndentedString(accountHolder)).append("\n");
    sb.append("    balancePlatform: ").append(toIndentedString(balancePlatform)).append("\n");
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
   * Create an instance of AccountHolderNotificationData given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of AccountHolderNotificationData
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     AccountHolderNotificationData
   */
  public static AccountHolderNotificationData fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, AccountHolderNotificationData.class);
  }

  /**
   * Convert an instance of AccountHolderNotificationData to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
