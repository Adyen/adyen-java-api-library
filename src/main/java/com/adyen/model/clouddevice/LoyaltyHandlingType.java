package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of loyalty handling. */
public enum LoyaltyHandlingType {

  /**
   * No loyalty card to read and loyalty transaction to process. Any attempt to enter a pure loyalty
   * card is rejected.
   */
  @Schema(
      description =
          "No loyalty card to read and loyalty transaction to process. Any attempt to enter a pure loyalty card is rejected.")
  FORBIDDEN("Forbidden"),

  /**
   * The loyalty transaction is already processed, no loyalty card or loyalty transaction to
   * process.
   */
  @Schema(
      description =
          "The loyalty transaction is already processed, no loyalty card or loyalty transaction to process.")
  PROCESSED("Processed"),

  /**
   * The loyalty is accepted, but the POI has not to require or ask a loyalty card. The loyalty is
   * involved by the payment card (e.g. an hybrid or linked card).
   */
  @Schema(
      description =
          "The loyalty is accepted, but the POI has not to require or ask a loyalty card. The loyalty is involved by the payment card (e.g. an hybrid or linked card).")
  ALLOWED("Allowed"),

  /**
   * The loyalty is accepted, and the POI has to ask a loyalty card. If the Customer does not enter
   * a loyalty card, no loyalty transaction is realised.
   */
  @Schema(
      description =
          "The loyalty is accepted, and the POI has to ask a loyalty card. If the Customer does not enter a loyalty card, no loyalty transaction is realised.")
  PROPOSED("Proposed"),

  /**
   * The loyalty is required, and the POI refuses the processing of the messageType request if the
   * cardholder does not entre a loyalty card
   */
  @Schema(
      description =
          "The loyalty is required, and the POI refuses the processing of the message request if the cardholder does not entre a loyalty card")
  REQUIRED("Required");

  private final String value;

  LoyaltyHandlingType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the LoyaltyHandlingType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a LoyaltyHandlingType from a string value.
   *
   * @param v the string value
   * @return the corresponding LoyaltyHandlingType
   */
  @JsonCreator
  public static LoyaltyHandlingType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
