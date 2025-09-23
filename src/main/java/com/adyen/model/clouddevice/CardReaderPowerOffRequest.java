package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigInteger;

/** Content of the Card Reader Power-Off Request message. */
@JsonPropertyOrder({"DisplayOutput", "MaxWaitingTime"})
public class CardReaderPowerOffRequest {

  @JsonProperty("DisplayOutput")
  @Schema(description = "Information to display and the way to process the display.")
  protected DisplayOutput displayOutput;

  @JsonProperty("MaxWaitingTime")
  @Schema(description = "Maximum time to wait for the request processing in seconds.")
  protected BigInteger maxWaitingTime;

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