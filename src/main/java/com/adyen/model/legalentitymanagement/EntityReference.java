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
import java.util.*;

/** EntityReference */
@JsonPropertyOrder({EntityReference.JSON_PROPERTY_ID})
public class EntityReference {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public EntityReference() {}

  /**
   * The unique identifier of the resource.
   *
   * @param id The unique identifier of the resource.
   * @return the current {@code EntityReference} instance, allowing for method chaining
   */
  public EntityReference id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier of the resource.
   *
   * @return id The unique identifier of the resource.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getId() {
    return id;
  }

  /**
   * The unique identifier of the resource.
   *
   * @param id The unique identifier of the resource.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }

  /** Return true if this EntityReference object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntityReference entityReference = (EntityReference) o;
    return Objects.equals(this.id, entityReference.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntityReference {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
   * Create an instance of EntityReference given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of EntityReference
   * @throws JsonProcessingException if the JSON string is invalid with respect to EntityReference
   */
  public static EntityReference fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, EntityReference.class);
  }

  /**
   * Convert an instance of EntityReference to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
