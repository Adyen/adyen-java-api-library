/*
 * Adyen Payout API
 *
 * The version of the OpenAPI document: 68
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.payout;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** Card */
@JsonPropertyOrder({
  Card.JSON_PROPERTY_CVC,
  Card.JSON_PROPERTY_EXPIRY_MONTH,
  Card.JSON_PROPERTY_EXPIRY_YEAR,
  Card.JSON_PROPERTY_HOLDER_NAME,
  Card.JSON_PROPERTY_ISSUE_NUMBER,
  Card.JSON_PROPERTY_NUMBER,
  Card.JSON_PROPERTY_START_MONTH,
  Card.JSON_PROPERTY_START_YEAR
})
public class Card {
  public static final String JSON_PROPERTY_CVC = "cvc";
  private String cvc;

  public static final String JSON_PROPERTY_EXPIRY_MONTH = "expiryMonth";
  private String expiryMonth;

  public static final String JSON_PROPERTY_EXPIRY_YEAR = "expiryYear";
  private String expiryYear;

  public static final String JSON_PROPERTY_HOLDER_NAME = "holderName";
  private String holderName;

  public static final String JSON_PROPERTY_ISSUE_NUMBER = "issueNumber";
  private String issueNumber;

  public static final String JSON_PROPERTY_NUMBER = "number";
  private String number;

  public static final String JSON_PROPERTY_START_MONTH = "startMonth";
  private String startMonth;

  public static final String JSON_PROPERTY_START_YEAR = "startYear";
  private String startYear;

  public Card() {}

  /**
   * The [card verification
   * code](https://docs.adyen.com/payments-fundamentals/payment-glossary#card-security-code-cvc-cvv-cid)
   * (1-20 characters). Depending on the card brand, it is known also as: * CVV2/CVC2 – length: 3
   * digits * CID – length: 4 digits &gt; If you are using [Client-Side
   * Encryption](https://docs.adyen.com/classic-integration/cse-integration-ecommerce), the CVC code
   * is present in the encrypted data. You must never post the card details to the server. &gt; This
   * field must be always present in a [one-click payment
   * request](https://docs.adyen.com/classic-integration/recurring-payments). &gt; When this value
   * is returned in a response, it is always empty because it is not stored.
   *
   * @param cvc The [card verification
   *     code](https://docs.adyen.com/payments-fundamentals/payment-glossary#card-security-code-cvc-cvv-cid)
   *     (1-20 characters). Depending on the card brand, it is known also as: * CVV2/CVC2 – length:
   *     3 digits * CID – length: 4 digits &gt; If you are using [Client-Side
   *     Encryption](https://docs.adyen.com/classic-integration/cse-integration-ecommerce), the CVC
   *     code is present in the encrypted data. You must never post the card details to the server.
   *     &gt; This field must be always present in a [one-click payment
   *     request](https://docs.adyen.com/classic-integration/recurring-payments). &gt; When this
   *     value is returned in a response, it is always empty because it is not stored.
   * @return the current {@code Card} instance, allowing for method chaining
   */
  public Card cvc(String cvc) {
    this.cvc = cvc;
    return this;
  }

  /**
   * The [card verification
   * code](https://docs.adyen.com/payments-fundamentals/payment-glossary#card-security-code-cvc-cvv-cid)
   * (1-20 characters). Depending on the card brand, it is known also as: * CVV2/CVC2 – length: 3
   * digits * CID – length: 4 digits &gt; If you are using [Client-Side
   * Encryption](https://docs.adyen.com/classic-integration/cse-integration-ecommerce), the CVC code
   * is present in the encrypted data. You must never post the card details to the server. &gt; This
   * field must be always present in a [one-click payment
   * request](https://docs.adyen.com/classic-integration/recurring-payments). &gt; When this value
   * is returned in a response, it is always empty because it is not stored.
   *
   * @return cvc The [card verification
   *     code](https://docs.adyen.com/payments-fundamentals/payment-glossary#card-security-code-cvc-cvv-cid)
   *     (1-20 characters). Depending on the card brand, it is known also as: * CVV2/CVC2 – length:
   *     3 digits * CID – length: 4 digits &gt; If you are using [Client-Side
   *     Encryption](https://docs.adyen.com/classic-integration/cse-integration-ecommerce), the CVC
   *     code is present in the encrypted data. You must never post the card details to the server.
   *     &gt; This field must be always present in a [one-click payment
   *     request](https://docs.adyen.com/classic-integration/recurring-payments). &gt; When this
   *     value is returned in a response, it is always empty because it is not stored.
   */
  @JsonProperty(JSON_PROPERTY_CVC)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCvc() {
    return cvc;
  }

