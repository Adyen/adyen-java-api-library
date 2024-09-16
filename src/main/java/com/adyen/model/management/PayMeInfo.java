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
 * PayMeInfo
 */
@JsonPropertyOrder({
  PayMeInfo.JSON_PROPERTY_DISPLAY_NAME,
  PayMeInfo.JSON_PROPERTY_LOGO,
  PayMeInfo.JSON_PROPERTY_SUPPORT_EMAIL
})

public class PayMeInfo {
  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  private String displayName;

  public static final String JSON_PROPERTY_LOGO = "logo";
  private String logo;

  public static final String JSON_PROPERTY_SUPPORT_EMAIL = "supportEmail";
  private String supportEmail;

  public PayMeInfo() { 
  }

  public PayMeInfo displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Merchant display name
   * @return displayName
  **/
  @ApiModelProperty(required = true, value = "Merchant display name")
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDisplayName() {
    return displayName;
  }


 /**
  * Merchant display name
  *
  * @param displayName
  */ 
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public PayMeInfo logo(String logo) {
    this.logo = logo;
    return this;
  }

   /**
   * Merchant logo. Format: Base64-encoded string.
   * @return logo
  **/
  @ApiModelProperty(required = true, value = "Merchant logo. Format: Base64-encoded string.")
  @JsonProperty(JSON_PROPERTY_LOGO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLogo() {
    return logo;
  }


 /**
  * Merchant logo. Format: Base64-encoded string.
  *
  * @param logo
  */ 
  @JsonProperty(JSON_PROPERTY_LOGO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLogo(String logo) {
    this.logo = logo;
  }


  public PayMeInfo supportEmail(String supportEmail) {
    this.supportEmail = supportEmail;
    return this;
  }

   /**
   * The email address of merchant support.
   * @return supportEmail
  **/
  @ApiModelProperty(required = true, value = "The email address of merchant support.")
  @JsonProperty(JSON_PROPERTY_SUPPORT_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSupportEmail() {
    return supportEmail;
  }


 /**
  * The email address of merchant support.
  *
  * @param supportEmail
  */ 
  @JsonProperty(JSON_PROPERTY_SUPPORT_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSupportEmail(String supportEmail) {
    this.supportEmail = supportEmail;
  }


  /**
   * Return true if this PayMeInfo object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PayMeInfo payMeInfo = (PayMeInfo) o;
    return Objects.equals(this.displayName, payMeInfo.displayName) &&
        Objects.equals(this.logo, payMeInfo.logo) &&
        Objects.equals(this.supportEmail, payMeInfo.supportEmail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, logo, supportEmail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PayMeInfo {\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    logo: ").append(toIndentedString(logo)).append("\n");
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
   * Create an instance of PayMeInfo given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PayMeInfo
   * @throws JsonProcessingException if the JSON string is invalid with respect to PayMeInfo
   */
  public static PayMeInfo fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, PayMeInfo.class);
  }
/**
  * Convert an instance of PayMeInfo to an JSON string
  *
  * @return JSON string
  */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
