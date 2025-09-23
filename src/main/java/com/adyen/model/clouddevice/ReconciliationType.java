package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of reconciliation. */
public enum ReconciliationType {

  /** Reconciliation with closure of the current period, without any Acquirers synchronisation. */
  @Schema(
      description =
          "Reconciliation with closure of the current period, without any Acquirers synchronisation.")
  SALE_RECONCILIATION("SaleReconciliation"),

  /**
   * Reconciliation and closure of the current period, with synchronisation of the reconciliation
   * between the POI and Acquirers.
   */
  @Schema(
      description =
          "Reconciliation and closure of the current period, with synchronisation of the reconciliation between the POI and Acquirers.")
  ACQUIRER_SYNCHRONISATION("AcquirerSynchronisation"),

  /**
   * Reconciliation between the POI and one or several Acquirers only. There is no reconciliation
   * between the Sale System and the POI System.
   */
  @Schema(
      description =
          "Reconciliation between the POI and one or several Acquirers only. There is no reconciliation between the Sale System and the POI System.")
  ACQUIRER_RECONCILIATION("AcquirerReconciliation"),

  /** Request result of a previous reconciliation. */
  @Schema(description = "Request result of a previous reconciliation.")
  PREVIOUS_RECONCILIATION("PreviousReconciliation");

  private final String value;

  ReconciliationType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the ReconciliationType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a ReconciliationType from a string value.
   *
   * @param v the string value
   * @return the corresponding ReconciliationType
   */
  @JsonCreator
  public static ReconciliationType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}