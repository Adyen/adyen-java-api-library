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

/** StoreAndForward */
@JsonPropertyOrder({
  StoreAndForward.JSON_PROPERTY_MAX_AMOUNT,
  StoreAndForward.JSON_PROPERTY_MAX_PAYMENTS,
  StoreAndForward.JSON_PROPERTY_SUPPORTED_CARD_TYPES
})
public class StoreAndForward {
  public static final String JSON_PROPERTY_MAX_AMOUNT = "maxAmount";
  private List<MinorUnitsMonetaryValue> maxAmount;

  public static final String JSON_PROPERTY_MAX_PAYMENTS = "maxPayments";
  private Integer maxPayments;

  public static final String JSON_PROPERTY_SUPPORTED_CARD_TYPES = "supportedCardTypes";
  private SupportedCardTypes supportedCardTypes;

  public StoreAndForward() {}

  /**
   * The maximum amount that the terminal accepts for a single store-and-forward payment.
   *
   * @param maxAmount The maximum amount that the terminal accepts for a single store-and-forward
   *     payment.
   * @return the current {@code StoreAndForward} instance, allowing for method chaining
   */
  public StoreAndForward maxAmount(List<MinorUnitsMonetaryValue> maxAmount) {
    this.maxAmount = maxAmount;
    return this;
  }

  public StoreAndForward addMaxAmountItem(MinorUnitsMonetaryValue maxAmountItem) {
    if (this.maxAmount == null) {
      this.maxAmount = new ArrayList<>();
    }
    this.maxAmount.add(maxAmountItem);
    return this;
  }

  /**
   * The maximum amount that the terminal accepts for a single store-and-forward payment.
   *
   * @return maxAmount The maximum amount that the terminal accepts for a single store-and-forward
   *     payment.
   */
  @JsonProperty(JSON_PROPERTY_MAX_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<MinorUnitsMonetaryValue> getMaxAmount() {
    return maxAmount;
  }

  /**
   * The maximum amount that the terminal accepts for a single store-and-forward payment.
   *
   * @param maxAmount The maximum amount that the terminal accepts for a single store-and-forward
   *     payment.
   */
  @JsonProperty(JSON_PROPERTY_MAX_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMaxAmount(List<MinorUnitsMonetaryValue> maxAmount) {
    this.maxAmount = maxAmount;
  }

  /**
   * The maximum number of store-and-forward transactions per terminal that you can process while
   * offline.
   *
   * @param maxPayments The maximum number of store-and-forward transactions per terminal that you
   *     can process while offline.
   * @return the current {@code StoreAndForward} instance, allowing for method chaining
   */
  public StoreAndForward maxPayments(Integer maxPayments) {
    this.maxPayments = maxPayments;
    return this;
  }

  /**
   * The maximum number of store-and-forward transactions per terminal that you can process while
   * offline.
   *
   * @return maxPayments The maximum number of store-and-forward transactions per terminal that you
   *     can process while offline.
   */
  @JsonProperty(JSON_PROPERTY_MAX_PAYMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getMaxPayments() {
    return maxPayments;
  }

  /**
   * The maximum number of store-and-forward transactions per terminal that you can process while
   * offline.
   *
   * @param maxPayments The maximum number of store-and-forward transactions per terminal that you
   *     can process while offline.
   */
  @JsonProperty(JSON_PROPERTY_MAX_PAYMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMaxPayments(Integer maxPayments) {
    this.maxPayments = maxPayments;
  }

  /**
   * supportedCardTypes
   *
   * @param supportedCardTypes
   * @return the current {@code StoreAndForward} instance, allowing for method chaining
   */
  public StoreAndForward supportedCardTypes(SupportedCardTypes supportedCardTypes) {
    this.supportedCardTypes = supportedCardTypes;
    return this;
  }

  /**
   * Get supportedCardTypes
   *
   * @return supportedCardTypes
   */
  @JsonProperty(JSON_PROPERTY_SUPPORTED_CARD_TYPES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SupportedCardTypes getSupportedCardTypes() {
    return supportedCardTypes;
  }

  /**
   * supportedCardTypes
   *
   * @param supportedCardTypes
   */
  @JsonProperty(JSON_PROPERTY_SUPPORTED_CARD_TYPES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSupportedCardTypes(SupportedCardTypes supportedCardTypes) {
    this.supportedCardTypes = supportedCardTypes;
  }

  /** Return true if this StoreAndForward object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoreAndForward storeAndForward = (StoreAndForward) o;
    return Objects.equals(this.maxAmount, storeAndForward.maxAmount)
        && Objects.equals(this.maxPayments, storeAndForward.maxPayments)
        && Objects.equals(this.supportedCardTypes, storeAndForward.supportedCardTypes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxAmount, maxPayments, supportedCardTypes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StoreAndForward {\n");
    sb.append("    maxAmount: ").append(toIndentedString(maxAmount)).append("\n");
    sb.append("    maxPayments: ").append(toIndentedString(maxPayments)).append("\n");
    sb.append("    supportedCardTypes: ").append(toIndentedString(supportedCardTypes)).append("\n");
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
   * Create an instance of StoreAndForward given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of StoreAndForward
   * @throws JsonProcessingException if the JSON string is invalid with respect to StoreAndForward
   */
  public static StoreAndForward fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, StoreAndForward.class);
  }

  /**
   * Convert an instance of StoreAndForward to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
