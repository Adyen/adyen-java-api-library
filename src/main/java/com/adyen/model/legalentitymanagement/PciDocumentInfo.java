/*
 * Legal Entity Management API
 *
 * The version of the OpenAPI document: 3
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.legalentitymanagement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.OffsetDateTime;
import java.util.*;

/** PciDocumentInfo */
@JsonPropertyOrder({
  PciDocumentInfo.JSON_PROPERTY_CREATED_AT,
  PciDocumentInfo.JSON_PROPERTY_ID,
  PciDocumentInfo.JSON_PROPERTY_VALID_UNTIL
})
public class PciDocumentInfo {
  public static final String JSON_PROPERTY_CREATED_AT = "createdAt";
  private OffsetDateTime createdAt;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_VALID_UNTIL = "validUntil";
  private OffsetDateTime validUntil;

  public PciDocumentInfo() {}

  /**
   * The date the questionnaire was created, in ISO 8601 extended format. For example,
   * 2022-12-18T10:15:30+01:00
   *
   * @param createdAt The date the questionnaire was created, in ISO 8601 extended format. For
   *     example, 2022-12-18T10:15:30+01:00
   * @return the current {@code PciDocumentInfo} instance, allowing for method chaining
   */
  public PciDocumentInfo createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * The date the questionnaire was created, in ISO 8601 extended format. For example,
   * 2022-12-18T10:15:30+01:00
   *
   * @return createdAt The date the questionnaire was created, in ISO 8601 extended format. For
   *     example, 2022-12-18T10:15:30+01:00
   */
  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * The date the questionnaire was created, in ISO 8601 extended format. For example,
   * 2022-12-18T10:15:30+01:00
   *
   * @param createdAt The date the questionnaire was created, in ISO 8601 extended format. For
   *     example, 2022-12-18T10:15:30+01:00
   */
  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * The unique identifier of the signed questionnaire.
   *
   * @param id The unique identifier of the signed questionnaire.
   * @return the current {@code PciDocumentInfo} instance, allowing for method chaining
   */
  public PciDocumentInfo id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier of the signed questionnaire.
   *
   * @return id The unique identifier of the signed questionnaire.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getId() {
    return id;
  }

  /**
   * The unique identifier of the signed questionnaire.
   *
   * @param id The unique identifier of the signed questionnaire.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The expiration date of the questionnaire, in ISO 8601 extended format. For example,
   * 2022-12-18T10:15:30+01:00
   *
   * @param validUntil The expiration date of the questionnaire, in ISO 8601 extended format. For
   *     example, 2022-12-18T10:15:30+01:00
   * @return the current {@code PciDocumentInfo} instance, allowing for method chaining
   */
  public PciDocumentInfo validUntil(OffsetDateTime validUntil) {
    this.validUntil = validUntil;
    return this;
  }

  /**
   * The expiration date of the questionnaire, in ISO 8601 extended format. For example,
   * 2022-12-18T10:15:30+01:00
   *
   * @return validUntil The expiration date of the questionnaire, in ISO 8601 extended format. For
   *     example, 2022-12-18T10:15:30+01:00
   */
  @JsonProperty(JSON_PROPERTY_VALID_UNTIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getValidUntil() {
    return validUntil;
  }

  /**
   * The expiration date of the questionnaire, in ISO 8601 extended format. For example,
   * 2022-12-18T10:15:30+01:00
   *
   * @param validUntil The expiration date of the questionnaire, in ISO 8601 extended format. For
   *     example, 2022-12-18T10:15:30+01:00
   */
  @JsonProperty(JSON_PROPERTY_VALID_UNTIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValidUntil(OffsetDateTime validUntil) {
    this.validUntil = validUntil;
  }

  /** Return true if this PciDocumentInfo object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PciDocumentInfo pciDocumentInfo = (PciDocumentInfo) o;
    return Objects.equals(this.createdAt, pciDocumentInfo.createdAt)
        && Objects.equals(this.id, pciDocumentInfo.id)
        && Objects.equals(this.validUntil, pciDocumentInfo.validUntil);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, id, validUntil);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PciDocumentInfo {\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    validUntil: ").append(toIndentedString(validUntil)).append("\n");
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
   * Create an instance of PciDocumentInfo given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PciDocumentInfo
   * @throws JsonProcessingException if the JSON string is invalid with respect to PciDocumentInfo
   */
  public static PciDocumentInfo fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, PciDocumentInfo.class);
  }

  /**
   * Convert an instance of PciDocumentInfo to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
