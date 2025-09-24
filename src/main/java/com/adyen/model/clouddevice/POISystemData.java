package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;

/** Information related to the POI System. */
@JsonPropertyOrder({"DateTime", "POISoftware", "POITerminalData", "POIStatus"})
public class POISystemData {

  @JsonProperty("DateTime")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  @Schema(description = "Date and Time")
  protected OffsetDateTime dateTime;

  @JsonProperty("POISoftware")
  @Schema(
      description =
          "Information related to the software of the POI System which manages the Sale to POI protocol.")
  protected POISoftware poiSoftware;

  @JsonProperty("POITerminalData")
  @Schema(
      description =
          "Information related to the software and hardware feature of the POI Terminal --Rule: Present if the login involve a POI Terminal")
  protected POITerminalData poiTerminalData;

  @JsonProperty("POIStatus")
  @Schema(description = "State of a POI Terminal. --Rule: if Response.Result is Success")
  protected POIStatus poiStatus;

  /**
   * Gets date time.
   *
   * @return the date time
   */
  public OffsetDateTime getDateTime() {
    return dateTime;
  }

  /**
   * Sets date time.
   *
   * @param dateTime the date time
   */
  public void setDateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
  }

  /**
   * Gets poi software.
   *
   * @return the poi software
   */
  public POISoftware getPOISoftware() {
    return poiSoftware;
  }

  /**
   * Sets poi software.
   *
   * @param poiSoftware the poi software
   */
  public void setPOISoftware(POISoftware poiSoftware) {
    this.poiSoftware = poiSoftware;
  }

  /**
   * Gets poi terminal data.
   *
   * @return the poi terminal data
   */
  public POITerminalData getPOITerminalData() {
    return poiTerminalData;
  }

  /**
   * Sets poi terminal data.
   *
   * @param poiTerminalData the poi terminal data
   */
  public void setPOITerminalData(POITerminalData poiTerminalData) {
    this.poiTerminalData = poiTerminalData;
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
}
