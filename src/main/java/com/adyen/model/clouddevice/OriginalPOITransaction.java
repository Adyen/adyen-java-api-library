package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Identification of a previous POI transaction. */
@JsonPropertyOrder({
  "POITransactionID",
  "ApprovalCode",
  "HostTransactionID",
  "SaleID",
  "POIID",
  "ReuseCardDataFlag",
  "CustomerLanguage",
  "AcquirerID"
})
public class OriginalPOITransaction {

  @JsonProperty("POITransactionID")
  @Schema(
      description =
          "Unique identification of a POI transaction for a POI --Rule: Absent if SaleReferenceID is sufficient to identify the transaction, or for some reversal cases.")
  protected TransactionIdentification poiTransactionID;

  @JsonProperty("ApprovalCode")
  @Schema(
      description = "Code assigned to a transaction approval by the Acquirer. --Rule: If referral")
  protected String approvalCode;

  @JsonProperty("HostTransactionID")
  @Schema(
      description =
          "Identification of the transaction by the host in charge of the stored value transaction --Rule: If POITransactionID not present")
  protected TransactionIdentification hostTransactionID;

  @JsonProperty("SaleID")
  @Schema(
      description =
          "Identification of a Sale System or a Sale Terminal for the Sale to POI protocol")
  protected String saleID;

  @JsonProperty("POIID")
  @Schema(
      description =
          "Identification of a POI System or a POI Terminal for the Sale to POI protocol --Rule: If original transaction is coming from another POI")
  protected String poiid;

  @JsonProperty("ReuseCardDataFlag")
  @Schema(description = "Indicate if the card data has to be got from a previous transaction.")
  protected Boolean reuseCardDataFlag;

  @JsonProperty("CustomerLanguage")
  @Schema(description = "Language of the Customer --Rule: Optional for Reversal, otherwise absent.")
  protected String customerLanguage;

  @JsonProperty("AcquirerID")
  @Schema(
      description =
          "Identification of the Acquirer --Rule: Optional for Reversal, otherwise absent.")
  protected String acquirerID;

  /**
   * Gets poi transaction id.
   *
   * @return the poi transaction id
   */
  public TransactionIdentification getPOITransactionID() {
    return poiTransactionID;
  }

  /**
   * Sets poi transaction id.
   *
   * @param poiTransactionID the poi transaction id
   */
  public void setPOITransactionID(TransactionIdentification poiTransactionID) {
    this.poiTransactionID = poiTransactionID;
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
   * Gets host transaction id.
   *
   * @return the host transaction id
   */
  public TransactionIdentification getHostTransactionID() {
    return hostTransactionID;
  }

  /**
   * Sets host transaction id.
   *
   * @param hostTransactionID the host transaction id
   */
  public void setHostTransactionID(TransactionIdentification hostTransactionID) {
    this.hostTransactionID = hostTransactionID;
  }

  /**
   * Gets sale id.
   *
   * @return the sale id
   */
  public String getSaleID() {
    return saleID;
  }

  /**
   * Sets sale id.
   *
   * @param saleID the sale id
   */
  public void setSaleID(String saleID) {
    this.saleID = saleID;
  }

  /**
   * Gets poiid.
   *
   * @return the poiid
   */
  public String getPOIID() {
    return poiid;
  }

  /**
   * Sets poiid.
   *
   * @param poiid the poiid
   */
  public void setPOIID(String poiid) {
    this.poiid = poiid;
  }

  /**
   * Is reuse card data flag boolean.
   *
   * @return the boolean
   */
  public boolean isReuseCardDataFlag() {
    if (reuseCardDataFlag == null) {
      return true;
    } else {
      return reuseCardDataFlag;
    }
  }

  /**
   * Sets reuse card data flag.
   *
   * @param reuseCardDataFlag the reuse card data flag
   */
  public void setReuseCardDataFlag(Boolean reuseCardDataFlag) {
    this.reuseCardDataFlag = reuseCardDataFlag;
  }

  /**
   * Gets customer language.
   *
   * @return the customer language
   */
  public String getCustomerLanguage() {
    return customerLanguage;
  }

  /**
   * Sets customer language.
   *
   * @param customerLanguage the customer language
   */
  public void setCustomerLanguage(String customerLanguage) {
    this.customerLanguage = customerLanguage;
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
}
