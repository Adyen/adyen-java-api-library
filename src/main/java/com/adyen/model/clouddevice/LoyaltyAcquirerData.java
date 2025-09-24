package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Data related to the loyalty Acquirer during a loyalty transaction. */
@JsonPropertyOrder({
  "ApprovalCode",
  "LoyaltyTransactionID",
  "LoyaltyAcquirerID",
  "HostReconciliationID"
})
public class LoyaltyAcquirerData {

  @JsonProperty("ApprovalCode")
  @Schema(
      description =
          "Code assigned to a transaction approval by the Acquirer. --Rule: If provided by the Acquirer")
  protected String approvalCode;

  @JsonProperty("LoyaltyTransactionID")
  @Schema(
      description =
          "Identification of the Transaction for the Loyalty Acquirer. --Rule: If provided by the Acquirer")
  protected TransactionIdentification loyaltyTransactionID;

  @JsonProperty("LoyaltyAcquirerID")
  @Schema(description = "Identification of the loyalty Acquirer. --Rule: If available")
  protected String loyaltyAcquirerID;

  @JsonProperty("HostReconciliationID")
  @Schema(
      description =
          "Identifier of a reconciliation period with a payment or loyalty host. --Rule: If provided by the Acquirer")
  protected String hostReconciliationID;

  /**
   * Gets approval code.
   *
   * @return the approval code
   */
  public String getApprovalCode() {
    return approvalCode;
  }

  /**
   * Sets approval code.
   *
   * @param approvalCode the approval code
   */
  public void setApprovalCode(String approvalCode) {
    this.approvalCode = approvalCode;
  }

  /**
   * Gets loyalty transaction id.
   *
   * @return the loyalty transaction id
   */
  public TransactionIdentification getLoyaltyTransactionID() {
    return loyaltyTransactionID;
  }

  /**
   * Sets loyalty transaction id.
   *
   * @param loyaltyTransactionID the loyalty transaction id
   */
  public void setLoyaltyTransactionID(TransactionIdentification loyaltyTransactionID) {
    this.loyaltyTransactionID = loyaltyTransactionID;
  }

  /**
   * Gets loyalty acquirer id.
   *
   * @return the loyalty acquirer id
   */
  public String getLoyaltyAcquirerID() {
    return loyaltyAcquirerID;
  }

  /**
   * Sets loyalty acquirer id.
   *
   * @param loyaltyAcquirerID the loyalty acquirer id
   */
  public void setLoyaltyAcquirerID(String loyaltyAcquirerID) {
    this.loyaltyAcquirerID = loyaltyAcquirerID;
  }

  /**
   * Gets host reconciliation id.
   *
   * @return the host reconciliation id
   */
  public String getHostReconciliationID() {
    return hostReconciliationID;
  }

  /**
   * Sets host reconciliation id.
   *
   * @param hostReconciliationID the host reconciliation id
   */
  public void setHostReconciliationID(String hostReconciliationID) {
    this.hostReconciliationID = hostReconciliationID;
  }
}
