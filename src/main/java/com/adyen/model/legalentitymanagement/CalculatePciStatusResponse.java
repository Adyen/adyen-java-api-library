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

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * CalculatePciStatusResponse
 */
@JsonPropertyOrder({
  CalculatePciStatusResponse.JSON_PROPERTY_SIGNING_REQUIRED
})

public class CalculatePciStatusResponse {
  public static final String JSON_PROPERTY_SIGNING_REQUIRED = "signingRequired";
  private Boolean signingRequired;

  public CalculatePciStatusResponse() { 
  }

  /**
   * Indicates if the user is required to sign PCI questionnaires. If **false**, they do not need to sign any questionnaires.
   *
   * @param signingRequired
   * @return the current {@code CalculatePciStatusResponse} instance, allowing for method chaining
   */
  public CalculatePciStatusResponse signingRequired(Boolean signingRequired) {
    this.signingRequired = signingRequired;
    return this;
  }

  /**
   * Indicates if the user is required to sign PCI questionnaires. If **false**, they do not need to sign any questionnaires.
   * @return signingRequired
   */
  @ApiModelProperty(value = "Indicates if the user is required to sign PCI questionnaires. If **false**, they do not need to sign any questionnaires.")
  @JsonProperty(JSON_PROPERTY_SIGNING_REQUIRED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getSigningRequired() {
    return signingRequired;
  }

  /**
   * Indicates if the user is required to sign PCI questionnaires. If **false**, they do not need to sign any questionnaires.
   *
   * @param signingRequired
   */ 
  @JsonProperty(JSON_PROPERTY_SIGNING_REQUIRED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSigningRequired(Boolean signingRequired) {
    this.signingRequired = signingRequired;
  }

  /**
   * Return true if this CalculatePciStatusResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalculatePciStatusResponse calculatePciStatusResponse = (CalculatePciStatusResponse) o;
    return Objects.equals(this.signingRequired, calculatePciStatusResponse.signingRequired);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signingRequired);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalculatePciStatusResponse {\n");
    sb.append("    signingRequired: ").append(toIndentedString(signingRequired)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

/**
   * Create an instance of CalculatePciStatusResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CalculatePciStatusResponse
   * @throws JsonProcessingException if the JSON string is invalid with respect to CalculatePciStatusResponse
   */
  public static CalculatePciStatusResponse fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, CalculatePciStatusResponse.class);
  }
/**
  * Convert an instance of CalculatePciStatusResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}