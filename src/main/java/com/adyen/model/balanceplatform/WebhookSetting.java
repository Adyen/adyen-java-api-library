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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** WebhookSetting */
@JsonPropertyOrder({
  WebhookSetting.JSON_PROPERTY_CURRENCY,
  WebhookSetting.JSON_PROPERTY_ID,
  WebhookSetting.JSON_PROPERTY_STATUS,
  WebhookSetting.JSON_PROPERTY_TARGET,
  WebhookSetting.JSON_PROPERTY_TYPE
})
@JsonIgnoreProperties(
    value =
        "type", // ignore manually set type, it will be automatically generated by Jackson during
    // serialization
    allowSetters = true // allows the type to be set during deserialization
    )
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type",
    visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = BalanceWebhookSetting.class, name = "balance"),
})
public class WebhookSetting {
  public static final String JSON_PROPERTY_CURRENCY = "currency";
  private String currency;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_STATUS = "status";
  private String status;

  public static final String JSON_PROPERTY_TARGET = "target";
  private Target target;

  public static final String JSON_PROPERTY_TYPE = "type";
  private SettingType type;

  public WebhookSetting() {}

  /**
   * The three-character [ISO currency
   * code](https://docs.adyen.com/development-resources/currency-codes) of the balance.
   *
   * @param currency The three-character [ISO currency
   *     code](https://docs.adyen.com/development-resources/currency-codes) of the balance.
   * @return the current {@code WebhookSetting} instance, allowing for method chaining
   */
  public WebhookSetting currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * The three-character [ISO currency
   * code](https://docs.adyen.com/development-resources/currency-codes) of the balance.
   *
   * @return currency The three-character [ISO currency
   *     code](https://docs.adyen.com/development-resources/currency-codes) of the balance.
   */
  @JsonProperty(JSON_PROPERTY_CURRENCY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCurrency() {
    return currency;
  }

  /**
   * The three-character [ISO currency
   * code](https://docs.adyen.com/development-resources/currency-codes) of the balance.
   *
   * @param currency The three-character [ISO currency
   *     code](https://docs.adyen.com/development-resources/currency-codes) of the balance.
   */
  @JsonProperty(JSON_PROPERTY_CURRENCY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  /**
   * The unique identifier of the webhook setting.
   *
   * @param id The unique identifier of the webhook setting.
   * @return the current {@code WebhookSetting} instance, allowing for method chaining
   */
  public WebhookSetting id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier of the webhook setting.
   *
   * @return id The unique identifier of the webhook setting.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getId() {
    return id;
  }

  /**
   * The unique identifier of the webhook setting.
   *
   * @param id The unique identifier of the webhook setting.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }

  /**
   * status
   *
   * @param status
   * @return the current {@code WebhookSetting} instance, allowing for method chaining
   */
  public WebhookSetting status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getStatus() {
    return status;
  }

  /**
   * status
   *
   * @param status
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * target
   *
   * @param target
   * @return the current {@code WebhookSetting} instance, allowing for method chaining
   */
  public WebhookSetting target(Target target) {
    this.target = target;
    return this;
  }

  /**
   * Get target
   *
   * @return target
   */
  @JsonProperty(JSON_PROPERTY_TARGET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Target getTarget() {
    return target;
  }

  /**
   * target
   *
   * @param target
   */
  @JsonProperty(JSON_PROPERTY_TARGET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTarget(Target target) {
    this.target = target;
  }

  /**
   * type
   *
   * @param type
   * @return the current {@code WebhookSetting} instance, allowing for method chaining
   */
  public WebhookSetting type(SettingType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   *
   * @return type
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SettingType getType() {
    return type;
  }

  /**
   * type
   *
   * @param type
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(SettingType type) {
    this.type = type;
  }

  /** Return true if this WebhookSetting object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookSetting webhookSetting = (WebhookSetting) o;
    return Objects.equals(this.currency, webhookSetting.currency)
        && Objects.equals(this.id, webhookSetting.id)
        && Objects.equals(this.status, webhookSetting.status)
        && Objects.equals(this.target, webhookSetting.target)
        && Objects.equals(this.type, webhookSetting.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currency, id, status, target, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookSetting {\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
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

  static {
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<>();
    mappings.put("balance", BalanceWebhookSetting.class);
    mappings.put("WebhookSetting", WebhookSetting.class);
    JSON.registerDiscriminator(WebhookSetting.class, "type", mappings);
  }

  /**
   * Create an instance of WebhookSetting given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of WebhookSetting
   * @throws JsonProcessingException if the JSON string is invalid with respect to WebhookSetting
   */
  public static WebhookSetting fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, WebhookSetting.class);
  }

  /**
   * Convert an instance of WebhookSetting to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
