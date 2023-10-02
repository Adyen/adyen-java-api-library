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

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.adyen.model.marketpayaccount.BankAccountDetail;
import com.adyen.model.marketpayaccount.BusinessDetails;
import com.adyen.model.marketpayaccount.IndividualDetails;
import com.adyen.model.marketpayaccount.LegalArrangementDetail;
import com.adyen.model.marketpayaccount.PayoutMethod;
import com.adyen.model.marketpayaccount.StoreDetail;
import com.adyen.model.marketpayaccount.ViasAddress;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * AccountHolderDetails
 */
@JsonPropertyOrder({
  AccountHolderDetails.JSON_PROPERTY_ADDRESS,
  AccountHolderDetails.JSON_PROPERTY_BANK_ACCOUNT_DETAILS,
  AccountHolderDetails.JSON_PROPERTY_BANK_AGGREGATOR_DATA_REFERENCE,
  AccountHolderDetails.JSON_PROPERTY_BUSINESS_DETAILS,
  AccountHolderDetails.JSON_PROPERTY_EMAIL,
  AccountHolderDetails.JSON_PROPERTY_FULL_PHONE_NUMBER,
  AccountHolderDetails.JSON_PROPERTY_INDIVIDUAL_DETAILS,
  AccountHolderDetails.JSON_PROPERTY_LAST_REVIEW_DATE,
  AccountHolderDetails.JSON_PROPERTY_LEGAL_ARRANGEMENTS,
  AccountHolderDetails.JSON_PROPERTY_MERCHANT_CATEGORY_CODE,
  AccountHolderDetails.JSON_PROPERTY_METADATA,
  AccountHolderDetails.JSON_PROPERTY_PAYOUT_METHODS,
  AccountHolderDetails.JSON_PROPERTY_PRINCIPAL_BUSINESS_ADDRESS,
  AccountHolderDetails.JSON_PROPERTY_STORE_DETAILS,
  AccountHolderDetails.JSON_PROPERTY_WEB_ADDRESS
})

public class AccountHolderDetails {
  public static final String JSON_PROPERTY_ADDRESS = "address";
  private ViasAddress address;

  public static final String JSON_PROPERTY_BANK_ACCOUNT_DETAILS = "bankAccountDetails";
  private List<BankAccountDetail> bankAccountDetails = null;

  public static final String JSON_PROPERTY_BANK_AGGREGATOR_DATA_REFERENCE = "bankAggregatorDataReference";
  private String bankAggregatorDataReference;

  public static final String JSON_PROPERTY_BUSINESS_DETAILS = "businessDetails";
  private BusinessDetails businessDetails;

  public static final String JSON_PROPERTY_EMAIL = "email";
  private String email;

  public static final String JSON_PROPERTY_FULL_PHONE_NUMBER = "fullPhoneNumber";
  private String fullPhoneNumber;

  public static final String JSON_PROPERTY_INDIVIDUAL_DETAILS = "individualDetails";
  private IndividualDetails individualDetails;

  public static final String JSON_PROPERTY_LAST_REVIEW_DATE = "lastReviewDate";
  private String lastReviewDate;

  public static final String JSON_PROPERTY_LEGAL_ARRANGEMENTS = "legalArrangements";
  private List<LegalArrangementDetail> legalArrangements = null;

  public static final String JSON_PROPERTY_MERCHANT_CATEGORY_CODE = "merchantCategoryCode";
  private String merchantCategoryCode;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private Map<String, String> metadata = null;

  public static final String JSON_PROPERTY_PAYOUT_METHODS = "payoutMethods";
  private List<PayoutMethod> payoutMethods = null;

  public static final String JSON_PROPERTY_PRINCIPAL_BUSINESS_ADDRESS = "principalBusinessAddress";
  private ViasAddress principalBusinessAddress;

  public static final String JSON_PROPERTY_STORE_DETAILS = "storeDetails";
  private List<StoreDetail> storeDetails = null;

