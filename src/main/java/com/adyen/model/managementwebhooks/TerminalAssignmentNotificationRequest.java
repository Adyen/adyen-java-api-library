/*
 * Management Webhooks
 *
 * The version of the OpenAPI document: 3
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.adyen.model.managementwebhooks;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * TerminalAssignmentNotificationRequest
 */
@JsonPropertyOrder({
  TerminalAssignmentNotificationRequest.JSON_PROPERTY_ASSIGNED_TO_ACCOUNT,
  TerminalAssignmentNotificationRequest.JSON_PROPERTY_ASSIGNED_TO_STORE,
  TerminalAssignmentNotificationRequest.JSON_PROPERTY_EVENT_DATE,
  TerminalAssignmentNotificationRequest.JSON_PROPERTY_PSP_REFERENCE,
  TerminalAssignmentNotificationRequest.JSON_PROPERTY_UNIQUE_TERMINAL_ID
})

public class TerminalAssignmentNotificationRequest {
  public static final String JSON_PROPERTY_ASSIGNED_TO_ACCOUNT = "assignedToAccount";
  private String assignedToAccount;

  public static final String JSON_PROPERTY_ASSIGNED_TO_STORE = "assignedToStore";
  private String assignedToStore;

  public static final String JSON_PROPERTY_EVENT_DATE = "eventDate";
  private String eventDate;

  public static final String JSON_PROPERTY_PSP_REFERENCE = "pspReference";
  private String pspReference;

  public static final String JSON_PROPERTY_UNIQUE_TERMINAL_ID = "uniqueTerminalId";
  private String uniqueTerminalId;

  public TerminalAssignmentNotificationRequest() { 
  }

  /**
   * The unique identifier of the merchant/company account to which the terminal is assigned.
   *
   * @param assignedToAccount
   * @return the current {@code TerminalAssignmentNotificationRequest} instance, allowing for method chaining
   */
  public TerminalAssignmentNotificationRequest assignedToAccount(String assignedToAccount) {
    this.assignedToAccount = assignedToAccount;
    return this;
  }

