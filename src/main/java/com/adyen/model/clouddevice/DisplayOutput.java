package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Information to display and the way to process the display. */
@JsonPropertyOrder({
  "OutputContent",
  "MenuEntry",
  "OutputSignature",
  "ResponseRequiredFlag",
  "MinimumDisplayTime",
  "Device",
  "InfoQualify"
})
public class DisplayOutput {

  @JsonProperty("OutputContent")
  @Schema(description = "Content to display or print.")
  protected OutputContent outputContent;

  @JsonProperty("MenuEntry")
  @Schema(
      description =
          "An entryof the menu to present to the Cashier --Rule: One instance of MenuEntry per item to display in the menu for the get menu input command.")
  protected List<MenuEntry> menuEntry;

  @JsonProperty("OutputSignature")
  @Schema(
      description =
          "Vendor specific signature of text message to display or print. --Rule: If protection has to be provided to the vendor on the text to display or print.")
  protected byte[] outputSignature;

  @JsonProperty("ResponseRequiredFlag")
  @Schema(description = "Request of a message response.")
  protected Boolean responseRequiredFlag;

  @JsonProperty("MinimumDisplayTime")
  @Schema(description = "Number of seconds the message has to be displayed")
  protected Integer minimumDisplayTime;

  @JsonProperty("Device")
  @Schema(
      description =
          "Logical device located on a Sale Terminal or a POI Terminal, in term of class of information to output (display, print --Rule: CashierDisplay, CustomerDisplay")
  protected DeviceType device;

  @JsonProperty("InfoQualify")
  @Schema(
      description =
          "Qualification of the information to sent to an output logical device, to display or print to the Cashier or the --Rule: Status, Error, Display, POIReplication")
  protected InfoQualifyType infoQualify;

  /**
   * Gets output content.
   *
   * @return the output content
   */
  public OutputContent getOutputContent() {
    return outputContent;
  }

  /**
   * Sets output content.
   *
   * @param outputContent the output content
   */
  public void setOutputContent(OutputContent outputContent) {
    this.outputContent = outputContent;
  }

  /**
   * Gets menu entry.
   *
   * @return the menu entry
   */
  public List<MenuEntry> getMenuEntry() {
    if (menuEntry == null) {
      menuEntry = new ArrayList<>();
    }
    return this.menuEntry;
  }

  /**
   * Sets menu entry.
   *
   * @param menuEntry the menu entry
   */
  public void setMenuEntry(List<MenuEntry> menuEntry) {
    this.menuEntry = menuEntry;
  }

  /**
   * Get output signature.
   *
   * @return the byte [ ]
   */
  public byte[] getOutputSignature() {
    return outputSignature;
  }

  /**
   * Sets output signature.
   *
   * @param outputSignature the output signature
   */
  public void setOutputSignature(byte[] outputSignature) {
    this.outputSignature = outputSignature;
  }

  /**
   * Is response required flag boolean.
   *
   * @return the boolean
   */
  public boolean isResponseRequiredFlag() {
    if (responseRequiredFlag == null) {
      return true;
    } else {
      return responseRequiredFlag;
    }
  }

  /**
   * Sets response required flag.
   *
   * @param responseRequiredFlag the response required flag
   */
  public void setResponseRequiredFlag(Boolean responseRequiredFlag) {
    this.responseRequiredFlag = responseRequiredFlag;
  }

  /**
   * Gets minimum display time.
   *
   * @return the minimum display time
   */
  public int getMinimumDisplayTime() {
    if (minimumDisplayTime == null) {
      return 0;
    } else {
      return minimumDisplayTime;
    }
  }

  /**
   * Sets minimum display time.
   *
   * @param minimumDisplayTime the minimum display time
   */
  public void setMinimumDisplayTime(Integer minimumDisplayTime) {
    this.minimumDisplayTime = minimumDisplayTime;
  }

  /**
   * Gets device.
   *
   * @return the device
   */
  public DeviceType getDevice() {
    return device;
  }

  /**
   * Sets device.
   *
   * @param device the device
   */
  public void setDevice(DeviceType device) {
    this.device = device;
  }

  /**
   * Gets info qualify.
   *
   * @return the info qualify
   */
  public InfoQualifyType getInfoQualify() {
    return infoQualify;
  }

  /**
   * Sets info qualify.
   *
   * @param infoQualify the info qualify
   */
  public void setInfoQualify(InfoQualifyType infoQualify) {
    this.infoQualify = infoQualify;
  }
}
