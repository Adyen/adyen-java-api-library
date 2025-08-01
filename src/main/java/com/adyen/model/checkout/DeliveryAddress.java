/*
 * Adyen Checkout API
 *
 * The version of the OpenAPI document: 71
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.checkout;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** DeliveryAddress */
@JsonPropertyOrder({
  DeliveryAddress.JSON_PROPERTY_CITY,
  DeliveryAddress.JSON_PROPERTY_COUNTRY,
  DeliveryAddress.JSON_PROPERTY_FIRST_NAME,
  DeliveryAddress.JSON_PROPERTY_HOUSE_NUMBER_OR_NAME,
  DeliveryAddress.JSON_PROPERTY_LAST_NAME,
  DeliveryAddress.JSON_PROPERTY_POSTAL_CODE,
  DeliveryAddress.JSON_PROPERTY_STATE_OR_PROVINCE,
  DeliveryAddress.JSON_PROPERTY_STREET
})
public class DeliveryAddress {
  public static final String JSON_PROPERTY_CITY = "city";
  private String city;

  public static final String JSON_PROPERTY_COUNTRY = "country";
  private String country;

  public static final String JSON_PROPERTY_FIRST_NAME = "firstName";
  private String firstName;

  public static final String JSON_PROPERTY_HOUSE_NUMBER_OR_NAME = "houseNumberOrName";
  private String houseNumberOrName;

  public static final String JSON_PROPERTY_LAST_NAME = "lastName";
  private String lastName;

  public static final String JSON_PROPERTY_POSTAL_CODE = "postalCode";
  private String postalCode;

  public static final String JSON_PROPERTY_STATE_OR_PROVINCE = "stateOrProvince";
  private String stateOrProvince;

  public static final String JSON_PROPERTY_STREET = "street";
  private String street;

  public DeliveryAddress() {}

  /**
   * The name of the city. Maximum length: 3000 characters.
   *
   * @param city The name of the city. Maximum length: 3000 characters.
   * @return the current {@code DeliveryAddress} instance, allowing for method chaining
   */
  public DeliveryAddress city(String city) {
    this.city = city;
    return this;
  }

  /**
   * The name of the city. Maximum length: 3000 characters.
   *
   * @return city The name of the city. Maximum length: 3000 characters.
   */
  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCity() {
    return city;
  }

  /**
   * The name of the city. Maximum length: 3000 characters.
   *
   * @param city The name of the city. Maximum length: 3000 characters.
   */
  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * The two-character ISO-3166-1 alpha-2 country code. For example, **US**. &gt; If you don&#39;t
   * know the country or are not collecting the country from the shopper, provide
   * &#x60;country&#x60; as &#x60;ZZ&#x60;.
   *
   * @param country The two-character ISO-3166-1 alpha-2 country code. For example, **US**. &gt; If
   *     you don&#39;t know the country or are not collecting the country from the shopper, provide
   *     &#x60;country&#x60; as &#x60;ZZ&#x60;.
   * @return the current {@code DeliveryAddress} instance, allowing for method chaining
   */
  public DeliveryAddress country(String country) {
    this.country = country;
    return this;
  }

  /**
   * The two-character ISO-3166-1 alpha-2 country code. For example, **US**. &gt; If you don&#39;t
   * know the country or are not collecting the country from the shopper, provide
   * &#x60;country&#x60; as &#x60;ZZ&#x60;.
   *
   * @return country The two-character ISO-3166-1 alpha-2 country code. For example, **US**. &gt; If
   *     you don&#39;t know the country or are not collecting the country from the shopper, provide
   *     &#x60;country&#x60; as &#x60;ZZ&#x60;.
   */
  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCountry() {
    return country;
  }

