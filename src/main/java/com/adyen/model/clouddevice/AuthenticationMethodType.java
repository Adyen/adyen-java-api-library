package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of authentication method. */
public enum AuthenticationMethodType {

  /** Authentication bypassed by the merchant. */
  @Schema(description = "Authentication bypassed by the merchant.")
  BYPASS("Bypass"),

  /** Manual verification, for example passport or drivers license. */
  @Schema(description = "Manual verification, for example passport or drivers license.")
  MANUAL_VERIFICATION("ManualVerification"),

  /** Merchant-related authentication. */
  @Schema(description = "Merchant-related authentication.")
  MERCHANT_AUTHENTICATION("MerchantAuthentication"),

  /** Off-line PIN authentication (Personal Identification Number). */
  @Schema(description = "Off-line PIN authentication (Personal Identification Number).")
  OFFLINE_PIN("OfflinePIN"),

  /** On-line PIN authentication (Personal Identification Number). */
  @Schema(description = "On-line PIN authentication (Personal Identification Number).")
  ON_LINE_PIN("OnLinePIN", "OnlinePIN"),

  /** Handwritten paper signature. */
  @Schema(description = "Handwritten paper signature.")
  PAPER_SIGNATURE("PaperSignature"),

  /** Channel-encrypted transaction. */
  @Schema(description = "Channel-encrypted transaction.")
  SECURED_CHANNEL("SecuredChannel"),

  /** Secure electronic transaction with cardholder X.509 certificate. */
  @Schema(description = "Secure electronic transaction with cardholder X.509 certificate.")
  SECURE_CERTIFICATE("SecureCertificate"),

  /** Secure electronic transaction without cardholder certificate. */
  @Schema(description = "Secure electronic transaction without cardholder certificate.")
  SECURE_NO_CERTIFICATE("SecureNoCertificate"),

  /** Electronic signature capture (handwritten signature). */
  @Schema(description = "Electronic signature capture (handwritten signature).")
  SIGNATURE_CAPTURE("SignatureCapture"),

  /** Authentication method is performed unknown. */
  @Schema(description = "Authentication method is performed unknown.")
  UNKNOWN_METHOD("UnknownMethod");

  private final String[] value;

  AuthenticationMethodType(String... v) {
    value = v;
  }

  /**
   * Returns the string representation of the AuthenticationMethodType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value[0];
  }

  /**
   * Creates an AuthenticationMethodType from a string value.
   *
   * @param v the string value
   * @return the corresponding AuthenticationMethodType
   */
  @JsonCreator
  public static AuthenticationMethodType fromValue(String v) {
    return Arrays.stream(values())
        .filter(s -> Arrays.asList(s.value).contains(v))
        .findFirst()
        .orElse(null);
  }
}
