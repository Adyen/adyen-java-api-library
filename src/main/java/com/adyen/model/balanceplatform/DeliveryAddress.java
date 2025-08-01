/*
 * Configuration API
 *
 * The version of the OpenAPI document: 2
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.balanceplatform;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** DeliveryAddress */
@JsonPropertyOrder({
  DeliveryAddress.JSON_PROPERTY_CITY,
  DeliveryAddress.JSON_PROPERTY_COUNTRY,
  DeliveryAddress.JSON_PROPERTY_LINE1,
  DeliveryAddress.JSON_PROPERTY_LINE2,
  DeliveryAddress.JSON_PROPERTY_LINE3,
  DeliveryAddress.JSON_PROPERTY_POSTAL_CODE,
  DeliveryAddress.JSON_PROPERTY_STATE_OR_PROVINCE
})
public class DeliveryAddress {
  public static final String JSON_PROPERTY_CITY = "city";
  private String city;

  public static final String JSON_PROPERTY_COUNTRY = "country";
  private String country;

  public static final String JSON_PROPERTY_LINE1 = "line1";
  private String line1;

  public static final String JSON_PROPERTY_LINE2 = "line2";
  private String line2;

  public static final String JSON_PROPERTY_LINE3 = "line3";
  private String line3;

  public static final String JSON_PROPERTY_POSTAL_CODE = "postalCode";
  private String postalCode;

  public static final String JSON_PROPERTY_STATE_OR_PROVINCE = "stateOrProvince";
  private String stateOrProvince;

  public DeliveryAddress() {}

  /**
   * The name of the city.
   *
   * @param city The name of the city.
   * @return the current {@code DeliveryAddress} instance, allowing for method chaining
   */
  public DeliveryAddress city(String city) {
    this.city = city;
    return this;
  }

  /**
   * The name of the city.
   *
   * @return city The name of the city.
   */
  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCity() {
    return city;
  }

  /**
   * The name of the city.
   *
   * @param city The name of the city.
   */
  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * The two-character ISO-3166-1 alpha-2 country code. For example, **US**. &gt;If you don&#39;t
   * know the country or are not collecting the country from the shopper, provide
   * &#x60;country&#x60; as &#x60;ZZ&#x60;.
   *
   * @param country The two-character ISO-3166-1 alpha-2 country code. For example, **US**. &gt;If
   *     you don&#39;t know the country or are not collecting the country from the shopper, provide
   *     &#x60;country&#x60; as &#x60;ZZ&#x60;.
   * @return the current {@code DeliveryAddress} instance, allowing for method chaining
   */
  public DeliveryAddress country(String country) {
    this.country = country;
    return this;
  }

  /**
   * The two-character ISO-3166-1 alpha-2 country code. For example, **US**. &gt;If you don&#39;t
   * know the country or are not collecting the country from the shopper, provide
   * &#x60;country&#x60; as &#x60;ZZ&#x60;.
   *
   * @return country The two-character ISO-3166-1 alpha-2 country code. For example, **US**. &gt;If
   *     you don&#39;t know the country or are not collecting the country from the shopper, provide
   *     &#x60;country&#x60; as &#x60;ZZ&#x60;.
   */
  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCountry() {
    return country;
  }

  /**
   * The two-character ISO-3166-1 alpha-2 country code. For example, **US**. &gt;If you don&#39;t
   * know the country or are not collecting the country from the shopper, provide
   * &#x60;country&#x60; as &#x60;ZZ&#x60;.
   *
   * @param country The two-character ISO-3166-1 alpha-2 country code. For example, **US**. &gt;If
   *     you don&#39;t know the country or are not collecting the country from the shopper, provide
   *     &#x60;country&#x60; as &#x60;ZZ&#x60;.
   */
  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * The name of the street. Do not include the number of the building. For example, if the address
   * is Simon Carmiggeltstraat 6-50, provide **Simon Carmiggeltstraat**.
   *
   * @param line1 The name of the street. Do not include the number of the building. For example, if
   *     the address is Simon Carmiggeltstraat 6-50, provide **Simon Carmiggeltstraat**.
   * @return the current {@code DeliveryAddress} instance, allowing for method chaining
   */
  public DeliveryAddress line1(String line1) {
    this.line1 = line1;
    return this;
  }

