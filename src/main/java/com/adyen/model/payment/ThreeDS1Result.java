/*
 * Adyen Payment API
 *
 * The version of the OpenAPI document: 68
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** ThreeDS1Result */
@JsonPropertyOrder({
  ThreeDS1Result.JSON_PROPERTY_CAVV,
  ThreeDS1Result.JSON_PROPERTY_CAVV_ALGORITHM,
  ThreeDS1Result.JSON_PROPERTY_ECI,
  ThreeDS1Result.JSON_PROPERTY_THREE_D_AUTHENTICATED_RESPONSE,
  ThreeDS1Result.JSON_PROPERTY_THREE_D_OFFERED_RESPONSE,
  ThreeDS1Result.JSON_PROPERTY_XID
})
public class ThreeDS1Result {
  public static final String JSON_PROPERTY_CAVV = "cavv";
  private String cavv;

  public static final String JSON_PROPERTY_CAVV_ALGORITHM = "cavvAlgorithm";
  private String cavvAlgorithm;

  public static final String JSON_PROPERTY_ECI = "eci";
  private String eci;

  public static final String JSON_PROPERTY_THREE_D_AUTHENTICATED_RESPONSE =
      "threeDAuthenticatedResponse";
  private String threeDAuthenticatedResponse;

  public static final String JSON_PROPERTY_THREE_D_OFFERED_RESPONSE = "threeDOfferedResponse";
  private String threeDOfferedResponse;

  public static final String JSON_PROPERTY_XID = "xid";
  private String xid;

  public ThreeDS1Result() {}

  /**
   * The cardholder authentication value (base64 encoded).
   *
   * @param cavv The cardholder authentication value (base64 encoded).
   * @return the current {@code ThreeDS1Result} instance, allowing for method chaining
   */
  public ThreeDS1Result cavv(String cavv) {
    this.cavv = cavv;
    return this;
  }

  /**
   * The cardholder authentication value (base64 encoded).
   *
   * @return cavv The cardholder authentication value (base64 encoded).
   */
  @JsonProperty(JSON_PROPERTY_CAVV)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCavv() {
    return cavv;
  }

  /**
   * The cardholder authentication value (base64 encoded).
   *
   * @param cavv The cardholder authentication value (base64 encoded).
   */
  @JsonProperty(JSON_PROPERTY_CAVV)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCavv(String cavv) {
    this.cavv = cavv;
  }

  /**
   * The CAVV algorithm used.
   *
   * @param cavvAlgorithm The CAVV algorithm used.
   * @return the current {@code ThreeDS1Result} instance, allowing for method chaining
   */
  public ThreeDS1Result cavvAlgorithm(String cavvAlgorithm) {
    this.cavvAlgorithm = cavvAlgorithm;
    return this;
  }

