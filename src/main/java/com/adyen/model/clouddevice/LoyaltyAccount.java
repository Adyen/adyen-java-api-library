package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Data related to a loyalty account processed in the transaction. */
@JsonPropertyOrder({"LoyaltyAccountID", "LoyaltyBrand"})
public class LoyaltyAccount {

  @JsonProperty("LoyaltyAccountID")
  @Schema(description = "Identification of a Loyalty account.")
  protected LoyaltyAccountID loyaltyAccountID;

  @JsonProperty("LoyaltyBrand")
  @Schema(description = "Identification of a Loyalty brand. --Rule: If a card is analysed")
  protected String loyaltyBrand;

  /**
   * Gets loyalty account id.
   *
   * @return the loyalty account id
   */
  public LoyaltyAccountID getLoyaltyAccountID() {
    return loyaltyAccountID;
  }

  /**
   * Sets loyalty account id.
   *
   * @param loyaltyAccountID the loyalty account id
   */
  public void setLoyaltyAccountID(LoyaltyAccountID loyaltyAccountID) {
    this.loyaltyAccountID = loyaltyAccountID;
  }

  /**
   * Gets loyalty brand.
   *
   * @return the loyalty brand
   */
  public String getLoyaltyBrand() {
    return loyaltyBrand;
  }

  /**
   * Sets loyalty brand.
   *
   * @param loyaltyBrand the loyalty brand
   */
  public void setLoyaltyBrand(String loyaltyBrand) {
    this.loyaltyBrand = loyaltyBrand;
  }
}
