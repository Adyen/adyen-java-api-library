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

/** DonationCampaignsResponse */
@JsonPropertyOrder({DonationCampaignsResponse.JSON_PROPERTY_DONATION_CAMPAIGNS})
public class DonationCampaignsResponse {
  public static final String JSON_PROPERTY_DONATION_CAMPAIGNS = "donationCampaigns";
  private List<DonationCampaign> donationCampaigns;

  public DonationCampaignsResponse() {}

  /**
   * List of active donation campaigns for your merchant account.
   *
   * @param donationCampaigns List of active donation campaigns for your merchant account.
   * @return the current {@code DonationCampaignsResponse} instance, allowing for method chaining
   */
  public DonationCampaignsResponse donationCampaigns(List<DonationCampaign> donationCampaigns) {
    this.donationCampaigns = donationCampaigns;
    return this;
  }

  public DonationCampaignsResponse addDonationCampaignsItem(
      DonationCampaign donationCampaignsItem) {
    if (this.donationCampaigns == null) {
      this.donationCampaigns = new ArrayList<>();
    }
    this.donationCampaigns.add(donationCampaignsItem);
    return this;
  }

  /**
   * List of active donation campaigns for your merchant account.
   *
   * @return donationCampaigns List of active donation campaigns for your merchant account.
   */
  @JsonProperty(JSON_PROPERTY_DONATION_CAMPAIGNS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<DonationCampaign> getDonationCampaigns() {
    return donationCampaigns;
  }

  /**
   * List of active donation campaigns for your merchant account.
   *
   * @param donationCampaigns List of active donation campaigns for your merchant account.
   */
  @JsonProperty(JSON_PROPERTY_DONATION_CAMPAIGNS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDonationCampaigns(List<DonationCampaign> donationCampaigns) {
    this.donationCampaigns = donationCampaigns;
  }

  /** Return true if this DonationCampaignsResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DonationCampaignsResponse donationCampaignsResponse = (DonationCampaignsResponse) o;
    return Objects.equals(this.donationCampaigns, donationCampaignsResponse.donationCampaigns);
  }

  @Override
  public int hashCode() {
    return Objects.hash(donationCampaigns);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DonationCampaignsResponse {\n");
    sb.append("    donationCampaigns: ").append(toIndentedString(donationCampaigns)).append("\n");
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
   * Create an instance of DonationCampaignsResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of DonationCampaignsResponse
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     DonationCampaignsResponse
   */
  public static DonationCampaignsResponse fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, DonationCampaignsResponse.class);
  }

  /**
   * Convert an instance of DonationCampaignsResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
