/*
 * Account API
 * This API is used for the classic integration. If you are just starting your implementation, refer to our [new integration guide](https://docs.adyen.com/marketplaces-and-platforms) instead.  The Account API provides endpoints for managing account-related entities on your platform. These related entities include account holders, accounts, bank accounts, shareholders, and verification-related documents. The management operations include actions such as creation, retrieval, updating, and deletion of them.  For more information, refer to our [documentation](https://docs.adyen.com/marketplaces-and-platforms/classic). ## Authentication Your Adyen contact will provide your API credential and an API key. To connect to the API, add an `X-API-Key` header with the API key as the value, for example:   ``` curl -H \"Content-Type: application/json\" \\ -H \"X-API-Key: YOUR_API_KEY\" \\ ... ```  Alternatively, you can use the username and password to connect to the API using basic authentication. For example:  ``` curl -U \"ws@MarketPlace.YOUR_PLATFORM_ACCOUNT\":\"YOUR_WS_PASSWORD\" \\ -H \"Content-Type: application/json\" \\ ... ``` When going live, you need to generate new web service user credentials to access the [live endpoints](https://docs.adyen.com/development-resources/live-endpoints).  ## Versioning The Account API supports [versioning](https://docs.adyen.com/development-resources/versioning) using a version suffix in the endpoint URL. This suffix has the following format: \"vXX\", where XX is the version number.  For example: ``` https://cal-test.adyen.com/cal/services/Account/v6/createAccountHolder ```
 *
 * The version of the OpenAPI document: 6
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.marketpayaccount;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** ViasPersonalData */
@JsonPropertyOrder({
  ViasPersonalData.JSON_PROPERTY_DATE_OF_BIRTH,
  ViasPersonalData.JSON_PROPERTY_DOCUMENT_DATA,
  ViasPersonalData.JSON_PROPERTY_NATIONALITY
})
public class ViasPersonalData {
  public static final String JSON_PROPERTY_DATE_OF_BIRTH = "dateOfBirth";
  private String dateOfBirth;

  public static final String JSON_PROPERTY_DOCUMENT_DATA = "documentData";
  private List<PersonalDocumentData> documentData = null;

  public static final String JSON_PROPERTY_NATIONALITY = "nationality";
  private String nationality;

  public ViasPersonalData() {}

  public ViasPersonalData dateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * The person&#39;s date of birth, in ISO-8601 YYYY-MM-DD format. For example, **2000-01-31**.
   *
   * @return dateOfBirth
   */
  @ApiModelProperty(
      value =
          "The person's date of birth, in ISO-8601 YYYY-MM-DD format. For example, **2000-01-31**.")
  @JsonProperty(JSON_PROPERTY_DATE_OF_BIRTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDateOfBirth() {
    return dateOfBirth;
  }

  @JsonProperty(JSON_PROPERTY_DATE_OF_BIRTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public ViasPersonalData documentData(List<PersonalDocumentData> documentData) {
    this.documentData = documentData;
    return this;
  }

  public ViasPersonalData addDocumentDataItem(PersonalDocumentData documentDataItem) {
    if (this.documentData == null) {
      this.documentData = new ArrayList<>();
    }
    this.documentData.add(documentDataItem);
    return this;
  }

  /**
   * Array that contains information about the person&#39;s identification document. You can submit
   * only one entry per document type.
   *
   * @return documentData
   */
  @ApiModelProperty(
      value =
          "Array that contains information about the person's identification document. You can submit only one entry per document type.")
  @JsonProperty(JSON_PROPERTY_DOCUMENT_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<PersonalDocumentData> getDocumentData() {
    return documentData;
  }

  @JsonProperty(JSON_PROPERTY_DOCUMENT_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDocumentData(List<PersonalDocumentData> documentData) {
    this.documentData = documentData;
  }

  public ViasPersonalData nationality(String nationality) {
    this.nationality = nationality;
    return this;
  }

  /**
   * The nationality of the person represented by a two-character country code, in [ISO 3166-1
   * alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) format. For example, **NL**.
   *
   * @return nationality
   */
  @ApiModelProperty(
      value =
          "The nationality of the person represented by a two-character country code,  in [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) format. For example, **NL**. ")
  @JsonProperty(JSON_PROPERTY_NATIONALITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getNationality() {
    return nationality;
  }

  @JsonProperty(JSON_PROPERTY_NATIONALITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  /** Return true if this ViasPersonalData object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ViasPersonalData viasPersonalData = (ViasPersonalData) o;
    return Objects.equals(this.dateOfBirth, viasPersonalData.dateOfBirth)
        && Objects.equals(this.documentData, viasPersonalData.documentData)
        && Objects.equals(this.nationality, viasPersonalData.nationality);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateOfBirth, documentData, nationality);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ViasPersonalData {\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    documentData: ").append(toIndentedString(documentData)).append("\n");
    sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
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
   * Create an instance of ViasPersonalData given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ViasPersonalData
   * @throws JsonProcessingException if the JSON string is invalid with respect to ViasPersonalData
   */
  public static ViasPersonalData fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, ViasPersonalData.class);
  }

  /**
   * Convert an instance of ViasPersonalData to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
