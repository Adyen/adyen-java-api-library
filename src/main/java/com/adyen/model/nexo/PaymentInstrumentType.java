package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/**
 * Java class for PaymentInstrumentType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="PaymentInstrumentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Card"/&gt;
 *     &lt;enumeration value="Check"/&gt;
 *     &lt;enumeration value="Mobile"/&gt;
 *     &lt;enumeration value="StoredValue"/&gt;
 *     &lt;enumeration value="Cash"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum PaymentInstrumentType {

  /** Payment card (credit or debit). */
  @SerializedName("Card")
  @Schema(description = "Payment card (credit or debit).")
  CARD("Card"),

  /** Paper check. */
  @SerializedName("Check")
  @Schema(description = "Paper check.")
  CHECK("Check"),

  /** Operator account accessed by a mobile phone. */
  @SerializedName("Mobile")
  @Schema(description = "Operator account accessed by a mobile phone.")
  MOBILE("Mobile"),

  /** Account accesed by a stored value instrument such as a card or a certificate. */
  @SerializedName("StoredValue")
  @Schema(
      description = "Account accesed by a stored value instrument such as a card or a certificate.")
  STORED_VALUE("StoredValue"),

  /** Cash managed by a cash handling system. */
  @SerializedName("Cash")
  @Schema(description = "Cash managed by a cash handling system.")
  CASH("Cash");
  private final String value;

  PaymentInstrumentType(String v) {
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
   * @return the PaymentInstrumentType, or {@code null} if no match is found.
   */
  public static PaymentInstrumentType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
