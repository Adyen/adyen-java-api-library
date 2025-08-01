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

/** PaymentInstrumentRevealRequest */
@JsonPropertyOrder({
  PaymentInstrumentRevealRequest.JSON_PROPERTY_ENCRYPTED_KEY,
  PaymentInstrumentRevealRequest.JSON_PROPERTY_PAYMENT_INSTRUMENT_ID
})
public class PaymentInstrumentRevealRequest {
  public static final String JSON_PROPERTY_ENCRYPTED_KEY = "encryptedKey";
  private String encryptedKey;

  public static final String JSON_PROPERTY_PAYMENT_INSTRUMENT_ID = "paymentInstrumentId";
  private String paymentInstrumentId;

  public PaymentInstrumentRevealRequest() {}

  /**
   * The symmetric session key that you encrypted with the [public
   * key](https://docs.adyen.com/api-explorer/balanceplatform/2/get/publicKey) that you received
   * from Adyen.
   *
   * @param encryptedKey The symmetric session key that you encrypted with the [public
   *     key](https://docs.adyen.com/api-explorer/balanceplatform/2/get/publicKey) that you received
   *     from Adyen.
   * @return the current {@code PaymentInstrumentRevealRequest} instance, allowing for method
   *     chaining
   */
  public PaymentInstrumentRevealRequest encryptedKey(String encryptedKey) {
    this.encryptedKey = encryptedKey;
    return this;
  }

  /**
   * The symmetric session key that you encrypted with the [public
   * key](https://docs.adyen.com/api-explorer/balanceplatform/2/get/publicKey) that you received
   * from Adyen.
   *
   * @return encryptedKey The symmetric session key that you encrypted with the [public
   *     key](https://docs.adyen.com/api-explorer/balanceplatform/2/get/publicKey) that you received
   *     from Adyen.
   */
  @JsonProperty(JSON_PROPERTY_ENCRYPTED_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getEncryptedKey() {
    return encryptedKey;
  }

  /**
   * The symmetric session key that you encrypted with the [public
   * key](https://docs.adyen.com/api-explorer/balanceplatform/2/get/publicKey) that you received
   * from Adyen.
   *
   * @param encryptedKey The symmetric session key that you encrypted with the [public
   *     key](https://docs.adyen.com/api-explorer/balanceplatform/2/get/publicKey) that you received
   *     from Adyen.
   */
  @JsonProperty(JSON_PROPERTY_ENCRYPTED_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEncryptedKey(String encryptedKey) {
    this.encryptedKey = encryptedKey;
  }

  /**
   * The unique identifier of the payment instrument, which is the card for which you are managing
   * the PIN.
   *
   * @param paymentInstrumentId The unique identifier of the payment instrument, which is the card
   *     for which you are managing the PIN.
   * @return the current {@code PaymentInstrumentRevealRequest} instance, allowing for method
   *     chaining
   */
  public PaymentInstrumentRevealRequest paymentInstrumentId(String paymentInstrumentId) {
    this.paymentInstrumentId = paymentInstrumentId;
    return this;
  }

  /**
   * The unique identifier of the payment instrument, which is the card for which you are managing
   * the PIN.
   *
   * @return paymentInstrumentId The unique identifier of the payment instrument, which is the card
   *     for which you are managing the PIN.
   */
  @JsonProperty(JSON_PROPERTY_PAYMENT_INSTRUMENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPaymentInstrumentId() {
    return paymentInstrumentId;
  }

  /**
   * The unique identifier of the payment instrument, which is the card for which you are managing
   * the PIN.
   *
   * @param paymentInstrumentId The unique identifier of the payment instrument, which is the card
   *     for which you are managing the PIN.
   */
  @JsonProperty(JSON_PROPERTY_PAYMENT_INSTRUMENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPaymentInstrumentId(String paymentInstrumentId) {
    this.paymentInstrumentId = paymentInstrumentId;
  }

  /** Return true if this PaymentInstrumentRevealRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentInstrumentRevealRequest paymentInstrumentRevealRequest =
        (PaymentInstrumentRevealRequest) o;
    return Objects.equals(this.encryptedKey, paymentInstrumentRevealRequest.encryptedKey)
        && Objects.equals(
            this.paymentInstrumentId, paymentInstrumentRevealRequest.paymentInstrumentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encryptedKey, paymentInstrumentId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentInstrumentRevealRequest {\n");
    sb.append("    encryptedKey: ").append(toIndentedString(encryptedKey)).append("\n");
    sb.append("    paymentInstrumentId: ")
        .append(toIndentedString(paymentInstrumentId))
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
   * Create an instance of PaymentInstrumentRevealRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PaymentInstrumentRevealRequest
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     PaymentInstrumentRevealRequest
   */
  public static PaymentInstrumentRevealRequest fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, PaymentInstrumentRevealRequest.class);
  }

  /**
   * Convert an instance of PaymentInstrumentRevealRequest to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
