package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/**
 * Java class for ReconciliationType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="ReconciliationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SaleReconciliation"/&gt;
 *     &lt;enumeration value="AcquirerSynchronisation"/&gt;
 *     &lt;enumeration value="AcquirerReconciliation"/&gt;
 *     &lt;enumeration value="PreviousReconciliation"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum ReconciliationType {

  /** Reconciliation with closure of the current period, without any Acquirers synchronisation. */
  @SerializedName("SaleReconciliation")
  @Schema(
      description =
          "Reconciliation with closure of the current period, without any Acquirers synchronisation.")
  SALE_RECONCILIATION("SaleReconciliation"),

  /**
   * Reconciliation and closure of the current period, with synchronisation of the reconciliation
   * between the POI and Acquirers.
   */
  @SerializedName("AcquirerSynchronisation")
  @Schema(
      description =
          "Reconciliation and closure of the current period, with synchronisation of the reconciliation between the POI and Acquirers.")
  ACQUIRER_SYNCHRONISATION("AcquirerSynchronisation"),

  /**
   * Reconciliation between the POI and one or several Acquirers only. There is no reconciliation
   * between the Sale System and the POI System.
   */
  @SerializedName("AcquirerReconciliation")
  @Schema(
      description =
          "Reconciliation between the POI and one or several Acquirers only. There is no reconciliation between the Sale System and the POI System.")
  ACQUIRER_RECONCILIATION("AcquirerReconciliation"),

  /** Request result of a previous reconciliation. */
  @SerializedName("PreviousReconciliation")
  @Schema(description = "Request result of a previous reconciliation.")
  PREVIOUS_RECONCILIATION("PreviousReconciliation");
  private final String value;

  ReconciliationType(String v) {
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

  public static ReconciliationType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
