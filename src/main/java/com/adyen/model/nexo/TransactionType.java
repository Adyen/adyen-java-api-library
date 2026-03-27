package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/**
 * Java class for TransactionType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="TransactionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Debit"/&gt;
 *     &lt;enumeration value="Credit"/&gt;
 *     &lt;enumeration value="ReverseDebit"/&gt;
 *     &lt;enumeration value="ReverseCredit"/&gt;
 *     &lt;enumeration value="OneTimeReservation"/&gt;
 *     &lt;enumeration value="CompletedDeffered"/&gt;
 *     &lt;enumeration value="FirstReservation"/&gt;
 *     &lt;enumeration value="UpdateReservation"/&gt;
 *     &lt;enumeration value="CompletedReservation"/&gt;
 *     &lt;enumeration value="CashAdvance"/&gt;
 *     &lt;enumeration value="IssuerInstalment"/&gt;
 *     &lt;enumeration value="Declined"/&gt;
 *     &lt;enumeration value="Failed"/&gt;
 *     &lt;enumeration value="Award"/&gt;
 *     &lt;enumeration value="ReverseAward"/&gt;
 *     &lt;enumeration value="Redemption"/&gt;
 *     &lt;enumeration value="ReverseRedemption"/&gt;
 *     &lt;enumeration value="Rebate"/&gt;
 *     &lt;enumeration value="ReverseRebate"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum TransactionType {

  /** Payment Debit transactions (e.g. if PaymentType is "Normal") */
  @SerializedName("Debit")
  @Schema(description = "Payment Debit transactions (e.g. if PaymentType is \"Normal\")")
  DEBIT("Debit"),

  /** Payment Credit transactions (e.g. if PaymentType is "Refund") */
  @SerializedName("Credit")
  @Schema(description = "Payment Credit transactions (e.g.  if PaymentType is \"Refund\")")
  CREDIT("Credit"),

  /** Payment Reversal Debit transactions */
  @SerializedName("ReverseDebit")
  @Schema(description = "Payment Reversal Debit transactions")
  REVERSE_DEBIT("ReverseDebit"),

  /** Payment Reversal Credit transactions */
  @SerializedName("ReverseCredit")
  @Schema(description = "Payment Reversal Credit transactions")
  REVERSE_CREDIT("ReverseCredit"),

  /** Outstanding OneTimeReservation transactions, i.e. between OneTimeReservation and Completion */
  @SerializedName("OneTimeReservation")
  @Schema(
      description =
          "Outstanding OneTimeReservation transactions, i.e. between OneTimeReservation and Completion")
  ONE_TIME_RESERVATION("OneTimeReservation"),

  /** OneTimeReservation transactions which have been completed by the Completion. */
  @SerializedName("CompletedDeffered")
  @Schema(
      description = "OneTimeReservation transactions which have been completed by the Completion.")
  COMPLETED_DEFFERED("CompletedDeffered"),

  /**
   * Outstanding FirstReservation transactions, i.e. between FirstReservation and UpdateReservation
   * or Completion
   */
  @SerializedName("FirstReservation")
  @Schema(
      description =
          "Outstanding FirstReservation transactions, i.e. between FirstReservation and UpdateReservation  or Completion")
  FIRST_RESERVATION("FirstReservation"),

  /**
   * Outstanding UpdateReservation transactions, i.e. between UpdateReservation and
   * UpdateReservation or Completion
   */
  @SerializedName("UpdateReservation")
  @Schema(
      description =
          "Outstanding UpdateReservation transactions, i.e. between UpdateReservation and UpdateReservation or Completion")
  UPDATE_RESERVATION("UpdateReservation"),

  /** Reservation transactions which have been completed by the Completion. */
  @SerializedName("CompletedReservation")
  @Schema(description = "Reservation transactions which have been completed by the Completion.")
  COMPLETED_RESERVATION("CompletedReservation"),

  /** Cash Advance transactions. */
  @SerializedName("CashAdvance")
  @Schema(description = "Cash Advance transactions.")
  CASH_ADVANCE("CashAdvance"),

  /** Issuer instalment transactions. */
  @SerializedName("IssuerInstalment")
  @Schema(description = "Issuer instalment transactions.")
  ISSUER_INSTALMENT("IssuerInstalment"),

  /** ResultErrorCondition */
  @SerializedName("Declined")
  @Schema(description = "ResultErrorCondition")
  DECLINED("Declined"),

  /** ResultErrorCondition */
  @SerializedName("Failed")
  @Schema(description = "ResultErrorCondition")
  FAILED("Failed"),

  /** Loyalty Award Transaction */
  @SerializedName("Award")
  @Schema(description = "Loyalty Award Transaction")
  AWARD("Award"),

  /** Loyalty Reversal Award Transaction */
  @SerializedName("ReverseAward")
  @Schema(description = "Loyalty Reversal Award Transaction")
  REVERSE_AWARD("ReverseAward"),

  /** Loyalty Redemption Transaction */
  @SerializedName("Redemption")
  @Schema(description = "Loyalty Redemption Transaction")
  REDEMPTION("Redemption"),

  /** Loyalty Reversal Redemption Transaction */
  @SerializedName("ReverseRedemption")
  @Schema(description = "Loyalty Reversal Redemption Transaction")
  REVERSE_REDEMPTION("ReverseRedemption"),

  /** Loyalty Rebate Transaction */
  @SerializedName("Rebate")
  @Schema(description = "Loyalty Rebate Transaction")
  REBATE("Rebate"),

  /** Loyalty Reversal Rebate Transaction */
  @SerializedName("ReverseRebate")
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
  public String value() {
    return value;
  }

  /**
   * Returns the enum constant matching the given string, or {@code null} if no match is found.
   *
   * @param v string value
   * @return the TransactionType, or {@code null} if no match is found.
   */
  public static TransactionType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
