package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of identification support. */
public enum IdentificationSupportType {

  /** The identification is not found on a card */
  @Schema(description = "The identification is not found on a card")
  NO_CARD("NoCard"),

  /** The identification is on a card dedicated to this loyalty brand. */
  @Schema(description = "The identification is on a card dedicated to this loyalty brand.")
  LOYALTY_CARD("LoyaltyCard"),

  /** The identification is on a card which might be used both for the loyalty and the payment. */
  @Schema(
      description =
          "The identification is on a card which might be used both for the loyalty and the payment.")
  HYBRID_CARD("HybridCard"),

  /**
   * The loyalty account is implicitly attached to the payment card. This is usually detected by the
   * loyalty Acquirer.
   */
  @Schema(
      description =
          "The loyalty account is implicitly attached to the payment card. This is usually detected by the loyalty Acquirer.")
  LINKED_CARD("LinkedCard");

  private final String value;

  IdentificationSupportType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the IdentificationSupportType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a IdentificationSupportType from a string value.
   *
   * @param v the string value
   * @return the corresponding IdentificationSupportType
   */
  @JsonCreator
  public static IdentificationSupportType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