  /**
   * The [card verification
   * code](https://docs.adyen.com/payments-fundamentals/payment-glossary#card-security-code-cvc-cvv-cid)
   * (1-20 characters). Depending on the card brand, it is known also as: * CVV2/CVC2 – length: 3
   * digits * CID – length: 4 digits &gt; If you are using [Client-Side
   * Encryption](https://docs.adyen.com/classic-integration/cse-integration-ecommerce), the CVC code
   * is present in the encrypted data. You must never post the card details to the server. &gt; This
   * field must be always present in a [one-click payment
   * request](https://docs.adyen.com/classic-integration/recurring-payments). &gt; When this value
   * is returned in a response, it is always empty because it is not stored.
   *
   * @param cvc The [card verification
   *     code](https://docs.adyen.com/payments-fundamentals/payment-glossary#card-security-code-cvc-cvv-cid)
   *     (1-20 characters). Depending on the card brand, it is known also as: * CVV2/CVC2 – length:
   *     3 digits * CID – length: 4 digits &gt; If you are using [Client-Side
   *     Encryption](https://docs.adyen.com/classic-integration/cse-integration-ecommerce), the CVC
   *     code is present in the encrypted data. You must never post the card details to the server.
   *     &gt; This field must be always present in a [one-click payment
   *     request](https://docs.adyen.com/classic-integration/recurring-payments). &gt; When this
   *     value is returned in a response, it is always empty because it is not stored.
   */
  @JsonProperty(JSON_PROPERTY_CVC)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCvc(String cvc) {
    this.cvc = cvc;
  }

  /**
   * The card expiry month. Format: 2 digits, zero-padded for single digits. For example: * 03
   * &#x3D; March * 11 &#x3D; November
   *
   * @param expiryMonth The card expiry month. Format: 2 digits, zero-padded for single digits. For
   *     example: * 03 &#x3D; March * 11 &#x3D; November
   * @return the current {@code Card} instance, allowing for method chaining
   */
  public Card expiryMonth(String expiryMonth) {
    this.expiryMonth = expiryMonth;
    return this;
  }

