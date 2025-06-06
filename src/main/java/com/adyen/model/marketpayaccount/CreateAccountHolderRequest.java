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
import java.util.Objects;

/** CreateAccountHolderRequest */
@JsonPropertyOrder({
  CreateAccountHolderRequest.JSON_PROPERTY_ACCOUNT_HOLDER_CODE,
  CreateAccountHolderRequest.JSON_PROPERTY_ACCOUNT_HOLDER_DETAILS,
  CreateAccountHolderRequest.JSON_PROPERTY_CREATE_DEFAULT_ACCOUNT,
  CreateAccountHolderRequest.JSON_PROPERTY_DESCRIPTION,
  CreateAccountHolderRequest.JSON_PROPERTY_LEGAL_ENTITY,
  CreateAccountHolderRequest.JSON_PROPERTY_PRIMARY_CURRENCY,
  CreateAccountHolderRequest.JSON_PROPERTY_PROCESSING_TIER,
  CreateAccountHolderRequest.JSON_PROPERTY_VERIFICATION_PROFILE
})
public class CreateAccountHolderRequest {
  public static final String JSON_PROPERTY_ACCOUNT_HOLDER_CODE = "accountHolderCode";
  private String accountHolderCode;

  public static final String JSON_PROPERTY_ACCOUNT_HOLDER_DETAILS = "accountHolderDetails";
  private AccountHolderDetails accountHolderDetails;

  public static final String JSON_PROPERTY_CREATE_DEFAULT_ACCOUNT = "createDefaultAccount";
  private Boolean createDefaultAccount;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  /**
   * The legal entity type of the account holder. This determines the information that should be
   * provided in the request. Possible values: **Business**, **Individual**, or **NonProfit**. * If
   * set to **Business** or **NonProfit**, then &#x60;accountHolderDetails.businessDetails&#x60;
   * must be provided, with at least one entry in the
   * &#x60;accountHolderDetails.businessDetails.shareholders&#x60; list. * If set to **Individual**,
   * then &#x60;accountHolderDetails.individualDetails&#x60; must be provided.
   */
  public enum LegalEntityEnum {
    BUSINESS("Business"),

    INDIVIDUAL("Individual"),

    NONPROFIT("NonProfit"),

    PARTNERSHIP("Partnership"),

    PUBLICCOMPANY("PublicCompany");

    private String value;

