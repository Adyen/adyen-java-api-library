package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Content of the Input Request message. */
@JsonPropertyOrder({"DisplayOutput", "InputData"})
public class InputRequest {

  @JsonProperty("DisplayOutput")
  @Schema(
      description =
          "Information to display and the way to process the display. --Rule: Mandatory if the display device is managed by the receiver.")
  protected DisplayOutput displayOutput;

  @JsonProperty("InputData")
  @Schema(description = "Information related to an Input request.")
  protected InputData inputData;

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
   * Gets input data.
   *
   * @return the input data
   */
  public InputData getInputData() {
    return inputData;
  }

  /**
   * Sets input data.
   *
   * @param inputData the input data
   */
  public void setInputData(InputData inputData) {
    this.inputData = inputData;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InputRequest {\n");
    sb.append("    displayOutput: ").append(toIndentedString(displayOutput)).append("\n");
    sb.append("    inputData: ").append(toIndentedString(inputData)).append("\n");
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