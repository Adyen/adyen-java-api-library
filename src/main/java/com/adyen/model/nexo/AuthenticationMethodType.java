package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for AuthenticationMethodType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="AuthenticationMethodType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Bypass"/&gt;
 *     &lt;enumeration value="ManualVerification"/&gt;
 *     &lt;enumeration value="MerchantAuthentication"/&gt;
 *     &lt;enumeration value="OfflinePIN"/&gt;
 *     &lt;enumeration value="OnlinePIN"/&gt;
 *     &lt;enumeration value="PaperSignature"/&gt;
 *     &lt;enumeration value="SecuredChannel"/&gt;
 *     &lt;enumeration value="SecureCertificate"/&gt;
 *     &lt;enumeration value="SecureNoCertificate"/&gt;
 *     &lt;enumeration value="SignatureCapture"/&gt;
 *     &lt;enumeration value="UnknownMethod"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "AuthenticationMethodType")
@XmlEnum
public enum AuthenticationMethodType {


    /**
     * Authentication bypassed by the merchant.
     */
    @XmlEnumValue("Bypass")
    @Schema(description = "Authentication bypassed by the merchant.")
    BYPASS("Bypass"),

    /**
     * Manual verification, for example passport or drivers license.
     */
    @XmlEnumValue("ManualVerification")
    @Schema(description = "Manual verification, for example passport or drivers license.")
    MANUAL_VERIFICATION("ManualVerification"),

    /**
     * Merchant-related authentication.
     */
    @XmlEnumValue("MerchantAuthentication")
    @Schema(description = "Merchant-related authentication.")
    MERCHANT_AUTHENTICATION("MerchantAuthentication"),

    /**
     * Off-line PIN authentication (Personal Identification Number).
     */
    @XmlEnumValue("OfflinePIN")
    @Schema(description = "Off-line PIN authentication (Personal Identification Number).")
    OFFLINE_PIN("OfflinePIN"),

    /**
     * On-line PIN authentication (Personal Identification Number).
     */
    @XmlEnumValue("OnlinePIN")
    @Schema(description = "On-line PIN authentication (Personal Identification Number).")
    ON_LINE_PIN("OnLinePIN", "OnlinePIN"),

    /**
     * Handwritten paper signature.
     */
    @XmlEnumValue("PaperSignature")
    @Schema(description = "Handwritten paper signature.")
    PAPER_SIGNATURE("PaperSignature"),

    /**
     * Channel-encrypted transaction.
     */
    @XmlEnumValue("SecuredChannel")
    @Schema(description = "Channel-encrypted transaction.")
    SECURED_CHANNEL("SecuredChannel"),

    /**
     * Secure electronic transaction with cardholder X.509 certificate.
     */
    @XmlEnumValue("SecureCertificate")
    @Schema(description = "Secure electronic transaction with cardholder X.509 certificate.")
    SECURE_CERTIFICATE("SecureCertificate"),

    /**
     * Secure electronic transaction without cardholder certificate.
     */
    @XmlEnumValue("SecureNoCertificate")
    @Schema(description = "Secure electronic transaction without cardholder certificate.")
    SECURE_NO_CERTIFICATE("SecureNoCertificate"),

    /**
     * Electronic signature capture (handwritten signature).
     */
    @XmlEnumValue("SignatureCapture")
    @Schema(description = "Electronic signature capture (handwritten signature).")
    SIGNATURE_CAPTURE("SignatureCapture"),

    /**
     * Authentication method is performed unknown.
     */
    @XmlEnumValue("UnknownMethod")
    @Schema(description = "Authentication method is performed unknown.")
    UNKNOWN_METHOD("UnknownMethod");

    private final String[] value;

    AuthenticationMethodType(String... v) {
        value = v;
    }

    /**
     * Values array.
     *
     * @return the values
     */
    public String[] value() {
        return value;
    }

    /**
     * From value authentication method type.
     *
     * @param v the v
     * @return the authentication method type
     */
    public static AuthenticationMethodType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> Arrays.asList(s.value).contains(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