  /**
   * The name of the street. Do not include the number of the building. For example, if the address
   * is Simon Carmiggeltstraat 6-50, provide **Simon Carmiggeltstraat**.
   *
   * @return line1 The name of the street. Do not include the number of the building. For example,
   *     if the address is Simon Carmiggeltstraat 6-50, provide **Simon Carmiggeltstraat**.
   */
  @JsonProperty(JSON_PROPERTY_LINE1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getLine1() {
    return line1;
  }

  /**
   * The name of the street. Do not include the number of the building. For example, if the address
   * is Simon Carmiggeltstraat 6-50, provide **Simon Carmiggeltstraat**.
   *
   * @param line1 The name of the street. Do not include the number of the building. For example, if
   *     the address is Simon Carmiggeltstraat 6-50, provide **Simon Carmiggeltstraat**.
   */
  @JsonProperty(JSON_PROPERTY_LINE1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLine1(String line1) {
    this.line1 = line1;
  }

  /**
   * The number of the building. For example, if the address is Simon Carmiggeltstraat 6-50, provide
   * **6-50**.
   *
   * @param line2 The number of the building. For example, if the address is Simon Carmiggeltstraat
   *     6-50, provide **6-50**.
   * @return the current {@code DeliveryAddress} instance, allowing for method chaining
   */
  public DeliveryAddress line2(String line2) {
    this.line2 = line2;
    return this;
  }

  /**
   * The number of the building. For example, if the address is Simon Carmiggeltstraat 6-50, provide
   * **6-50**.
   *
   * @return line2 The number of the building. For example, if the address is Simon Carmiggeltstraat
   *     6-50, provide **6-50**.
   */
  @JsonProperty(JSON_PROPERTY_LINE2)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getLine2() {
    return line2;
  }

  /**
   * The number of the building. For example, if the address is Simon Carmiggeltstraat 6-50, provide
   * **6-50**.
   *
   * @param line2 The number of the building. For example, if the address is Simon Carmiggeltstraat
   *     6-50, provide **6-50**.
   */
  @JsonProperty(JSON_PROPERTY_LINE2)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLine2(String line2) {
    this.line2 = line2;
  }

  /**
   * Additional information about the delivery address.
   *
   * @param line3 Additional information about the delivery address.
   * @return the current {@code DeliveryAddress} instance, allowing for method chaining
   */
  public DeliveryAddress line3(String line3) {
    this.line3 = line3;
    return this;
  }

  /**
   * Additional information about the delivery address.
   *
   * @return line3 Additional information about the delivery address.
   */
  @JsonProperty(JSON_PROPERTY_LINE3)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getLine3() {
    return line3;
  }

  /**
   * Additional information about the delivery address.
   *
   * @param line3 Additional information about the delivery address.
   */
  @JsonProperty(JSON_PROPERTY_LINE3)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLine3(String line3) {
    this.line3 = line3;
  }

  /**
   * The postal code. Maximum length: * 5 digits for an address in the US. * 10 characters for an
   * address in all other countries.
   *
   * @param postalCode The postal code. Maximum length: * 5 digits for an address in the US. * 10
   *     characters for an address in all other countries.
   * @return the current {@code DeliveryAddress} instance, allowing for method chaining
   */
  public DeliveryAddress postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * The postal code. Maximum length: * 5 digits for an address in the US. * 10 characters for an
   * address in all other countries.
   *
   * @return postalCode The postal code. Maximum length: * 5 digits for an address in the US. * 10
   *     characters for an address in all other countries.
   */
  @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPostalCode() {
    return postalCode;
  }

  /**
   * The postal code. Maximum length: * 5 digits for an address in the US. * 10 characters for an
   * address in all other countries.
   *
   * @param postalCode The postal code. Maximum length: * 5 digits for an address in the US. * 10
   *     characters for an address in all other countries.
   */
  @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  /**
   * The two-letter ISO 3166-2 state or province code. For example, **CA** in the US or **ON** in
   * Canada. &gt; Required for the US and Canada.
   *
   * @param stateOrProvince The two-letter ISO 3166-2 state or province code. For example, **CA** in
   *     the US or **ON** in Canada. &gt; Required for the US and Canada.
   * @return the current {@code DeliveryAddress} instance, allowing for method chaining
   */
  public DeliveryAddress stateOrProvince(String stateOrProvince) {
    this.stateOrProvince = stateOrProvince;
    return this;
  }

  /**
   * The two-letter ISO 3166-2 state or province code. For example, **CA** in the US or **ON** in
   * Canada. &gt; Required for the US and Canada.
   *
   * @return stateOrProvince The two-letter ISO 3166-2 state or province code. For example, **CA**
   *     in the US or **ON** in Canada. &gt; Required for the US and Canada.
   */
  @JsonProperty(JSON_PROPERTY_STATE_OR_PROVINCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getStateOrProvince() {
    return stateOrProvince;
  }

  /**
   * The two-letter ISO 3166-2 state or province code. For example, **CA** in the US or **ON** in
   * Canada. &gt; Required for the US and Canada.
   *
   * @param stateOrProvince The two-letter ISO 3166-2 state or province code. For example, **CA** in
   *     the US or **ON** in Canada. &gt; Required for the US and Canada.
   */
  @JsonProperty(JSON_PROPERTY_STATE_OR_PROVINCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStateOrProvince(String stateOrProvince) {
    this.stateOrProvince = stateOrProvince;
  }

  /** Return true if this DeliveryAddress object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeliveryAddress deliveryAddress = (DeliveryAddress) o;
    return Objects.equals(this.city, deliveryAddress.city)
        && Objects.equals(this.country, deliveryAddress.country)
        && Objects.equals(this.line1, deliveryAddress.line1)
        && Objects.equals(this.line2, deliveryAddress.line2)
        && Objects.equals(this.line3, deliveryAddress.line3)
        && Objects.equals(this.postalCode, deliveryAddress.postalCode)
        && Objects.equals(this.stateOrProvince, deliveryAddress.stateOrProvince);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, country, line1, line2, line3, postalCode, stateOrProvince);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeliveryAddress {\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    line1: ").append(toIndentedString(line1)).append("\n");
    sb.append("    line2: ").append(toIndentedString(line2)).append("\n");
    sb.append("    line3: ").append(toIndentedString(line3)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    stateOrProvince: ").append(toIndentedString(stateOrProvince)).append("\n");
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
   * Create an instance of DeliveryAddress given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of DeliveryAddress
   * @throws JsonProcessingException if the JSON string is invalid with respect to DeliveryAddress
   */
  public static DeliveryAddress fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, DeliveryAddress.class);
  }

  /**
   * Convert an instance of DeliveryAddress to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
