package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of reversal reason. */
public enum ReversalReasonType {

  /** Customer cancellation */
  @Schema(description = "Customer cancellation")
  CUST_CANCEL("CustCancel"),

  /** Cashier cancellation */
  @Schema(description = "Cashier cancellation")
  MERCHANT_CANCEL("MerchantCancel"),

  /** Suspected malfunction */
  @Schema(description = "Suspected malfunction")
  MALFUNCTION("Malfunction"),

  /** Card acceptor device unable to complete transaction */
  @Schema(description = "Card acceptor device unable to complete transaction")
  UNABLE_2_COMPL("Unable2Compl");

  private final String value;

  ReversalReasonType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the ReversalReasonType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a ReversalReasonType from a string value.
   *
   * @param v the string value
   * @return the corresponding ReversalReasonType
   */
  @JsonCreator
  public static ReversalReasonType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
