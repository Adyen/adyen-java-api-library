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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** MinorUnitsMonetaryValue */
@JsonPropertyOrder({
  MinorUnitsMonetaryValue.JSON_PROPERTY_AMOUNT,
  MinorUnitsMonetaryValue.JSON_PROPERTY_CURRENCY_CODE
})
public class MinorUnitsMonetaryValue {
  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private Integer amount;

  public static final String JSON_PROPERTY_CURRENCY_CODE = "currencyCode";
  private String currencyCode;

  public MinorUnitsMonetaryValue() {}

  /**
   * The transaction amount, in [minor
   * units](https://docs.adyen.com/development-resources/currency-codes).
   *
   * @param amount The transaction amount, in [minor
   *     units](https://docs.adyen.com/development-resources/currency-codes).
   * @return the current {@code MinorUnitsMonetaryValue} instance, allowing for method chaining
   */
  public MinorUnitsMonetaryValue amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * The transaction amount, in [minor
   * units](https://docs.adyen.com/development-resources/currency-codes).
   *
   * @return amount The transaction amount, in [minor
   *     units](https://docs.adyen.com/development-resources/currency-codes).
   */
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getAmount() {
    return amount;
  }

  /**
   * The transaction amount, in [minor
   * units](https://docs.adyen.com/development-resources/currency-codes).
   *
   * @param amount The transaction amount, in [minor
   *     units](https://docs.adyen.com/development-resources/currency-codes).
   */
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  /**
   * The three-character [ISO currency
   * code](https://docs.adyen.com/development-resources/currency-codes).
   *
   * @param currencyCode The three-character [ISO currency
   *     code](https://docs.adyen.com/development-resources/currency-codes).
   * @return the current {@code MinorUnitsMonetaryValue} instance, allowing for method chaining
   */
  public MinorUnitsMonetaryValue currencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

  /**
   * The three-character [ISO currency
   * code](https://docs.adyen.com/development-resources/currency-codes).
   *
   * @return currencyCode The three-character [ISO currency
   *     code](https://docs.adyen.com/development-resources/currency-codes).
   */
  @JsonProperty(JSON_PROPERTY_CURRENCY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCurrencyCode() {
    return currencyCode;
  }

  /**
   * The three-character [ISO currency
   * code](https://docs.adyen.com/development-resources/currency-codes).
   *
   * @param currencyCode The three-character [ISO currency
   *     code](https://docs.adyen.com/development-resources/currency-codes).
   */
  @JsonProperty(JSON_PROPERTY_CURRENCY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  /** Return true if this MinorUnitsMonetaryValue object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MinorUnitsMonetaryValue minorUnitsMonetaryValue = (MinorUnitsMonetaryValue) o;
    return Objects.equals(this.amount, minorUnitsMonetaryValue.amount)
        && Objects.equals(this.currencyCode, minorUnitsMonetaryValue.currencyCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currencyCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MinorUnitsMonetaryValue {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
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
   * Create an instance of MinorUnitsMonetaryValue given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of MinorUnitsMonetaryValue
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     MinorUnitsMonetaryValue
   */
  public static MinorUnitsMonetaryValue fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, MinorUnitsMonetaryValue.class);
  }

  /**
   * Convert an instance of MinorUnitsMonetaryValue to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