  /**
   * The CAVV algorithm used.
   *
   * @return cavvAlgorithm The CAVV algorithm used.
   */
  @JsonProperty(JSON_PROPERTY_CAVV_ALGORITHM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCavvAlgorithm() {
    return cavvAlgorithm;
  }

  /**
   * The CAVV algorithm used.
   *
   * @param cavvAlgorithm The CAVV algorithm used.
   */
  @JsonProperty(JSON_PROPERTY_CAVV_ALGORITHM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCavvAlgorithm(String cavvAlgorithm) {
    this.cavvAlgorithm = cavvAlgorithm;
  }

  /**
   * 3D Secure Electronic Commerce Indicator (ECI).
   *
   * @param eci 3D Secure Electronic Commerce Indicator (ECI).
   * @return the current {@code ThreeDS1Result} instance, allowing for method chaining
   */
  public ThreeDS1Result eci(String eci) {
    this.eci = eci;
    return this;
  }

  /**
   * 3D Secure Electronic Commerce Indicator (ECI).
   *
   * @return eci 3D Secure Electronic Commerce Indicator (ECI).
   */
  @JsonProperty(JSON_PROPERTY_ECI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getEci() {
    return eci;
  }

  /**
   * 3D Secure Electronic Commerce Indicator (ECI).
   *
   * @param eci 3D Secure Electronic Commerce Indicator (ECI).
   */
  @JsonProperty(JSON_PROPERTY_ECI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEci(String eci) {
    this.eci = eci;
  }

  /**
   * The authentication response from the ACS.
   *
   * @param threeDAuthenticatedResponse The authentication response from the ACS.
   * @return the current {@code ThreeDS1Result} instance, allowing for method chaining
   */
  public ThreeDS1Result threeDAuthenticatedResponse(String threeDAuthenticatedResponse) {
    this.threeDAuthenticatedResponse = threeDAuthenticatedResponse;
    return this;
  }

  /**
   * The authentication response from the ACS.
   *
   * @return threeDAuthenticatedResponse The authentication response from the ACS.
   */
  @JsonProperty(JSON_PROPERTY_THREE_D_AUTHENTICATED_RESPONSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getThreeDAuthenticatedResponse() {
    return threeDAuthenticatedResponse;
  }

  /**
   * The authentication response from the ACS.
   *
   * @param threeDAuthenticatedResponse The authentication response from the ACS.
   */
  @JsonProperty(JSON_PROPERTY_THREE_D_AUTHENTICATED_RESPONSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setThreeDAuthenticatedResponse(String threeDAuthenticatedResponse) {
    this.threeDAuthenticatedResponse = threeDAuthenticatedResponse;
  }

  /**
   * Whether 3D Secure was offered or not.
   *
   * @param threeDOfferedResponse Whether 3D Secure was offered or not.
   * @return the current {@code ThreeDS1Result} instance, allowing for method chaining
   */
  public ThreeDS1Result threeDOfferedResponse(String threeDOfferedResponse) {
    this.threeDOfferedResponse = threeDOfferedResponse;
    return this;
  }

  /**
   * Whether 3D Secure was offered or not.
   *
   * @return threeDOfferedResponse Whether 3D Secure was offered or not.
   */
  @JsonProperty(JSON_PROPERTY_THREE_D_OFFERED_RESPONSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getThreeDOfferedResponse() {
    return threeDOfferedResponse;
  }

  /**
   * Whether 3D Secure was offered or not.
   *
   * @param threeDOfferedResponse Whether 3D Secure was offered or not.
   */
  @JsonProperty(JSON_PROPERTY_THREE_D_OFFERED_RESPONSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setThreeDOfferedResponse(String threeDOfferedResponse) {
    this.threeDOfferedResponse = threeDOfferedResponse;
  }

  /**
   * A unique transaction identifier generated by the MPI on behalf of the merchant to identify the
   * 3D Secure transaction, in &#x60;Base64&#x60; encoding.
   *
   * @param xid A unique transaction identifier generated by the MPI on behalf of the merchant to
   *     identify the 3D Secure transaction, in &#x60;Base64&#x60; encoding.
   * @return the current {@code ThreeDS1Result} instance, allowing for method chaining
   */
  public ThreeDS1Result xid(String xid) {
    this.xid = xid;
    return this;
  }

  /**
   * A unique transaction identifier generated by the MPI on behalf of the merchant to identify the
   * 3D Secure transaction, in &#x60;Base64&#x60; encoding.
   *
   * @return xid A unique transaction identifier generated by the MPI on behalf of the merchant to
   *     identify the 3D Secure transaction, in &#x60;Base64&#x60; encoding.
   */
  @JsonProperty(JSON_PROPERTY_XID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getXid() {
    return xid;
  }

  /**
   * A unique transaction identifier generated by the MPI on behalf of the merchant to identify the
   * 3D Secure transaction, in &#x60;Base64&#x60; encoding.
   *
   * @param xid A unique transaction identifier generated by the MPI on behalf of the merchant to
   *     identify the 3D Secure transaction, in &#x60;Base64&#x60; encoding.
   */
  @JsonProperty(JSON_PROPERTY_XID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setXid(String xid) {
    this.xid = xid;
  }

  /** Return true if this ThreeDS1Result object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ThreeDS1Result threeDS1Result = (ThreeDS1Result) o;
    return Objects.equals(this.cavv, threeDS1Result.cavv)
        && Objects.equals(this.cavvAlgorithm, threeDS1Result.cavvAlgorithm)
        && Objects.equals(this.eci, threeDS1Result.eci)
        && Objects.equals(
            this.threeDAuthenticatedResponse, threeDS1Result.threeDAuthenticatedResponse)
        && Objects.equals(this.threeDOfferedResponse, threeDS1Result.threeDOfferedResponse)
        && Objects.equals(this.xid, threeDS1Result.xid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        cavv, cavvAlgorithm, eci, threeDAuthenticatedResponse, threeDOfferedResponse, xid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ThreeDS1Result {\n");
    sb.append("    cavv: ").append(toIndentedString(cavv)).append("\n");
    sb.append("    cavvAlgorithm: ").append(toIndentedString(cavvAlgorithm)).append("\n");
    sb.append("    eci: ").append(toIndentedString(eci)).append("\n");
    sb.append("    threeDAuthenticatedResponse: ")
        .append(toIndentedString(threeDAuthenticatedResponse))
        .append("\n");
    sb.append("    threeDOfferedResponse: ")
        .append(toIndentedString(threeDOfferedResponse))
        .append("\n");
    sb.append("    xid: ").append(toIndentedString(xid)).append("\n");
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
   * Create an instance of ThreeDS1Result given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ThreeDS1Result
   * @throws JsonProcessingException if the JSON string is invalid with respect to ThreeDS1Result
   */
  public static ThreeDS1Result fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, ThreeDS1Result.class);
  }

  /**
   * Convert an instance of ThreeDS1Result to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
