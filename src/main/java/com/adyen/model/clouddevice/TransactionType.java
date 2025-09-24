package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

public enum TransactionType {

  /** Payment Debit transactions (e.g. if PaymentType is "Normal") */
  @Schema(description = "Payment Debit transactions (e.g. if PaymentType is \"Normal\")")
  DEBIT("Debit"),

  /** Payment Credit transactions (e.g. if PaymentType is "Refund") */
  @Schema(description = "Payment Credit transactions (e.g.  if PaymentType is \"Refund\")")
  CREDIT("Credit"),

  /** Payment Reversal Debit transactions */
  @Schema(description = "Payment Reversal Debit transactions")
  REVERSE_DEBIT("ReverseDebit"),

  /** Payment Reversal Credit transactions */
  @Schema(description = "Payment Reversal Credit transactions")
  REVERSE_CREDIT("ReverseCredit"),

  /** Outstanding OneTimeReservation transactions, i.e. between OneTimeReservation and Completion */
  @Schema(
      description =
          "Outstanding OneTimeReservation transactions, i.e. between OneTimeReservation and Completion")
  ONE_TIME_RESERVATION("OneTimeReservation"),

  /** OneTimeReservation transactions which have been completed by the Completion. */
  @Schema(
      description = "OneTimeReservation transactions which have been completed by the Completion.")
  COMPLETED_DEFFERED("CompletedDeffered"),

  /**
   * Outstanding FirstReservation transactions, i.e. between FirstReservation and UpdateReservation
   * or Completion
   */
  @Schema(
      description =
          "Outstanding FirstReservation transactions, i.e. between FirstReservation and UpdateReservation  or Completion")
  FIRST_RESERVATION("FirstReservation"),

  /**
   * Outstanding UpdateReservation transactions, i.e. between UpdateReservation and
   * UpdateReservation or Completion
   */
  @Schema(
      description =
          "Outstanding UpdateReservation transactions, i.e. between UpdateReservation and UpdateReservation or Completion")
  UPDATE_RESERVATION("UpdateReservation"),

  /** Reservation transactions which have been completed by the Completion. */
  @Schema(description = "Reservation transactions which have been completed by the Completion.")
  COMPLETED_RESERVATION("CompletedReservation"),

  /** Cash Advance transactions. */
  @Schema(description = "Cash Advance transactions.")
  CASH_ADVANCE("CashAdvance"),

  /** Issuer instalment transactions. */
  @Schema(description = "Issuer instalment transactions.")
  ISSUER_INSTALMENT("IssuerInstalment"),

  /** ResultErrorCondition */
  @Schema(description = "ResultErrorCondition")
  DECLINED("Declined"),

  /** ResultErrorCondition */
  @Schema(description = "ResultErrorCondition")
  FAILED("Failed"),

  /** Loyalty Award Transaction */
  @Schema(description = "Loyalty Award Transaction")
  AWARD("Award"),

  /** Loyalty Reversal Award Transaction */
  @Schema(description = "Loyalty Reversal Award Transaction")
  REVERSE_AWARD("ReverseAward"),

  /** Loyalty Redemption Transaction */
  @Schema(description = "Loyalty Redemption Transaction")
  REDEMPTION("Redemption"),

  /** Loyalty Reversal Redemption Transaction */
  @Schema(description = "Loyalty Reversal Redemption Transaction")
  REVERSE_REDEMPTION("ReverseRedemption"),

  /** Loyalty Rebate Transaction */
  @Schema(description = "Loyalty Rebate Transaction")
  REBATE("Rebate"),

  /** Loyalty Reversal Rebate Transaction */
  @Schema(description = "Loyalty Reversal Rebate Transaction")
  REVERSE_REBATE("ReverseRebate");
  private final String value;

  TransactionType(String v) {
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
   * @return the TransactionType, or {@code null} if no match is found.
   */
  @JsonCreator
  public static TransactionType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