  /**
   * The card expiry month. Format: 2 digits, zero-padded for single digits. For example: * 03
   * &#x3D; March * 11 &#x3D; November
   *
   * @return expiryMonth The card expiry month. Format: 2 digits, zero-padded for single digits. For
   *     example: * 03 &#x3D; March * 11 &#x3D; November
   */
  @JsonProperty(JSON_PROPERTY_EXPIRY_MONTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getExpiryMonth() {
    return expiryMonth;
  }

  /**
   * The card expiry month. Format: 2 digits, zero-padded for single digits. For example: * 03
   * &#x3D; March * 11 &#x3D; November
   *
   * @param expiryMonth The card expiry month. Format: 2 digits, zero-padded for single digits. For
   *     example: * 03 &#x3D; March * 11 &#x3D; November
   */
  @JsonProperty(JSON_PROPERTY_EXPIRY_MONTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExpiryMonth(String expiryMonth) {
    this.expiryMonth = expiryMonth;
  }

  /**
   * The card expiry year. Format: 4 digits. For example: 2020
   *
   * @param expiryYear The card expiry year. Format: 4 digits. For example: 2020
   * @return the current {@code Card} instance, allowing for method chaining
   */
  public Card expiryYear(String expiryYear) {
    this.expiryYear = expiryYear;
    return this;
  }

  /**
   * The card expiry year. Format: 4 digits. For example: 2020
   *
   * @return expiryYear The card expiry year. Format: 4 digits. For example: 2020
   */
  @JsonProperty(JSON_PROPERTY_EXPIRY_YEAR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getExpiryYear() {
    return expiryYear;
  }

  /**
   * The card expiry year. Format: 4 digits. For example: 2020
   *
   * @param expiryYear The card expiry year. Format: 4 digits. For example: 2020
   */
  @JsonProperty(JSON_PROPERTY_EXPIRY_YEAR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExpiryYear(String expiryYear) {
    this.expiryYear = expiryYear;
  }

  /**
   * The name of the cardholder, as printed on the card.
   *
   * @param holderName The name of the cardholder, as printed on the card.
   * @return the current {@code Card} instance, allowing for method chaining
   */
  public Card holderName(String holderName) {
    this.holderName = holderName;
    return this;
  }

  /**
   * The name of the cardholder, as printed on the card.
   *
   * @return holderName The name of the cardholder, as printed on the card.
   */
  @JsonProperty(JSON_PROPERTY_HOLDER_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getHolderName() {
    return holderName;
  }

  /**
   * The name of the cardholder, as printed on the card.
   *
   * @param holderName The name of the cardholder, as printed on the card.
   */
  @JsonProperty(JSON_PROPERTY_HOLDER_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }

  /**
   * The issue number of the card (for some UK debit cards only).
   *
   * @param issueNumber The issue number of the card (for some UK debit cards only).
   * @return the current {@code Card} instance, allowing for method chaining
   */
  public Card issueNumber(String issueNumber) {
    this.issueNumber = issueNumber;
    return this;
  }

  /**
   * The issue number of the card (for some UK debit cards only).
   *
   * @return issueNumber The issue number of the card (for some UK debit cards only).
   */
  @JsonProperty(JSON_PROPERTY_ISSUE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getIssueNumber() {
    return issueNumber;
  }

  /**
   * The issue number of the card (for some UK debit cards only).
   *
   * @param issueNumber The issue number of the card (for some UK debit cards only).
   */
  @JsonProperty(JSON_PROPERTY_ISSUE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIssueNumber(String issueNumber) {
    this.issueNumber = issueNumber;
  }

  /**
   * The card number (4-19 characters). Do not use any separators. When this value is returned in a
   * response, only the last 4 digits of the card number are returned.
   *
   * @param number The card number (4-19 characters). Do not use any separators. When this value is
   *     returned in a response, only the last 4 digits of the card number are returned.
   * @return the current {@code Card} instance, allowing for method chaining
   */
  public Card number(String number) {
    this.number = number;
    return this;
  }

  /**
   * The card number (4-19 characters). Do not use any separators. When this value is returned in a
   * response, only the last 4 digits of the card number are returned.
   *
   * @return number The card number (4-19 characters). Do not use any separators. When this value is
   *     returned in a response, only the last 4 digits of the card number are returned.
   */
  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getNumber() {
    return number;
  }

  /**
   * The card number (4-19 characters). Do not use any separators. When this value is returned in a
   * response, only the last 4 digits of the card number are returned.
   *
   * @param number The card number (4-19 characters). Do not use any separators. When this value is
   *     returned in a response, only the last 4 digits of the card number are returned.
   */
  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNumber(String number) {
    this.number = number;
  }

  /**
   * The month component of the start date (for some UK debit cards only).
   *
   * @param startMonth The month component of the start date (for some UK debit cards only).
   * @return the current {@code Card} instance, allowing for method chaining
   */
  public Card startMonth(String startMonth) {
    this.startMonth = startMonth;
    return this;
  }

  /**
   * The month component of the start date (for some UK debit cards only).
   *
   * @return startMonth The month component of the start date (for some UK debit cards only).
   */
  @JsonProperty(JSON_PROPERTY_START_MONTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getStartMonth() {
    return startMonth;
  }

  /**
   * The month component of the start date (for some UK debit cards only).
   *
   * @param startMonth The month component of the start date (for some UK debit cards only).
   */
  @JsonProperty(JSON_PROPERTY_START_MONTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStartMonth(String startMonth) {
    this.startMonth = startMonth;
  }

  /**
   * The year component of the start date (for some UK debit cards only).
   *
   * @param startYear The year component of the start date (for some UK debit cards only).
   * @return the current {@code Card} instance, allowing for method chaining
   */
  public Card startYear(String startYear) {
    this.startYear = startYear;
    return this;
  }

  /**
   * The year component of the start date (for some UK debit cards only).
   *
   * @return startYear The year component of the start date (for some UK debit cards only).
   */
  @JsonProperty(JSON_PROPERTY_START_YEAR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getStartYear() {
    return startYear;
  }

  /**
   * The year component of the start date (for some UK debit cards only).
   *
   * @param startYear The year component of the start date (for some UK debit cards only).
   */
  @JsonProperty(JSON_PROPERTY_START_YEAR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStartYear(String startYear) {
    this.startYear = startYear;
  }

  /** Return true if this Card object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return Objects.equals(this.cvc, card.cvc)
        && Objects.equals(this.expiryMonth, card.expiryMonth)
        && Objects.equals(this.expiryYear, card.expiryYear)
        && Objects.equals(this.holderName, card.holderName)
        && Objects.equals(this.issueNumber, card.issueNumber)
        && Objects.equals(this.number, card.number)
        && Objects.equals(this.startMonth, card.startMonth)
        && Objects.equals(this.startYear, card.startYear);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        cvc, expiryMonth, expiryYear, holderName, issueNumber, number, startMonth, startYear);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Card {\n");
    sb.append("    cvc: ").append(toIndentedString(cvc)).append("\n");
    sb.append("    expiryMonth: ").append(toIndentedString(expiryMonth)).append("\n");
    sb.append("    expiryYear: ").append(toIndentedString(expiryYear)).append("\n");
    sb.append("    holderName: ").append(toIndentedString(holderName)).append("\n");
    sb.append("    issueNumber: ").append(toIndentedString(issueNumber)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    startMonth: ").append(toIndentedString(startMonth)).append("\n");
    sb.append("    startYear: ").append(toIndentedString(startYear)).append("\n");
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
   * Create an instance of Card given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Card
   * @throws JsonProcessingException if the JSON string is invalid with respect to Card
   */
  public static Card fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, Card.class);
  }

  /**
   * Convert an instance of Card to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
