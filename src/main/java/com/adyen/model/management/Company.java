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
import java.util.ArrayList;
import java.util.List;

/** Company */
@JsonPropertyOrder({
  Company.JSON_PROPERTY_LINKS,
  Company.JSON_PROPERTY_DATA_CENTERS,
  Company.JSON_PROPERTY_DESCRIPTION,
  Company.JSON_PROPERTY_ID,
  Company.JSON_PROPERTY_NAME,
  Company.JSON_PROPERTY_REFERENCE,
  Company.JSON_PROPERTY_STATUS
})
public class Company {
  public static final String JSON_PROPERTY_LINKS = "_links";
  private CompanyLinks links;

  public static final String JSON_PROPERTY_DATA_CENTERS = "dataCenters";
  private List<DataCenter> dataCenters;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_REFERENCE = "reference";
  private String reference;

  public static final String JSON_PROPERTY_STATUS = "status";
  private String status;

  public Company() {}

  /**
   * links
   *
   * @param links
   * @return the current {@code Company} instance, allowing for method chaining
   */
  public Company links(CompanyLinks links) {
    this.links = links;
    return this;
  }

  /**
   * Get links
   *
   * @return links
   */
  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public CompanyLinks getLinks() {
    return links;
  }

  /**
   * links
   *
   * @param links
   */
  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLinks(CompanyLinks links) {
    this.links = links;
  }

  /**
   * List of available data centers. Adyen has several data centers around the world.In the URL that
   * you use for making API requests, we recommend you use the live URL prefix from the data center
   * closest to your shoppers.
   *
   * @param dataCenters List of available data centers. Adyen has several data centers around the
   *     world.In the URL that you use for making API requests, we recommend you use the live URL
   *     prefix from the data center closest to your shoppers.
   * @return the current {@code Company} instance, allowing for method chaining
   */
  public Company dataCenters(List<DataCenter> dataCenters) {
    this.dataCenters = dataCenters;
    return this;
  }

  public Company addDataCentersItem(DataCenter dataCentersItem) {
    if (this.dataCenters == null) {
      this.dataCenters = new ArrayList<>();
    }
    this.dataCenters.add(dataCentersItem);
    return this;
  }

