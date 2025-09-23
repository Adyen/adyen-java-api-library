package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Content of the Reconciliation Request message. */
@JsonPropertyOrder({"AcquirerID", "ReconciliationType", "POIReconciliationID"})
public class ReconciliationRequest {

  @JsonProperty("AcquirerID")
  @Schema(
      description =
          "Identification of the Acquirer --Rule: Could be present only if ReconciliationType is \"AcquirerReconciliation\" or \"AcquirerSynchronisation\"")
  protected List<String> acquirerID;

  @JsonProperty("ReconciliationType")
  @Schema(description = "Type of Reconciliation requested by the Sale to the POI.")
  protected ReconciliationType reconciliationType;

  @JsonProperty("POIReconciliationID")
  @Schema(
      description =
          "Identification of the reconciliation period between Sale and POI.  --Rule: Absent if ReconciliationType is not \"PreviousReconciliation\"")
  protected String poiReconciliationID;

  /**
   * Gets acquirer id.
   *
   * @return the acquirer id
   */
  public List<String> getAcquirerID() {
    if (acquirerID == null) {
      acquirerID = new ArrayList<>();
    }
    return this.acquirerID;
  }

  /**
   * Sets acquirer id.
   *
   * @param acquirerID the acquirer id
   */
  public void setAcquirerID(List<String> acquirerID) {
    this.acquirerID = acquirerID;
  }

  /**
   * Gets reconciliation type.
   *
   * @return the reconciliation type
   */
  public ReconciliationType getReconciliationType() {
    return reconciliationType;
  }

  /**
   * Sets reconciliation type.
   *
   * @param reconciliationType the reconciliation type
   */
  public void setReconciliationType(ReconciliationType reconciliationType) {
    this.reconciliationType = reconciliationType;
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