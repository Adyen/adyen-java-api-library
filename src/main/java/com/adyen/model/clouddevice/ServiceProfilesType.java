package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

public enum ServiceProfilesType {

  /** CardAcquisition and EnableService could be requested by the Sale System to the POI System. */
  @Schema(
      description =
          "CardAcquisition and EnableService could be requested by the Sale System to the POI System.")
  SYNCHRO("Synchro"),

  /**
   * When the POI is unable to perform transactions without the Sale system, e.g. payment at
   * delivery, the POI provides in a Batch the performed transactions, and
   */
  @Schema(
      description =
          "When the POI is unable to perform transactions without the Sale system, e.g. payment at delivery, the POI provides in a Batch the performed transactions, and")
  BATCH("Batch"),

  /** One Time Reservation service could be requested by the Sale System (as petrol distribution) */
  @Schema(
      description =
          "One Time Reservation service could be requested by the Sale System (as petrol distribution)")
  ONE_TIME_RES("OneTimeRes"),

  /** The Reservation services could be requested by the Sale System */
  @Schema(description = "The Reservation services could be requested by the Sale System")
  RESERVATION("Reservation"),

  /** Loyalty services could be requested by the Sale System */
  @Schema(description = "Loyalty services could be requested by the Sale System")
  LOYALTY("Loyalty"),

  /** Stored Value service could be requested by the Sale System */
  @Schema(description = "Stored Value service could be requested by the Sale System")
  STORED_VALUE("StoredValue"),

  /** The Sale System could request the PIN validation services. */
  PIN("PIN"),

  /** The Sale System could request Card Reader services. */
  @Schema(description = "The Sale System could request Card Reader services.")
  CARD_READER("CardReader"),

  /** To produce various forms of sounds to a customer or an operator interface. */
  @Schema(
      description = "To produce various forms of sounds to a customer or an operator interface.")
  SOUND("Sound"),

  /**
   * The POI or Sale System could request communication through the Transmit device messages
   * exchange.
   */
  @Schema(
      description =
          "The POI or Sale System could request communication through the Transmit device messages exchange.")
  COMMUNICATION("Communication");
  private final String value;

  ServiceProfilesType(String v) {
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

  @JsonCreator
  public static ServiceProfilesType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