  /**
   * The unique identifier of the merchant/company account to which the terminal is assigned.
   * @return assignedToAccount
   */
  @ApiModelProperty(required = true, value = "The unique identifier of the merchant/company account to which the terminal is assigned.")
  @JsonProperty(JSON_PROPERTY_ASSIGNED_TO_ACCOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAssignedToAccount() {
    return assignedToAccount;
  }

  /**
   * The unique identifier of the merchant/company account to which the terminal is assigned.
   *
   * @param assignedToAccount
   */ 
  @JsonProperty(JSON_PROPERTY_ASSIGNED_TO_ACCOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAssignedToAccount(String assignedToAccount) {
    this.assignedToAccount = assignedToAccount;
  }

  /**
   * The unique identifier of the store to which the terminal is assigned.
   *
   * @param assignedToStore
   * @return the current {@code TerminalAssignmentNotificationRequest} instance, allowing for method chaining
   */
  public TerminalAssignmentNotificationRequest assignedToStore(String assignedToStore) {
    this.assignedToStore = assignedToStore;
    return this;
  }

  /**
   * The unique identifier of the store to which the terminal is assigned.
   * @return assignedToStore
   */
  @ApiModelProperty(value = "The unique identifier of the store to which the terminal is assigned.")
  @JsonProperty(JSON_PROPERTY_ASSIGNED_TO_STORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAssignedToStore() {
    return assignedToStore;
  }

  /**
   * The unique identifier of the store to which the terminal is assigned.
   *
   * @param assignedToStore
   */ 
  @JsonProperty(JSON_PROPERTY_ASSIGNED_TO_STORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAssignedToStore(String assignedToStore) {
    this.assignedToStore = assignedToStore;
  }

  /**
   * The date and time when an event has been completed.
   *
   * @param eventDate
   * @return the current {@code TerminalAssignmentNotificationRequest} instance, allowing for method chaining
   */
  public TerminalAssignmentNotificationRequest eventDate(String eventDate) {
    this.eventDate = eventDate;
    return this;
  }

  /**
   * The date and time when an event has been completed.
   * @return eventDate
   */
  @ApiModelProperty(required = true, value = "The date and time when an event has been completed.")
  @JsonProperty(JSON_PROPERTY_EVENT_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getEventDate() {
    return eventDate;
  }

  /**
   * The date and time when an event has been completed.
   *
   * @param eventDate
   */ 
  @JsonProperty(JSON_PROPERTY_EVENT_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEventDate(String eventDate) {
    this.eventDate = eventDate;
  }

  /**
   * The PSP reference of the request from which the notification originates.
   *
   * @param pspReference
   * @return the current {@code TerminalAssignmentNotificationRequest} instance, allowing for method chaining
   */
  public TerminalAssignmentNotificationRequest pspReference(String pspReference) {
    this.pspReference = pspReference;
    return this;
  }

  /**
   * The PSP reference of the request from which the notification originates.
   * @return pspReference
   */
  @ApiModelProperty(required = true, value = "The PSP reference of the request from which the notification originates.")
  @JsonProperty(JSON_PROPERTY_PSP_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPspReference() {
    return pspReference;
  }

  /**
   * The PSP reference of the request from which the notification originates.
   *
   * @param pspReference
   */ 
  @JsonProperty(JSON_PROPERTY_PSP_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPspReference(String pspReference) {
    this.pspReference = pspReference;
  }

  /**
   * The unique identifier of the terminal.
   *
   * @param uniqueTerminalId
   * @return the current {@code TerminalAssignmentNotificationRequest} instance, allowing for method chaining
   */
  public TerminalAssignmentNotificationRequest uniqueTerminalId(String uniqueTerminalId) {
    this.uniqueTerminalId = uniqueTerminalId;
    return this;
  }

  /**
   * The unique identifier of the terminal.
   * @return uniqueTerminalId
   */
  @ApiModelProperty(required = true, value = "The unique identifier of the terminal.")
  @JsonProperty(JSON_PROPERTY_UNIQUE_TERMINAL_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getUniqueTerminalId() {
    return uniqueTerminalId;
  }

  /**
   * The unique identifier of the terminal.
   *
   * @param uniqueTerminalId
   */ 
  @JsonProperty(JSON_PROPERTY_UNIQUE_TERMINAL_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUniqueTerminalId(String uniqueTerminalId) {
    this.uniqueTerminalId = uniqueTerminalId;
  }

  /**
   * Return true if this TerminalAssignmentNotificationRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TerminalAssignmentNotificationRequest terminalAssignmentNotificationRequest = (TerminalAssignmentNotificationRequest) o;
    return Objects.equals(this.assignedToAccount, terminalAssignmentNotificationRequest.assignedToAccount) &&
        Objects.equals(this.assignedToStore, terminalAssignmentNotificationRequest.assignedToStore) &&
        Objects.equals(this.eventDate, terminalAssignmentNotificationRequest.eventDate) &&
        Objects.equals(this.pspReference, terminalAssignmentNotificationRequest.pspReference) &&
        Objects.equals(this.uniqueTerminalId, terminalAssignmentNotificationRequest.uniqueTerminalId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assignedToAccount, assignedToStore, eventDate, pspReference, uniqueTerminalId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TerminalAssignmentNotificationRequest {\n");
    sb.append("    assignedToAccount: ").append(toIndentedString(assignedToAccount)).append("\n");
    sb.append("    assignedToStore: ").append(toIndentedString(assignedToStore)).append("\n");
    sb.append("    eventDate: ").append(toIndentedString(eventDate)).append("\n");
    sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
    sb.append("    uniqueTerminalId: ").append(toIndentedString(uniqueTerminalId)).append("\n");
    sb.append("}");
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

/**
   * Create an instance of TerminalAssignmentNotificationRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of TerminalAssignmentNotificationRequest
   * @throws JsonProcessingException if the JSON string is invalid with respect to TerminalAssignmentNotificationRequest
   */
  public static TerminalAssignmentNotificationRequest fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, TerminalAssignmentNotificationRequest.class);
  }
/**
  * Convert an instance of TerminalAssignmentNotificationRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}