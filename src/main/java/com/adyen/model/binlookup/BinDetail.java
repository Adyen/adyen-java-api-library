/*
 * Adyen BinLookup API
 *
 * The version of the OpenAPI document: 54
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.binlookup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** BinDetail */
@JsonPropertyOrder({BinDetail.JSON_PROPERTY_ISSUER_COUNTRY})
public class BinDetail {
  public static final String JSON_PROPERTY_ISSUER_COUNTRY = "issuerCountry";
  private String issuerCountry;

  public BinDetail() {}

  /**
   * The country where the card was issued.
   *
   * @param issuerCountry The country where the card was issued.
   * @return the current {@code BinDetail} instance, allowing for method chaining
   */
  public BinDetail issuerCountry(String issuerCountry) {
    this.issuerCountry = issuerCountry;
    return this;
  }

  /**
   * The country where the card was issued.
   *
   * @return issuerCountry The country where the card was issued.
   */
  @JsonProperty(JSON_PROPERTY_ISSUER_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getIssuerCountry() {
    return issuerCountry;
  }

  /**
   * The country where the card was issued.
   *
   * @param issuerCountry The country where the card was issued.
   */
  @JsonProperty(JSON_PROPERTY_ISSUER_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIssuerCountry(String issuerCountry) {
    this.issuerCountry = issuerCountry;
  }

  /** Return true if this BinDetail object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BinDetail binDetail = (BinDetail) o;
    return Objects.equals(this.issuerCountry, binDetail.issuerCountry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issuerCountry);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BinDetail {\n");
    sb.append("    issuerCountry: ").append(toIndentedString(issuerCountry)).append("\n");
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
   * Create an instance of BinDetail given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of BinDetail
   * @throws JsonProcessingException if the JSON string is invalid with respect to BinDetail
   */
  public static BinDetail fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, BinDetail.class);
  }

  /**
   * Convert an instance of BinDetail to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
