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

/** TransactionRuleEntityKey */
@JsonPropertyOrder({
  TransactionRuleEntityKey.JSON_PROPERTY_ENTITY_REFERENCE,
  TransactionRuleEntityKey.JSON_PROPERTY_ENTITY_TYPE
})
public class TransactionRuleEntityKey {
  public static final String JSON_PROPERTY_ENTITY_REFERENCE = "entityReference";
  private String entityReference;

  public static final String JSON_PROPERTY_ENTITY_TYPE = "entityType";
  private String entityType;

  public TransactionRuleEntityKey() {}

  /**
   * The unique identifier of the resource.
   *
   * @param entityReference The unique identifier of the resource.
   * @return the current {@code TransactionRuleEntityKey} instance, allowing for method chaining
   */
  public TransactionRuleEntityKey entityReference(String entityReference) {
    this.entityReference = entityReference;
    return this;
  }

  /**
   * The unique identifier of the resource.
   *
   * @return entityReference The unique identifier of the resource.
   */
  @JsonProperty(JSON_PROPERTY_ENTITY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getEntityReference() {
    return entityReference;
  }

  /**
   * The unique identifier of the resource.
   *
   * @param entityReference The unique identifier of the resource.
   */
  @JsonProperty(JSON_PROPERTY_ENTITY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEntityReference(String entityReference) {
    this.entityReference = entityReference;
  }

  /**
   * The type of resource. Possible values: **balancePlatform**, **paymentInstrumentGroup**,
   * **accountHolder**, **balanceAccount**, or **paymentInstrument**.
   *
   * @param entityType The type of resource. Possible values: **balancePlatform**,
   *     **paymentInstrumentGroup**, **accountHolder**, **balanceAccount**, or
   *     **paymentInstrument**.
   * @return the current {@code TransactionRuleEntityKey} instance, allowing for method chaining
   */
  public TransactionRuleEntityKey entityType(String entityType) {
    this.entityType = entityType;
    return this;
  }

  /**
   * The type of resource. Possible values: **balancePlatform**, **paymentInstrumentGroup**,
   * **accountHolder**, **balanceAccount**, or **paymentInstrument**.
   *
   * @return entityType The type of resource. Possible values: **balancePlatform**,
   *     **paymentInstrumentGroup**, **accountHolder**, **balanceAccount**, or
   *     **paymentInstrument**.
   */
  @JsonProperty(JSON_PROPERTY_ENTITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getEntityType() {
    return entityType;
  }

  /**
   * The type of resource. Possible values: **balancePlatform**, **paymentInstrumentGroup**,
   * **accountHolder**, **balanceAccount**, or **paymentInstrument**.
   *
   * @param entityType The type of resource. Possible values: **balancePlatform**,
   *     **paymentInstrumentGroup**, **accountHolder**, **balanceAccount**, or
   *     **paymentInstrument**.
   */
  @JsonProperty(JSON_PROPERTY_ENTITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEntityType(String entityType) {
    this.entityType = entityType;
  }

  /** Return true if this TransactionRuleEntityKey object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionRuleEntityKey transactionRuleEntityKey = (TransactionRuleEntityKey) o;
    return Objects.equals(this.entityReference, transactionRuleEntityKey.entityReference)
        && Objects.equals(this.entityType, transactionRuleEntityKey.entityType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entityReference, entityType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionRuleEntityKey {\n");
    sb.append("    entityReference: ").append(toIndentedString(entityReference)).append("\n");
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
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
   * Create an instance of TransactionRuleEntityKey given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of TransactionRuleEntityKey
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     TransactionRuleEntityKey
   */
  public static TransactionRuleEntityKey fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, TransactionRuleEntityKey.class);
  }

  /**
   * Convert an instance of TransactionRuleEntityKey to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
