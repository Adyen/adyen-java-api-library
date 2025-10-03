package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

/** Content of the Reversal Request message. */
@JsonPropertyOrder({
  "OriginalPOITransaction",
  "CustomerOrderID",
  "SaleReferenceID",
  "ReversalReason",
  "ReversedAmount",
  "SaleData"
})
public class ReversalRequest {

  @JsonProperty("OriginalPOITransaction")
  @Schema(description = "Identification of a previous POI transaction.")
  protected OriginalPOITransaction originalPOITransaction;

  @JsonProperty("CustomerOrderID")
  @Schema(description = "If the reversal is performed inside a customer order.")
  protected CustomerOrder customerOrderID;

  @JsonProperty("SaleReferenceID")
  @Schema(
      description =
          "Identification of a Sale global transaction for a sequence of related POI transactions --Rule: If payment reservation reversal")
  protected String saleReferenceID;

  @JsonProperty("ReversalReason")
  @Schema(description = "Reason of the payment or loyalty reversal..")
  protected ReversalReasonType reversalReason;

  @JsonProperty("ReversedAmount")
  @Schema(
      description =
          "Amount of the payment or loyalty to reverse.. --Rule: ReversedAmount is implicitely the AuthorizedAmount if absent.")
  protected BigDecimal reversedAmount;

  @JsonProperty("SaleData")
  protected SaleData saleData;

  /**
   * Gets original poi transaction.
   *
   * @return the original poi transaction
   */
  public OriginalPOITransaction getOriginalPOITransaction() {
    return originalPOITransaction;
  }

  /**
   * Sets original poi transaction.
   *
   * @param originalPOITransaction the original poi transaction
   */
  public void setOriginalPOITransaction(OriginalPOITransaction originalPOITransaction) {
    this.originalPOITransaction = originalPOITransaction;
  }

  /**
   * Gets customer order id.
   *
   * @return the customer order id
   */
  public CustomerOrder getCustomerOrderID() {
    return customerOrderID;
  }

  /**
   * Sets customer order id.
   *
   * @param customerOrderID the customer order id
   */
  public void setCustomerOrderID(CustomerOrder customerOrderID) {
    this.customerOrderID = customerOrderID;
  }

  /**
   * Gets sale reference id.
   *
   * @return the sale reference id
   */
  public String getSaleReferenceID() {
    return saleReferenceID;
  }

  /**
   * Sets sale reference id.
   *
   * @param saleReferenceID the sale reference id
   */
  public void setSaleReferenceID(String saleReferenceID) {
    this.saleReferenceID = saleReferenceID;
  }

  /**
   * Gets reversal reason.
   *
   * @return the reversal reason
   */
  public ReversalReasonType getReversalReason() {
    return reversalReason;
  }

  /**
   * Sets reversal reason.
   *
   * @param reversalReason the reversal reason
   */
  public void setReversalReason(ReversalReasonType reversalReason) {
    this.reversalReason = reversalReason;
  }

  /**
   * Gets reversed amount.
   *
   * @return the reversed amount
   */
  public BigDecimal getReversedAmount() {
    return reversedAmount;
  }

  /**
   * Sets reversed amount.
   *
   * @param reversedAmount the reversed amount
   */
  public void setReversedAmount(BigDecimal reversedAmount) {
    this.reversedAmount = reversedAmount;
  }

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
}
