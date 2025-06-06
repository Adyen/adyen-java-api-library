/*
 * Account API
 * This API is used for the classic integration. If you are just starting your implementation, refer to our [new integration guide](https://docs.adyen.com/marketplaces-and-platforms) instead.  The Account API provides endpoints for managing account-related entities on your platform. These related entities include account holders, accounts, bank accounts, shareholders, and verification-related documents. The management operations include actions such as creation, retrieval, updating, and deletion of them.  For more information, refer to our [documentation](https://docs.adyen.com/marketplaces-and-platforms/classic). ## Authentication Your Adyen contact will provide your API credential and an API key. To connect to the API, add an `X-API-Key` header with the API key as the value, for example:   ``` curl -H \"Content-Type: application/json\" \\ -H \"X-API-Key: YOUR_API_KEY\" \\ ... ```  Alternatively, you can use the username and password to connect to the API using basic authentication. For example:  ``` curl -U \"ws@MarketPlace.YOUR_PLATFORM_ACCOUNT\":\"YOUR_WS_PASSWORD\" \\ -H \"Content-Type: application/json\" \\ ... ``` When going live, you need to generate new web service user credentials to access the [live endpoints](https://docs.adyen.com/development-resources/live-endpoints).  ## Versioning The Account API supports [versioning](https://docs.adyen.com/development-resources/versioning) using a version suffix in the endpoint URL. This suffix has the following format: \"vXX\", where XX is the version number.  For example: ``` https://cal-test.adyen.com/cal/services/Account/v6/createAccountHolder ```
 *
 * The version of the OpenAPI document: 6
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.marketpayaccount;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** CreateAccountRequest */
@JsonPropertyOrder({
  CreateAccountRequest.JSON_PROPERTY_ACCOUNT_HOLDER_CODE,
  CreateAccountRequest.JSON_PROPERTY_BANK_ACCOUNT_U_U_I_D,
  CreateAccountRequest.JSON_PROPERTY_DESCRIPTION,
  CreateAccountRequest.JSON_PROPERTY_METADATA,
  CreateAccountRequest.JSON_PROPERTY_PAYOUT_METHOD_CODE,
  CreateAccountRequest.JSON_PROPERTY_PAYOUT_SCHEDULE,
  CreateAccountRequest.JSON_PROPERTY_PAYOUT_SCHEDULE_REASON,
  CreateAccountRequest.JSON_PROPERTY_PAYOUT_SPEED
})
public class CreateAccountRequest {
  public static final String JSON_PROPERTY_ACCOUNT_HOLDER_CODE = "accountHolderCode";
  private String accountHolderCode;

  public static final String JSON_PROPERTY_BANK_ACCOUNT_U_U_I_D = "bankAccountUUID";
  private String bankAccountUUID;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private Map<String, String> metadata = null;

  public static final String JSON_PROPERTY_PAYOUT_METHOD_CODE = "payoutMethodCode";
  private String payoutMethodCode;

  /**
   * The payout schedule of the prospective account. &gt;Permitted values: &#x60;DEFAULT&#x60;,
   * &#x60;HOLD&#x60;, &#x60;DAILY&#x60;, &#x60;WEEKLY&#x60;, &#x60;MONTHLY&#x60;.
   */
  public enum PayoutScheduleEnum {
    BIWEEKLY_ON_1ST_AND_15TH_AT_MIDNIGHT("BIWEEKLY_ON_1ST_AND_15TH_AT_MIDNIGHT"),

    DAILY("DAILY"),

    DAILY_AU("DAILY_AU"),

    DAILY_EU("DAILY_EU"),

    DAILY_SG("DAILY_SG"),

    DAILY_US("DAILY_US"),

    HOLD("HOLD"),

    MONTHLY("MONTHLY"),

    WEEKLY("WEEKLY"),

    WEEKLY_MON_TO_FRI_AU("WEEKLY_MON_TO_FRI_AU"),

    WEEKLY_MON_TO_FRI_EU("WEEKLY_MON_TO_FRI_EU"),

    WEEKLY_MON_TO_FRI_US("WEEKLY_MON_TO_FRI_US"),

    WEEKLY_ON_TUE_FRI_MIDNIGHT("WEEKLY_ON_TUE_FRI_MIDNIGHT"),

    WEEKLY_SUN_TO_THU_AU("WEEKLY_SUN_TO_THU_AU"),

    WEEKLY_SUN_TO_THU_US("WEEKLY_SUN_TO_THU_US");

    private String value;

    PayoutScheduleEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PayoutScheduleEnum fromValue(String value) {
      for (PayoutScheduleEnum b : PayoutScheduleEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_PAYOUT_SCHEDULE = "payoutSchedule";
  private PayoutScheduleEnum payoutSchedule;

  public static final String JSON_PROPERTY_PAYOUT_SCHEDULE_REASON = "payoutScheduleReason";
  private String payoutScheduleReason;

  /**
   * Speed with which payouts for this account are processed. Permitted values:
   * &#x60;STANDARD&#x60;, &#x60;SAME_DAY&#x60;.
   */
  public enum PayoutSpeedEnum {
    INSTANT("INSTANT"),

    SAME_DAY("SAME_DAY"),

    STANDARD("STANDARD");

    private String value;

    PayoutSpeedEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PayoutSpeedEnum fromValue(String value) {
      for (PayoutSpeedEnum b : PayoutSpeedEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_PAYOUT_SPEED = "payoutSpeed";
  private PayoutSpeedEnum payoutSpeed = PayoutSpeedEnum.STANDARD;

  public CreateAccountRequest() {}

  public CreateAccountRequest accountHolderCode(String accountHolderCode) {
    this.accountHolderCode = accountHolderCode;
    return this;
  }

  /**
   * The code of Account Holder under which to create the account.
   *
   * @return accountHolderCode
   */
  @ApiModelProperty(
      required = true,
      value = "The code of Account Holder under which to create the account.")
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

  public CreateAccountRequest bankAccountUUID(String bankAccountUUID) {
    this.bankAccountUUID = bankAccountUUID;
    return this;
  }

  /**
   * The bankAccountUUID of the bank account held by the account holder to couple the account with.
   * Scheduled payouts in currencies matching the currency of this bank account will be sent to this
   * bank account. Payouts in different currencies will be sent to a matching bank account of the
   * account holder.
   *
   * @return bankAccountUUID
   */
  @ApiModelProperty(
      value =
          "The bankAccountUUID of the bank account held by the account holder to couple the account with. Scheduled payouts in currencies matching the currency of this bank account will be sent to this bank account. Payouts in different currencies will be sent to a matching bank account of the account holder.")
  @JsonProperty(JSON_PROPERTY_BANK_ACCOUNT_U_U_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getBankAccountUUID() {
    return bankAccountUUID;
  }

  @JsonProperty(JSON_PROPERTY_BANK_ACCOUNT_U_U_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBankAccountUUID(String bankAccountUUID) {
    this.bankAccountUUID = bankAccountUUID;
  }

  public CreateAccountRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A description of the account, maximum 256 characters. You can use alphanumeric characters (A-Z,
   * a-z, 0-9), white spaces, and underscores &#x60;_&#x60;.
   *
   * @return description
   */
  @ApiModelProperty(
      value =
          "A description of the account, maximum 256 characters. You can use alphanumeric characters (A-Z, a-z, 0-9), white spaces, and underscores `_`.")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDescription() {
    return description;
  }

  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(String description) {
    this.description = description;
  }

  public CreateAccountRequest metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  public CreateAccountRequest putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

  /**
   * A set of key and value pairs for general use by the merchant. The keys do not have specific
   * names and may be used for storing miscellaneous data as desired. &gt; Note that during an
   * update of metadata, the omission of existing key-value pairs will result in the deletion of
   * those key-value pairs.
   *
   * @return metadata
   */
  @ApiModelProperty(
      value =
          "A set of key and value pairs for general use by the merchant. The keys do not have specific names and may be used for storing miscellaneous data as desired. > Note that during an update of metadata, the omission of existing key-value pairs will result in the deletion of those key-value pairs.")
  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Map<String, String> getMetadata() {
    return metadata;
  }

  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }

  public CreateAccountRequest payoutMethodCode(String payoutMethodCode) {
    this.payoutMethodCode = payoutMethodCode;
    return this;
  }

  /**
   * The payout method code held by the account holder to couple the account with. Scheduled card
   * payouts will be sent using this payout method code.
   *
   * @return payoutMethodCode
   */
  @ApiModelProperty(
      value =
          "The payout method code held by the account holder to couple the account with. Scheduled card payouts will be sent using this payout method code.")
  @JsonProperty(JSON_PROPERTY_PAYOUT_METHOD_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPayoutMethodCode() {
    return payoutMethodCode;
  }

  @JsonProperty(JSON_PROPERTY_PAYOUT_METHOD_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPayoutMethodCode(String payoutMethodCode) {
    this.payoutMethodCode = payoutMethodCode;
  }

  public CreateAccountRequest payoutSchedule(PayoutScheduleEnum payoutSchedule) {
    this.payoutSchedule = payoutSchedule;
    return this;
  }

  /**
   * The payout schedule of the prospective account. &gt;Permitted values: &#x60;DEFAULT&#x60;,
   * &#x60;HOLD&#x60;, &#x60;DAILY&#x60;, &#x60;WEEKLY&#x60;, &#x60;MONTHLY&#x60;.
   *
   * @return payoutSchedule
   */
  @ApiModelProperty(
      value =
          "The payout schedule of the prospective account. >Permitted values: `DEFAULT`, `HOLD`, `DAILY`, `WEEKLY`, `MONTHLY`.")
  @JsonProperty(JSON_PROPERTY_PAYOUT_SCHEDULE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public PayoutScheduleEnum getPayoutSchedule() {
    return payoutSchedule;
  }

  @JsonProperty(JSON_PROPERTY_PAYOUT_SCHEDULE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPayoutSchedule(PayoutScheduleEnum payoutSchedule) {
    this.payoutSchedule = payoutSchedule;
  }

  public CreateAccountRequest payoutScheduleReason(String payoutScheduleReason) {
    this.payoutScheduleReason = payoutScheduleReason;
    return this;
  }

  /**
   * The reason for the payout schedule choice. &gt;Required if the payoutSchedule is
   * &#x60;HOLD&#x60;.
   *
   * @return payoutScheduleReason
   */
  @ApiModelProperty(
      value =
          "The reason for the payout schedule choice. >Required if the payoutSchedule is `HOLD`.")
  @JsonProperty(JSON_PROPERTY_PAYOUT_SCHEDULE_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPayoutScheduleReason() {
    return payoutScheduleReason;
  }

  @JsonProperty(JSON_PROPERTY_PAYOUT_SCHEDULE_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPayoutScheduleReason(String payoutScheduleReason) {
    this.payoutScheduleReason = payoutScheduleReason;
  }

  public CreateAccountRequest payoutSpeed(PayoutSpeedEnum payoutSpeed) {
    this.payoutSpeed = payoutSpeed;
    return this;
  }

  /**
   * Speed with which payouts for this account are processed. Permitted values:
   * &#x60;STANDARD&#x60;, &#x60;SAME_DAY&#x60;.
   *
   * @return payoutSpeed
   */
  @ApiModelProperty(
      value =
          "Speed with which payouts for this account are processed. Permitted values: `STANDARD`, `SAME_DAY`.")
  @JsonProperty(JSON_PROPERTY_PAYOUT_SPEED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public PayoutSpeedEnum getPayoutSpeed() {
    return payoutSpeed;
  }

  @JsonProperty(JSON_PROPERTY_PAYOUT_SPEED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPayoutSpeed(PayoutSpeedEnum payoutSpeed) {
    this.payoutSpeed = payoutSpeed;
  }

  /** Return true if this CreateAccountRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateAccountRequest createAccountRequest = (CreateAccountRequest) o;
    return Objects.equals(this.accountHolderCode, createAccountRequest.accountHolderCode)
        && Objects.equals(this.bankAccountUUID, createAccountRequest.bankAccountUUID)
        && Objects.equals(this.description, createAccountRequest.description)
        && Objects.equals(this.metadata, createAccountRequest.metadata)
        && Objects.equals(this.payoutMethodCode, createAccountRequest.payoutMethodCode)
        && Objects.equals(this.payoutSchedule, createAccountRequest.payoutSchedule)
        && Objects.equals(this.payoutScheduleReason, createAccountRequest.payoutScheduleReason)
        && Objects.equals(this.payoutSpeed, createAccountRequest.payoutSpeed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        accountHolderCode,
        bankAccountUUID,
        description,
        metadata,
        payoutMethodCode,
        payoutSchedule,
        payoutScheduleReason,
        payoutSpeed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateAccountRequest {\n");
    sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
    sb.append("    bankAccountUUID: ").append(toIndentedString(bankAccountUUID)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    payoutMethodCode: ").append(toIndentedString(payoutMethodCode)).append("\n");
    sb.append("    payoutSchedule: ").append(toIndentedString(payoutSchedule)).append("\n");
    sb.append("    payoutScheduleReason: ")
        .append(toIndentedString(payoutScheduleReason))
        .append("\n");
    sb.append("    payoutSpeed: ").append(toIndentedString(payoutSpeed)).append("\n");
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
   * Create an instance of CreateAccountRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CreateAccountRequest
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     CreateAccountRequest
   */
  public static CreateAccountRequest fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, CreateAccountRequest.class);
  }

  /**
   * Convert an instance of CreateAccountRequest to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