  /**
   * List of available data centers. Adyen has several data centers around the world.In the URL that
   * you use for making API requests, we recommend you use the live URL prefix from the data center
   * closest to your shoppers.
   *
   * @return dataCenters List of available data centers. Adyen has several data centers around the
   *     world.In the URL that you use for making API requests, we recommend you use the live URL
   *     prefix from the data center closest to your shoppers.
   */
  @JsonProperty(JSON_PROPERTY_DATA_CENTERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<DataCenter> getDataCenters() {
    return dataCenters;
  }

  /**
   * List of available data centers. Adyen has several data centers around the world.In the URL that
   * you use for making API requests, we recommend you use the live URL prefix from the data center
   * closest to your shoppers.
   *
   * @param dataCenters List of available data centers. Adyen has several data centers around the
   *     world.In the URL that you use for making API requests, we recommend you use the live URL
   *     prefix from the data center closest to your shoppers.
   */
  @JsonProperty(JSON_PROPERTY_DATA_CENTERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDataCenters(List<DataCenter> dataCenters) {
    this.dataCenters = dataCenters;
  }

  /**
   * Your description for the company account, maximum 300 characters
   *
   * @param description Your description for the company account, maximum 300 characters
   * @return the current {@code Company} instance, allowing for method chaining
   */
  public Company description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Your description for the company account, maximum 300 characters
   *
   * @return description Your description for the company account, maximum 300 characters
   */
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDescription() {
    return description;
  }

  /**
   * Your description for the company account, maximum 300 characters
   *
   * @param description Your description for the company account, maximum 300 characters
   */
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * The unique identifier of the company account.
   *
   * @param id The unique identifier of the company account.
   * @return the current {@code Company} instance, allowing for method chaining
   */
  public Company id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier of the company account.
   *
   * @return id The unique identifier of the company account.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getId() {
    return id;
  }

  /**
   * The unique identifier of the company account.
   *
   * @param id The unique identifier of the company account.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The legal or trading name of the company.
   *
   * @param name The legal or trading name of the company.
   * @return the current {@code Company} instance, allowing for method chaining
   */
  public Company name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The legal or trading name of the company.
   *
   * @return name The legal or trading name of the company.
   */
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getName() {
    return name;
  }

  /**
   * The legal or trading name of the company.
   *
   * @param name The legal or trading name of the company.
   */
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Your reference to the account
   *
   * @param reference Your reference to the account
   * @return the current {@code Company} instance, allowing for method chaining
   */
  public Company reference(String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * Your reference to the account
   *
   * @return reference Your reference to the account
   */
  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getReference() {
    return reference;
  }

  /**
   * Your reference to the account
   *
   * @param reference Your reference to the account
   */
  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReference(String reference) {
    this.reference = reference;
  }

  /**
   * The status of the company account. Possible values: * **Active**: Users can log in. Processing
   * and payout capabilities depend on the status of the merchant account. * **Inactive**: Users can
   * log in. Payment processing and payouts are disabled. * **Closed**: The company account is
   * closed and this cannot be reversed. Users cannot log in. Payment processing and payouts are
   * disabled.
   *
   * @param status The status of the company account. Possible values: * **Active**: Users can log
   *     in. Processing and payout capabilities depend on the status of the merchant account. *
   *     **Inactive**: Users can log in. Payment processing and payouts are disabled. * **Closed**:
   *     The company account is closed and this cannot be reversed. Users cannot log in. Payment
   *     processing and payouts are disabled.
   * @return the current {@code Company} instance, allowing for method chaining
   */
  public Company status(String status) {
    this.status = status;
    return this;
  }

  /**
   * The status of the company account. Possible values: * **Active**: Users can log in. Processing
   * and payout capabilities depend on the status of the merchant account. * **Inactive**: Users can
   * log in. Payment processing and payouts are disabled. * **Closed**: The company account is
   * closed and this cannot be reversed. Users cannot log in. Payment processing and payouts are
   * disabled.
   *
   * @return status The status of the company account. Possible values: * **Active**: Users can log
   *     in. Processing and payout capabilities depend on the status of the merchant account. *
   *     **Inactive**: Users can log in. Payment processing and payouts are disabled. * **Closed**:
   *     The company account is closed and this cannot be reversed. Users cannot log in. Payment
   *     processing and payouts are disabled.
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getStatus() {
    return status;
  }

  /**
   * The status of the company account. Possible values: * **Active**: Users can log in. Processing
   * and payout capabilities depend on the status of the merchant account. * **Inactive**: Users can
   * log in. Payment processing and payouts are disabled. * **Closed**: The company account is
   * closed and this cannot be reversed. Users cannot log in. Payment processing and payouts are
   * disabled.
   *
   * @param status The status of the company account. Possible values: * **Active**: Users can log
   *     in. Processing and payout capabilities depend on the status of the merchant account. *
   *     **Inactive**: Users can log in. Payment processing and payouts are disabled. * **Closed**:
   *     The company account is closed and this cannot be reversed. Users cannot log in. Payment
   *     processing and payouts are disabled.
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(String status) {
    this.status = status;
  }

  /** Return true if this Company object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Company company = (Company) o;
    return Objects.equals(this.links, company.links)
        && Objects.equals(this.dataCenters, company.dataCenters)
        && Objects.equals(this.description, company.description)
        && Objects.equals(this.id, company.id)
        && Objects.equals(this.name, company.name)
        && Objects.equals(this.reference, company.reference)
        && Objects.equals(this.status, company.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(links, dataCenters, description, id, name, reference, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Company {\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    dataCenters: ").append(toIndentedString(dataCenters)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
   * Create an instance of Company given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Company
   * @throws JsonProcessingException if the JSON string is invalid with respect to Company
   */
  public static Company fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, Company.class);
  }

  /**
   * Convert an instance of Company to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
