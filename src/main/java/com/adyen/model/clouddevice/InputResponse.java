package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Content of the Input Response message. */
@JsonPropertyOrder({"OutputResult", "InputResult"})
public class InputResponse {

  @JsonProperty("OutputResult")
  @Schema(
      description =
          "Information related to the result the output (display, print, input). --Rule: If DisplayOutput present in the request.")
  protected OutputResult outputResult;

  @JsonProperty("InputResult")
  @Schema(description = "Information related to the result the input.")
  protected InputResult inputResult;

  /**
   * Gets output result.
   *
   * @return the output result
   */
  public OutputResult getOutputResult() {
    return outputResult;
  }

  /**
   * Sets output result.
   *
   * @param outputResult the output result
   */
  public void setOutputResult(OutputResult outputResult) {
    this.outputResult = outputResult;
  }

  /**
   * Gets input result.
   *
   * @return the input result
   */
  public InputResult getInputResult() {
    return inputResult;
  }

  /**
   * Sets input result.
   *
   * @param inputResult the input result
   */
  public void setInputResult(InputResult inputResult) {
    this.inputResult = inputResult;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InputResponse {\n");
    sb.append("    outputResult: ").append(toIndentedString(outputResult)).append("\n");
    sb.append("    inputResult: ").append(toIndentedString(inputResult)).append("\n");
    sb.append("}\n");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}