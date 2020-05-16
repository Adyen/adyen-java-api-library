package com.adyen.model.nexo;

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
 *     &lt;enumeration value="OnLinePIN"/&gt;
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
    BYPASS("Bypass"),

    /**
     * Manual verification, for example passport or drivers license.
     */
    @XmlEnumValue("ManualVerification")
    MANUAL_VERIFICATION("ManualVerification"),

    /**
     * Merchant-related authentication.
     */
    @XmlEnumValue("MerchantAuthentication")
    MERCHANT_AUTHENTICATION("MerchantAuthentication"),

    /**
     * Off-line PIN authentication (Personal Identification Number).
     */
    @XmlEnumValue("OfflinePIN")
    OFFLINE_PIN("OfflinePIN"),

    /**
     * On-line PIN authentication (Personal Identification Number).
     */
    @XmlEnumValue("OnLinePIN")
    ON_LINE_PIN("OnLinePIN", "OnlinePIN"),

    /**
     * Handwritten paper signature.
     */
    @XmlEnumValue("PaperSignature")
    PAPER_SIGNATURE("PaperSignature"),

    /**
     * Channel-encrypted transaction.
     */
    @XmlEnumValue("SecuredChannel")
    SECURED_CHANNEL("SecuredChannel"),

    /**
     * Secure electronic transaction with cardholder X.509 certificate.
     */
    @XmlEnumValue("SecureCertificate")
    SECURE_CERTIFICATE("SecureCertificate"),

    /**
     * Secure electronic transaction without cardholder certificate.
     */
    @XmlEnumValue("SecureNoCertificate")
    SECURE_NO_CERTIFICATE("SecureNoCertificate"),

    /**
     * Electronic signature capture (handwritten signature).
     */
    @XmlEnumValue("SignatureCapture")
    SIGNATURE_CAPTURE("SignatureCapture"),

    /**
     * Authentication method is performed unknown.
     */
    @XmlEnumValue("UnknownMethod")
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
