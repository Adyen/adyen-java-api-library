/*
 * Configuration webhooks
 *
 * The version of the OpenAPI document: 2
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.configurationwebhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** PaymentInstrumentNotificationData */
@JsonPropertyOrder({
  PaymentInstrumentNotificationData.JSON_PROPERTY_BALANCE_PLATFORM,
  PaymentInstrumentNotificationData.JSON_PROPERTY_PAYMENT_INSTRUMENT
})
public class PaymentInstrumentNotificationData {
  public static final String JSON_PROPERTY_BALANCE_PLATFORM = "balancePlatform";
  private String balancePlatform;

  public static final String JSON_PROPERTY_PAYMENT_INSTRUMENT = "paymentInstrument";
  private PaymentInstrument paymentInstrument;

  public PaymentInstrumentNotificationData() {}

  /**
   * The unique identifier of the balance platform.
   *
   * @param balancePlatform The unique identifier of the balance platform.
   * @return the current {@code PaymentInstrumentNotificationData} instance, allowing for method
   *     chaining
   */
  public PaymentInstrumentNotificationData balancePlatform(String balancePlatform) {
    this.balancePlatform = balancePlatform;
    return this;
  }

  /**
   * The unique identifier of the balance platform.
   *
   * @return balancePlatform The unique identifier of the balance platform.
   */
  @JsonProperty(JSON_PROPERTY_BALANCE_PLATFORM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getBalancePlatform() {
    return balancePlatform;
  }

  /**
   * The unique identifier of the balance platform.
   *
   * @param balancePlatform The unique identifier of the balance platform.
   */
  @JsonProperty(JSON_PROPERTY_BALANCE_PLATFORM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBalancePlatform(String balancePlatform) {
    this.balancePlatform = balancePlatform;
  }

  /**
   * paymentInstrument
   *
   * @param paymentInstrument
   * @return the current {@code PaymentInstrumentNotificationData} instance, allowing for method
   *     chaining
   */
  public PaymentInstrumentNotificationData paymentInstrument(PaymentInstrument paymentInstrument) {
    this.paymentInstrument = paymentInstrument;
    return this;
  }

  /**
   * Get paymentInstrument
   *
   * @return paymentInstrument
   */
  @JsonProperty(JSON_PROPERTY_PAYMENT_INSTRUMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public PaymentInstrument getPaymentInstrument() {
    return paymentInstrument;
  }

  /**
   * paymentInstrument
   *
   * @param paymentInstrument
   */
  @JsonProperty(JSON_PROPERTY_PAYMENT_INSTRUMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPaymentInstrument(PaymentInstrument paymentInstrument) {
    this.paymentInstrument = paymentInstrument;
  }

  /** Return true if this PaymentInstrumentNotificationData object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentInstrumentNotificationData paymentInstrumentNotificationData =
        (PaymentInstrumentNotificationData) o;
    return Objects.equals(this.balancePlatform, paymentInstrumentNotificationData.balancePlatform)
        && Objects.equals(
            this.paymentInstrument, paymentInstrumentNotificationData.paymentInstrument);
  }

  @Override
  public int hashCode() {
    return Objects.hash(balancePlatform, paymentInstrument);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentInstrumentNotificationData {\n");
    sb.append("    balancePlatform: ").append(toIndentedString(balancePlatform)).append("\n");
    sb.append("    paymentInstrument: ").append(toIndentedString(paymentInstrument)).append("\n");
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
   * Create an instance of PaymentInstrumentNotificationData given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PaymentInstrumentNotificationData
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     PaymentInstrumentNotificationData
   */
  public static PaymentInstrumentNotificationData fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, PaymentInstrumentNotificationData.class);
  }

  /**
   * Convert an instance of PaymentInstrumentNotificationData to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
