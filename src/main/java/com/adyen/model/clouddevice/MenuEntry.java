package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** An entryof the menu to present to the Cashier. */
@JsonPropertyOrder({
    "PredefinedContent",
    "OutputText",
    "OutputXHTML",
    "MenuEntryTag",
    "OutputFormat",
    "DefaultSelectedFlag"
})
public class MenuEntry {

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

  @JsonProperty("MenuEntryTag")
  @Schema(description = "Characteristics related to the selection of a menu entry")
  protected MenuEntryTagType menuEntryTag;

  @JsonProperty("OutputFormat")
  @Schema(description = "Format of the content to display or print --Rule: MessageRef, Text, XHTML")
  protected OutputFormatType outputFormat;

  @JsonProperty("DefaultSelectedFlag")
  @Schema(description = "Selection of a menu entry to be displayed.")
  protected Boolean defaultSelectedFlag;

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
   * Gets menu entry tag.
   *
   * @return the menu entry tag
   */
  public MenuEntryTagType getMenuEntryTag() {
    if (menuEntryTag == null) {
      return MenuEntryTagType.SELECTABLE;
    } else {
      return menuEntryTag;
    }
  }

  /**
   * Sets menu entry tag.
   *
   * @param menuEntryTag the menu entry tag
   */
  public void setMenuEntryTag(MenuEntryTagType menuEntryTag) {
    this.menuEntryTag = menuEntryTag;
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

  /**
   * Is default selected flag boolean.
   *
   * @return the boolean
   */
  public boolean isDefaultSelectedFlag() {
    if (defaultSelectedFlag == null) {
      return false;
    } else {
      return defaultSelectedFlag;
    }
  }

  /**
   * Sets default selected flag.
   *
   * @param defaultSelectedFlag the default selected flag
   */
  public void setDefaultSelectedFlag(Boolean defaultSelectedFlag) {
    this.defaultSelectedFlag = defaultSelectedFlag;
  }
}