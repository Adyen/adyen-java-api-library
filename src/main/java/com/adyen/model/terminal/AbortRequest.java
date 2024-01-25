/*
 * Adyen Terminal API
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.adyen.model.terminal;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.adyen.model.terminal.DisplayOutput;
import com.adyen.model.terminal.MessageReference;
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
 * It conveys Information requested for identification of the message request carrying the transaction to abort. A message to display on the CustomerError Device could be sent by the Sale System (DisplayOutput). Body of the Abort Request message.
 */
@ApiModel(description = "It conveys Information requested for identification of the message request carrying the transaction to abort. A message to display on the CustomerError Device could be sent by the Sale System (DisplayOutput). Body of the Abort Request message.")
@JsonPropertyOrder({
  AbortRequest.JSON_PROPERTY_MESSAGE_REFERENCE,
  AbortRequest.JSON_PROPERTY_ABORT_REASON,
  AbortRequest.JSON_PROPERTY_DISPLAY_OUTPUT
})

public class AbortRequest {
  public static final String JSON_PROPERTY_MESSAGE_REFERENCE = "MessageReference";
  private MessageReference messageReference;

  public static final String JSON_PROPERTY_ABORT_REASON = "AbortReason";
  private String abortReason;

  public static final String JSON_PROPERTY_DISPLAY_OUTPUT = "DisplayOutput";
  private DisplayOutput displayOutput;

  public AbortRequest() { 
  }

  public AbortRequest messageReference(MessageReference messageReference) {
    this.messageReference = messageReference;
    return this;
  }

   /**
   * Get messageReference
   * @return messageReference
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_MESSAGE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MessageReference getMessageReference() {
    return messageReference;
  }


 /**
  * messageReference
  *
  * @param messageReference
  */ 
  @JsonProperty(JSON_PROPERTY_MESSAGE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMessageReference(MessageReference messageReference) {
    this.messageReference = messageReference;
  }


  public AbortRequest abortReason(String abortReason) {
    this.abortReason = abortReason;
    return this;
  }

   /**
   * Reason of aborting a transaction.
   * @return abortReason
  **/
  @ApiModelProperty(required = true, value = "Reason of aborting a transaction.")
  @JsonProperty(JSON_PROPERTY_ABORT_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAbortReason() {
    return abortReason;
  }


 /**
  * Reason of aborting a transaction.
  *
  * @param abortReason
  */ 
  @JsonProperty(JSON_PROPERTY_ABORT_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAbortReason(String abortReason) {
    this.abortReason = abortReason;
  }


  public AbortRequest displayOutput(DisplayOutput displayOutput) {
    this.displayOutput = displayOutput;
    return this;
  }

   /**
   * Get displayOutput
   * @return displayOutput
  **/
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DISPLAY_OUTPUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public DisplayOutput getDisplayOutput() {
    return displayOutput;
  }


 /**
  * displayOutput
  *
  * @param displayOutput
  */ 
  @JsonProperty(JSON_PROPERTY_DISPLAY_OUTPUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplayOutput(DisplayOutput displayOutput) {
    this.displayOutput = displayOutput;
  }


  /**
   * Return true if this AbortRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbortRequest abortRequest = (AbortRequest) o;
    return Objects.equals(this.messageReference, abortRequest.messageReference) &&
        Objects.equals(this.abortReason, abortRequest.abortReason) &&
        Objects.equals(this.displayOutput, abortRequest.displayOutput);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageReference, abortReason, displayOutput);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AbortRequest {\n");
    sb.append("    messageReference: ").append(toIndentedString(messageReference)).append("\n");
    sb.append("    abortReason: ").append(toIndentedString(abortReason)).append("\n");
    sb.append("    displayOutput: ").append(toIndentedString(displayOutput)).append("\n");
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
   * Create an instance of AbortRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of AbortRequest
   * @throws JsonProcessingException if the JSON string is invalid with respect to AbortRequest
   */
  public static AbortRequest fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, AbortRequest.class);
  }
/**
  * Convert an instance of AbortRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
