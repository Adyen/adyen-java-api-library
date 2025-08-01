/*
 * Adyen Recurring API
 *
 * The version of the OpenAPI document: 68
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.recurring;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

/** CreatePermitResult */
@JsonPropertyOrder({
  CreatePermitResult.JSON_PROPERTY_PERMIT_RESULT_LIST,
  CreatePermitResult.JSON_PROPERTY_PSP_REFERENCE
})
public class CreatePermitResult {
  public static final String JSON_PROPERTY_PERMIT_RESULT_LIST = "permitResultList";
  private List<PermitResult> permitResultList;

  public static final String JSON_PROPERTY_PSP_REFERENCE = "pspReference";
  private String pspReference;

  public CreatePermitResult() {}

  /**
   * List of new permits.
   *
   * @param permitResultList List of new permits.
   * @return the current {@code CreatePermitResult} instance, allowing for method chaining
   */
  public CreatePermitResult permitResultList(List<PermitResult> permitResultList) {
    this.permitResultList = permitResultList;
    return this;
  }

  public CreatePermitResult addPermitResultListItem(PermitResult permitResultListItem) {
    if (this.permitResultList == null) {
      this.permitResultList = new ArrayList<>();
    }
    this.permitResultList.add(permitResultListItem);
    return this;
  }

  /**
   * List of new permits.
   *
   * @return permitResultList List of new permits.
   */
  @JsonProperty(JSON_PROPERTY_PERMIT_RESULT_LIST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<PermitResult> getPermitResultList() {
    return permitResultList;
  }

  /**
   * List of new permits.
   *
   * @param permitResultList List of new permits.
   */
  @JsonProperty(JSON_PROPERTY_PERMIT_RESULT_LIST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPermitResultList(List<PermitResult> permitResultList) {
    this.permitResultList = permitResultList;
  }

  /**
   * A unique reference associated with the request. This value is globally unique; quote it when
   * communicating with us about this request.
   *
   * @param pspReference A unique reference associated with the request. This value is globally
   *     unique; quote it when communicating with us about this request.
   * @return the current {@code CreatePermitResult} instance, allowing for method chaining
   */
  public CreatePermitResult pspReference(String pspReference) {
    this.pspReference = pspReference;
    return this;
  }

  /**
   * A unique reference associated with the request. This value is globally unique; quote it when
   * communicating with us about this request.
   *
   * @return pspReference A unique reference associated with the request. This value is globally
   *     unique; quote it when communicating with us about this request.
   */
  @JsonProperty(JSON_PROPERTY_PSP_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPspReference() {
    return pspReference;
  }

  /**
   * A unique reference associated with the request. This value is globally unique; quote it when
   * communicating with us about this request.
   *
   * @param pspReference A unique reference associated with the request. This value is globally
   *     unique; quote it when communicating with us about this request.
   */
  @JsonProperty(JSON_PROPERTY_PSP_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPspReference(String pspReference) {
    this.pspReference = pspReference;
  }

  /** Return true if this CreatePermitResult object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreatePermitResult createPermitResult = (CreatePermitResult) o;
    return Objects.equals(this.permitResultList, createPermitResult.permitResultList)
        && Objects.equals(this.pspReference, createPermitResult.pspReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(permitResultList, pspReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreatePermitResult {\n");
    sb.append("    permitResultList: ").append(toIndentedString(permitResultList)).append("\n");
    sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
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
   * Create an instance of CreatePermitResult given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CreatePermitResult
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     CreatePermitResult
   */
  public static CreatePermitResult fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, CreatePermitResult.class);
  }

  /**
   * Convert an instance of CreatePermitResult to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
