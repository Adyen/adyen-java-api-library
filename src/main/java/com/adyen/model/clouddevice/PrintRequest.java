package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Content of the Print Request message. */
@JsonPropertyOrder({"PrintOutput"})
public class PrintRequest {

  @JsonProperty("PrintOutput")
  @Schema(description = "Information to print and the way to process the print.")
  protected PrintOutput printOutput;

  /**
   * Gets print output.
   *
   * @return the print output
   */
  public PrintOutput getPrintOutput() {
    return printOutput;
  }

  /**
   * Sets print output.
   *
   * @param printOutput the print output
   */
  public void setPrintOutput(PrintOutput printOutput) {
    this.printOutput = printOutput;
  }
}