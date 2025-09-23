package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of message category. */
public enum MessageCategoryType {

  /** Abort messageType request */
  @Schema(description = "Abort message request")
  ABORT("Abort"),

  /** Admin request or response */
  @Schema(description = "Admin request or response")
  ADMIN("Admin"),

  /** Balance Inquiry request or response */
  @Schema(description = "Balance Inquiry request or response")
  BALANCE_INQUIRY("BalanceInquiry"),

  /** Batch request or response */
  @Schema(description = "Batch request or response")
  BATCH("Batch"),

  /** Card Acquisition request or response */
  @Schema(description = "Card Acquisition request or response")
  CARD_ACQUISITION("CardAcquisition"),

  /** Card Reader APDU request or response */
  @Schema(description = "Card Reader APDU request or response")
  CARD_READER_APDU("CardReaderAPDU"),

  /** Card Reader Init request or response */
  @Schema(description = "Card Reader Init request or response")
  CARD_READER_INIT("CardReaderInit"),

  /** Card Reader Power-Off request or response */
  @Schema(description = "Card Reader Power-Off request or response")
  CARD_READER_POWER_OFF("CardReaderPowerOff"),

  /** Diagnosis request or response */
  @Schema(description = "Diagnosis request or response")
  DIAGNOSIS("Diagnosis"),

  /** Display messageType request or response */
  @Schema(description = "Display message request or response")
  DISPLAY("Display"),

  /** Enable Service messageType request or response */
  @Schema(description = "Enable Service message request or response")
  ENABLE_SERVICE("EnableService"),

  /** Event Notification messageType */
  @Schema(description = "Event Notification message")
  EVENT("Event"),

  /** GetTotals messageType request or response */
  @Schema(description = "GetTotals message request or response")
  GET_TOTALS("GetTotals"),

  /** Input messageType request or response */
  @Schema(description = "Input message request or response")
  INPUT("Input"),

  /** Input Update messageType */
  @Schema(description = "Input Update message")
  INPUT_UPDATE("InputUpdate"),

  /** Login messageType request or response */
  @Schema(description = "Login message request or response")
  LOGIN("Login"),

  /** Logout messageType request or response */
  @Schema(description = "Logout message request or response")
  LOGOUT("Logout"),

  /** Loyalty messageType request or response */
  @Schema(description = "Loyalty message request or response")
  LOYALTY("Loyalty"),

  /** Payment messageType request or response */
  @Schema(description = "Payment message request or response")
  PAYMENT("Payment"),

  /** PIN messageType request or response */
  PIN("PIN"),

  /** Print messageType request or response */
  @Schema(description = "Print message request or response")
  PRINT("Print"),

  /** Reconciliation messageType request or response */
  @Schema(description = "Reconciliation message request or response")
  RECONCILIATION("Reconciliation"),

  /** Reversal messageType request or response */
  @Schema(description = "Reversal message request or response")
  REVERSAL("Reversal"),

  /** Sound messageType request or response */
  @Schema(description = "Sound message request or response")
  SOUND("Sound"),

  /** Stored Value messageType request or response */
  @Schema(description = "Stored Value message request or response")
  STORED_VALUE("StoredValue"),

  /** TransactionStatus messageType request or response */
  @Schema(description = "TransactionStatus message request or response")
  TRANSACTION_STATUS("TransactionStatus"),

  /** Transmit messageType request or response */
  @Schema(description = "Transmit message request or response")
  TRANSMIT("Transmit");

  private final String value;

  MessageCategoryType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the MessageCategoryType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a MessageCategoryType from a string value.
   *
   * @param v the string value
   * @return the corresponding MessageCategoryType
   */
  @JsonCreator
  public static MessageCategoryType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}