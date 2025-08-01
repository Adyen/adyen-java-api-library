/*
 * Management Webhooks
 *
 * The version of the OpenAPI document: 3
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.managementwebhooks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.Arrays;
import java.util.logging.Logger;

/** PaymentMethodScheduledForRemovalNotificationRequest */
@JsonPropertyOrder({
  PaymentMethodScheduledForRemovalNotificationRequest.JSON_PROPERTY_CREATED_AT,
  PaymentMethodScheduledForRemovalNotificationRequest.JSON_PROPERTY_DATA,
  PaymentMethodScheduledForRemovalNotificationRequest.JSON_PROPERTY_ENVIRONMENT,
  PaymentMethodScheduledForRemovalNotificationRequest.JSON_PROPERTY_TYPE
})
public class PaymentMethodScheduledForRemovalNotificationRequest {
  public static final String JSON_PROPERTY_CREATED_AT = "createdAt";
  private OffsetDateTime createdAt;

  public static final String JSON_PROPERTY_DATA = "data";
  private MidServiceNotificationData data;

  public static final String JSON_PROPERTY_ENVIRONMENT = "environment";
  private String environment;

  /** Type of notification. */
  public enum TypeEnum {
    PAYMENTMETHODREQUEST_SCHEDULEDFORREMOVAL(
        String.valueOf("paymentMethodRequest.scheduledForRemoval"));

    private static final Logger LOG = Logger.getLogger(TypeEnum.class.getName());

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      // handling unexpected value
      LOG.warning(
          "TypeEnum: unexpected enum value '"
              + value
              + "' - Supported values are "
              + Arrays.toString(TypeEnum.values()));
      return null;
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeEnum type;

  public PaymentMethodScheduledForRemovalNotificationRequest() {}

  /**
   * Timestamp for when the webhook was created.
   *
   * @param createdAt Timestamp for when the webhook was created.
   * @return the current {@code PaymentMethodScheduledForRemovalNotificationRequest} instance,
   *     allowing for method chaining
   */
  public PaymentMethodScheduledForRemovalNotificationRequest createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Timestamp for when the webhook was created.
   *
   * @return createdAt Timestamp for when the webhook was created.
   */
  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * Timestamp for when the webhook was created.
   *
   * @param createdAt Timestamp for when the webhook was created.
   */
  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * data
   *
   * @param data
   * @return the current {@code PaymentMethodScheduledForRemovalNotificationRequest} instance,
   *     allowing for method chaining
   */
  public PaymentMethodScheduledForRemovalNotificationRequest data(MidServiceNotificationData data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   *
   * @return data
   */
  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public MidServiceNotificationData getData() {
    return data;
  }

  /**
   * data
   *
   * @param data
   */
  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setData(MidServiceNotificationData data) {
    this.data = data;
  }

  /**
   * The environment from which the webhook originated. Possible values: **test**, **live**.
   *
   * @param environment The environment from which the webhook originated. Possible values:
   *     **test**, **live**.
   * @return the current {@code PaymentMethodScheduledForRemovalNotificationRequest} instance,
   *     allowing for method chaining
   */
  public PaymentMethodScheduledForRemovalNotificationRequest environment(String environment) {
    this.environment = environment;
    return this;
  }

  /**
   * The environment from which the webhook originated. Possible values: **test**, **live**.
   *
   * @return environment The environment from which the webhook originated. Possible values:
   *     **test**, **live**.
   */
  @JsonProperty(JSON_PROPERTY_ENVIRONMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getEnvironment() {
    return environment;
  }

  /**
   * The environment from which the webhook originated. Possible values: **test**, **live**.
   *
   * @param environment The environment from which the webhook originated. Possible values:
   *     **test**, **live**.
   */
  @JsonProperty(JSON_PROPERTY_ENVIRONMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEnvironment(String environment) {
    this.environment = environment;
  }

  /**
   * Type of notification.
   *
   * @param type Type of notification.
   * @return the current {@code PaymentMethodScheduledForRemovalNotificationRequest} instance,
   *     allowing for method chaining
   */
  public PaymentMethodScheduledForRemovalNotificationRequest type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Type of notification.
   *
   * @return type Type of notification.
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public TypeEnum getType() {
    return type;
  }

  /**
   * Type of notification.
   *
   * @param type Type of notification.
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(TypeEnum type) {
    this.type = type;
  }

  /**
   * Return true if this PaymentMethodScheduledForRemovalNotificationRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentMethodScheduledForRemovalNotificationRequest
        paymentMethodScheduledForRemovalNotificationRequest =
            (PaymentMethodScheduledForRemovalNotificationRequest) o;
    return Objects.equals(
            this.createdAt, paymentMethodScheduledForRemovalNotificationRequest.createdAt)
        && Objects.equals(this.data, paymentMethodScheduledForRemovalNotificationRequest.data)
        && Objects.equals(
            this.environment, paymentMethodScheduledForRemovalNotificationRequest.environment)
        && Objects.equals(this.type, paymentMethodScheduledForRemovalNotificationRequest.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, data, environment, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentMethodScheduledForRemovalNotificationRequest {\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    environment: ").append(toIndentedString(environment)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
   * Create an instance of PaymentMethodScheduledForRemovalNotificationRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PaymentMethodScheduledForRemovalNotificationRequest
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     PaymentMethodScheduledForRemovalNotificationRequest
   */
  public static PaymentMethodScheduledForRemovalNotificationRequest fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper()
        .readValue(jsonString, PaymentMethodScheduledForRemovalNotificationRequest.class);
  }

  /**
   * Convert an instance of PaymentMethodScheduledForRemovalNotificationRequest to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
