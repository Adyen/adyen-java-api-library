package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Data related to a Loyalty program or account. */
@JsonPropertyOrder({"CardAcquisitionReference", "LoyaltyAccountID", "LoyaltyAmount"})
public class LoyaltyData {

  @JsonProperty("CardAcquisitionReference")
  @Schema(
      description =
          "Reference to the last CardAcquisition, to use the same card. --Rule: If the loyalty account ID comes from a previous CardAcquisition")
  protected TransactionIdentification cardAcquisitionReference;

  @JsonProperty("LoyaltyAccountID")
  @Schema(
      description =
          "Identification of a Loyalty account. --Rule: If loyalty identification of the loyalty account is realised by the Sale System")
  protected LoyaltyAccountID loyaltyAccountID;

  @JsonProperty("LoyaltyAmount")
  @Schema(
      description =
          "Amount of a loyalty account. --Rule: When the Sale System want to award the Loyalty account  (not for BalanceInquiryRequest)")
  protected LoyaltyAmount loyaltyAmount;

  /**
   * Gets card acquisition reference.
   *
   * @return the card acquisition reference
   */
  public TransactionIdentification getCardAcquisitionReference() {
    return cardAcquisitionReference;
  }

  /**
   * Sets card acquisition reference.
   *
   * @param cardAcquisitionReference the card acquisition reference
   */
  public void setCardAcquisitionReference(TransactionIdentification cardAcquisitionReference) {
    this.cardAcquisitionReference = cardAcquisitionReference;
  }

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
   * Gets loyalty amount.
   *
   * @return the loyalty amount
   */
  public LoyaltyAmount getLoyaltyAmount() {
    return loyaltyAmount;
  }

  /**
   * Sets loyalty amount.
   *
   * @param loyaltyAmount the loyalty amount
   */
  public void setLoyaltyAmount(LoyaltyAmount loyaltyAmount) {
    this.loyaltyAmount = loyaltyAmount;
  }
}
