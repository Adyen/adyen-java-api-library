package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;

/** Content of the EventNotification message. */
@JsonPropertyOrder({
    "EventDetails",
    "RejectedMessage",
    "DisplayOutput",
    "TimeStamp",
    "EventToNotify",
    "MaintenanceRequiredFlag",
    "CustomerLanguage"
})
public class EventNotification {

  @JsonProperty("EventDetails")
  @Schema(
      description =
          "Information about the event the POI notifies to the Sale System. --Rule: EventToNotify")
  protected String eventDetails;

  @JsonProperty("RejectedMessage")
  @Schema(
      description =
          "Message request rejected by the receiver. --Rule: Mandatory if EventToNotify is \"Reject\", absent in other cases")
  protected byte[] rejectedMessage;

  @JsonProperty("DisplayOutput")
  @Schema(
      description =
          "Information to display and the way to process the display. --Rule: To display an event message")
  protected DisplayOutput displayOutput;

  @JsonProperty("TimeStamp")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  @Schema(
      description =
          "Date and time of a transaction for the Sale System, the POI System or the Acquirer.")
  protected OffsetDateTime timeStamp;

  @JsonProperty("EventToNotify")
  @Schema(description = "Event the POI notifies to the Sale System.")
  protected EventToNotifyType eventToNotify;

  @JsonProperty("MaintenanceRequiredFlag")
  @Schema(description = "Indicates if the occurred event requires maintenance call or action.")
  protected Boolean maintenanceRequiredFlag;

  @JsonProperty("CustomerLanguage")
  @Schema(description = "Language of the Customer --Rule: EventToNotify")
  protected String customerLanguage;

  /**
   * Gets event details.
   *
   * @return the event details
   */
  public String getEventDetails() {
    return eventDetails;
  }

  /**
   * Sets event details.
   *
   * @param eventDetails the event details
   */
  public void setEventDetails(String eventDetails) {
    this.eventDetails = eventDetails;
  }

  /**
   * Get rejected message.
   *
   * @return the byte [ ]
   */
  public byte[] getRejectedMessage() {
    return rejectedMessage;
  }

  /**
   * Sets rejected message.
   *
   * @param rejectedMessage the rejected message
   */
  public void setRejectedMessage(byte[] rejectedMessage) {
    this.rejectedMessage = rejectedMessage;
  }

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
   * Gets time stamp.
   *
   * @return the time stamp
   */
  public OffsetDateTime getTimeStamp() {
    return timeStamp;
  }

  /**
   * Sets time stamp.
   *
   * @param timeStamp the time stamp
   */
  public void setTimeStamp(OffsetDateTime timeStamp) {
    this.timeStamp = timeStamp;
  }

  /**
   * Gets event to notify.
   *
   * @return the event to notify
   */
  public EventToNotifyType getEventToNotify() {
    return eventToNotify;
  }

  /**
   * Sets event to notify.
   *
   * @param eventToNotify the event to notify
   */
  public void setEventToNotify(EventToNotifyType eventToNotify) {
    this.eventToNotify = eventToNotify;
  }

  /**
   * Is maintenance required flag boolean.
   *
   * @return the boolean
   */
  public boolean isMaintenanceRequiredFlag() {
    if (maintenanceRequiredFlag == null) {
      return false;
    } else {
      return maintenanceRequiredFlag;
    }
  }

  /**
   * Sets maintenance required flag.
   *
   * @param maintenanceRequiredFlag the maintenance required flag
   */
  public void setMaintenanceRequiredFlag(Boolean maintenanceRequiredFlag) {
    this.maintenanceRequiredFlag = maintenanceRequiredFlag;
  }

  /**
   * Gets customer language.
   *
   * @return the customer language
   */
  public String getCustomerLanguage() {
    return customerLanguage;
  }

  /**
   * Sets customer language.
   *
   * @param customerLanguage the customer language
   */
  public void setCustomerLanguage(String customerLanguage) {
    this.customerLanguage = customerLanguage;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventNotification {\n");
    sb.append("    eventDetails: ").append(toIndentedString(eventDetails)).append("\n");
    sb.append("    rejectedMessage: ").append(toIndentedString(rejectedMessage)).append("\n");
    sb.append("    displayOutput: ").append(toIndentedString(displayOutput)).append("\n");
    sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
    sb.append("    eventToNotify: ").append(toIndentedString(eventToNotify)).append("\n");
    sb.append("    maintenanceRequiredFlag: ").append(toIndentedString(maintenanceRequiredFlag)).append("\n");
    sb.append("    customerLanguage: ").append(toIndentedString(customerLanguage)).append("\n");
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