  /**
   * The two-character ISO-3166-1 alpha-2 country code. For example, **US**. &gt; If you don&#39;t
   * know the country or are not collecting the country from the shopper, provide
   * &#x60;country&#x60; as &#x60;ZZ&#x60;.
   *
   * @param country The two-character ISO-3166-1 alpha-2 country code. For example, **US**. &gt; If
   *     you don&#39;t know the country or are not collecting the country from the shopper, provide
   *     &#x60;country&#x60; as &#x60;ZZ&#x60;.
   */
  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * firstName
   *
   * @param firstName
   * @return the current {@code DeliveryAddress} instance, allowing for method chaining
   */
  public DeliveryAddress firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   *
   * @return firstName
   */
  @JsonProperty(JSON_PROPERTY_FIRST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getFirstName() {
    return firstName;
  }

  /**
   * firstName
   *
   * @param firstName
   */
  @JsonProperty(JSON_PROPERTY_FIRST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * The number or name of the house. Maximum length: 3000 characters.
   *
   * @param houseNumberOrName The number or name of the house. Maximum length: 3000 characters.
   * @return the current {@code DeliveryAddress} instance, allowing for method chaining
   */
  public DeliveryAddress houseNumberOrName(String houseNumberOrName) {
    this.houseNumberOrName = houseNumberOrName;
    return this;
  }

  /**
   * The number or name of the house. Maximum length: 3000 characters.
   *
   * @return houseNumberOrName The number or name of the house. Maximum length: 3000 characters.
   */
  @JsonProperty(JSON_PROPERTY_HOUSE_NUMBER_OR_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getHouseNumberOrName() {
    return houseNumberOrName;
  }

  /**
   * The number or name of the house. Maximum length: 3000 characters.
   *
   * @param houseNumberOrName The number or name of the house. Maximum length: 3000 characters.
   */
  @JsonProperty(JSON_PROPERTY_HOUSE_NUMBER_OR_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHouseNumberOrName(String houseNumberOrName) {
    this.houseNumberOrName = houseNumberOrName;
  }

  /**
   * lastName
   *
   * @param lastName
   * @return the current {@code DeliveryAddress} instance, allowing for method chaining
   */
  public DeliveryAddress lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   *
   * @return lastName
   */
  @JsonProperty(JSON_PROPERTY_LAST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getLastName() {
    return lastName;
  }

  /**
   * lastName
   *
   * @param lastName
   */
  @JsonProperty(JSON_PROPERTY_LAST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * A maximum of five digits for an address in the US, or a maximum of ten characters for an
   * address in all other countries.
   *
   * @param postalCode A maximum of five digits for an address in the US, or a maximum of ten
   *     characters for an address in all other countries.
   * @return the current {@code DeliveryAddress} instance, allowing for method chaining
   */
  public DeliveryAddress postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * A maximum of five digits for an address in the US, or a maximum of ten characters for an
   * address in all other countries.
   *
   * @return postalCode A maximum of five digits for an address in the US, or a maximum of ten
   *     characters for an address in all other countries.
   */
  @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPostalCode() {
    return postalCode;
  }

  /**
   * A maximum of five digits for an address in the US, or a maximum of ten characters for an
   * address in all other countries.
   *
   * @param postalCode A maximum of five digits for an address in the US, or a maximum of ten
   *     characters for an address in all other countries.
   */
  @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  /**
   * The two-character ISO 3166-2 state or province code. For example, **CA** in the US or **ON** in
   * Canada. &gt; Required for the US and Canada.
   *
   * @param stateOrProvince The two-character ISO 3166-2 state or province code. For example, **CA**
   *     in the US or **ON** in Canada. &gt; Required for the US and Canada.
   * @return the current {@code DeliveryAddress} instance, allowing for method chaining
   */
  public DeliveryAddress stateOrProvince(String stateOrProvince) {
    this.stateOrProvince = stateOrProvince;
    return this;
  }

  /**
   * The two-character ISO 3166-2 state or province code. For example, **CA** in the US or **ON** in
   * Canada. &gt; Required for the US and Canada.
   *
   * @return stateOrProvince The two-character ISO 3166-2 state or province code. For example,
   *     **CA** in the US or **ON** in Canada. &gt; Required for the US and Canada.
   */
  @JsonProperty(JSON_PROPERTY_STATE_OR_PROVINCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getStateOrProvince() {
    return stateOrProvince;
  }

  /**
   * The two-character ISO 3166-2 state or province code. For example, **CA** in the US or **ON** in
   * Canada. &gt; Required for the US and Canada.
   *
   * @param stateOrProvince The two-character ISO 3166-2 state or province code. For example, **CA**
   *     in the US or **ON** in Canada. &gt; Required for the US and Canada.
   */
  @JsonProperty(JSON_PROPERTY_STATE_OR_PROVINCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStateOrProvince(String stateOrProvince) {
    this.stateOrProvince = stateOrProvince;
  }

  /**
   * The name of the street. Maximum length: 3000 characters. &gt; The house number should not be
   * included in this field; it should be separately provided via &#x60;houseNumberOrName&#x60;.
   *
   * @param street The name of the street. Maximum length: 3000 characters. &gt; The house number
   *     should not be included in this field; it should be separately provided via
   *     &#x60;houseNumberOrName&#x60;.
   * @return the current {@code DeliveryAddress} instance, allowing for method chaining
   */
  public DeliveryAddress street(String street) {
    this.street = street;
    return this;
  }

  /**
   * The name of the street. Maximum length: 3000 characters. &gt; The house number should not be
   * included in this field; it should be separately provided via &#x60;houseNumberOrName&#x60;.
   *
   * @return street The name of the street. Maximum length: 3000 characters. &gt; The house number
   *     should not be included in this field; it should be separately provided via
   *     &#x60;houseNumberOrName&#x60;.
   */
  @JsonProperty(JSON_PROPERTY_STREET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getStreet() {
    return street;
  }

  /**
   * The name of the street. Maximum length: 3000 characters. &gt; The house number should not be
   * included in this field; it should be separately provided via &#x60;houseNumberOrName&#x60;.
   *
   * @param street The name of the street. Maximum length: 3000 characters. &gt; The house number
   *     should not be included in this field; it should be separately provided via
   *     &#x60;houseNumberOrName&#x60;.
   */
  @JsonProperty(JSON_PROPERTY_STREET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStreet(String street) {
    this.street = street;
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
        && Objects.equals(this.firstName, deliveryAddress.firstName)
        && Objects.equals(this.houseNumberOrName, deliveryAddress.houseNumberOrName)
        && Objects.equals(this.lastName, deliveryAddress.lastName)
        && Objects.equals(this.postalCode, deliveryAddress.postalCode)
        && Objects.equals(this.stateOrProvince, deliveryAddress.stateOrProvince)
        && Objects.equals(this.street, deliveryAddress.street);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        city, country, firstName, houseNumberOrName, lastName, postalCode, stateOrProvince, street);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeliveryAddress {\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    houseNumberOrName: ").append(toIndentedString(houseNumberOrName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    stateOrProvince: ").append(toIndentedString(stateOrProvince)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
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
