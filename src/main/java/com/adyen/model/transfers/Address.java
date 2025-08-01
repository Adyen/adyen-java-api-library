/*
 * Transfers API
 *
 * The version of the OpenAPI document: 4
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.transfers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** Address */
@JsonPropertyOrder({
  Address.JSON_PROPERTY_CITY,
  Address.JSON_PROPERTY_COUNTRY,
  Address.JSON_PROPERTY_LINE1,
  Address.JSON_PROPERTY_LINE2,
  Address.JSON_PROPERTY_POSTAL_CODE,
  Address.JSON_PROPERTY_STATE_OR_PROVINCE
})
public class Address {
  public static final String JSON_PROPERTY_CITY = "city";
  private String city;

  public static final String JSON_PROPERTY_COUNTRY = "country";
  private String country;

  public static final String JSON_PROPERTY_LINE1 = "line1";
  private String line1;

  public static final String JSON_PROPERTY_LINE2 = "line2";
  private String line2;

  public static final String JSON_PROPERTY_POSTAL_CODE = "postalCode";
  private String postalCode;

  public static final String JSON_PROPERTY_STATE_OR_PROVINCE = "stateOrProvince";
  private String stateOrProvince;

  public Address() {}

  /**
   * The name of the city. Supported characters: **[a-z] [A-Z] [0-9] . - — / # , ’ ° ( ) : ; [ ]
   * &amp; \\ |** and Space. &gt; Required when the &#x60;category&#x60; is **card**.
   *
   * @param city The name of the city. Supported characters: **[a-z] [A-Z] [0-9] . - — / # , ’ ° ( )
   *     : ; [ ] &amp; \\ |** and Space. &gt; Required when the &#x60;category&#x60; is **card**.
   * @return the current {@code Address} instance, allowing for method chaining
   */
  public Address city(String city) {
    this.city = city;
    return this;
  }

  /**
   * The name of the city. Supported characters: **[a-z] [A-Z] [0-9] . - — / # , ’ ° ( ) : ; [ ]
   * &amp; \\ |** and Space. &gt; Required when the &#x60;category&#x60; is **card**.
   *
   * @return city The name of the city. Supported characters: **[a-z] [A-Z] [0-9] . - — / # , ’ ° (
   *     ) : ; [ ] &amp; \\ |** and Space. &gt; Required when the &#x60;category&#x60; is **card**.
   */
  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCity() {
    return city;
  }

  /**
   * The name of the city. Supported characters: **[a-z] [A-Z] [0-9] . - — / # , ’ ° ( ) : ; [ ]
   * &amp; \\ |** and Space. &gt; Required when the &#x60;category&#x60; is **card**.
   *
   * @param city The name of the city. Supported characters: **[a-z] [A-Z] [0-9] . - — / # , ’ ° ( )
   *     : ; [ ] &amp; \\ |** and Space. &gt; Required when the &#x60;category&#x60; is **card**.
   */
  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * The two-character ISO 3166-1 alpha-2 country code. For example, **US**, **NL**, or **GB**.
   *
   * @param country The two-character ISO 3166-1 alpha-2 country code. For example, **US**, **NL**,
   *     or **GB**.
   * @return the current {@code Address} instance, allowing for method chaining
   */
  public Address country(String country) {
    this.country = country;
    return this;
  }

  /**
   * The two-character ISO 3166-1 alpha-2 country code. For example, **US**, **NL**, or **GB**.
   *
   * @return country The two-character ISO 3166-1 alpha-2 country code. For example, **US**, **NL**,
   *     or **GB**.
   */
  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCountry() {
    return country;
  }

  /**
   * The two-character ISO 3166-1 alpha-2 country code. For example, **US**, **NL**, or **GB**.
   *
   * @param country The two-character ISO 3166-1 alpha-2 country code. For example, **US**, **NL**,
   *     or **GB**.
   */
  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * The first line of the street address. Supported characters: **[a-z] [A-Z] [0-9] . - — / # , ’ °
   * ( ) : ; [ ] &amp; \\ |** and Space. &gt; Required when the &#x60;category&#x60; is **card**.
   *
   * @param line1 The first line of the street address. Supported characters: **[a-z] [A-Z] [0-9] .
   *     - — / # , ’ ° ( ) : ; [ ] &amp; \\ |** and Space. &gt; Required when the
   *     &#x60;category&#x60; is **card**.
   * @return the current {@code Address} instance, allowing for method chaining
   */
  public Address line1(String line1) {
    this.line1 = line1;
    return this;
  }

