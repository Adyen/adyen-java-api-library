package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of message. */
public enum MessageType {

  /**
   * Request messageType that requires a response, except if the request messageType mentions
   * explicitely that a response messageType is not expected.
   */
  @Schema(
      description =
          "Request message that requires a response, except if the request message mentions explicitely that a response message is not expected.")
  REQUEST("Request"),

  /** Response messageType, sent to answer to a request messageType. */
  @Schema(description = "Response message, sent to answer to a request message.")
  RESPONSE("Response"),

  /** Unsollicited notification messageType that does not require an answer. */
  @Schema(description = "Unsollicited notification message that does not require an answer.")
  NOTIFICATION("Notification");

  private final String value;

  MessageType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the MessageType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a MessageType from a string value.
   *
   * @param v the string value
   * @return the corresponding MessageType
   */
  @JsonCreator
  public static MessageType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
