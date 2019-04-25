
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthenticationMethodEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AuthenticationMethodEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Bypass"/>
 *     &lt;enumeration value="ManualVerification"/>
 *     &lt;enumeration value="MerchantAuthentication"/>
 *     &lt;enumeration value="OfflinePIN"/>
 *     &lt;enumeration value="OnLinePIN"/>
 *     &lt;enumeration value="PaperSignature"/>
 *     &lt;enumeration value="SecuredChannel"/>
 *     &lt;enumeration value="SecureCertificate"/>
 *     &lt;enumeration value="SecureNoCertificate"/>
 *     &lt;enumeration value="SignatureCapture"/>
 *     &lt;enumeration value="UnknownMethod"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AuthenticationMethodEnumeration")
@XmlEnum
public enum AuthenticationMethodEnumeration {


    /**
     * Authentication bypassed by the merchant.
     * 
     */
    @XmlEnumValue("Bypass")
    BYPASS("Bypass"),

    /**
     * Manual verification, for example passport or drivers license.
     * 
     */
    @XmlEnumValue("ManualVerification")
    MANUAL_VERIFICATION("ManualVerification"),

    /**
     * Merchant-related authentication.
     * 
     */
    @XmlEnumValue("MerchantAuthentication")
    MERCHANT_AUTHENTICATION("MerchantAuthentication"),

    /**
     * Off-line PIN authentication (Personal Identification Number).
     * 
     */
    @XmlEnumValue("OfflinePIN")
    OFFLINE_PIN("OfflinePIN"),

    /**
     * On-line PIN authentication (Personal Identification Number).
     * 
     */
    @XmlEnumValue("OnLinePIN")
    ON_LINE_PIN("OnLinePIN"),

    /**
     * Handwritten paper signature.
     * 
     */
    @XmlEnumValue("PaperSignature")
    PAPER_SIGNATURE("PaperSignature"),

    /**
     * Channel-encrypted transaction.
     * 
     */
    @XmlEnumValue("SecuredChannel")
    SECURED_CHANNEL("SecuredChannel"),

    /**
     * Secure electronic transaction with cardholder X.509 certificate.
     * 
     */
    @XmlEnumValue("SecureCertificate")
    SECURE_CERTIFICATE("SecureCertificate"),

    /**
     * Secure electronic transaction without cardholder certificate.
     * 
     */
    @XmlEnumValue("SecureNoCertificate")
    SECURE_NO_CERTIFICATE("SecureNoCertificate"),

    /**
     * Electronic signature capture (handwritten signature).
     * 
     */
    @XmlEnumValue("SignatureCapture")
    SIGNATURE_CAPTURE("SignatureCapture"),

    /**
     * Authentication method is performed unknown.
     * 
     */
    @XmlEnumValue("UnknownMethod")
    UNKNOWN_METHOD("UnknownMethod");
    private final String value;

    AuthenticationMethodEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AuthenticationMethodEnumeration fromValue(String v) {
        for (AuthenticationMethodEnumeration c: AuthenticationMethodEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
