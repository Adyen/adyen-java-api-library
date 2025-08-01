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

/** PaymentInstrumentRevealResponse */
@JsonPropertyOrder({PaymentInstrumentRevealResponse.JSON_PROPERTY_ENCRYPTED_DATA})
public class PaymentInstrumentRevealResponse {
  public static final String JSON_PROPERTY_ENCRYPTED_DATA = "encryptedData";
  private String encryptedData;

  public PaymentInstrumentRevealResponse() {}

  /**
   * The data encrypted using the &#x60;encryptedKey&#x60;.
   *
   * @param encryptedData The data encrypted using the &#x60;encryptedKey&#x60;.
   * @return the current {@code PaymentInstrumentRevealResponse} instance, allowing for method
   *     chaining
   */
  public PaymentInstrumentRevealResponse encryptedData(String encryptedData) {
    this.encryptedData = encryptedData;
    return this;
  }

  /**
   * The data encrypted using the &#x60;encryptedKey&#x60;.
   *
   * @return encryptedData The data encrypted using the &#x60;encryptedKey&#x60;.
   */
  @JsonProperty(JSON_PROPERTY_ENCRYPTED_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getEncryptedData() {
    return encryptedData;
  }

  /**
   * The data encrypted using the &#x60;encryptedKey&#x60;.
   *
   * @param encryptedData The data encrypted using the &#x60;encryptedKey&#x60;.
   */
  @JsonProperty(JSON_PROPERTY_ENCRYPTED_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEncryptedData(String encryptedData) {
    this.encryptedData = encryptedData;
  }

  /** Return true if this PaymentInstrumentRevealResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentInstrumentRevealResponse paymentInstrumentRevealResponse =
        (PaymentInstrumentRevealResponse) o;
    return Objects.equals(this.encryptedData, paymentInstrumentRevealResponse.encryptedData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encryptedData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentInstrumentRevealResponse {\n");
    sb.append("    encryptedData: ").append(toIndentedString(encryptedData)).append("\n");
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
   * Create an instance of PaymentInstrumentRevealResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PaymentInstrumentRevealResponse
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     PaymentInstrumentRevealResponse
   */
  public static PaymentInstrumentRevealResponse fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, PaymentInstrumentRevealResponse.class);
  }

  /**
   * Convert an instance of PaymentInstrumentRevealResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
