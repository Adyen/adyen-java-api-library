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

/** UpdateSplitConfigurationRuleRequest */
@JsonPropertyOrder({
  UpdateSplitConfigurationRuleRequest.JSON_PROPERTY_CURRENCY,
  UpdateSplitConfigurationRuleRequest.JSON_PROPERTY_FUNDING_SOURCE,
  UpdateSplitConfigurationRuleRequest.JSON_PROPERTY_PAYMENT_METHOD,
  UpdateSplitConfigurationRuleRequest.JSON_PROPERTY_SHOPPER_INTERACTION
})
public class UpdateSplitConfigurationRuleRequest {
  public static final String JSON_PROPERTY_CURRENCY = "currency";
  private String currency;

  public static final String JSON_PROPERTY_FUNDING_SOURCE = "fundingSource";
  private String fundingSource;

  public static final String JSON_PROPERTY_PAYMENT_METHOD = "paymentMethod";
  private String paymentMethod;

  public static final String JSON_PROPERTY_SHOPPER_INTERACTION = "shopperInteraction";
  private String shopperInteraction;

  public UpdateSplitConfigurationRuleRequest() {}

  /**
   * The currency condition that defines whether the split logic applies. Its value must be a
   * three-character [ISO currency code](https://en.wikipedia.org/wiki/ISO_4217).
   *
   * @param currency The currency condition that defines whether the split logic applies. Its value
   *     must be a three-character [ISO currency code](https://en.wikipedia.org/wiki/ISO_4217).
   * @return the current {@code UpdateSplitConfigurationRuleRequest} instance, allowing for method
   *     chaining
   */
  public UpdateSplitConfigurationRuleRequest currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * The currency condition that defines whether the split logic applies. Its value must be a
   * three-character [ISO currency code](https://en.wikipedia.org/wiki/ISO_4217).
   *
   * @return currency The currency condition that defines whether the split logic applies. Its value
   *     must be a three-character [ISO currency code](https://en.wikipedia.org/wiki/ISO_4217).
   */
  @JsonProperty(JSON_PROPERTY_CURRENCY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCurrency() {
    return currency;
  }

  /**
   * The currency condition that defines whether the split logic applies. Its value must be a
   * three-character [ISO currency code](https://en.wikipedia.org/wiki/ISO_4217).
   *
   * @param currency The currency condition that defines whether the split logic applies. Its value
   *     must be a three-character [ISO currency code](https://en.wikipedia.org/wiki/ISO_4217).
   */
  @JsonProperty(JSON_PROPERTY_CURRENCY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  /**
   * The funding source of the payment method. This only applies to card transactions. Possible
   * values: * **credit** * **debit** * **prepaid** * **deferred_debit** * **charged** * **ANY**
   *
   * @param fundingSource The funding source of the payment method. This only applies to card
   *     transactions. Possible values: * **credit** * **debit** * **prepaid** * **deferred_debit**
   *     * **charged** * **ANY**
   * @return the current {@code UpdateSplitConfigurationRuleRequest} instance, allowing for method
   *     chaining
   */
  public UpdateSplitConfigurationRuleRequest fundingSource(String fundingSource) {
    this.fundingSource = fundingSource;
    return this;
  }

  /**
   * The funding source of the payment method. This only applies to card transactions. Possible
   * values: * **credit** * **debit** * **prepaid** * **deferred_debit** * **charged** * **ANY**
   *
   * @return fundingSource The funding source of the payment method. This only applies to card
   *     transactions. Possible values: * **credit** * **debit** * **prepaid** * **deferred_debit**
   *     * **charged** * **ANY**
   */
  @JsonProperty(JSON_PROPERTY_FUNDING_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getFundingSource() {
    return fundingSource;
  }

  /**
   * The funding source of the payment method. This only applies to card transactions. Possible
   * values: * **credit** * **debit** * **prepaid** * **deferred_debit** * **charged** * **ANY**
   *
   * @param fundingSource The funding source of the payment method. This only applies to card
   *     transactions. Possible values: * **credit** * **debit** * **prepaid** * **deferred_debit**
   *     * **charged** * **ANY**
   */
  @JsonProperty(JSON_PROPERTY_FUNDING_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFundingSource(String fundingSource) {
    this.fundingSource = fundingSource;
  }

  /**
   * The payment method condition that defines whether the split logic applies. Possible values: *
   * [Payment method variant](https://docs.adyen.com/development-resources/paymentmethodvariant):
   * Apply the split logic for a specific payment method. * **ANY**: Apply the split logic for all
   * available payment methods.
   *
   * @param paymentMethod The payment method condition that defines whether the split logic applies.
   *     Possible values: * [Payment method
   *     variant](https://docs.adyen.com/development-resources/paymentmethodvariant): Apply the
   *     split logic for a specific payment method. * **ANY**: Apply the split logic for all
   *     available payment methods.
   * @return the current {@code UpdateSplitConfigurationRuleRequest} instance, allowing for method
   *     chaining
   */
  public UpdateSplitConfigurationRuleRequest paymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

  /**
   * The payment method condition that defines whether the split logic applies. Possible values: *
   * [Payment method variant](https://docs.adyen.com/development-resources/paymentmethodvariant):
   * Apply the split logic for a specific payment method. * **ANY**: Apply the split logic for all
   * available payment methods.
   *
   * @return paymentMethod The payment method condition that defines whether the split logic
   *     applies. Possible values: * [Payment method
   *     variant](https://docs.adyen.com/development-resources/paymentmethodvariant): Apply the
   *     split logic for a specific payment method. * **ANY**: Apply the split logic for all
   *     available payment methods.
   */
  @JsonProperty(JSON_PROPERTY_PAYMENT_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPaymentMethod() {
    return paymentMethod;
  }

  /**
   * The payment method condition that defines whether the split logic applies. Possible values: *
   * [Payment method variant](https://docs.adyen.com/development-resources/paymentmethodvariant):
   * Apply the split logic for a specific payment method. * **ANY**: Apply the split logic for all
   * available payment methods.
   *
   * @param paymentMethod The payment method condition that defines whether the split logic applies.
   *     Possible values: * [Payment method
   *     variant](https://docs.adyen.com/development-resources/paymentmethodvariant): Apply the
   *     split logic for a specific payment method. * **ANY**: Apply the split logic for all
   *     available payment methods.
   */
  @JsonProperty(JSON_PROPERTY_PAYMENT_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  /**
   * The sales channel condition that defines whether the split logic applies. Possible values: *
   * **Ecommerce**: Online transactions where the cardholder is present. * **ContAuth**: Card on
   * file and/or subscription transactions, where the cardholder is known to the merchant (returning
   * customer). * **Moto**: Mail-order and telephone-order transactions where the customer is in
   * contact with the merchant via email or telephone. * **POS**: Point-of-sale transactions where
   * the customer is physically present to make a payment using a secure payment terminal. *
   * **ANY**: All sales channels.
   *
   * @param shopperInteraction The sales channel condition that defines whether the split logic
   *     applies. Possible values: * **Ecommerce**: Online transactions where the cardholder is
   *     present. * **ContAuth**: Card on file and/or subscription transactions, where the
   *     cardholder is known to the merchant (returning customer). * **Moto**: Mail-order and
   *     telephone-order transactions where the customer is in contact with the merchant via email
   *     or telephone. * **POS**: Point-of-sale transactions where the customer is physically
   *     present to make a payment using a secure payment terminal. * **ANY**: All sales channels.
   * @return the current {@code UpdateSplitConfigurationRuleRequest} instance, allowing for method
   *     chaining
   */
  public UpdateSplitConfigurationRuleRequest shopperInteraction(String shopperInteraction) {
    this.shopperInteraction = shopperInteraction;
    return this;
  }

  /**
   * The sales channel condition that defines whether the split logic applies. Possible values: *
   * **Ecommerce**: Online transactions where the cardholder is present. * **ContAuth**: Card on
   * file and/or subscription transactions, where the cardholder is known to the merchant (returning
   * customer). * **Moto**: Mail-order and telephone-order transactions where the customer is in
   * contact with the merchant via email or telephone. * **POS**: Point-of-sale transactions where
   * the customer is physically present to make a payment using a secure payment terminal. *
   * **ANY**: All sales channels.
   *
   * @return shopperInteraction The sales channel condition that defines whether the split logic
   *     applies. Possible values: * **Ecommerce**: Online transactions where the cardholder is
   *     present. * **ContAuth**: Card on file and/or subscription transactions, where the
   *     cardholder is known to the merchant (returning customer). * **Moto**: Mail-order and
   *     telephone-order transactions where the customer is in contact with the merchant via email
   *     or telephone. * **POS**: Point-of-sale transactions where the customer is physically
   *     present to make a payment using a secure payment terminal. * **ANY**: All sales channels.
   */
  @JsonProperty(JSON_PROPERTY_SHOPPER_INTERACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getShopperInteraction() {
    return shopperInteraction;
  }

  /**
   * The sales channel condition that defines whether the split logic applies. Possible values: *
   * **Ecommerce**: Online transactions where the cardholder is present. * **ContAuth**: Card on
   * file and/or subscription transactions, where the cardholder is known to the merchant (returning
   * customer). * **Moto**: Mail-order and telephone-order transactions where the customer is in
   * contact with the merchant via email or telephone. * **POS**: Point-of-sale transactions where
   * the customer is physically present to make a payment using a secure payment terminal. *
   * **ANY**: All sales channels.
   *
   * @param shopperInteraction The sales channel condition that defines whether the split logic
   *     applies. Possible values: * **Ecommerce**: Online transactions where the cardholder is
   *     present. * **ContAuth**: Card on file and/or subscription transactions, where the
   *     cardholder is known to the merchant (returning customer). * **Moto**: Mail-order and
   *     telephone-order transactions where the customer is in contact with the merchant via email
   *     or telephone. * **POS**: Point-of-sale transactions where the customer is physically
   *     present to make a payment using a secure payment terminal. * **ANY**: All sales channels.
   */
  @JsonProperty(JSON_PROPERTY_SHOPPER_INTERACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setShopperInteraction(String shopperInteraction) {
    this.shopperInteraction = shopperInteraction;
  }

  /** Return true if this UpdateSplitConfigurationRuleRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateSplitConfigurationRuleRequest updateSplitConfigurationRuleRequest =
        (UpdateSplitConfigurationRuleRequest) o;
    return Objects.equals(this.currency, updateSplitConfigurationRuleRequest.currency)
        && Objects.equals(this.fundingSource, updateSplitConfigurationRuleRequest.fundingSource)
        && Objects.equals(this.paymentMethod, updateSplitConfigurationRuleRequest.paymentMethod)
        && Objects.equals(
            this.shopperInteraction, updateSplitConfigurationRuleRequest.shopperInteraction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currency, fundingSource, paymentMethod, shopperInteraction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateSplitConfigurationRuleRequest {\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    fundingSource: ").append(toIndentedString(fundingSource)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    shopperInteraction: ").append(toIndentedString(shopperInteraction)).append("\n");
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
   * Create an instance of UpdateSplitConfigurationRuleRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of UpdateSplitConfigurationRuleRequest
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     UpdateSplitConfigurationRuleRequest
   */
  public static UpdateSplitConfigurationRuleRequest fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, UpdateSplitConfigurationRuleRequest.class);
  }

  /**
   * Convert an instance of UpdateSplitConfigurationRuleRequest to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
