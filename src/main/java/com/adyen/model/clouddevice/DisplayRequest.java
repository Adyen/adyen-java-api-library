package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Content of the Display Request message. */
@JsonPropertyOrder({"DisplayOutput"})
public class DisplayRequest {

  @JsonProperty("DisplayOutput")
  @Schema(
      description =
          "Information to display and the way to process the display. --Rule: Complete display content for output devices. At most one DisplayOutput per  Device/ InfoQualify pair")
  protected List<DisplayOutput> displayOutput;

  /**
   * Gets display output.
   *
   * @return the display output
   */
  public List<DisplayOutput> getDisplayOutput() {
    if (displayOutput == null) {
      displayOutput = new ArrayList<>();
    }
    return this.displayOutput;
  }

  /**
   * Sets display output.
   *
   * @param displayOutput the display output
   */
  public void setDisplayOutput(List<DisplayOutput> displayOutput) {
    this.displayOutput = displayOutput;
  }
}