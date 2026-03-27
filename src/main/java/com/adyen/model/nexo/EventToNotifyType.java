package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/**
 * Java class for EventToNotifyType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="EventToNotifyType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="BeginMaintenance"/&gt;
 *     &lt;enumeration value="EndMaintenance"/&gt;
 *     &lt;enumeration value="Shutdown"/&gt;
 *     &lt;enumeration value="Initialised"/&gt;
 *     &lt;enumeration value="OutOfOrder"/&gt;
 *     &lt;enumeration value="Completed"/&gt;
 *     &lt;enumeration value="Abort"/&gt;
 *     &lt;enumeration value="SaleWakeUp"/&gt;
 *     &lt;enumeration value="SaleAdmin"/&gt;
 *     &lt;enumeration value="CustomerLanguage"/&gt;
 *     &lt;enumeration value="KeyPressed"/&gt;
 *     &lt;enumeration value="SecurityAlarm"/&gt;
 *     &lt;enumeration value="StopAssistance"/&gt;
 *     &lt;enumeration value="CardInserted"/&gt;
 *     &lt;enumeration value="CardRemoved"/&gt;
 *     &lt;enumeration value="Reject"/&gt;
 *     &lt;enumeration value="NetworkConnected"/&gt;
 *     &lt;enumeration value="NetworkDisconnected"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum EventToNotifyType {

  /** Begin of POI Maintenance */
  @SerializedName("BeginMaintenance")
  @Schema(description = "Begin of POI Maintenance")
  BEGIN_MAINTENANCE("BeginMaintenance"),

  /** End of POI Maintenance */
  @SerializedName("EndMaintenance")
  @Schema(description = "End of POI Maintenance")
  END_MAINTENANCE("EndMaintenance"),

  /** The POI Terminal or the POI System is shutting down */
  @SerializedName("Shutdown")
  @Schema(description = "The POI Terminal or the POI System is shutting down")
  SHUTDOWN("Shutdown"),

  /** The POI Terminal or the POI System is now ready to work */
  @SerializedName("Initialised")
  @Schema(description = "The POI Terminal or the POI System is now ready to work")
  INITIALISED("Initialised"),

  /** The POI Terminal or the POI System cannot work */
  @SerializedName("OutOfOrder")
  @Schema(description = "The POI Terminal or the POI System cannot work")
  OUT_OF_ORDER("OutOfOrder"),

  /** An Abort request has been sent to abort a messageType which is already completed. */
  @SerializedName("Completed")
  @Schema(
      description = "An Abort request has been sent to abort a message which is already completed.")
  COMPLETED("Completed"),

  /**
   * One or several device request has been sent by the POI during the processing of a service
   * requested by the Sale System. The processing is cancelled by the
   */
  @SerializedName("Abort")
  @Schema(
      description =
          "One or several device request has been sent by the POI during the processing of a service requested by the Sale System. The processing is cancelled by the")
  ABORT("Abort"),

  /**
   * A POI terminal requests the payment of the transaction identified by the content of
   * EventDetails in the Event notification.
   */
  @SerializedName("SaleWakeUp")
  @Schema(
      description =
          "A POI terminal requests the payment of the transaction identified by the content of EventDetails in the Event notification.")
  SALE_WAKE_UP("SaleWakeUp"),

  /**
   * The POI has performed, or want to perform an automatic administrative process, e.g. the reports
   * at the end of day.
   */
  @SerializedName("SaleAdmin")
  @Schema(
      description =
          "The POI has performed, or want to perform an automatic administrative process, e.g. the reports at the end of day.")
  SALE_ADMIN("SaleAdmin"),

  /** The customer has selected a different language on the POI. */
  @SerializedName("CustomerLanguage")
  @Schema(description = "The customer has selected a different language on the POI.")
  CUSTOMER_LANGUAGE("CustomerLanguage"),

  /** The customer has pressed a specific key on the POI. */
  @SerializedName("KeyPressed")
  @Schema(description = "The customer has pressed a specific key on the POI.")
  KEY_PRESSED("KeyPressed"),

  /** Problem of security */
  @SerializedName("SecurityAlarm")
  @Schema(description = "Problem of security")
  SECURITY_ALARM("SecurityAlarm"),

  /** When the Customer assistance is stopped, because the Customer has completed its input. */
  @SerializedName("StopAssistance")
  @Schema(
      description =
          "When the Customer assistance is stopped, because the Customer has completed its input.")
  STOP_ASSISTANCE("StopAssistance"),

  /** A card is inserted in the card reader (see Input request and NotifyCardInputFlag) */
  @SerializedName("CardInserted")
  @Schema(
      description =
          "A card is inserted in the card reader (see Input request and NotifyCardInputFlag)")
  CARD_INSERTED("CardInserted"),

  /** A card is removed from the card reader. */
  @SerializedName("CardRemoved")
  @Schema(description = "A card is removed from the card reader.")
  CARD_REMOVED("CardRemoved"),

  /**
   * A messageType request is rejected. An error explanation and the messageType in error have to be
   * put in the EventDetails data element.
   */
  @SerializedName("Reject")
  @Schema(
      description =
          "A message request is rejected. An error explanation and the message in error have to be put in the EventDetails data element.")
  REJECT("Reject"),

  /** The terminal has established a network connection to the POS and is online. */
  @SerializedName("NetworkConnected")
  @Schema(description = "The terminal is connected to the POS over the Internet.")
  NETWORK_CONNECTED("NetworkConnected"),

  /** The terminal has lost its network connection to the POS and is offline. */
  @SerializedName("NetworkDisconnected")
  @Schema(description = "The terminal is disconnected from the POS.")
  NETWORK_DISCONNECTED("NetworkDisconnected"),

  /** Delivers the result (or timeout failure) of the Barcode scan. */
  @SerializedName("ScanBarcodeResult")
  @Schema(description = "Delivers the result (or timeout failure) of the Barcode scan.")
  SCAN_BARCODE_RESULT("ScanBarcodeResult");

  private final String value;

  EventToNotifyType(String v) {
    value = v;
  }

  /**
   * Value string.
   *
   * @return the string
   */
  public String value() {
    return value;
  }

  /**
   * Returns the enum constant matching the given string, or {@code null} if no match is found.
   *
   * @param v string value
   * @return the EventToNotifyType, or {@code null} if no match is found.
   */
  public static EventToNotifyType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
