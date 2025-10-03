package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

public enum TransactionActionType {

  /** Start a transaction by a swipe ahead mechanism, with the services which are enabled. */
  @Schema(
      description =
          "Start a transaction by a swipe ahead mechanism, with the services which are enabled.")
  START_TRANSACTION("StartTransaction"),

  /**
   * Abort a transaction started either by a CardAcquisition or EnableService with TransactionAction
   * to "StartTransaction", not followed by a service request from
   */
  @Schema(
      description =
          "Abort a transaction started either by a CardAcquisition or EnableService with TransactionAction to \"StartTransaction\", not followed by a service request from")
  ABORT_TRANSACTION("AbortTransaction");
  private final String value;

  TransactionActionType(String v) {
    value = v;
  }

  /**
   * Value string.
   *
   * @return the string
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Returns the enum constant matching the given string, or {@code null} if no match is found.
   *
   * @param v string value
   * @return the TransactionActionType, or {@code null} if no match is found.
   */
  @JsonCreator
  public static TransactionActionType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
