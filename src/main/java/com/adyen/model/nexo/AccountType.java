package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/**
 * Java class for AccountType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="AccountType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Default"/&gt;
 *     &lt;enumeration value="Savings"/&gt;
 *     &lt;enumeration value="Checking"/&gt;
 *     &lt;enumeration value="CreditCard"/&gt;
 *     &lt;enumeration value="Universal"/&gt;
 *     &lt;enumeration value="Investment"/&gt;
 *     &lt;enumeration value="CardTotals"/&gt;
 *     &lt;enumeration value="EpurseCard"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum AccountType {

  /** Default account */
  @SerializedName("Default")
  @Schema(description = "Default account")
  DEFAULT("Default"),

  /** Savings account */
  @SerializedName("Savings")
  @Schema(description = "Savings account")
  SAVINGS("Savings"),

  /** Checking account */
  @SerializedName("Checking")
  @Schema(description = "Checking account")
  CHECKING("Checking"),

  /** Credit card account */
  @SerializedName("CreditCard")
  @Schema(description = "Credit card account")
  CREDIT_CARD("CreditCard"),

  /** Universal account */
  @SerializedName("Universal")
  @Schema(description = "Universal account")
  UNIVERSAL("Universal"),

  /** Investment account */
  @SerializedName("Investment")
  @Schema(description = "Investment account")
  INVESTMENT("Investment"),

  /** Card totals */
  @SerializedName("CardTotals")
  @Schema(description = "Card totals")
  CARD_TOTALS("CardTotals"),

  /** e-Purse card account */
  @SerializedName("EpurseCard")
  @Schema(description = "e-Purse card account")
  EPURSE_CARD("EpurseCard");

  private final String value;

  AccountType(String v) {
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
   * @return the AccountType, or {@code null} if no match is found.
   */
  public static AccountType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
