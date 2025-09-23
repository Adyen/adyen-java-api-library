package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Information related to the result the output (display, print, input). */
@JsonPropertyOrder({"Response", "Device", "InfoQualify"})
public class OutputResult {

  @JsonProperty("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  @JsonProperty("Device")
  @Schema(
      description =
          "Logical device located on a Sale Terminal or a POI Terminal, in term of class of information to output (display, print --Rule: Copy")
  protected DeviceType device;

  @JsonProperty("InfoQualify")
  @Schema(
      description =
          "Qualification of the information to sent to an output logical device, to display or print to the Cashier or the --Rule: Copy")
  protected InfoQualifyType infoQualify;

  /**
   * Gets response.
   *
   * @return the response
   */
  public Response getResponse() {
    return response;
  }

  /**
   * Sets response.
   *
   * @param response the response
   */
  public void setResponse(Response response) {
    this.response = response;
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