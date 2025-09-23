package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of error condition. */
public enum ErrorConditionType {

  /**
   * The Initiator of the request has sent an Abort messageType request, which was accepted and
   * processed.
   */
  @Schema(
      description =
          "The Initiator of the request has sent an Abort message request, which was accepted and processed.")
  ABORTED("Aborted"),

  /** The system is busy, try later */
  @Schema(description = "The system is busy, try later")
  BUSY("Busy"),

  /** The user has aborted the transaction on the PED keyboard, for instance during PIN entering. */
  @Schema(
      description =
          "The user has aborted the transaction on the PED keyboard, for instance during PIN entering.")
  CANCEL("Cancel"),

  /** Device out of order */
  @Schema(description = "Device out of order")
  DEVICE_OUT("DeviceOut"),

  /**
   * If the Input Device request a NotifyCardInputFlag and the Customer enters a card in the card
   * reader without answers to the Input command, the POI abort the
   */
  @Schema(
      description =
          "If the Input Device request a NotifyCardInputFlag and the Customer enters a card in the card reader without answers to the Input command, the POI abort the")
  INSERTED_CARD("InsertedCard"),

  /** The transaction is still in progress and then the command cannot be processed */
  @Schema(
      description = "The transaction is still in progress and then the command cannot be processed")
  IN_PROGRESS("InProgress"),

  /** Not logged in */
  @Schema(description = "Not logged in")
  LOGGED_OUT("LoggedOut"),

  /**
   * Error on the format of the messageType, AdditionalResponse shall contain the identification of
   * the data, and the reason in clear text.
   */
  @Schema(
      description =
          "Error on the format of the message, AdditionalResponse shall contain the identification of the data, and the reason in clear text.")
  MESSAGE_FORMAT("MessageFormat"),

  /**
   * A service request is sent during a Service dialogue. A combination of services not possible to
   * provide. During the CardReaderInit messageType processing, the user
   */
  @Schema(
      description =
          "A service request is sent during a Service dialogue. A combination of services not possible to provide. During the CardReaderInit message processing, the user")
  NOT_ALLOWED("NotAllowed"),

  /** The transaction is not found (e.g. for a reversal or a repeat) */
  @Schema(description = "The transaction is not found (e.g. for a reversal or a repeat)")
  NOT_FOUND("NotFound"),

  /** Some sale items are not payable by the card proposed by the Customer. */
  @Schema(description = "Some sale items are not payable by the card proposed by the Customer.")
  PAYMENT_RESTRICTION("PaymentRestriction"),

  /**
   * The transaction is refused by the host or the rules associated to the card, and cannot be
   * repeated.
   */
  @Schema(
      description =
          "The transaction is refused by the host or the rules associated to the card, and cannot be repeated.")
  REFUSAL("Refusal"),

  /** The hardware is not available (absent, not configured...) */
  @Schema(description = "The hardware is not available (absent, not configured...)")
  UNAVAILABLE_DEVICE("UnavailableDevice"),

  /** The service is not available (not implemented, not configured, protocol version too old...) */
  @Schema(
      description =
          "The service is not available (not implemented, not configured, protocol version too old...)")
  UNAVAILABLE_SERVICE("UnavailableService"),

  /**
   * The card entered by the Customer cannot be processed by the POI because this card is not
   * configured in the system
   */
  @Schema(
      description =
          "The card entered by the Customer cannot be processed by the POI because this card is not configured in the system")
  INVALID_CARD("InvalidCard"),

  /**
   * Acquirer or any host is unreachable or has not answered to an online request, so is considered
   * as temporary unavailable. Depending on the Sale context, the
   */
  @Schema(
      description =
          "Acquirer or any host is unreachable or has not answered to an online request, so is considered as temporary unavailable. Depending on the Sale context, the")
  UNREACHABLE_HOST("UnreachableHost"),

  /** The user has entered the PIN on the PED keyboard and the verification fails. */
  @Schema(
      description = "The user has entered the PIN on the PED keyboard and the verification fails.")
  WRONG_PIN("WrongPIN");

  private final String value;

  ErrorConditionType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the ErrorConditionType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a ErrorConditionType from a string value.
   *
   * @param v the string value
   * @return the corresponding ErrorConditionType
   */
  @JsonCreator
  public static ErrorConditionType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}