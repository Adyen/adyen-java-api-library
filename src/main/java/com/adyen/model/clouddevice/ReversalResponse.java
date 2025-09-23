package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/** Content of the Reversal Response message. */
@JsonPropertyOrder({
    "Response",
    "POIData",
    "OriginalPOITransaction",
    "PaymentReceipt",
    "ReversedAmount",
    "CustomerOrderID"
})
public class ReversalResponse {

  @JsonProperty("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  @JsonProperty("POIData")
  @Schema(description = "Data related to the POI System. --Rule: If Result is Success")
  protected POIData poiData;

  @JsonProperty("OriginalPOITransaction")
  @Schema(
      description =
          "Identification of a previous POI transaction. --Rule: Present if POITransactionID absent in the request")
  protected OriginalPOITransaction originalPOITransaction;

  @JsonProperty("PaymentReceipt")
  @Schema(
      description =
          "Customer or Merchant payment receipt. --Rule: If Basic profile implementation with no printer on the POI.")
  protected List<PaymentReceipt> paymentReceipt;

  @JsonProperty("ReversedAmount")
  @Schema(description = "Amount of the payment or loyalty to reverse.. --Rule: Copy")
  protected BigDecimal reversedAmount;

  @JsonProperty("CustomerOrderID")
  @Schema(
      description =
          "Customer order attached to a card, recorded in the POI system. --Rule: If the reversal is performed inside a customer order.")
  protected String customerOrderID;

  /**
   * Gets response.
   *
   * @return the response
   */
  public Response getResponse() {
    return response;
  }

  /**
   * Sets response.
   *
   * @param response the response
   */
  public void setResponse(Response response) {
    this.response = response;
  }

  /**
   * Gets poi data.
   *
   * @return the poi data
   */
  public POIData getPOIData() {
    return poiData;
  }

  /**
   * Sets poi data.
   *
   * @param poiData the poi data
   */
  public void setPOIData(POIData poiData) {
    this.poiData = poiData;
  }

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
   * Gets payment receipt.
   *
   * @return the payment receipt
   */
  public List<PaymentReceipt> getPaymentReceipt() {
    if (paymentReceipt == null) {
      paymentReceipt = new ArrayList<>();
    }
    return this.paymentReceipt;
  }

  /**
   * Sets payment receipt.
   *
   * @param paymentReceipt the payment receipt
   */
  public void setPaymentReceipt(List<PaymentReceipt> paymentReceipt) {
    this.paymentReceipt = paymentReceipt;
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
   * Gets customer order id.
   *
   * @return the customer order id
   */
  public String getCustomerOrderID() {
    return customerOrderID;
  }

  /**
   * Sets customer order id.
   *
   * @param customerOrderID the customer order id
   */
  public void setCustomerOrderID(String customerOrderID) {
    this.customerOrderID = customerOrderID;
  }
}