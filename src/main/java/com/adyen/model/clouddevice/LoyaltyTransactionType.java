package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of loyalty transaction. */
public enum LoyaltyTransactionType {

  /**
   * Direct or payment related award on a loyalty account. Award alone, award associated to a
   * payment (may be with an additional award alone), award because of a
   */
  @Schema(
      description =
          "Direct or payment related award on a loyalty account. Award alone, award associated to a payment (may be with an additional award alone), award because of a")
  AWARD("Award"),

  /** Rebate on a total amount, sale item amount, or sale items */
  @Schema(description = "Rebate on a total amount, sale item amount, or sale items")
  REBATE("Rebate"),

  /** Redemption on a loyalty account. */
  @Schema(description = "Redemption on a loyalty account.")
  REDEMPTION("Redemption"),

  /** Refund of a loyalty award transaction. */
  @Schema(description = "Refund of a loyalty award transaction.")
  AWARD_REFUND("AwardRefund"),

  /** Refund of a loyalty rebate transaction. */
  @Schema(description = "Refund of a loyalty rebate transaction.")
  REBATE_REFUND("RebateRefund"),

  /** Refund of a loyalty redemption transaction. */
  @Schema(description = "Refund of a loyalty redemption transaction.")
  REDEMPTION_REFUND("RedemptionRefund");

  private final String value;

  LoyaltyTransactionType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the LoyaltyTransactionType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a LoyaltyTransactionType from a string value.
   *
   * @param v the string value
   * @return the corresponding LoyaltyTransactionType
   */
  @JsonCreator
  public static LoyaltyTransactionType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}