package com.adyen.httpclient;

import com.adyen.enums.Environment;
import com.adyen.terminal.security.TerminalCommonNameValidator;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import java.security.cert.X509Certificate;

/**
 * A custom HostnameVerifier implementation for verifying SSL connections to
 * Adyen Terminal Local APIs. This verifier ensures the peer certificate's common name (CN)
 * matches expected patterns based on the current Environment.
 * <p>
 * This is typically used to verify secure connections to payment terminals on local networks.
 *
 * <p>It validates the hostname by inspecting the leaf certificate (first in the chain)
 * and checking it against allowed CNs using TerminalCommonNameValidator.
 *
 * @see TerminalCommonNameValidator
 * @see Environment
 */
public final class TerminalLocalAPIHostnameVerifier implements HostnameVerifier {

    /**
     * The Adyen environment (e.g., TEST, LIVE) that determines which hostnames are valid.
     */
    private final Environment environment;

    /**
     * Constructs a new {@code TerminalLocalAPIHostnameVerifier} with the specified environment.
     *
     * @param environment The Adyen environment used for validating terminal hostnames.
     */
    public TerminalLocalAPIHostnameVerifier(Environment environment) {
        this.environment = environment;
    }

    /**
     * Verifies the hostname of an SSL session by inspecting the peer's certificate
     * and validating its common name against expected values for the given environment.
     *
     * @param hostname the hostname to verify.
     * @param session the SSL session associated with the connection.
     * @return {@code true} if the hostname is valid for the given environment; {@code false} otherwise.
     */
    @Override
    public boolean verify(String hostname, SSLSession session) {
        try {
            if (session.getPeerCertificates() != null && session.getPeerCertificates().length > 0) {
                // Assume the first certificate is the leaf, since chain will be ordered.
                X509Certificate certificate = (X509Certificate) session.getPeerCertificates()[0];
                return TerminalCommonNameValidator.validateCertificate(certificate, environment);
            }
            return false;
        } catch (SSLPeerUnverifiedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
