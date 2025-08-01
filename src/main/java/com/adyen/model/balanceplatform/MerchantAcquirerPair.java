/*
 * Configuration API
 *
 * The version of the OpenAPI document: 2
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.balanceplatform;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** MerchantAcquirerPair */
@JsonPropertyOrder({
  MerchantAcquirerPair.JSON_PROPERTY_ACQUIRER_ID,
  MerchantAcquirerPair.JSON_PROPERTY_MERCHANT_ID
})
public class MerchantAcquirerPair {
  public static final String JSON_PROPERTY_ACQUIRER_ID = "acquirerId";
  private String acquirerId;

  public static final String JSON_PROPERTY_MERCHANT_ID = "merchantId";
  private String merchantId;

  public MerchantAcquirerPair() {}

  /**
   * The acquirer ID.
   *
   * @param acquirerId The acquirer ID.
   * @return the current {@code MerchantAcquirerPair} instance, allowing for method chaining
   */
  public MerchantAcquirerPair acquirerId(String acquirerId) {
    this.acquirerId = acquirerId;
    return this;
  }

  /**
   * The acquirer ID.
   *
   * @return acquirerId The acquirer ID.
   */
  @JsonProperty(JSON_PROPERTY_ACQUIRER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAcquirerId() {
    return acquirerId;
  }

  /**
   * The acquirer ID.
   *
   * @param acquirerId The acquirer ID.
   */
  @JsonProperty(JSON_PROPERTY_ACQUIRER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAcquirerId(String acquirerId) {
    this.acquirerId = acquirerId;
  }

  /**
   * The merchant identification number (MID).
   *
   * @param merchantId The merchant identification number (MID).
   * @return the current {@code MerchantAcquirerPair} instance, allowing for method chaining
   */
  public MerchantAcquirerPair merchantId(String merchantId) {
    this.merchantId = merchantId;
    return this;
  }

  /**
   * The merchant identification number (MID).
   *
   * @return merchantId The merchant identification number (MID).
   */
  @JsonProperty(JSON_PROPERTY_MERCHANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMerchantId() {
    return merchantId;
  }

  /**
   * The merchant identification number (MID).
   *
   * @param merchantId The merchant identification number (MID).
   */
  @JsonProperty(JSON_PROPERTY_MERCHANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMerchantId(String merchantId) {
    this.merchantId = merchantId;
  }

  /** Return true if this MerchantAcquirerPair object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MerchantAcquirerPair merchantAcquirerPair = (MerchantAcquirerPair) o;
    return Objects.equals(this.acquirerId, merchantAcquirerPair.acquirerId)
        && Objects.equals(this.merchantId, merchantAcquirerPair.merchantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(acquirerId, merchantId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MerchantAcquirerPair {\n");
    sb.append("    acquirerId: ").append(toIndentedString(acquirerId)).append("\n");
    sb.append("    merchantId: ").append(toIndentedString(merchantId)).append("\n");
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
   * Create an instance of MerchantAcquirerPair given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of MerchantAcquirerPair
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     MerchantAcquirerPair
   */
  public static MerchantAcquirerPair fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, MerchantAcquirerPair.class);
  }

  /**
   * Convert an instance of MerchantAcquirerPair to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
