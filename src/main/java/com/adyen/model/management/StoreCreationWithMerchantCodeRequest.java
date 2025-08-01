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
import java.util.ArrayList;
import java.util.List;

/** StoreCreationWithMerchantCodeRequest */
@JsonPropertyOrder({
  StoreCreationWithMerchantCodeRequest.JSON_PROPERTY_ADDRESS,
  StoreCreationWithMerchantCodeRequest.JSON_PROPERTY_BUSINESS_LINE_IDS,
  StoreCreationWithMerchantCodeRequest.JSON_PROPERTY_DESCRIPTION,
  StoreCreationWithMerchantCodeRequest.JSON_PROPERTY_EXTERNAL_REFERENCE_ID,
  StoreCreationWithMerchantCodeRequest.JSON_PROPERTY_MERCHANT_ID,
  StoreCreationWithMerchantCodeRequest.JSON_PROPERTY_PHONE_NUMBER,
  StoreCreationWithMerchantCodeRequest.JSON_PROPERTY_REFERENCE,
  StoreCreationWithMerchantCodeRequest.JSON_PROPERTY_SHOPPER_STATEMENT,
  StoreCreationWithMerchantCodeRequest.JSON_PROPERTY_SPLIT_CONFIGURATION,
  StoreCreationWithMerchantCodeRequest.JSON_PROPERTY_SUB_MERCHANT_DATA
})
public class StoreCreationWithMerchantCodeRequest {
  public static final String JSON_PROPERTY_ADDRESS = "address";
  private StoreLocation address;

  public static final String JSON_PROPERTY_BUSINESS_LINE_IDS = "businessLineIds";
  private List<String> businessLineIds;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_EXTERNAL_REFERENCE_ID = "externalReferenceId";
  private String externalReferenceId;

  public static final String JSON_PROPERTY_MERCHANT_ID = "merchantId";
  private String merchantId;

  public static final String JSON_PROPERTY_PHONE_NUMBER = "phoneNumber";
  private String phoneNumber;

  public static final String JSON_PROPERTY_REFERENCE = "reference";
  private String reference;

  public static final String JSON_PROPERTY_SHOPPER_STATEMENT = "shopperStatement";
  private String shopperStatement;

  public static final String JSON_PROPERTY_SPLIT_CONFIGURATION = "splitConfiguration";
  private StoreSplitConfiguration splitConfiguration;

  public static final String JSON_PROPERTY_SUB_MERCHANT_DATA = "subMerchantData";
  private SubMerchantData subMerchantData;

  public StoreCreationWithMerchantCodeRequest() {}

