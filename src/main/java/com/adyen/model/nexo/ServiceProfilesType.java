package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/**
 * Java class for ServiceProfilesType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="ServiceProfilesType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Synchro"/&gt;
 *     &lt;enumeration value="Batch"/&gt;
 *     &lt;enumeration value="OneTimeRes"/&gt;
 *     &lt;enumeration value="Reservation"/&gt;
 *     &lt;enumeration value="Loyalty"/&gt;
 *     &lt;enumeration value="StoredValue"/&gt;
 *     &lt;enumeration value="PIN"/&gt;
 *     &lt;enumeration value="CardReader"/&gt;
 *     &lt;enumeration value="Sound"/&gt;
 *     &lt;enumeration value="Communication"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum ServiceProfilesType {

  /** CardAcquisition and EnableService could be requested by the Sale System to the POI System. */
  @SerializedName("Synchro")
  @Schema(
      description =
          "CardAcquisition and EnableService could be requested by the Sale System to the POI System.")
  SYNCHRO("Synchro"),

  /**
   * When the POI is unable to perform transactions without the Sale system, e.g. payment at
   * delivery, the POI provides in a Batch the performed transactions, and
   */
  @SerializedName("Batch")
  @Schema(
      description =
          "When the POI is unable to perform transactions without the Sale system, e.g. payment at delivery, the POI provides in a Batch the performed transactions, and")
  BATCH("Batch"),

  /** One Time Reservation service could be requested by the Sale System (as petrol distribution) */
  @SerializedName("OneTimeRes")
  @Schema(
      description =
          "One Time Reservation service could be requested by the Sale System (as petrol distribution)")
  ONE_TIME_RES("OneTimeRes"),

  /** The Reservation services could be requested by the Sale System */
  @SerializedName("Reservation")
  @Schema(description = "The Reservation services could be requested by the Sale System")
  RESERVATION("Reservation"),

  /** Loyalty services could be requested by the Sale System */
  @SerializedName("Loyalty")
  @Schema(description = "Loyalty services could be requested by the Sale System")
  LOYALTY("Loyalty"),

  /** Stored Value service could be requested by the Sale System */
  @SerializedName("StoredValue")
  @Schema(description = "Stored Value service could be requested by the Sale System")
  STORED_VALUE("StoredValue"),

  /** The Sale System could request the PIN validation services. */
  PIN("PIN"),

  /** The Sale System could request Card Reader services. */
  @SerializedName("CardReader")
  @Schema(description = "The Sale System could request Card Reader services.")
  CARD_READER("CardReader"),

  /** To produce various forms of sounds to a customer or an operator interface. */
  @SerializedName("Sound")
  @Schema(
      description = "To produce various forms of sounds to a customer or an operator interface.")
  SOUND("Sound"),

  /**
   * The POI or Sale System could request communication through the Transmit device messages
   * exchange.
   */
  @SerializedName("Communication")
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
  public String value() {
    return value;
  }

  public static ServiceProfilesType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
