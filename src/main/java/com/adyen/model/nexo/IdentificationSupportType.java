package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/**
 * Java class for IdentificationSupportType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="IdentificationSupportType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NoCard"/&gt;
 *     &lt;enumeration value="LoyaltyCard"/&gt;
 *     &lt;enumeration value="HybridCard"/&gt;
 *     &lt;enumeration value="LinkedCard"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum IdentificationSupportType {

  /** The identification is not found on a card */
  @SerializedName("NoCard")
  @Schema(description = "The identification is not found on a card")
  NO_CARD("NoCard"),

  /** The identification is on a card dedicated to this loyalty brand. */
  @SerializedName("LoyaltyCard")
  @Schema(description = "The identification is on a card dedicated to this loyalty brand.")
  LOYALTY_CARD("LoyaltyCard"),

  /** The identification is on a card which might be used both for the loyalty and the payment. */
  @SerializedName("HybridCard")
  @Schema(
      description =
          "The identification is on a card which might be used both for the loyalty and the payment.")
  HYBRID_CARD("HybridCard"),

  /**
   * The loyalty account is implicitly attached to the payment card. This is usually detected by the
   * loyalty Acquirer.
   */
  @SerializedName("LinkedCard")
  @Schema(
      description =
          "The loyalty account is implicitly attached to the payment card. This is usually detected by the loyalty Acquirer.")
  LINKED_CARD("LinkedCard");
  private final String value;

  IdentificationSupportType(String v) {
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
   * @return the IdentificationSupportType, or {@code null} if no match is found.
   */
  public static IdentificationSupportType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