  public static final String JSON_PROPERTY_WEB_ADDRESS = "webAddress";
  private String webAddress;

  public AccountHolderDetails() { 
  }

  public AccountHolderDetails address(ViasAddress address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ViasAddress getAddress() {
    return address;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAddress(ViasAddress address) {
    this.address = address;
  }


  public AccountHolderDetails bankAccountDetails(List<BankAccountDetail> bankAccountDetails) {
    this.bankAccountDetails = bankAccountDetails;
    return this;
  }

  public AccountHolderDetails addBankAccountDetailsItem(BankAccountDetail bankAccountDetailsItem) {
    if (this.bankAccountDetails == null) {
      this.bankAccountDetails = new ArrayList<>();
    }
    this.bankAccountDetails.add(bankAccountDetailsItem);
    return this;
  }

   /**
   * Array of bank accounts associated with the account holder. For details about the required &#x60;bankAccountDetail&#x60; fields, see [Required information](https://docs.adyen.com/marketplaces-and-platforms/classic/verification-process/required-information).
   * @return bankAccountDetails
  **/
  @ApiModelProperty(value = "Array of bank accounts associated with the account holder. For details about the required `bankAccountDetail` fields, see [Required information](https://docs.adyen.com/marketplaces-and-platforms/classic/verification-process/required-information).")
  @JsonProperty(JSON_PROPERTY_BANK_ACCOUNT_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<BankAccountDetail> getBankAccountDetails() {
    return bankAccountDetails;
  }


  @JsonProperty(JSON_PROPERTY_BANK_ACCOUNT_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBankAccountDetails(List<BankAccountDetail> bankAccountDetails) {
    this.bankAccountDetails = bankAccountDetails;
  }


  public AccountHolderDetails bankAggregatorDataReference(String bankAggregatorDataReference) {
    this.bankAggregatorDataReference = bankAggregatorDataReference;
    return this;
  }

   /**
   * The opaque reference value returned by the Adyen API during bank account login.
   * @return bankAggregatorDataReference
  **/
  @ApiModelProperty(value = "The opaque reference value returned by the Adyen API during bank account login.")
  @JsonProperty(JSON_PROPERTY_BANK_AGGREGATOR_DATA_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBankAggregatorDataReference() {
    return bankAggregatorDataReference;
  }


  @JsonProperty(JSON_PROPERTY_BANK_AGGREGATOR_DATA_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBankAggregatorDataReference(String bankAggregatorDataReference) {
    this.bankAggregatorDataReference = bankAggregatorDataReference;
  }


  public AccountHolderDetails businessDetails(BusinessDetails businessDetails) {
    this.businessDetails = businessDetails;
    return this;
  }

   /**
   * Get businessDetails
   * @return businessDetails
  **/
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BUSINESS_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BusinessDetails getBusinessDetails() {
    return businessDetails;
  }


  @JsonProperty(JSON_PROPERTY_BUSINESS_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBusinessDetails(BusinessDetails businessDetails) {
    this.businessDetails = businessDetails;
  }


  public AccountHolderDetails email(String email) {
    this.email = email;
    return this;
  }

   /**
   * The email address of the account holder.
   * @return email
  **/
  @ApiModelProperty(value = "The email address of the account holder.")
  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEmail() {
    return email;
  }


  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmail(String email) {
    this.email = email;
  }


  public AccountHolderDetails fullPhoneNumber(String fullPhoneNumber) {
    this.fullPhoneNumber = fullPhoneNumber;
    return this;
  }

   /**
   * The phone number of the account holder provided as a single string. It will be handled as a landline phone. **Examples:** \&quot;0031 6 11 22 33 44\&quot;, \&quot;+316/1122-3344\&quot;, \&quot;(0031) 611223344\&quot;
   * @return fullPhoneNumber
  **/
  @ApiModelProperty(value = "The phone number of the account holder provided as a single string. It will be handled as a landline phone. **Examples:** \"0031 6 11 22 33 44\", \"+316/1122-3344\", \"(0031) 611223344\"")
  @JsonProperty(JSON_PROPERTY_FULL_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFullPhoneNumber() {
    return fullPhoneNumber;
  }


  @JsonProperty(JSON_PROPERTY_FULL_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFullPhoneNumber(String fullPhoneNumber) {
    this.fullPhoneNumber = fullPhoneNumber;
  }


  public AccountHolderDetails individualDetails(IndividualDetails individualDetails) {
    this.individualDetails = individualDetails;
    return this;
  }

   /**
   * Get individualDetails
   * @return individualDetails
  **/
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INDIVIDUAL_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IndividualDetails getIndividualDetails() {
    return individualDetails;
  }


  @JsonProperty(JSON_PROPERTY_INDIVIDUAL_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIndividualDetails(IndividualDetails individualDetails) {
    this.individualDetails = individualDetails;
  }


  public AccountHolderDetails lastReviewDate(String lastReviewDate) {
    this.lastReviewDate = lastReviewDate;
    return this;
  }

   /**
   * Date when you last reviewed the account holder&#39;s information, in ISO-8601 YYYY-MM-DD format. For example, **2020-01-31**.
   * @return lastReviewDate
  **/
  @ApiModelProperty(value = "Date when you last reviewed the account holder's information, in ISO-8601 YYYY-MM-DD format. For example, **2020-01-31**.")
  @JsonProperty(JSON_PROPERTY_LAST_REVIEW_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLastReviewDate() {
    return lastReviewDate;
  }


  @JsonProperty(JSON_PROPERTY_LAST_REVIEW_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLastReviewDate(String lastReviewDate) {
    this.lastReviewDate = lastReviewDate;
  }


  public AccountHolderDetails legalArrangements(List<LegalArrangementDetail> legalArrangements) {
    this.legalArrangements = legalArrangements;
    return this;
  }

  public AccountHolderDetails addLegalArrangementsItem(LegalArrangementDetail legalArrangementsItem) {
    if (this.legalArrangements == null) {
      this.legalArrangements = new ArrayList<>();
    }
    this.legalArrangements.add(legalArrangementsItem);
    return this;
  }

   /**
   * An array containing information about the account holder&#39;s [legal arrangements](https://docs.adyen.com/marketplaces-and-platforms/classic/verification-process/legal-arrangements).
   * @return legalArrangements
  **/
  @ApiModelProperty(value = "An array containing information about the account holder's [legal arrangements](https://docs.adyen.com/marketplaces-and-platforms/classic/verification-process/legal-arrangements).")
  @JsonProperty(JSON_PROPERTY_LEGAL_ARRANGEMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<LegalArrangementDetail> getLegalArrangements() {
    return legalArrangements;
  }


  @JsonProperty(JSON_PROPERTY_LEGAL_ARRANGEMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLegalArrangements(List<LegalArrangementDetail> legalArrangements) {
    this.legalArrangements = legalArrangements;
  }


  public AccountHolderDetails merchantCategoryCode(String merchantCategoryCode) {
    this.merchantCategoryCode = merchantCategoryCode;
    return this;
  }

   /**
   * The Merchant Category Code of the account holder. &gt; If not specified in the request, this will be derived from the platform account (which is configured by Adyen).
   * @return merchantCategoryCode
  **/
  @ApiModelProperty(value = "The Merchant Category Code of the account holder. > If not specified in the request, this will be derived from the platform account (which is configured by Adyen).")
  @JsonProperty(JSON_PROPERTY_MERCHANT_CATEGORY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMerchantCategoryCode() {
    return merchantCategoryCode;
  }


  @JsonProperty(JSON_PROPERTY_MERCHANT_CATEGORY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMerchantCategoryCode(String merchantCategoryCode) {
    this.merchantCategoryCode = merchantCategoryCode;
  }


  public AccountHolderDetails metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  public AccountHolderDetails putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

   /**
   * A set of key and value pairs for general use by the account holder or merchant. The keys do not have specific names and may be used for storing miscellaneous data as desired. &gt; The values being stored have a maximum length of eighty (80) characters and will be truncated if necessary. &gt; Note that during an update of metadata, the omission of existing key-value pairs will result in the deletion of those key-value pairs.
   * @return metadata
  **/
  @ApiModelProperty(value = "A set of key and value pairs for general use by the account holder or merchant. The keys do not have specific names and may be used for storing miscellaneous data as desired. > The values being stored have a maximum length of eighty (80) characters and will be truncated if necessary. > Note that during an update of metadata, the omission of existing key-value pairs will result in the deletion of those key-value pairs.")
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


  public AccountHolderDetails payoutMethods(List<PayoutMethod> payoutMethods) {
    this.payoutMethods = payoutMethods;
    return this;
  }

  public AccountHolderDetails addPayoutMethodsItem(PayoutMethod payoutMethodsItem) {
    if (this.payoutMethods == null) {
      this.payoutMethods = new ArrayList<>();
    }
    this.payoutMethods.add(payoutMethodsItem);
    return this;
  }

   /**
   * Array of tokenized card details associated with the account holder. For details about how you can use the tokens to pay out, refer to [Pay out to cards](https://docs.adyen.com/marketplaces-and-platforms/classic/payout-to-cards).
   * @return payoutMethods
  **/
  @ApiModelProperty(value = "Array of tokenized card details associated with the account holder. For details about how you can use the tokens to pay out, refer to [Pay out to cards](https://docs.adyen.com/marketplaces-and-platforms/classic/payout-to-cards).")
  @JsonProperty(JSON_PROPERTY_PAYOUT_METHODS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<PayoutMethod> getPayoutMethods() {
    return payoutMethods;
  }


  @JsonProperty(JSON_PROPERTY_PAYOUT_METHODS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPayoutMethods(List<PayoutMethod> payoutMethods) {
    this.payoutMethods = payoutMethods;
  }


  public AccountHolderDetails principalBusinessAddress(ViasAddress principalBusinessAddress) {
    this.principalBusinessAddress = principalBusinessAddress;
    return this;
  }

   /**
   * Get principalBusinessAddress
   * @return principalBusinessAddress
  **/
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PRINCIPAL_BUSINESS_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ViasAddress getPrincipalBusinessAddress() {
    return principalBusinessAddress;
  }


  @JsonProperty(JSON_PROPERTY_PRINCIPAL_BUSINESS_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrincipalBusinessAddress(ViasAddress principalBusinessAddress) {
    this.principalBusinessAddress = principalBusinessAddress;
  }


  public AccountHolderDetails storeDetails(List<StoreDetail> storeDetails) {
    this.storeDetails = storeDetails;
    return this;
  }

  public AccountHolderDetails addStoreDetailsItem(StoreDetail storeDetailsItem) {
    if (this.storeDetails == null) {
      this.storeDetails = new ArrayList<>();
    }
    this.storeDetails.add(storeDetailsItem);
    return this;
  }

   /**
   * Array of stores associated with the account holder. Required when onboarding account holders that have an Adyen [point of sale](https://docs.adyen.com/marketplaces-and-platforms/classic/platforms-for-pos).
   * @return storeDetails
  **/
  @ApiModelProperty(value = "Array of stores associated with the account holder. Required when onboarding account holders that have an Adyen [point of sale](https://docs.adyen.com/marketplaces-and-platforms/classic/platforms-for-pos).")
  @JsonProperty(JSON_PROPERTY_STORE_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<StoreDetail> getStoreDetails() {
    return storeDetails;
  }


  @JsonProperty(JSON_PROPERTY_STORE_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStoreDetails(List<StoreDetail> storeDetails) {
    this.storeDetails = storeDetails;
  }


  public AccountHolderDetails webAddress(String webAddress) {
    this.webAddress = webAddress;
    return this;
  }

   /**
   * The URL of the website of the account holder.
   * @return webAddress
  **/
  @ApiModelProperty(value = "The URL of the website of the account holder.")
  @JsonProperty(JSON_PROPERTY_WEB_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getWebAddress() {
    return webAddress;
  }


  @JsonProperty(JSON_PROPERTY_WEB_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWebAddress(String webAddress) {
    this.webAddress = webAddress;
  }


  /**
   * Return true if this AccountHolderDetails object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountHolderDetails accountHolderDetails = (AccountHolderDetails) o;
    return Objects.equals(this.address, accountHolderDetails.address) &&
        Objects.equals(this.bankAccountDetails, accountHolderDetails.bankAccountDetails) &&
        Objects.equals(this.bankAggregatorDataReference, accountHolderDetails.bankAggregatorDataReference) &&
        Objects.equals(this.businessDetails, accountHolderDetails.businessDetails) &&
        Objects.equals(this.email, accountHolderDetails.email) &&
        Objects.equals(this.fullPhoneNumber, accountHolderDetails.fullPhoneNumber) &&
        Objects.equals(this.individualDetails, accountHolderDetails.individualDetails) &&
        Objects.equals(this.lastReviewDate, accountHolderDetails.lastReviewDate) &&
        Objects.equals(this.legalArrangements, accountHolderDetails.legalArrangements) &&
        Objects.equals(this.merchantCategoryCode, accountHolderDetails.merchantCategoryCode) &&
        Objects.equals(this.metadata, accountHolderDetails.metadata) &&
        Objects.equals(this.payoutMethods, accountHolderDetails.payoutMethods) &&
        Objects.equals(this.principalBusinessAddress, accountHolderDetails.principalBusinessAddress) &&
        Objects.equals(this.storeDetails, accountHolderDetails.storeDetails) &&
        Objects.equals(this.webAddress, accountHolderDetails.webAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, bankAccountDetails, bankAggregatorDataReference, businessDetails, email, fullPhoneNumber, individualDetails, lastReviewDate, legalArrangements, merchantCategoryCode, metadata, payoutMethods, principalBusinessAddress, storeDetails, webAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountHolderDetails {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    bankAccountDetails: ").append(toIndentedString(bankAccountDetails)).append("\n");
    sb.append("    bankAggregatorDataReference: ").append(toIndentedString(bankAggregatorDataReference)).append("\n");
    sb.append("    businessDetails: ").append(toIndentedString(businessDetails)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    fullPhoneNumber: ").append(toIndentedString(fullPhoneNumber)).append("\n");
    sb.append("    individualDetails: ").append(toIndentedString(individualDetails)).append("\n");
    sb.append("    lastReviewDate: ").append(toIndentedString(lastReviewDate)).append("\n");
    sb.append("    legalArrangements: ").append(toIndentedString(legalArrangements)).append("\n");
    sb.append("    merchantCategoryCode: ").append(toIndentedString(merchantCategoryCode)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    payoutMethods: ").append(toIndentedString(payoutMethods)).append("\n");
    sb.append("    principalBusinessAddress: ").append(toIndentedString(principalBusinessAddress)).append("\n");
    sb.append("    storeDetails: ").append(toIndentedString(storeDetails)).append("\n");
    sb.append("    webAddress: ").append(toIndentedString(webAddress)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

/**
   * Create an instance of AccountHolderDetails given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of AccountHolderDetails
   * @throws JsonProcessingException if the JSON string is invalid with respect to AccountHolderDetails
   */
  public static AccountHolderDetails fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, AccountHolderDetails.class);
  }
/**
  * Convert an instance of AccountHolderDetails to an JSON string
  *
  * @return JSON string
  */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
