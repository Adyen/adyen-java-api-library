package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Content of the Display Response message. */
@JsonPropertyOrder({"OutputResult"})
public class DisplayResponse {

  @JsonProperty("OutputResult")
  @Schema(
      description =
          "Information related to the result the output (display, print, input). --Rule: One per DisplayOutput item of the request, and in the same order.")
  protected List<OutputResult> outputResult;

  /**
   * Gets output result.
   *
   * @return the output result
   */
  public List<OutputResult> getOutputResult() {
    if (outputResult == null) {
      outputResult = new ArrayList<>();
    }
    return this.outputResult;
  }

  /**
   * Sets output result.
   *
   * @param outputResult the output result
   */
  public void setOutputResult(List<OutputResult> outputResult) {
    this.outputResult = outputResult;
  }
}