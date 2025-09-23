package com.adyen.model.clouddevice;

import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransmitResponse {

  /** The Response. */
  @JsonProperty("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  /** The Message. */
  @JsonProperty("Message")
  @Schema(description = "Content of a transmitted message.")
  protected byte[] message;

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
   * Gets the value of the messageType property.
   *
   * @return possible object is byte[]
   */
  public byte[] getMessage() {
    return message;
  }

  /**
   * Sets the value of the messageType property.
   *
   * @param value allowed object is byte[]
   */
  public void setMessage(byte[] value) {
    this.message = value;
  }
}
