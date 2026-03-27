package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: Data related to the loyalty Acquirer during a loyalty transaction. -- Usage:
 * Information allowing the Sale System to characterise the transaction on the loyalty Acquirer
 * host.
 *
 * <p>Java class for LoyaltyAcquirerData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LoyaltyAcquirerData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ApprovalCode" type="{}ApprovalCode" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyTransactionID" type="{}TransactionIdentification" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="LoyaltyAcquirerID" type="{}LoyaltyAcquirerID" /&gt;
 *       &lt;attribute name="HostReconciliationID" type="{}HostReconciliationID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class LoyaltyAcquirerData {

  /** The Approval code. */
  @SerializedName("ApprovalCode")
  @Schema(
      description =
          "Code assigned to a transaction approval by the Acquirer. --Rule: If provided by the Acquirer")
  protected String approvalCode;

  /** The Loyalty transaction id. */
  @SerializedName("LoyaltyTransactionID")
  @Schema(
      description =
          "Identification of the Transaction for the Loyalty Acquirer. --Rule: If provided by the Acquirer")
  protected TransactionIdentification loyaltyTransactionID;

  /** The Loyalty acquirer id. */
  @SerializedName("LoyaltyAcquirerID")
  @Schema(description = "Identification of the loyalty Acquirer. --Rule: If available")
  protected String loyaltyAcquirerID;

  /** The Host reconciliation id. */
  @SerializedName("HostReconciliationID")
  @Schema(
      description =
          "Identifier of a reconciliation period with a payment or loyalty host. --Rule: If provided by the Acquirer")
  protected String hostReconciliationID;

  /**
   * Gets the value of the approvalCode property.
   *
   * @return possible object is {@link String }
   */
  public String getApprovalCode() {
    return approvalCode;
  }

  /**
   * Sets the value of the approvalCode property.
   *
   * @param value allowed object is {@link String }
   */
  public void setApprovalCode(String value) {
    this.approvalCode = value;
  }

  /**
   * Gets the value of the loyaltyTransactionID property.
   *
   * @return possible object is {@link TransactionIdentification }
   */
  public TransactionIdentification getLoyaltyTransactionID() {
    return loyaltyTransactionID;
  }

  /**
   * Sets the value of the loyaltyTransactionID property.
   *
   * @param value allowed object is {@link TransactionIdentification }
   */
  public void setLoyaltyTransactionID(TransactionIdentification value) {
    this.loyaltyTransactionID = value;
  }

  /**
   * Gets the value of the loyaltyAcquirerID property.
   *
   * @return possible object is {@link String }
   */
  public String getLoyaltyAcquirerID() {
    return loyaltyAcquirerID;
  }

  /**
   * Sets the value of the loyaltyAcquirerID property.
   *
   * @param value allowed object is {@link String }
   */
  public void setLoyaltyAcquirerID(String value) {
    this.loyaltyAcquirerID = value;
  }

  /**
   * Gets the value of the hostReconciliationID property.
   *
   * @return possible object is {@link String }
   */
  public String getHostReconciliationID() {
    return hostReconciliationID;
  }

  /**
   * Sets the value of the hostReconciliationID property.
   *
   * @param value allowed object is {@link String }
   */
  public void setHostReconciliationID(String value) {
    this.hostReconciliationID = value;
  }
}
