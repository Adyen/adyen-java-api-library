package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Content of the Reconciliation Response message. */
@JsonPropertyOrder({"Response", "TransactionTotals", "POIReconciliationID"})
public class GetTotalsResponse {

  @JsonProperty("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  @JsonProperty("TransactionTotals")
  @Schema(
      description =
          "Result of the Sale to POI Reconciliation processing. --Rule: if Response.Result is Success")
  protected List<TransactionTotals> transactionTotals;

  @JsonProperty("POIReconciliationID")
  @Schema(description = "Identification of the reconciliation period between Sale and POI. ")
  protected String poiReconciliationID;

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
   * Gets transaction totals.
   *
   * @return the transaction totals
   */
  public List<TransactionTotals> getTransactionTotals() {
    if (transactionTotals == null) {
      transactionTotals = new ArrayList<>();
    }
    return this.transactionTotals;
  }

  /**
   * Sets transaction totals.
   *
   * @param transactionTotals the transaction totals
   */
  public void setTransactionTotals(List<TransactionTotals> transactionTotals) {
    this.transactionTotals = transactionTotals;
  }

  /**
   * Gets poi reconciliation id.
   *
   * @return the poi reconciliation id
   */
  public String getPOIReconciliationID() {
    return poiReconciliationID;
  }

  /**
   * Sets poi reconciliation id.
   *
   * @param poiReconciliationID the poi reconciliation id
   */
  public void setPOIReconciliationID(String poiReconciliationID) {
    this.poiReconciliationID = poiReconciliationID;
  }
}
