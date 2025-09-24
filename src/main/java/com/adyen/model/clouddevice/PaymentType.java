package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of payment. */
public enum PaymentType {

  /** Normal Payment */
  @Schema(description = "Normal Payment")
  NORMAL("Normal"),

  /** Payment refund */
  @Schema(description = "Payment refund")
  REFUND("Refund"),

  /**
   * One time reservation to be just followed by a completion when the service or good is delivered.
   * This service is sometimes called "Deferred Sale".
   */
  @Schema(
      description =
          "One time reservation to be just followed by a completion when the service or good is delivered. This service is sometimes called \"Deferred Sale\".")
  ONE_TIME_RESERVATION("OneTimeReservation"),

  /**
   * First reservation for an amount and period of time. This service is sometimes called
   * "Pre-Authorisation".
   */
  @Schema(
      description =
          "First reservation for an amount and period of time. This service is sometimes called \"Pre-Authorisation\".")
  FIRST_RESERVATION("FirstReservation"),

  /** Adjustment of the amount or period of time of a reservation. */
  @Schema(description = "Adjustment of the amount or period of time of a reservation. ")
  UPDATE_RESERVATION("UpdateReservation"),

  /** End of the reservation transaction. */
  @Schema(description = "End of the reservation transaction.")
  COMPLETION("Completion"),

  /** Cash advance at the POI System. */
  @Schema(description = "Cash advance at the POI System.")
  CASH_ADVANCE("CashAdvance"),

  /** Cash deposit at the POI System, to credit an account. */
  @Schema(description = "Cash deposit at the POI System, to credit an account.")
  CASH_DEPOSIT("CashDeposit"),

  /** Recurring payment. */
  @Schema(description = "Recurring payment.")
  RECURRING("Recurring"),

  /** Instalments of payment performed on behalf of the merchant. */
  @Schema(description = "Instalments of payment performed on behalf of the merchant.")
  INSTALMENT("Instalment"),

  /** Instalments of payment performed by the card issuer. */
  @Schema(description = "Instalments of payment performed by the card issuer.")
  ISSUER_INSTALMENT("IssuerInstalment"),

  /** Give money to in return for goods or services rendered to the merchant. */
  @Schema(description = "Give money to in return for goods or services rendered to the merchant.")
  PAID_OUT("PaidOut");

  private final String value;

  PaymentType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the PaymentType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a PaymentType from a string value.
   *
   * @param v the string value
   * @return the corresponding PaymentType
   */
  @JsonCreator
  public static PaymentType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
