/*
 * Classic Platforms - Notifications
 *
 * The version of the OpenAPI document: 6
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.marketpaywebhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.Objects;

/** AccountFundsBelowThresholdNotificationContent */
@JsonPropertyOrder({
  AccountFundsBelowThresholdNotificationContent.JSON_PROPERTY_ACCOUNT_CODE,
  AccountFundsBelowThresholdNotificationContent.JSON_PROPERTY_BALANCE_DATE,
  AccountFundsBelowThresholdNotificationContent.JSON_PROPERTY_CURRENT_FUNDS,
  AccountFundsBelowThresholdNotificationContent.JSON_PROPERTY_FUND_THRESHOLD,
  AccountFundsBelowThresholdNotificationContent.JSON_PROPERTY_MERCHANT_ACCOUNT_CODE
})
public class AccountFundsBelowThresholdNotificationContent {
  public static final String JSON_PROPERTY_ACCOUNT_CODE = "accountCode";
  private String accountCode;

  public static final String JSON_PROPERTY_BALANCE_DATE = "balanceDate";
  private LocalDate balanceDate;

  public static final String JSON_PROPERTY_CURRENT_FUNDS = "currentFunds";
  private Amount currentFunds;

  public static final String JSON_PROPERTY_FUND_THRESHOLD = "fundThreshold";
  private Amount fundThreshold;

  public static final String JSON_PROPERTY_MERCHANT_ACCOUNT_CODE = "merchantAccountCode";
  private String merchantAccountCode;

  public AccountFundsBelowThresholdNotificationContent() {}

  public AccountFundsBelowThresholdNotificationContent accountCode(String accountCode) {
    this.accountCode = accountCode;
    return this;
  }

  /**
   * The code of the account with funds under threshold
   *
   * @return accountCode
   */
  @ApiModelProperty(value = "The code of the account with funds under threshold")
  @JsonProperty(JSON_PROPERTY_ACCOUNT_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAccountCode() {
    return accountCode;
  }

  @JsonProperty(JSON_PROPERTY_ACCOUNT_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccountCode(String accountCode) {
    this.accountCode = accountCode;
  }

  public AccountFundsBelowThresholdNotificationContent balanceDate(LocalDate balanceDate) {
    this.balanceDate = balanceDate;
    return this;
  }

  /**
   * Get balanceDate
   *
   * @return balanceDate
   */
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BALANCE_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public LocalDate getBalanceDate() {
    return balanceDate;
  }

  @JsonProperty(JSON_PROPERTY_BALANCE_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBalanceDate(LocalDate balanceDate) {
    this.balanceDate = balanceDate;
  }

  public AccountFundsBelowThresholdNotificationContent currentFunds(Amount currentFunds) {
    this.currentFunds = currentFunds;
    return this;
  }

  /**
   * Get currentFunds
   *
   * @return currentFunds
   */
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CURRENT_FUNDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Amount getCurrentFunds() {
    return currentFunds;
  }

  @JsonProperty(JSON_PROPERTY_CURRENT_FUNDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCurrentFunds(Amount currentFunds) {
    this.currentFunds = currentFunds;
  }

  public AccountFundsBelowThresholdNotificationContent fundThreshold(Amount fundThreshold) {
    this.fundThreshold = fundThreshold;
    return this;
  }

  /**
   * Get fundThreshold
   *
   * @return fundThreshold
   */
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_FUND_THRESHOLD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Amount getFundThreshold() {
    return fundThreshold;
  }

  @JsonProperty(JSON_PROPERTY_FUND_THRESHOLD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFundThreshold(Amount fundThreshold) {
    this.fundThreshold = fundThreshold;
  }

  public AccountFundsBelowThresholdNotificationContent merchantAccountCode(
      String merchantAccountCode) {
    this.merchantAccountCode = merchantAccountCode;
    return this;
  }

  /**
   * The code of the merchant account.
   *
   * @return merchantAccountCode
   */
  @ApiModelProperty(required = true, value = "The code of the merchant account.")
  @JsonProperty(JSON_PROPERTY_MERCHANT_ACCOUNT_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMerchantAccountCode() {
    return merchantAccountCode;
  }

  @JsonProperty(JSON_PROPERTY_MERCHANT_ACCOUNT_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMerchantAccountCode(String merchantAccountCode) {
    this.merchantAccountCode = merchantAccountCode;
  }

  /** Return true if this AccountFundsBelowThresholdNotificationContent object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountFundsBelowThresholdNotificationContent accountFundsBelowThresholdNotificationContent =
        (AccountFundsBelowThresholdNotificationContent) o;
    return Objects.equals(
            this.accountCode, accountFundsBelowThresholdNotificationContent.accountCode)
        && Objects.equals(
            this.balanceDate, accountFundsBelowThresholdNotificationContent.balanceDate)
        && Objects.equals(
            this.currentFunds, accountFundsBelowThresholdNotificationContent.currentFunds)
        && Objects.equals(
            this.fundThreshold, accountFundsBelowThresholdNotificationContent.fundThreshold)
        && Objects.equals(
            this.merchantAccountCode,
            accountFundsBelowThresholdNotificationContent.merchantAccountCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountCode, balanceDate, currentFunds, fundThreshold, merchantAccountCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountFundsBelowThresholdNotificationContent {\n");
    sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
    sb.append("    balanceDate: ").append(toIndentedString(balanceDate)).append("\n");
    sb.append("    currentFunds: ").append(toIndentedString(currentFunds)).append("\n");
    sb.append("    fundThreshold: ").append(toIndentedString(fundThreshold)).append("\n");
    sb.append("    merchantAccountCode: ")
        .append(toIndentedString(merchantAccountCode))
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
   * Create an instance of AccountFundsBelowThresholdNotificationContent given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of AccountFundsBelowThresholdNotificationContent
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     AccountFundsBelowThresholdNotificationContent
   */
  public static AccountFundsBelowThresholdNotificationContent fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper()
        .readValue(jsonString, AccountFundsBelowThresholdNotificationContent.class);
  }

  /**
   * Convert an instance of AccountFundsBelowThresholdNotificationContent to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
