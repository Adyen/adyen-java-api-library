package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Data related to the POI System. */
@JsonPropertyOrder({"POITransactionID", "POIReconciliationID"})
public class POIData {

  @JsonProperty("POITransactionID")
  @Schema(description = "Unique identification of a POI transaction for a POI")
  protected TransactionIdentification poiTransactionID;

  @JsonProperty("POIReconciliationID")
  @Schema(
      description =
          "Identification of the reconciliation period between Sale and POI.  --Rule: If Result is Success")
  protected String poiReconciliationID;

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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("POIData{");
    sb.append("poiTransactionID=").append(poiTransactionID);
    sb.append(", poiReconciliationID='").append(poiReconciliationID).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
