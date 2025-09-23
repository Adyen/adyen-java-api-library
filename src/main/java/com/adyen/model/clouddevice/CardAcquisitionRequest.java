package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Content of the Card Acquisition Request message. */
@JsonPropertyOrder({"SaleData", "CardAcquisitionTransaction"})
public class CardAcquisitionRequest {

  @JsonProperty("SaleData")
  @Schema(description = "Data related to the Sale System.")
  protected SaleData saleData;

  @JsonProperty("CardAcquisitionTransaction")
  @Schema(description = "Data related to the payment and loyalty card acquisition.")
  protected CardAcquisitionTransaction cardAcquisitionTransaction;

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
   * Gets card acquisition transaction.
   *
   * @return the card acquisition transaction
   */
  public CardAcquisitionTransaction getCardAcquisitionTransaction() {
    return cardAcquisitionTransaction;
  }

  /**
   * Sets card acquisition transaction.
   *
   * @param cardAcquisitionTransaction the card acquisition transaction
   */
  public void setCardAcquisitionTransaction(CardAcquisitionTransaction cardAcquisitionTransaction) {
    this.cardAcquisitionTransaction = cardAcquisitionTransaction;
  }
}