package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Content of the Loyalty Request message. */
@JsonPropertyOrder({"SaleData", "LoyaltyTransaction", "LoyaltyData"})
public class LoyaltyRequest {

  @JsonProperty("SaleData")
  @Schema(description = "Data related to the Sale System.")
  protected SaleData saleData;

  @JsonProperty("LoyaltyTransaction")
  @Schema(description = "Data related to the loyalty transaction.")
  protected LoyaltyTransaction loyaltyTransaction;

  @JsonProperty("LoyaltyData")
  @Schema(description = "Data related to a Loyalty program or account.")
  protected List<LoyaltyData> loyaltyData;

  /**
   * Gets sale data.
   *
   * @return the sale data
   */
  public SaleData getSaleData() {
    return saleData;
  }

  /**
   * Sets sale data.
   *
   * @param saleData the sale data
   */
  public void setSaleData(SaleData saleData) {
    this.saleData = saleData;
  }

  /**
   * Gets loyalty transaction.
   *
   * @return the loyalty transaction
   */
  public LoyaltyTransaction getLoyaltyTransaction() {
    return loyaltyTransaction;
  }

  /**
   * Sets loyalty transaction.
   *
   * @param loyaltyTransaction the loyalty transaction
   */
  public void setLoyaltyTransaction(LoyaltyTransaction loyaltyTransaction) {
    this.loyaltyTransaction = loyaltyTransaction;
  }

  /**
   * Gets loyalty data.
   *
   * @return the loyalty data
   */
  public List<LoyaltyData> getLoyaltyData() {
    if (loyaltyData == null) {
      loyaltyData = new ArrayList<>();
    }
    return this.loyaltyData;
  }

  /**
   * Sets loyalty data.
   *
   * @param loyaltyData the loyalty data
   */
  public void setLoyaltyData(List<LoyaltyData> loyaltyData) {
    this.loyaltyData = loyaltyData;
  }
}
