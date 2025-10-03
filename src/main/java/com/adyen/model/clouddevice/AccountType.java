package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Account type. */
public enum AccountType {

  /** Default account */
  @Schema(description = "Default account")
  DEFAULT("Default"),

  /** Savings account */
  @Schema(description = "Savings account")
  SAVINGS("Savings"),

  /** Checking account */
  @Schema(description = "Checking account")
  CHECKING("Checking"),

  /** Credit card account */
  @Schema(description = "Credit card account")
  CREDIT_CARD("CreditCard"),

  /** Universal account */
  @Schema(description = "Universal account")
  UNIVERSAL("Universal"),

  /** Investment account */
  @Schema(description = "Investment account")
  INVESTMENT("Investment"),

  /** Card totals */
  @Schema(description = "Card totals")
  CARD_TOTALS("CardTotals"),

  /** e-Purse card account */
  @Schema(description = "e-Purse card account")
  EPURSE_CARD("EpurseCard");

  private final String value;

  AccountType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the AccountType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates an AccountType from a string value.
   *
   * @param v the string value
   * @return the corresponding AccountType
   */
  @JsonCreator
  public static AccountType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
