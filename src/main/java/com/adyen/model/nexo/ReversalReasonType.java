package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/**
 * Java class for ReversalReasonType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="ReversalReasonType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CustCancel"/&gt;
 *     &lt;enumeration value="MerchantCancel"/&gt;
 *     &lt;enumeration value="Malfunction"/&gt;
 *     &lt;enumeration value="Unable2Compl"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum ReversalReasonType {

  /** Customer cancellation */
  @SerializedName("CustCancel")
  @Schema(description = "Customer cancellation")
  CUST_CANCEL("CustCancel"),

  /** Cashier cancellation */
  @SerializedName("MerchantCancel")
  @Schema(description = "Cashier cancellation")
  MERCHANT_CANCEL("MerchantCancel"),

  /** Suspected malfunction */
  @SerializedName("Malfunction")
  @Schema(description = "Suspected malfunction")
  MALFUNCTION("Malfunction"),

  /** Card acceptor device unable to complete transaction */
  @SerializedName("Unable2Compl")
  @Schema(description = "Card acceptor device unable to complete transaction")
  UNABLE_2_COMPL("Unable2Compl");
  private final String value;

  ReversalReasonType(String v) {
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
   * @return the ReversalReasonType, or {@code null} if no match is found.
   */
  public static ReversalReasonType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
