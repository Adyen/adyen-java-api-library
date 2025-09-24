package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/** Content of the Card Reader Init Request message. */
@JsonPropertyOrder({
  "ForceEntryMode",
  "DisplayOutput",
  "WarmResetFlag",
  "LeaveCardFlag",
  "MaxWaitingTime"
})
public class CardReaderInitRequest {

  @JsonProperty("ForceEntryMode")
  @Schema(description = "Payment instrument entry mode requested by the Sale System.")
  protected List<ForceEntryModeType> forceEntryMode;

  @JsonProperty("DisplayOutput")
  @Schema(description = "Information to display and the way to process the display.")
  protected DisplayOutput displayOutput;

  @JsonProperty("WarmResetFlag")
  @Schema(description = "Flag to request a warm reset on a chip.")
  protected Boolean warmResetFlag;

  @JsonProperty("LeaveCardFlag")
  @Schema(description = "Indicates if the POI has to keep the card in the reader for a smart card.")
  protected Boolean leaveCardFlag;

  @JsonProperty("MaxWaitingTime")
  @Schema(description = "Maximum time to wait for the request processing in seconds.")
  protected BigInteger maxWaitingTime;

  /**
   * Gets force entry mode.
   *
   * @return the force entry mode
   */
  public List<ForceEntryModeType> getForceEntryMode() {
    if (forceEntryMode == null) {
      forceEntryMode = new ArrayList<>();
    }
    return this.forceEntryMode;
  }

  /**
   * Sets force entry mode.
   *
   * @param forceEntryMode the force entry mode
   */
  public void setForceEntryMode(List<ForceEntryModeType> forceEntryMode) {
    this.forceEntryMode = forceEntryMode;
  }

  /**
   * Gets display output.
   *
   * @return the display output
   */
  public DisplayOutput getDisplayOutput() {
    return displayOutput;
  }

  /**
   * Sets display output.
   *
   * @param displayOutput the display output
   */
  public void setDisplayOutput(DisplayOutput displayOutput) {
    this.displayOutput = displayOutput;
  }

  /**
   * Is warm reset flag boolean.
   *
   * @return the boolean
   */
  public Boolean isWarmResetFlag() {
    return warmResetFlag;
  }

  /**
   * Sets warm reset flag.
   *
   * @param warmResetFlag the warm reset flag
   */
  public void setWarmResetFlag(Boolean warmResetFlag) {
    this.warmResetFlag = warmResetFlag;
  }

  /**
   * Is leave card flag boolean.
   *
   * @return the boolean
   */
  public boolean isLeaveCardFlag() {
    if (leaveCardFlag == null) {
      return true;
    } else {
      return leaveCardFlag;
    }
  }

  /**
   * Sets leave card flag.
   *
   * @param leaveCardFlag the leave card flag
   */
  public void setLeaveCardFlag(Boolean leaveCardFlag) {
    this.leaveCardFlag = leaveCardFlag;
  }

  /**
   * Gets max waiting time.
   *
   * @return the max waiting time
   */
  public BigInteger getMaxWaitingTime() {
    return maxWaitingTime;
  }

  /**
   * Sets max waiting time.
   *
   * @param maxWaitingTime the max waiting time
   */
  public void setMaxWaitingTime(BigInteger maxWaitingTime) {
    this.maxWaitingTime = maxWaitingTime;
  }
}
