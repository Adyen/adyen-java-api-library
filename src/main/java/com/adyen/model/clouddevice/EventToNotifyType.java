package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of event to notify. */
public enum EventToNotifyType {

  /** Begin of POI Maintenance */
  @Schema(description = "Begin of POI Maintenance")
  BEGIN_MAINTENANCE("BeginMaintenance"),

  /** End of POI Maintenance */
  @Schema(description = "End of POI Maintenance")
  END_MAINTENANCE("EndMaintenance"),

  /** The POI Terminal or the POI System is shutting down */
  @Schema(description = "The POI Terminal or the POI System is shutting down")
  SHUTDOWN("Shutdown"),

  /** The POI Terminal or the POI System is now ready to work */
  @Schema(description = "The POI Terminal or the POI System is now ready to work")
  INITIALISED("Initialised"),

  /** The POI Terminal or the POI System cannot work */
  @Schema(description = "The POI Terminal or the POI System cannot work")
  OUT_OF_ORDER("OutOfOrder"),

  /** An Abort request has been sent to abort a messageType which is already completed. */
  @Schema(
      description = "An Abort request has been sent to abort a message which is already completed.")
  COMPLETED("Completed"),

  /**
   * One or several device request has been sent by the POI during the processing of a service
   * requested by the Sale System. The processing is cancelled by the
   */
  @Schema(
      description =
          "One or several device request has been sent by the POI during the processing of a service requested by the Sale System. The processing is cancelled by the")
  ABORT("Abort"),

  /**
   * A POI terminal requests the payment of the transaction identified by the content of
   * EventDetails in the Event notification.
   */
  @Schema(
      description =
          "A POI terminal requests the payment of the transaction identified by the content of EventDetails in the Event notification.")
  SALE_WAKE_UP("SaleWakeUp"),

  /**
   * The POI has performed, or want to perform an automatic administrative process, e.g. the reports
   * at the end of day.
   */
  @Schema(
      description =
          "The POI has performed, or want to perform an automatic administrative process, e.g. the reports at the end of day.")
  SALE_ADMIN("SaleAdmin"),

  /** The customer has selected a different language on the POI. */
  @Schema(description = "The customer has selected a different language on the POI.")
  CUSTOMER_LANGUAGE("CustomerLanguage"),

  /** The customer has pressed a specific key on the POI. */
  @Schema(description = "The customer has pressed a specific key on the POI.")
  KEY_PRESSED("KeyPressed"),

  /** Problem of security */
  @Schema(description = "Problem of security")
  SECURITY_ALARM("SecurityAlarm"),

  /** When the Customer assistance is stopped, because the Customer has completed its input. */
  @Schema(
      description =
          "When the Customer assistance is stopped, because the Customer has completed its input.")
  STOP_ASSISTANCE("StopAssistance"),

  /** A card is inserted in the card reader (see Input request and NotifyCardInputFlag) */
  @Schema(
      description =
          "A card is inserted in the card reader (see Input request and NotifyCardInputFlag)")
  CARD_INSERTED("CardInserted"),

  /** A card is removed from the card reader. */
  @Schema(description = "A card is removed from the card reader.")
  CARD_REMOVED("CardRemoved"),

  /**
   * A messageType request is rejected. An error explanation and the messageType in error have to be
   * put in the EventDetails data element.
   */
  @Schema(
      description =
          "A message request is rejected. An error explanation and the message in error have to be put in the EventDetails data element.")
  REJECT("Reject"),

  /** The terminal has established a network connection to the POS and is online. */
  @Schema(description = "The terminal is connected to the POS over the Internet.")
  NETWORK_CONNECTED("NetworkConnected"),

  /** The terminal has lost its network connection to the POS and is offline. */
  @Schema(description = "The terminal is disconnected from the POS.")
  NETWORK_DISCONNECTED("NetworkDisconnected"),

  /** Delivers the result (or timeout failure) of the Barcode scan. */
  @Schema(description = "Delivers the result (or timeout failure) of the Barcode scan.")
  SCAN_BARCODE_RESULT("ScanBarcodeResult");

  private final String value;

  EventToNotifyType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the EventToNotifyType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a EventToNotifyType from a string value.
   *
   * @param v the string value
   * @return the corresponding EventToNotifyType
   */
  @JsonCreator
  public static EventToNotifyType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
