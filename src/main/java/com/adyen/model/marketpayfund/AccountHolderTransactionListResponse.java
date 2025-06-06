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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** AccountHolderTransactionListResponse */
@JsonPropertyOrder({
  AccountHolderTransactionListResponse.JSON_PROPERTY_ACCOUNT_TRANSACTION_LISTS,
  AccountHolderTransactionListResponse.JSON_PROPERTY_INVALID_FIELDS,
  AccountHolderTransactionListResponse.JSON_PROPERTY_PSP_REFERENCE,
  AccountHolderTransactionListResponse.JSON_PROPERTY_RESULT_CODE
})
public class AccountHolderTransactionListResponse {
  public static final String JSON_PROPERTY_ACCOUNT_TRANSACTION_LISTS = "accountTransactionLists";
  private List<AccountTransactionList> accountTransactionLists = null;

  public static final String JSON_PROPERTY_INVALID_FIELDS = "invalidFields";
  private List<ErrorFieldType> invalidFields = null;

  public static final String JSON_PROPERTY_PSP_REFERENCE = "pspReference";
  private String pspReference;

  public static final String JSON_PROPERTY_RESULT_CODE = "resultCode";
  private String resultCode;

  public AccountHolderTransactionListResponse() {}

  public AccountHolderTransactionListResponse accountTransactionLists(
      List<AccountTransactionList> accountTransactionLists) {
    this.accountTransactionLists = accountTransactionLists;
    return this;
  }

  public AccountHolderTransactionListResponse addAccountTransactionListsItem(
      AccountTransactionList accountTransactionListsItem) {
    if (this.accountTransactionLists == null) {
      this.accountTransactionLists = new ArrayList<>();
    }
    this.accountTransactionLists.add(accountTransactionListsItem);
    return this;
  }

  /**
   * A list of the transactions.
   *
   * @return accountTransactionLists
   */
  @ApiModelProperty(value = "A list of the transactions.")
  @JsonProperty(JSON_PROPERTY_ACCOUNT_TRANSACTION_LISTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<AccountTransactionList> getAccountTransactionLists() {
    return accountTransactionLists;
  }

  @JsonProperty(JSON_PROPERTY_ACCOUNT_TRANSACTION_LISTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccountTransactionLists(List<AccountTransactionList> accountTransactionLists) {
    this.accountTransactionLists = accountTransactionLists;
  }

  public AccountHolderTransactionListResponse invalidFields(List<ErrorFieldType> invalidFields) {
    this.invalidFields = invalidFields;
    return this;
  }

  public AccountHolderTransactionListResponse addInvalidFieldsItem(
      ErrorFieldType invalidFieldsItem) {
    if (this.invalidFields == null) {
      this.invalidFields = new ArrayList<>();
    }
    this.invalidFields.add(invalidFieldsItem);
    return this;
  }

  /**
   * Contains field validation errors that would prevent requests from being processed.
   *
   * @return invalidFields
   */
  @ApiModelProperty(
      value = "Contains field validation errors that would prevent requests from being processed.")
  @JsonProperty(JSON_PROPERTY_INVALID_FIELDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<ErrorFieldType> getInvalidFields() {
    return invalidFields;
  }

  @JsonProperty(JSON_PROPERTY_INVALID_FIELDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInvalidFields(List<ErrorFieldType> invalidFields) {
    this.invalidFields = invalidFields;
  }

  public AccountHolderTransactionListResponse pspReference(String pspReference) {
    this.pspReference = pspReference;
    return this;
  }

  /**
   * The reference of a request. Can be used to uniquely identify the request.
   *
   * @return pspReference
   */
  @ApiModelProperty(
      value = "The reference of a request. Can be used to uniquely identify the request.")
  @JsonProperty(JSON_PROPERTY_PSP_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPspReference() {
    return pspReference;
  }

  @JsonProperty(JSON_PROPERTY_PSP_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPspReference(String pspReference) {
    this.pspReference = pspReference;
  }

  public AccountHolderTransactionListResponse resultCode(String resultCode) {
    this.resultCode = resultCode;
    return this;
  }

  /**
   * The result code.
   *
   * @return resultCode
   */
  @ApiModelProperty(value = "The result code.")
  @JsonProperty(JSON_PROPERTY_RESULT_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getResultCode() {
    return resultCode;
  }

  @JsonProperty(JSON_PROPERTY_RESULT_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
  }

  /** Return true if this AccountHolderTransactionListResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountHolderTransactionListResponse accountHolderTransactionListResponse =
        (AccountHolderTransactionListResponse) o;
    return Objects.equals(
            this.accountTransactionLists,
            accountHolderTransactionListResponse.accountTransactionLists)
        && Objects.equals(this.invalidFields, accountHolderTransactionListResponse.invalidFields)
        && Objects.equals(this.pspReference, accountHolderTransactionListResponse.pspReference)
        && Objects.equals(this.resultCode, accountHolderTransactionListResponse.resultCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountTransactionLists, invalidFields, pspReference, resultCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountHolderTransactionListResponse {\n");
    sb.append("    accountTransactionLists: ")
        .append(toIndentedString(accountTransactionLists))
        .append("\n");
    sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
    sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
    sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
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
   * Create an instance of AccountHolderTransactionListResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of AccountHolderTransactionListResponse
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     AccountHolderTransactionListResponse
   */
  public static AccountHolderTransactionListResponse fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, AccountHolderTransactionListResponse.class);
  }

  /**
   * Convert an instance of AccountHolderTransactionListResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
