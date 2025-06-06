/*
 * Fund API
 * This API is used for the classic integration. If you are just starting your implementation, refer to our [new integration guide](https://docs.adyen.com/marketplaces-and-platforms) instead.  The Fund API provides endpoints for managing the funds in the accounts on your platform. These management operations include, for example, the transfer of funds from one account to another, the payout of funds to an account holder, and the retrieval of balances in an account.  For more information, refer to our [documentation](https://docs.adyen.com/marketplaces-and-platforms/classic/). ## Authentication Your Adyen contact will provide your API credential and an API key. To connect to the API, add an `X-API-Key` header with the API key as the value, for example:   ``` curl -H \"Content-Type: application/json\" \\ -H \"X-API-Key: YOUR_API_KEY\" \\ ... ```  Alternatively, you can use the username and password to connect to the API using basic authentication. For example:  ``` curl -U \"ws@MarketPlace.YOUR_PLATFORM_ACCOUNT\":\"YOUR_WS_PASSWORD\" \\ -H \"Content-Type: application/json\" \\ ... ``` When going live, you need to generate new web service user credentials to access the [live endpoints](https://docs.adyen.com/development-resources/live-endpoints).  ## Versioning The Fund API supports [versioning](https://docs.adyen.com/development-resources/versioning) using a version suffix in the endpoint URL. This suffix has the following format: \"vXX\", where XX is the version number.  For example: ``` https://cal-test.adyen.com/cal/services/Fund/v6/accountHolderBalance ```
 *
 * The version of the OpenAPI document: 6
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.marketpayfund;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/** AccountHolderBalanceRequest */
@JsonPropertyOrder({AccountHolderBalanceRequest.JSON_PROPERTY_ACCOUNT_HOLDER_CODE})
public class AccountHolderBalanceRequest {
  public static final String JSON_PROPERTY_ACCOUNT_HOLDER_CODE = "accountHolderCode";
  private String accountHolderCode;

  public AccountHolderBalanceRequest() {}

  public AccountHolderBalanceRequest accountHolderCode(String accountHolderCode) {
    this.accountHolderCode = accountHolderCode;
    return this;
  }

  /**
   * The code of the Account Holder of which to retrieve the balance.
   *
   * @return accountHolderCode
   */
  @ApiModelProperty(
      required = true,
      value = "The code of the Account Holder of which to retrieve the balance.")
  @JsonProperty(JSON_PROPERTY_ACCOUNT_HOLDER_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAccountHolderCode() {
    return accountHolderCode;
  }

  @JsonProperty(JSON_PROPERTY_ACCOUNT_HOLDER_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccountHolderCode(String accountHolderCode) {
    this.accountHolderCode = accountHolderCode;
  }

  /** Return true if this AccountHolderBalanceRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountHolderBalanceRequest accountHolderBalanceRequest = (AccountHolderBalanceRequest) o;
    return Objects.equals(this.accountHolderCode, accountHolderBalanceRequest.accountHolderCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountHolderCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountHolderBalanceRequest {\n");
    sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
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
   * Create an instance of AccountHolderBalanceRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of AccountHolderBalanceRequest
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     AccountHolderBalanceRequest
   */
  public static AccountHolderBalanceRequest fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, AccountHolderBalanceRequest.class);
  }

  /**
   * Convert an instance of AccountHolderBalanceRequest to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
