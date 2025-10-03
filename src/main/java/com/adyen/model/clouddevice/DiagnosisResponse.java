package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Content of the Diagnosis Response message. */
@JsonPropertyOrder({"Response", "LoggedSaleID", "POIStatus", "HostStatus"})
public class DiagnosisResponse {

  @JsonProperty("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  @JsonProperty("LoggedSaleID")
  @Schema(
      description = "Sale Terminal logged to. --Rule: If Sale Terminal logged to this POI Terminal")
  protected List<String> loggedSaleID;

  @JsonProperty("POIStatus")
  @Schema(description = "State of a POI Terminal. --Rule: if Response.Result is Success")
  protected POIStatus poiStatus;

  @JsonProperty("HostStatus")
  @Schema(description = "State of a Host.")
  protected List<HostStatus> hostStatus;

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
   * Gets logged sale id.
   *
   * @return the logged sale id
   */
  public List<String> getLoggedSaleID() {
    if (loggedSaleID == null) {
      loggedSaleID = new ArrayList<>();
    }
    return this.loggedSaleID;
  }

  /**
   * Sets logged sale id.
   *
   * @param loggedSaleID the logged sale id
   */
  public void setLoggedSaleID(List<String> loggedSaleID) {
    this.loggedSaleID = loggedSaleID;
  }

  /**
   * Gets poi status.
   *
   * @return the poi status
   */
  public POIStatus getPOIStatus() {
    return poiStatus;
  }

  /**
   * Sets poi status.
   *
   * @param poiStatus the poi status
   */
  public void setPOIStatus(POIStatus poiStatus) {
    this.poiStatus = poiStatus;
  }

  /**
   * Gets host status.
   *
   * @return the host status
   */
  public List<HostStatus> getHostStatus() {
    if (hostStatus == null) {
      hostStatus = new ArrayList<>();
    }
    return this.hostStatus;
  }

  /**
   * Sets host status.
   *
   * @param hostStatus the host status
   */
  public void setHostStatus(List<HostStatus> hostStatus) {
    this.hostStatus = hostStatus;
  }
}
