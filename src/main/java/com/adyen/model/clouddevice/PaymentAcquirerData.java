package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Data related to the response from the payment Acquirer. */
@JsonPropertyOrder({
    "AcquirerTransactionID",
    "ApprovalCode",
    "AcquirerID",
    "MerchantID",
    "AcquirerPOIID"
})
public class PaymentAcquirerData {

  @JsonProperty("AcquirerTransactionID")
  @Schema(
      description =
          "Identification of the Transaction for the Acquirer. --Rule: If provided by the Acquirer")
  protected TransactionIdentification acquirerTransactionID;

  @JsonProperty("ApprovalCode")
  @Schema(
      description = "Code assigned to a transaction approval by the Acquirer. --Rule: If available")
  protected String approvalCode;

  @JsonProperty("AcquirerID")
  @Schema(description = "Identification of the Acquirer --Rule: If several Acquirers")
  protected String acquirerID;

  @JsonProperty("MerchantID")
  @Schema(description = "Identification of the Merchant for the Acquirer")
  protected String merchantID;

  @JsonProperty("AcquirerPOIID")
  @Schema(description = "Identification of the POI for the payment Acquirer")
  protected String acquirerPOIID;

  /**
   * Gets acquirer transaction id.
   *
   * @return the acquirer transaction id
   */
  public TransactionIdentification getAcquirerTransactionID() {
    return acquirerTransactionID;
  }

  /**
   * Sets acquirer transaction id.
   *
   * @param acquirerTransactionID the acquirer transaction id
   */
  public void setAcquirerTransactionID(TransactionIdentification acquirerTransactionID) {
    this.acquirerTransactionID = acquirerTransactionID;
  }

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
   * Gets acquirer id.
   *
   * @return the acquirer id
   */
  public String getAcquirerID() {
    return acquirerID;
  }

  /**
   * Sets acquirer id.
   *
   * @param acquirerID the acquirer id
   */
  public void setAcquirerID(String acquirerID) {
    this.acquirerID = acquirerID;
  }

  /**
   * Gets merchant id.
   *
   * @return the merchant id
   */
  public String getMerchantID() {
    return merchantID;
  }

  /**
   * Sets merchant id.
   *
   * @param merchantID the merchant id
   */
  public void setMerchantID(String merchantID) {
    this.merchantID = merchantID;
  }

  /**
   * Gets acquirer poiid.
   *
   * @return the acquirer poiid
   */
  public String getAcquirerPOIID() {
    return acquirerPOIID;
  }

  /**
   * Sets acquirer poiid.
   *
   * @param acquirerPOIID the acquirer poiid
   */
  public void setAcquirerPOIID(String acquirerPOIID) {
    this.acquirerPOIID = acquirerPOIID;
  }
}