  /**
   * address
   *
   * @param address
   * @return the current {@code StoreCreationWithMerchantCodeRequest} instance, allowing for method
   *     chaining
   */
  public StoreCreationWithMerchantCodeRequest address(StoreLocation address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   *
   * @return address
   */
  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public StoreLocation getAddress() {
    return address;
  }

  /**
   * address
   *
   * @param address
   */
  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAddress(StoreLocation address) {
    this.address = address;
  }

  /**
   * The unique identifiers of the [business
   * lines](https://docs.adyen.com/api-explorer/legalentity/latest/post/businessLines#responses-200-id)
   * that the store is associated with. If not specified, the business line of the merchant account
   * is used. Required when there are multiple business lines under the merchant account.
   *
   * @param businessLineIds The unique identifiers of the [business
   *     lines](https://docs.adyen.com/api-explorer/legalentity/latest/post/businessLines#responses-200-id)
   *     that the store is associated with. If not specified, the business line of the merchant
   *     account is used. Required when there are multiple business lines under the merchant
   *     account.
   * @return the current {@code StoreCreationWithMerchantCodeRequest} instance, allowing for method
   *     chaining
   */
  public StoreCreationWithMerchantCodeRequest businessLineIds(List<String> businessLineIds) {
    this.businessLineIds = businessLineIds;
    return this;
  }

  public StoreCreationWithMerchantCodeRequest addBusinessLineIdsItem(String businessLineIdsItem) {
    if (this.businessLineIds == null) {
      this.businessLineIds = new ArrayList<>();
    }
    this.businessLineIds.add(businessLineIdsItem);
    return this;
  }

  /**
   * The unique identifiers of the [business
   * lines](https://docs.adyen.com/api-explorer/legalentity/latest/post/businessLines#responses-200-id)
   * that the store is associated with. If not specified, the business line of the merchant account
   * is used. Required when there are multiple business lines under the merchant account.
   *
   * @return businessLineIds The unique identifiers of the [business
   *     lines](https://docs.adyen.com/api-explorer/legalentity/latest/post/businessLines#responses-200-id)
   *     that the store is associated with. If not specified, the business line of the merchant
   *     account is used. Required when there are multiple business lines under the merchant
   *     account.
   */
  @JsonProperty(JSON_PROPERTY_BUSINESS_LINE_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getBusinessLineIds() {
    return businessLineIds;
  }

  /**
   * The unique identifiers of the [business
   * lines](https://docs.adyen.com/api-explorer/legalentity/latest/post/businessLines#responses-200-id)
   * that the store is associated with. If not specified, the business line of the merchant account
   * is used. Required when there are multiple business lines under the merchant account.
   *
   * @param businessLineIds The unique identifiers of the [business
   *     lines](https://docs.adyen.com/api-explorer/legalentity/latest/post/businessLines#responses-200-id)
   *     that the store is associated with. If not specified, the business line of the merchant
   *     account is used. Required when there are multiple business lines under the merchant
   *     account.
   */
  @JsonProperty(JSON_PROPERTY_BUSINESS_LINE_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBusinessLineIds(List<String> businessLineIds) {
    this.businessLineIds = businessLineIds;
  }

  /**
   * Your description of the store.
   *
   * @param description Your description of the store.
   * @return the current {@code StoreCreationWithMerchantCodeRequest} instance, allowing for method
   *     chaining
   */
  public StoreCreationWithMerchantCodeRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Your description of the store.
   *
   * @return description Your description of the store.
   */
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDescription() {
    return description;
  }

  /**
   * Your description of the store.
   *
   * @param description Your description of the store.
   */
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * The unique identifier of the store, used by certain payment methods and tax authorities.
   * Required for CNPJ in Brazil, in the format 00.000.000/0000-00 separated by dots, slashes,
   * hyphens, or without separators. Optional for SIRET in France, up to 14 digits. Optional for Zip
   * in Australia, up to 50 digits.
   *
   * @param externalReferenceId The unique identifier of the store, used by certain payment methods
   *     and tax authorities. Required for CNPJ in Brazil, in the format 00.000.000/0000-00
   *     separated by dots, slashes, hyphens, or without separators. Optional for SIRET in France,
   *     up to 14 digits. Optional for Zip in Australia, up to 50 digits.
   * @return the current {@code StoreCreationWithMerchantCodeRequest} instance, allowing for method
   *     chaining
   */
  public StoreCreationWithMerchantCodeRequest externalReferenceId(String externalReferenceId) {
    this.externalReferenceId = externalReferenceId;
    return this;
  }

  /**
   * The unique identifier of the store, used by certain payment methods and tax authorities.
   * Required for CNPJ in Brazil, in the format 00.000.000/0000-00 separated by dots, slashes,
   * hyphens, or without separators. Optional for SIRET in France, up to 14 digits. Optional for Zip
   * in Australia, up to 50 digits.
   *
   * @return externalReferenceId The unique identifier of the store, used by certain payment methods
   *     and tax authorities. Required for CNPJ in Brazil, in the format 00.000.000/0000-00
   *     separated by dots, slashes, hyphens, or without separators. Optional for SIRET in France,
   *     up to 14 digits. Optional for Zip in Australia, up to 50 digits.
   */
  @JsonProperty(JSON_PROPERTY_EXTERNAL_REFERENCE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getExternalReferenceId() {
    return externalReferenceId;
  }

  /**
   * The unique identifier of the store, used by certain payment methods and tax authorities.
   * Required for CNPJ in Brazil, in the format 00.000.000/0000-00 separated by dots, slashes,
   * hyphens, or without separators. Optional for SIRET in France, up to 14 digits. Optional for Zip
   * in Australia, up to 50 digits.
   *
   * @param externalReferenceId The unique identifier of the store, used by certain payment methods
   *     and tax authorities. Required for CNPJ in Brazil, in the format 00.000.000/0000-00
   *     separated by dots, slashes, hyphens, or without separators. Optional for SIRET in France,
   *     up to 14 digits. Optional for Zip in Australia, up to 50 digits.
   */
  @JsonProperty(JSON_PROPERTY_EXTERNAL_REFERENCE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExternalReferenceId(String externalReferenceId) {
    this.externalReferenceId = externalReferenceId;
  }

  /**
   * The unique identifier of the merchant account that the store belongs to.
   *
   * @param merchantId The unique identifier of the merchant account that the store belongs to.
   * @return the current {@code StoreCreationWithMerchantCodeRequest} instance, allowing for method
   *     chaining
   */
  public StoreCreationWithMerchantCodeRequest merchantId(String merchantId) {
    this.merchantId = merchantId;
    return this;
  }

  /**
   * The unique identifier of the merchant account that the store belongs to.
   *
   * @return merchantId The unique identifier of the merchant account that the store belongs to.
   */
  @JsonProperty(JSON_PROPERTY_MERCHANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMerchantId() {
    return merchantId;
  }

  /**
   * The unique identifier of the merchant account that the store belongs to.
   *
   * @param merchantId The unique identifier of the merchant account that the store belongs to.
   */
  @JsonProperty(JSON_PROPERTY_MERCHANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMerchantId(String merchantId) {
    this.merchantId = merchantId;
  }

  /**
   * The phone number of the store, including &#39;+&#39; and country code in the
   * [E.164](https://en.wikipedia.org/wiki/E.164) format. If passed in a different format, we
   * convert and validate the phone number against E.164.
   *
   * @param phoneNumber The phone number of the store, including &#39;+&#39; and country code in the
   *     [E.164](https://en.wikipedia.org/wiki/E.164) format. If passed in a different format, we
   *     convert and validate the phone number against E.164.
   * @return the current {@code StoreCreationWithMerchantCodeRequest} instance, allowing for method
   *     chaining
   */
  public StoreCreationWithMerchantCodeRequest phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * The phone number of the store, including &#39;+&#39; and country code in the
   * [E.164](https://en.wikipedia.org/wiki/E.164) format. If passed in a different format, we
   * convert and validate the phone number against E.164.
   *
   * @return phoneNumber The phone number of the store, including &#39;+&#39; and country code in
   *     the [E.164](https://en.wikipedia.org/wiki/E.164) format. If passed in a different format,
   *     we convert and validate the phone number against E.164.
   */
  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * The phone number of the store, including &#39;+&#39; and country code in the
   * [E.164](https://en.wikipedia.org/wiki/E.164) format. If passed in a different format, we
   * convert and validate the phone number against E.164.
   *
   * @param phoneNumber The phone number of the store, including &#39;+&#39; and country code in the
   *     [E.164](https://en.wikipedia.org/wiki/E.164) format. If passed in a different format, we
   *     convert and validate the phone number against E.164.
   */
  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * Your reference to recognize the store by. Also known as the store code. Allowed characters:
   * lowercase and uppercase letters without diacritics, numbers 0 through 9, hyphen (-), and
   * underscore (_). If you do not provide a reference in your POST request, it is populated with
   * the Adyen-generated
   * [id](https://docs.adyen.com/api-explorer/Management/latest/post/stores#responses-200-id).
   *
   * @param reference Your reference to recognize the store by. Also known as the store code.
   *     Allowed characters: lowercase and uppercase letters without diacritics, numbers 0 through
   *     9, hyphen (-), and underscore (_). If you do not provide a reference in your POST request,
   *     it is populated with the Adyen-generated
   *     [id](https://docs.adyen.com/api-explorer/Management/latest/post/stores#responses-200-id).
   * @return the current {@code StoreCreationWithMerchantCodeRequest} instance, allowing for method
   *     chaining
   */
  public StoreCreationWithMerchantCodeRequest reference(String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * Your reference to recognize the store by. Also known as the store code. Allowed characters:
   * lowercase and uppercase letters without diacritics, numbers 0 through 9, hyphen (-), and
   * underscore (_). If you do not provide a reference in your POST request, it is populated with
   * the Adyen-generated
   * [id](https://docs.adyen.com/api-explorer/Management/latest/post/stores#responses-200-id).
   *
   * @return reference Your reference to recognize the store by. Also known as the store code.
   *     Allowed characters: lowercase and uppercase letters without diacritics, numbers 0 through
   *     9, hyphen (-), and underscore (_). If you do not provide a reference in your POST request,
   *     it is populated with the Adyen-generated
   *     [id](https://docs.adyen.com/api-explorer/Management/latest/post/stores#responses-200-id).
   */
  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getReference() {
    return reference;
  }

  /**
   * Your reference to recognize the store by. Also known as the store code. Allowed characters:
   * lowercase and uppercase letters without diacritics, numbers 0 through 9, hyphen (-), and
   * underscore (_). If you do not provide a reference in your POST request, it is populated with
   * the Adyen-generated
   * [id](https://docs.adyen.com/api-explorer/Management/latest/post/stores#responses-200-id).
   *
   * @param reference Your reference to recognize the store by. Also known as the store code.
   *     Allowed characters: lowercase and uppercase letters without diacritics, numbers 0 through
   *     9, hyphen (-), and underscore (_). If you do not provide a reference in your POST request,
   *     it is populated with the Adyen-generated
   *     [id](https://docs.adyen.com/api-explorer/Management/latest/post/stores#responses-200-id).
   */
  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReference(String reference) {
    this.reference = reference;
  }

  /**
   * The store name to be shown on the shopper&#39;s bank or credit card statement and on the
   * shopper receipt. Maximum length: 22 characters; can&#39;t be all numbers.
   *
   * @param shopperStatement The store name to be shown on the shopper&#39;s bank or credit card
   *     statement and on the shopper receipt. Maximum length: 22 characters; can&#39;t be all
   *     numbers.
   * @return the current {@code StoreCreationWithMerchantCodeRequest} instance, allowing for method
   *     chaining
   */
  public StoreCreationWithMerchantCodeRequest shopperStatement(String shopperStatement) {
    this.shopperStatement = shopperStatement;
    return this;
  }

  /**
   * The store name to be shown on the shopper&#39;s bank or credit card statement and on the
   * shopper receipt. Maximum length: 22 characters; can&#39;t be all numbers.
   *
   * @return shopperStatement The store name to be shown on the shopper&#39;s bank or credit card
   *     statement and on the shopper receipt. Maximum length: 22 characters; can&#39;t be all
   *     numbers.
   */
  @JsonProperty(JSON_PROPERTY_SHOPPER_STATEMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getShopperStatement() {
    return shopperStatement;
  }

  /**
   * The store name to be shown on the shopper&#39;s bank or credit card statement and on the
   * shopper receipt. Maximum length: 22 characters; can&#39;t be all numbers.
   *
   * @param shopperStatement The store name to be shown on the shopper&#39;s bank or credit card
   *     statement and on the shopper receipt. Maximum length: 22 characters; can&#39;t be all
   *     numbers.
   */
  @JsonProperty(JSON_PROPERTY_SHOPPER_STATEMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setShopperStatement(String shopperStatement) {
    this.shopperStatement = shopperStatement;
  }

  /**
   * splitConfiguration
   *
   * @param splitConfiguration
   * @return the current {@code StoreCreationWithMerchantCodeRequest} instance, allowing for method
   *     chaining
   */
  public StoreCreationWithMerchantCodeRequest splitConfiguration(
      StoreSplitConfiguration splitConfiguration) {
    this.splitConfiguration = splitConfiguration;
    return this;
  }

  /**
   * Get splitConfiguration
   *
   * @return splitConfiguration
   */
  @JsonProperty(JSON_PROPERTY_SPLIT_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public StoreSplitConfiguration getSplitConfiguration() {
    return splitConfiguration;
  }

  /**
   * splitConfiguration
   *
   * @param splitConfiguration
   */
  @JsonProperty(JSON_PROPERTY_SPLIT_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSplitConfiguration(StoreSplitConfiguration splitConfiguration) {
    this.splitConfiguration = splitConfiguration;
  }

  /**
   * subMerchantData
   *
   * @param subMerchantData
   * @return the current {@code StoreCreationWithMerchantCodeRequest} instance, allowing for method
   *     chaining
   */
  public StoreCreationWithMerchantCodeRequest subMerchantData(SubMerchantData subMerchantData) {
    this.subMerchantData = subMerchantData;
    return this;
  }

  /**
   * Get subMerchantData
   *
   * @return subMerchantData
   */
  @JsonProperty(JSON_PROPERTY_SUB_MERCHANT_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SubMerchantData getSubMerchantData() {
    return subMerchantData;
  }

  /**
   * subMerchantData
   *
   * @param subMerchantData
   */
  @JsonProperty(JSON_PROPERTY_SUB_MERCHANT_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSubMerchantData(SubMerchantData subMerchantData) {
    this.subMerchantData = subMerchantData;
  }

  /** Return true if this StoreCreationWithMerchantCodeRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoreCreationWithMerchantCodeRequest storeCreationWithMerchantCodeRequest =
        (StoreCreationWithMerchantCodeRequest) o;
    return Objects.equals(this.address, storeCreationWithMerchantCodeRequest.address)
        && Objects.equals(
            this.businessLineIds, storeCreationWithMerchantCodeRequest.businessLineIds)
        && Objects.equals(this.description, storeCreationWithMerchantCodeRequest.description)
        && Objects.equals(
            this.externalReferenceId, storeCreationWithMerchantCodeRequest.externalReferenceId)
        && Objects.equals(this.merchantId, storeCreationWithMerchantCodeRequest.merchantId)
        && Objects.equals(this.phoneNumber, storeCreationWithMerchantCodeRequest.phoneNumber)
        && Objects.equals(this.reference, storeCreationWithMerchantCodeRequest.reference)
        && Objects.equals(
            this.shopperStatement, storeCreationWithMerchantCodeRequest.shopperStatement)
        && Objects.equals(
            this.splitConfiguration, storeCreationWithMerchantCodeRequest.splitConfiguration)
        && Objects.equals(
            this.subMerchantData, storeCreationWithMerchantCodeRequest.subMerchantData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        address,
        businessLineIds,
        description,
        externalReferenceId,
        merchantId,
        phoneNumber,
        reference,
        shopperStatement,
        splitConfiguration,
        subMerchantData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StoreCreationWithMerchantCodeRequest {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    businessLineIds: ").append(toIndentedString(businessLineIds)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    externalReferenceId: ")
        .append(toIndentedString(externalReferenceId))
        .append("\n");
    sb.append("    merchantId: ").append(toIndentedString(merchantId)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    shopperStatement: ").append(toIndentedString(shopperStatement)).append("\n");
    sb.append("    splitConfiguration: ").append(toIndentedString(splitConfiguration)).append("\n");
    sb.append("    subMerchantData: ").append(toIndentedString(subMerchantData)).append("\n");
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
   * Create an instance of StoreCreationWithMerchantCodeRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of StoreCreationWithMerchantCodeRequest
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     StoreCreationWithMerchantCodeRequest
   */
  public static StoreCreationWithMerchantCodeRequest fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, StoreCreationWithMerchantCodeRequest.class);
  }

  /**
   * Convert an instance of StoreCreationWithMerchantCodeRequest to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
