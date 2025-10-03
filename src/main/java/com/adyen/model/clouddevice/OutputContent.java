package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Content to display or print. */
@JsonPropertyOrder({
  "PredefinedContent",
  "OutputText",
  "OutputXHTML",
  "OutputBarcode",
  "OutputFormat"
})
public class OutputContent {

  @JsonProperty("PredefinedContent")
  @Schema(
      description =
          "Reference of a predefined message to display or print. --Rule: Mandatory, if OutputFormat is MessageRef, not allowed otherwise.")
  protected PredefinedContent predefinedContent;

  @JsonProperty("OutputText")
  @Schema(
      description =
          "Content of text message to display or print. --Rule: Mandatory, if OutputFormat is Text, not allowed otherwise. One instance of OutputText per shared format")
  protected List<OutputText> outputText;

  @JsonProperty("OutputXHTML")
  @Schema(
      description =
          "XHTML document body containing the message to display or print. --Rule: Mandatory, if OutputFormat is XHTML, not allowed otherwise.")
  protected byte[] outputXHTML;

  @JsonProperty("OutputBarcode")
  @Schema(
      description =
          "BarCode content to display or print. --Rule: Mandatory, if OutputFormat is BarCode, not allowed otherwise.")
  protected OutputBarcode outputBarcode;

  @JsonProperty("OutputFormat")
  @Schema(description = "Format of the content to display or print")
  protected OutputFormatType outputFormat;

  /**
   * Gets predefined content.
   *
   * @return the predefined content
   */
  public PredefinedContent getPredefinedContent() {
    return predefinedContent;
  }

  /**
   * Sets predefined content.
   *
   * @param predefinedContent the predefined content
   */
  public void setPredefinedContent(PredefinedContent predefinedContent) {
    this.predefinedContent = predefinedContent;
  }

  /**
   * Gets output text.
   *
   * @return the output text
   */
  public List<OutputText> getOutputText() {
    if (outputText == null) {
      outputText = new ArrayList<>();
    }
    return this.outputText;
  }

  /**
   * Sets output text.
   *
   * @param outputText the output text
   */
  public void setOutputText(List<OutputText> outputText) {
    this.outputText = outputText;
  }

  /**
   * Get output xhtml.
   *
   * @return the byte [ ]
   */
  public byte[] getOutputXHTML() {
    return outputXHTML;
  }

  /**
   * Sets output xhtml.
   *
   * @param outputXHTML the output xhtml
   */
  public void setOutputXHTML(byte[] outputXHTML) {
    this.outputXHTML = outputXHTML;
  }

  /**
   * Gets output barcode.
   *
   * @return the output barcode
   */
  public OutputBarcode getOutputBarcode() {
    return outputBarcode;
  }

  /**
   * Sets output barcode.
   *
   * @param outputBarcode the output barcode
   */
  public void setOutputBarcode(OutputBarcode outputBarcode) {
    this.outputBarcode = outputBarcode;
  }

  /**
   * Gets output format.
   *
   * @return the output format
   */
  public OutputFormatType getOutputFormat() {
    return outputFormat;
  }

  /**
   * Sets output format.
   *
   * @param outputFormat the output format
   */
  public void setOutputFormat(OutputFormatType outputFormat) {
    this.outputFormat = outputFormat;
  }
}
