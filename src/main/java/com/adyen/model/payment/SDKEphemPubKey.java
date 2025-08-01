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

/** SDKEphemPubKey */
@JsonPropertyOrder({
  SDKEphemPubKey.JSON_PROPERTY_CRV,
  SDKEphemPubKey.JSON_PROPERTY_KTY,
  SDKEphemPubKey.JSON_PROPERTY_X,
  SDKEphemPubKey.JSON_PROPERTY_Y
})
public class SDKEphemPubKey {
  public static final String JSON_PROPERTY_CRV = "crv";
  private String crv;

  public static final String JSON_PROPERTY_KTY = "kty";
  private String kty;

  public static final String JSON_PROPERTY_X = "x";
  private String x;

  public static final String JSON_PROPERTY_Y = "y";
  private String y;

  public SDKEphemPubKey() {}

  /**
   * The &#x60;crv&#x60; value as received from the 3D Secure 2 SDK.
   *
   * @param crv The &#x60;crv&#x60; value as received from the 3D Secure 2 SDK.
   * @return the current {@code SDKEphemPubKey} instance, allowing for method chaining
   */
  public SDKEphemPubKey crv(String crv) {
    this.crv = crv;
    return this;
  }

  /**
   * The &#x60;crv&#x60; value as received from the 3D Secure 2 SDK.
   *
   * @return crv The &#x60;crv&#x60; value as received from the 3D Secure 2 SDK.
   */
  @JsonProperty(JSON_PROPERTY_CRV)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCrv() {
    return crv;
  }

  /**
   * The &#x60;crv&#x60; value as received from the 3D Secure 2 SDK.
   *
   * @param crv The &#x60;crv&#x60; value as received from the 3D Secure 2 SDK.
   */
  @JsonProperty(JSON_PROPERTY_CRV)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCrv(String crv) {
    this.crv = crv;
  }

  /**
   * The &#x60;kty&#x60; value as received from the 3D Secure 2 SDK.
   *
   * @param kty The &#x60;kty&#x60; value as received from the 3D Secure 2 SDK.
   * @return the current {@code SDKEphemPubKey} instance, allowing for method chaining
   */
  public SDKEphemPubKey kty(String kty) {
    this.kty = kty;
    return this;
  }

  /**
   * The &#x60;kty&#x60; value as received from the 3D Secure 2 SDK.
   *
   * @return kty The &#x60;kty&#x60; value as received from the 3D Secure 2 SDK.
   */
  @JsonProperty(JSON_PROPERTY_KTY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getKty() {
    return kty;
  }

  /**
   * The &#x60;kty&#x60; value as received from the 3D Secure 2 SDK.
   *
   * @param kty The &#x60;kty&#x60; value as received from the 3D Secure 2 SDK.
   */
  @JsonProperty(JSON_PROPERTY_KTY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setKty(String kty) {
    this.kty = kty;
  }

  /**
   * The &#x60;x&#x60; value as received from the 3D Secure 2 SDK.
   *
   * @param x The &#x60;x&#x60; value as received from the 3D Secure 2 SDK.
   * @return the current {@code SDKEphemPubKey} instance, allowing for method chaining
   */
  public SDKEphemPubKey x(String x) {
    this.x = x;
    return this;
  }

  /**
   * The &#x60;x&#x60; value as received from the 3D Secure 2 SDK.
   *
   * @return x The &#x60;x&#x60; value as received from the 3D Secure 2 SDK.
   */
  @JsonProperty(JSON_PROPERTY_X)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getX() {
    return x;
  }

  /**
   * The &#x60;x&#x60; value as received from the 3D Secure 2 SDK.
   *
   * @param x The &#x60;x&#x60; value as received from the 3D Secure 2 SDK.
   */
  @JsonProperty(JSON_PROPERTY_X)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setX(String x) {
    this.x = x;
  }

  /**
   * The &#x60;y&#x60; value as received from the 3D Secure 2 SDK.
   *
   * @param y The &#x60;y&#x60; value as received from the 3D Secure 2 SDK.
   * @return the current {@code SDKEphemPubKey} instance, allowing for method chaining
   */
  public SDKEphemPubKey y(String y) {
    this.y = y;
    return this;
  }

  /**
   * The &#x60;y&#x60; value as received from the 3D Secure 2 SDK.
   *
   * @return y The &#x60;y&#x60; value as received from the 3D Secure 2 SDK.
   */
  @JsonProperty(JSON_PROPERTY_Y)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getY() {
    return y;
  }

  /**
   * The &#x60;y&#x60; value as received from the 3D Secure 2 SDK.
   *
   * @param y The &#x60;y&#x60; value as received from the 3D Secure 2 SDK.
   */
  @JsonProperty(JSON_PROPERTY_Y)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setY(String y) {
    this.y = y;
  }

  /** Return true if this SDKEphemPubKey object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SDKEphemPubKey sdKEphemPubKey = (SDKEphemPubKey) o;
    return Objects.equals(this.crv, sdKEphemPubKey.crv)
        && Objects.equals(this.kty, sdKEphemPubKey.kty)
        && Objects.equals(this.x, sdKEphemPubKey.x)
        && Objects.equals(this.y, sdKEphemPubKey.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crv, kty, x, y);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SDKEphemPubKey {\n");
    sb.append("    crv: ").append(toIndentedString(crv)).append("\n");
    sb.append("    kty: ").append(toIndentedString(kty)).append("\n");
    sb.append("    x: ").append(toIndentedString(x)).append("\n");
    sb.append("    y: ").append(toIndentedString(y)).append("\n");
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
   * Create an instance of SDKEphemPubKey given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of SDKEphemPubKey
   * @throws JsonProcessingException if the JSON string is invalid with respect to SDKEphemPubKey
   */
  public static SDKEphemPubKey fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, SDKEphemPubKey.class);
  }

  /**
   * Convert an instance of SDKEphemPubKey to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
