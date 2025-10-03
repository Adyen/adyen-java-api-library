package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: Body of the Abort Request messageType. -- Usage: It conveys Information requested for
 * identification of the messageType request carrying the transaction to abort. A messageType to
 * display on the CustomerError Device could be sent by the Sale System (DisplayOutput).
 */
public class AbortRequest {

  @JsonProperty("MessageReference")
  @Schema(description = "Identification of a previous POI transaction.")
  protected MessageReference messageReference;

  @JsonProperty("AbortReason")
  @Schema(description = "Reason of aborting a transaction")
  protected String abortReason;

  @JsonProperty("DisplayOutput")
  @Schema(
      description =
          "Information to display and the way to process the display. --Rule: To display an abort message to the Customer")
  protected DisplayOutput displayOutput;

  /**
   * Gets the message reference.
   *
   * @return the message reference
   */
  public MessageReference getMessageReference() {
    return messageReference;
  }

  /**
   * Sets the message reference.
   *
   * @param value the message reference
   */
  public void setMessageReference(MessageReference value) {
    this.messageReference = value;
  }

  /**
   * Gets the abort reason.
   *
   * @return the abort reason
   */
  public String getAbortReason() {
    return abortReason;
  }

  /**
   * Sets the abort reason.
   *
   * @param value the abort reason
   */
  public void setAbortReason(String value) {
    this.abortReason = value;
  }

  /**
   * Gets the display output.
   *
   * @return the display output
   */
  public DisplayOutput getDisplayOutput() {
    return displayOutput;
  }

  /**
   * Sets the display output.
   *
   * @param value the display output
   */
  public void setDisplayOutput(DisplayOutput value) {
    this.displayOutput = value;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AbortRequest {\n");
    sb.append("    messageReference: ").append(toIndentedString(messageReference)).append("\n");
    sb.append("    abortReason: ").append(toIndentedString(abortReason)).append("\n");
    sb.append("    displayOutput: ").append(toIndentedString(displayOutput)).append("\n");
    sb.append("}\n");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