    LegalEntityEnum(String value) {
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
    public static LegalEntityEnum fromValue(String value) {
      for (LegalEntityEnum b : LegalEntityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_LEGAL_ENTITY = "legalEntity";
  private LegalEntityEnum legalEntity;

  public static final String JSON_PROPERTY_PRIMARY_CURRENCY = "primaryCurrency";
  private String primaryCurrency;

  public static final String JSON_PROPERTY_PROCESSING_TIER = "processingTier";
  private Integer processingTier;

  public static final String JSON_PROPERTY_VERIFICATION_PROFILE = "verificationProfile";
  private String verificationProfile;

  public CreateAccountHolderRequest() {}

  public CreateAccountHolderRequest accountHolderCode(String accountHolderCode) {
    this.accountHolderCode = accountHolderCode;
    return this;
  }

  /**
   * Your unique identifier for the prospective account holder. The length must be between three (3)
   * and fifty (50) characters long. Only letters, digits, and hyphens (-) are allowed.
   *
   * @return accountHolderCode
   */
  @ApiModelProperty(
      required = true,
      value =
          "Your unique identifier for the prospective account holder. The length must be between three (3) and fifty (50) characters long. Only letters, digits, and hyphens (-) are allowed.")
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

  public CreateAccountHolderRequest accountHolderDetails(
      AccountHolderDetails accountHolderDetails) {
    this.accountHolderDetails = accountHolderDetails;
    return this;
  }

  /**
   * Get accountHolderDetails
   *
   * @return accountHolderDetails
   */
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ACCOUNT_HOLDER_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public AccountHolderDetails getAccountHolderDetails() {
    return accountHolderDetails;
  }

  @JsonProperty(JSON_PROPERTY_ACCOUNT_HOLDER_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccountHolderDetails(AccountHolderDetails accountHolderDetails) {
    this.accountHolderDetails = accountHolderDetails;
  }

  public CreateAccountHolderRequest createDefaultAccount(Boolean createDefaultAccount) {
    this.createDefaultAccount = createDefaultAccount;
    return this;
  }

  /**
   * If set to **true**, an account with the default options is automatically created for the
   * account holder. By default, this field is set to **true**.
   *
   * @return createDefaultAccount
   */
  @ApiModelProperty(
      value =
          "If set to **true**, an account with the default options is automatically created for the account holder. By default, this field is set to **true**.")
  @JsonProperty(JSON_PROPERTY_CREATE_DEFAULT_ACCOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getCreateDefaultAccount() {
    return createDefaultAccount;
  }

  @JsonProperty(JSON_PROPERTY_CREATE_DEFAULT_ACCOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreateDefaultAccount(Boolean createDefaultAccount) {
    this.createDefaultAccount = createDefaultAccount;
  }

  public CreateAccountHolderRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A description of the prospective account holder, maximum 256 characters. You can use
   * alphanumeric characters (A-Z, a-z, 0-9), white spaces, and underscores &#x60;_&#x60;.
   *
   * @return description
   */
  @ApiModelProperty(
      value =
          "A description of the prospective account holder, maximum 256 characters. You can use alphanumeric characters (A-Z, a-z, 0-9), white spaces, and underscores `_`.")
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

  public CreateAccountHolderRequest legalEntity(LegalEntityEnum legalEntity) {
    this.legalEntity = legalEntity;
    return this;
  }

  /**
   * The legal entity type of the account holder. This determines the information that should be
   * provided in the request. Possible values: **Business**, **Individual**, or **NonProfit**. * If
   * set to **Business** or **NonProfit**, then &#x60;accountHolderDetails.businessDetails&#x60;
   * must be provided, with at least one entry in the
   * &#x60;accountHolderDetails.businessDetails.shareholders&#x60; list. * If set to **Individual**,
   * then &#x60;accountHolderDetails.individualDetails&#x60; must be provided.
   *
   * @return legalEntity
   */
  @ApiModelProperty(
      required = true,
      value =
          "The legal entity type of the account holder. This determines the information that should be provided in the request.  Possible values: **Business**, **Individual**, or **NonProfit**.  * If set to **Business** or **NonProfit**, then `accountHolderDetails.businessDetails` must be provided, with at least one entry in the `accountHolderDetails.businessDetails.shareholders` list.  * If set to **Individual**, then `accountHolderDetails.individualDetails` must be provided.")
  @JsonProperty(JSON_PROPERTY_LEGAL_ENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public LegalEntityEnum getLegalEntity() {
    return legalEntity;
  }

  @JsonProperty(JSON_PROPERTY_LEGAL_ENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLegalEntity(LegalEntityEnum legalEntity) {
    this.legalEntity = legalEntity;
  }

  public CreateAccountHolderRequest primaryCurrency(String primaryCurrency) {
    this.primaryCurrency = primaryCurrency;
    return this;
  }

  /**
   * The three-character [ISO currency
   * code](https://docs.adyen.com/development-resources/currency-codes), with which the prospective
   * account holder primarily deals.
   *
   * @return primaryCurrency
   * @deprecated
   */
  @Deprecated
  @ApiModelProperty(
      value =
          "The three-character [ISO currency code](https://docs.adyen.com/development-resources/currency-codes), with which the prospective account holder primarily deals.")
  @JsonProperty(JSON_PROPERTY_PRIMARY_CURRENCY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPrimaryCurrency() {
    return primaryCurrency;
  }

  @Deprecated
  @JsonProperty(JSON_PROPERTY_PRIMARY_CURRENCY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrimaryCurrency(String primaryCurrency) {
    this.primaryCurrency = primaryCurrency;
  }

  public CreateAccountHolderRequest processingTier(Integer processingTier) {
    this.processingTier = processingTier;
    return this;
  }

  /**
   * The starting [processing
   * tier](https://docs.adyen.com/marketplaces-and-platforms/classic/onboarding-and-verification/precheck-kyc-information)
   * for the prospective account holder.
   *
   * @return processingTier
   */
  @ApiModelProperty(
      value =
          "The starting [processing tier](https://docs.adyen.com/marketplaces-and-platforms/classic/onboarding-and-verification/precheck-kyc-information) for the prospective account holder.")
  @JsonProperty(JSON_PROPERTY_PROCESSING_TIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getProcessingTier() {
    return processingTier;
  }

  @JsonProperty(JSON_PROPERTY_PROCESSING_TIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProcessingTier(Integer processingTier) {
    this.processingTier = processingTier;
  }

  public CreateAccountHolderRequest verificationProfile(String verificationProfile) {
    this.verificationProfile = verificationProfile;
    return this;
  }

  /**
   * The identifier of the profile that applies to this entity.
   *
   * @return verificationProfile
   */
  @ApiModelProperty(value = "The identifier of the profile that applies to this entity.")
  @JsonProperty(JSON_PROPERTY_VERIFICATION_PROFILE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getVerificationProfile() {
    return verificationProfile;
  }

  @JsonProperty(JSON_PROPERTY_VERIFICATION_PROFILE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVerificationProfile(String verificationProfile) {
    this.verificationProfile = verificationProfile;
  }

  /** Return true if this CreateAccountHolderRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateAccountHolderRequest createAccountHolderRequest = (CreateAccountHolderRequest) o;
    return Objects.equals(this.accountHolderCode, createAccountHolderRequest.accountHolderCode)
        && Objects.equals(
            this.accountHolderDetails, createAccountHolderRequest.accountHolderDetails)
        && Objects.equals(
            this.createDefaultAccount, createAccountHolderRequest.createDefaultAccount)
        && Objects.equals(this.description, createAccountHolderRequest.description)
        && Objects.equals(this.legalEntity, createAccountHolderRequest.legalEntity)
        && Objects.equals(this.primaryCurrency, createAccountHolderRequest.primaryCurrency)
        && Objects.equals(this.processingTier, createAccountHolderRequest.processingTier)
        && Objects.equals(this.verificationProfile, createAccountHolderRequest.verificationProfile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        accountHolderCode,
        accountHolderDetails,
        createDefaultAccount,
        description,
        legalEntity,
        primaryCurrency,
        processingTier,
        verificationProfile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateAccountHolderRequest {\n");
    sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
    sb.append("    accountHolderDetails: ")
        .append(toIndentedString(accountHolderDetails))
        .append("\n");
    sb.append("    createDefaultAccount: ")
        .append(toIndentedString(createDefaultAccount))
        .append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    legalEntity: ").append(toIndentedString(legalEntity)).append("\n");
    sb.append("    primaryCurrency: ").append(toIndentedString(primaryCurrency)).append("\n");
    sb.append("    processingTier: ").append(toIndentedString(processingTier)).append("\n");
    sb.append("    verificationProfile: ")
        .append(toIndentedString(verificationProfile))
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
   * Create an instance of CreateAccountHolderRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CreateAccountHolderRequest
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     CreateAccountHolderRequest
   */
  public static CreateAccountHolderRequest fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, CreateAccountHolderRequest.class);
  }

  /**
   * Convert an instance of CreateAccountHolderRequest to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
