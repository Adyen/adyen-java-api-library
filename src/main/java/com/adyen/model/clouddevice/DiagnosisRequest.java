package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Content of the Diagnosis Request message. */
@JsonPropertyOrder({"AcquirerID", "POIID", "HostDiagnosisFlag"})
public class DiagnosisRequest {

  @JsonProperty("AcquirerID")
  @Schema(
      description =
          "Identification of the Acquirer --Rule: Present if requesting the diagnosis of these hosts only.")
  protected List<String> acquirerID;

  @JsonProperty("POIID")
  @Schema(
      description =
          "Identification of a POI System or a POI Terminal for the Sale to POI protocol --Rule: MessageHeader.POIID")
  protected String poiid;

  @JsonProperty("HostDiagnosisFlag")
  @Schema(description = "Indicates if Host Diagnosis are required")
  protected Boolean hostDiagnosisFlag;

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
   * Is host diagnosis flag boolean.
   *
   * @return the boolean
   */
  public boolean isHostDiagnosisFlag() {
    if (hostDiagnosisFlag == null) {
      return false;
    } else {
      return hostDiagnosisFlag;
    }
  }

  /**
   * Sets host diagnosis flag.
   *
   * @param hostDiagnosisFlag the host diagnosis flag
   */
  public void setHostDiagnosisFlag(Boolean hostDiagnosisFlag) {
    this.hostDiagnosisFlag = hostDiagnosisFlag;
  }
}