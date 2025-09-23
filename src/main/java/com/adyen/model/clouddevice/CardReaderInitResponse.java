package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Content of the Card Reader Init Response message. */
@JsonPropertyOrder({"Response", "TrackData", "ICCResetData", "EntryMode"})
public class CardReaderInitResponse {

  @JsonProperty("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  @JsonProperty("TrackData")
  @Schema(
      description =
          "Magnetic track or magnetic ink characters line. --Rule: if EntryMode is RFID or MagStripe")
  protected List<TrackData> trackData;

  @JsonProperty("ICCResetData")
  @Schema(
      description =
          "Data of a Chip Card related to the reset of the chip. --Rule: if EntryMode is ICC, EMVContactless or SynchronousICC")
  protected ICCResetData iccResetData;

  @JsonProperty("EntryMode")
  @Schema(
      description =
          "Entry mode of the payment instrument information --Rule: RFID, MagStripe, ICC, EMVContactless or SynchronousICC")
  protected List<EntryModeType> entryMode;

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
   * Gets track data.
   *
   * @return the track data
   */
  public List<TrackData> getTrackData() {
    if (trackData == null) {
      trackData = new ArrayList<>();
    }
    return this.trackData;
  }

  /**
   * Sets track data.
   *
   * @param trackData the track data
   */
  public void setTrackData(List<TrackData> trackData) {
    this.trackData = trackData;
  }

  /**
   * Gets icc reset data.
   *
   * @return the icc reset data
   */
  public ICCResetData getICCResetData() {
    return iccResetData;
  }

  /**
   * Sets icc reset data.
   *
   * @param iccResetData the icc reset data
   */
  public void setICCResetData(ICCResetData iccResetData) {
    this.iccResetData = iccResetData;
  }

  /**
   * Gets entry mode.
   *
   * @return the entry mode
   */
  public List<EntryModeType> getEntryMode() {
    if (entryMode == null) {
      entryMode = new ArrayList<>();
    }
    return this.entryMode;
  }

  /**
   * Sets entry mode.
   *
   * @param entryMode the entry mode
   */
  public void setEntryMode(List<EntryModeType> entryMode) {
    this.entryMode = entryMode;
  }
}