package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

public enum TotalDetailsType {

  /** Give the totals result per POIID value. */
  POIID("POIID"),

  /** Give the totals result per SaleID value. */
  @Schema(description = "Give the totals result per SaleID value.")
  SALE_ID("SaleID"),

  /** Give the totals result per OperatorID value. */
  @Schema(description = "Give the totals result per OperatorID value.")
  OPERATOR_ID("OperatorID"),

  /** Give the totals result per ShiftNumber value. */
  @Schema(description = "Give the totals result per ShiftNumber value.")
  SHIFT_NUMBER("ShiftNumber"),

  /** Give the totals result per TotalsGroupID value. */
  @Schema(description = "Give the totals result per TotalsGroupID value.")
  TOTALS_GROUP_ID("TotalsGroupID");
  private final String value;

  TotalDetailsType(String v) {
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

  /**
   * Returns the enum constant matching the given string, or {@code null} if no match is found.
   *
   * @param v string value
   * @return the TotalDetailsType, or {@code null} if no match is found.
   */
  @JsonCreator
  public static TotalDetailsType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
