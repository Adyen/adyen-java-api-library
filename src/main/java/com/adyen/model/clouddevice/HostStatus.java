package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** State of a Host. */
@JsonPropertyOrder({"AcquirerID", "IsReachableFlag"})
public class HostStatus {

  @JsonProperty("AcquirerID")
  @Schema(description = "Identification of the Acquirer")
  protected String acquirerID;

  @JsonProperty("IsReachableFlag")
  @Schema(description = "Indicate if a Host is reachable")
  protected Boolean isReachableFlag;

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
   * Is is reachable flag boolean.
   *
   * @return the boolean
   */
  public boolean isIsReachableFlag() {
    if (isReachableFlag == null) {
      return true;
    } else {
      return isReachableFlag;
    }
  }

  /**
   * Sets is reachable flag.
   *
   * @param isReachableFlag the is reachable flag
   */
  public void setIsReachableFlag(Boolean isReachableFlag) {
    this.isReachableFlag = isReachableFlag;
  }
}
