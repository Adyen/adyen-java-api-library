package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of identification. */
public enum IdentificationType {

  /** Standard card identification (card number) */
  PAN("PAN"),

  /** ISO Track 2 including identification. */
  @Schema(description = "ISO Track 2 including identification.")
  ISO_TRACK_2("ISOTrack2"),

  /** Bar-code with a specific form of identification */
  @Schema(description = "Bar-code with a specific form of identification")
  BAR_CODE("BarCode"),

  /** Account number */
  @Schema(description = "Account number")
  ACCOUNT_NUMBER("AccountNumber"),

  /** A phone number identifies the account on which the phone card is assigned. */
  @Schema(
      description = "A phone number identifies the account on which the phone card is assigned.")
  PHONE_NUMBER("PhoneNumber");

  private final String value;

  IdentificationType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the IdentificationType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a IdentificationType from a string value.
   *
   * @param v the string value
   * @return the corresponding IdentificationType
   */
  @JsonCreator
  public static IdentificationType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
