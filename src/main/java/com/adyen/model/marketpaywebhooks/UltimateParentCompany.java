/*
 * Classic Platforms - Notifications
 *
 * The version of the OpenAPI document: 6
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.marketpaywebhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/** UltimateParentCompany */
@JsonPropertyOrder({
  UltimateParentCompany.JSON_PROPERTY_ADDRESS,
  UltimateParentCompany.JSON_PROPERTY_BUSINESS_DETAILS,
  UltimateParentCompany.JSON_PROPERTY_ULTIMATE_PARENT_COMPANY_CODE
})
public class UltimateParentCompany {
  public static final String JSON_PROPERTY_ADDRESS = "address";
  private ViasAddress address;

  public static final String JSON_PROPERTY_BUSINESS_DETAILS = "businessDetails";
  private UltimateParentCompanyBusinessDetails businessDetails;

  public static final String JSON_PROPERTY_ULTIMATE_PARENT_COMPANY_CODE =
      "ultimateParentCompanyCode";
  private String ultimateParentCompanyCode;

  public UltimateParentCompany() {}

  public UltimateParentCompany address(ViasAddress address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   *
   * @return address
   */
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ViasAddress getAddress() {
    return address;
  }

  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAddress(ViasAddress address) {
    this.address = address;
  }

  public UltimateParentCompany businessDetails(
      UltimateParentCompanyBusinessDetails businessDetails) {
    this.businessDetails = businessDetails;
    return this;
  }

  /**
   * Get businessDetails
   *
   * @return businessDetails
   */
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BUSINESS_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public UltimateParentCompanyBusinessDetails getBusinessDetails() {
    return businessDetails;
  }

  @JsonProperty(JSON_PROPERTY_BUSINESS_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBusinessDetails(UltimateParentCompanyBusinessDetails businessDetails) {
    this.businessDetails = businessDetails;
  }

  public UltimateParentCompany ultimateParentCompanyCode(String ultimateParentCompanyCode) {
    this.ultimateParentCompanyCode = ultimateParentCompanyCode;
    return this;
  }

  /**
   * Adyen-generated unique alphanumeric identifier (UUID) for the entry, returned in the response
   * when you create an ultimate parent company. Required when updating an existing entry in an
   * &#x60;/updateAccountHolder&#x60; request.
   *
   * @return ultimateParentCompanyCode
   */
  @ApiModelProperty(
      value =
          "Adyen-generated unique alphanumeric identifier (UUID) for the entry, returned in the response when you create an ultimate parent company. Required when updating an existing entry in an `/updateAccountHolder` request.")
  @JsonProperty(JSON_PROPERTY_ULTIMATE_PARENT_COMPANY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getUltimateParentCompanyCode() {
    return ultimateParentCompanyCode;
  }

  @JsonProperty(JSON_PROPERTY_ULTIMATE_PARENT_COMPANY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUltimateParentCompanyCode(String ultimateParentCompanyCode) {
    this.ultimateParentCompanyCode = ultimateParentCompanyCode;
  }

  /** Return true if this UltimateParentCompany object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UltimateParentCompany ultimateParentCompany = (UltimateParentCompany) o;
    return Objects.equals(this.address, ultimateParentCompany.address)
        && Objects.equals(this.businessDetails, ultimateParentCompany.businessDetails)
        && Objects.equals(
            this.ultimateParentCompanyCode, ultimateParentCompany.ultimateParentCompanyCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, businessDetails, ultimateParentCompanyCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UltimateParentCompany {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    businessDetails: ").append(toIndentedString(businessDetails)).append("\n");
    sb.append("    ultimateParentCompanyCode: ")
        .append(toIndentedString(ultimateParentCompanyCode))
        .append("\n");
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
   * Create an instance of UltimateParentCompany given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of UltimateParentCompany
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     UltimateParentCompany
   */
  public static UltimateParentCompany fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, UltimateParentCompany.class);
  }

  /**
   * Convert an instance of UltimateParentCompany to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
