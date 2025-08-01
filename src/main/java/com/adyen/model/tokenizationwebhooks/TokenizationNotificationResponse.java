/*
 * Tokenization webhooks
 *
 * The version of the OpenAPI document: 1
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.tokenizationwebhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** TokenizationNotificationResponse */
@JsonPropertyOrder({TokenizationNotificationResponse.JSON_PROPERTY_NOTIFICATION_RESPONSE})
public class TokenizationNotificationResponse {
  public static final String JSON_PROPERTY_NOTIFICATION_RESPONSE = "notificationResponse";
  private String notificationResponse;

  public TokenizationNotificationResponse() {}

  /**
   * Respond with any **2xx** HTTP status code to [accept the
   * webhook](https://docs.adyen.com/development-resources/webhooks/#accept-webhooks).
   *
   * @param notificationResponse Respond with any **2xx** HTTP status code to [accept the
   *     webhook](https://docs.adyen.com/development-resources/webhooks/#accept-webhooks).
   * @return the current {@code TokenizationNotificationResponse} instance, allowing for method
   *     chaining
   */
  public TokenizationNotificationResponse notificationResponse(String notificationResponse) {
    this.notificationResponse = notificationResponse;
    return this;
  }

  /**
   * Respond with any **2xx** HTTP status code to [accept the
   * webhook](https://docs.adyen.com/development-resources/webhooks/#accept-webhooks).
   *
   * @return notificationResponse Respond with any **2xx** HTTP status code to [accept the
   *     webhook](https://docs.adyen.com/development-resources/webhooks/#accept-webhooks).
   */
  @JsonProperty(JSON_PROPERTY_NOTIFICATION_RESPONSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getNotificationResponse() {
    return notificationResponse;
  }

  /**
   * Respond with any **2xx** HTTP status code to [accept the
   * webhook](https://docs.adyen.com/development-resources/webhooks/#accept-webhooks).
   *
   * @param notificationResponse Respond with any **2xx** HTTP status code to [accept the
   *     webhook](https://docs.adyen.com/development-resources/webhooks/#accept-webhooks).
   */
  @JsonProperty(JSON_PROPERTY_NOTIFICATION_RESPONSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNotificationResponse(String notificationResponse) {
    this.notificationResponse = notificationResponse;
  }

  /** Return true if this TokenizationNotificationResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenizationNotificationResponse tokenizationNotificationResponse =
        (TokenizationNotificationResponse) o;
    return Objects.equals(
        this.notificationResponse, tokenizationNotificationResponse.notificationResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(notificationResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenizationNotificationResponse {\n");
    sb.append("    notificationResponse: ")
        .append(toIndentedString(notificationResponse))
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
   * Create an instance of TokenizationNotificationResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of TokenizationNotificationResponse
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     TokenizationNotificationResponse
   */
  public static TokenizationNotificationResponse fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, TokenizationNotificationResponse.class);
  }

  /**
   * Convert an instance of TokenizationNotificationResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
