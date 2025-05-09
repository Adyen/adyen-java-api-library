/*
 * Management API
 *
 * The version of the OpenAPI document: 3
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.adyen.model.management;

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * GiroPayInfo
 */
@JsonPropertyOrder({
  GiroPayInfo.JSON_PROPERTY_SUPPORT_EMAIL
})

public class GiroPayInfo {
  public static final String JSON_PROPERTY_SUPPORT_EMAIL = "supportEmail";
  private String supportEmail;

  public GiroPayInfo() { 
  }

  /**
   * The email address of merchant support.
   *
   * @param supportEmail The email address of merchant support.
   * @return the current {@code GiroPayInfo} instance, allowing for method chaining
   */
  public GiroPayInfo supportEmail(String supportEmail) {
    this.supportEmail = supportEmail;
    return this;
  }

  /**
   * The email address of merchant support.
   * @return supportEmail The email address of merchant support.
   */
  @JsonProperty(JSON_PROPERTY_SUPPORT_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getSupportEmail() {
    return supportEmail;
  }

  /**
   * The email address of merchant support.
   *
   * @param supportEmail The email address of merchant support.
   */
  @JsonProperty(JSON_PROPERTY_SUPPORT_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSupportEmail(String supportEmail) {
    this.supportEmail = supportEmail;
  }

  /**
   * Return true if this GiroPayInfo object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GiroPayInfo giroPayInfo = (GiroPayInfo) o;
    return Objects.equals(this.supportEmail, giroPayInfo.supportEmail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(supportEmail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GiroPayInfo {\n");
    sb.append("    supportEmail: ").append(toIndentedString(supportEmail)).append("\n");
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
   * Create an instance of GiroPayInfo given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of GiroPayInfo
   * @throws JsonProcessingException if the JSON string is invalid with respect to GiroPayInfo
   */
  public static GiroPayInfo fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, GiroPayInfo.class);
  }
/**
  * Convert an instance of GiroPayInfo to an JSON string
  *
  * @return JSON string
  */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
