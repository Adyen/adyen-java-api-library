package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class TransactionStatusResponse {

  /** The Response. */
  @JsonProperty("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  /** The Message reference. */
  @JsonProperty("MessageReference")
  @Schema(
      description =
          "Identification of a previous POI transaction. --Rule: if Response.Result is Success")
  protected MessageReference messageReference;

  /** The Repeated message response. */
  @JsonProperty("RepeatedMessageResponse")
  @Schema(
      description =
          "Content of the requested Message Response. --Rule: If Result is Success (process completed)")
  protected RepeatedMessageResponse repeatedMessageResponse;

  /**
   * Gets the value of the response property.
   *
   * @return possible object is {@link Response }
   */
  public Response getResponse() {
    return response;
  }

  /**
   * Sets the value of the response property.
   *
   * @param value allowed object is {@link Response }
   */
  public void setResponse(Response value) {
    this.response = value;
  }

  /**
   * Gets the value of the messageReference property.
   *
   * @return possible object is {@link MessageReference }
   */
  public MessageReference getMessageReference() {
    return messageReference;
  }

  /**
   * Sets the value of the messageReference property.
   *
   * @param value allowed object is {@link MessageReference }
   */
  public void setMessageReference(MessageReference value) {
    this.messageReference = value;
  }

  /**
   * Gets the value of the repeatedMessageResponse property.
   *
   * @return possible object is {@link RepeatedMessageResponse }
   */
  public RepeatedMessageResponse getRepeatedMessageResponse() {
    return repeatedMessageResponse;
  }

  /**
   * Sets the value of the repeatedMessageResponse property.
   *
   * @param value allowed object is {@link RepeatedMessageResponse }
   */
  public void setRepeatedMessageResponse(RepeatedMessageResponse value) {
    this.repeatedMessageResponse = value;
  }
}
