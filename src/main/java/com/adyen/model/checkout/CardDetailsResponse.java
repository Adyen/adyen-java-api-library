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
import java.util.ArrayList;
import java.util.List;

/** CardDetailsResponse */
@JsonPropertyOrder({
  CardDetailsResponse.JSON_PROPERTY_BRANDS,
  CardDetailsResponse.JSON_PROPERTY_FUNDING_SOURCE,
  CardDetailsResponse.JSON_PROPERTY_IS_CARD_COMMERCIAL,
  CardDetailsResponse.JSON_PROPERTY_ISSUING_COUNTRY_CODE
})
public class CardDetailsResponse {
  public static final String JSON_PROPERTY_BRANDS = "brands";
  private List<CardBrandDetails> brands;

  public static final String JSON_PROPERTY_FUNDING_SOURCE = "fundingSource";
  private String fundingSource;

  public static final String JSON_PROPERTY_IS_CARD_COMMERCIAL = "isCardCommercial";
  private Boolean isCardCommercial;

  public static final String JSON_PROPERTY_ISSUING_COUNTRY_CODE = "issuingCountryCode";
  private String issuingCountryCode;

  public CardDetailsResponse() {}

  /**
   * The list of brands identified for the card.
   *
   * @param brands The list of brands identified for the card.
   * @return the current {@code CardDetailsResponse} instance, allowing for method chaining
   */
  public CardDetailsResponse brands(List<CardBrandDetails> brands) {
    this.brands = brands;
    return this;
  }

  public CardDetailsResponse addBrandsItem(CardBrandDetails brandsItem) {
    if (this.brands == null) {
      this.brands = new ArrayList<>();
    }
    this.brands.add(brandsItem);
    return this;
  }

  /**
   * The list of brands identified for the card.
   *
   * @return brands The list of brands identified for the card.
   */
  @JsonProperty(JSON_PROPERTY_BRANDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<CardBrandDetails> getBrands() {
    return brands;
  }

  /**
   * The list of brands identified for the card.
   *
   * @param brands The list of brands identified for the card.
   */
  @JsonProperty(JSON_PROPERTY_BRANDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBrands(List<CardBrandDetails> brands) {
    this.brands = brands;
  }

  /**
   * The funding source of the card, for example **DEBIT**, **CREDIT**, or **PREPAID**.
   *
   * @param fundingSource The funding source of the card, for example **DEBIT**, **CREDIT**, or
   *     **PREPAID**.
   * @return the current {@code CardDetailsResponse} instance, allowing for method chaining
   */
  public CardDetailsResponse fundingSource(String fundingSource) {
    this.fundingSource = fundingSource;
    return this;
  }

  /**
   * The funding source of the card, for example **DEBIT**, **CREDIT**, or **PREPAID**.
   *
   * @return fundingSource The funding source of the card, for example **DEBIT**, **CREDIT**, or
   *     **PREPAID**.
   */
  @JsonProperty(JSON_PROPERTY_FUNDING_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getFundingSource() {
    return fundingSource;
  }

  /**
   * The funding source of the card, for example **DEBIT**, **CREDIT**, or **PREPAID**.
   *
   * @param fundingSource The funding source of the card, for example **DEBIT**, **CREDIT**, or
   *     **PREPAID**.
   */
  @JsonProperty(JSON_PROPERTY_FUNDING_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFundingSource(String fundingSource) {
    this.fundingSource = fundingSource;
  }

  /**
   * Indicates if this is a commercial card or a consumer card. If **true**, it is a commercial
   * card. If **false**, it is a consumer card.
   *
   * @param isCardCommercial Indicates if this is a commercial card or a consumer card. If **true**,
   *     it is a commercial card. If **false**, it is a consumer card.
   * @return the current {@code CardDetailsResponse} instance, allowing for method chaining
   */
  public CardDetailsResponse isCardCommercial(Boolean isCardCommercial) {
    this.isCardCommercial = isCardCommercial;
    return this;
  }

  /**
   * Indicates if this is a commercial card or a consumer card. If **true**, it is a commercial
   * card. If **false**, it is a consumer card.
   *
   * @return isCardCommercial Indicates if this is a commercial card or a consumer card. If
   *     **true**, it is a commercial card. If **false**, it is a consumer card.
   */
  @JsonProperty(JSON_PROPERTY_IS_CARD_COMMERCIAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getIsCardCommercial() {
    return isCardCommercial;
  }

  /**
   * Indicates if this is a commercial card or a consumer card. If **true**, it is a commercial
   * card. If **false**, it is a consumer card.
   *
   * @param isCardCommercial Indicates if this is a commercial card or a consumer card. If **true**,
   *     it is a commercial card. If **false**, it is a consumer card.
   */
  @JsonProperty(JSON_PROPERTY_IS_CARD_COMMERCIAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIsCardCommercial(Boolean isCardCommercial) {
    this.isCardCommercial = isCardCommercial;
  }

  /**
   * The two-letter country code of the country where the card was issued.
   *
   * @param issuingCountryCode The two-letter country code of the country where the card was issued.
   * @return the current {@code CardDetailsResponse} instance, allowing for method chaining
   */
  public CardDetailsResponse issuingCountryCode(String issuingCountryCode) {
    this.issuingCountryCode = issuingCountryCode;
    return this;
  }

  /**
   * The two-letter country code of the country where the card was issued.
   *
   * @return issuingCountryCode The two-letter country code of the country where the card was
   *     issued.
   */
  @JsonProperty(JSON_PROPERTY_ISSUING_COUNTRY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getIssuingCountryCode() {
    return issuingCountryCode;
  }

  /**
   * The two-letter country code of the country where the card was issued.
   *
   * @param issuingCountryCode The two-letter country code of the country where the card was issued.
   */
  @JsonProperty(JSON_PROPERTY_ISSUING_COUNTRY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIssuingCountryCode(String issuingCountryCode) {
    this.issuingCountryCode = issuingCountryCode;
  }

  /** Return true if this CardDetailsResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardDetailsResponse cardDetailsResponse = (CardDetailsResponse) o;
    return Objects.equals(this.brands, cardDetailsResponse.brands)
        && Objects.equals(this.fundingSource, cardDetailsResponse.fundingSource)
        && Objects.equals(this.isCardCommercial, cardDetailsResponse.isCardCommercial)
        && Objects.equals(this.issuingCountryCode, cardDetailsResponse.issuingCountryCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(brands, fundingSource, isCardCommercial, issuingCountryCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardDetailsResponse {\n");
    sb.append("    brands: ").append(toIndentedString(brands)).append("\n");
    sb.append("    fundingSource: ").append(toIndentedString(fundingSource)).append("\n");
    sb.append("    isCardCommercial: ").append(toIndentedString(isCardCommercial)).append("\n");
    sb.append("    issuingCountryCode: ").append(toIndentedString(issuingCountryCode)).append("\n");
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
   * Create an instance of CardDetailsResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CardDetailsResponse
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     CardDetailsResponse
   */
  public static CardDetailsResponse fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, CardDetailsResponse.class);
  }

  /**
   * Convert an instance of CardDetailsResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
