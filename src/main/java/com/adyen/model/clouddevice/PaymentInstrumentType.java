package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of payment instrument. */
public enum PaymentInstrumentType {

  /** Payment card (credit or debit). */
  @Schema(description = "Payment card (credit or debit).")
  CARD("Card"),

  /** Paper check. */
  @Schema(description = "Paper check.")
  CHECK("Check"),

  /** Operator account accessed by a mobile phone. */
  @Schema(description = "Operator account accessed by a mobile phone.")
  MOBILE("Mobile"),

  /** Account accesed by a stored value instrument such as a card or a certificate. */
  @Schema(
      description = "Account accesed by a stored value instrument such as a card or a certificate.")
  STORED_VALUE("StoredValue"),

  /** Cash managed by a cash handling system. */
  @Schema(description = "Cash managed by a cash handling system.")
  CASH("Cash");

  private final String value;

  PaymentInstrumentType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the PaymentInstrumentType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a PaymentInstrumentType from a string value.
   *
   * @param v the string value
   * @return the corresponding PaymentInstrumentType
   */
  @JsonCreator
  public static PaymentInstrumentType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
