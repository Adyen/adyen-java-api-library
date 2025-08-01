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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** UndefinedBeneficiary */
@JsonPropertyOrder({
  UndefinedBeneficiary.JSON_PROPERTY_DESCRIPTION,
  UndefinedBeneficiary.JSON_PROPERTY_REFERENCE
})
public class UndefinedBeneficiary {
  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_REFERENCE = "reference";
  private String reference;

  public UndefinedBeneficiary() {}

  @JsonCreator
  public UndefinedBeneficiary(@JsonProperty(JSON_PROPERTY_REFERENCE) String reference) {
    this();
    this.reference = reference;
  }

  /**
   * The details of the undefined beneficiary.
   *
   * @param description The details of the undefined beneficiary.
   * @return the current {@code UndefinedBeneficiary} instance, allowing for method chaining
   */
  public UndefinedBeneficiary description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The details of the undefined beneficiary.
   *
   * @return description The details of the undefined beneficiary.
   */
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDescription() {
    return description;
  }

  /**
   * The details of the undefined beneficiary.
   *
   * @param description The details of the undefined beneficiary.
   */
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * The reference of the undefined beneficiary.
   *
   * @return reference The reference of the undefined beneficiary.
   */
  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getReference() {
    return reference;
  }

  /** Return true if this UndefinedBeneficiary object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UndefinedBeneficiary undefinedBeneficiary = (UndefinedBeneficiary) o;
    return Objects.equals(this.description, undefinedBeneficiary.description)
        && Objects.equals(this.reference, undefinedBeneficiary.reference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, reference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UndefinedBeneficiary {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
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
   * Create an instance of UndefinedBeneficiary given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of UndefinedBeneficiary
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     UndefinedBeneficiary
   */
  public static UndefinedBeneficiary fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, UndefinedBeneficiary.class);
  }

  /**
   * Convert an instance of UndefinedBeneficiary to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