  /**
   * The first line of the street address. Supported characters: **[a-z] [A-Z] [0-9] . - — / # , ’ °
   * ( ) : ; [ ] &amp; \\ |** and Space. &gt; Required when the &#x60;category&#x60; is **card**.
   *
   * @return line1 The first line of the street address. Supported characters: **[a-z] [A-Z] [0-9] .
   *     - — / # , ’ ° ( ) : ; [ ] &amp; \\ |** and Space. &gt; Required when the
   *     &#x60;category&#x60; is **card**.
   */
  @JsonProperty(JSON_PROPERTY_LINE1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getLine1() {
    return line1;
  }

  /**
   * The first line of the street address. Supported characters: **[a-z] [A-Z] [0-9] . - — / # , ’ °
   * ( ) : ; [ ] &amp; \\ |** and Space. &gt; Required when the &#x60;category&#x60; is **card**.
   *
   * @param line1 The first line of the street address. Supported characters: **[a-z] [A-Z] [0-9] .
   *     - — / # , ’ ° ( ) : ; [ ] &amp; \\ |** and Space. &gt; Required when the
   *     &#x60;category&#x60; is **card**.
   */
  @JsonProperty(JSON_PROPERTY_LINE1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLine1(String line1) {
    this.line1 = line1;
  }

  /**
   * The second line of the street address. Supported characters: **[a-z] [A-Z] [0-9] . - — / # , ’
   * ° ( ) : ; [ ] &amp; \\ |** and Space. &gt; Required when the &#x60;category&#x60; is **card**.
   *
   * @param line2 The second line of the street address. Supported characters: **[a-z] [A-Z] [0-9] .
   *     - — / # , ’ ° ( ) : ; [ ] &amp; \\ |** and Space. &gt; Required when the
   *     &#x60;category&#x60; is **card**.
   * @return the current {@code Address} instance, allowing for method chaining
   */
  public Address line2(String line2) {
    this.line2 = line2;
    return this;
  }

  /**
   * The second line of the street address. Supported characters: **[a-z] [A-Z] [0-9] . - — / # , ’
   * ° ( ) : ; [ ] &amp; \\ |** and Space. &gt; Required when the &#x60;category&#x60; is **card**.
   *
   * @return line2 The second line of the street address. Supported characters: **[a-z] [A-Z] [0-9]
   *     . - — / # , ’ ° ( ) : ; [ ] &amp; \\ |** and Space. &gt; Required when the
   *     &#x60;category&#x60; is **card**.
   */
  @JsonProperty(JSON_PROPERTY_LINE2)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getLine2() {
    return line2;
  }

  /**
   * The second line of the street address. Supported characters: **[a-z] [A-Z] [0-9] . - — / # , ’
   * ° ( ) : ; [ ] &amp; \\ |** and Space. &gt; Required when the &#x60;category&#x60; is **card**.
   *
   * @param line2 The second line of the street address. Supported characters: **[a-z] [A-Z] [0-9] .
   *     - — / # , ’ ° ( ) : ; [ ] &amp; \\ |** and Space. &gt; Required when the
   *     &#x60;category&#x60; is **card**.
   */
  @JsonProperty(JSON_PROPERTY_LINE2)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLine2(String line2) {
    this.line2 = line2;
  }

  /**
   * The postal code. Maximum length: * 5 digits for an address in the US. * 10 characters for an
   * address in all other countries. Supported characters: **[a-z] [A-Z] [0-9]** and Space. &gt;
   * Required for addresses in the US.
   *
   * @param postalCode The postal code. Maximum length: * 5 digits for an address in the US. * 10
   *     characters for an address in all other countries. Supported characters: **[a-z] [A-Z]
   *     [0-9]** and Space. &gt; Required for addresses in the US.
   * @return the current {@code Address} instance, allowing for method chaining
   */
  public Address postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * The postal code. Maximum length: * 5 digits for an address in the US. * 10 characters for an
   * address in all other countries. Supported characters: **[a-z] [A-Z] [0-9]** and Space. &gt;
   * Required for addresses in the US.
   *
   * @return postalCode The postal code. Maximum length: * 5 digits for an address in the US. * 10
   *     characters for an address in all other countries. Supported characters: **[a-z] [A-Z]
   *     [0-9]** and Space. &gt; Required for addresses in the US.
   */
  @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPostalCode() {
    return postalCode;
  }

  /**
   * The postal code. Maximum length: * 5 digits for an address in the US. * 10 characters for an
   * address in all other countries. Supported characters: **[a-z] [A-Z] [0-9]** and Space. &gt;
   * Required for addresses in the US.
   *
   * @param postalCode The postal code. Maximum length: * 5 digits for an address in the US. * 10
   *     characters for an address in all other countries. Supported characters: **[a-z] [A-Z]
   *     [0-9]** and Space. &gt; Required for addresses in the US.
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
   * @return the current {@code Address} instance, allowing for method chaining
   */
  public Address stateOrProvince(String stateOrProvince) {
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

  /** Return true if this Address object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.city, address.city)
        && Objects.equals(this.country, address.country)
        && Objects.equals(this.line1, address.line1)
        && Objects.equals(this.line2, address.line2)
        && Objects.equals(this.postalCode, address.postalCode)
        && Objects.equals(this.stateOrProvince, address.stateOrProvince);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, country, line1, line2, postalCode, stateOrProvince);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    line1: ").append(toIndentedString(line1)).append("\n");
    sb.append("    line2: ").append(toIndentedString(line2)).append("\n");
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
   * Create an instance of Address given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Address
   * @throws JsonProcessingException if the JSON string is invalid with respect to Address
   */
  public static Address fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, Address.class);
  }

  /**
   * Convert an instance of Address to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
